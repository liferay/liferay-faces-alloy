/**
 * Copyright (c) 2000-2025 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.component.form.internal;

import java.io.IOException;

import javax.faces.context.ResponseWriter;
import javax.faces.context.ResponseWriterWrapper;


/**
 * @author  Neil Griffin
 */
public class FormResponseWriter extends ResponseWriterWrapper {

	// Private Data Members
	private String encodedActionURL;
	private ResponseWriter wrappedResponseWriter;

	public FormResponseWriter(ResponseWriter responseWriter, String encodedActionURL) {
		this.wrappedResponseWriter = responseWriter;
		this.encodedActionURL = encodedActionURL;
	}

	@Override
	public ResponseWriter getWrapped() {
		return wrappedResponseWriter;
	}

	@Override
	public void writeAttribute(String name, Object value, String property) throws IOException {

		if ("action".equals(name)) {
			value = encodedActionURL;
		}

		super.writeAttribute(name, value, property);
	}
}
