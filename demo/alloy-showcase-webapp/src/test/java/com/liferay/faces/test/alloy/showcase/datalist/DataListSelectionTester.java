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
public class DataListSelectionTester extends DataListTester {

	@Test
	public void runDataListSelectionTest() throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataList", "selection");

		// Verify that five list items are visible.
		assertListChildElementCount(browserDriver, "ul", "li", 5); // unordered type

		WaitingAsserter waitingAsserter = getWaitingAsserter();

		// Verify that first and last search icons are visible.
		waitingAsserter.assertElementDisplayed("(//*[contains(@class,'icon-search')])[1]");
		waitingAsserter.assertElementDisplayed("(//*[contains(@class,'icon-search')])[5]");

		// Verify that list items' text of list type description are visible.
		assertListItemText(waitingAsserter, "ul", "li", 1, "Compatible");
		assertListItemText(waitingAsserter, "ul", "li", 2, "Enterprise Ready");
		assertListItemText(waitingAsserter, "ul", "li", 3, "Powerful Integration");
		assertListItemText(waitingAsserter, "ul", "li", 4, "Lightweight");
		assertListItemText(waitingAsserter, "ul", "li", 5, "Open Source");

		browserDriver.centerElementInCurrentWindow("(//*[contains(@class,'icon-search')])[5]");

		testShowModal(browserDriver, waitingAsserter, "Enterprise Ready", ENTERPRISE_READY_DESCRIPTION_TEXT);
		testShowModal(browserDriver, waitingAsserter, "Lightweight", LIGHTWEIGHT_DESCRIPTION_TEXT);
	}

	private void testShowModal(BrowserDriver browserDriver, WaitingAsserter waitingAsserter, String text,
		String descriptionText) {

		// Verify that the "Show Modal" button's value is visibly correct.
		browserDriver.clickElement("(//*[contains(text(),'" + text + "')])[1]");
		browserDriver.waitForTextPresentInElement(text, modalDialogXpath);
		waitingAsserter.assertElementDisplayed(modalDialogXpath);

		waitingAsserter.assertTextPresentInElement(descriptionText, modalDialogXpath);

		browserDriver.clickElement("(//button[contains(@class,'close')])");
		waitingAsserter.assertElementNotDisplayed(modalDialogXpath);
	}
}
