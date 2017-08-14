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

import java.util.List;

import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 * @author  Neil Griffin
 */
public class DataTableSelectionTester extends DataTableTesterBase {

	@Test
	public void runDataTableSelectionTest() throws Exception {

		// 1. Navigate to the alloy:dataTable "Selection" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "selection";
		navigateToUseCase(browserDriver, componentUseCase);

		// 2. Verify that the paginator is working correctly by making sure that the first customer on page 1 is not
		// present on page 2, etc.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPaginator(browserDriver, waitingAsserter, componentUseCase);

		// 3. Navigate to the "Selection" use case in order to reset the state of the UI.
		navigateToUseCase(browserDriver, componentUseCase);

		// 4. Verify that rows are selected/deselected when clicking on the corresponding checkbox or radio button.
		List<Customer> customersOnPage1 = extractCustomersFromCurrentPage(browserDriver, componentUseCase);
		testDataTableSelection(browserDriver, waitingAsserter, componentUseCase, customersOnPage1);
	}
}
