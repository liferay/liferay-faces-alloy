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
package com.liferay.faces.alloy.component.tab;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIColumn;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class TabBase extends UIColumn implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.tab.Tab";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.tab.TabRenderer";

	// Protected Enumerations
	protected enum TabPropertyKeys {
		contentClass,
		disabled,
		headerClass,
		headerText,
		style,
		styleClass
	}

	public TabBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>contentClass</code> attribute description:</p>
	 *
	 * <div>When alloy:tab is a child of alloy:accordion, this is the name of the CSS class that is to be rendered within the class attribute of the content &lt;div&gt;</div>
	 */
	public String getContentClass() {
		return (String) getStateHelper().eval(TabPropertyKeys.contentClass, null);
	}

	/**
	 * <p><code>contentClass</code> attribute description:</p>
	 *
	 * <div>When alloy:tab is a child of alloy:accordion, this is the name of the CSS class that is to be rendered within the class attribute of the content &lt;div&gt;</div>
	 */
	public void setContentClass(String contentClass) {
		getStateHelper().put(TabPropertyKeys.contentClass, contentClass);
	}

	/**
	 * <p><code>disabled</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be disabled, and the user will be unable to intercat with the component.</div>
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(TabPropertyKeys.disabled, false);
	}

	/**
	 * <p><code>disabled</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be disabled, and the user will be unable to intercat with the component.</div>
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(TabPropertyKeys.disabled, disabled);
	}

	/**
	 * <p><code>headerClass</code> attribute description:</p>
	 *
	 * <div>When alloy:tab is a child of alloy:accordion, this is the name of the CSS class that is to be rendered within the class attribute of the header &lt;div&gt;</div>
	 */
	public String getHeaderClass() {
		return (String) getStateHelper().eval(TabPropertyKeys.headerClass, null);
	}

	/**
	 * <p><code>headerClass</code> attribute description:</p>
	 *
	 * <div>When alloy:tab is a child of alloy:accordion, this is the name of the CSS class that is to be rendered within the class attribute of the header &lt;div&gt;</div>
	 */
	public void setHeaderClass(String headerClass) {
		getStateHelper().put(TabPropertyKeys.headerClass, headerClass);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public String getHeaderText() {
		return (String) getStateHelper().eval(TabPropertyKeys.headerText, null);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public void setHeaderText(String headerText) {
		getStateHelper().put(TabPropertyKeys.headerText, headerText);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(TabPropertyKeys.style, null);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(TabPropertyKeys.style, style);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(TabPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(TabPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-tab");
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(TabPropertyKeys.styleClass, styleClass);
	}
}
//J+
