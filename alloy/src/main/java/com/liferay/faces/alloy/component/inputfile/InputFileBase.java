/**
 * Copyright (c) 2000-2021 Liferay, Inc. All rights reserved.
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
//J-

import javax.annotation.Generated;

import com.liferay.faces.util.component.ClientComponent;
import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class InputFileBase extends com.liferay.faces.util.component.InputFileBase implements Styleable, ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.inputfile.InputFile";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.inputfile.InputFileRenderer";

	// Protected Enumerations
	protected enum InputFilePropertyKeys {
		appendNewFiles,
		auto,
		clientKey,
		contentTypes,
		fileUploadListener,
		location,
		maxFileSize,
		multiple,
		showPreview,
		showProgress
	}

	public InputFileBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>appendNewFiles</code> attribute description:</p>
	 *
	 * <div>When this flag is true, selected files are appended to the preview table. Otherwise, the preview table is cleared when new files are selected. NOTE: This feature is only available when showProgress=true.</div>
	 */
	public boolean isAppendNewFiles() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.appendNewFiles, false);
	}

	/**
	 * <p><code>appendNewFiles</code> attribute description:</p>
	 *
	 * <div>When this flag is true, selected files are appended to the preview table. Otherwise, the preview table is cleared when new files are selected. NOTE: This feature is only available when showProgress=true.</div>
	 */
	public void setAppendNewFiles(boolean appendNewFiles) {
		getStateHelper().put(InputFilePropertyKeys.appendNewFiles, appendNewFiles);
	}

	/**
	 * <p><code>auto</code> attribute description:</p>
	 *
	 * <div>When this flag is true, files are uploaded automatically as soon as they are selected.</div>
	 */
	public boolean isAuto() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.auto, false);
	}

	/**
	 * <p><code>auto</code> attribute description:</p>
	 *
	 * <div>When this flag is true, files are uploaded automatically as soon as they are selected.</div>
	 */
	public void setAuto(boolean auto) {
		getStateHelper().put(InputFilePropertyKeys.auto, auto);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(InputFilePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <p><code>contentTypes</code> attribute description:</p>
	 *
	 * <div>Comma-delimited list of uploaded file MIME types that are valid. If not specified, then all MIME types are assumed to be valid.</div>
	 */
	public String getContentTypes() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.contentTypes, null);
	}

	/**
	 * <p><code>contentTypes</code> attribute description:</p>
	 *
	 * <div>Comma-delimited list of uploaded file MIME types that are valid. If not specified, then all MIME types are assumed to be valid.</div>
	 */
	public void setContentTypes(String contentTypes) {
		getStateHelper().put(InputFilePropertyKeys.contentTypes, contentTypes);
	}

	/**
	 * <p><code>fileUploadListener</code> attribute description:</p>
	 *
	 * <div>A method that is executed when a file is uploaded. The method must be <code>public</code>, return <code>void</code>, and take a <code>FileUploadEvent</code> argument.</div>
	 */
	public javax.el.MethodExpression getFileUploadListener() {
		return (javax.el.MethodExpression) getStateHelper().eval(InputFilePropertyKeys.fileUploadListener, null);
	}

	/**
	 * <p><code>fileUploadListener</code> attribute description:</p>
	 *
	 * <div>A method that is executed when a file is uploaded. The method must be <code>public</code>, return <code>void</code>, and take a <code>FileUploadEvent</code> argument.</div>
	 */
	public void setFileUploadListener(javax.el.MethodExpression fileUploadListener) {
		getStateHelper().put(InputFilePropertyKeys.fileUploadListener, fileUploadListener);
	}

	/**
	 * <p><code>label</code> attribute description:</p>
	 *
	 * <div>A localized label for this component that is typically only rendered in a FacesMessage when validation fails.</div>
	 */
	@Override
	public String getLabel() {

		String label = super.getLabel();

		if (label == null) {

			javax.faces.context.FacesContext facesContext = javax.faces.context.FacesContext.getCurrentInstance();

			if (facesContext.getCurrentPhaseId() == javax.faces.event.PhaseId.PROCESS_VALIDATIONS) {
				label = com.liferay.faces.util.component.ComponentUtil.getComponentLabel(this);
			}
		}

		return label;
	}

	/**
	 * <p><code>location</code> attribute description:</p>
	 *
	 * <div>The absolute path that uploaded file should be copied to. If not specified, then the value of the &lt;location&gt; element specified in the Servlet 3.0 web.xml &lt;multipart-config&gt; of the FacesServlet &lt;servlet&gt; will be utilized. Otherwise, the value of the "com.liferay.faces.util.uploadedFilesDir" context-param is utilizied.</div>
	 */
	public String getLocation() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.location, null);
	}

	/**
	 * <p><code>location</code> attribute description:</p>
	 *
	 * <div>The absolute path that uploaded file should be copied to. If not specified, then the value of the &lt;location&gt; element specified in the Servlet 3.0 web.xml &lt;multipart-config&gt; of the FacesServlet &lt;servlet&gt; will be utilized. Otherwise, the value of the "com.liferay.faces.util.uploadedFilesDir" context-param is utilizied.</div>
	 */
	public void setLocation(String location) {
		getStateHelper().put(InputFilePropertyKeys.location, location);
	}

	/**
	 * <p><code>maxFileSize</code> attribute description:</p>
	 *
	 * <div>Maximum length (in bytes) permitted for each individual uploaded file. If not specified, then files of any length are assumed to be valid.</div>
	 */
	public Long getMaxFileSize() {
		return (Long) getStateHelper().eval(InputFilePropertyKeys.maxFileSize, null);
	}

	/**
	 * <p><code>maxFileSize</code> attribute description:</p>
	 *
	 * <div>Maximum length (in bytes) permitted for each individual uploaded file. If not specified, then files of any length are assumed to be valid.</div>
	 */
	public void setMaxFileSize(Long maxFileSize) {
		getStateHelper().put(InputFilePropertyKeys.maxFileSize, maxFileSize);
	}

	/**
	 * <p><code>multiple</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying whether or not multiple files can be uploaded. Valid values are blank (to upload a single file) or "multiple" (to upload multiple files).</div>
	 */
	public String getMultiple() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.multiple, null);
	}

	/**
	 * <p><code>multiple</code> attribute description:</p>
	 *
	 * <div>HTML passthrough attribute specifying whether or not multiple files can be uploaded. Valid values are blank (to upload a single file) or "multiple" (to upload multiple files).</div>
	 */
	public void setMultiple(String multiple) {
		getStateHelper().put(InputFilePropertyKeys.multiple, multiple);
	}

	/**
	 * <p><code>showPreview</code> attribute description:</p>
	 *
	 * <div>When this flag is true, a table showing a preview will be rendered when the user selects one or more files.</div>
	 */
	public boolean isShowPreview() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.showPreview, false);
	}

	/**
	 * <p><code>showPreview</code> attribute description:</p>
	 *
	 * <div>When this flag is true, a table showing a preview will be rendered when the user selects one or more files.</div>
	 */
	public void setShowPreview(boolean showPreview) {
		getStateHelper().put(InputFilePropertyKeys.showPreview, showPreview);
	}

	/**
	 * <p><code>showProgress</code> attribute description:</p>
	 *
	 * <div>When this flag is true, a table showing file upload progress will be rendered when the user selects one of more files.</div>
	 */
	public boolean isShowProgress() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.showProgress, false);
	}

	/**
	 * <p><code>showProgress</code> attribute description:</p>
	 *
	 * <div>When this flag is true, a table showing file upload progress will be rendered when the user selects one of more files.</div>
	 */
	public void setShowProgress(boolean showProgress) {
		getStateHelper().put(InputFilePropertyKeys.showProgress, showProgress);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(PropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(PropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-input-file");
	}
}
//J+
