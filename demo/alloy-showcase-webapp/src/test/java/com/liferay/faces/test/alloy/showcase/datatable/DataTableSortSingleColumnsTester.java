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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTableSortSingleColumnsTester extends DataTableTester {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(DataTableSortSingleColumnsTester.class);

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

	private List<String> sortDateList(List<String> dateList, Boolean reverseOrder) {

		Comparator<String> dateStringComparator = new Comparator<String>() {
				DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");

				@Override
				public int compare(String o1, String o2) {

					try {
						return dateFormat.parse(o1).compareTo(dateFormat.parse(o2));
					}
					catch (ParseException e) {
						throw new IllegalArgumentException(e);
					}
				}
			};

		if (reverseOrder.equals(true)) {
			Collections.sort(dateList, Collections.reverseOrder(dateStringComparator));
		}
		else {
			Collections.sort(dateList, dateStringComparator);
		}

		return dateList;
	}

	private void verifyDataTableSort(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String columnHeaderXpath, String columnElementsXpath, String componentUseCase) {
		verifyDataTableSort(browserDriver, waitingAsserter, columnHeaderXpath, columnElementsXpath, componentUseCase,
			false);
	}

	/**
	 * Verify the sorted order state after executing a column ordering feature of dataTable.
	 */
	private void verifyDataTableSort(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String columnHeaderXpath, String columnElementsXpath, String componentUseCase, Boolean sortDate) {

		// 1. Take note of each dataTable value in a specified column of the table, clicking the *Next* button until
		// all the values in that column have been noted.
		List<String> firstNames = extractColumnValuesFromDataTable(browserDriver, columnElementsXpath);

		// 2. Sort the initial unsorted list of values to obtain the expected list sorted in ascending order.
		List<String> expectedColumnValuesAscending = new ArrayList<String>(firstNames);

		if (sortDate.equals(true)) {
			sortDateList(expectedColumnValuesAscending, false);
		}
		else {
			Collections.sort(expectedColumnValuesAscending);
		}

		logger.debug("Expected sorted list of first names (ascending):[{}]", expectedColumnValuesAscending);

		// 3. Reset UI state
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);

		// 4. Click the specified header to sort dataTable values into ascending order and verify that the sort
		// indication icon is pointed up (ascending order).
		browserDriver.centerElementInCurrentWindow(columnHeaderXpath);
		browserDriver.clickElement(columnHeaderXpath);
		waitingAsserter.assertElementDisplayed(SORTED_ASCENDING_ICON_XPATH);

		// 5. Take note of each dataTable value in a specified column of the table, clicking the *Next* button until
		// all the values in that column have been noted.
		List<String> actualColumnValuesAscending = extractColumnValuesFromDataTable(browserDriver, columnElementsXpath);
		logger.debug("Actual screen names extracted from the UI after sorting by ascending order:[{}]",
			actualColumnValuesAscending);

		// 6. Verify that the sorted list obtained from the UI matches the order of the expected list (sorted in
		// ascending order).
		Assert.assertEquals(expectedColumnValuesAscending, actualColumnValuesAscending);

		// 7. Click the *First Page* button to go back to the first page of users.
		browserDriver.centerElementInCurrentWindow(columnHeaderXpath);
		browserDriver.clickElement(getNavigationButtonXpath("firstPage"));
		browserDriver.waitFor(pageButtonClassActive(1));

		// 8. Click the specified header to sort dataTable values into descending order and verify that the sort
		// indication icon is pointed down.
		browserDriver.centerElementInCurrentWindow(columnHeaderXpath);
		browserDriver.clickElement(columnHeaderXpath);
		waitingAsserter.assertElementDisplayed(
			"//th[contains(@class,'table-sortable-column table-sorted table-sorted-desc')]//span[contains(@class,'table-sort-indicator')]");

		// 9. Take note of each dataTable value in a specified column of the table, clicking the *Next* button until
		// all the values in that column have been noted.
		List<String> actualColumnValuesDescending = extractColumnValuesFromDataTable(browserDriver,
				columnElementsXpath);
		logger.debug("Actual screen names extracted from the UI after sorting by descending order:[{}]",
			actualColumnValuesDescending);

		// 10. Sort the initial unsorted list of values to obtain the expected list sorted in descending order.
		List<String> expectedColumnValuesDescending = new ArrayList<String>(firstNames);

		if (sortDate.equals(true)) {
			sortDateList(expectedColumnValuesDescending, true);
		}
		else {
			Collections.sort(expectedColumnValuesDescending, Collections.reverseOrder());
		}

		logger.debug("Expected sorted list of first names (descending):[{}]", expectedColumnValuesDescending);

		// 11. Verify that the sorted list obtained from the UI matches the order of the expected list (sorted in
		// descending order).
		Assert.assertEquals(expectedColumnValuesDescending, actualColumnValuesDescending);

		// 12. Reset UI state
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);
	}
}
