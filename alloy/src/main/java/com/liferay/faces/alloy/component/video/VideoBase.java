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
package com.liferay.faces.alloy.component.video;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.media.Media;

import com.liferay.faces.util.component.Styleable;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class VideoBase extends Media implements Styleable {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.video.Video";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.video.VideoRenderer";

	// Protected Enumerations
	protected enum VideoPropertyKeys {
		height,
		poster,
		styleClass,
		width
	}

	public VideoBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The height (in pixels) of the video, this attribute will also be applied to the Adobe&reg; Flash&reg; player's <code>&lt;object&gt;</code> tag.</div>
	 */
	public String getHeight() {
		return (String) getStateHelper().eval(VideoPropertyKeys.height, null);
	}

	/**
	 * <p><code>height</code> attribute description:</p>
	 *
	 * <div>The height (in pixels) of the video, this attribute will also be applied to the Adobe&reg; Flash&reg; player's <code>&lt;object&gt;</code> tag.</div>
	 */
	public void setHeight(String height) {
		getStateHelper().put(VideoPropertyKeys.height, height);
	}

	/**
	 * <p><code>poster</code> attribute description:</p>
	 *
	 * <div>A context-relative path, resource URL, or <code>FacesResource</code> that can be used to retrieve the poster image.</div>
	 */
	public Object getPoster() {
		return (Object) getStateHelper().eval(VideoPropertyKeys.poster, null);
	}

	/**
	 * <p><code>poster</code> attribute description:</p>
	 *
	 * <div>A context-relative path, resource URL, or <code>FacesResource</code> that can be used to retrieve the poster image.</div>
	 */
	public void setPoster(Object poster) {
		getStateHelper().put(VideoPropertyKeys.poster, poster);
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public String getStyleClass() {

		// getStateHelper().eval(VideoPropertyKeys.styleClass, null) is called because
		// super.getStyleClass() may return the styleClass name of the super class.
		String styleClass = (String) getStateHelper().eval(VideoPropertyKeys.styleClass, null);

		return com.liferay.faces.util.component.ComponentUtil.concatCssClasses(styleClass, "alloy-video");
	}

	/**
	 * <p><code>styleClass</code> attribute description:</p>
	 *
	 * <div>List of CSS class names (separated by spaces) that are to be rendered within the class attribute.</div>
	 */
	@Override
	public void setStyleClass(String styleClass) {
		getStateHelper().put(VideoPropertyKeys.styleClass, styleClass);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The width (in pixels) of the video, this attribute will also be applied to the Adobe&reg; Flash&reg; player's <code>&lt;object&gt;</code> tag.</div>
	 */
	public String getWidth() {
		return (String) getStateHelper().eval(VideoPropertyKeys.width, null);
	}

	/**
	 * <p><code>width</code> attribute description:</p>
	 *
	 * <div>The width (in pixels) of the video, this attribute will also be applied to the Adobe&reg; Flash&reg; player's <code>&lt;object&gt;</code> tag.</div>
	 */
	public void setWidth(String width) {
		getStateHelper().put(VideoPropertyKeys.width, width);
	}
}
//J+
