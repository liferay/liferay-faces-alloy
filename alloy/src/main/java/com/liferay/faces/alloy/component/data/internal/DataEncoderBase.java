/**
 * Copyright (c) 2000-2020 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.data.internal;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Kyle Stiemann
 */
public abstract class DataEncoderBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(DataEncoderBase.class);

	public static boolean isIterateOverDataModel(UIData uiData) {

		Object value = uiData.getValue();
		String var = uiData.getVar();

		return ((value != null) && (var != null));
	}

	private static String getComponentName(UIComponent uiComponent) {
		return getComponentName(uiComponent.getClass());
	}

	private static String getComponentName(Class clazz) {

		String simpleName = clazz.getSimpleName();

		if (simpleName.length() > 1) {
			simpleName = simpleName.substring(0, 1).toLowerCase(Locale.ENGLISH) + simpleName.substring(1);
		}
		else {
			simpleName = simpleName.toLowerCase(Locale.ENGLISH);
		}

		return simpleName;
	}

	public void encodeColumns(FacesContext facesContext, UIData uiData) throws IOException {
		encodeColumns(facesContext, uiData, isIterateOverDataModel(uiData));
	}

	public void encodeColumns(FacesContext facesContext, UIData uiData, boolean iterateOverDataModel)
		throws IOException {

		if (iterateOverDataModel) {

			int rowCount = uiData.getRowCount();
			UIColumn prototypeChild = getPrototypeColumnChild(uiData);

			if (prototypeChild != null) {

				for (int i = 0; i < rowCount; i++) {

					uiData.setRowIndex(i);
					encodeColumn(facesContext, uiData, prototypeChild, i);
				}
			}
			else {

				String dataComponentName = getComponentName(uiData);
				Class<? extends UIColumn> columnClass = getColumnClass();
				String columnComponentName = getComponentName(columnClass);

				logger.warn("Unable to iterate because alloy:{0} does not have an alloy:{1} child element.",
					dataComponentName, columnComponentName);
			}
		}
		else {

			List<UIComponent> children = uiData.getChildren();

			for (int i = 0; i < children.size(); i++) {

				UIComponent child = children.get(i);
				Class<? extends UIColumn> columnClass = getColumnClass();

				if (columnClass.isInstance(child)) {
					encodeColumn(facesContext, uiData, columnClass.cast(child), i);
				}
				else {

					String dataComponentName = getComponentName(uiData);
					String columnComponentName = getComponentName(columnClass);

					logger.warn("Unable to render child element of alloy:{0} since it is not alloy:{1}",
						dataComponentName, columnComponentName);
				}
			}
		}

		uiData.setRowIndex(-1);
	}

	protected abstract Class<? extends UIColumn> getColumnClass();

	protected void encodeColumn(FacesContext facesContext, UIData uiData, UIColumn currentUIColumn, int currentIndex)
		throws IOException {

		if (currentUIColumn.isRendered()) {
			currentUIColumn.encodeAll(facesContext);
		}
	}

	private UIColumn getPrototypeColumnChild(UIData uiData) {

		UIColumn prototypeChild = null;
		int childCount = uiData.getChildCount();

		if (childCount > 0) {

			List<UIComponent> children = uiData.getChildren();

			for (int i = 0; i < childCount; i++) {

				UIComponent child = children.get(i);
				Class<? extends UIColumn> columnClass = getColumnClass();

				if (columnClass.isInstance(child)) {
					prototypeChild = columnClass.cast(child);
				}
			}
		}

		return prototypeChild;
	}
}
