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
package com.liferay.faces.alloy.component.inputsourcecode;

import javax.faces.component.FacesComponent;


/**
 * @author  Neil Griffin
 */
@FacesComponent(value = InputSourceCode.COMPONENT_TYPE)
public class InputSourceCode extends InputSourceCodeBase {

	@Override
	public Object getSubmittedValue() {

		Boolean readOnly = getReadOnly();

		if ((readOnly != null) && readOnly) {
			return null;
		}
		else {
			return super.getSubmittedValue();
		}
	}
}
