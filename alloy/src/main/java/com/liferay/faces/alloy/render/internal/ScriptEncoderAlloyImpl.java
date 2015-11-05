/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.liferay.faces.alloy.render.internal.AlloyRendererUtil;
import com.liferay.faces.util.client.AlloyScript;
import com.liferay.faces.util.client.BrowserSniffer;
import com.liferay.faces.util.client.BrowserSnifferFactory;
import com.liferay.faces.util.client.Script;
import com.liferay.faces.util.client.ScriptEncoder;
import com.liferay.faces.util.factory.FactoryExtensionFinder;


/**
 * @author  Kyle Stiemann
 */
public class ScriptEncoderAlloyImpl implements ScriptEncoder {

	@Override
	public void encodeScript(FacesContext facesContext, Script script) throws IOException {

		if (script instanceof AlloyScript) {

			AlloyScript alloyScript = (AlloyScript) script;
			BrowserSnifferFactory browserSnifferFactory = (BrowserSnifferFactory) FactoryExtensionFinder.getFactory(
					BrowserSnifferFactory.class);
			BrowserSniffer browserSniffer = browserSnifferFactory.getBrowserSniffer(facesContext.getExternalContext());
			String[] modules = alloyScript.getModules();
			String alloyBeginScript = AlloyRendererUtil.getAlloyBeginScript(modules, browserSniffer);
			ResponseWriter responseWriter = facesContext.getResponseWriter();
			responseWriter.write(alloyBeginScript);
			encodeScript(facesContext, alloyScript.getSourceCode());
			responseWriter.write("});");
		}
		else {
			encodeScript(facesContext, script.getSourceCode());
		}
	}

	@Override
	public void encodeScript(FacesContext facesContext, String script) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		encodeScript(responseWriter, script);
	}

	@Override
	public void encodeScripts(FacesContext facesContext, List<Script> scripts) throws IOException {

		Set<String> allModules = new TreeSet<String>();
		List<AlloyScript> alloyScripts = new ArrayList<AlloyScript>();
		List<Script> basicScripts = new ArrayList<Script>();

		for (Script script : scripts) {

			if (script instanceof AlloyScript) {

				AlloyScript alloyScript = (AlloyScript) script;
				final String[] modules = alloyScript.getModules();
				Collections.addAll(allModules, modules);
				alloyScripts.add(alloyScript);
			}
			else {
				basicScripts.add(script);
			}
		}

		ResponseWriter responseWriter = facesContext.getResponseWriter();

		for (Script script : basicScripts) {
			encodeScript(responseWriter, script.getSourceCode());
		}

		if (!alloyScripts.isEmpty()) {

			BrowserSnifferFactory browserSnifferFactory = (BrowserSnifferFactory) FactoryExtensionFinder.getFactory(
					BrowserSnifferFactory.class);
			BrowserSniffer browserSniffer = browserSnifferFactory.getBrowserSniffer(facesContext.getExternalContext());
			String alloyBeginScript = AlloyRendererUtil.getAlloyBeginScript(allModules.toArray(new String[] {}),
					browserSniffer);
			responseWriter.write(alloyBeginScript);

			for (AlloyScript alloyScript : alloyScripts) {
				encodeScript(responseWriter, alloyScript.getSourceCode());
			}

			responseWriter.write("});");
		}
	}

	private void encodeScript(ResponseWriter responseWriter, String script) throws IOException {

		responseWriter.write("(function(){");
		responseWriter.write(script);
		responseWriter.write("})();");
	}
}
