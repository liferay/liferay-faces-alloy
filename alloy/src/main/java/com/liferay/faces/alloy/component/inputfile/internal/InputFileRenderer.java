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
package com.liferay.faces.alloy.component.inputfile.internal;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.application.ViewHandler;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;

import com.liferay.faces.alloy.component.inputfile.FileUploadEvent;
import com.liferay.faces.alloy.component.inputfile.InputFile;
import com.liferay.faces.util.context.map.MultiPartFormData;
import com.liferay.faces.util.factory.FactoryExtensionFinder;
import com.liferay.faces.util.i18n.I18n;
import com.liferay.faces.util.i18n.I18nFactory;
import com.liferay.faces.util.model.UploadedFile;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;
import com.liferay.faces.util.render.JavaScriptFragment;
import com.liferay.faces.util.render.RendererUtil;


/**
 * @author  Neil Griffin
 */

//J-
@FacesRenderer(componentFamily = InputFile.COMPONENT_FAMILY, rendererType = InputFile.RENDERER_TYPE)
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
public class InputFileRenderer extends InputFileRendererBase {

	@Override
	public void decode(FacesContext facesContext, UIComponent uiComponent) {

		InputFile inputFile = (InputFile) uiComponent;

		Map<String, List<UploadedFile>> uploadedFileMap = getUploadedFileMap(facesContext, inputFile.getLocation());

		if (uploadedFileMap != null) {

			String clientId = uiComponent.getClientId(facesContext);
			List<UploadedFile> uploadedFiles = uploadedFileMap.get(clientId);

			if ((uploadedFiles != null) && (uploadedFiles.size() > 0)) {

				inputFile.setSubmittedValue(uploadedFiles);

				// Queue the FileUploadEvent so that each uploaded file can be handled individually with an
				// ActionListener.
				for (UploadedFile uploadedFile : uploadedFiles) {

					FileUploadEvent fileUploadEvent = new FileUploadEvent(uiComponent, uploadedFile);
					uiComponent.queueEvent(fileUploadEvent);
				}
			}

			// FACES-3136: Ensure that the required attribute is enforced.
			else {
				inputFile.setSubmittedValue(Collections.emptyList());
			}
		}

		// FACES-3136: Ensure that the required attribute is enforced.
		else {
			inputFile.setSubmittedValue(Collections.emptyList());
		}
	}

	@Override
	public void encodeJavaScriptCustom(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		InputFile inputFile = (InputFile) uiComponent;
		JavaScriptFragment alloyNamespace = new JavaScriptFragment("A");

		// Determine the valid content-types and maximum file size from the validator (if specified).
		JavaScriptFragment contentTypes = new JavaScriptFragment("[]");
		String validContentTypes = inputFile.getContentTypes();

		if (validContentTypes != null) {
			contentTypes = toJavaScriptArray(validContentTypes.split(","));
		}

		String clientId = inputFile.getClientId(facesContext);
		Long maxFileSize = inputFile.getMaxFileSize();

		if (maxFileSize == null) {
			maxFileSize = Long.MAX_VALUE;
		}

		// If the component should render the upload progress table, then initialize the YUI progress uploader widget.
		if (inputFile.isShowProgress()) {

			String clientVarName = getClientVarName(facesContext, inputFile);
			String clientKey = inputFile.getClientKey();

			if (clientKey == null) {
				clientKey = clientVarName;
			}

			UIViewRoot viewRoot = facesContext.getViewRoot();
			Locale locale = viewRoot.getLocale();
			String formClientId = getParentFormClientId(inputFile);
			Application application = facesContext.getApplication();
			ViewHandler viewHandler = application.getViewHandler();
			String actionURL = viewHandler.getActionURL(facesContext, viewRoot.getViewId());
			String partialActionURL = facesContext.getExternalContext().encodePartialActionURL(actionURL);
			String namingContainerId = "";

			if (viewRoot instanceof NamingContainer) {
				namingContainerId = viewRoot.getContainerClientId(facesContext);
			}

			AjaxParameters ajaxParameters = new AjaxParameters(inputFile, clientId, formClientId);
			String execute = ajaxParameters.getExecute();
			String render = ajaxParameters.getRender();
			ExternalContext externalContext = facesContext.getExternalContext();

			I18n i18n = I18nFactory.getI18nInstance(externalContext);
			String notStartedMessage = i18n.getMessage(facesContext, locale, "not-started");
			JavaScriptFragment clientComponent = new JavaScriptFragment("Liferay.component('" + clientKey + "')");
			encodeFunctionCall(responseWriter, "LFAI.initProgressUploader", alloyNamespace, clientComponent,
				contentTypes, clientId, formClientId, namingContainerId, inputFile.isAuto(), execute, render,
				partialActionURL, maxFileSize, notStartedMessage);
		}

		// Otherwise, if the component should render the upload preview table, then format the preview-uploader.js
		// template and write it to the response.
		else if (inputFile.isShowPreview()) {

			encodeFunctionCall(responseWriter, "LFAI.initPreviewUploader", alloyNamespace, contentTypes, clientId,
				maxFileSize);
		}
	}

	@Override
	public void encodeMarkupBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {
		ResponseWriter responseWriter = facesContext.getResponseWriter();

		InputFile inputFile = (InputFile) uiComponent;

		// If the component should render the preview table or the upload progress table, then
		if (inputFile.isShowPreview() || inputFile.isShowProgress()) {

			// Start encoding the outermost <div> element.
			responseWriter.startElement("div", inputFile);

			String clientId = inputFile.getClientId(facesContext);
			responseWriter.writeAttribute("id", clientId, "id");
			RendererUtil.encodeStyleable(responseWriter, inputFile);

			// If the component should render the upload progress table, then format the progress-table.html template
			// and write it to the response.
			if (inputFile.isShowProgress()) {
				encodeProgress(facesContext, responseWriter, inputFile, clientId);
			}

			// Otherwise, delegate writing to the delegate renderer. Note that this effectively a no-op with Mojarra and
			// MyFaces, since they both delay writing of the entire <input type="file"...> ... </input> element until
			// encodeEnd.
			else {
				super.encodeMarkupBegin(facesContext, inputFile);
			}
		}

		// Otherwise, delegate writing to the delegate renderer. Note that this effectively a no-op with Mojarra and
		// MyFaces, since they both delay writing of the entire <input type="file"...> ... </input> element until
		// encodeEnd.
		else {
			super.encodeMarkupBegin(facesContext, inputFile);
		}
	}

	@Override
	public void encodeMarkupEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		// If the component should show the progress table, then
		InputFile inputFile = (InputFile) uiComponent;
		ResponseWriter responseWriter = facesContext.getResponseWriter();

		if (inputFile.isShowProgress()) {

			// Finish encoding of the outermost <div> element. Since the template contains its own "Select Files"
			// button, delegation must not occur.
			responseWriter.endElement("div");
		}

		// Otherwise, if the component should show the preview table, then
		else if (inputFile.isShowPreview()) {

			encodePreview(facesContext, responseWriter, inputFile);

			// Finish encoding of the outermost <div> element.
			responseWriter.endElement("div");
		}

		// Otherwise, delegate writing of the entire <input type="file"...> ... </input> element to the delegate
		// renderer.
		else {
			ResponseWriter delegationResponseWriter = new InputFileDelegationResponseWriter(responseWriter,
					inputFile.isAuto());
			super.encodeMarkupEnd(facesContext, uiComponent, delegationResponseWriter);
		}
	}

	@Override
	public Object getConvertedValue(FacesContext facesContext, UIComponent uiComponent, Object submittedValue)
		throws ConverterException {
		return submittedValue;
	}

	@Override
	protected void encodeHiddenAttributes(FacesContext facesContext, ResponseWriter responseWriter, InputFile inputFile,
		boolean first) throws IOException {

		// fileFieldName
		encodeString(responseWriter, "fileFieldName", inputFile.getClientId(), first);
		first = false;

		// multipleFiles
		String multiple = inputFile.getMultiple();
		boolean multipleFiles = "multiple".equalsIgnoreCase(multiple);
		encodeBoolean(responseWriter, "multipleFiles", multipleFiles, first);

		// selectFilesButton
		Locale locale = facesContext.getViewRoot().getLocale();
		ExternalContext externalContext = facesContext.getExternalContext();
		I18n i18n = I18nFactory.getI18nInstance(externalContext);
		String chooseFiles = i18n.getMessage(facesContext, locale, "choose-files");
		StringBuilder selectFilesButtonScript = new StringBuilder();
		selectFilesButtonScript.append(
			"A.Node.create(\"<button type='button' class='alloy-button' role='button' aria-label='");
		selectFilesButtonScript.append(chooseFiles);
		selectFilesButtonScript.append("' tabindex='{tabIndex}'>");
		selectFilesButtonScript.append(chooseFiles);
		selectFilesButtonScript.append("</button>\")");
		encodeNonEscapedObject(responseWriter, "selectFilesButton", selectFilesButtonScript, first);
	}

	protected void encodePreview(FacesContext facesContext, ResponseWriter responseWriter, InputFile inputFile)
		throws IOException {

		// Delegate writing of the entire <input type="file"...> ... </input> element to the delegate renderer.
		ResponseWriter delegationResponseWriter = new InputFileDelegationResponseWriter(responseWriter,
				inputFile.isAuto());
		super.encodeMarkupEnd(facesContext, inputFile, delegationResponseWriter);

		// Format the preview-table.html template and write it to the response.
		Locale locale = facesContext.getViewRoot().getLocale();
		String clientId = inputFile.getClientId(facesContext);
		responseWriter.startElement("div", inputFile);
		responseWriter.startElement("table", inputFile);
		responseWriter.writeAttribute("id", clientId + "_table", null);
		responseWriter.writeAttribute("class", "table table-bordered", null);
		responseWriter.startElement("thead", inputFile);
		responseWriter.writeAttribute("class", "table-columns", null);
		responseWriter.startElement("tr", inputFile);
		responseWriter.startElement("th", inputFile);

		ExternalContext externalContext = facesContext.getExternalContext();
		I18nFactory i18nFactory = (I18nFactory) FactoryExtensionFinder.getFactory(externalContext, I18nFactory.class);
		I18n i18n = i18nFactory.getI18n();
		String i18nFileName = i18n.getMessage(facesContext, locale, "file-name");
		responseWriter.writeText(i18nFileName, null);
		responseWriter.endElement("th");
		responseWriter.startElement("th", inputFile);

		String i18nFileType = i18n.getMessage(facesContext, locale, "file-type");
		responseWriter.writeText(i18nFileType, null);
		responseWriter.endElement("th");
		responseWriter.startElement("th", inputFile);

		String i18nFileSize = i18n.getMessage(facesContext, locale, "file-size");
		responseWriter.writeText(i18nFileSize, null);
		responseWriter.endElement("th");
		responseWriter.endElement("tr");
		responseWriter.endElement("thead");
		responseWriter.startElement("tfoot", inputFile);
		responseWriter.startElement("tr", inputFile);
		responseWriter.startElement("td", inputFile);
		responseWriter.writeAttribute("colspan", "3", null);

		String i18nNoFilesSelected = i18n.getMessage(facesContext, locale, "no-files-selected");
		responseWriter.writeText(i18nNoFilesSelected, null);
		responseWriter.endElement("td");
		responseWriter.endElement("tr");
		responseWriter.endElement("tfoot");
		responseWriter.startElement("tbody", inputFile);
		responseWriter.startElement("tr", inputFile);
		responseWriter.endElement("tr");
		responseWriter.endElement("tbody");
		responseWriter.endElement("table");
		responseWriter.endElement("div");
	}

	protected void encodeProgress(FacesContext facesContext, ResponseWriter responseWriter, InputFile inputFile,
		String clientId) throws IOException {

		Locale locale = facesContext.getViewRoot().getLocale();
		responseWriter.startElement("div", inputFile);
		responseWriter.writeAttribute("id", clientId + "_selectFilesBox", null);
		responseWriter.writeAttribute("class", "select-files-box", null);
		responseWriter.endElement("div");

		ExternalContext externalContext = facesContext.getExternalContext();
		I18nFactory i18nFactory = (I18nFactory) FactoryExtensionFinder.getFactory(externalContext, I18nFactory.class);
		I18n i18n = i18nFactory.getI18n();

		if (!inputFile.isAuto()) {

			responseWriter.startElement("div", inputFile);
			responseWriter.writeAttribute("id", clientId + "_uploadFilesBox", null);
			responseWriter.writeAttribute("class", "upload-files-box", null);
			responseWriter.startElement("button", inputFile);
			responseWriter.writeAttribute("id", clientId + "_uploadFilesButton", null);
			responseWriter.writeAttribute("class", "alloy-button", null);

			String i18nUploadFiles = i18n.getMessage(facesContext, locale, "upload-files");
			responseWriter.writeText(i18nUploadFiles, null);
			responseWriter.endElement("button");
			responseWriter.endElement("div");
		}

		responseWriter.startElement("div", inputFile);
		responseWriter.startElement("table", inputFile);
		responseWriter.writeAttribute("id", clientId + "_table", null);
		responseWriter.writeAttribute("class", "table table-bordered", null);
		responseWriter.startElement("thead", inputFile);
		responseWriter.writeAttribute("class", "table-columns", null);
		responseWriter.startElement("tr", inputFile);
		responseWriter.startElement("th", inputFile);

		String i18nFileName = i18n.getMessage(facesContext, locale, "file-name");
		responseWriter.writeText(i18nFileName, null);
		responseWriter.endElement("th");
		responseWriter.startElement("th", inputFile);

		String i18nFileType = i18n.getMessage(facesContext, locale, "file-type");
		responseWriter.writeText(i18nFileType, null);
		responseWriter.endElement("th");
		responseWriter.startElement("th", inputFile);

		String i18nFileSize = i18n.getMessage(facesContext, locale, "file-size");
		responseWriter.writeText(i18nFileSize, null);
		responseWriter.endElement("th");
		responseWriter.startElement("th", inputFile);

		String i18nProgress = i18n.getMessage(facesContext, locale, "progress");
		responseWriter.writeText(i18nProgress, null);
		responseWriter.endElement("th");
		responseWriter.endElement("tr");
		responseWriter.endElement("thead");
		responseWriter.startElement("tfoot", inputFile);
		responseWriter.startElement("tr", inputFile);
		responseWriter.startElement("td", inputFile);
		responseWriter.writeAttribute("colspan", "4", null);

		String i18nNoFilesSelected = i18n.getMessage(facesContext, locale, "no-files-selected");
		responseWriter.writeText(i18nNoFilesSelected, null);
		responseWriter.endElement("td");
		responseWriter.endElement("tr");
		responseWriter.endElement("tfoot");
		responseWriter.startElement("tbody", inputFile);
		responseWriter.startElement("tr", inputFile);
		responseWriter.endElement("tr");
		responseWriter.endElement("tbody");
		responseWriter.endElement("table");
		responseWriter.endElement("div");
	}

	protected String getParentFormClientId(UIComponent uiComponent) {

		String parentFormClientId = null;

		if (uiComponent != null) {

			if (uiComponent instanceof UIForm) {
				parentFormClientId = uiComponent.getClientId();
			}
			else {
				parentFormClientId = getParentFormClientId(uiComponent.getParent());
			}
		}

		return parentFormClientId;
	}

	protected Map<String, List<UploadedFile>> getUploadedFileMap(FacesContext facesContext, String location) {

		Map<String, List<UploadedFile>> uploadedFileMap = null;
		ExternalContext externalContext = facesContext.getExternalContext();
		final Product LIFERAY_FACES_BRIDGE = ProductFactory.getProductInstance(externalContext,
				Product.Name.LIFERAY_FACES_BRIDGE);

		if (LIFERAY_FACES_BRIDGE.isDetected()) {
			Map<String, Object> requestAttributeMap = facesContext.getExternalContext().getRequestMap();
			MultiPartFormData multiPartFormData = (MultiPartFormData) requestAttributeMap.get(MultiPartFormData.class
					.getName());

			if (multiPartFormData != null) {
				uploadedFileMap = multiPartFormData.getUploadedFileMap();
			}
		}
		else {
			InputFileDecoder inputFileDecoder = getWebappInputFileDecoder(facesContext);
			uploadedFileMap = inputFileDecoder.decode(facesContext, location);
		}

		return uploadedFileMap;
	}

	protected JavaScriptFragment toJavaScriptArray(String[] items) {

		StringBuilder buf = new StringBuilder("[");

		if (items != null) {

			for (int i = 0; i < items.length; i++) {

				if (i > 0) {
					buf.append(",");
				}

				buf.append("'");
				buf.append(items[i].trim());
				buf.append("'");
			}
		}

		buf.append("]");

		return new JavaScriptFragment(buf.toString());
	}
}
