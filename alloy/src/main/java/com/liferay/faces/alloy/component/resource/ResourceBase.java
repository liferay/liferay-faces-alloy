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
package com.liferay.faces.alloy.component.resource;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIComponentBase;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class ResourceBase extends UIComponentBase {

	// Public Constants
	public static final String COMPONENT_FAMILY = "com.liferay.faces.alloy.component.resource";
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.resource.Resource";

	// Protected Enumerations
	protected enum ResourcePropertyKeys {
		contentType,
		library,
		name
	}

	public ResourceBase() {
		super();
		setRendererType("");
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	/**
	 * <p><code>contentType</code> attribute description:</p>
	 *
	 * <div>The content type of the resource.</div>
	 */
	public String getContentType() {
		return (String) getStateHelper().eval(ResourcePropertyKeys.contentType, null);
	}

	/**
	 * <p><code>contentType</code> attribute description:</p>
	 *
	 * <div>The content type of the resource.</div>
	 */
	public void setContentType(String contentType) {
		getStateHelper().put(ResourcePropertyKeys.contentType, contentType);
	}

	/**
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(ResourcePropertyKeys.library, null);
	}

	/**
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public void setLibrary(String library) {
		getStateHelper().put(ResourcePropertyKeys.library, library);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public String getName() {
		return (String) getStateHelper().eval(ResourcePropertyKeys.name, null);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public void setName(String name) {
		getStateHelper().put(ResourcePropertyKeys.name, name);
	}
}
//J+
