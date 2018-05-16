/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
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
import com.liferay.faces.util.jsp.JspTagConfig;
import com.liferay.faces.util.lang.ThreadSafeAccessor;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Neil Griffin
 * @author  Kyle Stiemann
 */
public class LoadConstants extends TagHandler {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(LoadConstants.class);

	// Protected Enumerations
	protected enum PropertyKeys {
		cacheable, classType, var
	}

	// Private Final Data Members
	private final String classType;
	private final ConstantCacheAccessor constantCacheAccessor;
	private final String var;

	// Workaround for https://issues.liferay.com/browse/FACES-1576
	public LoadConstants() throws Exception {

		super(new JspTagConfig());
		this.classType = null;
		this.constantCacheAccessor = null;
		this.var = null;
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

		if ((cacheableAttr == null) || Boolean.parseBoolean(cacheableAttr.getValue())) {
			this.constantCacheAccessor = new ConstantCacheAccessor();
		}
		else {
			this.constantCacheAccessor = null;
		}
	}

	@Override
	public void apply(FaceletContext faceletContext, UIComponent parentUIComponent) throws IOException {

		Cache<String, Map<String, Object>> constantCache = null;

		if (constantCacheAccessor != null) {
			constantCache = constantCacheAccessor.get(faceletContext);
		}

		if ((constantCache != null) && constantCache.containsKey(classType)) {
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

				if ((constantCache != null)) {
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

	/**
	 * This class provides lazy access to the constant cache that is set up by {@link
	 * com.liferay.faces.alloy.event.internal.ApplicationConfigConstructedListener}.
	 */
	private static final class ConstantCacheAccessor
		extends ThreadSafeAccessor<Cache<String, Map<String, Object>>, FaceletContext> {

		@Override
		protected Cache<String, Map<String, Object>> computeValue(FaceletContext faceletContext) {

			FacesContext facesContext = faceletContext.getFacesContext();
			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, Object> applicationMap = externalContext.getApplicationMap();
			Cache<String, Map<String, Object>> constantCache = (Cache<String, Map<String, Object>>) applicationMap.get(
					LoadConstants.class.getName());

			return constantCache;
		}
	}
}
