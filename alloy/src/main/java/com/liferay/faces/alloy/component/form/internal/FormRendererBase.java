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
package com.liferay.faces.alloy.component.form.internal;
//J-

import javax.annotation.Generated;

import com.liferay.faces.util.render.DelegatingRendererBase;

import com.liferay.faces.alloy.component.form.Form;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class FormRendererBase extends DelegatingRendererBase {

	// Protected Constants
	protected static final String INCLUDE_VIEW_PARAMS = "includeViewParams";

	@Override
	public String getDelegateComponentFamily() {
		return Form.COMPONENT_FAMILY;
	}

	@Override
	public String getDelegateRendererType() {
		return "javax.faces.Form";
	}
}
//J+
