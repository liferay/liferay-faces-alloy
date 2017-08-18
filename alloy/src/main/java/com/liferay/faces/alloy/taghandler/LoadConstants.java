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

import com.liferay.faces.util.cache.Cache;
import com.liferay.faces.util.cache.CacheFactory;
import com.liferay.faces.util.factory.FactoryExtensionFinder;
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
	public void apply(FaceletContext facletContext, UIComponent parentUIComponent) throws IOException {

		Cache<String, Map<String, Object>> constantCache = LoadConstants.constantCache;

		// First check without locking (not yet thread-safe)
		if (constantCache == null) {

			// Second check with locking (thread-safe)
			synchronized (LoadConstants.class) {

				constantCache = LoadConstants.constantCache;

				if (constantCache == null) {

					FacesContext facesContext = facletContext.getFacesContext();
					ExternalContext externalContext = facesContext.getExternalContext();
					String maxCacheCapacityString = externalContext.getInitParameter(LoadConstants.class.getName() +
							".maxCacheCapacity");

					if (maxCacheCapacityString != null) {

						CacheFactory cacheFactory = (CacheFactory) FactoryExtensionFinder.getFactory(externalContext,
								CacheFactory.class);
						int initialCacheCapacity = cacheFactory.getDefaultInitialCapacity();
						int maxCacheCapacity = Integer.parseInt(maxCacheCapacityString);
						constantCache = LoadConstants.constantCache = cacheFactory.getConcurrentCache(
									initialCacheCapacity, maxCacheCapacity);
					}
					else {
						constantCache = LoadConstants.constantCache = CacheFactory.getConcurrentCacheInstance(
									externalContext);
					}
				}
			}
		}

		if (cacheable && constantCache.containsKey(classType)) {
			facletContext.setAttribute(var, constantCache.get(classType));
		}
		else {

			Map<String, Object> constantMap = new HashMap<String, Object>();

			try {

				Class<?> clazz = Class.forName(classType);
				Field[] fields = clazz.getFields();

				for (Field field : fields) {

					int modifiers = field.getModifiers();

					if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
						constantMap.put(field.getName(), field.get(null));
					}
				}

				constantMap = Collections.unmodifiableMap(constantMap);

				if (cacheable) {
					constantMap = constantCache.putIfAbsent(classType, constantMap);
				}

				facletContext.setAttribute(var, constantMap);
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
