/**
 * Copyright (c) 2000-2022 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.popover;
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
public abstract class PopoverBase extends PanelGroupBlockLayout implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.popover.Popover";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.popover.PopoverRenderer";

	// Protected Enumerations
	protected enum PopoverPropertyKeys {
		autoShow,
		clientKey,
		dismissible,
		for_,
		headerText,
		height,
		hideIconRendered,
		position,
		width,
		zIndex
	}

	public PopoverBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>autoShow</code> attribute description:</p>
	 *
	 * <div>When true, the component is visible initially.</div>
	 */
	public boolean isAutoShow() {
		return (Boolean) getStateHelper().eval(PopoverPropertyKeys.autoShow, false);
	}

	/**
	 * <p><code>autoShow</code> attribute description:</p>
	 *
	 * <div>When true, the component is visible initially.</div>
	 */
	public void setAutoShow(boolean autoShow) {
		getStateHelper().put(PopoverPropertyKeys.autoShow, autoShow);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(PopoverPropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(PopoverPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>dismissible</code> attribute description:</p>
	 *
	 * <div>When true, the overlay window is automatically hidden when the user clicks outside of it.</div>
	 */
	public boolean isDismissible() {
		return (Boolean) getStateHelper().eval(PopoverPropertyKeys.dismissible, true);
	}

	/**
	 * <p><code>dismissible</code> attribute description:</p>
	 *
	 * <div>When true, the overlay window is automatically hidden when the user clicks outside of it.</div>
	 */
	public void setDismissible(boolean dismissible) {
		getStateHelper().put(PopoverPropertyKeys.dismissible, dismissible);
	}

	/**
	 * <p><code>for</code> attribute description:</p>
	 *
	 * <div>The id of the component that is associated with the popover.</div>
	 */
	public String getFor() {
		return (String) getStateHelper().eval(PopoverPropertyKeys.for_, null);
	}

	/**
	 * <p><code>for</code> attribute description:</p>
	 *
	 * <div>The id of the component that is associated with the popover.</div>
	 */
	public void setFor(String for_) {
		getStateHelper().put(PopoverPropertyKeys.for_, for_);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public String getHeaderText() {
		return (String) getStateHelper().eval(PopoverPropertyKeys.headerText, null);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public void setHeaderText(String headerText) {
		getStateHelper().put(PopoverPropertyKeys.headerText, headerText);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The height of the dialog/popover.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(PopoverPropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The height of the dialog/popover.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(PopoverPropertyKeys.height, height);
	}

	/**
	 * <p><code>hideIconRendered</code> attribute description:</p>
	 *
	 * <div>When true, an "x" is placed in the upper right corner that the user can click on to hide/dismiss the overlay window.</div>
	 */
	public boolean isHideIconRendered() {
		return (Boolean) getStateHelper().eval(PopoverPropertyKeys.hideIconRendered, true);
	}

	/**
	 * <p><code>hideIconRendered</code> attribute description:</p>
	 *
	 * <div>When true, an "x" is placed in the upper right corner that the user can click on to hide/dismiss the overlay window.</div>
	 */
	public void setHideIconRendered(boolean hideIconRendered) {
		getStateHelper().put(PopoverPropertyKeys.hideIconRendered, hideIconRendered);
	}

	/**
	 * <p><code>position</code> attribute description:</p>
	 *
	 * <div>Indicates the side of the associated component where the tooltip should appear ("right", "left", "top", "bottom").</div>
	 */
	public String getPosition() {
		return (String) getStateHelper().eval(PopoverPropertyKeys.position, "right");
	}

	/**
	 * <p><code>position</code> attribute description:</p>
	 *
	 * <div>Indicates the side of the associated component where the tooltip should appear ("right", "left", "top", "bottom").</div>
	 */
	public void setPosition(String position) {
		getStateHelper().put(PopoverPropertyKeys.position, position);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-popover");
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The width of the dialog/popover.</div>
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(PopoverPropertyKeys.width, null);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The width of the dialog/popover.</div>
	 */
	public void setWidth(String width) {
		getStateHelper().put(PopoverPropertyKeys.width, width);
	}

	/**
	 * <p><code>zIndex</code> attribute description:</p>
	 *
	 * <div>Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.</div>
	 */
	public Integer getzIndex() {
		return (Integer) getStateHelper().eval(PopoverPropertyKeys.zIndex, Integer.MIN_VALUE);
	}

	/**
	 * <p><code>zIndex</code> attribute description:</p>
	 *
	 * <div>Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.</div>
	 */
	public void setzIndex(Integer zIndex) {
		getStateHelper().put(PopoverPropertyKeys.zIndex, zIndex);
	}
}
//J+
