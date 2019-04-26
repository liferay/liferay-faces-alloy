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
package com.liferay.faces.alloy.component.inputsourcecode;
//J-

import javax.annotation.Generated;
import javax.faces.component.html.HtmlInputText;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputSourceCodeBase extends HtmlInputText implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.inputsourcecode.InputSourceCode";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.inputsourcecode.InputSourceCodeRenderer";

	// Protected Enumerations
	protected enum InputSourceCodePropertyKeys {
		clientKey,
		height,
		highlightActiveLine,
		locale,
		maxLines,
		minLines,
		mode,
		readOnly,
		showPrintMargin,
		tabSize,
		useSoftTabs,
		useWrapMode,
		width
	}

	public InputSourceCodeBase() {
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
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(InputSourceCodePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(InputSourceCodePropertyKeys.height, height);
	}

	/**
	 * <p><code>highlightActiveLine</code> attribute description:</p>
	 *
	 * <div>When true, the background-color of the line that is being edited by the user (the active line) will change to indicate a highlight.</div>
	 */
	public Boolean getHighlightActiveLine() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.highlightActiveLine, null);
	}

	/**
	 * <p><code>highlightActiveLine</code> attribute description:</p>
	 *
	 * <div>When true, the background-color of the line that is being edited by the user (the active line) will change to indicate a highlight.</div>
	 */
	public void setHighlightActiveLine(Boolean highlightActiveLine) {
		getStateHelper().put(InputSourceCodePropertyKeys.highlightActiveLine, highlightActiveLine);
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>A localized label for this component that is typically only rendered in a FacesMessage when validation fails.</div>
	 */
	@Override
	public String getLabel() {

		String label = super.getLabel();

		if (label == null) {

			javax.faces.context.FacesContext facesContext = javax.faces.context.FacesContext.getCurrentInstance();

			if (facesContext.getCurrentPhaseId() == javax.faces.event.PhaseId.PROCESS_VALIDATIONS) {
				label = com.liferay.faces.util.component.ComponentUtil.getComponentLabel(this);
			}
		}

		return label;
	}

	/**
	 * <p><code>locale</code> attribute description:</p>
	 *
	 * <div>The locale of the text that the editor is editing or displaying.</div>
	 */
	public String getLocale() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.locale, null);
	}

	/**
	 * <p><code>locale</code> attribute description:</p>
	 *
	 * <div>The locale of the text that the editor is editing or displaying.</div>
	 */
	public void setLocale(String locale) {
		getStateHelper().put(InputSourceCodePropertyKeys.locale, locale);
	}

	/**
	 * <p><code>maxLines</code> attribute description:</p>
	 *
	 * <div>Specifies the maximum number of lines that the editor is to display before a vertical scrollbar appears.</div>
	 */
	public Integer getMaxLines() {
		return (Integer) getStateHelper().eval(InputSourceCodePropertyKeys.maxLines, 1024);
	}

	/**
	 * <p><code>maxLines</code> attribute description:</p>
	 *
	 * <div>Specifies the maximum number of lines that the editor is to display before a vertical scrollbar appears.</div>
	 */
	public void setMaxLines(Integer maxLines) {
		getStateHelper().put(InputSourceCodePropertyKeys.maxLines, maxLines);
	}

	/**
	 * <p><code>minLines</code> attribute description:</p>
	 *
	 * <div>Minimum number of lines that the editor is to display.</div>
	 */
	public Integer getMinLines() {
		return (Integer) getStateHelper().eval(InputSourceCodePropertyKeys.minLines, 6);
	}

	/**
	 * <p><code>minLines</code> attribute description:</p>
	 *
	 * <div>Minimum number of lines that the editor is to display.</div>
	 */
	public void setMinLines(Integer minLines) {
		getStateHelper().put(InputSourceCodePropertyKeys.minLines, minLines);
	}

	/**
	 * <p><code>mode</code> attribute description:</p>
	 *
	 * <div>The name of the programming language that the editor is editing or displaying.</div>
	 */
	public String getMode() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.mode, null);
	}

	/**
	 * <p><code>mode</code> attribute description:</p>
	 *
	 * <div>The name of the programming language that the editor is editing or displaying.</div>
	 */
	public void setMode(String mode) {
		getStateHelper().put(InputSourceCodePropertyKeys.mode, mode);
	}

	/**
	 * <p><code>readOnly</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be read-only, meaning that the user will be unable to edit the source code text. The default value is <code>false</code>.</div>
	 */
	public Boolean getReadOnly() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.readOnly, null);
	}

	/**
	 * <p><code>readOnly</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the component will be read-only, meaning that the user will be unable to edit the source code text. The default value is <code>false</code>.</div>
	 */
	public void setReadOnly(Boolean readOnly) {
		getStateHelper().put(InputSourceCodePropertyKeys.readOnly, readOnly);
	}

	/**
	 * <p><code>showPrintMargin</code> attribute description:</p>
	 *
	 * <div>When this flag is true, a vertical line will appear that indicates the print margin. The default value is <code>true</code>.</div>
	 */
	public Boolean getShowPrintMargin() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.showPrintMargin, null);
	}

	/**
	 * <p><code>showPrintMargin</code> attribute description:</p>
	 *
	 * <div>When this flag is true, a vertical line will appear that indicates the print margin. The default value is <code>true</code>.</div>
	 */
	public void setShowPrintMargin(Boolean showPrintMargin) {
		getStateHelper().put(InputSourceCodePropertyKeys.showPrintMargin, showPrintMargin);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-input-source-code");
	}

	/**
	 * <p><code>tabSize</code> attribute description:</p>
	 *
	 * <div>The number of spaces that are to be displayed in place of each tab character.</div>
	 */
	public String getTabSize() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.tabSize, null);
	}

	/**
	 * <p><code>tabSize</code> attribute description:</p>
	 *
	 * <div>The number of spaces that are to be displayed in place of each tab character.</div>
	 */
	public void setTabSize(String tabSize) {
		getStateHelper().put(InputSourceCodePropertyKeys.tabSize, tabSize);
	}

	/**
	 * <p><code>useSoftTabs</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the tab key will produce space characters rather than tab characters. The default value is <code>false</code>.</div>
	 */
	public Boolean getUseSoftTabs() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.useSoftTabs, null);
	}

	/**
	 * <p><code>useSoftTabs</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the tab key will produce space characters rather than tab characters. The default value is <code>false</code>.</div>
	 */
	public void setUseSoftTabs(Boolean useSoftTabs) {
		getStateHelper().put(InputSourceCodePropertyKeys.useSoftTabs, useSoftTabs);
	}

	/**
	 * <p><code>useWrapMode</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the line will break when it reaches the end of the line. The default value is <code>true</code>.</div>
	 */
	public Boolean getUseWrapMode() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.useWrapMode, null);
	}

	/**
	 * <p><code>useWrapMode</code> attribute description:</p>
	 *
	 * <div>When this flag is true, the line will break when it reaches the end of the line. The default value is <code>true</code>.</div>
	 */
	public void setUseWrapMode(Boolean useWrapMode) {
		getStateHelper().put(InputSourceCodePropertyKeys.useWrapMode, useWrapMode);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the width (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.width, null);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the width (in pixels) of the rendered <code>&lt;div&gt;</code>.</div>
	 */
	public void setWidth(String width) {
		getStateHelper().put(InputSourceCodePropertyKeys.width, width);
	}
}
//J+
