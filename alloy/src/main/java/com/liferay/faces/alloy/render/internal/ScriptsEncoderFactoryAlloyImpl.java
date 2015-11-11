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
package com.liferay.faces.alloy.render.internal;

import com.liferay.faces.util.client.ScriptsEncoder;
import com.liferay.faces.util.client.ScriptsEncoderFactory;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;


/**
 * @author  Kyle Stiemann
 */
public class ScriptsEncoderFactoryAlloyImpl extends ScriptsEncoderFactory {

	// Private Constants
	private static final boolean LIFERAY_FACES_BRIDGE_DETECTED = ProductMap.getInstance().get(
			ProductConstants.LIFERAY_FACES_BRIDGE).isDetected();
	private static final boolean LIFERAY_PORTAL_DETECTED = ProductMap.getInstance().get(ProductConstants.LIFERAY_PORTAL)
		.isDetected();

	// Private Members;
	ScriptsEncoderFactory wrappedScriptsEncoderFactory;

	public ScriptsEncoderFactoryAlloyImpl(ScriptsEncoderFactory wrappedScriptEncoderFactory) {
		this.wrappedScriptsEncoderFactory = wrappedScriptEncoderFactory;
	}

	@Override
	public ScriptsEncoder getScriptsEncoder() {

		if (LIFERAY_PORTAL_DETECTED && LIFERAY_FACES_BRIDGE_DETECTED) {
			return wrappedScriptsEncoderFactory.getScriptsEncoder();
		}
		else {
			return new ScriptsEncoderAlloyImpl();
		}
	}

	@Override
	public ScriptsEncoderFactory getWrapped() {
		return wrappedScriptsEncoderFactory;
	}
}
