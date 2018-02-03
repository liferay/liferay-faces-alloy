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
package com.liferay.faces.alloy.application.internal;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.util.application.ResourceUtil;
import com.liferay.faces.util.application.ResourceVerifier;
import com.liferay.faces.util.application.ResourceVerifierWrapper;
import com.liferay.faces.util.product.Product;
import com.liferay.faces.util.product.ProductFactory;


/**
 * @author  Kyle Stiemann
 */
public class ResourceVerifierAlloyImpl extends ResourceVerifierWrapper implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 2927555200777822626L;

	// Private Constants
	private static final Set<String> LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS;

	static {
		Set<String> liferayPortalIncludedResourceIds = new HashSet<String>();
		liferayPortalIncludedResourceIds.add(ResourceUtil.getResourceId("liferay-faces-alloy-reslib",
				"build/aui/aui-min.js"));
		liferayPortalIncludedResourceIds.add(ResourceUtil.getResourceId("liferay-faces-alloy-reslib",
				"build/aui-css/css/bootstrap.min.css"));
		liferayPortalIncludedResourceIds.add(ResourceUtil.getResourceId("liferay-faces-alloy-reslib", "liferay.js"));
		LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS = Collections.unmodifiableSet(liferayPortalIncludedResourceIds);
	}

	// Private Members
	private final ResourceVerifier wrappedResourceVerifier;

	public ResourceVerifierAlloyImpl(ResourceVerifier wrappedResourceVerifier) {
		this.wrappedResourceVerifier = wrappedResourceVerifier;
	}

	@Override
	public ResourceVerifier getWrapped() {
		return wrappedResourceVerifier;
	}

	@Override
	public boolean isDependencySatisfied(FacesContext facesContext, UIComponent componentResource) {

		boolean dependencySatisfied;
		ExternalContext externalContext = facesContext.getExternalContext();
		final Product LIFERAY_PORTAL = ProductFactory.getProductInstance(externalContext, Product.Name.LIFERAY_PORTAL);

		if (LIFERAY_PORTAL.isDetected() &&
				LIFERAY_PORTAL_INCLUDED_RESOURCE_IDS.contains(ResourceUtil.getResourceId(componentResource))) {
			dependencySatisfied = true;
		}
		else {
			dependencySatisfied = super.isDependencySatisfied(facesContext, componentResource);
		}

		return dependencySatisfied;
	}
}
