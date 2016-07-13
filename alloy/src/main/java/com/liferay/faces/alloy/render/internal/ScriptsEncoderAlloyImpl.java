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

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.liferay.faces.util.client.BrowserSniffer;
import com.liferay.faces.util.client.BrowserSnifferFactory;
import com.liferay.faces.util.client.Script;
import com.liferay.faces.util.client.ScriptsEncoder;


/**
 * @author  Kyle Stiemann
 */
public class ScriptsEncoderAlloyImpl implements ScriptsEncoder, Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 9063135909273616418L;

	@Override
	public void encodeBodyScripts(FacesContext facesContext, List<Script> scripts) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		responseWriter.startElement("script", null);
		responseWriter.writeAttribute("type", "text/javascript", null);
		encodeScripts(facesContext, responseWriter, scripts);
		responseWriter.endElement("script");
	}

	@Override
	public void encodeEvalScripts(FacesContext facesContext, List<Script> scripts) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		encodeScripts(facesContext, responseWriter, scripts);
	}

	private void encodeScripts(FacesContext facesContext, ResponseWriter responseWriter, List<Script> scripts)
		throws IOException {

		Set<String> sortedModules = new TreeSet<String>();
		List<Script> alloyScripts = new ArrayList<Script>();
		List<Script> basicScripts = new ArrayList<Script>();

		for (Script script : scripts) {

			Script.ModulesType modulesType = script.getModulesType();

			if (Script.ModulesType.ALLOY.equals(modulesType)) {

				String[] modules = script.getModules();

				if (modules != null) {

					for (String module : modules) {
						sortedModules.add(module.trim());
					}
				}

				alloyScripts.add(script);
			}
			else {
				basicScripts.add(script);
			}
		}

		for (Script script : basicScripts) {
			responseWriter.write(script.getSourceCode());
		}

		if (!alloyScripts.isEmpty()) {

			BrowserSniffer browserSniffer = BrowserSnifferFactory.getBrowserSnifferInstance(
					facesContext.getExternalContext());
			String alloyBeginScript = AlloyRendererUtil.getAlloyBeginScript(sortedModules, null, browserSniffer);
			responseWriter.write(alloyBeginScript);

			for (Script alloyScript : alloyScripts) {

				responseWriter.write("(function(){");
				responseWriter.write(alloyScript.getSourceCode());
				responseWriter.write("})();");
			}

			responseWriter.write("});");
		}
	}
}
