/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.commandbutton;
//J-

import javax.annotation.Generated;
import javax.faces.component.html.HtmlCommandButton;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class CommandButtonBase extends HtmlCommandButton implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.commandbutton.CommandButton";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.commandbutton.CommandButtonRenderer";

	// Protected Enumerations
	protected enum CommandButtonPropertyKeys {
		ajax,
		autofocus,
		disabled,
		execute,
		process,
		render,
		styleClass,
		type,
		update
	}

	public CommandButtonBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>ajax</code> attribute description:</p>
	 *
	 * <div>When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.</div>
	 */
	public boolean isAjax() {
		return (Boolean) getStateHelper().eval(CommandButtonPropertyKeys.ajax, true);
	}

	/**
	 * <p><code>ajax</code> attribute description:</p>
	 *
	 * <div>When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.</div>
	 */
	public void setAjax(boolean ajax) {
		getStateHelper().put(CommandButtonPropertyKeys.ajax, ajax);
	}

	/**
	 * <p><code>autofocus</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying whether or not the component should automatically recieve focus on the initial page load.</div>
	 */
	public Boolean getAutofocus() {
		return (Boolean) getStateHelper().eval(CommandButtonPropertyKeys.autofocus, null);
	}

	/**
	 * <p><code>autofocus</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying whether or not the component should automatically recieve focus on the initial page load.</div>
	 */
	public void setAutofocus(Boolean autofocus) {
		getStateHelper().put(CommandButtonPropertyKeys.autofocus, autofocus);
	}

	/**
	 * <p><code>disabled</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be disabled, and the user will be unable to interact with the component.</div>
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(CommandButtonPropertyKeys.disabled, false);
	}

	/**
	 * <p><code>disabled</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be disabled, and the user will be unable to interact with the component.</div>
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(CommandButtonPropertyKeys.disabled, disabled);
	}

	/**
	 * <p><code>execute</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public String getExecute() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.execute, "@all");
	}

	/**
	 * <p><code>execute</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public void setExecute(String execute) {
		getStateHelper().put(CommandButtonPropertyKeys.execute, execute);
	}

	/**
	 * <p><code>process</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.</div>
	 */
	public String getProcess() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.process, getExecute());
	}

	/**
	 * <p><code>process</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.</div>
	 */
	public void setProcess(String process) {
		getStateHelper().put(CommandButtonPropertyKeys.process, process);
	}

	/**
	 * <p><code>render</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public String getRender() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.render, "@none");
	}

	/**
	 * <p><code>render</code> attribute description:</p>
	 *
	 * <div>Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.</div>
	 */
	public void setRender(String render) {
		getStateHelper().put(CommandButtonPropertyKeys.render, render);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(CommandButtonPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(CommandButtonPropertyKeys.styleClass, "btn-default");

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-command-button");
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(CommandButtonPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <p><code>type</code> attribute description:</p>
	 *
	 * <div>The type of the button: button, submit (default), or reset.</div>
	 */
	public String getType() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.type, null);
	}

	/**
	 * <p><code>type</code> attribute description:</p>
	 *
	 * <div>The type of the button: button, submit (default), or reset.</div>
	 */
	public void setType(String type) {
		getStateHelper().put(CommandButtonPropertyKeys.type, type);
	}

	/**
	 * <p><code>update</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.</div>
	 */
	public String getUpdate() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.update, getRender());
	}

	/**
	 * <p><code>update</code> attribute description:</p>
	 *
	 * <div>Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.</div>
	 */
	public void setUpdate(String update) {
		getStateHelper().put(CommandButtonPropertyKeys.update, update);
	}
}
//J+
