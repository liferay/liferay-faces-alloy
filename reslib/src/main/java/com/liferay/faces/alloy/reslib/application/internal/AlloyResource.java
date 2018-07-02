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
package com.liferay.faces.alloy.reslib.application.internal;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;


/**
 * @author  Kyle Stiemann
 */
public abstract class AlloyResource extends Resource {

	// Private Members
	private String requestPath;

	public AlloyResource(String resourceName) {
		setLibraryName(ResLibResourceHandler.LIBRARY_NAME);
		setResourceName(resourceName);
	}

	@Override
	public String getRequestPath() {

		if (requestPath == null) {

			// In order to determine the request path, create a dummy resource that corresponds to an existing text file
			// in the classpath. This provides the ability to ask the JSF runtime for a request path that corresponds to
			// the existing file.
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ResourceHandler resourceHandlerChain = facesContext.getApplication().getResourceHandler();
			Resource dummyResource = resourceHandlerChain.createResource("dummy-resource.txt", getLibraryName());
			String dummyResourceRequestPath = dummyResource.getRequestPath();

			// Replace the dummy resource's name in the request path with the actual resource name.
			requestPath = dummyResourceRequestPath.replace("dummy-resource.txt", getResourceName());
		}

		return requestPath;
	}
}
