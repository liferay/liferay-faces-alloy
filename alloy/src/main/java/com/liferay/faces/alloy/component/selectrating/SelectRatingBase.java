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
package com.liferay.faces.alloy.component.selectrating;
//J-

import javax.annotation.Generated;
import com.liferay.faces.alloy.component.selectoneradio.SelectOneRadioBase;

import com.liferay.faces.util.component.ClientComponent;


/**
 * @author	Bruno Basto
 * @author	Kyle Stiemann
 */
@Generated(value = "com.liferay.alloy.tools.builder.FacesBuilder")
public abstract class SelectRatingBase extends SelectOneRadioBase implements ClientComponent {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.alloy.component.selectrating.SelectRating";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.selectrating.SelectRatingRenderer";

	// Protected Enumerations
	protected enum SelectRatingPropertyKeys {
		clientKey
	}

	public SelectRatingBase() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public String getClientKey() {
		return (String) getStateHelper().eval(SelectRatingPropertyKeys.clientKey, null);
	}

	/**
	 * <p><code>clientKey</code> attribute description:</p>
	 *
	 * <div>The key name that can be used to reference the component on the client.</div>
	 */
	@Override
	public void setClientKey(String clientKey) {
		getStateHelper().put(SelectRatingPropertyKeys.clientKey, clientKey);
	}
}
//J+
