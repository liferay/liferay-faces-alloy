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
package com.liferay.faces.alloy.component.paginator;
//J-

import javax.annotation.Generated;
import javax.faces.component.UIComponentBase;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class PaginatorBase extends UIComponentBase implements Styleable {

	// Public Constants
	public static final String COMPONENT_FAMILY = "com.liferay.faces.alloy.component.paginator";
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.paginator.Paginator";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.paginator.PaginatorRenderer";

	// Protected Enumerations
	protected enum PaginatorPropertyKeys {
		ajax,
		execute,
		firstPage,
		firstPageLabel,
		for_,
		lastPageLabel,
		maxPageNumberControls,
		nextPageLabel,
		previousPageLabel,
		process,
		render,
		showFirstPageControl,
		showLastPageControl,
		showNextPageControl,
		showPageNumberControls,
		showPreviousPageControl,
		style,
		styleClass,
		summaryPosition,
		update
	}

	public PaginatorBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	/**
	 * <code>ajax</code> attribute description:
	 * <br /><br />
	 * When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.
	 */
	public boolean isAjax() {
		return (Boolean) getStateHelper().eval(PaginatorPropertyKeys.ajax, true);
	}

	/**
	 * <code>ajax</code> attribute description:
	 * <br /><br />
	 * When this flag is true, clicking on the button will cause the form to be submitted via XmlHttpRequest.
	 */
	public void setAjax(boolean ajax) {
		getStateHelper().put(PaginatorPropertyKeys.ajax, ajax);
	}

	/**
	 * <code>execute</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>. The default value is <code>@this @for</code> (meaning, the paginator itself and the associated alloy:dataTable).
	 */
	public String getExecute() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.execute, "@this @for");
	}

	/**
	 * <code>execute</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the APPLY_REQUEST_VALUES, PROCESS_VALIDATIONS, UPDATE_MODEL_VALUES, and INVOKE_APPLICATION phases of the JSF lifecycle. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>. The default value is <code>@this @for</code> (meaning, the paginator itself and the associated alloy:dataTable).
	 */
	public void setExecute(String execute) {
		getStateHelper().put(PaginatorPropertyKeys.execute, execute);
	}

	/**
	 * <code>firstPage</code> attribute description:
	 * <br /><br />
	 * Integer representing the first page number that is to be displayed in the list of page number controls.
	 */
	public int getFirstPage() {
		return (Integer) getStateHelper().eval(PaginatorPropertyKeys.firstPage, 1);
	}

	/**
	 * <code>firstPage</code> attribute description:
	 * <br /><br />
	 * Integer representing the first page number that is to be displayed in the list of page number controls.
	 */
	public void setFirstPage(int firstPage) {
		getStateHelper().put(PaginatorPropertyKeys.firstPage, firstPage);
	}

	/**
	 * <code>firstPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the first page to be displayed. The default value is the <code>"&amp;laquo;"</code> character code.
	 */
	public String getFirstPageLabel() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.firstPageLabel, "&laquo;");
	}

	/**
	 * <code>firstPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the first page to be displayed. The default value is the <code>"&amp;laquo;"</code> character code.
	 */
	public void setFirstPageLabel(String firstPageLabel) {
		getStateHelper().put(PaginatorPropertyKeys.firstPageLabel, firstPageLabel);
	}

	/**
	 * <code>for</code> attribute description:
	 * <br /><br />
	 * The id of the UIData component that is to be paginated.
	 */
	public String getFor() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.for_, null);
	}

	/**
	 * <code>for</code> attribute description:
	 * <br /><br />
	 * The id of the UIData component that is to be paginated.
	 */
	public void setFor(String for_) {
		getStateHelper().put(PaginatorPropertyKeys.for_, for_);
	}

	/**
	 * <code>lastPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the last page to be displayed. The default value is the <code>"&amp;raquo;"</code> character code.
	 */
	public String getLastPageLabel() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.lastPageLabel, "&raquo;");
	}

	/**
	 * <code>lastPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the last page to be displayed. The default value is the <code>"&amp;raquo;"</code> character code.
	 */
	public void setLastPageLabel(String lastPageLabel) {
		getStateHelper().put(PaginatorPropertyKeys.lastPageLabel, lastPageLabel);
	}

	/**
	 * <code>maxPageNumberControls</code> attribute description:
	 * <br /><br />
	 * Integer representing the maximum number of page number controls that will be displayed.
	 */
	public int getMaxPageNumberControls() {
		return (Integer) getStateHelper().eval(PaginatorPropertyKeys.maxPageNumberControls, 10);
	}

	/**
	 * <code>maxPageNumberControls</code> attribute description:
	 * <br /><br />
	 * Integer representing the maximum number of page number controls that will be displayed.
	 */
	public void setMaxPageNumberControls(int maxPageNumberControls) {
		getStateHelper().put(PaginatorPropertyKeys.maxPageNumberControls, maxPageNumberControls);
	}

	/**
	 * <code>nextPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the next page to be displayed. The default value is the <code>"&amp;rsaquo;"</code> character code.
	 */
	public String getNextPageLabel() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.nextPageLabel, "&rsaquo;");
	}

	/**
	 * <code>nextPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the next page to be displayed. The default value is the <code>"&amp;rsaquo;"</code> character code.
	 */
	public void setNextPageLabel(String nextPageLabel) {
		getStateHelper().put(PaginatorPropertyKeys.nextPageLabel, nextPageLabel);
	}

	/**
	 * <code>previousPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the previous page to be displayed. The default value is the <code>"&amp;lsaquo;"</code> character code.
	 */
	public String getPreviousPageLabel() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.previousPageLabel, "&lsaquo;");
	}

	/**
	 * <code>previousPageLabel</code> attribute description:
	 * <br /><br />
	 * The label of the control that causes the previous page to be displayed. The default value is the <code>"&amp;lsaquo;"</code> character code.
	 */
	public void setPreviousPageLabel(String previousPageLabel) {
		getStateHelper().put(PaginatorPropertyKeys.previousPageLabel, previousPageLabel);
	}

	/**
	 * <code>process</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.
	 */
	public String getProcess() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.process, getExecute());
	}

	/**
	 * <code>process</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>execute</code> attribute. The default value is <code>"@all"</code>.
	 */
	public void setProcess(String process) {
		getStateHelper().put(PaginatorPropertyKeys.process, process);
	}

	/**
	 * <code>render</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>, <code>@for</code>. The default value is <code>@this @for</code> (meaning, the paginator itself and the associated alloy:dataTable).
	 */
	public String getRender() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.render, "@this @for");
	}

	/**
	 * <code>render</code> attribute description:
	 * <br /><br />
	 * Space-delimited list of component ids that are to participate in the RENDER_RESPONSE phase of the JSF lifecycle and be re-rendered in the DOM after the response is received from the XmlHttpRequest. The following keywords may also appear in the list: <code>@this</code>, <code>@form</code>, <code>@all</code>, <code>@none</code>, <code>@for</code>. The default value is <code>@this @for</code> (meaning, the paginator itself and the associated alloy:dataTable).
	 */
	public void setRender(String render) {
		getStateHelper().put(PaginatorPropertyKeys.render, render);
	}

	/**
	 * <code>showFirstPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the first page.
	 */
	public boolean isShowFirstPageControl() {
		return (Boolean) getStateHelper().eval(PaginatorPropertyKeys.showFirstPageControl, true);
	}

	/**
	 * <code>showFirstPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the first page.
	 */
	public void setShowFirstPageControl(boolean showFirstPageControl) {
		getStateHelper().put(PaginatorPropertyKeys.showFirstPageControl, showFirstPageControl);
	}

	/**
	 * <code>showLastPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the last page.
	 */
	public boolean isShowLastPageControl() {
		return (Boolean) getStateHelper().eval(PaginatorPropertyKeys.showLastPageControl, true);
	}

	/**
	 * <code>showLastPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the last page.
	 */
	public void setShowLastPageControl(boolean showLastPageControl) {
		getStateHelper().put(PaginatorPropertyKeys.showLastPageControl, showLastPageControl);
	}

	/**
	 * <code>showNextPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the next page.
	 */
	public boolean isShowNextPageControl() {
		return (Boolean) getStateHelper().eval(PaginatorPropertyKeys.showNextPageControl, true);
	}

	/**
	 * <code>showNextPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the next page.
	 */
	public void setShowNextPageControl(boolean showNextPageControl) {
		getStateHelper().put(PaginatorPropertyKeys.showNextPageControl, showNextPageControl);
	}

	/**
	 * <code>showPageNumberControls</code> attribute description:
	 * <br /><br />
	 * When true, controls will be rendered for each page number (limited by the maxPageNumberControls attribute).
	 */
	public boolean isShowPageNumberControls() {
		return (Boolean) getStateHelper().eval(PaginatorPropertyKeys.showPageNumberControls, true);
	}

	/**
	 * <code>showPageNumberControls</code> attribute description:
	 * <br /><br />
	 * When true, controls will be rendered for each page number (limited by the maxPageNumberControls attribute).
	 */
	public void setShowPageNumberControls(boolean showPageNumberControls) {
		getStateHelper().put(PaginatorPropertyKeys.showPageNumberControls, showPageNumberControls);
	}

	/**
	 * <code>showPreviousPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the previous page.
	 */
	public boolean isShowPreviousPageControl() {
		return (Boolean) getStateHelper().eval(PaginatorPropertyKeys.showPreviousPageControl, true);
	}

	/**
	 * <code>showPreviousPageControl</code> attribute description:
	 * <br /><br />
	 * When true, a control will be rendered that will cause the associated UIData component to display the previous page.
	 */
	public void setShowPreviousPageControl(boolean showPreviousPageControl) {
		getStateHelper().put(PaginatorPropertyKeys.showPreviousPageControl, showPreviousPageControl);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public String getStyle() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.style, null);
	}

	/**
	 * <code>style</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying the css style of the element.
	 */
	@Override
	public void setStyle(String style) {
		getStateHelper().put(PaginatorPropertyKeys.style, style);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute. Valid values are <code>pagination-large</code>, <code>pagination-small</code>, and <code>pagination-mini</code>.
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(PaginatorPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(PaginatorPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-paginator");
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute. Valid values are <code>pagination-large</code>, <code>pagination-small</code>, and <code>pagination-mini</code>.
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(PaginatorPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <code>summaryPosition</code> attribute description:
	 * <br /><br />
	 * Specifies the position of the row summary. The row summary will be displayed based on the <code>results-x-x-of-x-page-x-of-x</code> internationalized language key, for example: "Page 1 of 7."
	 */
	public String getSummaryPosition() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.summaryPosition, "bottom");
	}

	/**
	 * <code>summaryPosition</code> attribute description:
	 * <br /><br />
	 * Specifies the position of the row summary. The row summary will be displayed based on the <code>results-x-x-of-x-page-x-of-x</code> internationalized language key, for example: "Page 1 of 7."
	 */
	public void setSummaryPosition(String summaryPosition) {
		getStateHelper().put(PaginatorPropertyKeys.summaryPosition, summaryPosition);
	}

	/**
	 * <code>update</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.
	 */
	public String getUpdate() {
		return (String) getStateHelper().eval(PaginatorPropertyKeys.update, getRender());
	}

	/**
	 * <code>update</code> attribute description:
	 * <br /><br />
	 * Synonym for the <code>render</code> attribute. The default value is <code>"@none"</code>.
	 */
	public void setUpdate(String update) {
		getStateHelper().put(PaginatorPropertyKeys.update, update);
	}
}
//J+
