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

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.application.FilteredResourceBase;


/**
 * @author  Neil Griffin
 */
public class FilteredResourceExpressionImpl extends FilteredResourceBase {

	// Private Constants
	private static final String COMBO_MODULE_PATHS_DELIMITER = "#{comboModulePathsDelimiter}";
	private static final String SCRIPT_MODULE_PATHS_DELIMITER = "#{scriptModulePathsDelimiter}";

	// Private Members
	private Resource wrappedResource;

	public FilteredResourceExpressionImpl(Resource wrappedResource) {
		this.wrappedResource = wrappedResource;
	}

	@Override
	public Resource getWrapped() {
		return wrappedResource;
	}

	@Override
	protected String filter(String text) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceHandler resourceHandlerChain = facesContext.getApplication().getResourceHandler();
		ExternalContext externalContext = facesContext.getExternalContext();
		String comboModulePathsDelimiter = getModulePathsDelimiter("combo", resourceHandlerChain, externalContext);
		String scriptModulePathsDelimiter = getModulePathsDelimiter("script", resourceHandlerChain, externalContext);
		text = text.replace(COMBO_MODULE_PATHS_DELIMITER, comboModulePathsDelimiter);
		text = text.replace(SCRIPT_MODULE_PATHS_DELIMITER, scriptModulePathsDelimiter);

		return ExpressionUtil.filterResourceExpressions(text, resourceHandlerChain, externalContext);
	}

	private String getModulePathsDelimiter(String resourceName, ResourceHandler resourceHandlerChain,
		ExternalContext externalContext) {

		String modulePathsDelimiter = "&";
		Resource resource = resourceHandlerChain.createResource(resourceName, ResLibResourceHandler.LIBRARY_NAME);

		if (resource != null) {

			String requestPath = resource.getRequestPath();

			if (requestPath != null) {

				String resourceURL = externalContext.encodeResourceURL(requestPath);

				if (!resourceURL.contains("?")) {
					modulePathsDelimiter = "?";
				}
			}
		}

		return modulePathsDelimiter;
	}
}
