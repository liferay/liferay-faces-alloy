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
	 * <code>activateFirstItem</code> attribute description:
	 * <br /><br />
	 * When true, the first item in the list will be activated so that users can press TAB or ENTER to select it.
	 */
	public boolean isActivateFirstItem() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.activateFirstItem, true);
	}

	/**
	 * <code>activateFirstItem</code> attribute description:
	 * <br /><br />
	 * When true, the first item in the list will be activated so that users can press TAB or ENTER to select it.
	 */
	public void setActivateFirstItem(boolean activateFirstItem) {
		getStateHelper().put(InputTimePropertyKeys.activateFirstItem, activateFirstItem);
	}

	/**
	 * <code>circular</code> attribute description:
	 * <br /><br />
	 * When true, the autoComplete list will wrap around allowing users to use keyboard navigation to move from the top of the list to the bottom and vice versa. The default value is <code>true</code>.
	 */
	public Boolean getCircular() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.circular, null);
	}

	/**
	 * <code>circular</code> attribute description:
	 * <br /><br />
	 * When true, the autoComplete list will wrap around allowing users to use keyboard navigation to move from the top of the list to the bottom and vice versa. The default value is <code>true</code>.
	 */
	public void setCircular(Boolean circular) {
		getStateHelper().put(InputTimePropertyKeys.circular, circular);
	}

	/**
	 * <code>filterType</code> attribute description:
	 * <br /><br />
	 * Specifies the type of filter that will be used for the pickTime's autocompletion. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul>
	 */
	public String getFilterType() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.filterType, null);
	}

	/**
	 * <code>filterType</code> attribute description:
	 * <br /><br />
	 * Specifies the type of filter that will be used for the pickTime's autocompletion. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul>
	 */
	public void setFilterType(String filterType) {
		getStateHelper().put(InputTimePropertyKeys.filterType, filterType);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered autoComplete list.
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.height, null);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered autoComplete list.
	 */
	public void setHeight(String height) {
		getStateHelper().put(InputTimePropertyKeys.height, height);
	}

	/**
	 * <code>highlighterType</code> attribute description:
	 * <br /><br />
	 * Specifies the type of filter that will be used for the pickTime's autocomplete highlighter. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul>
	 */
	public String getHighlighterType() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.highlighterType, null);
	}

	/**
	 * <code>highlighterType</code> attribute description:
	 * <br /><br />
	 * Specifies the type of filter that will be used for the pickTime's autocomplete highlighter. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul>
	 */
	public void setHighlighterType(String highlighterType) {
		getStateHelper().put(InputTimePropertyKeys.highlighterType, highlighterType);
	}

	/**
	 * <code>maxResults</code> attribute description:
	 * <br /><br />
	 * The maximum amount of autoComplete results.
	 */
	public Integer getMaxResults() {
		return (Integer) getStateHelper().eval(InputTimePropertyKeys.maxResults, null);
	}

	/**
	 * <code>maxResults</code> attribute description:
	 * <br /><br />
	 * The maximum amount of autoComplete results.
	 */
	public void setMaxResults(Integer maxResults) {
		getStateHelper().put(InputTimePropertyKeys.maxResults, maxResults);
	}

	/**
	 * <code>maxTime</code> attribute description:
	 * <br /><br />
	 * The maximum time that can be selected by the user. <code>maxTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.
	 */
	public String getMaxTime() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.maxTime, "23:59:59");
	}

	/**
	 * <code>maxTime</code> attribute description:
	 * <br /><br />
	 * The maximum time that can be selected by the user. <code>maxTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.
	 */
	public void setMaxTime(String maxTime) {
		getStateHelper().put(InputTimePropertyKeys.maxTime, maxTime);
	}

	/**
	 * <code>minTime</code> attribute description:
	 * <br /><br />
	 * The minimum time that can be selected by the user. <code>minTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.
	 */
	public String getMinTime() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.minTime, "00:00:00");
	}

	/**
	 * <code>minTime</code> attribute description:
	 * <br /><br />
	 * The minimum time that can be selected by the user. <code>minTime</code> can be of type <code>java.lang.String</code> (of the pattern "HH:mm:ss") or <code>java.util.Date</code>.
	 */
	public void setMinTime(String minTime) {
		getStateHelper().put(InputTimePropertyKeys.minTime, minTime);
	}

	/**
	 * <code>nativeWhenMobile</code> attribute description:
	 * <br /><br />
	 * When true, the component will render an HTML5 <code>&lt;input type="time" /&gt;</code> element on small/mobile displays in order to enable selection of a time with the mobile device's native UI.
	 */
	public boolean isNativeWhenMobile() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.nativeWhenMobile, true);
	}

	/**
	 * <code>nativeWhenMobile</code> attribute description:
	 * <br /><br />
	 * When true, the component will render an HTML5 <code>&lt;input type="time" /&gt;</code> element on small/mobile displays in order to enable selection of a time with the mobile device's native UI.
	 */
	public void setNativeWhenMobile(boolean nativeWhenMobile) {
		getStateHelper().put(InputTimePropertyKeys.nativeWhenMobile, nativeWhenMobile);
	}

	/**
	 * <code>pattern</code> attribute description:
	 * <br /><br />
	 * The format of the time that corresponds to patterns described in the javadoc for <code>java.text.SimpleDateFormat</code>.
	 */
	public String getPattern() {
		return (String) getStateHelper().eval(InputTimePropertyKeys.pattern, "hh:mm a");
	}

	/**
	 * <code>pattern</code> attribute description:
	 * <br /><br />
	 * The format of the time that corresponds to patterns described in the javadoc for <code>java.text.SimpleDateFormat</code>.
	 */
	public void setPattern(String pattern) {
		getStateHelper().put(InputTimePropertyKeys.pattern, pattern);
	}

	/**
	 * <code>queryDelay</code> attribute description:
	 * <br /><br />
	 * The delay in milliseconds before a query occurs. After the <code>autoComplete</code> receives input, it waits the specified number of milliseconds before querying it's source. If input occurs before the specified number of milliseconds has elapsed, the timer is reset.
	 */
	public Integer getQueryDelay() {
		return (Integer) getStateHelper().eval(InputTimePropertyKeys.queryDelay, null);
	}

	/**
	 * <code>queryDelay</code> attribute description:
	 * <br /><br />
	 * The delay in milliseconds before a query occurs. After the <code>autoComplete</code> receives input, it waits the specified number of milliseconds before querying it's source. If input occurs before the specified number of milliseconds has elapsed, the timer is reset.
	 */
	public void setQueryDelay(Integer queryDelay) {
		getStateHelper().put(InputTimePropertyKeys.queryDelay, queryDelay);
	}

	/**
	 * <code>scrollIntoView</code> attribute description:
	 * <br /><br />
	 * When true, if the active option of the autoComplete is not in view, the view will be scrolled to make the active option is displayed to the user.
	 */
	public Boolean getScrollIntoView() {
		return (Boolean) getStateHelper().eval(InputTimePropertyKeys.scrollIntoView, null);
	}

	/**
	 * <code>scrollIntoView</code> attribute description:
	 * <br /><br />
	 * When true, if the active option of the autoComplete is not in view, the view will be scrolled to make the active option is displayed to the user.
	 */
	public void setScrollIntoView(Boolean scrollIntoView) {
		getStateHelper().put(InputTimePropertyKeys.scrollIntoView, scrollIntoView);
	}

	/**
	 * <code>step</code> attribute description:
	 * <br /><br />
	 * The step in seconds between each selectable timestamp. The default value is 3,600 seconds (or 1 hour).
	 */
	public Integer getStep() {
		return (Integer) getStateHelper().eval(InputTimePropertyKeys.step, 3600);
	}

	/**
	 * <code>step</code> attribute description:
	 * <br /><br />
	 * The step in seconds between each selectable timestamp. The default value is 3,600 seconds (or 1 hour).
	 */
	public void setStep(Integer step) {
		getStateHelper().put(InputTimePropertyKeys.step, step);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-input-time", "form-inline");
	}
}
//J+
