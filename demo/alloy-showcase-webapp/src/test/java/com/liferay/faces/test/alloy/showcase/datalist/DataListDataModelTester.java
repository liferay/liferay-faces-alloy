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
public class DataListDataModelTester extends DataListTester {

	@Test
	public void runDataListDataModelTest() throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "data-model");

		// Verify that five list items appear on each example of list types.
		assertListChildElementCount(browserDriver, "dl", "dt", 5); // description type
		assertListChildElementCount(browserDriver, "dl", "dd", 5); // description type tags

		WaitingAsserter waitingAsserter = getWaitingAsserter();

		// Verify that list item icons are visible.
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-compatible.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-enterprise.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-integration.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-lightweight.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-open-source.png')])");

		// Verify that list items' text of list type description are visible.
		assertListItemText(waitingAsserter, "dl", "dt", 1, "Compatible");
		assertListItemText(waitingAsserter, "dl", "dt", 2, "Enterprise Ready");
		assertListItemText(waitingAsserter, "dl", "dt", 3, "Powerful Integration");
		assertListItemText(waitingAsserter, "dl", "dt", 4, "Lightweight");
		assertListItemText(waitingAsserter, "dl", "dt", 5, "Open Source");

		assertListItemText(waitingAsserter, "dl", "dd", 1, COMPATIBLE_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "dl", "dd", 2, ENTERPRISE_READY_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "dl", "dd", 3, POWERFUL_INTEGRATION_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "dl", "dd", 4, LIGHTWEIGHT_DESCRIPTION_TEXT);
		assertListItemText(waitingAsserter, "dl", "dd", 5, OPEN_SOURCE_DESCRIPTION_TEXT);
	}
}
