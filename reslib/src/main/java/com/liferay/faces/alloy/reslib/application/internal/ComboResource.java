/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.reslib.application.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.ContentTypes;
import com.liferay.faces.util.application.ResourceUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Neil Griffin
 */
public class ComboResource extends Resource {

	// Public Constants
	public static final String RESOURCE_NAME = "combo";
	public static final String DUMMY_RESOURCE_NAME = "combo-resource.txt";

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(ComboResource.class);

	// Private Constants
	private static final String RESOURCE_PATH_BASE = "META-INF/resources/liferay-faces-alloy-reslib/";

	// Private Data Members
	private List<String> modulePaths;
	private String requestPath;

	public ComboResource(List<String> modulePaths) {

		this.modulePaths = modulePaths;
		setLibraryName(ResLibResourceHandler.LIBRARY_NAME);
		setResourceName(RESOURCE_NAME);
	}

	@Override
	public boolean userAgentNeedsUpdate(FacesContext facesContext) {
		return true;
	}

	@Override
	public String getContentType() {

		String contentType = ContentTypes.TEXT_PLAIN;

		if ((modulePaths != null) && (modulePaths.size() > 0)) {
			String firstModulePath = modulePaths.get(0);

			if (firstModulePath.endsWith(".css")) {
				contentType = ContentTypes.TEXT_CSS;
			}
			else if (firstModulePath.endsWith(".js")) {
				contentType = ContentTypes.TEXT_JAVASCRIPT;
			}
		}

		return contentType;
	}

	@Override
	public InputStream getInputStream() throws IOException {

		StringBuilder comboResourceText = new StringBuilder();
		String contentType = getContentType();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceHandler resourceHandlerChain = facesContext.getApplication().getResourceHandler();
		ExternalContext externalContext = facesContext.getExternalContext();

		for (String modulePath : modulePaths) {

			String resourcePath = RESOURCE_PATH_BASE + modulePath;
			URL resourceURL = ComboResource.class.getClassLoader().getResource(resourcePath);

			logger.debug("resourcePath=[{0}] resourceURL=[{1}]", resourcePath, resourceURL);

			InputStream inputStream = resourceURL.openStream();
			String resourceText = ResourceUtil.toString(inputStream, "UTF-8");

			if (ContentTypes.TEXT_CSS.equals(contentType)) {
				resourceText = ExpressionUtil.filterExpressions(resourceText, resourceHandlerChain, externalContext);
			}

			comboResourceText.append(resourceText);
		}

		return ResourceUtil.toInputStream(comboResourceText.toString(), "UTF-8");
	}

	@Override
	public String getRequestPath() {

		if (requestPath == null) {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			ResourceHandler resourceHandlerChain = facesContext.getApplication().getResourceHandler();
			Resource dummyResource = resourceHandlerChain.createResource(DUMMY_RESOURCE_NAME, getLibraryName());
			String dummyResourceRequestPath = dummyResource.getRequestPath();
			requestPath = dummyResourceRequestPath.replace(DUMMY_RESOURCE_NAME, RESOURCE_NAME);
		}

		return requestPath;
	}

	@Override
	public Map<String, String> getResponseHeaders() {
		return Collections.EMPTY_MAP;
	}

	@Override
	public URL getURL() {
		return null;
	}
}
