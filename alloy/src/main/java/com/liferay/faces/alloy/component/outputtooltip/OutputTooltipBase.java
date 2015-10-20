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
	 * <code>autoShow</code> attribute description:
	 * <br /><br />
	 * When true, the component is visible initially.
	 */
	public boolean isAutoShow() {
		return (Boolean) getStateHelper().eval(OutputTooltipPropertyKeys.autoShow, false);
	}

	/**
	 * <code>autoShow</code> attribute description:
	 * <br /><br />
	 * When true, the component is visible initially.
	 */
	public void setAutoShow(boolean autoShow) {
		getStateHelper().put(OutputTooltipPropertyKeys.autoShow, autoShow);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(OutputTooltipPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>for</code> attribute description:
	 * <br /><br />
	 * The id of the component that is associated with the tooltip.
	 */
	public String getFor() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.for_, null);
	}

	/**
	 * <code>for</code> attribute description:
	 * <br /><br />
	 * The id of the component that is associated with the tooltip.
	 */
	public void setFor(String for_) {
		getStateHelper().put(OutputTooltipPropertyKeys.for_, for_);
	}

	/**
	 * <code>headerText</code> attribute description:
	 * <br /><br />
	 * The text to place in the header of the component.
	 */
	public String getHeaderText() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.headerText, null);
	}

	/**
	 * <code>headerText</code> attribute description:
	 * <br /><br />
	 * The text to place in the header of the component.
	 */
	public void setHeaderText(String headerText) {
		getStateHelper().put(OutputTooltipPropertyKeys.headerText, headerText);
	}

	/**
	 * <code>opacity</code> attribute description:
	 * <br /><br />
	 * A number between 0 and 1 describing how much the tooltip will obscure its background when visible.
	 */
	public String getOpacity() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.opacity, null);
	}

	/**
	 * <code>opacity</code> attribute description:
	 * <br /><br />
	 * A number between 0 and 1 describing how much the tooltip will obscure its background when visible.
	 */
	public void setOpacity(String opacity) {
		getStateHelper().put(OutputTooltipPropertyKeys.opacity, opacity);
	}

	/**
	 * <code>position</code> attribute description:
	 * <br /><br />
	 * Indicates the side of the associated component where the tooltip should appear ("right", "left", "top", "bottom").
	 */
	public String getPosition() {
		return (String) getStateHelper().eval(OutputTooltipPropertyKeys.position, "right");
	}

	/**
	 * <code>position</code> attribute description:
	 * <br /><br />
	 * Indicates the side of the associated component where the tooltip should appear ("right", "left", "top", "bottom").
	 */
	public void setPosition(String position) {
		getStateHelper().put(OutputTooltipPropertyKeys.position, position);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-output-tooltip");
	}

	/**
	 * <code>zIndex</code> attribute description:
	 * <br /><br />
	 * Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.
	 */
	public Integer getzIndex() {
		return (Integer) getStateHelper().eval(OutputTooltipPropertyKeys.zIndex, Integer.MIN_VALUE);
	}

	/**
	 * <code>zIndex</code> attribute description:
	 * <br /><br />
	 * Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.
	 */
	public void setzIndex(Integer zIndex) {
		getStateHelper().put(OutputTooltipPropertyKeys.zIndex, zIndex);
	}
}
//J+
