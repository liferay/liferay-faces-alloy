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
package com.liferay.faces.alloy.component.selectbooleancheckbox.internal;

import java.io.IOException;

import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;
import javax.faces.view.facelets.FacetHandler;

import com.liferay.faces.alloy.component.field.Field;
import com.liferay.faces.alloy.component.selectbooleancheckbox.SelectBooleanCheckbox;
import com.liferay.faces.util.render.IdResponseWriter;


/**
 * This is the renderer for the {@link SelectBooleanCheckbox} component. All of the methods in this renderer delegate to
 * the renderer provided by the JSF runtime for for {@link HtmlSelectBooleanCheckbox}, along with one added feature.
 * Specifically, this renderer overcomes the limitation outlined <a
 * href="http://balusc.blogspot.com/2008/09/validate-required-checkbox.html">this blog post</a> in which the "required"
 * attribute of {@link HtmlSelectBooleanCheckbox} is effectively disabled.
 *
 * @author  Vernon Singleton
 */
@FacesRenderer(
	componentFamily = SelectBooleanCheckbox.COMPONENT_FAMILY, rendererType = SelectBooleanCheckbox.RENDERER_TYPE
)
@ResourceDependency(library = "liferay-faces-alloy", name = "alloy.css")
public class SelectBooleanCheckboxRenderer extends SelectBooleanCheckboxRendererBase {

	@Override
	public void decode(FacesContext facesContext, UIComponent uiComponent) {

		super.decode(facesContext, uiComponent);

		SelectBooleanCheckbox selectBooleanCheckbox = (SelectBooleanCheckbox) uiComponent;

		Object submittedValue = selectBooleanCheckbox.getSubmittedValue();

		if (selectBooleanCheckbox.isRequired() && submittedValue.getClass().equals(Boolean.class) &&
				Boolean.FALSE.equals(submittedValue)) {
			selectBooleanCheckbox.setSubmittedValue("");
		}
	}

	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		if (isInsideFieldLabelFacet(uiComponent)) {

			// Force the JSF runtime to output the "id" attribute so that the FieldRenderer can encode a label
			// element with a "for" attribute that associates the label with this checkbox.
			ResponseWriter responseWriter = facesContext.getResponseWriter();
			IdResponseWriter idDelegationResponseWriter = new IdResponseWriter(responseWriter, "input",
					uiComponent.getClientId(facesContext));
			super.encodeEnd(facesContext, uiComponent, idDelegationResponseWriter);
		}
		else {
			super.encodeEnd(facesContext, uiComponent);
		}
	}

	@Override
	public Object getConvertedValue(FacesContext facesContext, UIComponent uiComponent, Object submittedValue)
		throws ConverterException {

		Object convertedValue = super.getConvertedValue(facesContext, uiComponent, submittedValue);

		SelectBooleanCheckbox selectBooleanCheckbox = (SelectBooleanCheckbox) uiComponent;

		if (selectBooleanCheckbox.isRequired() && "".equals(submittedValue)) {
			convertedValue = submittedValue;
		}

		return convertedValue;
	}

	/*
	 * See
	 * http://stackoverflow.com/questions/34274934/how-can-i-determine-whether-a-component-is-inside-a-certain-facet/34274935
	 * for more details.
	 */
	private boolean isInsideFieldLabelFacet(UIComponent uiComponent) {

		boolean insideFieldLabelFacet = false;
		UIComponent parent = uiComponent.getParent();

		if (parent != null) {

			// In Section 9.2.3 of the JSF spec, it states that when a facet is created, the first component in it
			// should be named as the facet. If no other components are added to the Field's label facet, then the
			// checkbox will be the label facet, so...
			if (parent instanceof Field) {

				UIComponent labelFacet = parent.getFacet("label");

				// Check if the checkbox is the Field's label facet.
				if ((labelFacet != null) && labelFacet.equals(uiComponent)) {
					insideFieldLabelFacet = true;
				}
			}

			// Otherwise, according to
			// https://github.com/javaserverfaces/mojarra/blob/2.1.4/jsf-ri/src/main/java/com/sun/faces/facelets/tag/jsf/ComponentSupport.java#L512,
			// the facet will be a component, so...
			else {

				UIComponent grandparent = parent.getParent();

				if ((grandparent != null) && (grandparent instanceof Field)) {

					UIComponent labelFacet = grandparent.getFacet("label");

					// Check if the checkbox's parent is the label facet.
					if ((labelFacet != null) && labelFacet.equals(parent)) {
						insideFieldLabelFacet = true;
					}
				}
			}
		}

		return insideFieldLabelFacet;
	}
}
