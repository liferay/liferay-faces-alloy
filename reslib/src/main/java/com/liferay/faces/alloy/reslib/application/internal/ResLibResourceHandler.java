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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.faces.alloy.reslib.config.ResLibConfigParam;
import com.liferay.faces.util.config.ApplicationConfig;
import com.liferay.faces.util.config.ConfiguredServletMapping;
import com.liferay.faces.util.config.FacesConfig;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;


/**
 * This is a resource handler that is only necessary in a non-Liferay (webapp) environment. The purpose of this class is
 * to provide Alloy/YUI/Bootstrap resources.
 *
 * @author  Neil Griffin
 */
public class ResLibResourceHandler extends ResourceHandlerWrapper {

	// Public Constants
	public static final String LIBRARY_NAME = "liferay-faces-alloy-reslib";

	// Private Constants
	private static final String LIFERAY_JS = "liferay.js";
	private static final boolean LIFERAY_PORTAL_DETECTED = ProductFactory.getProduct(Product.Name.LIFERAY_PORTAL)
		.isDetected();

	// Private Members
	private ResourceHandler wrappedResourceHandler;

	public ResLibResourceHandler(ResourceHandler wrappedResourceHandler) {
		this.wrappedResourceHandler = wrappedResourceHandler;
	}

	@Override
	public Resource createResource(String resourceName) {

		Resource resource;

		if (!LIFERAY_PORTAL_DETECTED) {

			if (ComboResource.RESOURCE_NAME.equals(resourceName)) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ExternalContext externalContext = facesContext.getExternalContext();
				List<String> modulePaths = getModulePaths(externalContext);
				resource = new ComboResource(modulePaths);
			}
			else if (ScriptResource.RESOURCE_NAME.equals(resourceName)) {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ExternalContext externalContext = facesContext.getExternalContext();
				List<String> modulePaths = getModulePaths(externalContext);
				String scriptModulePath = "";

				if (modulePaths.size() > 0) {
					scriptModulePath = modulePaths.get(0);
				}

				resource = new ScriptResource(scriptModulePath);
			}
			else {

				resource = super.createResource(resourceName);

				if (LIFERAY_JS.equals(resourceName)) {
					resource = new FilteredResourceExpressionImpl(resource);
				}
			}
		}
		else {
			resource = super.createResource(resourceName);
		}

		return resource;
	}

	@Override
	public Resource createResource(String resourceName, String libraryName) {

		Resource resource;

		if (!LIFERAY_PORTAL_DETECTED && LIBRARY_NAME.equals(libraryName)) {

			if (ComboResource.RESOURCE_NAME.equals(resourceName) || ScriptResource.RESOURCE_NAME.equals(resourceName)) {
				resource = createResource(resourceName);
			}
			else {

				resource = super.createResource(resourceName, libraryName);

				if (LIFERAY_JS.equals(resourceName)) {
					resource = new FilteredResourceExpressionImpl(resource);
				}
			}
		}
		else {
			resource = super.createResource(resourceName, libraryName);
		}

		return resource;
	}

	@Override
	public Resource createResource(String resourceName, String libraryName, String contentType) {

		Resource resource;

		if (!LIFERAY_PORTAL_DETECTED && LIBRARY_NAME.equals(libraryName)) {

			if (ComboResource.RESOURCE_NAME.equals(resourceName) || ScriptResource.RESOURCE_NAME.equals(resourceName)) {
				resource = createResource(resourceName);
			}
			else {

				resource = super.createResource(resourceName, libraryName, contentType);

				if (LIFERAY_JS.equals(resourceName)) {
					resource = new FilteredResourceExpressionImpl(resource);
				}
			}
		}
		else {
			resource = super.createResource(resourceName, libraryName, contentType);
		}

		return resource;
	}

	@Override
	public ResourceHandler getWrapped() {
		return wrappedResourceHandler;
	}

	@Override
	public void handleResourceRequest(FacesContext facesContext) throws IOException {

		if (LIFERAY_PORTAL_DETECTED) {
			super.handleResourceRequest(facesContext);
		}
		else {

			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, String> requestParameterMap = externalContext.getRequestParameterMap();
			String libraryName = requestParameterMap.get("ln");
			String resourceName = getResourceName(externalContext);

			// If the resource that is to be rendered is a combo or script module resource and the module paths
			// extensions are invalid, then the resource cannot be found.
			if (LIBRARY_NAME.equals(libraryName) &&
					(ComboResource.RESOURCE_NAME.equals(resourceName) ||
						ScriptResource.RESOURCE_NAME.equals(resourceName)) &&
					!areModulePathsExtensionsValid(externalContext)) {

				externalContext.setResponseHeader("Cache-Control", "private, no-cache, no-store, must-revalidate");
				externalContext.setResponseStatus(HttpServletResponse.SC_NOT_FOUND);
			}

			// Otherwise, pass responsibility for handling the resource to the resource-handler delegation chain.
			else {
				super.handleResourceRequest(facesContext);
			}
		}
	}

	@Override
	public boolean libraryExists(String libraryName) {

		if (!LIFERAY_PORTAL_DETECTED && LIBRARY_NAME.equals(libraryName)) {
			return true;
		}
		else {
			return super.libraryExists(libraryName);
		}
	}

	protected boolean areModulePathsExtensionsValid(ExternalContext externalContext) {

		List<String> modulePaths = getModulePaths(externalContext);
		boolean modulePathsExtensionsValid = false;

		if (modulePaths.size() > 0) {

			String[] comboAllowedFileExtensions = ResLibConfigParam.ComboAllowedFileExtensions.getStringValue(
					externalContext).split(",");
			modulePathsExtensionsValid = true;

			for (String modulePath : modulePaths) {

				boolean validFileExtension = false;

				for (String comboAllowedFileExtension : comboAllowedFileExtensions) {

					if (modulePath.endsWith(comboAllowedFileExtension)) {

						validFileExtension = true;

						break;
					}
				}

				if (!validFileExtension) {

					modulePathsExtensionsValid = false;

					break;
				}
			}
		}

		return modulePathsExtensionsValid;
	}

	protected List<String> getModulePaths(ExternalContext externalContext) {

		List<String> modulePaths = new ArrayList<String>();
		Iterator<String> requestParameterNames = externalContext.getRequestParameterNames();

		while (requestParameterNames.hasNext()) {
			String parameterName = requestParameterNames.next();

			if (parameterName.startsWith("build/")) {
				modulePaths.add(parameterName);
			}
		}

		return modulePaths;
	}

	protected String getResourceName(ExternalContext externalContext) {

		// Attempt to get the resource name from the "javax.faces.resource" request parameter. If it exists, then
		// this is probably a non-Liferay portlet environment like Pluto.
		String resourceName = externalContext.getRequestParameterMap().get("javax.faces.resource");

		if (resourceName == null) {

			// If the specified request was extension-mapped (suffix-mapped), then determine the resource name based
			// on the configured mappings to the Faces Servlet.
			Object request = externalContext.getRequest();

			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
				String servletPath = httpServletRequest.getServletPath();

				if ((servletPath != null) && servletPath.startsWith(RESOURCE_IDENTIFIER)) {

					Map<String, Object> applicationMap = externalContext.getApplicationMap();
					String appConfigAttrName = ApplicationConfig.class.getName();
					ApplicationConfig applicationConfig = (ApplicationConfig) applicationMap.get(appConfigAttrName);
					FacesConfig facesConfig = applicationConfig.getFacesConfig();
					List<ConfiguredServletMapping> configuredFacesServletMappings =
						facesConfig.getConfiguredFacesServletMappings();

					resourceName = servletPath.substring(RESOURCE_IDENTIFIER.length() + 1);

					for (ConfiguredServletMapping configuredFacesServletMapping : configuredFacesServletMappings) {

						String configuredExtension = configuredFacesServletMapping.getExtension();

						if (servletPath.endsWith(configuredExtension)) {
							resourceName = resourceName.substring(0,
									resourceName.length() - configuredExtension.length());

							break;
						}
					}
				}

				// Otherwise, it must be path-mapped.
				else {
					resourceName = httpServletRequest.getPathInfo();
				}
			}
		}

		return resourceName;
	}
}
