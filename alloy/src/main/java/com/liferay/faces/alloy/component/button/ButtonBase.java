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
//J-

import javax.annotation.Generated;
import javax.faces.component.html.HtmlOutcomeTargetButton;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class ButtonBase extends HtmlOutcomeTargetButton implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.button.Button";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.button.ButtonRenderer";

	// Protected Enumerations
	protected enum ButtonPropertyKeys {
		autofocus,
		disabled,
		styleClass,
		type
	}

	public ButtonBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <code>autofocus</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying whether or not the component should automatically recieve focus on the initial page load.
	 */
	public Boolean getAutofocus() {
		return (Boolean) getStateHelper().eval(ButtonPropertyKeys.autofocus, null);
	}

	/**
	 * <code>autofocus</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying whether or not the component should automatically recieve focus on the initial page load.
	 */
	public void setAutofocus(Boolean autofocus) {
		getStateHelper().put(ButtonPropertyKeys.autofocus, autofocus);
	}

	/**
	 * <code>disabled</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be disabled, and the user will be unable to interact with the component.
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(ButtonPropertyKeys.disabled, false);
	}

	/**
	 * <code>disabled</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be disabled, and the user will be unable to interact with the component.
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(ButtonPropertyKeys.disabled, disabled);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(ButtonPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(ButtonPropertyKeys.styleClass, "btn-default");

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-button");
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(ButtonPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <code>type</code> attribute description:
	 * <br /><br />
	 * The type of the button: button (default), submit, or reset.
	 */
	public String getType() {
		return (String) getStateHelper().eval(ButtonPropertyKeys.type, null);
	}

	/**
	 * <code>type</code> attribute description:
	 * <br /><br />
	 * The type of the button: button (default), submit, or reset.
	 */
	public void setType(String type) {
		getStateHelper().put(ButtonPropertyKeys.type, type);
	}
}
//J+
