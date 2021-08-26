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
package com.liferay.faces.alloy.component.menu;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIColumn;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class MenuBase extends UIColumn implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.menu.Menu";

	// Protected Enumerations
	protected enum MenuPropertyKeys {
		label,
		style,
		styleClass
	}

	public MenuBase() {
		super();
		setRendererType("");
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>The visible label for the menu. This is only used if a facet with name="label" is not present.</div>
	 */
	public String getLabel() {
		return (String) getStateHelper().eval(MenuPropertyKeys.label, null);
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>The visible label for the menu. This is only used if a facet with name="label" is not present.</div>
	 */
	public void setLabel(String label) {
		getStateHelper().put(MenuPropertyKeys.label, label);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(MenuPropertyKeys.style, null);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(MenuPropertyKeys.style, style);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(MenuPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(MenuPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-menu");
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(MenuPropertyKeys.styleClass, styleClass);
	}
}
//J+
