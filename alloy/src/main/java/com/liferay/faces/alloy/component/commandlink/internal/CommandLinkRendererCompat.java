/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.commandlink.internal;

import com.liferay.faces.alloy.component.commandlink.CommandLink;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Neil Griffin
 */
public class CommandLinkRendererCompat extends CommandLinkRendererBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(CommandLinkRendererCompat.class);

	// Private Constants
	private static final Product MOJARRA = ProductFactory.getProduct(Product.Name.MOJARRA);

	protected void addDefaultAjaxBehavior(CommandLink commandLink) {

		if (MOJARRA.isDetected() && (MOJARRA.getMajorVersion() == 2) && (MOJARRA.getMinorVersion() == 1)) {

			// The following issue is not fixed in Mojarra 2.1:
			// https://github.com/javaserverfaces/mojarra/issues/2053
			logger.warn("Mojarra 2.1 does not support dynamically adding an AjaxBehavior");
		}
		else {
			RendererUtil.addDefaultAjaxBehavior(commandLink, commandLink.getExecute(), commandLink.getProcess(), "@all",
				commandLink.getRender(), commandLink.getUpdate(), "@none");
		}
	}
}
