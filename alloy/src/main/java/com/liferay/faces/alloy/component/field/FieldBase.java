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
package com.liferay.faces.alloy.component.field;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.panelgroup.PanelGroupBlockLayout;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class FieldBase extends PanelGroupBlockLayout implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.field.Field";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.field.FieldRenderer";

	// Protected Enumerations
	protected enum FieldPropertyKeys {
		label,
		labelFirst
	}

	public FieldBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>The text value for the rendered &lt;label&gt; element.</div>
	 */
	public String getLabel() {
		return (String) getStateHelper().eval(FieldPropertyKeys.label, null);
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>The text value for the rendered &lt;label&gt; element.</div>
	 */
	public void setLabel(String label) {
		getStateHelper().put(FieldPropertyKeys.label, label);
	}

	/**
	 * <p><code>labelFirst</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the label will be rendered before the rendered children.</div>
	 */
	public boolean isLabelFirst() {
		return (Boolean) getStateHelper().eval(FieldPropertyKeys.labelFirst, true);
	}

	/**
	 * <p><code>labelFirst</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the label will be rendered before the rendered children.</div>
	 */
	public void setLabelFirst(boolean labelFirst) {
		getStateHelper().put(FieldPropertyKeys.labelFirst, labelFirst);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-field");
	}
}
//J+
