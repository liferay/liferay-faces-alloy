/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.alloy.i18n.internal;

import java.io.Serializable;

import com.liferay.faces.util.i18n.I18n;
import com.liferay.faces.util.i18n.I18nBundleBase;


/**
 * @author  Neil Griffin
 */
public class I18nAlloyImpl extends I18nBundleBase implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 2433290128484661875L;

	public I18nAlloyImpl(I18n i18n) {
		super(i18n);
	}

	@Override
	public String getBundleKey() {
		return "i18n-alloy";
	}
}
