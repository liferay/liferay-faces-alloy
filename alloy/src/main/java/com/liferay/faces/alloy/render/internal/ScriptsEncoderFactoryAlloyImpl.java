/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.render.internal;

import java.io.Serializable;

import com.liferay.faces.util.client.ScriptsEncoder;
import com.liferay.faces.util.client.ScriptsEncoderFactory;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;


/**
 * @author  Kyle Stiemann
 */
public class ScriptsEncoderFactoryAlloyImpl extends ScriptsEncoderFactory implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 2186017689814362487L;

	// Private Constants
	private static final boolean LIFERAY_FACES_BRIDGE_DETECTED = ProductFactory.getProduct(
			Product.Name.LIFERAY_FACES_BRIDGE).isDetected();
	private static final boolean LIFERAY_PORTAL_DETECTED = ProductFactory.getProduct(Product.Name.LIFERAY_PORTAL)
		.isDetected();

	// Private Data Members
	ScriptsEncoder scriptsEncoder;
	ScriptsEncoderFactory wrappedScriptsEncoderFactory;

	public ScriptsEncoderFactoryAlloyImpl(ScriptsEncoderFactory scriptEncoderFactory) {

		if (LIFERAY_PORTAL_DETECTED && LIFERAY_FACES_BRIDGE_DETECTED) {
			this.scriptsEncoder = scriptEncoderFactory.getScriptsEncoder();
		}
		else {
			this.scriptsEncoder = new ScriptsEncoderAlloyImpl();
		}

		this.wrappedScriptsEncoderFactory = scriptEncoderFactory;
	}

	@Override
	public ScriptsEncoder getScriptsEncoder() {
		return scriptsEncoder;
	}

	@Override
	public ScriptsEncoderFactory getWrapped() {
		return wrappedScriptsEncoderFactory;
	}
}
