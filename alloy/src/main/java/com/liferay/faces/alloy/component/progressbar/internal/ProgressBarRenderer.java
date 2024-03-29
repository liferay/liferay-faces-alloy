/**
 * Copyright (c) 2000-2022 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.progressbar.internal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.progressbar.ProgressBar;
import com.liferay.faces.util.component.Styleable;
import com.liferay.faces.util.context.FacesRequestContext;
import com.liferay.faces.util.render.BufferedScriptResponseWriter;
import com.liferay.faces.util.render.JavaScriptFragment;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Bruno Basto
 * @author  Kyle Stiemann
 */

//J-
@FacesRenderer(componentFamily = ProgressBar.COMPONENT_FAMILY, rendererType = ProgressBar.RENDERER_TYPE)
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
public class ProgressBarRenderer extends ProgressBarRendererBase {

	private static final String COMPLETE = "complete";
	private static final String CONTENT_BOX_SUFFIX = "_contentBox";
	private static final String HIDDEN_SUFFIX = "_hidden";
	private static final String PAGE_DIRECTION = "pageDirection";
	private static final String TOKEN = "{0}";
	private static final String VALUE_CHANGE = "valueChange";
	private static final String VERTICAL = "vertical";

	/**
	 * This method is being overridden in order to set the value of the progressBar when server-side polling occurs.
	 * Otherwise, this method simply calls super.encodeJavaScript() in order to render the component normally.
	 */
	@Override
	public void encodeJavaScript(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		if (isAjaxPolling(facesContext, uiComponent)) {

			ProgressBar progressBar = (ProgressBar) uiComponent;
			String clientVarName = getClientVarName(facesContext, progressBar);
			String clientKey = progressBar.getClientKey();

			if (clientKey == null) {
				clientKey = clientVarName;
			}

			// Buffer all JavaScript so that it is rendered in the <eval> section of the partial response.
			BufferedScriptResponseWriter bufferedScriptResponseWriter = new BufferedScriptResponseWriter();
			String clientId = progressBar.getClientId(facesContext);
			String hiddenClientId = clientId.concat(HIDDEN_SUFFIX);

			//J-
			//	Liferay.component('clientKey')
			//J+
			JavaScriptFragment liferayComponent = new JavaScriptFragment("Liferay.component('" + clientKey + "')");
			Integer value = progressBar.getValue();

			//J-
			//	LFAI.setProgressBarServerValue('hiddenClientId', Liferay.component('clientKey'), value);
			//J+
			encodeFunctionCall(bufferedScriptResponseWriter, "LFAI.setProgressBarServerValue", hiddenClientId,
				liferayComponent, value);

			FacesRequestContext facesRequestContext = FacesRequestContext.getCurrentInstance();
			facesRequestContext.addScript(bufferedScriptResponseWriter.toString());
		}
		else {
			super.encodeJavaScript(facesContext, uiComponent);
		}
	}

	@Override
	public void encodeJavaScriptCustom(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		ProgressBar progressBar = (ProgressBar) uiComponent;
		String clientVarName = getClientVarName(facesContext, progressBar);
		String clientKey = progressBar.getClientKey();

		if (clientKey == null) {
			clientKey = clientVarName;
		}

		Map<String, List<ClientBehavior>> clientBehaviorMap = progressBar.getClientBehaviors();
		List<ClientBehavior> pollEventClientBehaviors = clientBehaviorMap.get("poll");

		// If the developer has specified <f:ajax event="poll" />, then
		String javaScriptText = "Liferay.component('".concat(clientKey).concat("')");

		if ((pollEventClientBehaviors != null) && !pollEventClientBehaviors.isEmpty()) {

			// Build up an anonymous function, which contains all clientBehaviors for the "poll" event, so that it can
			// be passed to LFAI.initProgressBarServerMode().

			//J-
			//	function(pollingFunction) {
			//		var event = null;
			//		jsf.ajax.request('clientId', event, 'poll', {
			//			render: 'clientId ' + render,
			//			execute: 'clientId ' + execute,
			//			onevent: function(data){
			//				if(data.status==='success'){
			//					pollingFunction();
			//				}
			//				onevent();
			//			},
			//			onerror: function(data){
			//				Liferay.component('clientKey').stopPolling();
			//				onerror();
			//			}
			//		});
			//		jsf.ajax.request(...);
			//		...
			//		jsf.ajax.request(...);
			//	}
			//J+
			StringBuilder buf = new StringBuilder();
			buf.append("function(pollingFunction){");

			// ClientBehavior.getScript(ClientBehaviorContext clientBehaviorContext) renders javascript which expects a
			// javascript variable named 'event' to have been initilized and contain the DOM event which triggered the
			// request. Since there is no DOM event which triggers the progressBar events, render javascript
			// initializing event to null;
			buf.append("var event = null;");

			String clientId = progressBar.getClientId(facesContext);
			ClientBehaviorContext clientBehaviorContext = ClientBehaviorContext.createClientBehaviorContext(
					facesContext, progressBar, "poll", clientId, null);
			int size = pollEventClientBehaviors.size();

			//J-
			//	Liferay.component('clientKey')
			//J+
			JavaScriptFragment liferayComponent = new JavaScriptFragment(javaScriptText);

			// It is possible to specify multiple <f:ajax event="poll" /> tags (even though there is no benefit).
			for (int i = 0; i < size; i++) {

				ClientBehavior pollEventClientBehavior = pollEventClientBehaviors.get(i);

				if (i == 0) {

					AjaxBehavior firstPollEventAjaxBehavior = (AjaxBehavior) pollEventClientBehavior;
					String stopPollingFunction = "function(){".concat(liferayComponent.toString()).concat(
							".stopPolling();}");

					// Ensure that render is '@this', execute is '@this', the pollingFunction is called onsuccess, and
					// the stopPolling function is called onerror.
					pollEventClientBehavior = new ProgressBarAjaxBehavior(firstPollEventAjaxBehavior, "pollingFunction",
							stopPollingFunction);
				}

				buf.append(pollEventClientBehavior.getScript(clientBehaviorContext));
				buf.append(";");
			}

			buf.append("}");

			JavaScriptFragment anonymousFunction = new JavaScriptFragment(buf.toString());
			Integer pollingDelay = progressBar.getPollingDelay();

			//J-
			//	LFAI.initProgressBarServerMode(Liferay.component('clientKey'), 'clientId', pollingDelay,
			//		function(pollingFunction) {
			//			var event = null;
			//			jsf.ajax.request('clientId', event, 'poll', {
			//				render: 'clientId ' + render,
			//				execute: 'clientId ' + execute,
			//				onevent: function(data){
			//					if(data.status==='success'){
			//						pollingFunction();
			//					}
			//					onevent();
			//				},
			//				onerror: function(data){
			//					Liferay.component('clientKey').stopPolling();
			//					onerror();
			//				}
			//			});
			//			jsf.ajax.request(...);
			//			...
			//			jsf.ajax.request(...);
			//		}
			//	);
			//J+
			encodeFunctionCall(responseWriter, "LFAI.initProgressBarServerMode", liferayComponent, clientId,
				pollingDelay, anonymousFunction);
		}

		// Otherwise the component is in client mode.
		else {

			//J-
			//	LFAI.initProgressBarClientMode(Liferay.component('clientKey'), projectStageDevelopment);
			//J+
			JavaScriptFragment liferayComponent = new JavaScriptFragment(javaScriptText);
			encodeFunctionCall(responseWriter, "LFAI.initProgressBarClientMode", liferayComponent);
		}
	}

	@Override
	public void encodeMarkupBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// If the component is not currently polling the server via an Ajax request, then render markup.
		// Otherwise, only the JavaScript necessary to update the progressBar is rendered.
		if (!isAjaxPolling(facesContext, uiComponent)) {

			// Start the encoding of the outermost <div> element.
			ResponseWriter responseWriter = facesContext.getResponseWriter();
			responseWriter.startElement("div", uiComponent);

			String clientId = uiComponent.getClientId(facesContext);
			responseWriter.writeAttribute("id", clientId, "id");

			Styleable styleable = (Styleable) uiComponent;
			RendererUtil.encodeStyleable(responseWriter, styleable);

			// If the developer has specified <f:ajax event="poll" />, then render the hidden input which flags
			// whether or not the component is currently polling.
			if (isServerPollingEnabled(uiComponent)) {

				String hiddenClientId = clientId.concat(HIDDEN_SUFFIX);
				responseWriter.startElement("input", null);
				responseWriter.writeAttribute("id", hiddenClientId, null);
				responseWriter.writeAttribute("name", hiddenClientId, null);
				responseWriter.writeAttribute("type", "hidden", null);
				responseWriter.writeAttribute("value", "", null);
				responseWriter.endElement("input");
			}

			// Encode the contentBox of the progressBar.
			String contentBoxClientId = clientId.concat(CONTENT_BOX_SUFFIX);
			responseWriter.startElement("div", null);
			responseWriter.writeAttribute("id", contentBoxClientId, null);
			responseWriter.endElement("div");
		}
	}

	@Override
	public void encodeMarkupEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// If the component is not currently polling the server via an Ajax request, then render markup.
		// Otherwise, only the JavaScript necessary to update the progressBar is rendered.
		if (!isAjaxPolling(facesContext, uiComponent)) {

			// Finish the encoding of the outermost </div> element.
			ResponseWriter responseWriter = facesContext.getResponseWriter();
			responseWriter.endElement("div");
		}
	}

	@Override
	protected void encodeHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter,
		ProgressBar progressBar, boolean first) throws IOException {

		// render: true
		encodeWidgetRender(responseWriter, first);
		first = false;

		// contentBox
		String clientId = progressBar.getClientId(facesContext);
		String contentBoxClientId = clientId.concat(CONTENT_BOX_SUFFIX);
		encodeClientId(responseWriter, CONTENT_BOX, contentBoxClientId, first);

		// Begin encoding event listeners that occur on the event.
		encodeNonEscapedObject(responseWriter, "on", "", first);
		responseWriter.write("{");

		// complete
		boolean onFirst = true;
		String oncomplete = progressBar.getOncomplete();
		Map<String, List<ClientBehavior>> clientBehaviorMap = progressBar.getClientBehaviors();
		List<ClientBehavior> clientBehaviorsForComplete = clientBehaviorMap.get("progressComplete");

		if ((oncomplete != null) || ((clientBehaviorsForComplete != null) && !clientBehaviorsForComplete.isEmpty())) {

			//J-
			//	function(event) {
			//		oncomplete();
			//		jsf.ajax.request(...);
			//		jsf.ajax.request(...);
			//		...
			//		jsf.ajax.request(...);
			//	}
			//J+
			StringBuilder onCompleteBuilder = new StringBuilder();
			onCompleteBuilder.append("function(event){");

			if (oncomplete != null) {
				onCompleteBuilder.append(oncomplete);
			}

			if ((clientBehaviorsForComplete != null) && !clientBehaviorsForComplete.isEmpty()) {

				ClientBehaviorContext clientBehaviorContext = ClientBehaviorContext.createClientBehaviorContext(
						facesContext, progressBar, "progressComplete", clientId, null);

				for (ClientBehavior clientBehaviorForComplete : clientBehaviorsForComplete) {
					onCompleteBuilder.append(clientBehaviorForComplete.getScript(clientBehaviorContext));
					onCompleteBuilder.append(";");
				}
			}

			onCompleteBuilder.append("}");
			encodeNonEscapedObject(responseWriter, COMPLETE, onCompleteBuilder.toString(), onFirst);
			onFirst = false;
		}

		// label
		String label = progressBar.getLabel();

		// If the developer has specified a label and the label contains the TOKEN representin the value, then create
		// a callback which will update the label each time the value changes.

		//J-
		//	valueChange: function(event) {
		//		this.set('label','escapedLabel'.replace(LFAI.TOKEN_REGEX, event.newVal));
		//	}
		//J+
		if ((label != null) && label.contains(TOKEN)) {

			String escapedLabel = RendererUtil.escapeJavaScript(label);
			encodeNonEscapedObject(responseWriter, VALUE_CHANGE,
				"function(event){this.set('label','".concat(escapedLabel).concat(
					"'.replace(LFAI.TOKEN_REGEX, event.newVal));}"), onFirst);
			onFirst = false;
		}

		// Finish encoding event listeners that occur on the event.
		responseWriter.write("}");
	}

	@Override
	protected void encodeLabel(ResponseWriter responseWriter, ProgressBar progressBar, String label, boolean first)
		throws IOException {

		Integer value = progressBar.getValue();
		label = label.replace(TOKEN, value.toString());
		super.encodeLabel(responseWriter, progressBar, label, first);
	}

	@Override
	protected void encodeOrientation(ResponseWriter responseWriter, ProgressBar progressBar, String layout,
		boolean first) throws IOException {

		if (PAGE_DIRECTION.equals(layout)) {
			super.encodeOrientation(responseWriter, progressBar, VERTICAL, first);
		}
	}

	private boolean isAjaxPolling(FacesContext facesContext, UIComponent uiComponent) {

		boolean polling = false;

		if (isServerPollingEnabled(uiComponent) && facesContext.getPartialViewContext().isAjaxRequest()) {

			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, String> requestParameterMap = externalContext.getRequestParameterMap();
			String hiddenClientId = uiComponent.getClientId(facesContext) + HIDDEN_SUFFIX;
			String pollingString = requestParameterMap.get(hiddenClientId);
			polling = Boolean.parseBoolean(pollingString);
		}

		return polling;
	}

	private boolean isServerPollingEnabled(UIComponent uiComponent) {

		ProgressBar progressBar = (ProgressBar) uiComponent;
		Map<String, List<ClientBehavior>> clientBehaviorMap = progressBar.getClientBehaviors();
		List<ClientBehavior> clientBehaviorsForPolling = clientBehaviorMap.get("poll");

		return ((clientBehaviorsForPolling != null) && !clientBehaviorsForPolling.isEmpty());
	}
}
