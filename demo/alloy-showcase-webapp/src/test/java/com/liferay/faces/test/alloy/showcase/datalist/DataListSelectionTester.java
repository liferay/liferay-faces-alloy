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
public class DataListSelectionTester extends DataListTesterBase {

	@Test
	public void runDataListSelectionTest() throws Exception {

		// 1. Navigate to the "Selection" use case in order to reset the state of the UI.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "selection");

		// 2. Verify that the following description list terms are displayed: Compatible, Enterprise Ready, Powerful
		// Integration, Lightweight, and Open Source.
		WaitingAsserter waitingAsserter = getWaitingAsserter();

		for (int i = 0; i < DESCRIPTION_LIST_TERMS.length; i++) {
			assertListItemLinkText(waitingAsserter, "ul", "li", i + 1, DESCRIPTION_LIST_TERMS[i]);
		}

		assertListChildElementCount(browserDriver, "ul", "li", DESCRIPTION_LIST_TERMS.length);

		// 3. Verify that a search icon appears with each of the description list terms.
		for (int i = 0; i < 5; i++) {
			waitingAsserter.assertElementDisplayed("(//*[contains(@class,'icon-search')])[" + (i + 1) + "]");
		}

		// 4. Click on each search icon and verify that the corresponding description list detail is displayed.
		for (int i = 0; i < DESCRIPTION_LIST_TERMS.length; i++) {
			testShowModal(browserDriver, waitingAsserter, DESCRIPTION_LIST_TERMS[i], DESCRIPTION_LIST_DETAILS[i]);
		}
	}

	private void assertListItemLinkText(WaitingAsserter waitingAsserter, String listType, String listItemType,
		int itemNumber, String expectedContent) {

		String listItemXpath = "//div[@class='showcase-example']//" + listType + "//" + listItemType;
		String listItemContentXpath = listItemXpath + "[" + itemNumber + "]//a";
		waitingAsserter.assertTextPresentInElement(expectedContent, listItemContentXpath);
	}

	private void testShowModal(BrowserDriver browserDriver, WaitingAsserter waitingAsserter, String text,
		String descriptionText) {

		// Verify that the "Show Modal" button's value is visibly correct.
		browserDriver.clickElement("(//*[contains(text(),'" + text + "')])[1]");
		browserDriver.waitForTextPresentInElement(text, MODAL_DIALOG_XPATH);
		waitingAsserter.assertElementDisplayed(MODAL_DIALOG_XPATH);

		waitingAsserter.assertTextPresentInElement(descriptionText, MODAL_DIALOG_XPATH);

		browserDriver.clickElement("(//button[contains(@class,'close')])");
		waitingAsserter.assertElementNotDisplayed(MODAL_DIALOG_XPATH);
	}
}
