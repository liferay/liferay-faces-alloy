/**
 * Copyright (c) 2000-2025 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.selectthumbrating.internal;

import jakarta.faces.application.ResourceDependencies;
import jakarta.faces.application.ResourceDependency;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.selectstarrating.internal.SelectStarRatingRenderer;
import com.liferay.faces.alloy.component.selectthumbrating.SelectThumbRating;


/**
 * @author  Vernon Singleton
 */

//J-
@FacesRenderer(componentFamily = SelectThumbRating.COMPONENT_FAMILY, rendererType = SelectThumbRating.RENDERER_TYPE)
@ResourceDependencies(
	{
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui-css/css/bootstrap.min.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui/aui-min.js"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "liferay.js")
	}
)
//J+
public class SelectThumbRatingRenderer extends SelectStarRatingRenderer {

	// Private Constants
	private static final String THUMBRATING_CLASS_NAME = "ThumbRating";

	@Override
	public String getAlloyClassName(FacesContext facesContext, UIComponent uiCompnent) {
		return THUMBRATING_CLASS_NAME;
	}
}
