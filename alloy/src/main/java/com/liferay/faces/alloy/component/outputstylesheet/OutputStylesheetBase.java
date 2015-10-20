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
package com.liferay.faces.alloy.component.outputstylesheet;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIOutput;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class OutputStylesheetBase extends UIOutput {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.outputstylesheet.OutputStylesheet";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.outputstylesheet.OutputStylesheetRenderer";

	// Protected Enumerations
	protected enum OutputStylesheetPropertyKeys {
		library,
		media,
		name
	}

	public OutputStylesheetBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <code>library</code> attribute description:
	 * <br /><br />
	 * The name of the library which contains the resource.
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(OutputStylesheetPropertyKeys.library, null);
	}

	/**
	 * <code>library</code> attribute description:
	 * <br /><br />
	 * The name of the library which contains the resource.
	 */
	public void setLibrary(String library) {
		getStateHelper().put(OutputStylesheetPropertyKeys.library, library);
	}

	/**
	 * <code>media</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the media type of the element.
	 */
	public String getMedia() {
		return (String) getStateHelper().eval(OutputStylesheetPropertyKeys.media, null);
	}

	/**
	 * <code>media</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the media type of the element.
	 */
	public void setMedia(String media) {
		getStateHelper().put(OutputStylesheetPropertyKeys.media, media);
	}

	/**
	 * <code>name</code> attribute description:
	 * <br /><br />
	 * The name of the resource file to be included on the page.
	 */
	public String getName() {
		return (String) getStateHelper().eval(OutputStylesheetPropertyKeys.name, null);
	}

	/**
	 * <code>name</code> attribute description:
	 * <br /><br />
	 * The name of the resource file to be included on the page.
	 */
	public void setName(String name) {
		getStateHelper().put(OutputStylesheetPropertyKeys.name, name);
	}
}
//J+
