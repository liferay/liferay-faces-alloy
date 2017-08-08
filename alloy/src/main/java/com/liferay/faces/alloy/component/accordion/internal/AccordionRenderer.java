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
import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.accordion.Accordion;
import com.liferay.faces.alloy.component.data.internal.DataEncoderBase;
import com.liferay.faces.alloy.component.tab.Tab;
import com.liferay.faces.alloy.component.tab.TabCollapseEvent;
import com.liferay.faces.alloy.component.tab.TabExpandEvent;
import com.liferay.faces.alloy.component.tab.internal.DataEncoderTabImpl;
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
		@ResourceDependency(library = "liferay-faces-alloy", name = "alloy.js"),
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

	private static int getIntegerOrDefault(Integer i, int defaultValue) {

		if (i != null) {
			return i;
		}
		else {
			return defaultValue;
		}
	}

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

		Accordion accordion = (Accordion) uiComponent;
		Integer selectedIndex = accordion.getSelectedIndex();
		DataEncoderBase dataEncoder = new DataEncoderTabMarkupImpl(selectedIndex);
		dataEncoder.encodeColumns(facesContext, accordion);
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

			DataEncoderBase dataEncoder = new DataEncoderTabJavaScriptImpl(selectedIndex, clientVarName);
			dataEncoder.encodeColumns(facesContext, accordion);
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

	private static class DataEncoderTabJavaScriptImpl extends DataEncoderTabImpl {

		// Private Final Data Members
		private final String clientVarName;
		private final int selectedIndex;

		// Private Data Members
		int clientSideTabIndex = 0;

		public DataEncoderTabJavaScriptImpl(Integer selectedIndex, String clientVarName) {

			this.selectedIndex = getIntegerOrDefault(selectedIndex, -1);
			this.clientVarName = clientVarName;
		}

		@Override
		protected void encodeColumn(FacesContext facesContext, UIData uiData, UIColumn currentUIColumn,
			int currentIndex) throws IOException {

			if ((currentUIColumn instanceof Tab) && currentUIColumn.isRendered()) {

				Tab childTab = (Tab) currentUIColumn;

				if (!childTab.isDisabled() && (currentIndex == selectedIndex)) {

					// accordionClientVarName.items[clientSideTabIndexString].expand();
					ResponseWriter responseWriter = facesContext.getResponseWriter();
					responseWriter.write(clientVarName);
					responseWriter.write(".items[");
					responseWriter.write(Integer.toString(clientSideTabIndex));
					responseWriter.write("].expand();");
				}

				clientSideTabIndex++;
			}
		}
	}

	private static class DataEncoderTabMarkupImpl extends DataEncoderTabImpl {

		// Private Final Data Members
		private final int selectedIndex;

		public DataEncoderTabMarkupImpl(Integer selectedIndex) {
			this.selectedIndex = getIntegerOrDefault(selectedIndex, -1);
		}

		@Override
		protected void encodeColumn(FacesContext facesContext, UIData uiData, UIColumn currentUIColumn,
			int serverSideIndex) throws IOException {

			if ((currentUIColumn instanceof Tab) && currentUIColumn.isRendered()) {

				// Encode the starting <div> element that represents the specified tab's header.
				ResponseWriter responseWriter = facesContext.getResponseWriter();
				Tab tab = (Tab) currentUIColumn;
				responseWriter.startElement("div", tab);

				// Encode the div's class attribute according to the specified tab's collapsed/expanded state.
				String headerClass = HEADER_COLLAPSED_CLASSES;
				boolean selected = (serverSideIndex == selectedIndex);

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

				// Encode the closing </div> element for the specified tab's header.
				responseWriter.endElement("div");

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
		}
	}
}
