/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.alloy.taghandler;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

import com.liferay.faces.alloy.config.internal.AlloyWebConfigParam;
import com.liferay.faces.util.cache.Cache;
import com.liferay.faces.util.cache.CacheFactory;
import com.liferay.faces.util.config.WebConfigParam;
import com.liferay.faces.util.jsp.JspTagConfig;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Neil Griffin
 * @author  Kyle Stiemann
 */
public class LoadConstants extends TagHandler {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(LoadConstants.class);

	// Static field must be declared volatile in order for the double-check idiom to work (requires JRE 1.5+)
	private static volatile Cache<String, Map<String, Object>> constantCache;

	// Protected Enumerations
	protected enum PropertyKeys {
		cacheable, classType, var
	}

	// Private Data Members
	private boolean cacheable = true;
	private String classType;
	private String var;

	// Workaround for https://issues.liferay.com/browse/FACES-1576
	public LoadConstants() throws Exception {
		super(new JspTagConfig());
	}

	public LoadConstants(TagConfig config) throws Exception {

		super(config);

		TagAttribute typeAttr = getAttribute(PropertyKeys.classType.toString());

		if (typeAttr == null) {
			throw new NullPointerException("classType is required.");
		}

		this.classType = typeAttr.getValue();

		TagAttribute varAttr = getAttribute(PropertyKeys.var.toString());

		if (varAttr == null) {
			throw new NullPointerException("var is required.");
		}

		this.var = varAttr.getValue();

		TagAttribute cacheableAttr = getAttribute(PropertyKeys.cacheable.toString());

		if (cacheableAttr != null) {
			this.cacheable = Boolean.parseBoolean(cacheableAttr.getValue());
		}
	}

	@Override
	public void apply(FaceletContext faceletContext, UIComponent parentUIComponent) throws IOException {

		Cache<String, Map<String, Object>> constantCache = LoadConstants.constantCache;

		// First check without locking (not yet thread-safe)
		if (cacheable && (constantCache == null)) {

			synchronized (LoadConstants.class) {

				constantCache = LoadConstants.constantCache;

				// Second check with locking (thread-safe)
				if (constantCache == null) {

					FacesContext facesContext = faceletContext.getFacesContext();
					ExternalContext externalContext = facesContext.getExternalContext();
					AlloyWebConfigParam AlloyLoadConstantsMaxCacheCapacity =
						AlloyWebConfigParam.AlloyLoadConstantsMaxCacheCapacity;
					int maxCacheCapacity = AlloyLoadConstantsMaxCacheCapacity.getIntegerValue(externalContext);

					if (maxCacheCapacity != AlloyLoadConstantsMaxCacheCapacity.getDefaultIntegerValue()) {

						int initialCacheCapacity = WebConfigParam.DefaultInitialCacheCapacity.getIntegerValue(
								externalContext);
						constantCache = LoadConstants.constantCache = CacheFactory.getConcurrentLRUCacheInstance(
									externalContext, initialCacheCapacity, maxCacheCapacity);
					}
					else {
						constantCache = LoadConstants.constantCache = CacheFactory.getConcurrentCacheInstance(
									externalContext);
					}
				}
			}
		}

		if (cacheable && constantCache.containsKey(classType)) {
			faceletContext.setAttribute(var, constantCache.getValue(classType));
		}
		else {

			Map<String, Object> constantMap = new HashMap<String, Object>();

			try {

				Class<?> clazz = Class.forName(classType);
				Field[] fields = clazz.getFields();

				for (Field field : fields) {

					int modifiers = field.getModifiers();

					if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {

						String fieldName = field.getName();

						if (!Modifier.isFinal(modifiers)) {
							logger.warn(
								"Loading non-final field: {0}. alloy:loadConstants is designed to load \"public static final\" fields. The behavior of alloy:loadConstants is undefined when loading non-final fields.",
								fieldName);
						}

						constantMap.put(fieldName, field.get(null));
					}
				}

				constantMap = Collections.unmodifiableMap(constantMap);

				if (cacheable) {
					constantMap = constantCache.putValueIfAbsent(classType, constantMap);
				}

				faceletContext.setAttribute(var, constantMap);
			}
			catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("Referenced class cannot be found.", e);
			}
			catch (IllegalAccessException e) {
				logger.error(e);
			}
		}
	}
}
