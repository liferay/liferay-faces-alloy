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
package com.liferay.faces.alloy.component.datalist.internal;

import java.io.IOException;

import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.data.internal.DataEncoderBase;
import com.liferay.faces.alloy.component.dataitem.DataItem;
import com.liferay.faces.alloy.component.datalist.DataList;
import com.liferay.faces.util.component.Styleable;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Vernon Singleton
 */

//J-
@FacesRenderer(componentFamily = DataList.COMPONENT_FAMILY, rendererType = DataList.RENDERER_TYPE)
//J+
public class DataListRenderer extends DataListRendererBase {

	// Private constants
	private static final String DESCRIPTION = "description";
	private static final String ORDERED = "ordered";
	private static final String UNORDERED = "unordered";

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(DataListRenderer.class);

	@Override
	public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		DataList dataList = (DataList) uiComponent;
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		String clientId = uiComponent.getClientId(facesContext);

		// Encode the starting <ul>, <ol>, or <dl> element that represents the component.
		String type = dataList.getType();

		if (UNORDERED.equals(type)) {
			responseWriter.startElement("ul", uiComponent);
		}
		else if (ORDERED.equals(type)) {
			responseWriter.startElement("ol", uiComponent);
		}
		else if (DESCRIPTION.equals(type)) {
			responseWriter.startElement("dl", uiComponent);
		}

		responseWriter.writeAttribute("id", clientId, "id");
		RendererUtil.encodeStyleable(responseWriter, (Styleable) uiComponent);
	}

	@Override
	public void encodeChildren(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		DataList dataList = (DataList) uiComponent;
		UIComponent facet = dataList.getFacet(DESCRIPTION);

		String itemTag = "li";
		String type = dataList.getType();

		if (DESCRIPTION.equals(type)) {
			itemTag = "dt";
		}

		DataEncoderBase dataEncoder = new DataEncoderDataItemImpl(facet, itemTag);
		dataEncoder.encodeColumns(facesContext, dataList);
	}

	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {
		DataList dataList = (DataList) uiComponent;
		ResponseWriter responseWriter = facesContext.getResponseWriter();

		// Encode the closing <ul>, <ol>, or <dl> element that represents the component.
		String type = dataList.getType();

		if (UNORDERED.equals(type)) {
			responseWriter.endElement("ul");
		}
		else if (ORDERED.equals(type)) {
			responseWriter.endElement("ol");
		}
		else if (DESCRIPTION.equals(type)) {
			responseWriter.endElement("dl");
		}
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}

	private static class DataEncoderDataItemImpl extends DataEncoderBase {

		// Private Final Data Members
		private final UIComponent facet;
		private final String itemTag;

		public DataEncoderDataItemImpl(UIComponent facet, String itemTag) {

			this.facet = facet;
			this.itemTag = itemTag;
		}

		@Override
		protected void encodeColumn(FacesContext facesContext, UIData uiData, UIColumn currentUIColumn,
			int currentIndex) throws IOException {

			if (currentUIColumn.isRendered() && (currentUIColumn instanceof DataItem)) {

				// Encode the starting element that represents the specified child's content.
				ResponseWriter responseWriter = facesContext.getResponseWriter();
				DataItem childDataItem = (DataItem) currentUIColumn;
				responseWriter.startElement(itemTag, childDataItem);
				RendererUtil.encodeStyleable(responseWriter, childDataItem);

				// Encode the children of the specified child as the actual content.
				childDataItem.encodeAll(facesContext);

				// Encode the closing element for the specified child.
				responseWriter.endElement(itemTag);

				if (facet != null) {

					if (isIterateOverDataModel(uiData)) {

						DataList dataList = (DataList) uiData;
						String type = dataList.getType();

						if (DESCRIPTION.equals(type)) {

							responseWriter.startElement("dd", uiData);

							String styleClass = dataList.getStyleClass();
							responseWriter.writeAttribute("class", styleClass + "-" + DESCRIPTION, "class");
							facet.encodeAll(facesContext);
							responseWriter.endElement("dd");
						}
						else {
							logger.warn(
								"Ignoring description facet since alloy:dataList type [{0}] is not \"description\".",
								type);
						}
					}
					else {
						logger.warn(
							"Ignoring description facet since the value and var attributes are not specified on alloy:dataList.");
					}
				}
			}
		}

		@Override
		protected Class<? extends UIColumn> getColumnClass() {
			return DataItem.class;
		}
	}
}
