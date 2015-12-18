/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.outputscriptstylesheet.internal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.render.Renderer;

import com.liferay.faces.alloy.component.outputscript.OutputScript;
import com.liferay.faces.util.render.DelegatingRendererBase;


/**
 * @author  Kyle Stiemann
 */
public abstract class OutputScriptStylesheetRendererBase extends DelegatingRendererBase
	implements ComponentSystemEventListener {

	@Override
	public void processEvent(ComponentSystemEvent componentSystemEvent) throws AbortProcessingException {

		UIComponent uiComponent = componentSystemEvent.getComponent();
		boolean outputScriptTargetBody = false;

		if (uiComponent instanceof OutputScript) {

			OutputScript outputScript = (OutputScript) uiComponent;
			String target = outputScript.getTarget();
			outputScriptTargetBody = "body".equals(target);
		}

		FacesContext facesContext = FacesContext.getCurrentInstance();
		boolean ajaxRequest = facesContext.getPartialViewContext().isAjaxRequest();
		Renderer delegateRenderer = getDelegateRenderer(facesContext);

		// If this is an Ajax request or the current component is not an alloy:outputScript with target="body" AND the
		// delegateRenderer is a ComponentSystemEventListener, then ...
		if ((ajaxRequest || !outputScriptTargetBody) && (delegateRenderer instanceof ComponentSystemEventListener)) {

			ComponentSystemEventListener delegateComponentSystemEventListener = (ComponentSystemEventListener)
				delegateRenderer;
			delegateComponentSystemEventListener.processEvent(componentSystemEvent);
		}
	}
}
