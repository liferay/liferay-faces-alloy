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
package com.liferay.faces.alloy.component.inputdatetime.internal;
//J-

import javax.annotation.Generated;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import com.liferay.faces.alloy.render.internal.DelegatingAlloyRendererBase;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputDateTimeRendererBase extends DelegatingAlloyRendererBase {

	// Protected Constants
	protected static final String AUTO_HIDE = "autoHide";
	protected static final String CLIENT_KEY = "clientKey";
	protected static final String LOCALE = "locale";
	protected static final String NATIVE_WHEN_MOBILE = "nativeWhenMobile";
	protected static final String SHOW_ON = "showOn";
	protected static final String TIME_ZONE = "timeZone";
	protected static final String Z_INDEX = "zIndex";

	@Override
	public void decode(FacesContext facesContext, UIComponent uiComponent) {

		super.decode(facesContext, uiComponent);

		UIInput uiInput = (UIInput) uiComponent;
		Object submittedValue = uiInput.getSubmittedValue();

		// FACES-3139 Avoid the possibility of a NullPointerException for custom components
		if (submittedValue == null) {
			uiInput.setSubmittedValue("");
		}
	}
}
//J+
