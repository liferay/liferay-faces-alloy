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
package com.liferay.faces.alloy.render.internal;

import java.util.Set;
import java.util.TreeSet;

import com.liferay.faces.util.client.BrowserSniffer;


/**
 * @author  Kyle Stiemann
 */
public class AlloyRendererUtil {

	public static String getAlloyBeginScript(String[] modules, String yuiConfig, BrowserSniffer browserSniffer) {

		Set<String> sortedModules = null;

		if (modules != null) {

			sortedModules = new TreeSet<String>();

			for (String module : modules) {
				sortedModules.add(module.trim());
			}
		}

		return getAlloyBeginScript(sortedModules, yuiConfig, browserSniffer);
	}

	public static String getAlloyBeginScript(Set<String> sortedModules, String yuiConfig,
		BrowserSniffer browserSniffer) {

		StringBuilder stringBuilder = new StringBuilder();
		String loadMethod = "use";
		boolean browserIE = browserSniffer.isIe();
		float browserMajorVersion = browserSniffer.getMajorVersion();

		if (browserIE && (browserMajorVersion < 8)) {
			loadMethod = "ready";
		}

		// If there is config render a YUI sandbox to avoid using the preconfigured AUI sandbox in Liferay Portal.
		if ((yuiConfig != null) && (yuiConfig.length() > 0)) {

			stringBuilder.append("YUI(");
			stringBuilder.append(yuiConfig);
		}
		else {
			stringBuilder.append("AUI(");
		}

		stringBuilder.append(").");
		stringBuilder.append(loadMethod);
		stringBuilder.append("(");

		if (sortedModules != null) {

			for (String module : sortedModules) {

				stringBuilder.append("'");
				stringBuilder.append(module);
				stringBuilder.append("',");
			}
		}

		stringBuilder.append("function(A){");

		return stringBuilder.toString();
	}
}
