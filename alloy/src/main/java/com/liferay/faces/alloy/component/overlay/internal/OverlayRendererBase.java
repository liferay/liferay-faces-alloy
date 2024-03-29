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
package com.liferay.faces.alloy.component.overlay.internal;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.liferay.faces.alloy.render.internal.DelegatingAlloyRendererBase;
import com.liferay.faces.util.component.ComponentUtil;
import com.liferay.faces.util.render.IdResponseWriter;
import com.liferay.faces.util.render.JavaScriptFragment;


/**
 * @author  Vernon Singleton
 */
public abstract class OverlayRendererBase extends DelegatingAlloyRendererBase implements NamingContainer {

	// Protected Constants
	protected static final String Z_INDEX = "zIndex";
	protected static final String CONTENT_BOX_SUFFIX = "_contentBox";
	protected static final String OVERLAY_BODY_SUFFIX = "_overlayBody";

	protected void encodeOverlayDismissible(ResponseWriter responseWriter, UIComponent overlay, String clientKey)
		throws IOException {

		JavaScriptFragment overlayClientVar = new JavaScriptFragment("Liferay.component('" + clientKey + "')");
		encodeFunctionCall(responseWriter, "LFAI.initOverlayDismissible", 'A', overlayClientVar);
	}

	protected void encodeOverlayHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter,
		UIComponent overlay, boolean first) throws IOException {

		// Encode the "contentBox" Alloy hidden attribute.
		String clientId = overlay.getClientId(facesContext);
		encodeClientId(responseWriter, BOUNDING_BOX, clientId, first);

		String contentBoxClientId = clientId.concat(CONTENT_BOX_SUFFIX);
		encodeClientId(responseWriter, CONTENT_BOX, contentBoxClientId, first);

		first = false;

		// Encode the "headerContent" Alloy hidden attribute.
		Map<String, Object> attributes = overlay.getAttributes();
		String headerText = (String) attributes.get("headerText");

		if (headerText != null) {
			headerText = "<span class=\"alloy-overlay-title\">" + headerText + "</span>";
			encodeString(responseWriter, "headerContent", headerText, first);
		}

		encodeString(responseWriter, "bodyContent", "", first);

		// Encode the "render: true" Alloy hidden attribute.
		encodeWidgetRender(responseWriter, first);

		encodeBoolean(responseWriter, "visible", false, first);
	}

	protected void encodeOverlayJavaScriptCustom(ResponseWriter responseWriter, FacesContext facesContext,
		UIComponent overlay, String clientKey) throws IOException {

		// The outermost <div> (which is the boundingBox) was initially styled with "display:none;" in order to prevent
		// blinking when Alloy's JavaScript attempts to hide the boundingBox. At this point in JavaScript execution,
		// Alloy is done manipulating the DOM and it is necessary to remove the "display:none;" so that the
		// dialog will popup correctly.
		responseWriter.write("A.one('#");

		String clientId = overlay.getClientId(facesContext);
		String escapedBoundingBoxClientId = ComponentUtil.escapeClientId(clientId);
		responseWriter.write(escapedBoundingBoxClientId);
		responseWriter.write("').setStyle('display',null);");

		Map<String, Object> attributes = overlay.getAttributes();
		boolean autoShow = (Boolean) attributes.get("autoShow");

		if (autoShow) {

			responseWriter.write("Liferay.component('");
			responseWriter.write(clientKey);
			responseWriter.write("').show();");
		}
	}

	protected void encodeOverlayMarkupBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {
		encodeOverlayMarkupBegin(facesContext, uiComponent, null);
	}

	protected void encodeOverlayMarkupBegin(FacesContext facesContext, UIComponent uiComponent,
		String contentBoxCSSClasses) throws IOException {

		// NOTE: This is currently only used by Dialog and Popover.

		// Encode the opening boundingBox <div> tag via delegation. Ensure that the "id" attribute is always written so
		// that Alloy's JavaScript will be able to locate the boundingBox in the DOM.
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		String clientId = uiComponent.getClientId(facesContext);
		ResponseWriter idDelegationResponseWriter = new IdResponseWriter(responseWriter, "div", clientId);
		super.encodeMarkupBegin(facesContext, uiComponent, idDelegationResponseWriter);

		// Encode the opening contentBox <div> tag with a unique id.
		String contentBoxClientId = clientId.concat(CONTENT_BOX_SUFFIX);
		responseWriter.startElement("div", null);
		responseWriter.writeAttribute("id", contentBoxClientId, null);

		if ((contentBoxCSSClasses != null) && !contentBoxCSSClasses.equals("")) {
			responseWriter.writeAttribute("class", contentBoxCSSClasses, null);
		}

		// Encode the opening overlayBody <div> tag with a unique id.
		String overlayBodyClientId = clientId.concat(OVERLAY_BODY_SUFFIX);
		responseWriter.startElement("div", null);
		responseWriter.writeAttribute("id", overlayBodyClientId, null);
	}

	protected void encodeOverlayMarkupEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// NOTE: This is currently only used by Dialog and Popover.

		// Encode the closing overlayBody </div> tag.
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.endElement("div");

		// Encode the closing contentBox </div> tag.
		responseWriter.endElement("div");

		// Encode the closing boundingBox </div> tag via delegation.
		super.encodeMarkupEnd(facesContext, uiComponent);
	}

	protected void encodeOverlayZIndex(ResponseWriter responseWriter, UIComponent overlay, Integer zIndex,
		String defaultZIndex, boolean first) throws IOException {

		if (zIndex.equals(Integer.MIN_VALUE)) {
			encodeNonEscapedObject(responseWriter, Z_INDEX, defaultZIndex, first);
		}
		else {
			encodeInteger(responseWriter, Z_INDEX, zIndex, first);
		}
	}
}
