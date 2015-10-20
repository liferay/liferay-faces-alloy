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
	 * <code>ajax</code> attribute description:
	 * <br /><br />
	 * When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.
	 */
	public boolean isAjax() {
		return (Boolean) getStateHelper().eval(CommandButtonPropertyKeys.ajax, true);
	}

	/**
	 * <code>ajax</code> attribute description:
	 * <br /><br />
	 * When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.
	 */
	public void setAjax(boolean ajax) {
		getStateHelper().put(CommandButtonPropertyKeys.ajax, ajax);
	}

	/**
	 * <code>autofocus</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying whether or not the component should automatically recieve focus on the initial page load.
	 */
	public Boolean getAutofocus() {
		return (Boolean) getStateHelper().eval(CommandButtonPropertyKeys.autofocus, null);
	}

	/**
	 * <code>autofocus</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying whether or not the component should automatically recieve focus on the initial page load.
	 */
	public void setAutofocus(Boolean autofocus) {
		getStateHelper().put(CommandButtonPropertyKeys.autofocus, autofocus);
	}

	/**
	 * <code>disabled</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be disabled, and the user will be unable to interact with the component.
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(CommandButtonPropertyKeys.disabled, false);
	}

	/**
	 * <code>disabled</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be disabled, and the user will be unable to interact with the component.
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(CommandButtonPropertyKeys.disabled, disabled);
	}

	/**
	 * <code>execute</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.
	 */
	public String getExecute() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.execute, "@all");
	}

	/**
	 * <code>execute</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.
	 */
	public void setExecute(String execute) {
		getStateHelper().put(CommandButtonPropertyKeys.execute, execute);
	}

	/**
	 * <code>process</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.
	 */
	public String getProcess() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.process, getExecute());
	}

	/**
	 * <code>process</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.
	 */
	public void setProcess(String process) {
		getStateHelper().put(CommandButtonPropertyKeys.process, process);
	}

	/**
	 * <code>render</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.
	 */
	public String getRender() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.render, "@none");
	}

	/**
	 * <code>render</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>.
	 */
	public void setRender(String render) {
		getStateHelper().put(CommandButtonPropertyKeys.render, render);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(CommandButtonPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(CommandButtonPropertyKeys.styleClass, "btn-default");

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-command-button");
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(CommandButtonPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <code>type</code> attribute description:
	 * <br /><br />
	 * The type of the button: button, submit (default), or reset.
	 */
	public String getType() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.type, null);
	}

	/**
	 * <code>type</code> attribute description:
	 * <br /><br />
	 * The type of the button: button, submit (default), or reset.
	 */
	public void setType(String type) {
		getStateHelper().put(CommandButtonPropertyKeys.type, type);
	}

	/**
	 * <code>update</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.
	 */
	public String getUpdate() {
		return (String) getStateHelper().eval(CommandButtonPropertyKeys.update, getRender());
	}

	/**
	 * <code>update</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.
	 */
	public void setUpdate(String update) {
		getStateHelper().put(CommandButtonPropertyKeys.update, update);
	}
}
//J+
