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
package com.liferay.faces.alloy.util.internal;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;


/**
 * @author  Kyle Stiemann
 */
public final class JSFUtil {

	private JSFUtil() {
		throw new AssertionError();
	}

	public static boolean isFaces_2_2_OrNewer(FacesContext facesContext) {

		ExternalContext externalContext = facesContext.getExternalContext();
		final Product JSF = ProductFactory.getProductInstance(externalContext, Product.Name.JSF);

		return JSF.isDetected() &&
			((JSF.getMajorVersion() > 2) || ((JSF.getMajorVersion() == 2) && (JSF.getMinorVersion() >= 2)));
	}
}
