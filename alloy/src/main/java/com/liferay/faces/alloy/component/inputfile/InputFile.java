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
package com.liferay.faces.alloy.component.inputfile;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.FacesEvent;

import com.liferay.faces.util.i18n.I18n;
import com.liferay.faces.util.i18n.I18nFactory;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.model.UploadedFile;


/**
 * @author  Neil Griffin
 */
@FacesComponent(value = InputFile.COMPONENT_TYPE)
public class InputFile extends InputFileBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(InputFile.class);

	@Override
	public void broadcast(FacesEvent facesEvent) throws AbortProcessingException {
		super.broadcast(facesEvent);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		try {
			MethodExpression methodExpression = getFileUploadListener();

			if ((methodExpression != null) && (facesEvent instanceof FileUploadEvent)) {
				methodExpression.invoke(facesContext.getELContext(), new Object[] { facesEvent });
			}
		}
		catch (Exception e) {
			throw new AbortProcessingException(e);
		}
	}

	@Override
	protected void validateValue(FacesContext facesContext, Object value) {

		super.validateValue(facesContext, value);

		if (isValid()) {

			Long maxFileSize = getMaxFileSize();
			String contentTypeSet = getContentTypes();

			if ((maxFileSize != null) || (contentTypeSet != null)) {

				Locale locale = facesContext.getViewRoot().getLocale();
				ExternalContext externalContext = facesContext.getExternalContext();
				I18n i18n = I18nFactory.getI18nInstance(externalContext);
				String clientId = getClientId(facesContext);
				@SuppressWarnings("unchecked")
				List<UploadedFile> uploadedFiles = (List<UploadedFile>) value;

				for (UploadedFile uploadedFile : uploadedFiles) {

					if ((maxFileSize != null) && (maxFileSize >= 0) && (uploadedFile.getSize() > maxFileSize)) {

						String errorMessage = i18n.getMessage(facesContext, locale,
								"file-x-is-y-bytes-but-may-not-exceed-z-bytes", uploadedFile.getName(),
								uploadedFile.getSize(), maxFileSize);
						handleInvalidFile(facesContext, clientId, uploadedFile, errorMessage);
					}

					String contentType = uploadedFile.getContentType();

					if ((contentType == null) || ((contentTypeSet != null) && !contentTypeSet.contains(contentType))) {

						String errorMessage = i18n.getMessage(facesContext, locale,
								"file-x-has-an-invalid-content-type-y", uploadedFile.getName(), contentType);
						handleInvalidFile(facesContext, clientId, uploadedFile, errorMessage);
					}
				}
			}
		}
	}

	private void handleInvalidFile(FacesContext facesContext, String clientId, UploadedFile uploadedFile,
		String errorMessage) {

		facesContext.addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, errorMessage));

		setValid(false);

		try {
			uploadedFile.delete();
		}
		catch (IOException e) {
			logger.error(e);
		}
	}
}
