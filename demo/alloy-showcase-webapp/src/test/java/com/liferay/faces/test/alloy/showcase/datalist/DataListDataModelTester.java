/**
 * Copyright (c) 2000-2020 Liferay, Inc. All rights reserved.
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

		// 1. Navigate to the alloy:dataList "Data Model" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "data-model");

		// 2. Verify that the following description terms are displayed: Compatible, Enterprise Ready, Powerful
		// Integration, Lightweight, and Open Source.
		WaitingAsserter waitingAsserter = getWaitingAsserter();

		for (int i = 0; i < LIFERAY_BENEFIT_TERMS.length; i++) {
			assertTextPresentInListItem(waitingAsserter, LIFERAY_BENEFIT_TERMS[i], "dl", "dt", i + 1);
		}

		// 3. Verify that only 5 description terms appear.
		assertChildElementCount(browserDriver, "dl", "dt", LIFERAY_BENEFIT_TERMS.length);

		// 4. Verify that each description list term has a corresponding icon displayed.
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-compatible.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-enterprise.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-integration.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-lightweight.png')])");
		waitingAsserter.assertElementDisplayed("(//img[contains(@src,'icon-open-source.png')])");

		// 5. Verify that each description list term has a corresponding description displayed.
		for (int i = 0; i < LIFERAY_BENEFIT_DESCRIPTIONS.length; i++) {
			assertTextPresentInListItem(waitingAsserter, LIFERAY_BENEFIT_DESCRIPTIONS[i], "dl", "dd", i + 1);
		}

		// 6. Verify that only 5 descriptions appear.
		assertChildElementCount(browserDriver, "dl", "dd", LIFERAY_BENEFIT_DESCRIPTIONS.length);
	}
}
