/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
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
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(ProgressBarPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the progress bar.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the progress bar.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(ProgressBarPropertyKeys.height, height);
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>The label which appears on the progress bar. The <code>{0}</code> token can be used to include the value in the label.</div>
	 */
	public String getLabel() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.label, null);
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>The label which appears on the progress bar. The <code>{0}</code> token can be used to include the value in the label.</div>
	 */
	public void setLabel(String label) {
		getStateHelper().put(ProgressBarPropertyKeys.label, label);
	}

	/**
	 * <p><code>layout</code> attribute description:</p>
	 *
	 * <div>The direction in which the layout of the component should be displayed. Valid values include <code>lineDirection</code> (the default) and <code>pageDirection</code>.</div>
	 */
	public String getLayout() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.layout, null);
	}

	/**
	 * <p><code>layout</code> attribute description:</p>
	 *
	 * <div>The direction in which the layout of the component should be displayed. Valid values include <code>lineDirection</code> (the default) and <code>pageDirection</code>.</div>
	 */
	public void setLayout(String layout) {
		getStateHelper().put(ProgressBarPropertyKeys.layout, layout);
	}

	/**
	 * <p><code>maxProgress</code> attribute description:</p>
	 *
	 * <div>The maximum value that the progress bar can have. The default value is <code>100</code>.</div>
	 */
	public Integer getMaxProgress() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.maxProgress, null);
	}

	/**
	 * <p><code>maxProgress</code> attribute description:</p>
	 *
	 * <div>The maximum value that the progress bar can have. The default value is <code>100</code>.</div>
	 */
	public void setMaxProgress(Integer maxProgress) {
		getStateHelper().put(ProgressBarPropertyKeys.maxProgress, maxProgress);
	}

	/**
	 * <p><code>minProgress</code> attribute description:</p>
	 *
	 * <div>The minimum value that the progress bar can have. The default value is <code>0</code>.</div>
	 */
	public Integer getMinProgress() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.minProgress, null);
	}

	/**
	 * <p><code>minProgress</code> attribute description:</p>
	 *
	 * <div>The minimum value that the progress bar can have. The default value is <code>0</code>.</div>
	 */
	public void setMinProgress(Integer minProgress) {
		getStateHelper().put(ProgressBarPropertyKeys.minProgress, minProgress);
	}

	/**
	 * <p><code>oncomplete</code> attribute description:</p>
	 *
	 * <div>Client-side javascript to be executed when progress has completed.</div>
	 */
	public String getOncomplete() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.oncomplete, null);
	}

	/**
	 * <p><code>oncomplete</code> attribute description:</p>
	 *
	 * <div>Client-side javascript to be executed when progress has completed.</div>
	 */
	public void setOncomplete(String oncomplete) {
		getStateHelper().put(ProgressBarPropertyKeys.oncomplete, oncomplete);
	}

	/**
	 * <p><code>pollingDelay</code> attribute description:</p>
	 *
	 * <div>The delay (in milliseconds) before dispatching a polling Ajax request after recieving the response of a previous request.</div>
	 */
	public Integer getPollingDelay() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.pollingDelay, 3000);
	}

	/**
	 * <p><code>pollingDelay</code> attribute description:</p>
	 *
	 * <div>The delay (in milliseconds) before dispatching a polling Ajax request after recieving the response of a previous request.</div>
	 */
	public void setPollingDelay(Integer pollingDelay) {
		getStateHelper().put(ProgressBarPropertyKeys.pollingDelay, pollingDelay);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.style, null);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(ProgressBarPropertyKeys.style, style);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(ProgressBarPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(ProgressBarPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-progress-bar");
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(ProgressBarPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <p><code>value</code> attribute description:</p>
	 *
	 * <div>The value of this component, which is typically bound via EL to a model bean property.</div>
	 */
	public Integer getValue() {
		return (Integer) getStateHelper().eval(ProgressBarPropertyKeys.value, 0);
	}

	/**
	 * <p><code>value</code> attribute description:</p>
	 *
	 * <div>The value of this component, which is typically bound via EL to a model bean property.</div>
	 */
	public void setValue(Integer value) {
		getStateHelper().put(ProgressBarPropertyKeys.value, value);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the width (in pixels) of the progress bar.</div>
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(ProgressBarPropertyKeys.width, null);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the width (in pixels) of the progress bar.</div>
	 */
	public void setWidth(String width) {
		getStateHelper().put(ProgressBarPropertyKeys.width, width);
	}
}
//J+
