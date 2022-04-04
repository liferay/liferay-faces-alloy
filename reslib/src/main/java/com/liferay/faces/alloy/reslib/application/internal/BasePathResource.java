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
package com.liferay.faces.alloy.reslib.application.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import javax.faces.context.FacesContext;


/**
 * This class represents the "base path" of AlloyUI resource as determined by the {@link #getRequestPath()} method.
 * Since it does not represent an actual resource that can be downloaded, all other methods throw {@link
 * UnsupportedOperationException}.
 *
 * @author  Neil Griffin
 */
public class BasePathResource extends AlloyResource {

	public BasePathResource(String resourceName) {
		super(resourceName);
	}

	@Override
	public InputStream getInputStream() throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, String> getResponseHeaders() {
		throw new UnsupportedOperationException();
	}

	@Override
	public URL getURL() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean userAgentNeedsUpdate(FacesContext context) {
		throw new UnsupportedOperationException();
	}
}
