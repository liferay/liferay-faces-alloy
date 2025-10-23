/**
 * Copyright (c) 2000-2025 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.showcase.validator;

import java.util.Locale;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.liferay.faces.alloy.component.inputdate.InputDate;
import com.liferay.faces.alloy.component.inputtime.InputTime;
import com.liferay.faces.util.i18n.I18n;
import com.liferay.faces.util.i18n.I18nFactory;


/**
 * @author  Neil Griffin
 */
public class AlloyValidatorHelper {

	public static String getMessage(FacesContext facesContext, InputDate inputDate, String messageId) {

		ExternalContext externalContext = facesContext.getExternalContext();
		I18n i18n = I18nFactory.getI18nInstance(externalContext);
		Object localeObject = inputDate.getLocale(facesContext);
		Locale locale = getObjectAsLocale(localeObject);

		return i18n.getMessage(facesContext, locale, messageId);
	}

	public static String getMessage(FacesContext facesContext, InputTime inputTime, String messageId) {

		ExternalContext externalContext = facesContext.getExternalContext();
		I18n i18n = I18nFactory.getI18nInstance(externalContext);
		Object localeObject = inputTime.getLocale(facesContext);
		Locale locale = getObjectAsLocale(localeObject);

		return i18n.getMessage(facesContext, locale, messageId);
	}

	public static Locale getObjectAsLocale(Object localeAsObject) throws FacesException {

		Locale locale = null;

		if (localeAsObject != null) {

			if (localeAsObject instanceof Locale) {
				locale = (Locale) localeAsObject;
			}
			else if (localeAsObject instanceof String) {

				String localeAsString = (String) localeAsObject;

				if (localeAsString.length() > 0) {
					String[] locales = localeAsString.split("-");

					if (locales.length > 1) {
						locale = new Locale(locales[0], locales[1]);
					}
					else {
						locale = new Locale(locales[0]);
					}
				}
			}
			else {
				throw new FacesException("Unable to convert value to locale.");
			}
		}

		return locale;
	}
}
