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
package com.liferay.faces.showcase.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 * @author  Kyle Stiemann
 */
@ManagedBean
@ViewScoped
public class InputTimeModelBean implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 7445057510998134124L;

	// Private Data Members
	private String highlighterType = "charMatch";
	private Date time;
	private Locale locale;

	public String getHighlighterType() {
		return highlighterType;
	}

	public Locale getLocale() {

		if (locale == null) {
			locale = new Locale("ja", "JA");
		}

		return locale;
	}

	public Date getTime() {
		return time;
	}

	public void setHighlighterType(String highlighterType) {
		this.highlighterType = highlighterType;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
