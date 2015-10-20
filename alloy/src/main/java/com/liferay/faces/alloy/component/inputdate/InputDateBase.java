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
package com.liferay.faces.alloy.component.inputdate;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.inputdatetime.InputDateTime;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputDateBase extends InputDateTime implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.inputdate.InputDate";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.inputdate.InputDateRenderer";

	// Protected Enumerations
	protected enum InputDatePropertyKeys {
		maxDate,
		minDate,
		nativeWhenMobile,
		panes,
		pattern
	}

	public InputDateBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <code>maxDate</code> attribute description:
	 * <br /><br />
	 * The maximum date that can be selected by the user. This attribute can be of type <code>java.lang.String</code> or <code>java.util.Date</code>.
	 */
	public Object getMaxDate() {
		return (Object) getStateHelper().eval(InputDatePropertyKeys.maxDate, null);
	}

	/**
	 * <code>maxDate</code> attribute description:
	 * <br /><br />
	 * The maximum date that can be selected by the user. This attribute can be of type <code>java.lang.String</code> or <code>java.util.Date</code>.
	 */
	public void setMaxDate(Object maxDate) {
		getStateHelper().put(InputDatePropertyKeys.maxDate, maxDate);
	}

	/**
	 * <code>minDate</code> attribute description:
	 * <br /><br />
	 * The minimum date that can be selected by the user. This attribute can be of type <code>java.lang.String</code> or <code>java.util.Date</code>.
	 */
	public Object getMinDate() {
		return (Object) getStateHelper().eval(InputDatePropertyKeys.minDate, null);
	}

	/**
	 * <code>minDate</code> attribute description:
	 * <br /><br />
	 * The minimum date that can be selected by the user. This attribute can be of type <code>java.lang.String</code> or <code>java.util.Date</code>.
	 */
	public void setMinDate(Object minDate) {
		getStateHelper().put(InputDatePropertyKeys.minDate, minDate);
	}

	/**
	 * <code>nativeWhenMobile</code> attribute description:
	 * <br /><br />
	 * When true, the component will render an HTML5 <code>&lt;input type="date" /&gt;</code> element on small/mobile displays in order to enable selection of a date with the mobile device's native UI.
	 */
	public boolean isNativeWhenMobile() {
		return (Boolean) getStateHelper().eval(InputDatePropertyKeys.nativeWhenMobile, true);
	}

	/**
	 * <code>nativeWhenMobile</code> attribute description:
	 * <br /><br />
	 * When true, the component will render an HTML5 <code>&lt;input type="date" /&gt;</code> element on small/mobile displays in order to enable selection of a date with the mobile device's native UI.
	 */
	public void setNativeWhenMobile(boolean nativeWhenMobile) {
		getStateHelper().put(InputDatePropertyKeys.nativeWhenMobile, nativeWhenMobile);
	}

	/**
	 * <code>panes</code> attribute description:
	 * <br /><br />
	 * The number of month panes shown in the popup calendar. Valid values are <code>1</code> (the default), <code>2</code>, and <code>3</code>.
	 */
	public Integer getPanes() {
		return (Integer) getStateHelper().eval(InputDatePropertyKeys.panes, null);
	}

	/**
	 * <code>panes</code> attribute description:
	 * <br /><br />
	 * The number of month panes shown in the popup calendar. Valid values are <code>1</code> (the default), <code>2</code>, and <code>3</code>.
	 */
	public void setPanes(Integer panes) {
		getStateHelper().put(InputDatePropertyKeys.panes, panes);
	}

	/**
	 * <code>pattern</code> attribute description:
	 * <br /><br />
	 * The format of the date that corresponds to patterns described in the javadoc for <code>java.text.SimpleDateFormat</code>.
	 */
	public String getPattern() {
		return (String) getStateHelper().eval(InputDatePropertyKeys.pattern, null);
	}

	/**
	 * <code>pattern</code> attribute description:
	 * <br /><br />
	 * The format of the date that corresponds to patterns described in the javadoc for <code>java.text.SimpleDateFormat</code>.
	 */
	public void setPattern(String pattern) {
		getStateHelper().put(InputDatePropertyKeys.pattern, pattern);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-input-date", "form-inline");
	}
}
//J+
