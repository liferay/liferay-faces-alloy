/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.button;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.ContextCallback;
import javax.faces.component.TransientStateHelper;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.FacesEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import com.liferay.faces.util.component.ComponentUtil;


/**
 * @author  Neil Griffin
 */
public class SplitButton extends SplitButtonCompat {

	// Public Constants
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.button.internal.SplitButtonRenderer";

	// Private Members
	private String rendererType;
	private Button wrappedButton;

	public SplitButton() {
		setRendererType(RENDERER_TYPE);
	}

	public SplitButton(Button wrappedButton) {
		this();
		this.wrappedButton = wrappedButton;
	}

	@Override
	public void addClientBehavior(String eventName, ClientBehavior behavior) {
		getWrappedButton().addClientBehavior(eventName, behavior);
	}

	@Override
	public void broadcast(FacesEvent event) throws AbortProcessingException {
		getWrappedButton().broadcast(event);
	}

	@Override
	public void clearInitialState() {
		getWrappedButton().clearInitialState();
	}

	@Override
	public void decode(FacesContext context) {
		getWrappedButton().decode(context);
	}

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		getWrappedButton().encodeAll(context);
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		getWrappedButton().encodeBegin(context);
	}

	@Override
	public void encodeChildren(FacesContext context) throws IOException {
		getWrappedButton().encodeChildren(context);
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		getWrappedButton().encodeEnd(context);
	}

	@Override
	public UIComponent findComponent(String expr) {
		return getWrappedButton().findComponent(expr);
	}

	@Override
	public String getAccesskey() {
		return getWrappedButton().getAccesskey();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return getWrappedButton().getAttributes();
	}

	@Override
	public String getCharset() {
		return null;
	}

	@Override
	public int getChildCount() {
		return getWrappedButton().getChildCount();
	}

	@Override
	public List<UIComponent> getChildren() {
		return getWrappedButton().getChildren();
	}

	@Override
	public Map<String, List<ClientBehavior>> getClientBehaviors() {
		return getWrappedButton().getClientBehaviors();
	}

	@Override
	public String getClientId() {
		return getWrappedButton().getClientId();
	}

	@Override
	public String getClientId(FacesContext context) {
		return getWrappedButton().getClientId();
	}

	public String getClientKey() {
		return null;
	}

	@Override
	public String getContainerClientId(FacesContext context) {
		return getWrappedButton().getContainerClientId(context);
	}

	@Override
	public Converter getConverter() {
		return getWrappedButton().getConverter();
	}

	@Override
	public String getCoords() {
		return null;
	}

	@Override
	public String getDefaultEventName() {
		return getWrappedButton().getDefaultEventName();
	}

	@Override
	public String getDir() {
		return getWrappedButton().getDir();
	}

	@Override
	public Collection<String> getEventNames() {
		return getWrappedButton().getEventNames();
	}

	@Override
	public UIComponent getFacet(String name) {
		return getWrappedButton().getFacet(name);
	}

	@Override
	public int getFacetCount() {
		return getWrappedButton().getFacetCount();
	}

	@Override
	public Map<String, UIComponent> getFacets() {
		return getWrappedButton().getFacets();
	}

	@Override
	public Iterator<UIComponent> getFacetsAndChildren() {
		return getWrappedButton().getFacetsAndChildren();
	}

	@Override
	public String getFamily() {
		return getWrappedButton().getFamily();
	}

	@Override
	public String getHreflang() {
		return null;
	}

	@Override
	public String getId() {
		return getWrappedButton().getId();
	}

	@Override
	public String getLang() {
		return getWrappedButton().getLang();
	}

	@Override
	public List<SystemEventListener> getListenersForEventClass(Class<? extends SystemEvent> eventClass) {
		return getWrappedButton().getListenersForEventClass(eventClass);
	}

	@Override
	public Object getLocalValue() {
		return getWrappedButton().getLocalValue();
	}

	@Override
	public UIComponent getNamingContainer() {
		return getWrappedButton().getNamingContainer();
	}

	@Override
	public String getOnblur() {
		return getWrappedButton().getOnblur();
	}

	@Override
	public String getOnclick() {
		return getWrappedButton().getOnclick();
	}

	@Override
	public String getOndblclick() {
		return getWrappedButton().getOndblclick();
	}

	@Override
	public String getOnfocus() {
		return getWrappedButton().getOnfocus();
	}

	@Override
	public String getOnkeydown() {
		return getWrappedButton().getOnkeydown();
	}

	@Override
	public String getOnkeypress() {
		return getWrappedButton().getOnkeypress();
	}

	@Override
	public String getOnkeyup() {
		return getWrappedButton().getOnkeyup();
	}

	@Override
	public String getOnmousedown() {
		return getWrappedButton().getOnmousedown();
	}

	@Override
	public String getOnmousemove() {
		return getWrappedButton().getOnmousemove();
	}

	@Override
	public String getOnmouseout() {
		return getWrappedButton().getOnmouseout();
	}

	@Override
	public String getOnmouseover() {
		return getWrappedButton().getOnmouseover();
	}

	@Override
	public String getOnmouseup() {
		return getWrappedButton().getOnmouseup();
	}

	@Override
	public String getOutcome() {
		return getWrappedButton().getOutcome();
	}

	@Override
	public UIComponent getParent() {
		return getWrappedButton().getParent();
	}

	@Override
	public String getRel() {
		return null;
	}

	@Override
	public String getRendererType() {
		return rendererType;
	}

	@Override
	public boolean getRendersChildren() {
		return getWrappedButton().getRendersChildren();
	}

	@Override
	public Map<String, String> getResourceBundleMap() {
		return getWrappedButton().getResourceBundleMap();
	}

	@Override
	public String getRev() {
		return null;
	}

	@Override
	public String getShape() {
		return null;
	}

	@Override
	public String getStyle() {
		return getWrappedButton().getStyle();
	}

	@Override
	public String getStyleClass() {

		String styleClass = getWrappedButton().getStyleClass();

		if (styleClass == null) {
			styleClass = "btn-default";
		}

		String defaultButtonClass = null;

		if (!styleClass.contains("btn-")) {
			defaultButtonClass = "btn-default";
		}

		String disabledClass = null;
		boolean disabled = isDisabled();

		if (disabled) {
			disabledClass = "disabled";
		}

		styleClass = ComponentUtil.concatCssClasses("btn", defaultButtonClass, disabledClass, styleClass);

		return styleClass;
	}

	@Override
	public String getTabindex() {
		return getWrappedButton().getTabindex();
	}

	@Override
	public String getTarget() {
		return null;
	}

	@Override
	public String getTitle() {
		return getWrappedButton().getTitle();
	}

	@Override
	public TransientStateHelper getTransientStateHelper(boolean create) {
		return getWrappedButton().getTransientStateHelper(create);
	}

	@Override
	public String getType() {
		return getWrappedButton().getType();
	}

	@Override
	public Object getValue() {
		return getWrappedButton().getValue();
	}

	@SuppressWarnings("deprecation")
	@Override
	public javax.faces.el.ValueBinding getValueBinding(String name) {
		return getWrappedButton().getValueBinding(name);
	}

	@Override
	public ValueExpression getValueExpression(String name) {
		return getWrappedButton().getValueExpression(name);
	}

	@Override
	public Button getWrappedButton() {
		return wrappedButton;
	}

	@Override
	public boolean initialStateMarked() {
		return getWrappedButton().initialStateMarked();
	}

	@Override
	public boolean invokeOnComponent(FacesContext context, String clientId, ContextCallback callback)
		throws FacesException {
		return getWrappedButton().invokeOnComponent(context, clientId, callback);
	}

	@Override
	public boolean isDisabled() {
		return getWrappedButton().isDisabled();
	}

	@Override
	public boolean isIncludeViewParams() {
		return getWrappedButton().isIncludeViewParams();
	}

	@Override
	public boolean isInView() {
		return getWrappedButton().isInView();
	}

	@Override
	public boolean isRendered() {
		return getWrappedButton().isRendered();
	}

	@Override
	public boolean isTransient() {
		return getWrappedButton().isTransient();
	}

	@Override
	public void markInitialState() {
		getWrappedButton().markInitialState();
	}

	@Override
	public void processDecodes(FacesContext context) {
		getWrappedButton().processDecodes(context);
	}

	@Override
	public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
		getWrappedButton().processEvent(event);
	}

	@Override
	public void processRestoreState(FacesContext context, Object state) {
		getWrappedButton().processRestoreState(context, state);
	}

	@Override
	public Object processSaveState(FacesContext context) {
		return getWrappedButton().processSaveState(context);
	}

	@Override
	public void processUpdates(FacesContext context) {
		getWrappedButton().processUpdates(context);
	}

	@Override
	public void processValidators(FacesContext context) {
		getWrappedButton().processValidators(context);
	}

	@Override
	public void queueEvent(FacesEvent event) {
		getWrappedButton().queueEvent(event);
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		getWrappedButton().restoreState(context, state);
	}

	@Override
	public void restoreTransientState(FacesContext context, Object state) {
		getWrappedButton().restoreTransientState(context, state);
	}

	@Override
	public Object saveState(FacesContext context) {
		return getWrappedButton().saveState(context);
	}

	@Override
	public Object saveTransientState(FacesContext context) {
		return getWrappedButton().saveTransientState(context);
	}

	@Override
	public void setAccesskey(String accesskey) {
		getWrappedButton().setAccesskey(accesskey);
	}

	@Override
	public void setCharset(String charset) {
		// no-op
	}

	public void setClientKey(String clientKey) {
		// no-op
	}

	@Override
	public void setConverter(Converter converter) {
		getWrappedButton().setConverter(converter);
	}

	@Override
	public void setCoords(String coords) {
		// no-op
	}

	@Override
	public void setDir(String dir) {
		getWrappedButton().setDir(dir);
	}

	@Override
	public void setDisabled(boolean disabled) {
		getWrappedButton().setDisabled(disabled);
	}

	@Override
	public void setHreflang(String hreflang) {
		// no-op
	}

	@Override
	public void setId(String id) {
		getWrappedButton().setId(id);
	}

	@Override
	public void setIncludeViewParams(boolean includeViewParams) {
		getWrappedButton().setIncludeViewParams(includeViewParams);
	}

	@Override
	public void setInView(boolean isInView) {
		getWrappedButton().setInView(isInView);
	}

	@Override
	public void setLang(String lang) {
		getWrappedButton().setLang(lang);
	}

	@Override
	public void setOnblur(String onblur) {
		getWrappedButton().setOnblur(onblur);
	}

	@Override
	public void setOnclick(String onclick) {
		getWrappedButton().setOnclick(onclick);
	}

	@Override
	public void setOndblclick(String ondblclick) {
		getWrappedButton().setOndblclick(ondblclick);
	}

	@Override
	public void setOnfocus(String onfocus) {
		getWrappedButton().setOnfocus(onfocus);
	}

	@Override
	public void setOnkeydown(String onkeydown) {
		getWrappedButton().setOnkeydown(onkeydown);
	}

	@Override
	public void setOnkeypress(String onkeypress) {
		getWrappedButton().setOnkeypress(onkeypress);
	}

	@Override
	public void setOnkeyup(String onkeyup) {
		getWrappedButton().setOnkeyup(onkeyup);
	}

	@Override
	public void setOnmousedown(String onmousedown) {
		getWrappedButton().setOnmousedown(onmousedown);
	}

	@Override
	public void setOnmousemove(String onmousemove) {
		getWrappedButton().setOnmousemove(onmousemove);
	}

	@Override
	public void setOnmouseout(String onmouseout) {
		getWrappedButton().setOnmouseout(onmouseout);
	}

	@Override
	public void setOnmouseover(String onmouseover) {
		getWrappedButton().setOnmouseover(onmouseover);
	}

	@Override
	public void setOnmouseup(String onmouseup) {
		getWrappedButton().setOnmouseup(onmouseup);
	}

	@Override
	public void setOutcome(String outcome) {
		getWrappedButton().setOutcome(outcome);
	}

	@Override
	public void setParent(UIComponent parent) {
		getWrappedButton().setParent(parent);
	}

	@Override
	public void setRel(String rel) {
		// no-op
	}

	@Override
	public void setRendered(boolean rendered) {
		getWrappedButton().setRendered(rendered);
	}

	@Override
	public void setRendererType(String rendererType) {
		this.rendererType = rendererType;
	}

	@Override
	public void setRev(String rev) {
		// no-op
	}

	@Override
	public void setShape(String shape) {
		// no-op
	}

	@Override
	public void setStyle(String style) {
		getWrappedButton().setStyle(style);
	}

	@Override
	public void setStyleClass(String styleClass) {
		getWrappedButton().setStyleClass(styleClass);
	}

	@Override
	public void setTabindex(String tabindex) {
		getWrappedButton().setTabindex(tabindex);
	}

	@Override
	public void setTarget(String target) {
		// no-op
	}

	@Override
	public void setTitle(String title) {
		getWrappedButton().setTitle(title);
	}

	@Override
	public void setTransient(boolean newTransientValue) {
		getWrappedButton().setTransient(newTransientValue);
	}

	@Override
	public void setType(String type) {
		getWrappedButton().setType(type);
	}

	@Override
	public void setValue(Object value) {
		getWrappedButton().setValue(value);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setValueBinding(String name, javax.faces.el.ValueBinding binding) {
		getWrappedButton().setValueBinding(name, binding);
	}

	@Override
	public void setValueExpression(String name, ValueExpression binding) {
		getWrappedButton().setValueExpression(name, binding);
	}

	public void setWrappedButton(Button wrappedButton) {
		this.wrappedButton = wrappedButton;
	}

	@Override
	public void subscribeToEvent(Class<? extends SystemEvent> eventClass,
		ComponentSystemEventListener componentListener) {
		getWrappedButton().subscribeToEvent(eventClass, componentListener);
	}

	@Override
	public void unsubscribeFromEvent(Class<? extends SystemEvent> eventClass,
		ComponentSystemEventListener componentListener) {
		getWrappedButton().unsubscribeFromEvent(eventClass, componentListener);
	}

	@Override
	public boolean visitTree(VisitContext context, VisitCallback callback) {
		return getWrappedButton().visitTree(context, callback);
	}
}
