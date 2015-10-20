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
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>for</code> attribute description:
	 * <br /><br />
	 * The id of the component for which the remaining characters are to be calculated.
	 */
	public String getFor() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.for_, null);
	}

	/**
	 * <code>for</code> attribute description:
	 * <br /><br />
	 * The id of the component for which the remaining characters are to be calculated.
	 */
	public void setFor(String for_) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.for_, for_);
	}

	/**
	 * <code>maxLength</code> attribute description:
	 * <br /><br />
	 * The maximum number of charachters to allow in the input.
	 */
	public Integer getMaxLength() {
		return (Integer) getStateHelper().eval(OutputRemainingCharsPropertyKeys.maxLength, null);
	}

	/**
	 * <code>maxLength</code> attribute description:
	 * <br /><br />
	 * The maximum number of charachters to allow in the input.
	 */
	public void setMaxLength(Integer maxLength) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.maxLength, maxLength);
	}

	/**
	 * <code>onceMaxlengthReached</code> attribute description:
	 * <br /><br />
	 * Node or Selector to display the number of remaining characters calculated by the charCounter.
	 */
	public String getOnceMaxlengthReached() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.onceMaxlengthReached, null);
	}

	/**
	 * <code>onceMaxlengthReached</code> attribute description:
	 * <br /><br />
	 * Node or Selector to display the number of remaining characters calculated by the charCounter.
	 */
	public void setOnceMaxlengthReached(String onceMaxlengthReached) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.onceMaxlengthReached, onceMaxlengthReached);
	}

	/**
	 * <code>onMaxlengthReached</code> attribute description:
	 * <br /><br />
	 * Node or Selector to display the number of remaining characters calculated by the charCounter.
	 */
	public String getOnMaxlengthReached() {
		return (String) getStateHelper().eval(OutputRemainingCharsPropertyKeys.onMaxlengthReached, null);
	}

	/**
	 * <code>onMaxlengthReached</code> attribute description:
	 * <br /><br />
	 * Node or Selector to display the number of remaining characters calculated by the charCounter.
	 */
	public void setOnMaxlengthReached(String onMaxlengthReached) {
		getStateHelper().put(OutputRemainingCharsPropertyKeys.onMaxlengthReached, onMaxlengthReached);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
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
