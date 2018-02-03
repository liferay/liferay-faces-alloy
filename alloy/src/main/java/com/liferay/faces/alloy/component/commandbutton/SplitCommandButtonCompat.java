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
package com.liferay.faces.alloy.component.commandbutton;

import java.util.Map;

import com.liferay.faces.alloy.component.commandlink.CommandLinkBase;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * This class isolates differences between JSF 2.2 and JSF 2.1 in order to minimize diffs across branches.
 *
 * @author  Neil Griffin
 */
public abstract class SplitCommandButtonCompat extends CommandLinkBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(SplitCommandButtonCompat.class);

	// Protected Data Members
	/**
	 * @deprecated  Please use {@link SplitCommandButton#getWrappedCommandButton()} and {@link
	 *              SplitCommandButton#setWrappedCommandButton(com.liferay.faces.alloy.component.commandbutton.CommandButton)
	 *              } instead.
	 */
	@Deprecated
	protected CommandButton wrappedCommandButton;

	@Override
	public Map<String, Object> getPassThroughAttributes(boolean create) {
		return getWrappedCommandButton().getPassThroughAttributes(create);
	}

	@Override
	public String getRole() {
		return getWrappedCommandButton().getRole();
	}

	@Override
	public void setRole(String role) {
		getWrappedCommandButton().setRole(role);
	}

	protected abstract CommandButton getWrappedCommandButton();
}
