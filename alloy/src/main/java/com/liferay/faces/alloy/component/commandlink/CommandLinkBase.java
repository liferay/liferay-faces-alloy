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
package com.liferay.faces.alloy.component.commandlink;
//J-

import javax.annotation.Generated;
import javax.faces.component.html.HtmlCommandLink;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class CommandLinkBase extends HtmlCommandLink implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.commandlink.CommandLink";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.commandlink.CommandLinkRenderer";

	// Protected Enumerations
	protected enum CommandLinkPropertyKeys {
		ajax,
		execute,
		process,
		render,
		update
	}

	public CommandLinkBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>ajax</code> attribute description:</p>
	 *
	 * <div>When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.</div>
	 */
	public boolean isAjax() {
		return (Boolean) getStateHelper().eval(CommandLinkPropertyKeys.ajax, true);
	}

	/**
	 * <p><code>ajax</code> attribute description:</p>
	 *
	 * <div>When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.</div>
	 */
	public void setAjax(boolean ajax) {
		getStateHelper().put(CommandLinkPropertyKeys.ajax, ajax);
	}

	/**
	 * <p><code>execute</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public String getExecute() {
		return (String) getStateHelper().eval(CommandLinkPropertyKeys.execute, "@all");
	}

	/**
	 * <p><code>execute</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public void setExecute(String execute) {
		getStateHelper().put(CommandLinkPropertyKeys.execute, execute);
	}

	/**
	 * <p><code>process</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.</div>
	 */
	public String getProcess() {
		return (String) getStateHelper().eval(CommandLinkPropertyKeys.process, getExecute());
	}

	/**
	 * <p><code>process</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.</div>
	 */
	public void setProcess(String process) {
		getStateHelper().put(CommandLinkPropertyKeys.process, process);
	}

	/**
	 * <p><code>render</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public String getRender() {
		return (String) getStateHelper().eval(CommandLinkPropertyKeys.render, "@none");
	}

	/**
	 * <p><code>render</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public void setRender(String render) {
		getStateHelper().put(CommandLinkPropertyKeys.render, render);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(PropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(PropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-command-link");
	}

	/**
	 * <p><code>update</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.</div>
	 */
	public String getUpdate() {
		return (String) getStateHelper().eval(CommandLinkPropertyKeys.update, getRender());
	}

	/**
	 * <p><code>update</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.</div>
	 */
	public void setUpdate(String update) {
		getStateHelper().put(CommandLinkPropertyKeys.update, update);
	}
}
//J+
