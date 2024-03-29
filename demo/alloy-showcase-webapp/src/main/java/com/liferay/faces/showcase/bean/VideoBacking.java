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
package com.liferay.faces.showcase.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.showcase.service.VideoService;
import com.liferay.faces.util.application.FacesResource;


/**
 * @author  Kyle Stiemann
 */
@RequestScoped
@ManagedBean
public class VideoBacking {

	// Injections
	@ManagedProperty(value = "#{videoService}")
	private VideoService videoService;

	private String encodedMp4ResourceURL;
	private FacesResource ogvVideo;
	private List<FacesResource> videos;

	public String getEncodedMp4ResourceURL() throws UnsupportedEncodingException {

		if (encodedMp4ResourceURL == null) {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			Application application = facesContext.getApplication();
			ResourceHandler resourceHandler = application.getResourceHandler();
			Resource mp3AudioResource = resourceHandler.createResource("over-the-rainbow.mp4", "videos");
			String requestPath = mp3AudioResource.getRequestPath();
			ExternalContext externalContext = facesContext.getExternalContext();
			String mp4ResourceURL = externalContext.encodeResourceURL(requestPath);
			encodedMp4ResourceURL = URLEncoder.encode(mp4ResourceURL, "UTF-8");
		}

		return encodedMp4ResourceURL;
	}

	public FacesResource getOgvVideo() {

		if (ogvVideo == null) {
			ogvVideo = new FacesResource("videos", "over-the-rainbow.ogv");
		}

		return ogvVideo;
	}

	public List<FacesResource> getVideos() {
		return videos;
	}

	@PostConstruct
	public void postConstruct() {
		videos = videoService.getAllVideos();
	}

	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}
}
