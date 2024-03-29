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
package com.liferay.faces.alloy.component.outputstylesheet.internal;

import javax.faces.event.ListenerFor;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.outputstylesheet.OutputStylesheet;


/**
 * @author  Kyle Stiemann
 */

//J-
@FacesRenderer(componentFamily = OutputStylesheet.COMPONENT_FAMILY, rendererType = OutputStylesheet.RENDERER_TYPE)
@ListenerFor(systemEventClass = PostAddToViewEvent.class)
//J+
public class OutputStylesheetRenderer extends OutputStylesheetRendererBase {
	// Initial Generation
}
