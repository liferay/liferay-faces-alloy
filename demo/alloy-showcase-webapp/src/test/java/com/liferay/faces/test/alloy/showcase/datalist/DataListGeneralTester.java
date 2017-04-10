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
public class DataListGeneralTester extends DataListTester {

	@Test
	public void runDataListGeneralTest() throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "general");

		// Verify that five list items of each list type are visible.
		assertListChildElementCount(browserDriver, "ul", "li", 5); // unordered type
		assertListChildElementCount(browserDriver, "ol", "li", 5); // ordered type
		assertListChildElementCount(browserDriver, "dl", "dt", 5); // description type

		WaitingAsserter waitingAsserter = getWaitingAsserter();

		// Verify that the list items' text of each list type are visible.
		assertListItemText(waitingAsserter, "ul", "li", 1, COMPATIBLE_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "ul", "li", 2, ENTERPRISE_READY_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "ol", "li", 3, POWERFUL_INTEGRATION_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "dl", "dt", 4, LIGHTWEIGHT_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "dl", "dt", 5, OPEN_SOURCE_DESCRIPTION_TEXT);
	}
}
