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

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.liferay.faces.showcase.dto.LiferayBenefit;
import com.liferay.faces.showcase.service.LiferayBenefitService;


/**
 * @author  Vernon Singleton
 */
@ManagedBean
@RequestScoped
public class DataListModelBean {

	@ManagedProperty(name = "liferayBenefitService", value = "#{liferayBenefitService}")
	private LiferayBenefitService liferayBenefitService;

	private LiferayBenefit selectedLiferayBenefit;

	public List<LiferayBenefit> getLiferayBenefits() {
		return liferayBenefitService.getLiferayBenefits();
	}

	public LiferayBenefit getSelectedLiferayBenefit() {
		return selectedLiferayBenefit;
	}

	public void setLiferayBenefitService(LiferayBenefitService liferayBenefitService) {
		this.liferayBenefitService = liferayBenefitService;
	}

	public void setSelectedLiferayBenefit(LiferayBenefit selectedLiferayBenefit) {
		this.selectedLiferayBenefit = selectedLiferayBenefit;
	}
}
