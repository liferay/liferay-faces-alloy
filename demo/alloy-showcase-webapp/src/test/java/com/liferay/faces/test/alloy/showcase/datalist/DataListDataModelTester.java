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
public class DataListDataModelTester extends DataListTesterBase {

	@Test
	public void runDataListDataModelTest() throws Exception {

		// 1. Navigate to the "Data Model" use case in order to reset the state of the UI.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "data-model");

		// 2. Verify that the following description list terms are displayed: Compatible, Enterprise Ready, Powerful
		// Integration, Lightweight, and Open Source.
		WaitingAsserter waitingAsserter = getWaitingAsserter();

		for (int i = 0; i < DESCRIPTION_LIST_TERMS.length; i++) {
			assertListItemText(waitingAsserter, "dl", "dt", i + 1, DESCRIPTION_LIST_TERMS[i]);
		}

		assertListChildElementCount(browserDriver, "dl", "dt", DESCRIPTION_LIST_TERMS.length);

		// 3. Verify that each description list term has a corresponding icon displayed.
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-compatible.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-enterprise.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-integration.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-lightweight.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-open-source.png')])");

		// 4. Verify that each description list term has a corresponding description displayed.
		for (int i = 0; i < DESCRIPTION_LIST_DETAILS.length; i++) {
			assertListItemText(waitingAsserter, "dl", "dd", i + 1, DESCRIPTION_LIST_DETAILS[i]);
		}

		assertListChildElementCount(browserDriver, "dl", "dd", DESCRIPTION_LIST_DETAILS.length);
	}
}
