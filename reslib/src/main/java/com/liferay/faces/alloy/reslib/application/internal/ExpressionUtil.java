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

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.ExternalContext;


/**
 * @author  Kyle Stiemann
 */
/* package-private */ class ExpressionUtil {

	// Private Constants
	private static final String RESOURCE_TOKEN_BEGIN = "#{resource['";
	private static final String RESOURCE_TOKEN_END = "']}";

	// Prevent instantiation since this is a static utility class.
	private ExpressionUtil() {
		throw new AssertionError();
	}

	/* package-priavte */ static String filterResourceExpressions(String text, ResourceHandler resourceHandlerChain,
		ExternalContext externalContext) {

		int startPos = text.indexOf(RESOURCE_TOKEN_BEGIN);

		while (startPos > 0) {
			int finishPos = text.indexOf(RESOURCE_TOKEN_END, startPos);

			if (finishPos > 0) {
				String resourcePair = text.substring(startPos + RESOURCE_TOKEN_BEGIN.length(), finishPos);

				if (resourcePair.indexOf(":") > 0) {
					String[] resourceTokens = resourcePair.split(":");
					String libraryName = resourceTokens[0];
					String resourceName = resourceTokens[1];
					Resource resource = resourceHandlerChain.createResource(resourceName, libraryName);

					if (resource != null) {

						String requestPath = resource.getRequestPath();

						if (requestPath != null) {

							String resourceURL = externalContext.encodeResourceURL(requestPath);
							text = text.substring(0, startPos) + resourceURL +
								text.substring(finishPos + RESOURCE_TOKEN_END.length());
						}
					}
				}
			}

			startPos = text.indexOf(RESOURCE_TOKEN_BEGIN);
		}

		return text;
	}
}
