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
package com.liferay.faces.alloy.component.commandbutton.internal;

import javax.faces.context.FacesContext;

import com.liferay.faces.alloy.component.commandbutton.CommandButton;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Neil Griffin
 */
public class CommandButtonRendererCompat extends CommandButtonRendererBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(CommandButtonRendererCompat.class);

	// Private Constants
	private static final Product MOJARRA = ProductFactory.getProduct(Product.Name.MOJARRA);

	protected void addDefaultAjaxBehavior(CommandButton commandButton) {

		if (MOJARRA.isDetected() && (MOJARRA.getMajorVersion() == 2) && (MOJARRA.getMinorVersion() == 1) &&
				FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {

			// The following issue is not fixed in Mojarra 2.1:
			// https://github.com/javaserverfaces/mojarra/issues/2053
			logger.warn("Mojarra 2.1 does not support dynamically adding an AjaxBehavior");
		}
		else {
			RendererUtil.addDefaultAjaxBehavior(commandButton, commandButton.getExecute(), commandButton.getProcess(),
				"@all", commandButton.getRender(), commandButton.getUpdate(), "@none");
		}
	}
}
