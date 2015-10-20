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
	 * <code>label</code> attribute description:
	 * <br /><br />
	 * The visible label for the menu. This is only used if a facet with name="label" is not present.
	 */
	public String getLabel() {
		return (String) getStateHelper().eval(MenuPropertyKeys.label, null);
	}

	/**
	 * <code>label</code> attribute description:
	 * <br /><br />
	 * The visible label for the menu. This is only used if a facet with name="label" is not present.
	 */
	public void setLabel(String label) {
		getStateHelper().put(MenuPropertyKeys.label, label);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(MenuPropertyKeys.style, null);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(MenuPropertyKeys.style, style);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(MenuPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(MenuPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-menu");
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(MenuPropertyKeys.styleClass, styleClass);
	}
}
//J+
