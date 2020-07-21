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
package com.liferay.faces.alloy.component.autocomplete;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.inputtext.InputTextBase;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class AutoCompleteBase extends InputTextBase implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.autocomplete.AutoComplete";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.autocomplete.AutoCompleteRenderer";

	// Protected Enumerations
	protected enum AutoCompletePropertyKeys {
		activateFirstItem,
		autoScroll,
		circular,
		clientCustomFilter,
		clientFilterType,
		clientKey,
		delay,
		delimiter,
		height,
		highlighterType,
		listItemRequired,
		maxItems,
		minChars,
		serverCustomFilter,
		serverFilterType,
		tabSelect,
		width
	}

	public AutoCompleteBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>activateFirstItem</code> attribute description:</p>
	 *
	 * <div>When true, the first item in the list will be activated so that users can press TAB or ENTER to select it.</div>
	 */
	public boolean isActivateFirstItem() {
		return (Boolean) getStateHelper().eval(AutoCompletePropertyKeys.activateFirstItem, true);
	}

	/**
	 * <p><code>activateFirstItem</code> attribute description:</p>
	 *
	 * <div>When true, the first item in the list will be activated so that users can press TAB or ENTER to select it.</div>
	 */
	public void setActivateFirstItem(boolean activateFirstItem) {
		getStateHelper().put(AutoCompletePropertyKeys.activateFirstItem, activateFirstItem);
	}

	/**
	 * <p><code>autoScroll</code> attribute description:</p>
	 *
	 * <div>When true, if the active option of the autoComplete is not in view, the view will be scrolled to ensure that the active option is displayed to the user.</div>
	 */
	public Boolean getAutoScroll() {
		return (Boolean) getStateHelper().eval(AutoCompletePropertyKeys.autoScroll, null);
	}

	/**
	 * <p><code>autoScroll</code> attribute description:</p>
	 *
	 * <div>When true, if the active option of the autoComplete is not in view, the view will be scrolled to ensure that the active option is displayed to the user.</div>
	 */
	public void setAutoScroll(Boolean autoScroll) {
		getStateHelper().put(AutoCompletePropertyKeys.autoScroll, autoScroll);
	}

	/**
	 * <p><code>circular</code> attribute description:</p>
	 *
	 * <div>When true, the autoComplete list will wrap around allowing users to use keyboard navigation to move from the top of the list to the bottom and vice versa. The default value is <code>true</code>.</div>
	 */
	public Boolean getCircular() {
		return (Boolean) getStateHelper().eval(AutoCompletePropertyKeys.circular, null);
	}

	/**
	 * <p><code>circular</code> attribute description:</p>
	 *
	 * <div>When true, the autoComplete list will wrap around allowing users to use keyboard navigation to move from the top of the list to the bottom and vice versa. The default value is <code>true</code>.</div>
	 */
	public void setCircular(Boolean circular) {
		getStateHelper().put(AutoCompletePropertyKeys.circular, circular);
	}

	/**
	 * <p><code>clientCustomFilter</code> attribute description:</p>
	 *
	 * <div>A callback which filters the client-side results. The callback must be a function which takes <code>query</code> and <code>source</code> arguments and returns an array of <code>String</code>s as a result. The <code>source</code> argument recieved by this callback is an <code>Array</code> of <code>Object</code>s which contain three properties: <code>display</code>, <code>raw</code>, and <code>text</code>. <strong>Note:</strong> This attribute will be ignored if the <code>serverCustomFilter</code> or <code>serverFilterType</code> attributes are used.</div>
	 */
	public String getClientCustomFilter() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.clientCustomFilter, null);
	}

	/**
	 * <p><code>clientCustomFilter</code> attribute description:</p>
	 *
	 * <div>A callback which filters the client-side results. The callback must be a function which takes <code>query</code> and <code>source</code> arguments and returns an array of <code>String</code>s as a result. The <code>source</code> argument recieved by this callback is an <code>Array</code> of <code>Object</code>s which contain three properties: <code>display</code>, <code>raw</code>, and <code>text</code>. <strong>Note:</strong> This attribute will be ignored if the <code>serverCustomFilter</code> or <code>serverFilterType</code> attributes are used.</div>
	 */
	public void setClientCustomFilter(String clientCustomFilter) {
		getStateHelper().put(AutoCompletePropertyKeys.clientCustomFilter, clientCustomFilter);
	}

	/**
	 * <p><code>clientFilterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the autoComplete results. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul><strong>Note:</strong> This attribute will be ignored if the <code>serverCustomFilter</code>, <code>serverFilterType</code>, or <code>clientCustomFilter</code> attributes are used.</div>
	 */
	public String getClientFilterType() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.clientFilterType, null);
	}

	/**
	 * <p><code>clientFilterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the autoComplete results. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul><strong>Note:</strong> This attribute will be ignored if the <code>serverCustomFilter</code>, <code>serverFilterType</code>, or <code>clientCustomFilter</code> attributes are used.</div>
	 */
	public void setClientFilterType(String clientFilterType) {
		getStateHelper().put(AutoCompletePropertyKeys.clientFilterType, clientFilterType);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(AutoCompletePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>delay</code> attribute description:</p>
	 *
	 * <div>The delay in milliseconds before a request for filtering occurs. After the <code>autoComplete</code> receives input, it waits the specified number of milliseconds before sending a request for filtering it's source. If input occurs before the specified number of milliseconds has elapsed, the timer is reset.</div>
	 */
	public Integer getDelay() {
		return (Integer) getStateHelper().eval(AutoCompletePropertyKeys.delay, null);
	}

	/**
	 * <p><code>delay</code> attribute description:</p>
	 *
	 * <div>The delay in milliseconds before a request for filtering occurs. After the <code>autoComplete</code> receives input, it waits the specified number of milliseconds before sending a request for filtering it's source. If input occurs before the specified number of milliseconds has elapsed, the timer is reset.</div>
	 */
	public void setDelay(Integer delay) {
		getStateHelper().put(AutoCompletePropertyKeys.delay, delay);
	}

	/**
	 * <p><code>delimiter</code> attribute description:</p>
	 *
	 * <div>The string which delimits the part of the text that will have completion. For example, if <code>delimiter=" "</code>, then only the text after the final space will have completion. <strong>Note:</strong> if <code>listItemRequired="true"</code>, this attribute is ignored.</div>
	 */
	public String getDelimiter() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.delimiter, null);
	}

	/**
	 * <p><code>delimiter</code> attribute description:</p>
	 *
	 * <div>The string which delimits the part of the text that will have completion. For example, if <code>delimiter=" "</code>, then only the text after the final space will have completion. <strong>Note:</strong> if <code>listItemRequired="true"</code>, this attribute is ignored.</div>
	 */
	public void setDelimiter(String delimiter) {
		getStateHelper().put(AutoCompletePropertyKeys.delimiter, delimiter);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered autoComplete list.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The the height (in pixels) of the rendered autoComplete list.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(AutoCompletePropertyKeys.height, height);
	}

	/**
	 * <p><code>highlighterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of highlighter that will be used for the autoComplete results. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul></div>
	 */
	public String getHighlighterType() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.highlighterType, null);
	}

	/**
	 * <p><code>highlighterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of highlighter that will be used for the autoComplete results. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul></div>
	 */
	public void setHighlighterType(String highlighterType) {
		getStateHelper().put(AutoCompletePropertyKeys.highlighterType, highlighterType);
	}

	/**
	 * <p><code>listItemRequired</code> attribute description:</p>
	 *
	 * <div>When true, the component will perform server-side validation to ensure that the value entered is on the list of completion items.</div>
	 */
	public boolean isListItemRequired() {
		return (Boolean) getStateHelper().eval(AutoCompletePropertyKeys.listItemRequired, false);
	}

	/**
	 * <p><code>listItemRequired</code> attribute description:</p>
	 *
	 * <div>When true, the component will perform server-side validation to ensure that the value entered is on the list of completion items.</div>
	 */
	public void setListItemRequired(boolean listItemRequired) {
		getStateHelper().put(AutoCompletePropertyKeys.listItemRequired, listItemRequired);
	}

	/**
	 * <p><code>maxItems</code> attribute description:</p>
	 *
	 * <div>The maximum amount of autoComplete results.</div>
	 */
	public Integer getMaxItems() {
		return (Integer) getStateHelper().eval(AutoCompletePropertyKeys.maxItems, null);
	}

	/**
	 * <p><code>maxItems</code> attribute description:</p>
	 *
	 * <div>The maximum amount of autoComplete results.</div>
	 */
	public void setMaxItems(Integer maxItems) {
		getStateHelper().put(AutoCompletePropertyKeys.maxItems, maxItems);
	}

	/**
	 * <p><code>minChars</code> attribute description:</p>
	 *
	 * <div>The minimum length of input required to trigger a query.</div>
	 */
	public Integer getMinChars() {
		return (Integer) getStateHelper().eval(AutoCompletePropertyKeys.minChars, null);
	}

	/**
	 * <p><code>minChars</code> attribute description:</p>
	 *
	 * <div>The minimum length of input required to trigger a query.</div>
	 */
	public void setMinChars(Integer minChars) {
		getStateHelper().put(AutoCompletePropertyKeys.minChars, minChars);
	}

	/**
	 * <p><code>serverCustomFilter</code> attribute description:</p>
	 *
	 * <div>A method that is executed when a query occurs. The method must be <code>public</code>, return a <code>java.util.List&lt;java.lang.String&gt;</code>, and takes a <code>java.lang.String</code> and a <code>java.util.List&lt;java.lang.String&gt;</code> as a arguments. The <code>String</code> passed to the method is the current query. The <code>List&lt;String&gt;</code> is an immutable list of unfiltered results. The method must return a <code>List&lt;String&gt;</code> which contains the filtered results.</div>
	 */
	public javax.el.MethodExpression getServerCustomFilter() {
		return (javax.el.MethodExpression) getStateHelper().eval(AutoCompletePropertyKeys.serverCustomFilter, null);
	}

	/**
	 * <p><code>serverCustomFilter</code> attribute description:</p>
	 *
	 * <div>A method that is executed when a query occurs. The method must be <code>public</code>, return a <code>java.util.List&lt;java.lang.String&gt;</code>, and takes a <code>java.lang.String</code> and a <code>java.util.List&lt;java.lang.String&gt;</code> as a arguments. The <code>String</code> passed to the method is the current query. The <code>List&lt;String&gt;</code> is an immutable list of unfiltered results. The method must return a <code>List&lt;String&gt;</code> which contains the filtered results.</div>
	 */
	public void setServerCustomFilter(javax.el.MethodExpression serverCustomFilter) {
		getStateHelper().put(AutoCompletePropertyKeys.serverCustomFilter, serverCustomFilter);
	}

	/**
	 * <p><code>serverFilterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the autoComplete results. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul><strong>Note:</strong> This attribute will be ignored if the <code>serverCustomFilter</code> attribute is used.</div>
	 */
	public String getServerFilterType() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.serverFilterType, null);
	}

	/**
	 * <p><code>serverFilterType</code> attribute description:</p>
	 *
	 * <div>Specifies the type of filter that will be used for the autoComplete results. Valid values include:<ul><li>charMatch</li><li>charMatchCase</li><li>phraseMatch</li><li>phraseMatchCase</li><li>startsWith</li><li>startsWithCase</li><li>subWordMatch</li><li>subWordMatchCase</li><li>wordMatch</li><li>wordMatchCase</li></ul><strong>Note:</strong> This attribute will be ignored if the <code>serverCustomFilter</code> attribute is used.</div>
	 */
	public void setServerFilterType(String serverFilterType) {
		getStateHelper().put(AutoCompletePropertyKeys.serverFilterType, serverFilterType);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-auto-complete");
	}

	/**
	 * <p><code>tabSelect</code> attribute description:</p>
	 *
	 * <div>When <code>true</code>, pressing TAB selects the active autoComplete option.</div>
	 */
	public boolean isTabSelect() {
		return (Boolean) getStateHelper().eval(AutoCompletePropertyKeys.tabSelect, true);
	}

	/**
	 * <p><code>tabSelect</code> attribute description:</p>
	 *
	 * <div>When <code>true</code>, pressing TAB selects the active autoComplete option.</div>
	 */
	public void setTabSelect(boolean tabSelect) {
		getStateHelper().put(AutoCompletePropertyKeys.tabSelect, tabSelect);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the width (in pixels) of the rendered autoComplete list.</div>
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(AutoCompletePropertyKeys.width, null);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The the width (in pixels) of the rendered autoComplete list.</div>
	 */
	public void setWidth(String width) {
		getStateHelper().put(AutoCompletePropertyKeys.width, width);
	}
}
//J+
