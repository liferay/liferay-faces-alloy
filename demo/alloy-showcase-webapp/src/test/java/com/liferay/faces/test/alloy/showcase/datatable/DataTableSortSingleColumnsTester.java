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

import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTableSortSingleColumnsTester extends DataTableTester {

	@Test
	public void runDataTableSortSingleColumnsTest() throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "sort-single-column";
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPagesPagination(browserDriver, waitingAsserter, false);

		// Test and verify sort by first name column in both ascending and descending order.
		verifyDataTableSort(browserDriver, waitingAsserter, FIRST_NAME_HEADER_XPATH, FIRST_NAME_CELL_XPATH,
			componentUseCase);

		// Test and verify sort by last name column in both ascending and descending order.
		verifyDataTableSort(browserDriver, waitingAsserter, LAST_NAME_HEADER_XPATH, LAST_NAME_CELL_XPATH,
			componentUseCase);

		// Test and verify sort by date of birth column in both ascending and descending order.
		verifyDataTableSort(browserDriver, waitingAsserter, DATE_OF_BIRTH_HEADER_XPATH, DATE_OF_BIRTH_CELL_XPATH,
			componentUseCase, true);
	}
}
