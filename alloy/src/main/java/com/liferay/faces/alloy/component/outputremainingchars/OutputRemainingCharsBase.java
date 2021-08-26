/**
 * Copyright (c) 2000-2021 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.outputremainingchars;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.outputtext.OutputTextBase;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class OutputRemainingCharsBase extends OutputTextBase implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.outputremainingchars.OutputRemainingChars";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.outputremainingchars.OutputRemainingCharsRenderer";

	// Protected Enumerations
	protected enum OutputRemainingCharsPropertyKeys {
		clientKey,
		for_,
		maxLength,
		onceMaxlengthReached,
		onMaxlengthReached
	}

	public OutputRemainingCharsBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>for</code> attribute description:</p>
	 *
	 * <div>The id of the component for which the remaining characters are to be calculated.</div>
	 */
	public String getFor() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.for_, null);
	}

	/**
	 * <p><code>for</code> attribute description:</p>
	 *
	 * <div>The id of the component for which the remaining characters are to be calculated.</div>
	 */
	public void setFor(String for_) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.for_, for_);
	}

	/**
	 * <p><code>maxLength</code> attribute description:</p>
	 *
	 * <div>The maximum number of charachters to allow in the input.</div>
	 */
	public Integer getMaxLength() {
		return (Integer) getStateHelper().eval(OutputRemainingCharsPropertyKeys.maxLength, null);
	}

	/**
	 * <p><code>maxLength</code> attribute description:</p>
	 *
	 * <div>The maximum number of charachters to allow in the input.</div>
	 */
	public void setMaxLength(Integer maxLength) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.maxLength, maxLength);
	}

	/**
	 * <p><code>onceMaxlengthReached</code> attribute description:</p>
	 *
	 * <div>Node or Selector to display the number of remaining characters calculated by the charCounter.</div>
	 */
	public String getOnceMaxlengthReached() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.onceMaxlengthReached, null);
	}

	/**
	 * <p><code>onceMaxlengthReached</code> attribute description:</p>
	 *
	 * <div>Node or Selector to display the number of remaining characters calculated by the charCounter.</div>
	 */
	public void setOnceMaxlengthReached(String onceMaxlengthReached) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.onceMaxlengthReached, onceMaxlengthReached);
	}

	/**
	 * <p><code>onMaxlengthReached</code> attribute description:</p>
	 *
	 * <div>Node or Selector to display the number of remaining characters calculated by the charCounter.</div>
	 */
	public String getOnMaxlengthReached() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.onMaxlengthReached, null);
	}

	/**
	 * <p><code>onMaxlengthReached</code> attribute description:</p>
	 *
	 * <div>Node or Selector to display the number of remaining characters calculated by the charCounter.</div>
	 */
	public void setOnMaxlengthReached(String onMaxlengthReached) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.onMaxlengthReached, onMaxlengthReached);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-output-remaining-chars");
	}
}
//J+
