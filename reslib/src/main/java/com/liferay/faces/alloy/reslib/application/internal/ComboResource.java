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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.application.ResourceHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.application.ResourceUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Neil Griffin
 */
public class ComboResource extends ReslibResource {

	// Public Constants
	public static final String RESOURCE_NAME = "combo";

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(ComboResource.class);

	// Private Constants
	private static final String DUMMY_RESOURCE_NAME = "combo-resource.txt";
	private static final String RESOURCE_PATH_BASE = "META-INF/resources/liferay-faces-alloy-reslib/";

	// Private Data Members
	private List<String> modulePaths;

	public ComboResource() {
		super(DUMMY_RESOURCE_NAME, RESOURCE_NAME);
	}

	public ComboResource(List<String> modulePaths) {

		this();

		if ((modulePaths == null) || (modulePaths.isEmpty())) {
			throw new IllegalArgumentException(
				"ModulePaths must not be empty. Use the no-arg constructor if you are creating a dummy combo resource.");
		}

		this.modulePaths = modulePaths;

		String firstModulePath = this.modulePaths.get(0);

		if (firstModulePath.endsWith(".css")) {
			setContentType("text/css");
		}
		else if (firstModulePath.endsWith(".js")) {
			setContentType("text/javascript");
		}
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
			String resourceText = ResourceUtil.toString(inputStream, "UTF-8", 1024);

			if ("text/css".equals(contentType)) {
				resourceText = ExpressionUtil.filterExpressions(resourceText, resourceHandlerChain, externalContext);
			}

			comboResourceText.append(resourceText);
		}

		return ResourceUtil.toInputStream(comboResourceText.toString(), "UTF-8");
	}

	@Override
	public Map<String, String> getResponseHeaders() {
		return Collections.EMPTY_MAP;
	}

	@Override
	public URL getURL() {
		return null;
	}

	@Override
	public boolean userAgentNeedsUpdate(FacesContext facesContext) {
		return true;
	}
}
