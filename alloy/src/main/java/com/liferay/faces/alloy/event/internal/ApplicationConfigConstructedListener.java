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
package com.liferay.faces.alloy.event.internal;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import com.liferay.faces.alloy.config.internal.AlloyWebConfigParam;
import com.liferay.faces.alloy.taghandler.LoadConstants;
import com.liferay.faces.util.cache.Cache;
import com.liferay.faces.util.cache.CacheFactory;
import com.liferay.faces.util.config.ApplicationConfig;


/**
 * @author  Kyle Stiemann
 */
public class ApplicationConfigConstructedListener implements SystemEventListener {

	/**
	 * This method initializes the constant cache for {@link LoadConstants}. This method is called in {@link
	 * com.liferay.faces.alloy.event.internal.ApplicationConfigConstructedListener#processEvent(javax.faces.event.SystemEvent)
	 * } to ensure that the CacheFactory has been created and the cache is initialized in a single-threaded context. The
	 * initialization cannot be performed in the constructor of LoadConstants since that would create a race condition
	 * where different instances of LoadConstants might overwrite the initial cache.
	 *
	 * @param  initFacesContext
	 */
	private static void initLoadConstantsCache(FacesContext initFacesContext) {

		Cache<String, Map<String, Object>> constantCache;
		ExternalContext externalContext = initFacesContext.getExternalContext();
		int initialCacheCapacity = AlloyWebConfigParam.AlloyLoadConstantsInitialCacheCapacity.getIntegerValue(
				externalContext);
		int maxCacheCapacity = AlloyWebConfigParam.AlloyLoadConstantsMaxCacheCapacity.getIntegerValue(externalContext);

		if (maxCacheCapacity > -1) {
			constantCache = CacheFactory.getConcurrentLRUCacheInstance(externalContext, initialCacheCapacity,
					maxCacheCapacity);
		}
		else {
			constantCache = CacheFactory.getConcurrentCacheInstance(externalContext, initialCacheCapacity);
		}

		Map<String, Object> applicationMap = externalContext.getApplicationMap();
		applicationMap.put(LoadConstants.class.getName(), constantCache);
	}

	@Override
	public boolean isListenerForSource(Object source) {
		return ((source != null) && (source instanceof ApplicationConfig));
	}

	@Override
	public void processEvent(SystemEvent systemEvent) throws AbortProcessingException {

		FacesContext initFacesContext = FacesContext.getCurrentInstance();
		initLoadConstantsCache(initFacesContext);
	}
}
