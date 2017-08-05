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
package com.liferay.faces.alloy.component.accordion.internal;

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

import com.liferay.faces.alloy.component.accordion.Accordion;
import com.liferay.faces.alloy.component.tab.Tab;
import com.liferay.faces.alloy.component.tab.TabCollapseEvent;
import com.liferay.faces.alloy.component.tab.TabExpandEvent;
import com.liferay.faces.alloy.component.tab.TabUtil;
import com.liferay.faces.util.component.Styleable;
import com.liferay.faces.util.helper.IntegerHelper;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.render.JavaScriptFragment;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Vernon Singleton
 */

//J-
@FacesRenderer(componentFamily = Accordion.COMPONENT_FAMILY, rendererType = Accordion.RENDERER_TYPE)
@ResourceDependencies(
	{
		@ResourceDependency(library = "liferay-faces-alloy", name = "alloy.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui-css/css/bootstrap.min.css"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "build/aui/aui-min.js"),
		@ResourceDependency(library = "liferay-faces-alloy-reslib", name = "liferay.js")
	}
)
//J+
public class AccordionRenderer extends AccordionRendererBase {

	// Private Constants
	private static final String ANIMATED = "animated";
	private static final String CONTAINER = "container";
	private static final String CONTENT_COLLAPSED_CLASSES = "content toggler-content toggler-content-collapsed";
	private static final String CONTENT_EXPANDED_CLASSES = "content toggler-content toggler-content-expanded";
	private static final String DOT_CONTENT = ".content";
	private static final String DOT_HEADER = ".header";
	private static final String HEADER_COLLAPSED_CLASSES = "header toggler-header toggler-header-collapsed";
	private static final String HEADER_EXPANDED_CLASSES = "header toggler-header toggler-header-expanded";
	private static final String EXPANDED = "expanded";

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(AccordionRenderer.class);

	@Override
	public void decodeClientState(FacesContext facesContext, UIComponent uiComponent) {

		// Apply the client-side state of the selected index.
		Accordion accordion = (Accordion) uiComponent;
		String hiddenFieldName = accordion.getClientId(facesContext) + "selectedIndex";
		Map<String, String> requestParameterMap = facesContext.getExternalContext().getRequestParameterMap();
		String selectedIndex = requestParameterMap.get(hiddenFieldName);

		if (selectedIndex != null) {
			accordion.setSelectedIndex(IntegerHelper.toInteger(selectedIndex, -1));
		}
	}

	@Override
	public void encodeChildren(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// If iteration should take place over a data-model, then
		Accordion accordion = (Accordion) uiComponent;
		Integer selectedIndex = accordion.getSelectedIndex();
		Object value = accordion.getValue();
		String var = accordion.getVar();
		boolean iterateOverDataModel = ((value != null) && (var != null));
		ResponseWriter responseWriter = facesContext.getResponseWriter();

		if (iterateOverDataModel) {

			// Get the first child tab and use it as a prototype tab.
			Tab prototypeChildTab = TabUtil.getFirstChildTab(accordion);

			if (prototypeChildTab != null) {

				// Encode a header <div> and content <div> for each row in the data-model.
				int rowCount = accordion.getRowCount();

				for (int i = 0; i < rowCount; i++) {

					accordion.setRowIndex(i);

					if (prototypeChildTab.isRendered()) {

						boolean selected = ((selectedIndex != null) && (i == selectedIndex));
						encodeHeader(facesContext, responseWriter, uiComponent, prototypeChildTab, selected, i);
						encodeContent(facesContext, responseWriter, uiComponent, prototypeChildTab, selected);
					}
				}

				accordion.setRowIndex(-1);
			}
			else {
				logger.warn("Unable to iterate because alloy:accordion does not have an alloy:tab child element.");
			}
		}

		// Otherwise, encode a header <div> and content <div> for each child tab of the specified accordion.
		else {
			List<UIComponent> children = uiComponent.getChildren();
			int childCount = children.size();

			for (int i = 0; i < childCount; i++) {

				UIComponent child = children.get(i);

				if ((child instanceof Tab)) {

					if (child.isRendered()) {

						Tab childTab = (Tab) child;
						boolean selected = ((selectedIndex != null) && (i == selectedIndex));
						encodeHeader(facesContext, responseWriter, uiComponent, childTab, selected, i);
						encodeContent(facesContext, responseWriter, uiComponent, childTab, selected);
					}
				}
				else {
					logger.warn("Unable to render child element of alloy:accordion since it is not alloy:tab");
				}
			}
		}

		accordion.setRowIndex(-1);
	}

	@Override
	public void encodeClientState(FacesContext facesContext, ResponseWriter responseWriter, UIComponent uiComponent)
		throws IOException {

		// Encode the hidden field that contains the client-side state of the selected index.
		Accordion accordion = (Accordion) uiComponent;
		responseWriter.startElement("input", accordion);

		String accordionClientId = accordion.getClientId(facesContext);
		String hiddenFieldName = accordionClientId + "selectedIndex";
		responseWriter.writeAttribute("id", hiddenFieldName, null);
		responseWriter.writeAttribute("name", hiddenFieldName, null);
		responseWriter.writeAttribute("type", "hidden", null);
		responseWriter.writeAttribute("value", accordion.getSelectedIndex(), null);
		responseWriter.endElement("input");

		responseWriter.startElement("input", accordion);

		hiddenFieldName = accordionClientId + "collapsedTabIndex";
		responseWriter.writeAttribute("id", hiddenFieldName, null);
		responseWriter.writeAttribute("name", hiddenFieldName, null);
		responseWriter.writeAttribute("type", "hidden", null);
		responseWriter.endElement("input");
	}

	@Override
	public void encodeJavaScriptCustom(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// Encode a script that will handle the client-side state of the selected tab index, as well as submitting
		// Ajax requests to support server-side events.
		Accordion accordion = (Accordion) uiComponent;

		// var accordionClientVarName = Liferay.component('{clientKey}');
		String clientVarName = getClientVarName(facesContext, accordion);
		String clientKey = accordion.getClientKey();

		if (clientKey == null) {
			clientKey = clientVarName;
		}

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		encodeLiferayComponentVar(responseWriter, clientVarName, clientKey);

		// Expand the selected tab.
		Integer selectedIndex = accordion.getSelectedIndex();

		if ((selectedIndex != null) && (selectedIndex > -1)) {

			int clientSideTabIndex = 0;
			List<UIComponent> children = accordion.getChildren();
			int childCount = accordion.getChildCount();

			for (int i = 0; i < childCount; i++) {

				UIComponent child = children.get(i);

				if ((child instanceof Tab) && child.isRendered()) {

					Tab childTab = (Tab) child;

					if (!childTab.isDisabled() && (i == selectedIndex)) {

						// accordionClientVarName.items[clientSideTabIndexString].expand();
						responseWriter.write(clientVarName);
						responseWriter.write(".items[");
						responseWriter.write(Integer.toString(clientSideTabIndex));
						responseWriter.write("].expand();");

						break;
					}

					clientSideTabIndex++;
				}
			}
		}

		// LFAI.initAccordion(multiple, accordionClientVarName, '{clientId}selectedIndex', '{clientId}',
		// [tabExpandClientBehaviorScriptFunction1, tabExpandClientBehaviorScriptFunction2,
		// tabExpandClientBehaviorScriptFunction3], '{clientId}collapsedTabIndex',
		// [tabCollapseClientBehaviorScriptFunction1, tabCollapseClientBehaviorScriptFunction2,
		// tabCollapseClientBehaviorScriptFunction3]);
		boolean multiple = accordion.isMultiple();
		String clientId = accordion.getClientId(facesContext);

		StringBuilder tabExpandedClientBehaviors = new StringBuilder();
		tabExpandedClientBehaviors.append("[");

		StringBuilder tabCollapsedClientBehaviors = new StringBuilder();
		tabCollapsedClientBehaviors.append("[");

		boolean firstTabExpandedClientBehavior = true;
		boolean firstTabCollapsedClientBehavior = true;
		Map<String, List<ClientBehavior>> clientBehaviorMap = accordion.getClientBehaviors();
		Collection<String> eventNames = accordion.getEventNames();

		for (String eventName : eventNames) {
			List<ClientBehavior> clientBehaviorsForEvent = clientBehaviorMap.get(eventName);

			if (clientBehaviorsForEvent != null) {

				for (ClientBehavior clientBehavior : clientBehaviorsForEvent) {

					ClientBehaviorContext clientBehaviorContext = ClientBehaviorContext.createClientBehaviorContext(
							facesContext, accordion, eventName, clientId, null);

					// If <f:ajax event="tabExpand" /> is specified in the view, then render a script that submits
					// an Ajax request.
					if (TabExpandEvent.TAB_EXPAND.equals(eventName)) {

						if (!firstTabExpandedClientBehavior) {
							tabExpandedClientBehaviors.append(",");
						}

						//J-
						// function(event) {
						//	jsf.ajax.request(this, event, {'javax.faces.behavior.event': 'tabSelect'})
						// };
						//J+
						tabExpandedClientBehaviors.append("function(event){");
						tabExpandedClientBehaviors.append(clientBehavior.getScript(clientBehaviorContext));
						tabExpandedClientBehaviors.append("}");
						firstTabExpandedClientBehavior = false;
					}

					// If <f:ajax event="tabCollapse" /> is specified in the view, then render a script that submits
					// an Ajax request.
					else if (TabCollapseEvent.TAB_COLLAPSE.equals(eventName)) {

						if (!firstTabCollapsedClientBehavior) {
							tabCollapsedClientBehaviors.append(",");
						}

						//J-
						// function(event) {
						//	jsf.ajax.request(this, event, {'javax.faces.behavior.event': 'tabSelect'})
						// };
						//J+
						tabCollapsedClientBehaviors.append("function(event){");
						tabCollapsedClientBehaviors.append(clientBehavior.getScript(clientBehaviorContext));
						tabCollapsedClientBehaviors.append("}");
						firstTabCollapsedClientBehavior = false;
					}
				}
			}
		}

		tabExpandedClientBehaviors.append("]");
		tabCollapsedClientBehaviors.append("]");
		encodeFunctionCall(responseWriter, "LFAI.initAccordion", multiple, new JavaScriptFragment(clientVarName),
			clientId + "selectedIndex", clientId, new JavaScriptFragment(tabExpandedClientBehaviors.toString()),
			clientId + "collapsedTabIndex", new JavaScriptFragment(tabCollapsedClientBehaviors.toString()));
	}

	@Override
	public void encodeMarkupBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// Encode the starting <div> element that represents the accordion.
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.startElement("div", uiComponent);
		responseWriter.writeAttribute("id", uiComponent.getClientId(facesContext), "id");
		RendererUtil.encodeStyleable(responseWriter, (Styleable) uiComponent);
	}

	@Override
	public void encodeMarkupEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// Encode the closing </div> element for the accordion.
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.endElement("div");
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}

	protected void encodeContent(FacesContext facesContext, ResponseWriter responseWriter, UIComponent uiComponent,
		Tab tab, boolean selected) throws IOException {

		// Encode the starting <div> element that represents the specified tab's content.
		responseWriter.startElement("div", tab);

		// Encode the div's class attribute according to the specified tab's collapsed/expanded state.
		String contentClass = CONTENT_COLLAPSED_CLASSES;

		if (selected) {
			contentClass = CONTENT_EXPANDED_CLASSES;
		}

		// If the specified tab has a contentClass, then append it to the class attribute before encoding.
		String tabContentClass = tab.getContentClass();

		if (tabContentClass != null) {
			contentClass += " " + tabContentClass;
		}

		responseWriter.writeAttribute("class", contentClass, Styleable.STYLE_CLASS);

		// Encode the children of the specified tab as the actual content.
		tab.encodeAll(facesContext);

		// Encode the closing </div> element for the specified tab.
		responseWriter.endElement("div");
	}

	protected void encodeHeader(FacesContext facesContext, ResponseWriter responseWriter, UIComponent uiComponent,
		Tab tab, boolean selected, int serverSideIndex) throws IOException {

		// Encode the starting <div> element that represents the specified tab's header.
		responseWriter.startElement("div", tab);

		// Encode the div's class attribute according to the specified tab's collapsed/expanded state.
		String headerClass = HEADER_COLLAPSED_CLASSES;

		if (selected) {
			headerClass = HEADER_EXPANDED_CLASSES;
		}

		// If the specified tab has a headerClass, then append it to the class attribute before encoding.
		String tabHeaderClass = tab.getHeaderClass();

		if (tabHeaderClass != null) {
			headerClass += " " + tabHeaderClass;
		}

		headerClass += " serverSideIndex" + serverSideIndex;
		responseWriter.writeAttribute("class", headerClass, Styleable.STYLE_CLASS);

		// If the header facet exists for the specified tab, then encode the header facet.
		UIComponent headerFacet = tab.getFacet("header");

		if (headerFacet != null) {
			headerFacet.encodeAll(facesContext);
		}

		// Otherwise, render the label of the specified tab.
		else {
			String headerText = (String) tab.getHeaderText();

			if (headerText != null) {
				responseWriter.write(headerText);
			}
		}

		// Encode the closing </div> element for the specified tab.
		responseWriter.endElement("div");
	}

	@Override
	protected void encodeHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter, Accordion accordion,
		boolean first) throws IOException {

		// render: true
		encodeWidgetRender(responseWriter, first);

		// container
		first = false;
		encodeClientId(responseWriter, CONTAINER, accordion.getClientId(facesContext), first);

		// animated
		encodeBoolean(responseWriter, ANIMATED, true, first);

		// If closeAllOnExpand is set to false here, Toggler/tab JavaScript is lazily initialized causing FACES-3081.
		// Workaround FACES-3081 by setting closeAllOnExpand in encodeJavaScriptCustom() if multiple="true" after tabs
		// are already initialized.
		encodeBoolean(responseWriter, "closeAllOnExpand", true, first);

		// content
		encodeString(responseWriter, "content", DOT_CONTENT, first);

		// header
		encodeString(responseWriter, "header", DOT_HEADER, first);

		// expanded: false
		encodeBoolean(responseWriter, EXPANDED, false, first);
	}
}
