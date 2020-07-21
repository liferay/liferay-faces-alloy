/**
 * Copyright (c) 2000-2020 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.fieldset;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIPanel;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class FieldsetBase extends UIPanel implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.fieldset.Fieldset";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.fieldset.FieldsetRenderer";

	// Protected Enumerations
	protected enum FieldsetPropertyKeys {
		disabled,
		legend,
		onclick,
		ondblclick,
		onkeydown,
		onkeypress,
		onkeyup,
		onmousedown,
		onmousemove,
		onmouseout,
		onmouseover,
		onmouseup,
		style,
		styleClass
	}

	public FieldsetBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>disabled</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be disabled, and the user will be unable to interact with the component.</div>
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(FieldsetPropertyKeys.disabled, false);
	}

	/**
	 * <p><code>disabled</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be disabled, and the user will be unable to interact with the component.</div>
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(FieldsetPropertyKeys.disabled, disabled);
	}

	/**
	 * <p><code>legend</code> attribute description:</p>
	 *
	 * <div>The text value for the rendered &lt;legend&gt; element.</div>
	 */
	public String getLegend() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.legend, null);
	}

	/**
	 * <p><code>legend</code> attribute description:</p>
	 *
	 * <div>The text value for the rendered &lt;legend&gt; element.</div>
	 */
	public void setLegend(String legend) {
		getStateHelper().put(FieldsetPropertyKeys.legend, legend);
	}

	/**
	 * <p><code>onclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when this component is clicked.</div>
	 */
	public String getOnclick() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onclick, null);
	}

	/**
	 * <p><code>onclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when this component is clicked.</div>
	 */
	public void setOnclick(String onclick) {
		getStateHelper().put(FieldsetPropertyKeys.onclick, onclick);
	}

	/**
	 * <p><code>ondblclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a double click event occurs.</div>
	 */
	public String getOndblclick() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.ondblclick, null);
	}

	/**
	 * <p><code>ondblclick</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a double click event occurs.</div>
	 */
	public void setOndblclick(String ondblclick) {
		getStateHelper().put(FieldsetPropertyKeys.ondblclick, ondblclick);
	}

	/**
	 * <p><code>onkeydown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keydown event occurs.</div>
	 */
	public String getOnkeydown() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onkeydown, null);
	}

	/**
	 * <p><code>onkeydown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keydown event occurs.</div>
	 */
	public void setOnkeydown(String onkeydown) {
		getStateHelper().put(FieldsetPropertyKeys.onkeydown, onkeydown);
	}

	/**
	 * <p><code>onkeypress</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keypress event occurs.</div>
	 */
	public String getOnkeypress() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onkeypress, null);
	}

	/**
	 * <p><code>onkeypress</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keypress event occurs.</div>
	 */
	public void setOnkeypress(String onkeypress) {
		getStateHelper().put(FieldsetPropertyKeys.onkeypress, onkeypress);
	}

	/**
	 * <p><code>onkeyup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keyup event occurs.</div>
	 */
	public String getOnkeyup() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onkeyup, null);
	}

	/**
	 * <p><code>onkeyup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a keyup event occurs.</div>
	 */
	public void setOnkeyup(String onkeyup) {
		getStateHelper().put(FieldsetPropertyKeys.onkeyup, onkeyup);
	}

	/**
	 * <p><code>onmousedown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousedown event occurs.</div>
	 */
	public String getOnmousedown() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmousedown, null);
	}

	/**
	 * <p><code>onmousedown</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousedown event occurs.</div>
	 */
	public void setOnmousedown(String onmousedown) {
		getStateHelper().put(FieldsetPropertyKeys.onmousedown, onmousedown);
	}

	/**
	 * <p><code>onmousemove</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousemove event occurs.</div>
	 */
	public String getOnmousemove() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmousemove, null);
	}

	/**
	 * <p><code>onmousemove</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mousemove event occurs.</div>
	 */
	public void setOnmousemove(String onmousemove) {
		getStateHelper().put(FieldsetPropertyKeys.onmousemove, onmousemove);
	}

	/**
	 * <p><code>onmouseout</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseout event occurs.</div>
	 */
	public String getOnmouseout() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmouseout, null);
	}

	/**
	 * <p><code>onmouseout</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseout event occurs.</div>
	 */
	public void setOnmouseout(String onmouseout) {
		getStateHelper().put(FieldsetPropertyKeys.onmouseout, onmouseout);
	}

	/**
	 * <p><code>onmouseover</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseover event occurs.</div>
	 */
	public String getOnmouseover() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmouseover, null);
	}

	/**
	 * <p><code>onmouseover</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseover event occurs.</div>
	 */
	public void setOnmouseover(String onmouseover) {
		getStateHelper().put(FieldsetPropertyKeys.onmouseover, onmouseover);
	}

	/**
	 * <p><code>onmouseup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseup event occurs.</div>
	 */
	public String getOnmouseup() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmouseup, null);
	}

	/**
	 * <p><code>onmouseup</code> attribute description:</p>
	 *
	 * <div>Javascript to execute when a mouseup event occurs.</div>
	 */
	public void setOnmouseup(String onmouseup) {
		getStateHelper().put(FieldsetPropertyKeys.onmouseup, onmouseup);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.style, null);
	}

	/**
	 * <p><code>style</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying the css style of the element.</div>
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(FieldsetPropertyKeys.style, style);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(FieldsetPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(FieldsetPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-fieldset", "fieldset");
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(FieldsetPropertyKeys.styleClass, styleClass);
	}
}
//J+
