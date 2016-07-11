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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;


/**
 * @author  Kyle Stiemann
 */
public class ReslibResource extends Resource {

	// Private Constants
	private final String DUMMY_RESOURCE_NAME;
	private final String RESOURCE_NAME;

	// Private Members
	private String requestPath;

	public ReslibResource(String dummyResourceName, String resourceName) {

		this.DUMMY_RESOURCE_NAME = dummyResourceName;
		this.RESOURCE_NAME = resourceName;
		setLibraryName(ResLibResourceHandler.LIBRARY_NAME);
		setResourceName(RESOURCE_NAME);
		setContentType("text/plain");
	}

	@Override
	public InputStream getInputStream() throws IOException {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public URL getURL() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean userAgentNeedsUpdate(FacesContext fc) {
		throw new UnsupportedOperationException();
	}
}
