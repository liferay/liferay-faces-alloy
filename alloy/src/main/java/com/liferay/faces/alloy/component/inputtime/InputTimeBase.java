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
package com.liferay.faces.alloy.component.inputtime;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.inputdatetime.InputDateTime;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputTimeBase extends InputDateTime implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.inputtime.InputTime";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.inputtime.InputTimeRenderer";

	// Protected Enumerations
	protected enum InputTimePropertyKeys {
		activateFirstItem,
		circular,
		filterType,
		height,
		highlighterType,
		maxResults,
		maxTime,
		minTime,
		nativeWhenMobile,
		pattern,
		queryDelay,
		scrollIntoView,
		step
	}

	public InputTimeBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>activateFirstItem</code> attribute description:</p>
	 *
	 * <div>When true, the first item in the list will be activated so that users can press TAB or ENTER to select it.</div>
	 */
	public boolean isActivateFirstItem() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.activateFirstItem, true);
	}

	/**
	 * <p><code>activateFirstItem</code> attribute description:</p>
	 *
	 * <div>When true, the first item in the list will be activated so that users can press TAB or ENTER to select it.</div>
	 */
	public void setActivateFirstItem(boolean activateFirstItem) {
		getStateHelper().put(InputTimePropertyKeys.activateFirstItem, activateFirstItem);
	}

	/**
	 * <p><code>circular</code> attribute description:</p>
	 *
	 * <div>When true, the autoComplete list will wrap around allowing users to use keyboard navigation to move from the top of the list to the bottom and vice versa. The default value is <code>true</code>.</div>
	 */
	public Boolean getCircular() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.circular, null);
	}

	/**
	 * <p><code>circular</code> attribute description:</p>
	 *
	 * <div>When true, the autoComplete list will wrap around allowing users to use keyboard navigation to move from the top of the list to the bottom and vice versa. The default value is <code>true</code>.</div>
	 */
	public void setCircular(Boolean circular) {
		getStateHelper().put(InputTimePropertyKeys.circular, circular);
	}

	/**
	 * <p><code>filterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the pickTime's autocompletion. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul></div>
	 */
	public String getFilterType() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.filterType, null);
	}

	/**
	 * <p><code>filterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the pickTime's autocompletion. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul></div>
	 */
	public void setFilterType(String filterType) {
		getStateHelper().put(InputTimePropertyKeys.filterType, filterType);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered autoComplete list.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered autoComplete list.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(InputTimePropertyKeys.height, height);
	}

	/**
	 * <p><code>highlighterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the pickTime's autocomplete highlighter. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul></div>
	 */
	public String getHighlighterType() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.highlighterType, null);
	}

	/**
	 * <p><code>highlighterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the pickTime's autocomplete highlighter. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul></div>
	 */
	public void setHighlighterType(String highlighterType) {
		getStateHelper().put(InputTimePropertyKeys.highlighterType, highlighterType);
	}

	/**
	 * <p><code>maxResults</code> attribute description:</p>
	 *
	 * <div>The maximum amount of autoComplete results.</div>
	 */
	public Integer getMaxResults() {
		return (Integer) getStateHelper().eval(InputTimePropertyKeys.maxResults, null);
	}

	/**
	 * <p><code>maxResults</code> attribute description:</p>
	 *
	 * <div>The maximum amount of autoComplete results.</div>
	 */
	public void setMaxResults(Integer maxResults) {
		getStateHelper().put(InputTimePropertyKeys.maxResults, maxResults);
	}

	/**
	 * <p><code>maxTime</code> attribute description:</p>
	 *
	 * <div>The maximum time that can be selected by the user. <code>maxTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.</div>
	 */
	public String getMaxTime() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.maxTime, "23:59:59");
	}

	/**
	 * <p><code>maxTime</code> attribute description:</p>
	 *
	 * <div>The maximum time that can be selected by the user. <code>maxTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.</div>
	 */
	public void setMaxTime(String maxTime) {
		getStateHelper().put(InputTimePropertyKeys.maxTime, maxTime);
	}

	/**
	 * <p><code>minTime</code> attribute description:</p>
	 *
	 * <div>The minimum time that can be selected by the user. <code>minTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.</div>
	 */
	public String getMinTime() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.minTime, "00:00:00");
	}

	/**
	 * <p><code>minTime</code> attribute description:</p>
	 *
	 * <div>The minimum time that can be selected by the user. <code>minTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.</div>
	 */
	public void setMinTime(String minTime) {
		getStateHelper().put(InputTimePropertyKeys.minTime, minTime);
	}

	/**
	 * <p><code>nativeWhenMobile</code> attribute description:</p>
	 *
	 * <div>When true, the component will render an HTML5 <code>&lt;input type="time" /&gt;</code> element on small/mobile displays in order to enable selection of a time with the mobile device's native UI.</div>
	 */
	public boolean isNativeWhenMobile() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.nativeWhenMobile, true);
	}

	/**
	 * <p><code>nativeWhenMobile</code> attribute description:</p>
	 *
	 * <div>When true, the component will render an HTML5 <code>&lt;input type="time" /&gt;</code> element on small/mobile displays in order to enable selection of a time with the mobile device's native UI.</div>
	 */
	public void setNativeWhenMobile(boolean nativeWhenMobile) {
		getStateHelper().put(InputTimePropertyKeys.nativeWhenMobile, nativeWhenMobile);
	}

	/**
	 * <p><code>pattern</code> attribute description:</p>
	 *
	 * <div>The format of the time that corresponds to patterns described in the javadoc for <code>java.text.SimpleDateFormat</code>.</div>
	 */
	public String getPattern() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.pattern, "hh:mm a");
	}

	/**
	 * <p><code>pattern</code> attribute description:</p>
	 *
	 * <div>The format of the time that corresponds to patterns described in the javadoc for <code>java.text.SimpleDateFormat</code>.</div>
	 */
	public void setPattern(String pattern) {
		getStateHelper().put(InputTimePropertyKeys.pattern, pattern);
	}

	/**
	 * <p><code>queryDelay</code> attribute description:</p>
	 *
	 * <div>The delay in milliseconds before a query occurs. After the <code>autoComplete</code> receives input, it waits the specified number of milliseconds before querying it's source. If input occurs before the specified number of milliseconds has elapsed, the timer is reset.</div>
	 */
	public Integer getQueryDelay() {
		return (Integer) getStateHelper().eval(InputTimePropertyKeys.queryDelay, null);
	}

	/**
	 * <p><code>queryDelay</code> attribute description:</p>
	 *
	 * <div>The delay in milliseconds before a query occurs. After the <code>autoComplete</code> receives input, it waits the specified number of milliseconds before querying it's source. If input occurs before the specified number of milliseconds has elapsed, the timer is reset.</div>
	 */
	public void setQueryDelay(Integer queryDelay) {
		getStateHelper().put(InputTimePropertyKeys.queryDelay, queryDelay);
	}

	/**
	 * <p><code>scrollIntoView</code> attribute description:</p>
	 *
	 * <div>When true, if the active option of the autoComplete is not in view, the view will be scrolled to make the active option is displayed to the user.</div>
	 */
	public Boolean getScrollIntoView() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.scrollIntoView, null);
	}

	/**
	 * <p><code>scrollIntoView</code> attribute description:</p>
	 *
	 * <div>When true, if the active option of the autoComplete is not in view, the view will be scrolled to make the active option is displayed to the user.</div>
	 */
	public void setScrollIntoView(Boolean scrollIntoView) {
		getStateHelper().put(InputTimePropertyKeys.scrollIntoView, scrollIntoView);
	}

	/**
	 * <p><code>step</code> attribute description:</p>
	 *
	 * <div>The step in seconds between each selectable timestamp. The default value is 3,600 seconds (or 1 hour).</div>
	 */
	public Integer getStep() {
		return (Integer) getStateHelper().eval(InputTimePropertyKeys.step, 3600);
	}

	/**
	 * <p><code>step</code> attribute description:</p>
	 *
	 * <div>The step in seconds between each selectable timestamp. The default value is 3,600 seconds (or 1 hour).</div>
	 */
	public void setStep(Integer step) {
		getStateHelper().put(InputTimePropertyKeys.step, step);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-input-time", "form-inline");
	}
}
//J+
