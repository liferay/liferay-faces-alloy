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
package com.liferay.faces.demos.service;

import java.util.List;
import java.util.Map;

import com.liferay.faces.demos.dto.Country;


/**
 * @author  Neil Griffin
 */
public interface CountryService {

	public List<Country> getAllCountries();

	public Country getCountryByCode(String countryCode);

	public Map<Long, Country> getCountryMap();
}
