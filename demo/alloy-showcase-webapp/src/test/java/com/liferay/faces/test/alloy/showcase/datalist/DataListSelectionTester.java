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
public class DataListSelectionTester extends DataListTesterBase {

	@Test
	public void runDataListSelectionTest() throws Exception {

		// 1. Navigate to the alloy:dataList "Selection" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "selection");

		// 2. Verify that the following list item terms are displayed: Compatible, Enterprise Ready, Powerful
		// Integration, Lightweight, and Open Source.
		WaitingAsserter waitingAsserter = getWaitingAsserter();

		for (int i = 0; i < LIFERAY_BENEFIT_TERMS.length; i++) {
			assertTextPresentInListItem(waitingAsserter, LIFERAY_BENEFIT_TERMS[i], "ul", "li", i + 1);
		}

		// 3. Verify that only 5 list items appear.
		assertChildElementCount(browserDriver, "ul", "li", LIFERAY_BENEFIT_TERMS.length);

		// 4. Verify that a search icon appears with each of the list items.
		for (int i = 0; i < 5; i++) {
			waitingAsserter.assertElementDisplayed("(//*[contains(@class,'icon-search')])[" + (i + 1) + "]");
		}

		// 5. Click on each list item link and verify that a modal containing the list item term and descriptiong is
		// displayed.
		for (int i = 0; i < LIFERAY_BENEFIT_TERMS.length; i++) {
			testModalDescription(browserDriver, waitingAsserter, LIFERAY_BENEFIT_TERMS[i],
				LIFERAY_BENEFIT_DESCRIPTIONS[i]);
		}
	}

	private void testModalDescription(BrowserDriver browserDriver, WaitingAsserter waitingAsserter, String text,
		String descriptionText) {

		browserDriver.clickElement("(//*[contains(text(),'" + text + "')])[1]");
		waitingAsserter.assertElementDisplayed(MODAL_DIALOG_XPATH);
		waitingAsserter.assertTextPresentInElement(text, MODAL_DIALOG_XPATH);
		waitingAsserter.assertTextPresentInElement(descriptionText, MODAL_DIALOG_XPATH);

		browserDriver.clickElement("(//button[contains(@class,'close')])");
		waitingAsserter.assertElementNotDisplayed(MODAL_DIALOG_XPATH);
	}
}
