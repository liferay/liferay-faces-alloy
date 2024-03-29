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
package com.liferay.faces.alloy.component.icon.internal;

import java.io.IOException;

import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.icon.Icon;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Kyle Stiemann
 */
@FacesRenderer(componentFamily = Icon.COMPONENT_FAMILY, rendererType = Icon.RENDERER_TYPE)
@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui-css/css/bootstrap.min.css")
public class IconRenderer extends IconRendererBase {

	// Private Constants
	private static final String ICON_CLASS_PREFIX = "glyphicon glyphicon-";

	@Override
	public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.startElement("span", uiComponent);

		String clientId = uiComponent.getClientId(facesContext);
		responseWriter.writeAttribute("id", clientId, "id");

		Icon icon = (Icon) uiComponent;

		String name = icon.getName();

		if (name != null) {
			name = ICON_CLASS_PREFIX + name;
		}

		String color = icon.getColor();

		if (color != null) {
			color = ICON_CLASS_PREFIX + color;
		}

		RendererUtil.encodeStyleable(responseWriter, icon, name, color);
	}

	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.endElement("span");
	}
}
