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
package com.liferay.faces.showcase.i18n;

import java.io.Serializable;

import com.liferay.faces.util.i18n.I18n;
import com.liferay.faces.util.i18n.I18nFactory;


/**
 * @author  Neil Griffin
 */
public class I18nFactoryAlloyShowcaseImpl extends I18nFactory implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 1641775486709277158L;

	// Private Data Members
	private I18nFactory wrappedI18nFactory;
	private I18n i18n;

	public I18nFactoryAlloyShowcaseImpl(I18nFactory i18nFactory) {
		this.wrappedI18nFactory = i18nFactory;

		I18n wrappedI18n = i18nFactory.getI18n();
		this.i18n = new I18nAlloyShowcaseImpl(wrappedI18n);
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
