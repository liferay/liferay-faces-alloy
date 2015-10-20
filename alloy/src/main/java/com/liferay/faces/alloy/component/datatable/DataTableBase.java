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
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(DataTablePropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(DataTablePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>multiColumnSort</code> attribute description:
	 * <br /><br />
	 * When true, multiple columns can be selected by the user when the meta key is held down during a left click on a sortable column header.
	 */
	public boolean isMultiColumnSort() {
		return (Boolean) getStateHelper().eval(DataTablePropertyKeys.multiColumnSort, false);
	}

	/**
	 * <code>multiColumnSort</code> attribute description:
	 * <br /><br />
	 * When true, multiple columns can be selected by the user when the meta key is held down during a left click on a sortable column header.
	 */
	public void setMultiColumnSort(boolean multiColumnSort) {
		getStateHelper().put(DataTablePropertyKeys.multiColumnSort, multiColumnSort);
	}

	/**
	 * <code>selectedRowIndexes</code> attribute description:
	 * <br /><br />
	 * Comma-delimited list of row indexes that indicate which rows are selected.
	 */
	public String getSelectedRowIndexes() {
		return (String) getStateHelper().eval(DataTablePropertyKeys.selectedRowIndexes, null);
	}

	/**
	 * <code>selectedRowIndexes</code> attribute description:
	 * <br /><br />
	 * Comma-delimited list of row indexes that indicate which rows are selected.
	 */
	public void setSelectedRowIndexes(String selectedRowIndexes) {
		getStateHelper().put(DataTablePropertyKeys.selectedRowIndexes, selectedRowIndexes);
	}

	/**
	 * <code>selectionMode</code> attribute description:
	 * <br /><br />
	 * Indicates the type of row selection. Valid values are <code>"checkbox"</code>, <code>"radio"</code>.
	 */
	public String getSelectionMode() {
		return (String) getStateHelper().eval(DataTablePropertyKeys.selectionMode, null);
	}

	/**
	 * <code>selectionMode</code> attribute description:
	 * <br /><br />
	 * Indicates the type of row selection. Valid values are <code>"checkbox"</code>, <code>"radio"</code>.
	 */
	public void setSelectionMode(String selectionMode) {
		getStateHelper().put(DataTablePropertyKeys.selectionMode, selectionMode);
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

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-data-table", "table table-bordered table-hover table-striped");
	}
}
//J+
