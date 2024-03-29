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
package com.liferay.faces.alloy.component.inputfile.internal;
//J-

import java.io.IOException;

import javax.annotation.Generated;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.liferay.faces.alloy.component.inputfile.internal.InputFileRendererCompat;

import com.liferay.faces.alloy.component.inputfile.InputFile;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputFileRendererBase extends InputFileRendererCompat {

	// Protected Constants
	protected static final String APPEND_NEW_FILES = "appendNewFiles";
	protected static final String AUTO = "auto";
	protected static final String CLIENT_KEY = "clientKey";
	protected static final String CONTENT_TYPES = "contentTypes";
	protected static final String FILE_UPLOAD_LISTENER = "fileUploadListener";
	protected static final String LOCATION = "location";
	protected static final String MAX_FILE_SIZE = "maxFileSize";
	protected static final String MULTIPLE = "multiple";
	protected static final String SHOW_PREVIEW = "showPreview";
	protected static final String SHOW_PROGRESS = "showProgress";

	// Modules
	protected static final String[] MODULES = { "uploader", "aui-datatable", "datatype-xml" };

	@Override
	public void encodeAlloyAttributes(FacesContext facesContext, ResponseWriter responseWriter, UIComponent uiComponent) throws IOException {

		InputFile inputFile = (InputFile) uiComponent;
		boolean first = true;

		Boolean appendNewFiles = inputFile.isAppendNewFiles();

		if (appendNewFiles != null) {

			encodeAppendNewFiles(responseWriter, inputFile, appendNewFiles, first);
			first = false;
		}

		encodeHiddenAttributes(facesContext, responseWriter, inputFile, first);
	}

	@Override
	public String getAlloyClassName(FacesContext facesContext, UIComponent uiComponent) {
		return "Uploader";
	}

	@Override
	public String[] getModules(FacesContext facesContext, UIComponent uiComponent) {
		return MODULES;
	}

	protected void encodeAppendNewFiles(ResponseWriter responseWriter, InputFile inputFile, Boolean appendNewFiles, boolean first) throws IOException {
		encodeBoolean(responseWriter, APPEND_NEW_FILES, appendNewFiles, first);
	}

	protected void encodeHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter, InputFile inputFile, boolean first) throws IOException {
		// no-op
	}
}
//J+
