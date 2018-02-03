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
package com.liferay.faces.alloy.component.media.internal;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.liferay.faces.alloy.component.media.Media;
import com.liferay.faces.alloy.util.internal.JSFUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * This class provides a compatibility layer that isolates differences between 2.2 and earlier.
 *
 * @author  Neil Griffin
 */
public class MediaRendererCompat extends MediaRendererBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(MediaRendererCompat.class);

	protected void encodeJSF22PassthroughAttributes(FacesContext facesContext, Media media,
		ResponseWriter responseWriter) throws IOException {

		Method getPassThroughAttributesMethod = null;

		try {
			getPassThroughAttributesMethod = media.getClass().getMethod("getPassThroughAttributes", new Class[] {});
		}
		catch (NoSuchMethodException e) {

			if (JSFUtil.isFaces_2_2_OrNewer(facesContext)) {
				logger.error(e);
			}
		}

		if (getPassThroughAttributesMethod != null) {

			try {
				Map<String, Object> passThroughAttributesMap = (Map<String, Object>)
					getPassThroughAttributesMethod.invoke(media, new Object[] {});
				Set<String> passThroughAttributes = passThroughAttributesMap.keySet();

				for (String passThroughAttribute : passThroughAttributes) {
					Object passThroughAttributeValue = passThroughAttributesMap.get(passThroughAttribute);
					responseWriter.writeAttribute(passThroughAttribute, passThroughAttributeValue,
						passThroughAttribute);
				}
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
	}

	protected boolean isEncodedResourceURL(FacesContext facesContext, ResourceHandler resourceHandler, String value) {

		boolean facesResourceURL = false;
		Method isResourceURLMethod = null;

		try {
			isResourceURLMethod = resourceHandler.getClass().getMethod("isResourceURL", new Class[] { String.class });
		}
		catch (NoSuchMethodException e) {

			if (JSFUtil.isFaces_2_2_OrNewer(facesContext)) {
				logger.error(e);
			}
		}

		if (isResourceURLMethod == null) {
			facesResourceURL = ((value != null) && value.contains("javax.faces.resource"));
		}
		else {

			try {
				facesResourceURL = (Boolean) isResourceURLMethod.invoke(resourceHandler, new Object[] { value });
			}
			catch (Exception e) {
				logger.error(e);
			}
		}

		return facesResourceURL;
	}
}
