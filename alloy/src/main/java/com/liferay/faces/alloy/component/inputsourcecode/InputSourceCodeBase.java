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
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(InputSourceCodePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.height, null);
	}

	/**
	 * <code>height</code> attribute description:
	 * <br /><br />
	 * The the height (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public void setHeight(String height) {
		getStateHelper().put(InputSourceCodePropertyKeys.height, height);
	}

	/**
	 * <code>highlightActiveLine</code> attribute description:
	 * <br /><br />
	 * When true, the background-color of the line that is being edited by the user (the active line) will change to indicate a highlight.
	 */
	public Boolean getHighlightActiveLine() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.highlightActiveLine, null);
	}

	/**
	 * <code>highlightActiveLine</code> attribute description:
	 * <br /><br />
	 * When true, the background-color of the line that is being edited by the user (the active line) will change to indicate a highlight.
	 */
	public void setHighlightActiveLine(Boolean highlightActiveLine) {
		getStateHelper().put(InputSourceCodePropertyKeys.highlightActiveLine, highlightActiveLine);
	}

	/**
	 * <code>label</code> attribute description:
	 * <br /><br />
	 * A localized label for this component that is typically only rendered in a FacesMessage when validation fails.
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
	 * <code>locale</code> attribute description:
	 * <br /><br />
	 * The locale of the text that the editor is editing or displaying.
	 */
	public String getLocale() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.locale, null);
	}

	/**
	 * <code>locale</code> attribute description:
	 * <br /><br />
	 * The locale of the text that the editor is editing or displaying.
	 */
	public void setLocale(String locale) {
		getStateHelper().put(InputSourceCodePropertyKeys.locale, locale);
	}

	/**
	 * <code>maxLines</code> attribute description:
	 * <br /><br />
	 * Specifies the maximum number of lines that the editor is to display before a vertical scrollbar appears.
	 */
	public Integer getMaxLines() {
		return (Integer) getStateHelper().eval(InputSourceCodePropertyKeys.maxLines, 1024);
	}

	/**
	 * <code>maxLines</code> attribute description:
	 * <br /><br />
	 * Specifies the maximum number of lines that the editor is to display before a vertical scrollbar appears.
	 */
	public void setMaxLines(Integer maxLines) {
		getStateHelper().put(InputSourceCodePropertyKeys.maxLines, maxLines);
	}

	/**
	 * <code>minLines</code> attribute description:
	 * <br /><br />
	 * Minimum number of lines that the editor is to display.
	 */
	public Integer getMinLines() {
		return (Integer) getStateHelper().eval(InputSourceCodePropertyKeys.minLines, 6);
	}

	/**
	 * <code>minLines</code> attribute description:
	 * <br /><br />
	 * Minimum number of lines that the editor is to display.
	 */
	public void setMinLines(Integer minLines) {
		getStateHelper().put(InputSourceCodePropertyKeys.minLines, minLines);
	}

	/**
	 * <code>mode</code> attribute description:
	 * <br /><br />
	 * The name of the programming language that the editor is editing or displaying.
	 */
	public String getMode() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.mode, null);
	}

	/**
	 * <code>mode</code> attribute description:
	 * <br /><br />
	 * The name of the programming language that the editor is editing or displaying.
	 */
	public void setMode(String mode) {
		getStateHelper().put(InputSourceCodePropertyKeys.mode, mode);
	}

	/**
	 * <code>readOnly</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be read-only, meaning that the user will be unable to edit the source code text. The default value is <code>false</code>.
	 */
	public Boolean getReadOnly() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.readOnly, null);
	}

	/**
	 * <code>readOnly</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the component will be read-only, meaning that the user will be unable to edit the source code text. The default value is <code>false</code>.
	 */
	public void setReadOnly(Boolean readOnly) {
		getStateHelper().put(InputSourceCodePropertyKeys.readOnly, readOnly);
	}

	/**
	 * <code>showPrintMargin</code> attribute description:
	 * <br /><br />
	 * When this flag is true, a vertical line will appear that indicates the print margin. The default value is <code>true</code>.
	 */
	public Boolean getShowPrintMargin() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.showPrintMargin, null);
	}

	/**
	 * <code>showPrintMargin</code> attribute description:
	 * <br /><br />
	 * When this flag is true, a vertical line will appear that indicates the print margin. The default value is <code>true</code>.
	 */
	public void setShowPrintMargin(Boolean showPrintMargin) {
		getStateHelper().put(InputSourceCodePropertyKeys.showPrintMargin, showPrintMargin);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-input-source-code");
	}

	/**
	 * <code>tabSize</code> attribute description:
	 * <br /><br />
	 * The number of spaces that are to be displayed in place of each tab character.
	 */
	public String getTabSize() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.tabSize, null);
	}

	/**
	 * <code>tabSize</code> attribute description:
	 * <br /><br />
	 * The number of spaces that are to be displayed in place of each tab character.
	 */
	public void setTabSize(String tabSize) {
		getStateHelper().put(InputSourceCodePropertyKeys.tabSize, tabSize);
	}

	/**
	 * <code>useSoftTabs</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the tab key will produce space characters rather than tab characters. The default value is <code>false</code>.
	 */
	public Boolean getUseSoftTabs() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.useSoftTabs, null);
	}

	/**
	 * <code>useSoftTabs</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the tab key will produce space characters rather than tab characters. The default value is <code>false</code>.
	 */
	public void setUseSoftTabs(Boolean useSoftTabs) {
		getStateHelper().put(InputSourceCodePropertyKeys.useSoftTabs, useSoftTabs);
	}

	/**
	 * <code>useWrapMode</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the line will break when it reaches the end of the line. The default value is <code>true</code>.
	 */
	public Boolean getUseWrapMode() {
		return (Boolean) getStateHelper().eval(InputSourceCodePropertyKeys.useWrapMode, null);
	}

	/**
	 * <code>useWrapMode</code> attribute description:
	 * <br /><br />
	 * When this flag is true, the line will break when it reaches the end of the line. The default value is <code>true</code>.
	 */
	public void setUseWrapMode(Boolean useWrapMode) {
		getStateHelper().put(InputSourceCodePropertyKeys.useWrapMode, useWrapMode);
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The the width (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(InputSourceCodePropertyKeys.width, null);
	}

	/**
	 * <code>width</code> attribute description:
	 * <br /><br />
	 * The the width (in pixels) of the rendered <code>&lt;div&gt;</code>.
	 */
	public void setWidth(String width) {
		getStateHelper().put(InputSourceCodePropertyKeys.width, width);
	}
}
//J+
