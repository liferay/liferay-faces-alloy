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

import java.io.IOException;

import javax.faces.context.ResponseWriter;

import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;
import com.liferay.faces.util.render.internal.DelegationResponseWriterBase;


/**
 * This class provides a compatibility layer that isolates differences between 2.2 and older versions of JSF.
 *
 * @author  Neil Griffin
 */
public abstract class InputFileDelegationResponseWriterCompat extends DelegationResponseWriterBase {

	// Private Constants
	private static final Product JSF = ProductMap.getInstance().get(ProductConstants.JSF);

	public InputFileDelegationResponseWriterCompat(ResponseWriter responseWriter) {
		super(responseWriter);
	}

	@Override
	public void writeAttribute(String name, Object value, String property) throws IOException {

		if ("type".equals(name) && !isFaces_2_2_OrNewer()) {
			value = "file";
		}

		super.writeAttribute(name, value, property);
	}

	protected boolean isFaces_2_2_OrNewer() {

		return JSF.isDetected() &&
			((JSF.getMajorVersion() > 2) || ((JSF.getMajorVersion() == 2) && (JSF.getMinorVersion() >= 2)));
	}
}
