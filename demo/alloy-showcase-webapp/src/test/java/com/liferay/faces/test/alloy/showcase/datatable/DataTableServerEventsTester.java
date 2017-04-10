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
package com.liferay.faces.test.alloy.showcase.datatable;

import java.util.LinkedList;

import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTableServerEventsTester extends DataTableTester {

	@Test
	public void runDataTableServerEventsTest() throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "server-events";
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPagesPagination(browserDriver, waitingAsserter, true);

		LinkedList<String> firstPageFullNames = getFirstPageFullNames(browserDriver, componentUseCase,
				FIRST_NAME_CELL_SELECTION_XPATH, LAST_NAME_CELL_SELECTION_XPATH);
		testDataTableSelection(browserDriver, waitingAsserter, componentUseCase, firstPageFullNames);

		String[] johnAdams = { firstPageFullNames.get(0) };
		testDataTableServerEvents(browserDriver, waitingAsserter, "0", johnAdams);

		// Verify the firing of ServerEvents by selecting the first customer 'checkbox'.
		String firstCustomerFirstName = browserDriver.findElementByXpath(FIRST_NAME_CELL_SELECTION_XPATH).getText();
		String firstCustomerLastName = browserDriver.findElementByXpath(LAST_NAME_CELL_SELECTION_XPATH).getText();
		String serverEventInfoText = serverEventInfoText("RowSelectEvent", "0", firstPageFullNames.get(0));
		verifyClickWaitAssertText(browserDriver, waitingAsserter,
			getTableRowCustomersXpath(firstCustomerFirstName, firstCustomerLastName),
			ASSERT_SERVER_EVENT_INFO_TEXT_XPATH, serverEventInfoText);

		// Verify the firing of ServerEvents by selecting the third customer 'checkbox'.
		String thirdCustomerFirstName = browserDriver.findElementByXpath("(" + FIRST_NAME_CELL_SELECTION_XPATH + ")[3]")
			.getText();
		String thirdCustomerLastName = browserDriver.findElementByXpath("(" + LAST_NAME_CELL_SELECTION_XPATH + ")[3]")
			.getText();
		serverEventInfoText = serverEventInfoText("RowSelectEvent", "2", firstPageFullNames.get(2));
		verifyClickWaitAssertText(browserDriver, waitingAsserter,
			getTableRowCustomersXpath(thirdCustomerFirstName, thirdCustomerLastName),
			ASSERT_SERVER_EVENT_INFO_TEXT_XPATH, serverEventInfoText);

		// Verify that selecting and deselecting the 'all checkbox' fires RowSelectEvent and RowDeselectEvent.
		serverEventInfoText = "Received RowSelectRangeEvent for rowIndexes=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] Customers=[" +
			removeBrackets(firstPageFullNames.toString()) + "] in the APPLY_REQUEST_VALUES 2 phase.";
		verifyClickWaitAssertText(browserDriver, waitingAsserter, "//input[contains(@id,'selectAll')]",
			ASSERT_SERVER_EVENT_INFO_TEXT_XPATH, serverEventInfoText);

		serverEventInfoText =
			"Received RowDeselectRangeEvent for rowIndexes=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] Customers=[" +
			removeBrackets(firstPageFullNames.toString()) + "] in the APPLY_REQUEST_VALUES 2 phase.";
		verifyClickWaitAssertText(browserDriver, waitingAsserter, "//input[contains(@id,'selectAll')]",
			ASSERT_SERVER_EVENT_INFO_TEXT_XPATH, serverEventInfoText);

		// Reset UI state for radio.
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);

		// Select and verify that 'radio' Selection Mode is selected.
		String selectRadioXpath = labelSelectOptionValueXpath("Selection Mode", "radio");
		browserDriver.clickElement(selectRadioXpath);
		browserDriver.waitForElementDisplayed("//input[contains(@type,'radio')]");

		testDataTableServerEvents(browserDriver, waitingAsserter, "0", johnAdams);

		// Due to UI state getting reset again, select and verify that 'radio' Selection Mode is selected.
		browserDriver.clickElement(selectRadioXpath);
		browserDriver.waitForElementDisplayed("//input[contains(@type,'radio')]");

		String[] francisLewis = { firstPageFullNames.get(firstPageFullNames.size() - 1) };
		testDataTableServerEvents(browserDriver, waitingAsserter, "9", francisLewis);
	}
}
