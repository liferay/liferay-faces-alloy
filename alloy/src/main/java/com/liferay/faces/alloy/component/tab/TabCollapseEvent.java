/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.tab;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;


/**
 * @author  Neil Griffin
 */
public class TabCollapseEvent extends AjaxBehaviorEvent {

	// Public Constants
	public static final String TAB_COLLAPSE = "tabCollapse";

	// serialVersionUID
	private static final long serialVersionUID = 8882538970972516549L;

	// Private Data Members
	private Object rowData;
	private Tab tab;

	public TabCollapseEvent(UIComponent component, Behavior behavior, Tab tab, Object rowData) {
		super(component, behavior);
		this.tab = tab;
		this.rowData = rowData;
		setPhaseId(PhaseId.APPLY_REQUEST_VALUES);
	}

	public Object getRowData() {
		return rowData;
	}

	public Tab getTab() {
		return tab;
	}
}
