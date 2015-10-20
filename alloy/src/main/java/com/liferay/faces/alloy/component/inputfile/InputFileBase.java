/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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
	 * <code>appendNewFiles</code> attribute description:
	 * <br /><br />
	 * When this flag is true, selected files are appended to the preview table. Otherwise, the preview table is cleared when new files are selected. NOTE: This feature is only available when showProgress=true.
	 */
	public boolean isAppendNewFiles() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.appendNewFiles, false);
	}

	/**
	 * <code>appendNewFiles</code> attribute description:
	 * <br /><br />
	 * When this flag is true, selected files are appended to the preview table. Otherwise, the preview table is cleared when new files are selected. NOTE: This feature is only available when showProgress=true.
	 */
	public void setAppendNewFiles(boolean appendNewFiles) {
		getStateHelper().put(InputFilePropertyKeys.appendNewFiles, appendNewFiles);
	}

	/**
	 * <code>auto</code> attribute description:
	 * <br /><br />
	 * When this flag is true, files are uploaded automatically as soon as they are selected.
	 */
	public boolean isAuto() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.auto, false);
	}

	/**
	 * <code>auto</code> attribute description:
	 * <br /><br />
	 * When this flag is true, files are uploaded automatically as soon as they are selected.
	 */
	public void setAuto(boolean auto) {
		getStateHelper().put(InputFilePropertyKeys.auto, auto);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.clientKey, null);
	}

	/**
	 * <code>clientKey</code> attribute description:
	 * <br /><br />
	 * The key name that can be used to reference the component on the client.
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(InputFilePropertyKeys.clientKey, clientKey);
	}

	/**
	 * <code>contentTypes</code> attribute description:
	 * <br /><br />
	 * Comma-delimited list of uploaded file MIME types that are valid. If not specified, then all MIME types are assumed to be valid.
	 */
	public String getContentTypes() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.contentTypes, null);
	}

	/**
	 * <code>contentTypes</code> attribute description:
	 * <br /><br />
	 * Comma-delimited list of uploaded file MIME types that are valid. If not specified, then all MIME types are assumed to be valid.
	 */
	public void setContentTypes(String contentTypes) {
		getStateHelper().put(InputFilePropertyKeys.contentTypes, contentTypes);
	}

	/**
	 * <code>fileUploadListener</code> attribute description:
	 * <br /><br />
	 * A method that is executed when a file is uploaded. The method must be <code>public</code>, return <code>void</code>, and take a <code>FileUploadEvent</code> argument.
	 */
	public javax.el.MethodExpression getFileUploadListener() {
		return (javax.el.MethodExpression) getStateHelper().eval(InputFilePropertyKeys.fileUploadListener, null);
	}

	/**
	 * <code>fileUploadListener</code> attribute description:
	 * <br /><br />
	 * A method that is executed when a file is uploaded. The method must be <code>public</code>, return <code>void</code>, and take a <code>FileUploadEvent</code> argument.
	 */
	public void setFileUploadListener(javax.el.MethodExpression fileUploadListener) {
		getStateHelper().put(InputFilePropertyKeys.fileUploadListener, fileUploadListener);
	}

	/**
	 * <code>label</code> attribute description:
	 * <br /><br />
	 * A localized label for this component that is typically only rendered in a FacesMessage when validation fails.
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
	 * <code>location</code> attribute description:
	 * <br /><br />
	 * The absolute path that uploaded file should be copied to. If not specified, then the value of the &lt;location&gt; element specified in the Servlet 3.0 web.xml &lt;multipart-config&gt; of the FacesServlet &lt;servlet&gt; will be utilized. Otherwise, the value of the "com.liferay.faces.util.uploadedFilesDir" context-param is utilizied.
	 */
	public String getLocation() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.location, null);
	}

	/**
	 * <code>location</code> attribute description:
	 * <br /><br />
	 * The absolute path that uploaded file should be copied to. If not specified, then the value of the &lt;location&gt; element specified in the Servlet 3.0 web.xml &lt;multipart-config&gt; of the FacesServlet &lt;servlet&gt; will be utilized. Otherwise, the value of the "com.liferay.faces.util.uploadedFilesDir" context-param is utilizied.
	 */
	public void setLocation(String location) {
		getStateHelper().put(InputFilePropertyKeys.location, location);
	}

	/**
	 * <code>maxFileSize</code> attribute description:
	 * <br /><br />
	 * Maximum length (in bytes) permitted for each individual uploaded file. If not specified, then files of any length are assumed to be valid.
	 */
	public Long getMaxFileSize() {
		return (Long) getStateHelper().eval(InputFilePropertyKeys.maxFileSize, null);
	}

	/**
	 * <code>maxFileSize</code> attribute description:
	 * <br /><br />
	 * Maximum length (in bytes) permitted for each individual uploaded file. If not specified, then files of any length are assumed to be valid.
	 */
	public void setMaxFileSize(Long maxFileSize) {
		getStateHelper().put(InputFilePropertyKeys.maxFileSize, maxFileSize);
	}

	/**
	 * <code>multiple</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying whether or not multiple files can be uploaded. Valid values are blank (to upload a single file) or "multiple" (to upload multiple files).
	 */
	public String getMultiple() {
		return (String) getStateHelper().eval(InputFilePropertyKeys.multiple, null);
	}

	/**
	 * <code>multiple</code> attribute description:
	 * <br /><br />
	 * HTML passthrough attribute specifying whether or not multiple files can be uploaded. Valid values are blank (to upload a single file) or "multiple" (to upload multiple files).
	 */
	public void setMultiple(String multiple) {
		getStateHelper().put(InputFilePropertyKeys.multiple, multiple);
	}

	/**
	 * <code>showPreview</code> attribute description:
	 * <br /><br />
	 * When this flag is true, a table showing a preview will be rendered when the user selects one or more files.
	 */
	public boolean isShowPreview() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.showPreview, false);
	}

	/**
	 * <code>showPreview</code> attribute description:
	 * <br /><br />
	 * When this flag is true, a table showing a preview will be rendered when the user selects one or more files.
	 */
	public void setShowPreview(boolean showPreview) {
		getStateHelper().put(InputFilePropertyKeys.showPreview, showPreview);
	}

	/**
	 * <code>showProgress</code> attribute description:
	 * <br /><br />
	 * When this flag is true, a table showing file upload progress will be rendered when the user selects one of more files.
	 */
	public boolean isShowProgress() {
		return (Boolean) getStateHelper().eval(InputFilePropertyKeys.showProgress, false);
	}

	/**
	 * <code>showProgress</code> attribute description:
	 * <br /><br />
	 * When this flag is true, a table showing file upload progress will be rendered when the user selects one of more files.
	 */
	public void setShowProgress(boolean showProgress) {
		getStateHelper().put(InputFilePropertyKeys.showProgress, showProgress);
	}

	/**
	 * <code>styleClass</code> attribute description:
	 * <br /><br />
	 * List of CSS class names (separated by spaces) that are to be rendered within the class attribute.
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
