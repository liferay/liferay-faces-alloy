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
package com.liferay.faces.alloy.component.autocomplete.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * @author  Kyle Stiemann
 */
class AutoCompleteFilterPhraseMatchImpl implements AutoCompleteFilter {

	@Override
	public List<String> doFilter(String query, List<String> items, boolean caseSensitive, Locale locale) {

		List<String> results = new ArrayList<String>();

		if (!caseSensitive) {
			query = query.toLowerCase(locale);
		}

		for (String item : items) {

			if (caseSensitive && item.contains(query)) {
				results.add(item);
			}
			else if (!caseSensitive && item.toLowerCase(locale).contains(query)) {
				results.add(item);
			}
		}

		return results;
	}
}
