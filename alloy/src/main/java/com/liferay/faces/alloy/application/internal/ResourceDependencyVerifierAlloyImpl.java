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

import com.liferay.faces.util.application.ResourceDependencyVerifier;
import com.liferay.faces.util.application.ResourceDependencyVerifierWrapper;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;


/**
 * @author  Kyle Stiemann
 */
public class ResourceDependencyVerifierAlloyImpl extends ResourceDependencyVerifierWrapper {

	// Private Constants
	private static final boolean LIFERAY_PORTAL_DETECTED = ProductMap.getInstance().get(ProductConstants.LIFERAY_PORTAL)
		.isDetected();
	private static final Set<String> LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS = new HashSet<String>();

	static {
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.add(getResourceDependencyId("liferay-faces-alloy-reslib",
				"build/aui/aui-min.js"));
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.add(getResourceDependencyId("liferay-faces-alloy-reslib",
				"build/aui-css/css/bootstrap.min.css"));
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.add(getResourceDependencyId("liferay-faces-alloy-reslib", "liferay.js"));
	}

	// Private Members
	private ResourceDependencyVerifier wrappedResourceDependencyVerifier;

	public ResourceDependencyVerifierAlloyImpl(ResourceDependencyVerifier wrappedResourceDependencyVerifier) {
		this.wrappedResourceDependencyVerifier = wrappedResourceDependencyVerifier;
	}

	@Override
	public boolean isResourceDependencySatisfied(UIComponent componentResource) {

		boolean resourceDependencySatisfied;

		if (LIFERAY_PORTAL_DETECTED &&
				LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.contains(getResourceDependencyId(componentResource))) {
			resourceDependencySatisfied = true;
		}
		else {
			resourceDependencySatisfied = super.isResourceDependencySatisfied(componentResource);
		}

		return resourceDependencySatisfied;
	}

	@Override
	public ResourceDependencyVerifier getWrapped() {
		return wrappedResourceDependencyVerifier;
	}
}
