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
package com.liferay.faces.alloy.component.outputtooltip;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.outputtext.OutputTextBase;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class OutputTooltipBase extends OutputTextBase implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.outputtooltip.OutputTooltip";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.outputtooltip.OutputTooltipRenderer";

	// Protected Enumerations
	protected enum OutputTooltipPropertyKeys {
		autoShow,
		clientKey,
		for_,
		headerText,
		opacity,
		position,
		zIndex
	}

	public OutputTooltipBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>autoShow</code> attribute description:</p>
	 *
	 * <div>When true, the component is visible initially.</div>
	 */
	public boolean isAutoShow() {
		return (Boolean) getStateHelper().eval(OutputTooltipPropertyKeys.autoShow, false);
	}

	/**
	 * <p><code>autoShow</code> attribute description:</p>
	 *
	 * <div>When true, the component is visible initially.</div>
	 */
	public void setAutoShow(boolean autoShow) {
		getStateHelper().put(OutputTooltipPropertyKeys.autoShow, autoShow);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(OutputTooltipPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>for</code> attribute description:</p>
	 *
	 * <div>The id of the component that is associated with the tooltip.</div>
	 */
	public String getFor() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.for_, null);
	}

	/**
	 * <p><code>for</code> attribute description:</p>
	 *
	 * <div>The id of the component that is associated with the tooltip.</div>
	 */
	public void setFor(String for_) {
		getStateHelper().put(OutputTooltipPropertyKeys.for_, for_);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public String getHeaderText() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.headerText, null);
	}

	/**
	 * <p><code>headerText</code> attribute description:</p>
	 *
	 * <div>The text to place in the header of the component.</div>
	 */
	public void setHeaderText(String headerText) {
		getStateHelper().put(OutputTooltipPropertyKeys.headerText, headerText);
	}

	/**
	 * <p><code>opacity</code> attribute description:</p>
	 *
	 * <div>A number between 0 and 1 describing how much the tooltip will obscure its background when visible.</div>
	 */
	public String getOpacity() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.opacity, null);
	}

	/**
	 * <p><code>opacity</code> attribute description:</p>
	 *
	 * <div>A number between 0 and 1 describing how much the tooltip will obscure its background when visible.</div>
	 */
	public void setOpacity(String opacity) {
		getStateHelper().put(OutputTooltipPropertyKeys.opacity, opacity);
	}

	/**
	 * <p><code>position</code> attribute description:</p>
	 *
	 * <div>Indicates the side of the associated component where the tooltip should appear ("right", "left", "top", "bottom").</div>
	 */
	public String getPosition() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.position, "right");
	}

	/**
	 * <p><code>position</code> attribute description:</p>
	 *
	 * <div>Indicates the side of the associated component where the tooltip should appear ("right", "left", "top", "bottom").</div>
	 */
	public void setPosition(String position) {
		getStateHelper().put(OutputTooltipPropertyKeys.position, position);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-output-tooltip");
	}

	/**
	 * <p><code>zIndex</code> attribute description:</p>
	 *
	 * <div>Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.</div>
	 */
	public Integer getzIndex() {
		return (Integer) getStateHelper().eval(OutputTooltipPropertyKeys.zIndex, Integer.MIN_VALUE);
	}

	/**
	 * <p><code>zIndex</code> attribute description:</p>
	 *
	 * <div>Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.</div>
	 */
	public void setzIndex(Integer zIndex) {
		getStateHelper().put(OutputTooltipPropertyKeys.zIndex, zIndex);
	}
}
//J+
