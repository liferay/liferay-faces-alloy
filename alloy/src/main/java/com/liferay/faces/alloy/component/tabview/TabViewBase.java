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
package com.liferay.faces.alloy.component.tabview;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIData;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class TabViewBase extends UIData implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.tabview.TabView";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.tabview.TabViewRenderer";

	// Protected Enumerations
	protected enum TabViewPropertyKeys {
		clientKey,
		height,
		selectedIndex,
		stacked,
		style,
		styleClass,
		width
	}

	public TabViewBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(TabViewPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(TabViewPropertyKeys.height, height);
	}

	/**
	 * <p><code>selectedIndex</code> attribute description:</p>
	 *
	 * <div>Integer representing the zero-based index representing the selected tab.</div>
	 */
	public Integer getSelectedIndex() {
		return (Integer) getStateHelper().eval(TabViewPropertyKeys.selectedIndex, null);
	}

	/**
	 * <p><code>selectedIndex</code> attribute description:</p>
	 *
	 * <div>Integer representing the zero-based index representing the selected tab.</div>
	 */
	public void setSelectedIndex(Integer selectedIndex) {
		getStateHelper().put(TabViewPropertyKeys.selectedIndex, selectedIndex);
	}

	/**
	 * <p><code>stacked</code> attribute description:</p>
	 *
	 * <div>When true, this indicates whether or not the tabs will appear vertically. The default value is <code>false.</code></div>
	 */
	public Boolean getStacked() {
		return (Boolean) getStateHelper().eval(TabViewPropertyKeys.stacked, null);
	}

	/**
	 * <p><code>stacked</code> attribute description:</p>
	 *
	 * <div>When true, this indicates whether or not the tabs will appear vertically. The default value is <code>false.</code></div>
	 */
	public void setStacked(Boolean stacked) {
		getStateHelper().put(TabViewPropertyKeys.stacked, stacked);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.style, null);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(TabViewPropertyKeys.style, style);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(TabViewPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(TabViewPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-tab-view");
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(TabViewPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.width, null);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public void setWidth(String width) {
		getStateHelper().put(TabViewPropertyKeys.width, width);
	}
}
//J+
