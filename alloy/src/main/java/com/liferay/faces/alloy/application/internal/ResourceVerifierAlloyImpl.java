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
package com.liferay.faces.alloy.application.internal;

import java.util.HashSet;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.application.ResourceUtil;
import com.liferay.faces.util.application.ResourceVerifier;
import com.liferay.faces.util.application.ResourceVerifierWrapper;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;


/**
 * @author  Kyle Stiemann
 */
public class ResourceVerifierAlloyImpl extends ResourceVerifierWrapper {

	// Private Constants
	private static final boolean LIFERAY_PORTAL_DETECTED = ProductMap.getInstance().get(ProductConstants.LIFERAY_PORTAL)
		.isDetected();
	private static final Set<String> LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS = new HashSet<String>();

	static {
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.add(ResourceUtil.getResourceId("liferay-faces-alloy-reslib",
				"build/aui/aui-min.js"));
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.add(ResourceUtil.getResourceId("liferay-faces-alloy-reslib",
				"build/aui-css/css/bootstrap.min.css"));
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.add(ResourceUtil.getResourceId("liferay-faces-alloy-reslib",
				"build/aui-css/css/bootstrap-responsive.min.css"));
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.add(ResourceUtil.getResourceId("liferay-faces-alloy-reslib",
				"liferay.js"));
	}

	// Private Members
	private ResourceVerifier wrappedResourceVerifier;

	public ResourceVerifierAlloyImpl(ResourceVerifier wrappedResourceVerifier) {
		this.wrappedResourceVerifier = wrappedResourceVerifier;
	}

	@Override
	public boolean isDependencySatisfied(FacesContext facesContext, UIComponent componentResource) {

		boolean dependencySatisfied;

		if (LIFERAY_PORTAL_DETECTED &&
				LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.contains(ResourceUtil.getResourceId(componentResource))) {
			dependencySatisfied = true;
		}
		else {
			dependencySatisfied = super.isDependencySatisfied(facesContext, componentResource);
		}

		return dependencySatisfied;
	}

	@Override
	public ResourceVerifier getWrapped() {
		return wrappedResourceVerifier;
	}
}
