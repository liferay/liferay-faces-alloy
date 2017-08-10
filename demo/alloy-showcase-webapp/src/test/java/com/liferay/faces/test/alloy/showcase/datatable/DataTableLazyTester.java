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

import org.junit.Assert;
import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 * @author  Neil Griffin
 */
public class DataTableLazyTester extends DataTableTesterBase {

	@Test
	public void runDataTableLazyTest() throws Exception {

		// 1. Navigate to the "Lazy" use case in order to reset the state of the UI.
		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "lazy";
		navigateToUseCase(browserDriver, DATA_TABLE, componentUseCase);

		// 2. Verify that the paginator is working correctly by making sure that the first customer on page 1 is not
		// present on page 2, etc.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPaginator(browserDriver, waitingAsserter, componentUseCase);

		// 3. Select "100" from the *Rows Per Page" dropdown list (reduces the number of *Next* button clicks in the
		// following step).
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "100"));

		// 4. Take note of how many rows are in each page, clicking the *Next* button until a total count of all the
		// rows has been noted.
		List<Customer> customers = extractCustomersFromAllPages(browserDriver, componentUseCase);

		// 5. Verify that 162 total rows were displayed.
		Assert.assertEquals(customers.size(), TOTAL_CUSTOMERS);
	}
}
