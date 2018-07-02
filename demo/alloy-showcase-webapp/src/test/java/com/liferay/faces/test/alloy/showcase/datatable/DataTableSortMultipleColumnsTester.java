/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
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

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 * @author  Neil Griffin
 */
public class DataTableSortMultipleColumnsTester extends DataTableTesterBase {

	@Test
	public void runDataTableSortMultipleColumnsTest() throws Exception {

		// 1. Navigate to the alloy:dataTable "Sort (Multiple Column)" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "sort-multiple-columns";
		navigateToUseCase(browserDriver, componentUseCase);

		// 2. Verify that the tabular data is paginate according to expected behavior of the pagination buttons.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPaginator(browserDriver, waitingAsserter, componentUseCase);

		// 3. Navigate to the "Sort (Multiple Column)" use case in order to reset the state of the UI.
		navigateToUseCase(browserDriver, componentUseCase);

		// 4. Select "100" from the *Rows Per Page" dropdown list (reduces the number of *Next* button clicks in the
		// following steps).
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "100"));

		// 5. Click the *Last Name* header in order to sort the table primarily by last name in ascending order and
		// verify that the sort indication icon is pointed up.
		browserDriver.clickElementAndWaitForRerender(LAST_NAME_HEADER_XPATH);
		waitingAsserter.assertElementDisplayed(SORTED_ASCENDING_ICON_XPATH);

		// 6. Click the *Date of Birth* header while holding down the meta or command key in order to sort the table
		// secondarily by date of birth in ascending order.
		WebElement rerenderElement = browserDriver.findElementByXpath(DATE_OF_BIRTH_HEADER_XPATH);
		metaOrCommandClick(browserDriver, DATE_OF_BIRTH_HEADER_XPATH);
		browserDriver.waitFor(ExpectedConditions.stalenessOf(rerenderElement));
		browserDriver.waitForElementDisplayed(DATE_OF_BIRTH_HEADER_XPATH);

		// 7. Take note of each customer shown in the table, clicking the *Next* button until all the customers in
		// the table have been noted.
		List<Customer> actualCustomers = extractCustomersFromAllPages(browserDriver, componentUseCase);

		// 8. Verify that the list of noted customers is sorted primarily by last name, and secondarily by date of
		// birth.
		List<Customer> expectedCustomers = new ArrayList<Customer>(actualCustomers);
		Collections.sort(expectedCustomers, new CustomerComparator());
		Assert.assertEquals(TOTAL_CUSTOMERS, actualCustomers.size());
		Assert.assertEquals(expectedCustomers, actualCustomers);
	}

	private static class CustomerComparator implements Comparator<Customer> {

		@Override
		public int compare(Customer customer1, Customer customer2) {

			int comparison = customer1.getLastName().compareTo(customer2.getLastName());

			if ((comparison < 0) || (comparison > 0)) {
				return comparison;
			}
			else {
				return customer1.getDateOfBirth().compareTo(customer2.getDateOfBirth());
			}
		}
	}
}
