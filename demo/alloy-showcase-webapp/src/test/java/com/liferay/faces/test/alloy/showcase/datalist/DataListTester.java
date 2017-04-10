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
package com.liferay.faces.test.alloy.showcase.datalist;

import com.liferay.faces.test.alloy.showcase.data.DataTester;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataListTester extends DataTester {

	// Common Strings
	protected static final String COMPATIBLE_DESCRIPTION_TEXT =
		"Liferay lets you reuse the enterprise software and skills you already have in-house.";
	protected static final String ENTERPRISE_READY_DESCRIPTION_TEXT =
		"Liferay is designed for scalability, reliablity, and high performance both on-premise and in the cloud.";
	protected static final String POWERFUL_INTEGRATION_DESCRIPTION_TEXT =
		"Liferay is designed for integrating with both enterprise systems and web-based resources.";
	protected static final String LIGHTWEIGHT_DESCRIPTION_TEXT =
		"With Liferay, projects are completed faster and with smaller budgets so you can see immediate results.";
	protected static final String OPEN_SOURCE_DESCRIPTION_TEXT =
		"Our open source community fosters innovation, increase security, and improves quality of the software.";

	// Verify that the list item text property is rendered and visible on the page.
	protected final void assertListItemText(WaitingAsserter waitingAsserter, String listType, String listItemTag,
		int itemNumber, String expectedContent) {

		String listItemXpath = "(//div[@class='showcase-example']//" + listType + "//" + listItemTag + ")";
		String listItemContentXpath = listItemXpath + "[" + itemNumber + "]//*[text()]";
		waitingAsserter.assertTextPresentInElement(expectedContent, listItemContentXpath);
	}
}
