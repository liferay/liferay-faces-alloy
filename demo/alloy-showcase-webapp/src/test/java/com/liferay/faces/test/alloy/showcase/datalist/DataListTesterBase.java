/**
 * Copyright (c) 2000-2021 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.test.alloy.showcase.datalist;

import com.liferay.faces.test.alloy.showcase.data.DataTesterBase;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataListTesterBase extends DataTesterBase {

	// Protected Constants
	protected static final String[] LIFERAY_BENEFIT_TERMS = {
			"Compatible", "Enterprise Ready", "Powerful Integration", "Lightweight", "Open Source"
		};
	protected static final String[] LIFERAY_BENEFIT_DESCRIPTIONS = new String[] {
			"Liferay lets you reuse the enterprise software and skills you already have in-house.",
			"Liferay is designed for scalability, reliability, and high performance both on-premise and in the cloud.",
			"Liferay is designed for integrating with both enterprise systems and web-based resources.",
			"With Liferay, projects are completed faster and with smaller budgets so you can see immediate results.",
			"Our open source community fosters innovation, increase security, and improves quality of the software."
		};

	/**
	 * Verify that the list item text property is rendered and visible on the page.
	 */
	protected void assertTextPresentInListItem(WaitingAsserter waitingAsserter, String text, String listTagName,
		String listItemTagName, int listItemNumber) {

		String listItemXpath = "//div[@class='showcase-example']//" + listTagName + "//" + listItemTagName;
		String listItemContentXpath = listItemXpath + "[" + listItemNumber + "]";
		waitingAsserter.assertTextPresentInElement(text, listItemContentXpath);
	}
}
