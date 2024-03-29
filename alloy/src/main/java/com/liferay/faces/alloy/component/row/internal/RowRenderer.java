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
package com.liferay.faces.alloy.component.row.internal;

import java.io.IOException;

import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.row.Row;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Kyle Stiemann
 */

//J-
@FacesRenderer(componentFamily = Row.COMPONENT_FAMILY, rendererType = Row.RENDERER_TYPE)
@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui-css/css/bootstrap.min.css")
//J+
public class RowRenderer extends RowRendererBase {

	// Private Constants
	private static final String ROW = "row";

	@Override
	public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.startElement("div", uiComponent);

		String clientId = uiComponent.getClientId(facesContext);
		responseWriter.writeAttribute("id", clientId, null);

		Row row = (Row) uiComponent;
		RendererUtil.encodeStyleable(responseWriter, row, ROW);
	}

	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.endElement("div");
	}
}
