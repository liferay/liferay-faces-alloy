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
package com.liferay.faces.alloy.component.button;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.liferay.faces.alloy.component.link.LinkBase;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;


/**
 * This class isolates differences between JSF 2.2 and JSF 2.1 in order to minimize diffs across branches.
 *
 * @author  Neil Griffin
 */
public abstract class SplitButtonCompat extends LinkBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(SplitButtonCompat.class);

	// Private Constants
	private static final Product JSF = ProductMap.getInstance().get(ProductConstants.JSF);

	// Private Data Members
	private boolean disableClientWindow;
	private Map<String, Object> passThroughAttributes;
	private String role;

	// Protected Data Members
	protected Button wrappedButton;

	public void resetValue() {

		Method resetValueMethod = null;

		try {
			Class<? extends Button> wrappedButtonClass = wrappedButton.getClass();
			resetValueMethod = wrappedButtonClass.getMethod("resetValue", new Class[] {});
		}
		catch (NoSuchMethodException e) {

			if (isFaces_2_2_OrNewer()) {
				logger.error(e);
			}
		}

		if (resetValueMethod != null) {

			try {
				resetValueMethod.invoke(wrappedButton, new Object[] {});
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
	}

	public void setDisableClientWindow(boolean disableClientWindow) {

		Method setDisableClientWindowMethod = null;

		try {
			Class<? extends Button> wrappedButtonClass = wrappedButton.getClass();
			setDisableClientWindowMethod = wrappedButtonClass.getMethod("setDisableClientWindow",
					new Class[] { boolean.class });
		}
		catch (NoSuchMethodException e) {

			if (isFaces_2_2_OrNewer()) {
				logger.error(e);
			}
		}

		if (setDisableClientWindowMethod == null) {
			this.disableClientWindow = disableClientWindow;
		}
		else {

			try {
				setDisableClientWindowMethod.invoke(wrappedButton, disableClientWindow);
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
	}

	public Map<String, Object> getPassThroughAttributes(boolean create) {

		if (passThroughAttributes == null) {
			passThroughAttributes = new HashMap<String, Object>();
		}

		Method getPassThroughAttributesMethod = null;

		try {
			Class<? extends Button> wrappedButtonClass = wrappedButton.getClass();
			getPassThroughAttributesMethod = wrappedButtonClass.getMethod("getPassThroughAttributes",
					new Class[] { boolean.class });
		}
		catch (NoSuchMethodException e) {

			if (isFaces_2_2_OrNewer()) {
				logger.error(e);
			}
		}

		if (getPassThroughAttributesMethod != null) {

			try {
				passThroughAttributes = (Map<String, Object>) getPassThroughAttributesMethod.invoke(wrappedButton,
						new Object[] { create });
			}
			catch (Exception e) {
				logger.error(e);
			}
		}

		return passThroughAttributes;
	}

	protected boolean isFaces_2_2_OrNewer() {

		return JSF.isDetected() &&
			((JSF.getMajorVersion() > 2) || ((JSF.getMajorVersion() == 2) && (JSF.getMinorVersion() >= 2)));
	}

	public String getRole() {

		Method getRoleMethod = null;

		Class<? extends Button> wrappedButtonClass = wrappedButton.getClass();

		try {
			getRoleMethod = wrappedButtonClass.getMethod("getRole", new Class[] {});
		}
		catch (NoSuchMethodException e) {

			if (isFaces_2_2_OrNewer()) {
				logger.error(e);
			}
		}

		if (getRoleMethod != null) {

			try {
				role = (String) getRoleMethod.invoke(wrappedButton, new Object[] {});
			}
			catch (Exception e) {
				logger.error(e);
			}
		}

		return role;
	}

	public void setRole(String role) {

		Method setRoleMethod = null;

		Class<? extends Button> wrappedButtonClass = wrappedButton.getClass();

		try {
			setRoleMethod = wrappedButtonClass.getMethod("setRole", new Class[] { String.class });
		}
		catch (NoSuchMethodException e) {

			if (isFaces_2_2_OrNewer()) {
				logger.error(e);
			}
		}

		if (setRoleMethod == null) {
			this.role = role;
		}
		else {

			try {
				setRoleMethod.invoke(wrappedButton, new Object[] { role });
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
	}

	public boolean isDisableClientWindow() {

		Method isDisableClientWindowMethod = null;

		try {
			Class<? extends Button> wrappedButtonClass = wrappedButton.getClass();
			isDisableClientWindowMethod = wrappedButtonClass.getMethod("isDisableClientWindow", new Class[] {});
		}
		catch (NoSuchMethodException e) {

			if (isFaces_2_2_OrNewer()) {
				logger.error(e);
			}
		}

		if (isDisableClientWindowMethod != null) {

			try {
				disableClientWindow = (Boolean) isDisableClientWindowMethod.invoke(wrappedButton, new Object[] {});
			}
			catch (Exception e) {
				logger.error(e);
			}
		}

		return disableClientWindow;
	}
}
