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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.faces.showcase.dto.Customer;
import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTableSortMultipleColumnsTester extends DataTableTester {

	@Test
	public void runDataTableSortMultipleColumnsTest() throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "sort-multiple-columns";
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPagesPagination(browserDriver, waitingAsserter, false);

		// 1. Take note of each customer on every page of the table, clicking the *Next* button until all the values
		// in each column have been noted.
		List<Customer> customers = extractCustomersFromDataTable(browserDriver, FIRST_NAME_CELL_XPATH,
				LAST_NAME_CELL_XPATH, DATE_OF_BIRTH_CELL_XPATH);

		// 2. Create a comparison criterion for sorting customers primarily by last name and secondarily by date of
		// birth.
		Comparator<Customer> customerComparator = new Comparator<Customer>() {
				@Override
				public int compare(Customer c1, Customer c2) {
					int i = 0;
					c1.getLastName().compareTo(c2.getLastName());

					if (c1.getLastName().compareTo(c2.getLastName()) > 0) {
						i = 1;
					}

					;

					if (c1.getLastName().compareTo(c2.getLastName()) < 0) {
						i = -1;
					}

					;

					if (c1.getLastName().compareTo(c2.getLastName()) == 0) {

						if (c1.getDateOfBirth().compareTo(c2.getDateOfBirth()) > 0) {
							i = 1;
						}

						;

						if (c1.getDateOfBirth().compareTo(c2.getDateOfBirth()) < 0) {
							i = -1;
						}

						;

						if (c1.getDateOfBirth().compareTo(c2.getDateOfBirth()) == 0) {
							i = 0;
						}

						;
					}

					;

					return i;
				}
			};

		// 3. Sort the initial unsorted list of values according to the comparison criterion to obtain the expected
		// list.
		Collections.sort(customers, customerComparator);

		List<String> expectedFirstNames = new ArrayList<String>(customers.size());

		for (Customer customer : customers) {
			expectedFirstNames.add(customer.getFirstName());
		}

		logger.debug("Expected sorted list of first names:[{}]", expectedFirstNames);

		// 4. Reset UI state
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);

		// 5. Click the *Last Name* header to sort dataTable values into ascending order and verify that the sort
		// indication icon is pointed up (ascending order).
		browserDriver.centerElementInCurrentWindow(LAST_NAME_HEADER_XPATH);
		browserDriver.clickElementAndWaitForRerender(LAST_NAME_HEADER_XPATH);
		waitingAsserter.assertElementDisplayed(SORTED_ASCENDING_ICON_XPATH);

		// 6. Click the *Date of Birth* header while holding down the meta or command key to sort dataTable values
		// secondarily by date of birth.
		WebElement rerenderElement = browserDriver.findElementByXpath(DATE_OF_BIRTH_HEADER_XPATH);
		browserDriver.centerElementInCurrentWindow(DATE_OF_BIRTH_HEADER_XPATH);
		metaOrCommandClick(browserDriver, DATE_OF_BIRTH_HEADER_XPATH);
		browserDriver.waitFor(ExpectedConditions.stalenessOf(rerenderElement));
		browserDriver.waitForElementDisplayed(DATE_OF_BIRTH_HEADER_XPATH);

		// 7. Take note of each first name value in the *FirstName* column of the table, clicking the *Next* button
		// until all the values in that column have been noted.
		List<String> actualFirstNames = extractColumnValuesFromDataTable(browserDriver, FIRST_NAME_CELL_XPATH);
		logger.debug("Actual sorted list of first names:[{}]", actualFirstNames);

		// 8. Verify that the sorted list obtained from the UI matches the order of the expected list (sorted in
		// ascending order).
		Assert.assertEquals(expectedFirstNames, actualFirstNames);
	}
}
