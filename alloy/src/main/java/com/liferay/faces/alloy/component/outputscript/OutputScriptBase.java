/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.outputscript;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIOutput;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class OutputScriptBase extends UIOutput {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.outputscript.OutputScript";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.outputscript.OutputScriptRenderer";

	// Protected Enumerations
	protected enum OutputScriptPropertyKeys {
		library,
		name,
		target,
		use
	}

	public OutputScriptBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.library, null);
	}

	/**
	 * <p><code>library</code> attribute description:</p>
	 *
	 * <div>The name of the library which contains the resource.</div>
	 */
	public void setLibrary(String library) {
		getStateHelper().put(OutputScriptPropertyKeys.library, library);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public String getName() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.name, null);
	}

	/**
	 * <p><code>name</code> attribute description:</p>
	 *
	 * <div>The name of the resource file to be included on the page.</div>
	 */
	public void setName(String name) {
		getStateHelper().put(OutputScriptPropertyKeys.name, name);
	}

	/**
	 * <p><code>target</code> attribute description:</p>
	 *
	 * <div>The position on the page where the JavaScript should be rendered. Valid values include <code>body</code>, <code>form</code>, and <code>head</code>. The default value of this attribute is an empty (null) value which causes the <code>&lt;script&gt;</code> to be rendered inline (corresponding to its position in the view). Specifying <code>body</code> for the target attribute will cause the <code>&lt;script&gt;</code> to be rendered as close to the closing body tag as possible.</div>
	 */
	public String getTarget() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.target, null);
	}

	/**
	 * <p><code>target</code> attribute description:</p>
	 *
	 * <div>The position on the page where the JavaScript should be rendered. Valid values include <code>body</code>, <code>form</code>, and <code>head</code>. The default value of this attribute is an empty (null) value which causes the <code>&lt;script&gt;</code> to be rendered inline (corresponding to its position in the view). Specifying <code>body</code> for the target attribute will cause the <code>&lt;script&gt;</code> to be rendered as close to the closing body tag as possible.</div>
	 */
	public void setTarget(String target) {
		getStateHelper().put(OutputScriptPropertyKeys.target, target);
	}

	/**
	 * <p><code>use</code> attribute description:</p>
	 *
	 * <div>A comma-delimited list of YUI or AlloyUI modules to load for this script. <strong>Note:</strong> if this attribute is specified, a YUI sandbox will be created automatically for the <code>&lt;script&gt;</code>.</div>
	 */
	public String getUse() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.use, null);
	}

	/**
	 * <p><code>use</code> attribute description:</p>
	 *
	 * <div>A comma-delimited list of YUI or AlloyUI modules to load for this script. <strong>Note:</strong> if this attribute is specified, a YUI sandbox will be created automatically for the <code>&lt;script&gt;</code>.</div>
	 */
	public void setUse(String use) {
		getStateHelper().put(OutputScriptPropertyKeys.use, use);
	}
}
//J+
