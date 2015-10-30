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

import static com.liferay.faces.alloy.render.internal.AlloyRendererUtil.getAlloyBeginScript;
import com.liferay.faces.util.client.AlloyScript;
import com.liferay.faces.util.client.BrowserSniffer;
import com.liferay.faces.util.client.BrowserSnifferFactory;
import com.liferay.faces.util.client.Script;
import com.liferay.faces.util.client.ScriptEncoder;
import com.liferay.faces.util.context.FacesRequestContext;
import com.liferay.faces.util.factory.FactoryExtensionFinder;


/**
 * @author  Kyle Stiemann
 */
public class ScriptEncoderAlloyImpl implements ScriptEncoder {

	@Override
	public void encodeScripts(ResponseWriter responseWriter) throws IOException {

		FacesRequestContext facesRequestContext = FacesRequestContext.getCurrentInstance();
		List<Script> scripts = facesRequestContext.getScripts();
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

		for (Script script : basicScripts) {
			responseWriter.write(script.getSourceCode());
		}

		if (!alloyScripts.isEmpty()) {

			BrowserSnifferFactory browserSnifferFactory = (BrowserSnifferFactory) FactoryExtensionFinder.getFactory(
					BrowserSnifferFactory.class);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			BrowserSniffer browserSniffer = browserSnifferFactory.getBrowserSniffer(facesContext.getExternalContext());
			String alloyBeginScript = getAlloyBeginScript(allModules.toArray(new String[] {}), browserSniffer);
			responseWriter.write(alloyBeginScript);

			for (AlloyScript alloyScript : alloyScripts) {

				responseWriter.write("(function(){");
				responseWriter.write(alloyScript.getSourceCode());
				responseWriter.write("})();");
			}

			responseWriter.write("});");
		}
	}
}
