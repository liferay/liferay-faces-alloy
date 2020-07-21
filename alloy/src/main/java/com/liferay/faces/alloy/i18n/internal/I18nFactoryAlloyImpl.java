/**
 * Copyright (c) 2000-2020 Liferay, Inc. All rights reserved.
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
import com.liferay.faces.util.i18n.I18nFactory;


/**
 * @author  Neil Griffin
 */
public class I18nFactoryAlloyImpl extends I18nFactory implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 4854765685342340315L;

	// Private Data Members
	private I18n i18n;
	private I18nFactory wrappedI18nFactory;

	public I18nFactoryAlloyImpl(I18nFactory i18nFactory) {

		I18n i18n = i18nFactory.getI18n();
		this.i18n = new I18nAlloyImpl(i18n);
		this.wrappedI18nFactory = i18nFactory;
	}

	@Override
	public I18n getI18n() {
		return i18n;
	}

	@Override
	public I18nFactory getWrapped() {
		return wrappedI18nFactory;
	}
}
