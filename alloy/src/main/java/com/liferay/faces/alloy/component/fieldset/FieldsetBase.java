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
	 * <code>disabled</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be disabled, and the user will be unable to interact with the component.
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(FieldsetPropertyKeys.disabled, false);
	}

	/**
	 * <code>disabled</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be disabled, and the user will be unable to interact with the component.
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(FieldsetPropertyKeys.disabled, disabled);
	}

	/**
	 * <code>legend</code> attribute description:
	 * <br /><br />
	 * The text value for the rendered &lt;legend&gt; element.
	 */
	public String getLegend() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.legend, null);
	}

	/**
	 * <code>legend</code> attribute description:
	 * <br /><br />
	 * The text value for the rendered &lt;legend&gt; element.
	 */
	public void setLegend(String legend) {
		getStateHelper().put(FieldsetPropertyKeys.legend, legend);
	}

	/**
	 * <code>onclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when this component is clicked.
	 */
	public String getOnclick() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onclick, null);
	}

	/**
	 * <code>onclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when this component is clicked.
	 */
	public void setOnclick(String onclick) {
		getStateHelper().put(FieldsetPropertyKeys.onclick, onclick);
	}

	/**
	 * <code>ondblclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a double click event occurs.
	 */
	public String getOndblclick() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.ondblclick, null);
	}

	/**
	 * <code>ondblclick</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a double click event occurs.
	 */
	public void setOndblclick(String ondblclick) {
		getStateHelper().put(FieldsetPropertyKeys.ondblclick, ondblclick);
	}

	/**
	 * <code>onkeydown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keydown event occurs.
	 */
	public String getOnkeydown() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onkeydown, null);
	}

	/**
	 * <code>onkeydown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keydown event occurs.
	 */
	public void setOnkeydown(String onkeydown) {
		getStateHelper().put(FieldsetPropertyKeys.onkeydown, onkeydown);
	}

	/**
	 * <code>onkeypress</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keypress event occurs.
	 */
	public String getOnkeypress() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onkeypress, null);
	}

	/**
	 * <code>onkeypress</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keypress event occurs.
	 */
	public void setOnkeypress(String onkeypress) {
		getStateHelper().put(FieldsetPropertyKeys.onkeypress, onkeypress);
	}

	/**
	 * <code>onkeyup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keyup event occurs.
	 */
	public String getOnkeyup() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onkeyup, null);
	}

	/**
	 * <code>onkeyup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a keyup event occurs.
	 */
	public void setOnkeyup(String onkeyup) {
		getStateHelper().put(FieldsetPropertyKeys.onkeyup, onkeyup);
	}

	/**
	 * <code>onmousedown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousedown event occurs.
	 */
	public String getOnmousedown() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmousedown, null);
	}

	/**
	 * <code>onmousedown</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousedown event occurs.
	 */
	public void setOnmousedown(String onmousedown) {
		getStateHelper().put(FieldsetPropertyKeys.onmousedown, onmousedown);
	}

	/**
	 * <code>onmousemove</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousemove event occurs.
	 */
	public String getOnmousemove() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmousemove, null);
	}

	/**
	 * <code>onmousemove</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mousemove event occurs.
	 */
	public void setOnmousemove(String onmousemove) {
		getStateHelper().put(FieldsetPropertyKeys.onmousemove, onmousemove);
	}

	/**
	 * <code>onmouseout</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseout event occurs.
	 */
	public String getOnmouseout() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmouseout, null);
	}

	/**
	 * <code>onmouseout</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseout event occurs.
	 */
	public void setOnmouseout(String onmouseout) {
		getStateHelper().put(FieldsetPropertyKeys.onmouseout, onmouseout);
	}

	/**
	 * <code>onmouseover</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseover event occurs.
	 */
	public String getOnmouseover() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmouseover, null);
	}

	/**
	 * <code>onmouseover</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseover event occurs.
	 */
	public void setOnmouseover(String onmouseover) {
		getStateHelper().put(FieldsetPropertyKeys.onmouseover, onmouseover);
	}

	/**
	 * <code>onmouseup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseup event occurs.
	 */
	public String getOnmouseup() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.onmouseup, null);
	}

	/**
	 * <code>onmouseup</code> attribute description:
	 * <br /><br />
	 * Javascript to execute when a mouseup event occurs.
	 */
	public void setOnmouseup(String onmouseup) {
		getStateHelper().put(FieldsetPropertyKeys.onmouseup, onmouseup);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(FieldsetPropertyKeys.style, null);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(FieldsetPropertyKeys.style, style);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(FieldsetPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(FieldsetPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-fieldset", "fieldset");
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(FieldsetPropertyKeys.styleClass, styleClass);
	}
}
//J+
