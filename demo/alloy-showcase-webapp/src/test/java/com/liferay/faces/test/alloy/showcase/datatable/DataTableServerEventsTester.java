/**
 * Copyright (c) 2000-2025 Liferay, Inc. All rights reserved.
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

import java.util.List;

import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 * @author  Neil Griffin
 */
public class DataTableServerEventsTester extends DataTableTesterBase {

	// Private Constants
	private static final String COMPONENT_USE_CASE = "server-events";

	@Test
	public void runDataTableServerEventsTest() throws Exception {

		// 1. Navigate to the alloy:dataTable "Server Events" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, COMPONENT_USE_CASE);

		// 2. Verify that the paginator is working correctly by making sure that the first customer on page 1 is not
		// present on page 2, etc.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPaginator(browserDriver, waitingAsserter, COMPONENT_USE_CASE);

		// 3. Verify that rows are selected/deselected when clicking on the corresponding checkbox or radio button.
		List<Customer> customersOnPage1 = extractCustomersFromCurrentPage(browserDriver, COMPONENT_USE_CASE);
		testDataTableSelection(browserDriver, waitingAsserter, COMPONENT_USE_CASE, customersOnPage1);

		// 4. Verify that selecting or deselecting the first, second, and third customers, that RowSelectEvent and
		// RowDeselectEvent fire respectively.
		testDataTableServerEvents(browserDriver, waitingAsserter, 0, customersOnPage1.get(0));
		testDataTableServerEvents(browserDriver, waitingAsserter, 1, customersOnPage1.get(1));
		testDataTableServerEvents(browserDriver, waitingAsserter, 2, customersOnPage1.get(2));

		// 5. Click on the *Check All* checkbox and verify that the RowSelectEvent fires for row indexes 0-9.
		String serverEventInfoText =
			"Received RowSelectRangeEvent for rowIndexes=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] Customers=" + customersOnPage1 +
			" in the APPLY_REQUEST_VALUES 2 phase.";
		browserDriver.clickElement("//input[contains(@id,'selectAll')]");
		waitingAsserter.assertTextPresentInElement(serverEventInfoText, ALLOY_MESSAGES_XPATH);

		// 6. Click again on the *Check All* checkbox and verify that the RowDeselectEvent fires for row indexes 0-9.
		serverEventInfoText =
			"Received RowDeselectRangeEvent for rowIndexes=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] Customers=" +
			customersOnPage1.toString() + " in the APPLY_REQUEST_VALUES 2 phase.";
		browserDriver.clickElement("//input[contains(@id,'selectAll')]");
		waitingAsserter.assertTextPresentInElement(serverEventInfoText, ALLOY_MESSAGES_XPATH);

		// 7. Navigate to the "Server Events" use case in order to reset the state of the UI.
		navigateToUseCase(browserDriver, COMPONENT_USE_CASE);

		// 8. For the first, second, third, and last customer:
		int[] rowIndexes = new int[] { 0, 1, 2, (customersOnPage1.size() - 1) };

		for (int rowIndex : rowIndexes) {

			// 8a. Click on the *Selection Mode* dropdown and select "radio".
			String selectRadioXpath = getDropDownListXpath("Selection Mode", "radio");
			browserDriver.clickElement(selectRadioXpath);
			browserDriver.waitForElementDisplayed("//input[contains(@type,'radio')]");

			// 8b. Verify that selecting and deselecting the customer causes RowSelectEvent and
			// RowDeselectEvent to fire respectively.
			browserDriver.waitForElementDisplayed("//input[contains(@type,'radio')]");
			testDataTableServerEvents(browserDriver, waitingAsserter, rowIndex, customersOnPage1.get(rowIndex));

			// 8c. Navigate to the "Server Events" use case in order to reset the state of the UI.
			navigateToUseCase(browserDriver, COMPONENT_USE_CASE);
		}
	}

	private String getServerEventInfoText(String rowSelectEvent, int rowIndex, Customer customer) {
		return "Received " + rowSelectEvent + " for rowIndex=[" + rowIndex + "] customer=[" + customer +
			"] in the APPLY_REQUEST_VALUES 2 phase.";
	}

	/**
	 * Verifies that selecting or deselecting the customer (whether by clicking on a checkbox or radio button), that
	 * RowSelectEvent and RowDeselectEvent fire respectively.
	 */
	private void testDataTableServerEvents(BrowserDriver browserDriver, WaitingAsserter waitingAsserter, int rowIndex,
		Customer customer) {

		String tableRowCustomersXpath = getRowSelectionInputXpath(customer);
		String rowSelectEventInfoText = getServerEventInfoText("RowSelectEvent", rowIndex, customer);
		browserDriver.clickElement(tableRowCustomersXpath);
		waitingAsserter.assertTextPresentInElement(rowSelectEventInfoText, ALLOY_MESSAGES_XPATH);

		if (browserDriver.findElementsByXpath("//input[contains(@type,'checkbox')]").isEmpty()) {
			metaOrCommandClick(browserDriver, tableRowCustomersXpath);
		}
		else {
			browserDriver.clickElement(tableRowCustomersXpath);
		}

		String rowDeselectEventInfoText = getServerEventInfoText("RowDeselectEvent", rowIndex, customer);
		waitingAsserter.assertTextPresentInElement(rowDeselectEventInfoText, ALLOY_MESSAGES_XPATH);
		browserDriver.clickElement(tableRowCustomersXpath);
		waitingAsserter.assertTextPresentInElement(rowSelectEventInfoText, ALLOY_MESSAGES_XPATH);
	}
}
