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
package com.liferay.faces.alloy.component.inputdatetime;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.inputtext.InputTextBase;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputDateTimeBase extends InputTextBase implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.inputdatetime.InputDateTime";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.inputdatetime.InputDateTimeRenderer";

	// Protected Enumerations
	protected enum InputDateTimePropertyKeys {
		autoHide,
		clientKey,
		locale,
		nativeWhenMobile,
		showOn,
		timeZone,
		zIndex
	}

	public InputDateTimeBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <code>autoHide</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will hide when an item is selected. The default value is <code>true</code>.
	 */
	public Boolean getAutoHide() {
		return (Boolean) getStateHelper().eval(InputDateTimePropertyKeys.autoHide, null);
	}

	/**
	 * <code>autoHide</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will hide when an item is selected. The default value is <code>true</code>.
	 */
	public void setAutoHide(Boolean autoHide) {
		getStateHelper().put(InputDateTimePropertyKeys.autoHide, autoHide);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	public String getClientKey() {
		return (String) getStateHelper().eval(InputDateTimePropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	public void setClientKey(String clientKey) {
		getStateHelper().put(InputDateTimePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>locale</code> attribute description:
	 * <br /><br />
	 * The locale of the component which can be of type <code>java.lang.String</code> or <code>java.util.Locale</code>.
	 */
	public Object getLocale() {
		return (Object) getStateHelper().eval(InputDateTimePropertyKeys.locale, null);
	}

	/**
	 * <code>locale</code> attribute description:
	 * <br /><br />
	 * The locale of the component which can be of type <code>java.lang.String</code> or <code>java.util.Locale</code>.
	 */
	public void setLocale(Object locale) {
		getStateHelper().put(InputDateTimePropertyKeys.locale, locale);
	}

	/**
	 * <code>nativeWhenMobile</code> attribute description:
	 * <br /><br />
	 * When true, the component will render an HTML5 <code>&lt;input type="date" /&gt;</code> element on small/mobile displays in order to enable selection of a date with the mobile device's native UI.
	 */
	public boolean isNativeWhenMobile() {
		return (Boolean) getStateHelper().eval(InputDateTimePropertyKeys.nativeWhenMobile, true);
	}

	/**
	 * <code>nativeWhenMobile</code> attribute description:
	 * <br /><br />
	 * When true, the component will render an HTML5 <code>&lt;input type="date" /&gt;</code> element on small/mobile displays in order to enable selection of a date with the mobile device's native UI.
	 */
	public void setNativeWhenMobile(boolean nativeWhenMobile) {
		getStateHelper().put(InputDateTimePropertyKeys.nativeWhenMobile, nativeWhenMobile);
	}

	/**
	 * <code>showOn</code> attribute description:
	 * <br /><br />
	 * Specifies which event will pop up the picker. Valid values are <code>"focus"</code> (the default), <code>"button"</code>, and <code>"both"</code>.
	 */
	public String getShowOn() {
		return (String) getStateHelper().eval(InputDateTimePropertyKeys.showOn, "focus");
	}

	/**
	 * <code>showOn</code> attribute description:
	 * <br /><br />
	 * Specifies which event will pop up the picker. Valid values are <code>"focus"</code> (the default), <code>"button"</code>, and <code>"both"</code>.
	 */
	public void setShowOn(String showOn) {
		getStateHelper().put(InputDateTimePropertyKeys.showOn, showOn);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-input-date-time");
	}

	/**
	 * <code>timeZone</code> attribute description:
	 * <br /><br />
	 * The time zone of the component.
	 */
	public String getTimeZone() {
		return (String) getStateHelper().eval(InputDateTimePropertyKeys.timeZone, "Greenwich");
	}

	/**
	 * <code>timeZone</code> attribute description:
	 * <br /><br />
	 * The time zone of the component.
	 */
	public void setTimeZone(String timeZone) {
		getStateHelper().put(InputDateTimePropertyKeys.timeZone, timeZone);
	}

	/**
	 * <code>zIndex</code> attribute description:
	 * <br /><br />
	 * Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.
	 */
	public Integer getzIndex() {
		return (Integer) getStateHelper().eval(InputDateTimePropertyKeys.zIndex, null);
	}

	/**
	 * <code>zIndex</code> attribute description:
	 * <br /><br />
	 * Specifies the stack order of the component. The default value is a constant from the Liferay.zIndex JavaScript object.
	 */
	public void setzIndex(Integer zIndex) {
		getStateHelper().put(InputDateTimePropertyKeys.zIndex, zIndex);
	}
}
//J+
