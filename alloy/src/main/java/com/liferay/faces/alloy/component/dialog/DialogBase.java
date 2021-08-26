/**
 * Copyright (c) 2000-2021 Liferay, Inc. All rights reserved.
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
	 * <p><code>autoShow</code> attribute description:</p>
	 *
	 * <div>When true, the component is visible initially.</div>
	 */
	public boolean isAutoShow() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.autoShow, false);
	}

	/**
	 * <p><code>autoShow</code> attribute description:</p>
	 *
	 * <div>When true, the component is visible initially.</div>
	 */
	public void setAutoShow(boolean autoShow) {
		getStateHelper().put(DialogPropertyKeys.autoShow, autoShow);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(DialogPropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(DialogPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>dismissible</code> attribute description:</p>
	 *
	 * <div>When true, the overlay window is automatically hidden when the user clicks outside of it.</div>
	 */
	public boolean isDismissible() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.dismissible, false);
	}

	/**
	 * <p><code>dismissible</code> attribute description:</p>
	 *
	 * <div>When true, the overlay window is automatically hidden when the user clicks outside of it.</div>
	 */
	public void setDismissible(boolean dismissible) {
		getStateHelper().put(DialogPropertyKeys.dismissible, dismissible);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public String getHeaderText() {
		return (String) getStateHelper().eval(DialogPropertyKeys.headerText, null);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public void setHeaderText(String headerText) {
		getStateHelper().put(DialogPropertyKeys.headerText, headerText);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The height of the dialog/popover.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(DialogPropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The height of the dialog/popover.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(DialogPropertyKeys.height, height);
	}

	/**
	 * <p><code>hideIconRendered</code> attribute description:</p>
	 *
	 * <div>When true, an "x" is placed in the upper right corner that the user can click on to hide/dismiss the overlay window.</div>
	 */
	public boolean isHideIconRendered() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.hideIconRendered, true);
	}

	/**
	 * <p><code>hideIconRendered</code> attribute description:</p>
	 *
	 * <div>When true, an "x" is placed in the upper right corner that the user can click on to hide/dismiss the overlay window.</div>
	 */
	public void setHideIconRendered(boolean hideIconRendered) {
		getStateHelper().put(DialogPropertyKeys.hideIconRendered, hideIconRendered);
	}

	/**
	 * <p><code>modal</code> attribute description:</p>
	 *
	 * <div>When true, the user must interact with the child dialog window before continuing to interact with the parent.</div>
	 */
	public boolean isModal() {
		return (Boolean) getStateHelper().eval(DialogPropertyKeys.modal, false);
	}

	/**
	 * <p><code>modal</code> attribute description:</p>
	 *
	 * <div>When true, the user must interact with the child dialog window before continuing to interact with the parent.</div>
	 */
	public void setModal(boolean modal) {
		getStateHelper().put(DialogPropertyKeys.modal, modal);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(PropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(PropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-dialog");
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The width of the dialog/popover.</div>
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(DialogPropertyKeys.width, null);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The width of the dialog/popover.</div>
	 */
	public void setWidth(String width) {
		getStateHelper().put(DialogPropertyKeys.width, width);
	}

	/**
	 * <p><code>zIndex</code> attribute description:</p>
	 *
	 * <div>Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.</div>
	 */
	public Integer getzIndex() {
		return (Integer) getStateHelper().eval(DialogPropertyKeys.zIndex, Integer.MIN_VALUE);
	}

	/**
	 * <p><code>zIndex</code> attribute description:</p>
	 *
	 * <div>Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.</div>
	 */
	public void setzIndex(Integer zIndex) {
		getStateHelper().put(DialogPropertyKeys.zIndex, zIndex);
	}
}
//J+
