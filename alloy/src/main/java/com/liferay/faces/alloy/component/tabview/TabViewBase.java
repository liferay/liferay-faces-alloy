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
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(TabViewPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.height, null);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public void setHeight(String height) {
		getStateHelper().put(TabViewPropertyKeys.height, height);
	}

	/**
	 * <code>selectedIndex</code> attribute description:
	 * <br /><br />
	 * Integer representing the zero-based index representing the selected tab.
	 */
	public Integer getSelectedIndex() {
		return (Integer) getStateHelper().eval(TabViewPropertyKeys.selectedIndex, null);
	}

	/**
	 * <code>selectedIndex</code> attribute description:
	 * <br /><br />
	 * Integer representing the zero-based index representing the selected tab.
	 */
	public void setSelectedIndex(Integer selectedIndex) {
		getStateHelper().put(TabViewPropertyKeys.selectedIndex, selectedIndex);
	}

	/**
	 * <code>stacked</code> attribute description:
	 * <br /><br />
	 * When true, this indicates whether or not the tabs will appear vertically. The default value is <code>false.</code>
	 */
	public Boolean getStacked() {
		return (Boolean) getStateHelper().eval(TabViewPropertyKeys.stacked, null);
	}

	/**
	 * <code>stacked</code> attribute description:
	 * <br /><br />
	 * When true, this indicates whether or not the tabs will appear vertically. The default value is <code>false.</code>
	 */
	public void setStacked(Boolean stacked) {
		getStateHelper().put(TabViewPropertyKeys.stacked, stacked);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.style, null);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(TabViewPropertyKeys.style, style);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(TabViewPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(TabViewPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-tab-view");
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(TabViewPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(TabViewPropertyKeys.width, null);
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public void setWidth(String width) {
		getStateHelper().put(TabViewPropertyKeys.width, width);
	}
}
//J+
