/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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

import com.liferay.faces.alloy.component.inputfile.InputFile;
import com.liferay.faces.alloy.render.internal.DelegatingAlloyRendererBase;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;


/**
 * This class isolates differences between JSF 2.2 and JSF 2.1 in order to minimize diffs across branches.
 *
 * @author  Neil Griffin
 */
public abstract class InputFileRendererCompat extends DelegatingAlloyRendererBase {

	// Private Constants
	private static final Product JSF = ProductMap.getInstance().get(ProductConstants.JSF);

	@Override
	public String getDelegateComponentFamily() {
		return InputFile.COMPONENT_FAMILY;
	}

	@Override
	public String getDelegateRendererType() {

		if (isFaces_2_2_OrNewer()) {
			return "javax.faces.File";
		}
		else {
			return "javax.faces.Text";
		}
	}

	protected InputFileDecoder getInputFileDecoder() {

		if (isFaces_2_2_OrNewer()) {

			// Since running with JSF 2.2 (or higher) need to use the javax.servlet.http.Part (Servlet 3.0) method of
			// decoding uploaded files. This is because the the @MultipartConfig annotation on the FacesServlet will
			// cause commons-fileupload to throw exceptions.
			return new InputFileDecoderPartImpl();
		}
		else {
			return new InputFileDecoderCommonsImpl();
		}
	}

	protected boolean isFaces_2_2_OrNewer() {

		return JSF.isDetected() &&
			((JSF.getMajorVersion() > 2) || ((JSF.getMajorVersion() == 2) && (JSF.getMinorVersion() >= 2)));
	}
}
