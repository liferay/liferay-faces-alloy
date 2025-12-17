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
package com.liferay.faces.alloy.component.head.internal;

import java.io.IOException;
import java.util.Map;

import jakarta.faces.application.ResourceDependencies;
import jakarta.faces.application.ResourceDependency;
import jakarta.faces.component.UIComponentBase;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.event.ComponentSystemEventListener;
import jakarta.faces.event.ListenerFor;
import jakarta.faces.event.PostAddToViewEvent;
import jakarta.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.head.Head;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;


/**
 * @author  Neil Griffin
 */

//J-
@FacesRenderer(componentFamily = Head.COMPONENT_FAMILY, rendererType = Head.RENDERER_TYPE)
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
@ListenerFor(systemEventClass = PostAddToViewEvent.class, sourceClass = Head.class)
public class HeadRenderer extends HeadRendererBase implements ComponentSystemEventListener {

	@Override
	public void processEvent(ComponentSystemEvent componentSystemEvent) throws AbortProcessingException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		final Product LIFERAY_PORTAL = ProductFactory.getProductInstance(externalContext, Product.Name.LIFERAY_PORTAL);

		// If Liferay Portal is not detected, then encode a meta tag as a child of the head that will cause bootstrap
		// to behave responsively.
		if (!LIFERAY_PORTAL.isDetected()) {

			UIViewRoot uiViewRoot = facesContext.getViewRoot();
			ResponsiveMetadata responsiveMetadata = new ResponsiveMetadata();
			Map<String, Object> attributes = responsiveMetadata.getAttributes();
			attributes.put("name", ResponsiveMetadata.COMPONENT_FAMILY);
			uiViewRoot.addComponentResource(facesContext, responsiveMetadata);
		}
	}

	public static class ResponsiveMetadata extends UIComponentBase {

		// Private Constants
		private static final String COMPONENT_FAMILY = "com.liferay.faces.alloy.component.internal.responsive.metadata";

		@Override
		public void encodeEnd(FacesContext facesContext) throws IOException {

			ResponseWriter responseWriter = facesContext.getResponseWriter();
			responseWriter.startElement("meta", this);
			responseWriter.writeAttribute("name", "viewport", null);
			responseWriter.writeAttribute("content", "width=device-width,initial-scale=1", null);
			responseWriter.endElement("meta");

			super.encodeEnd(facesContext);
		}

		@Override
		public String getFamily() {
			return COMPONENT_FAMILY;
		}
	}
}
