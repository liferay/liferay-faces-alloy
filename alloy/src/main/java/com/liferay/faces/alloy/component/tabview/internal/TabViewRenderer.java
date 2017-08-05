/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.tabview.internal;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.tab.Tab;
import com.liferay.faces.alloy.component.tab.TabSelectEvent;
import com.liferay.faces.alloy.component.tab.TabUtil;
import com.liferay.faces.alloy.component.tabview.TabView;
import com.liferay.faces.util.component.Styleable;
import com.liferay.faces.util.helper.IntegerHelper;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.render.JavaScriptFragment;
import com.liferay.faces.util.render.RendererUtil;


/**
 * This class is a JSF {@link javax.faces.render.Renderer} for the alloy:tabView component.
 *
 * @author  Neil Griffin
 * @author  Vernon Singleton
 */

//J-
@FacesRenderer(componentFamily = TabView.COMPONENT_FAMILY, rendererType = TabView.RENDERER_TYPE)
@ResourceDependencies(
	{
		@ResourceDependency(library = "liferay-faces-alloy", name = "alloy.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui-css/css/bootstrap.min.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui/aui-min.js"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "liferay.js")
	}
)
//J+
public class TabViewRenderer extends TabViewRendererBase {

	// Private Constants
	private static final String SELECTED_TAB_HEADER_CLASSES = "tab yui3-widget active tab-selected";
	private static final String UNSELECTED_TAB_HEADER_CLASSES = "tab yui3-widget";

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(TabViewRenderer.class);

	@Override
	public void decodeClientState(FacesContext facesContext, UIComponent uiComponent) {

		// Apply the client-side state of the selected index.
		TabView tabView = (TabView) uiComponent;
		String hiddenFieldName = tabView.getClientId(facesContext) + "selectedIndex";
		Map<String, String> requestParameterMap = facesContext.getExternalContext().getRequestParameterMap();
		String selectedIndex = requestParameterMap.get(hiddenFieldName);

		if (selectedIndex != null) {
			tabView.setSelectedIndex(IntegerHelper.toInteger(selectedIndex, -1));
		}
	}

	@Override
	public void encodeChildren(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// Get the "value" and "var" attributes of the TabView component and determine if iteration should take place
		// using a prototype child tab.
		TabView tabView = (TabView) uiComponent;
		Integer selectedIndex = tabView.getSelectedIndex();
		Object value = tabView.getValue();
		String var = tabView.getVar();
		boolean iterateOverDataModel = ((value != null) && (var != null));
		Tab prototypeChildTab = TabUtil.getFirstChildTab(tabView);

		// Encode the starting <ul> unordered list element that represents the list of clickable tabs.
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.startElement("ul", tabView);
		responseWriter.writeAttribute("class", "nav nav-tabs", null);

		if (iterateOverDataModel) {

			if (prototypeChildTab != null) {

				int rowCount = tabView.getRowCount();

				for (int i = 0; i < rowCount; i++) {

					tabView.setRowIndex(i);

					if (prototypeChildTab.isRendered()) {

						boolean selected = ((selectedIndex != null) && (i == selectedIndex));
						encodeTabListItem(facesContext, responseWriter, prototypeChildTab, selected, i);
					}
				}

				tabView.setRowIndex(-1);

			}
			else {
				logger.warn("Unable to iterate because alloy:tabView does not have an alloy:tab child element.");
			}
		}
		else {
			List<UIComponent> children = uiComponent.getChildren();
			int childCount = children.size();

			for (int i = 0; i < childCount; i++) {
				UIComponent child = children.get(i);

				if (child instanceof Tab) {

					if (child.isRendered()) {

						Tab childTab = (Tab) child;
						boolean selected = ((selectedIndex != null) && (i == selectedIndex));
						encodeTabListItem(facesContext, responseWriter, childTab, selected, i);
					}
				}
				else {
					logger.warn("Unable to render child element of alloy:tabView since it is not alloy:tab");
				}
			}
		}

		responseWriter.endElement("ul");

		// Encode the starting <div> element that represents the content for the selected tab.
		responseWriter.startElement("div", uiComponent);
		responseWriter.writeAttribute("class", "tab-content", null);

		// Encode the content for each tab.
		if ((iterateOverDataModel) && (prototypeChildTab != null)) {
			int rowCount = tabView.getRowCount();

			for (int i = 0; i < rowCount; i++) {
				tabView.setRowIndex(i);

				if (prototypeChildTab.isRendered()) {
					prototypeChildTab.encodeAll(facesContext);
				}
			}
		}
		else {
			List<UIComponent> children = tabView.getChildren();

			for (int i = 0; i < children.size(); i++) {
				UIComponent child = children.get(i);

				if (child.isRendered()) {
					child.encodeAll(facesContext);
				}
			}
		}

		tabView.setRowIndex(-1);

		// Encode the closing </div> element for the content.
		responseWriter.endElement("div");
	}

	@Override
	public void encodeClientState(FacesContext facesContext, ResponseWriter responseWriter, UIComponent uiComponent)
		throws IOException {

		// Encode the hidden field that contains the client-side state of the selected index.
		TabView tabView = (TabView) uiComponent;
		responseWriter.startElement("input", tabView);

		String hiddenFieldName = tabView.getClientId(facesContext) + "selectedIndex";
		responseWriter.writeAttribute("id", hiddenFieldName, null);
		responseWriter.writeAttribute("name", hiddenFieldName, null);
		responseWriter.writeAttribute("type", "hidden", null);
		responseWriter.writeAttribute("value", tabView.getSelectedIndex(), null);
		responseWriter.endElement("input");

	}

	@Override
	public void encodeJavaScriptCustom(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// Encode a script that will handle the client-side state of the selected tab index, as well as submitting
		// Ajax requests to support server-side events.
		TabView tabView = (TabView) uiComponent;

		// var tabViewClientVarName = Liferay.component('{clientKey}');
		String clientVarName = getClientVarName(facesContext, tabView);
		String clientKey = tabView.getClientKey();

		if (clientKey == null) {
			clientKey = clientVarName;
		}

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		encodeLiferayComponentVar(responseWriter, clientVarName, clientKey);

		// Enable the enabled tabs, disable the disabled tabs, and select the selected tab on the client side.
		Integer selectedIndex = tabView.getSelectedIndex();
		int clientSideTabIndex = 0;
		List<UIComponent> children = tabView.getChildren();
		int childCount = tabView.getChildCount();

		for (int i = 0; i < childCount; i++) {

			UIComponent child = children.get(i);

			if ((child instanceof Tab) && child.isRendered()) {

				String clientSideTabIndexString = Integer.toString(clientSideTabIndex);
				Tab childTab = (Tab) child;

				if (childTab.isDisabled()) {

					// tabViewClientVarName.disableTab(clientSideTabIndexString);
					responseWriter.write(clientVarName);
					responseWriter.write(".disableTab(");
					responseWriter.write(clientSideTabIndexString);
					responseWriter.write(");");
				}
				else {

					// tabViewClientVarName.enableTab(clientSideTabIndexString);
					responseWriter.write(clientVarName);
					responseWriter.write(".enableTab(");
					responseWriter.write(clientSideTabIndexString);
					responseWriter.write(");");

					if ((selectedIndex != null) && (i == selectedIndex)) {

						// tabViewClientVarName.selectChild(clientSideTabIndexString);
						responseWriter.write(clientVarName);
						responseWriter.write(".selectChild(");
						responseWriter.write(clientSideTabIndexString);
						responseWriter.write(");");
					}
				}

				clientSideTabIndex++;
			}
		}

		// LFAI.initTabView(tabViewClientVarName, '{clientId}selectedIndex', '{clientId}',
		// [tabSelectClientBehaviorScriptFunction1, tabSelectClientBehaviorScriptFunction2,
		// tabSelectClientBehaviorScriptFunction3]);
		String clientId = uiComponent.getClientId(facesContext);
		String hiddenFieldId = clientId + "selectedIndex";

		StringBuilder clientBehaviorsArrayStringBuilder = new StringBuilder();
		clientBehaviorsArrayStringBuilder.append("[");

		boolean first = true;
		Map<String, List<ClientBehavior>> clientBehaviorMap = tabView.getClientBehaviors();
		Collection<String> eventNames = tabView.getEventNames();

		for (String eventName : eventNames) {
			List<ClientBehavior> clientBehaviorsForEvent = clientBehaviorMap.get(eventName);

			if (clientBehaviorsForEvent != null) {

				for (ClientBehavior clientBehavior : clientBehaviorsForEvent) {

					ClientBehaviorContext clientBehaviorContext = ClientBehaviorContext.createClientBehaviorContext(
							facesContext, tabView, eventName, clientId, null);

					// If <f:ajax event="tabSelect" /> is specified in the view, then render a script that submits
					// an Ajax request.
					if (TabSelectEvent.TAB_SELECT.equals(eventName)) {

						if (!first) {
							clientBehaviorsArrayStringBuilder.append(",");
						}

						//J-
						// function(event) {
						//	jsf.ajax.request(this, event, {'javax.faces.behavior.event': 'tabSelect'})
						// };
						//J+
						clientBehaviorsArrayStringBuilder.append("function(event){");
						clientBehaviorsArrayStringBuilder.append(clientBehavior.getScript(clientBehaviorContext));
						clientBehaviorsArrayStringBuilder.append("}");
						first = false;
					}
				}
			}
		}

		clientBehaviorsArrayStringBuilder.append("]");
		encodeFunctionCall(responseWriter, "LFAI.initTabView", new JavaScriptFragment(clientVarName), hiddenFieldId,
			clientId, new JavaScriptFragment(clientBehaviorsArrayStringBuilder.toString()));
	}

	@Override
	public void encodeMarkupBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// Encode the starting <div> element that represents the component.
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.startElement("div", uiComponent);
		responseWriter.writeAttribute("id", uiComponent.getClientId(facesContext), "id");
		RendererUtil.encodeStyleable(responseWriter, (Styleable) uiComponent);
	}

	@Override
	public void encodeMarkupEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// Encode the closing </div> element.
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.endElement("div");
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}

	@Override
	protected void encodeHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter, TabView tabView,
		boolean first) throws IOException {

		encodeWidgetRender(responseWriter, first);

		first = false;

		encodeClientId(responseWriter, "srcNode", tabView.getClientId(facesContext), first);
	}

	protected void encodeTabListItem(FacesContext facesContext, ResponseWriter responseWriter, Tab tab,
		boolean selected, int serverSideIndex) throws IOException {

		responseWriter.startElement("li", tab);

		// Encode the div's class attribute according to the specified tab's selected/un-selected state.
		String tabClasses = UNSELECTED_TAB_HEADER_CLASSES;

		if (selected) {
			tabClasses = SELECTED_TAB_HEADER_CLASSES;
		}

		// If the specified tab has a headerClass, then append it to the class attribute before encoding.
		String tabHeaderClass = tab.getHeaderClass();

		if (tabHeaderClass != null) {
			tabClasses += " " + tabHeaderClass;
		}

		tabClasses += " serverSideIndex" + serverSideIndex;
		responseWriter.writeAttribute("class", tabClasses, Styleable.STYLE_CLASS);
		responseWriter.startElement("a", tab);

		if (tab.isDisabled()) {
			responseWriter.writeAttribute("disabled", "disabled", null);
		}

		String clientId = tab.getClientId(facesContext);
		responseWriter.writeAttribute("href", "#" + clientId, null);

		// If the header facet exists for the specified tab, then encode the header facet.
		UIComponent headerFacet = tab.getFacet("header");

		if (headerFacet != null) {
			headerFacet.encodeAll(facesContext);
		}

		// Otherwise, render the label of the specified tab.
		else {
			String headerText = tab.getHeaderText();

			if (headerText != null) {
				responseWriter.write(headerText);
			}
		}

		responseWriter.endElement("a");
		responseWriter.endElement("li");
	}
}
