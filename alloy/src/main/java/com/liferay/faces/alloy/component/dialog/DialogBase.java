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
package com.liferay.faces.alloy.component.dialog;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.panelgroup.PanelGroupBlockLayout;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class DialogBase extends PanelGroupBlockLayout implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.dialog.Dialog";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.dialog.DialogRenderer";

	// Protected Enumerations
	protected enum DialogPropertyKeys {
		autoShow,
		clientKey,
		dismissible,
		headerText,
		height,
		hideIconRendered,
		modal,
		width,
		zIndex
	}

	public DialogBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <code>autoShow</code> attribute description:
	 * <br /><br />
	 * When true, the component is visible initially.
	 */
	public boolean isAutoShow() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.autoShow, false);
	}

	/**
	 * <code>autoShow</code> attribute description:
	 * <br /><br />
	 * When true, the component is visible initially.
	 */
	public void setAutoShow(boolean autoShow) {
		getStateHelper().put(DialogPropertyKeys.autoShow, autoShow);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(DialogPropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(DialogPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>dismissible</code> attribute description:
	 * <br /><br />
	 * When true, the overlay window is automatically hidden when the user clicks outside of it.
	 */
	public boolean isDismissible() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.dismissible, false);
	}

	/**
	 * <code>dismissible</code> attribute description:
	 * <br /><br />
	 * When true, the overlay window is automatically hidden when the user clicks outside of it.
	 */
	public void setDismissible(boolean dismissible) {
		getStateHelper().put(DialogPropertyKeys.dismissible, dismissible);
	}

	/**
	 * <code>headerText</code> attribute description:
	 * <br /><br />
	 * The text to place in the header of the component.
	 */
	public String getHeaderText() {
		return (String) getStateHelper().eval(DialogPropertyKeys.headerText, null);
	}

	/**
	 * <code>headerText</code> attribute description:
	 * <br /><br />
	 * The text to place in the header of the component.
	 */
	public void setHeaderText(String headerText) {
		getStateHelper().put(DialogPropertyKeys.headerText, headerText);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The height of the dialog/popover.
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(DialogPropertyKeys.height, null);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The height of the dialog/popover.
	 */
	public void setHeight(String height) {
		getStateHelper().put(DialogPropertyKeys.height, height);
	}

	/**
	 * <code>hideIconRendered</code> attribute description:
	 * <br /><br />
	 * When true, an "x" is placed in the upper right corner that the user can click on to hide/dismiss the overlay window.
	 */
	public boolean isHideIconRendered() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.hideIconRendered, true);
	}

	/**
	 * <code>hideIconRendered</code> attribute description:
	 * <br /><br />
	 * When true, an "x" is placed in the upper right corner that the user can click on to hide/dismiss the overlay window.
	 */
	public void setHideIconRendered(boolean hideIconRendered) {
		getStateHelper().put(DialogPropertyKeys.hideIconRendered, hideIconRendered);
	}

	/**
	 * <code>modal</code> attribute description:
	 * <br /><br />
	 * When true, the user must interact with the child dialog window before continuing to interact with the parent.
	 */
	public boolean isModal() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.modal, false);
	}

	/**
	 * <code>modal</code> attribute description:
	 * <br /><br />
	 * When true, the user must interact with the child dialog window before continuing to interact with the parent.
	 */
	public void setModal(boolean modal) {
		getStateHelper().put(DialogPropertyKeys.modal, modal);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(PropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(PropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-dialog");
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The width of the dialog/popover.
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(DialogPropertyKeys.width, null);
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The width of the dialog/popover.
	 */
	public void setWidth(String width) {
		getStateHelper().put(DialogPropertyKeys.width, width);
	}

	/**
	 * <code>zIndex</code> attribute description:
	 * <br /><br />
	 * Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.
	 */
	public Integer getzIndex() {
		return (Integer) getStateHelper().eval(DialogPropertyKeys.zIndex, Integer.MIN_VALUE);
	}

	/**
	 * <code>zIndex</code> attribute description:
	 * <br /><br />
	 * Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.
	 */
	public void setzIndex(Integer zIndex) {
		getStateHelper().put(DialogPropertyKeys.zIndex, zIndex);
	}
}
//J+
