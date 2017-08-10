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

import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataListGeneralTester extends DataListTesterBase {

	@Test
	public void runDataListGeneralTest() throws Exception {

		// 1. Navigate to the "General" use case in order to reset the state of the UI.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "general");

		// 2. For each type of list (unordered, ordered, description):
		String[] listTypes = new String[] { "ul", "ol", "dl" };
		String[] listItemTypes = new String[] { "li", "li", "dt" };
		WaitingAsserter waitingAsserter = getWaitingAsserter();

		for (int i = 0; i < listTypes.length; i++) {

			// 2a. Verify that five list items are present in the list.
			String listType = listTypes[i];
			String listItemType = listItemTypes[i];
			assertListChildElementCount(browserDriver, listType, listItemType, DESCRIPTION_LIST_DETAILS.length);

			// 2b. Verify that each description list item contains the expected details.
			for (int j = 0; j < DESCRIPTION_LIST_DETAILS.length; j++) {
				assertListItemText(waitingAsserter, listType, listItemType, j + 1, DESCRIPTION_LIST_DETAILS[j]);
			}
		}
	}
}
