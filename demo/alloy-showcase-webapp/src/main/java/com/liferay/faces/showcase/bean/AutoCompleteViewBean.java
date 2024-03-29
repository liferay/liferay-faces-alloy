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
package com.liferay.faces.showcase.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 * @author  Kyle Stiemann
 */
@ManagedBean
@ViewScoped
public class AutoCompleteViewBean implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 101469870238239865L;

	// Private Data Members
	private String clientFilterType = "charMatch";
	private String serverFilterType = "charMatch";

	public String getClientFilterType() {
		return clientFilterType;
	}

	public String getServerFilterType() {
		return serverFilterType;
	}

	public void setClientFilterType(String clientFilterType) {
		this.clientFilterType = clientFilterType;
	}

	public void setServerFilterType(String serverFilterType) {
		this.serverFilterType = serverFilterType;
	}
}
