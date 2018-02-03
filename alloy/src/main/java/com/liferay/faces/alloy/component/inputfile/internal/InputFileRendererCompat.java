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
package com.liferay.faces.alloy.component.inputfile.internal;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.liferay.faces.alloy.component.inputfile.InputFile;
import com.liferay.faces.alloy.render.internal.DelegatingAlloyRendererBase;
import com.liferay.faces.alloy.util.internal.JSFUtil;


/**
 * This class isolates differences between JSF 2.2 and JSF 2.1 in order to minimize diffs across branches.
 *
 * @author  Neil Griffin
 */
public abstract class InputFileRendererCompat extends DelegatingAlloyRendererBase {

	@Override
	public String getDelegateComponentFamily() {
		return InputFile.COMPONENT_FAMILY;
	}

	@Override
	public String getDelegateRendererType() {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		if (JSFUtil.isFaces_2_2_OrNewer(facesContext)) {
			return "javax.faces.File";
		}
		else {
			return "javax.faces.Text";
		}
	}

	protected InputFileDecoder getWebappInputFileDecoder(FacesContext facesContext) {

		// If running with JSF 2.2 (or higher), then the javax.servlet.http.Part (Servlet 3.0) mechanism for decoding
		// uploaded files must be used. This is because the the @MultipartConfig annotation on the FacesServlet will
		// cause commons-fileupload to throw exceptions.
		if (JSFUtil.isFaces_2_2_OrNewer(facesContext)) {
			return new InputFileDecoderPartImpl();
		}

		// Otherwise,
		else {

			// If running Servlet 3.0 (or newer) then the javax.servlet.http.Part (Servlet 3.0) mechanism for
			// decoding uploaded files must be used. However, this might be restricted to plain JSF 2.1 Tomcat
			// webapps (and not other servers). Not sure why this is necessary since the default value of the Tomcat
			// config param allowCasualMultipartParsing is false, meaning, Tomcat should only use the
			// javax.servlet.http.Part mechanism when it detectes the presence of the @MultipartConfig annotation on
			// the FacesServlet. https://tomcat.apache.org/tomcat-7.0-doc/config/context.html
			ExternalContext externalContext = facesContext.getExternalContext();
			HttpServletRequest httpServletRequest = (HttpServletRequest) externalContext.getRequest();
			ServletContext servletContext = httpServletRequest.getServletContext();
			int servletContextMajorVersion = servletContext.getMajorVersion();

			if (servletContextMajorVersion >= 3) {
				return new InputFileDecoderPartImpl();
			}

			// Otherwise, use commons-fileupload.
			else {
				return new InputFileDecoderCommonsImpl();
			}
		}
	}
}
