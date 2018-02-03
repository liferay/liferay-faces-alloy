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
package com.liferay.faces.alloy.component.commandbutton;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.ContextCallback;
import javax.faces.component.TransientStateHelper;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionListener;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ComponentSystemEventListener;
import javax.faces.event.FacesEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import com.liferay.faces.util.component.ComponentUtil;


/**
 * @author  Vernon Singleton
 */
public class SplitCommandButton extends SplitCommandButtonCompat {

	// Public Constants
	public static final String RENDERER_TYPE =
		"com.liferay.faces.alloy.component.button.internal.SplitCommandButtonRenderer";

	// Private Data Members
	private String rendererType;
	private CommandButton wrappedCommandButton;

	public SplitCommandButton() {
		setRendererType(RENDERER_TYPE);
	}

	public SplitCommandButton(CommandButton wrappedCommandButton) {
		this();
		this.wrappedCommandButton = wrappedCommandButton;
	}

	@Override
	public void addActionListener(ActionListener listener) {
		getWrappedCommandButton().addActionListener(listener);
	}

	@Override
	public void addClientBehavior(String eventName, ClientBehavior behavior) {
		getWrappedCommandButton().addClientBehavior(eventName, behavior);
	}

	@Override
	public void broadcast(FacesEvent event) throws AbortProcessingException {
		getWrappedCommandButton().broadcast(event);
	}

	@Override
	public void clearInitialState() {
		getWrappedCommandButton().clearInitialState();
	}

	@Override
	public void decode(FacesContext context) {
		getWrappedCommandButton().decode(context);
	}

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		getWrappedCommandButton().encodeAll(context);
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		getWrappedCommandButton().encodeBegin(context);
	}

	@Override
	public void encodeChildren(FacesContext context) throws IOException {
		getWrappedCommandButton().encodeChildren(context);
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		getWrappedCommandButton().encodeEnd(context);
	}

	@Override
	public UIComponent findComponent(String expr) {
		return getWrappedCommandButton().findComponent(expr);
	}

	@Override
	public String getAccesskey() {
		return getWrappedCommandButton().getAccesskey();
	}

	@Override
	@SuppressWarnings("deprecation")
	public javax.faces.el.MethodBinding getAction() {
		return getWrappedCommandButton().getAction();
	}

	@Override
	public MethodExpression getActionExpression() {
		return getWrappedCommandButton().getActionExpression();
	}

	@Override
	@SuppressWarnings("deprecation")
	public javax.faces.el.MethodBinding getActionListener() {
		return getWrappedCommandButton().getActionListener();
	}

	@Override
	public ActionListener[] getActionListeners() {
		return getWrappedCommandButton().getActionListeners();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return getWrappedCommandButton().getAttributes();
	}

	@Override
	public String getCharset() {
		return null;
	}

	@Override
	public int getChildCount() {
		return getWrappedCommandButton().getChildCount();
	}

	@Override
	public List<UIComponent> getChildren() {
		return getWrappedCommandButton().getChildren();
	}

	@Override
	public Map<String, List<ClientBehavior>> getClientBehaviors() {
		return getWrappedCommandButton().getClientBehaviors();
	}

	@Override
	public String getClientId() {
		return getWrappedCommandButton().getClientId();
	}

	@Override
	public String getClientId(FacesContext context) {
		return getWrappedCommandButton().getClientId();
	}

	public String getClientKey() {
		return null;
	}

	@Override
	public String getContainerClientId(FacesContext context) {
		return getWrappedCommandButton().getContainerClientId(context);
	}

	@Override
	public String getCoords() {
		return null;
	}

	@Override
	public String getDefaultEventName() {
		return getWrappedCommandButton().getDefaultEventName();
	}

	@Override
	public String getDir() {
		return getWrappedCommandButton().getDir();
	}

	@Override
	public Collection<String> getEventNames() {
		return getWrappedCommandButton().getEventNames();
	}

	@Override
	public UIComponent getFacet(String name) {
		return getWrappedCommandButton().getFacet(name);
	}

	@Override
	public int getFacetCount() {
		return getWrappedCommandButton().getFacetCount();
	}

	@Override
	public Map<String, UIComponent> getFacets() {
		return getWrappedCommandButton().getFacets();
	}

	@Override
	public Iterator<UIComponent> getFacetsAndChildren() {
		return getWrappedCommandButton().getFacetsAndChildren();
	}

	@Override
	public String getFamily() {
		return getWrappedCommandButton().getFamily();
	}

	@Override
	public String getHreflang() {
		return null;
	}

	@Override
	public String getId() {
		return getWrappedCommandButton().getId();
	}

	@Override
	public String getLang() {
		return getWrappedCommandButton().getLang();
	}

	@Override
	public List<SystemEventListener> getListenersForEventClass(Class<? extends SystemEvent> eventClass) {
		return getWrappedCommandButton().getListenersForEventClass(eventClass);
	}

	@Override
	public UIComponent getNamingContainer() {
		return getWrappedCommandButton().getNamingContainer();
	}

	@Override
	public String getOnblur() {
		return getWrappedCommandButton().getOnblur();
	}

	@Override
	public String getOnclick() {
		return getWrappedCommandButton().getOnclick();
	}

	@Override
	public String getOndblclick() {
		return getWrappedCommandButton().getOndblclick();
	}

	@Override
	public String getOnfocus() {
		return getWrappedCommandButton().getOnfocus();
	}

	@Override
	public String getOnkeydown() {
		return getWrappedCommandButton().getOnkeydown();
	}

	@Override
	public String getOnkeypress() {
		return getWrappedCommandButton().getOnkeypress();
	}

	@Override
	public String getOnkeyup() {
		return getWrappedCommandButton().getOnkeyup();
	}

	@Override
	public String getOnmousedown() {
		return getWrappedCommandButton().getOnmousedown();
	}

	@Override
	public String getOnmousemove() {
		return getWrappedCommandButton().getOnmousemove();
	}

	@Override
	public String getOnmouseout() {
		return getWrappedCommandButton().getOnmouseout();
	}

	@Override
	public String getOnmouseover() {
		return getWrappedCommandButton().getOnmouseover();
	}

	@Override
	public String getOnmouseup() {
		return getWrappedCommandButton().getOnmouseup();
	}

	@Override
	public UIComponent getParent() {
		return getWrappedCommandButton().getParent();
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
		return getWrappedCommandButton().getRendersChildren();
	}

	@Override
	public Map<String, String> getResourceBundleMap() {
		return getWrappedCommandButton().getResourceBundleMap();
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
		return getWrappedCommandButton().getStyle();
	}

	@Override
	public String getStyleClass() {

		String styleClass = getWrappedCommandButton().getStyleClass();

		if (styleClass == null) {
			styleClass = "btn-default";
		}

		String defaultCommandButtonClass = null;

		if (!styleClass.contains("btn-")) {
			defaultCommandButtonClass = "btn-default";
		}

		String disabledClass = null;
		boolean disabled = isDisabled();

		if (disabled) {
			disabledClass = "disabled";
		}

		styleClass = ComponentUtil.concatCssClasses("btn", defaultCommandButtonClass, disabledClass, styleClass);

		return styleClass;
	}

	@Override
	public String getTabindex() {
		return getWrappedCommandButton().getTabindex();
	}

	@Override
	public String getTarget() {
		return null;
	}

	@Override
	public String getTitle() {
		return getWrappedCommandButton().getTitle();
	}

	@Override
	public TransientStateHelper getTransientStateHelper(boolean create) {
		return getWrappedCommandButton().getTransientStateHelper(create);
	}

	@Override
	public String getType() {
		return getWrappedCommandButton().getType();
	}

	@Override
	public Object getValue() {
		return getWrappedCommandButton().getValue();
	}

	@SuppressWarnings("deprecation")
	@Override
	public javax.faces.el.ValueBinding getValueBinding(String name) {
		return getWrappedCommandButton().getValueBinding(name);
	}

	@Override
	public ValueExpression getValueExpression(String name) {
		return getWrappedCommandButton().getValueExpression(name);
	}

	@Override
	public CommandButton getWrappedCommandButton() {
		return wrappedCommandButton;
	}

	@Override
	public boolean initialStateMarked() {
		return getWrappedCommandButton().initialStateMarked();
	}

	@Override
	public boolean invokeOnComponent(FacesContext context, String clientId, ContextCallback callback)
		throws FacesException {
		return getWrappedCommandButton().invokeOnComponent(context, clientId, callback);
	}

	@Override
	public boolean isDisabled() {
		return getWrappedCommandButton().isDisabled();
	}

	@Override
	public boolean isImmediate() {
		return getWrappedCommandButton().isImmediate();
	}

	@Override
	public boolean isInView() {
		return getWrappedCommandButton().isInView();
	}

	@Override
	public boolean isRendered() {
		return getWrappedCommandButton().isRendered();
	}

	@Override
	public boolean isTransient() {
		return getWrappedCommandButton().isTransient();
	}

	@Override
	public void markInitialState() {
		getWrappedCommandButton().markInitialState();
	}

	@Override
	public void processDecodes(FacesContext context) {
		getWrappedCommandButton().processDecodes(context);
	}

	@Override
	public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
		getWrappedCommandButton().processEvent(event);
	}

	@Override
	public void processRestoreState(FacesContext context, Object state) {
		getWrappedCommandButton().processRestoreState(context, state);
	}

	@Override
	public Object processSaveState(FacesContext context) {
		return getWrappedCommandButton().processSaveState(context);
	}

	@Override
	public void processUpdates(FacesContext context) {
		getWrappedCommandButton().processUpdates(context);
	}

	@Override
	public void processValidators(FacesContext context) {
		getWrappedCommandButton().processValidators(context);
	}

	@Override
	public void queueEvent(FacesEvent event) {
		getWrappedCommandButton().queueEvent(event);
	}

	@Override
	public void removeActionListener(ActionListener listener) {
		getWrappedCommandButton().removeActionListener(listener);
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		getWrappedCommandButton().restoreState(context, state);
	}

	@Override
	public void restoreTransientState(FacesContext context, Object state) {
		getWrappedCommandButton().restoreTransientState(context, state);
	}

	@Override
	public Object saveState(FacesContext context) {
		return getWrappedCommandButton().saveState(context);
	}

	@Override
	public Object saveTransientState(FacesContext context) {
		return getWrappedCommandButton().saveTransientState(context);
	}

	@Override
	public void setAccesskey(String accesskey) {
		getWrappedCommandButton().setAccesskey(accesskey);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void setAction(javax.faces.el.MethodBinding action) {
		getWrappedCommandButton().setAction(action);
	}

	@Override
	public void setActionExpression(MethodExpression actionExpression) {
		getWrappedCommandButton().setActionExpression(actionExpression);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void setActionListener(javax.faces.el.MethodBinding actionListener) {
		getWrappedCommandButton().setActionListener(actionListener);
	}

	@Override
	public void setCharset(String charset) {
		// no-op
	}

	public void setClientKey(String clientKey) {
		// no-op
	}

	@Override
	public void setCoords(String coords) {
		// no-op
	}

	@Override
	public void setDir(String dir) {
		getWrappedCommandButton().setDir(dir);
	}

	@Override
	public void setDisabled(boolean disabled) {
		getWrappedCommandButton().setDisabled(disabled);
	}

	@Override
	public void setHreflang(String hreflang) {
		// no-op
	}

	@Override
	public void setId(String id) {
		getWrappedCommandButton().setId(id);
	}

	@Override
	public void setImmediate(boolean immediate) {
		getWrappedCommandButton().setImmediate(immediate);
	}

	@Override
	public void setInView(boolean isInView) {
		getWrappedCommandButton().setInView(isInView);
	}

	@Override
	public void setLang(String lang) {
		getWrappedCommandButton().setLang(lang);
	}

	@Override
	public void setOnblur(String onblur) {
		getWrappedCommandButton().setOnblur(onblur);
	}

	@Override
	public void setOnclick(String onclick) {
		getWrappedCommandButton().setOnclick(onclick);
	}

	@Override
	public void setOndblclick(String ondblclick) {
		getWrappedCommandButton().setOndblclick(ondblclick);
	}

	@Override
	public void setOnfocus(String onfocus) {
		getWrappedCommandButton().setOnfocus(onfocus);
	}

	@Override
	public void setOnkeydown(String onkeydown) {
		getWrappedCommandButton().setOnkeydown(onkeydown);
	}

	@Override
	public void setOnkeypress(String onkeypress) {
		getWrappedCommandButton().setOnkeypress(onkeypress);
	}

	@Override
	public void setOnkeyup(String onkeyup) {
		getWrappedCommandButton().setOnkeyup(onkeyup);
	}

	@Override
	public void setOnmousedown(String onmousedown) {
		getWrappedCommandButton().setOnmousedown(onmousedown);
	}

	@Override
	public void setOnmousemove(String onmousemove) {
		getWrappedCommandButton().setOnmousemove(onmousemove);
	}

	@Override
	public void setOnmouseout(String onmouseout) {
		getWrappedCommandButton().setOnmouseout(onmouseout);
	}

	@Override
	public void setOnmouseover(String onmouseover) {
		getWrappedCommandButton().setOnmouseover(onmouseover);
	}

	@Override
	public void setOnmouseup(String onmouseup) {
		getWrappedCommandButton().setOnmouseup(onmouseup);
	}

	@Override
	public void setParent(UIComponent parent) {
		getWrappedCommandButton().setParent(parent);
	}

	@Override
	public void setRel(String rel) {
		// no-op
	}

	@Override
	public void setRendered(boolean rendered) {
		getWrappedCommandButton().setRendered(rendered);
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
		getWrappedCommandButton().setStyle(style);
	}

	@Override
	public void setStyleClass(String styleClass) {
		getWrappedCommandButton().setStyleClass(styleClass);
	}

	@Override
	public void setTabindex(String tabindex) {
		getWrappedCommandButton().setTabindex(tabindex);
	}

	@Override
	public void setTarget(String target) {
		// no-op
	}

	@Override
	public void setTitle(String title) {
		getWrappedCommandButton().setTitle(title);
	}

	@Override
	public void setTransient(boolean newTransientValue) {
		getWrappedCommandButton().setTransient(newTransientValue);
	}

	@Override
	public void setType(String type) {
		getWrappedCommandButton().setType(type);
	}

	@Override
	public void setValue(Object value) {
		getWrappedCommandButton().setValue(value);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setValueBinding(String name, javax.faces.el.ValueBinding binding) {
		getWrappedCommandButton().setValueBinding(name, binding);
	}

	@Override
	public void setValueExpression(String name, ValueExpression binding) {
		getWrappedCommandButton().setValueExpression(name, binding);
	}

	public void setWrappedCommandButton(CommandButton wrappedCommandButton) {
		this.wrappedCommandButton = wrappedCommandButton;
	}

	@Override
	public void subscribeToEvent(Class<? extends SystemEvent> eventClass,
		ComponentSystemEventListener componentListener) {
		getWrappedCommandButton().subscribeToEvent(eventClass, componentListener);
	}

	@Override
	public void unsubscribeFromEvent(Class<? extends SystemEvent> eventClass,
		ComponentSystemEventListener componentListener) {
		getWrappedCommandButton().unsubscribeFromEvent(eventClass, componentListener);
	}

	@Override
	public boolean visitTree(VisitContext context, VisitCallback callback) {
		return getWrappedCommandButton().visitTree(context, callback);
	}
}
