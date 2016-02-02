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
package com.liferay.faces.alloy.component.dialog.internal;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.dialog.Dialog;
import com.liferay.faces.alloy.render.internal.JavaScriptFragment;
import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.helper.StringHelper;


/**
 * @author  Vernon Singleton
 */
//J-
@FacesRenderer(componentFamily = Dialog.COMPONENT_FAMILY, rendererType = Dialog.RENDERER_TYPE)
@ResourceDependencies(
	{
		@ResourceDependency(library = "liferay-faces-alloy", name = "alloy.css"),
		@ResourceDependency(library = "liferay-faces-alloy", name = "alloy.js"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui-css/css/bootstrap.min.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui/aui-min.js"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "liferay.js")
	}
)
//J+
public class DialogRenderer extends DialogRendererBase {

	@Override
	public void encodeJavaScriptCustom(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();

		Dialog dialog = (Dialog) uiComponent;
		ClientComponent clientComponent = (ClientComponent) uiComponent;
		String clientVarName = getClientVarName(facesContext, clientComponent);
		String clientKey = clientComponent.getClientKey();

		if (clientKey == null) {
			clientKey = clientVarName;
		}

		encodeLiferayComponentVar(responseWriter, "dialog", clientKey);

		// Prevent scrolling when the show() JavaScript function is called.
		responseWriter.write("var ");
		responseWriter.write(clientKey);
		responseWriter.write("_scrollx=window.scrollX;");
		responseWriter.write("var ");
		responseWriter.write(clientKey);
		responseWriter.write("_scrolly=window.scrollY;");
		responseWriter.write("A.Do.before(function(stuff) { ");
		responseWriter.write(clientKey);
		responseWriter.write("_scrollx=window.scrollX; ");
		responseWriter.write(clientKey);
		responseWriter.write("_scrolly=window.scrollY;},Liferay.component('");
		responseWriter.write(clientKey);
		responseWriter.write("'),'show');");
		responseWriter.write("A.Do.after(function(stuff){window.scrollTo(");
		responseWriter.write(clientKey);
		responseWriter.write("_scrollx,");
		responseWriter.write(clientKey);
		responseWriter.write("_scrolly);},Liferay.component('");
		responseWriter.write(clientKey);
		responseWriter.write("'),'show');");

		// FACES-2209 remove class="hide" from the "mask" div that is used for modal dialogs
		// the mask div is placed as the first child of the parent of the dialog
		// removing this class allows a modal dialog to be fully rendered upon a partial request.
		responseWriter.write("var " + clientKey + "_mask=A.one('#");

		String clientId = dialog.getClientId(facesContext);
		String escapedBoundingBoxClientId = escapeClientId(clientId);
		responseWriter.write(escapedBoundingBoxClientId);
		responseWriter.write("').ancestor().one('.hide');");
		responseWriter.write("if (");
		responseWriter.write(clientKey);
		responseWriter.write("_mask) { ");
		responseWriter.write(clientKey);
		responseWriter.write("_mask.removeClass('hide') }; ");

		if (!dialog.isHideIconRendered()) {
			responseWriter.write("dialog.removeToolbar('header');");
		}

		// move the overlayBody div into the modal-body div
		String overlayBodyClientId = clientId.concat(OVERLAY_BODY_SUFFIX);
		String escapedOverlayBodyClientId = escapeClientId(overlayBodyClientId);

		String contentBoxClientId = clientId.concat(CONTENT_BOX_SUFFIX);
		String escapedContentBoxClientId = escapeClientId(contentBoxClientId);

		responseWriter.write("A.one('#");
		responseWriter.write(escapedOverlayBodyClientId);
		responseWriter.write("').appendTo(A.one('div#");
		responseWriter.write(escapedContentBoxClientId);
		responseWriter.write(">div.modal-body'));");

		if (!dialog.isModal() && dialog.isDismissible()) {
			encodeOverlayDismissible(responseWriter, dialog, clientKey);
		}

		JavaScriptFragment dialogJavaScriptFragment = new JavaScriptFragment("dialog");
		encodeFunctionCall(responseWriter, "LFAI.initDialog", dialogJavaScriptFragment);
		encodeOverlayJavaScriptCustom(responseWriter, facesContext, dialog, clientKey);
	}

	@Override
	public void encodeMarkupBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {
		encodeOverlayMarkupBegin(facesContext, uiComponent, "modal-content");
	}

	@Override
	public void encodeMarkupEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {
		encodeOverlayMarkupEnd(facesContext, uiComponent);
	}

	@Override
	protected void encodeHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter, Dialog dialog,
		boolean first) throws IOException {

		// contentBox, headerText, render : true, visible
		encodeOverlayHiddenAttributes(facesContext, responseWriter, dialog, first);
	}

	@Override
	protected void encodeZIndex(ResponseWriter responseWriter, Dialog dialog, Integer zIndex, boolean first)
		throws IOException {
		encodeOverlayZIndex(responseWriter, dialog, zIndex, LIFERAY_Z_INDEX_OVERLAY, first);
	}

	@Override
	protected String[] getModules(FacesContext facesContext, UIComponent uiComponent) {

		String[] modules = MODULES;
		Dialog dialog = (Dialog) uiComponent;

		if (!dialog.isModal() && dialog.isDismissible()) {
			modules = StringHelper.append(modules, "event-move");
		}

		return modules;
	}
}
