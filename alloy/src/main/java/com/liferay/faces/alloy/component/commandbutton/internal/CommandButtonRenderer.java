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
package com.liferay.faces.alloy.component.commandbutton.internal;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.ListenerFor;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.commandbutton.CommandButton;
import com.liferay.faces.alloy.render.internal.AlloyRendererUtil;


/**
 * @author  Kyle Stiemann
 */
//J-
@FacesRenderer(componentFamily = CommandButton.COMPONENT_FAMILY, rendererType = CommandButton.RENDERER_TYPE)
@ListenerFor(systemEventClass = PostAddToViewEvent.class, sourceClass = CommandButton.class)
@ResourceDependencies(
	{
		@ResourceDependency(library = "liferay-faces-alloy", name = "alloy.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui-css/css/bootstrap.min.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui/aui-min.js"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "liferay.js"),
		@ResourceDependency(library = "javax.faces", name = "jsf.js")
	}
)
//J+
public class CommandButtonRenderer extends CommandButtonRendererBase implements ComponentSystemEventListener {

	@Override
	public void processEvent(ComponentSystemEvent componentSystemEvent) throws AbortProcessingException {

		CommandButton commandButton = (CommandButton) componentSystemEvent.getComponent();

		if (commandButton.isAjax()) {
			AlloyRendererUtil.addDefaultAjaxBehavior(commandButton, commandButton.getExecute(),
				commandButton.getProcess(), "@all", commandButton.getRender(), commandButton.getUpdate(), "@none");
		}
	}
}
