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
package com.liferay.faces.alloy.component.commandlink.internal;

import jakarta.faces.application.ResourceDependency;
import jakarta.faces.component.behavior.AjaxBehavior;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.event.ComponentSystemEventListener;
import jakarta.faces.event.ListenerFor;
import jakarta.faces.event.ListenersFor;
import jakarta.faces.event.PostAddToViewEvent;
import jakarta.faces.event.PreRenderComponentEvent;
import jakarta.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.commandlink.CommandLink;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Vernon Singleton
 * @author  Neil Griffin
 */

//J-
@FacesRenderer(componentFamily = CommandLink.COMPONENT_FAMILY, rendererType = CommandLink.RENDERER_TYPE)
@ListenersFor({
	@ListenerFor(systemEventClass = PostAddToViewEvent.class, sourceClass = CommandLink.class),
	@ListenerFor(systemEventClass = PreRenderComponentEvent.class, sourceClass = CommandLink.class)
})
@ResourceDependency(library = "jakarta.faces", name = "jsf.js")
//J+
public class CommandLinkRenderer extends CommandLinkRendererBase implements ComponentSystemEventListener {

	@Override
	public void processEvent(ComponentSystemEvent componentSystemEvent) throws AbortProcessingException {

		CommandLink commandLink = (CommandLink) componentSystemEvent.getComponent();

		// If the specified event indicates that the command link was added to the component tree, then
		if (componentSystemEvent instanceof PostAddToViewEvent) {

			// Add the default Ajax behavior in order to support the ajax attribute. This effectively simulates the
			// presence of a child f:ajax tag.
			RendererUtil.addDefaultAjaxBehavior(commandLink, commandLink.getExecute(), commandLink.getProcess(), "@all",
				commandLink.getRender(), commandLink.getUpdate(), "@none");
		}

		// Otherwise, the specified event indicates that the command link is about to be rendered. If the ajax
		// attribute is true, then ensure that the AjaxBehavior is rendered. Otherwise, ensure that the AjaxBehavior is
		// not rendered.
		else {

			AjaxBehavior ajaxBehavior = RendererUtil.getDefaultAjaxBehavior(commandLink);
			ajaxBehavior.setDisabled(!commandLink.isAjax());
		}
	}
}
