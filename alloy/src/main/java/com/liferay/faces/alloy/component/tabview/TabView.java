/**
 * Copyright (c) 2000-2025 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.tabview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;

import com.liferay.faces.alloy.component.tab.Tab;
import com.liferay.faces.alloy.component.tab.TabSelectEvent;
import com.liferay.faces.alloy.component.tab.TabUtil;
import com.liferay.faces.util.helper.IntegerHelper;


/**
 * @author  Neil Griffin
 */
@FacesComponent(value = TabView.COMPONENT_TYPE)
public class TabView extends TabViewBase implements ClientBehaviorHolder {

	// Private Constants
	private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList(
				TabSelectEvent.TAB_SELECT));

	@Override
	public String getDefaultEventName() {
		return TabSelectEvent.TAB_SELECT;
	}

	@Override
	public Collection<String> getEventNames() {
		return EVENT_NAMES;
	}

	@Override
	public void queueEvent(FacesEvent facesEvent) {

		// This method is called by the AjaxBehavior renderer's decode() method. If the specified event is an ajax
		// behavior event that indicates a tab being selected, then
		if (facesEvent instanceof AjaxBehaviorEvent) {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, String> requestParameterMap = externalContext.getRequestParameterMap();
			String eventName = requestParameterMap.get("javax.faces.behavior.event");

			// If the AjaxBehaviorEvent indicates a tab being selected, then
			if (TabSelectEvent.TAB_SELECT.equals(eventName)) {

				// Determine the client-side state of the selected tab index.
				String clientId = getClientId(facesContext);
				int selectedIndex = IntegerHelper.toInteger(requestParameterMap.get(clientId + "selectedIndex"));

				// If iterating over a data model, then determine the row data and tab associated with the data model
				// iteration.
				Object rowData = null;
				Tab tab = null;
				String var = getVar();

				if (var != null) {
					setRowIndex(selectedIndex);
					rowData = getRowData();
					tab = TabUtil.getFirstChildTab(this);
					setRowIndex(-1);
				}

				// Otherwise, determine the tab associated with the client-side state of the selected tab index.
				else {
					List<Tab> childTabs = TabUtil.getChildTabs(this);

					if (childTabs.size() >= (selectedIndex + 1)) {
						tab = childTabs.get(selectedIndex);
					}
				}

				// Queue a tab select event rather than the specified faces event.
				AjaxBehaviorEvent behaviorEvent = (AjaxBehaviorEvent) facesEvent;
				Behavior behavior = behaviorEvent.getBehavior();
				facesEvent = new TabSelectEvent(this, behavior, tab, rowData);
			}
		}

		super.queueEvent(facesEvent);
	}
}
