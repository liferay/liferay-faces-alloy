/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
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

		// 1. Navigate to the alloy:dataList "General" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "general");

		// 2. For each type of list (unordered, ordered, description):
		String[] listTagNames = new String[] { "ul", "ol", "dl" };
		String[] listItemTagNames = new String[] { "li", "li", "dt" };
		WaitingAsserter waitingAsserter = getWaitingAsserter();

		for (int i = 0; i < listTagNames.length; i++) {

			// 2a. Verify that five list items are present in the list.
			String listType = listTagNames[i];
			String listItemType = listItemTagNames[i];
			assertChildElementCount(browserDriver, listType, listItemType, LIFERAY_BENEFIT_DESCRIPTIONS.length);

			// 2b. Verify that each description list item contains the expected details.
			for (int j = 0; j < LIFERAY_BENEFIT_DESCRIPTIONS.length; j++) {
				assertTextPresentInListItem(waitingAsserter, LIFERAY_BENEFIT_DESCRIPTIONS[j], listType, listItemType,
					j + 1);
			}
		}
	}
}
