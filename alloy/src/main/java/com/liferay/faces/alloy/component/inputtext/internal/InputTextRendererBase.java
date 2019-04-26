/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.inputtext.internal;
//J-

import javax.annotation.Generated;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.render.DelegatingRendererBase;

import com.liferay.faces.alloy.component.inputtext.InputText;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputTextRendererBase extends DelegatingRendererBase {

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

	@Override
	public String getDelegateComponentFamily() {
		return InputText.COMPONENT_FAMILY;
	}

	@Override
	public String getDelegateRendererType() {
		return "javax.faces.Text";
	}
}
//J+
