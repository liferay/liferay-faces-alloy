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

import com.liferay.faces.util.client.ScriptEncoder;
import com.liferay.faces.util.client.ScriptEncoderFactory;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;


/**
 * @author  Kyle Stiemann
 */
public class ScriptEncoderFactoryAlloyImpl extends ScriptEncoderFactory {

	// Private Constants
	private static final boolean LIFERAY_FACES_BRIDGE_DETECTED = ProductMap.getInstance().get(
			ProductConstants.LIFERAY_FACES_BRIDGE).isDetected();
	private static final boolean LIFERAY_PORTAL_DETECTED = ProductMap.getInstance().get(ProductConstants.LIFERAY_PORTAL)
		.isDetected();

	// Private Members;
	ScriptEncoderFactory wrappedScriptEncoderFactory;

	public ScriptEncoderFactoryAlloyImpl(ScriptEncoderFactory wrappedScriptEncoderFactory) {
		this.wrappedScriptEncoderFactory = wrappedScriptEncoderFactory;
	}

	@Override
	public ScriptEncoder getScriptEncoder() {

		ScriptEncoder scriptEncoder;

		if (LIFERAY_PORTAL_DETECTED && LIFERAY_FACES_BRIDGE_DETECTED) {
			scriptEncoder = wrappedScriptEncoderFactory.getScriptEncoder();
		}
		else {
			scriptEncoder = new ScriptEncoderAlloyImpl();
		}

		return scriptEncoder;
	}

	@Override
	public ScriptEncoderFactory getWrapped() {
		return wrappedScriptEncoderFactory;
	}
}
