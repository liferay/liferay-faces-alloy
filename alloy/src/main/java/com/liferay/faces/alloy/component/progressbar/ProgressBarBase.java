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
package com.liferay.faces.alloy.component.progressbar;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIComponentBase;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class ProgressBarBase extends UIComponentBase implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_FAMILY = "com.liferay.faces.alloy.component.progressbar";
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.progressbar.ProgressBar";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.progressbar.ProgressBarRenderer";

	// Protected Enumerations
	protected enum ProgressBarPropertyKeys {
		clientKey,
		height,
		label,
		layout,
		maxProgress,
		minProgress,
		oncomplete,
		pollingDelay,
		style,
		styleClass,
		value,
		width
	}

	public ProgressBarBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(ProgressBarPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the progress bar.
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.height, null);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the progress bar.
	 */
	public void setHeight(String height) {
		getStateHelper().put(ProgressBarPropertyKeys.height, height);
	}

	/**
	 * <code>label</code> attribute description:
	 * <br /><br />
	 * The label which appears on the progress bar. The <code>{0}</code> token can be used to include the value in the label.
	 */
	public String getLabel() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.label, null);
	}

	/**
	 * <code>label</code> attribute description:
	 * <br /><br />
	 * The label which appears on the progress bar. The <code>{0}</code> token can be used to include the value in the label.
	 */
	public void setLabel(String label) {
		getStateHelper().put(ProgressBarPropertyKeys.label, label);
	}

	/**
	 * <code>layout</code> attribute description:
	 * <br /><br />
	 * The direction in which the layout of the component should be displayed. Valid values include <code>lineDirection</code> (the default) and <code>pageDirection</code>.
	 */
	public String getLayout() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.layout, null);
	}

	/**
	 * <code>layout</code> attribute description:
	 * <br /><br />
	 * The direction in which the layout of the component should be displayed. Valid values include <code>lineDirection</code> (the default) and <code>pageDirection</code>.
	 */
	public void setLayout(String layout) {
		getStateHelper().put(ProgressBarPropertyKeys.layout, layout);
	}

	/**
	 * <code>maxProgress</code> attribute description:
	 * <br /><br />
	 * The maximum value that the progress bar can have. The default value is <code>100</code>.
	 */
	public Integer getMaxProgress() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.maxProgress, null);
	}

	/**
	 * <code>maxProgress</code> attribute description:
	 * <br /><br />
	 * The maximum value that the progress bar can have. The default value is <code>100</code>.
	 */
	public void setMaxProgress(Integer maxProgress) {
		getStateHelper().put(ProgressBarPropertyKeys.maxProgress, maxProgress);
	}

	/**
	 * <code>minProgress</code> attribute description:
	 * <br /><br />
	 * The minimum value that the progress bar can have. The default value is <code>0</code>.
	 */
	public Integer getMinProgress() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.minProgress, null);
	}

	/**
	 * <code>minProgress</code> attribute description:
	 * <br /><br />
	 * The minimum value that the progress bar can have. The default value is <code>0</code>.
	 */
	public void setMinProgress(Integer minProgress) {
		getStateHelper().put(ProgressBarPropertyKeys.minProgress, minProgress);
	}

	/**
	 * <code>oncomplete</code> attribute description:
	 * <br /><br />
	 * Client-side javascript to be executed when progress has completed.
	 */
	public String getOncomplete() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.oncomplete, null);
	}

	/**
	 * <code>oncomplete</code> attribute description:
	 * <br /><br />
	 * Client-side javascript to be executed when progress has completed.
	 */
	public void setOncomplete(String oncomplete) {
		getStateHelper().put(ProgressBarPropertyKeys.oncomplete, oncomplete);
	}

	/**
	 * <code>pollingDelay</code> attribute description:
	 * <br /><br />
	 * The delay (in milliseconds) before dispatching a polling Ajax request after recieving the response of a previous request.
	 */
	public Integer getPollingDelay() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.pollingDelay, 3000);
	}

	/**
	 * <code>pollingDelay</code> attribute description:
	 * <br /><br />
	 * The delay (in milliseconds) before dispatching a polling Ajax request after recieving the response of a previous request.
	 */
	public void setPollingDelay(Integer pollingDelay) {
		getStateHelper().put(ProgressBarPropertyKeys.pollingDelay, pollingDelay);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.style, null);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(ProgressBarPropertyKeys.style, style);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(ProgressBarPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(ProgressBarPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-progress-bar");
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(ProgressBarPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <code>value</code> attribute description:
	 * <br /><br />
	 * The value of this component, which is typically bound via EL to a model bean property.
	 */
	public Integer getValue() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.value, 0);
	}

	/**
	 * <code>value</code> attribute description:
	 * <br /><br />
	 * The value of this component, which is typically bound via EL to a model bean property.
	 */
	public void setValue(Integer value) {
		getStateHelper().put(ProgressBarPropertyKeys.value, value);
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The the width (in pixels) of the progress bar.
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.width, null);
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The the width (in pixels) of the progress bar.
	 */
	public void setWidth(String width) {
		getStateHelper().put(ProgressBarPropertyKeys.width, width);
	}
}
//J+
