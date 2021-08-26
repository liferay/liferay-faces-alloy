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
package com.liferay.faces.alloy.component.datatable;
//J-

import javax.annotation.Generated;
import javax.faces.component.html.HtmlDataTable;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class DataTableBase extends HtmlDataTable implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.datatable.DataTable";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.datatable.DataTableRenderer";

	// Protected Enumerations
	protected enum DataTablePropertyKeys {
		clientKey,
		multiColumnSort,
		selectedRowIndexes,
		selectionMode
	}

	public DataTableBase() {
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
		return (String) getStateHelper().eval(DataTablePropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(DataTablePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>multiColumnSort</code> attribute description:</p>
	 *
	 * <div>When true, multiple columns can be selected by the user when the meta key is held down during a left click on a sortable column header.</div>
	 */
	public boolean isMultiColumnSort() {
		return (Boolean) getStateHelper().eval(DataTablePropertyKeys.multiColumnSort, false);
	}

	/**
	 * <p><code>multiColumnSort</code> attribute description:</p>
	 *
	 * <div>When true, multiple columns can be selected by the user when the meta key is held down during a left click on a sortable column header.</div>
	 */
	public void setMultiColumnSort(boolean multiColumnSort) {
		getStateHelper().put(DataTablePropertyKeys.multiColumnSort, multiColumnSort);
	}

	/**
	 * <p><code>selectedRowIndexes</code> attribute description:</p>
	 *
	 * <div>Comma-delimited list of row indexes that indicate which rows are selected.</div>
	 */
	public String getSelectedRowIndexes() {
		return (String) getStateHelper().eval(DataTablePropertyKeys.selectedRowIndexes, null);
	}

	/**
	 * <p><code>selectedRowIndexes</code> attribute description:</p>
	 *
	 * <div>Comma-delimited list of row indexes that indicate which rows are selected.</div>
	 */
	public void setSelectedRowIndexes(String selectedRowIndexes) {
		getStateHelper().put(DataTablePropertyKeys.selectedRowIndexes, selectedRowIndexes);
	}

	/**
	 * <p><code>selectionMode</code> attribute description:</p>
	 *
	 * <div>Indicates the type of row selection. Valid values are <code>"checkbox"</code>, <code>"radio"</code>.</div>
	 */
	public String getSelectionMode() {
		return (String) getStateHelper().eval(DataTablePropertyKeys.selectionMode, null);
	}

	/**
	 * <p><code>selectionMode</code> attribute description:</p>
	 *
	 * <div>Indicates the type of row selection. Valid values are <code>"checkbox"</code>, <code>"radio"</code>.</div>
	 */
	public void setSelectionMode(String selectionMode) {
		getStateHelper().put(DataTablePropertyKeys.selectionMode, selectionMode);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-data-table", "table table-bordered table-hover table-striped");
	}
}
//J+
