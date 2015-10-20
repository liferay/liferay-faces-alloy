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
	 * <code>library</code> attribute description:
	 * <br /><br />
	 * The name of the library which contains the resource.
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.library, null);
	}

	/**
	 * <code>library</code> attribute description:
	 * <br /><br />
	 * The name of the library which contains the resource.
	 */
	public void setLibrary(String library) {
		getStateHelper().put(OutputScriptPropertyKeys.library, library);
	}

	/**
	 * <code>name</code> attribute description:
	 * <br /><br />
	 * The name of the resource file to be included on the page.
	 */
	public String getName() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.name, null);
	}

	/**
	 * <code>name</code> attribute description:
	 * <br /><br />
	 * The name of the resource file to be included on the page.
	 */
	public void setName(String name) {
		getStateHelper().put(OutputScriptPropertyKeys.name, name);
	}

	/**
	 * <code>target</code> attribute description:
	 * <br /><br />
	 * The position on the page where the JavaScript should be rendered. Valid values include <code>body</code>, <code>form</code>, and <code>head</code>. The default value of this attribute is an empty (null) value which causes the <code>&lt;script&gt;</code> to be rendered inline (corresponding to its position in the view). Specifying <code>body</code> for the target attribute will cause the <code>&lt;script&gt;</code> to be rendered as close to the closing body tag as possible.
	 */
	public String getTarget() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.target, null);
	}

	/**
	 * <code>target</code> attribute description:
	 * <br /><br />
	 * The position on the page where the JavaScript should be rendered. Valid values include <code>body</code>, <code>form</code>, and <code>head</code>. The default value of this attribute is an empty (null) value which causes the <code>&lt;script&gt;</code> to be rendered inline (corresponding to its position in the view). Specifying <code>body</code> for the target attribute will cause the <code>&lt;script&gt;</code> to be rendered as close to the closing body tag as possible.
	 */
	public void setTarget(String target) {
		getStateHelper().put(OutputScriptPropertyKeys.target, target);
	}

	/**
	 * <code>use</code> attribute description:
	 * <br /><br />
	 * A comma-delimited list of YUI or AlloyUI modules to load for this script. <strong>Note:</strong> if this attribute is specified, a YUI sandbox will be created automatically for the <code>&lt;script&gt;</code>.
	 */
	public String getUse() {
		return (String) getStateHelper().eval(OutputScriptPropertyKeys.use, null);
	}

	/**
	 * <code>use</code> attribute description:
	 * <br /><br />
	 * A comma-delimited list of YUI or AlloyUI modules to load for this script. <strong>Note:</strong> if this attribute is specified, a YUI sandbox will be created automatically for the <code>&lt;script&gt;</code>.
	 */
	public void setUse(String use) {
		getStateHelper().put(OutputScriptPropertyKeys.use, use);
	}
}
//J+
