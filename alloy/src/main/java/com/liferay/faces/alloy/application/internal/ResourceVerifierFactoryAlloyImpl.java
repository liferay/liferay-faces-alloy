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
package com.liferay.faces.alloy.application.internal;

import java.io.Serializable;

import com.liferay.faces.util.application.ResourceVerifier;
import com.liferay.faces.util.application.ResourceVerifierFactory;


/**
 * @author  Kyle Stiemann
 */
public class ResourceVerifierFactoryAlloyImpl extends ResourceVerifierFactory implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 5965483678717545981L;

	// Private Data Members
	private ResourceVerifier resourceVerifier;
	private ResourceVerifierFactory wrappedResourceVerifierFactory;

	public ResourceVerifierFactoryAlloyImpl(ResourceVerifierFactory resourceVerifierFactory) {

		ResourceVerifier resourceVerifier = resourceVerifierFactory.getResourceVerifier();
		this.resourceVerifier = new ResourceVerifierAlloyImpl(resourceVerifier);
		this.wrappedResourceVerifierFactory = resourceVerifierFactory;
	}

	@Override
	public ResourceVerifier getResourceVerifier() {
		return resourceVerifier;
	}

	@Override
	public ResourceVerifierFactory getWrapped() {
		return wrappedResourceVerifierFactory;
	}
}
