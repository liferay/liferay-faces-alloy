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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Vernon Singleton
 */
@ManagedBean
@RequestScoped
public class SelectThumbRatingBackingBean {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(SelectThumbRatingBackingBean.class);

	@ManagedProperty(name = "selectThumbRatingModelBean", value = "#{selectThumbRatingModelBean}")
	private SelectThumbRatingModelBean selectThumbRatingModelBean;

	public void setSelectThumbRatingModelBean(SelectThumbRatingModelBean selectThumbRatingModelBean) {
		this.selectThumbRatingModelBean = selectThumbRatingModelBean;
	}

	public void submit() {
		logger.info("submit: selectThumbRatingModelBean.getLike() = " + selectThumbRatingModelBean.getLike());
	}
}
