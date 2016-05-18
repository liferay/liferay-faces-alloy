/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.selectrating.internal;
//J-

import java.io.IOException;

import javax.annotation.Generated;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.liferay.faces.alloy.render.internal.DelegatingAlloyRendererBase;

import com.liferay.faces.alloy.component.selectrating.SelectRating;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class SelectRatingRendererBase extends DelegatingAlloyRendererBase {

	// Protected Constants
	protected static final String CLIENT_KEY = "clientKey";

	// Modules
	protected static final String[] MODULES = { "aui-rating" };

	@Override
	public void encodeAlloyAttributes(FacesContext facesContext, ResponseWriter responseWriter, UIComponent uiComponent) throws IOException {

		SelectRating selectRating = (SelectRating) uiComponent;
		boolean first = true;

		encodeHiddenAttributes(facesContext, responseWriter, selectRating, first);
	}

	@Override
	public String getAlloyClassName(FacesContext facesContext, UIComponent uiComponent) {
		return "Rating";
	}

	@Override
	public String[] getModules(FacesContext facesContext, UIComponent uiComponent) {
		return MODULES;
	}

	protected void encodeHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter, SelectRating selectRating, boolean first) throws IOException {
		// no-op
	}

	@Override
	public String getDelegateComponentFamily() {
		return SelectRating.COMPONENT_FAMILY;
	}

	@Override
	public String getDelegateRendererType() {
		return "javax.faces.Radio";
	}
}
//J+
