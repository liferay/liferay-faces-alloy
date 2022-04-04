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
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(OutputStylesheetPropertyKeys.library, null);
	}

	/**
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public void setLibrary(String library) {
		getStateHelper().put(OutputStylesheetPropertyKeys.library, library);
	}

	/**
	 * <p><code>media</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the media type of the element.</div>
	 */
	public String getMedia() {
		return (String) getStateHelper().eval(OutputStylesheetPropertyKeys.media, null);
	}

	/**
	 * <p><code>media</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the media type of the element.</div>
	 */
	public void setMedia(String media) {
		getStateHelper().put(OutputStylesheetPropertyKeys.media, media);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public String getName() {
		return (String) getStateHelper().eval(OutputStylesheetPropertyKeys.name, null);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public void setName(String name) {
		getStateHelper().put(OutputStylesheetPropertyKeys.name, name);
	}
}
//J+
