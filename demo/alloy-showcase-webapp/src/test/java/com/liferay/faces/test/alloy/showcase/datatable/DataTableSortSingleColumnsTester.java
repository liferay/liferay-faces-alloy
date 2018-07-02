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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class DataTableSortSingleColumnsTester extends DataTableTesterBase {

	// Private Constants
	private static final String COMPONENT_USE_CASE = "sort-single-column";
	private static final String FIRST_NAME_HEADER_XPATH = "//table/thead/tr/th[@scope='col'][contains(.,'First Name')]";

	@Test
	public void runDataTableSortSingleColumnsTest() throws Exception {

		// 1. Navigate to the "Sort (Single Column)" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, COMPONENT_USE_CASE);

		// 2. Verify that the paginator is working correctly by making sure that the first customer on page 1 is not
		// present on page 2, etc.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPaginator(browserDriver, waitingAsserter, COMPONENT_USE_CASE);

		// 3. For each column header: *First Name*, *Last Name*, and *Date of Birth*: Verify that clicking on the column
		// header causes the tabular data to be sorted in ascending order. Also verify that a subsequent click on the
		// column header causes the tabular data to be sorted in descending order.
		verifyDataTableSort(browserDriver, waitingAsserter, FIRST_NAME_HEADER_XPATH);
		verifyDataTableSort(browserDriver, waitingAsserter, LAST_NAME_HEADER_XPATH);
		verifyDataTableSort(browserDriver, waitingAsserter, DATE_OF_BIRTH_HEADER_XPATH);
	}

	private void sortCustomers(List<Customer> customers, Comparator comparator, boolean ascending) {

		if (ascending) {
			Collections.sort(customers, comparator);
		}
		else {
			Collections.sort(customers, Collections.reverseOrder(comparator));
		}
	}

	private void sortCustomers(List<Customer> customers, String columnHeaderXpath, boolean ascending) {

		if (FIRST_NAME_HEADER_XPATH.equals(columnHeaderXpath)) {
			sortCustomers(customers, new CustomerFirstNameComparator(), ascending);
		}
		else if (LAST_NAME_HEADER_XPATH.equals(columnHeaderXpath)) {
			sortCustomers(customers, new CustomerLastNameComparator(), ascending);
		}
		else if (DATE_OF_BIRTH_HEADER_XPATH.equals(columnHeaderXpath)) {
			sortCustomers(customers, new CustomerDateOfBirthComparator(), ascending);
		}
	}

	/**
	 * Verify that clicking on the column header targeted by the specified XPath causes the tabular data to be sorted in
	 * ascending order, and that a subsequent click on the column header causes the tabular data to be sorted in
	 * descending order.
	 */
	private void verifyDataTableSort(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String columnHeaderXpath) throws ParseException {

		// 1. Navigate to the alloy:dataTable "Sort (Single Column)" use case in order to reset the state of the UI.
		navigateToUseCase(browserDriver, COMPONENT_USE_CASE);

		// 2. Select "100" from the *Rows Per Page" dropdown list (reduces the number of *Next* button clicks in the
		// following steps).
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "100"));

		// 3. Click the specified column header in order to sort the table by ascending order and verify that the sort
		// indication icon is pointed up.
		browserDriver.clickElement(columnHeaderXpath);
		waitingAsserter.assertElementDisplayed(SORTED_ASCENDING_ICON_XPATH);

		// 4. Take note of each customer shown in the table, clicking the *Next* button until all the customers in
		// the table have been noted.
		List<Customer> actualCustomersAscending = extractCustomersFromAllPages(browserDriver, COMPONENT_USE_CASE);

		// 5. Verify that the list of noted customers is sorted in descending order according to the specified column
		// header.
		List<Customer> expectedCustomers = new ArrayList<Customer>(actualCustomersAscending);
		sortCustomers(expectedCustomers, columnHeaderXpath, true);
		Assert.assertEquals(TOTAL_CUSTOMERS, actualCustomersAscending.size());
		Assert.assertEquals(expectedCustomers, actualCustomersAscending);

		// 6. Click the *First Page* button to go back to the first page of users.
		browserDriver.clickElement(getPaginatorButtonXpath("firstPage"));
		browserDriver.waitFor(pageButtonClassActive(1));

		// 7. Click the specified column header in order to sort the table by descending order and verify that the sort
		// indication icon is pointed down.
		browserDriver.clickElement(columnHeaderXpath);
		waitingAsserter.assertElementDisplayed(
			"//th[contains(@class,'table-sortable-column table-sorted table-sorted-desc')]//span[contains(@class,'table-sort-indicator')]");

		// 8. Take note of each customer shown in the table, clicking the *Next* button until all the customers have
		// been noted.
		List<Customer> actualCustomersDescending = extractCustomersFromAllPages(browserDriver, COMPONENT_USE_CASE);

		// 9. Verify that the list of noted customers is sorted in descending order according to the specified column
		// header.
		Assert.assertEquals(TOTAL_CUSTOMERS, actualCustomersDescending.size());
		sortCustomers(expectedCustomers, columnHeaderXpath, false);
		Assert.assertEquals(expectedCustomers, actualCustomersDescending);

		// 10. Again, navigate to the "Sort (Single Column)" use case in order to reset the state of the UI.
		navigateToUseCase(browserDriver, COMPONENT_USE_CASE);
	}

	private static final class CustomerDateOfBirthComparator implements Comparator<Customer> {

		@Override
		public int compare(Customer customer1, Customer customer2) {
			return customer1.getDateOfBirth().compareTo(customer2.getDateOfBirth());
		}
	}

	private static final class CustomerFirstNameComparator implements Comparator<Customer> {

		@Override
		public int compare(Customer customer1, Customer customer2) {
			return customer1.getFirstName().compareTo(customer2.getFirstName());
		}
	}

	private static final class CustomerLastNameComparator implements Comparator<Customer> {

		@Override
		public int compare(Customer customer1, Customer customer2) {
			return customer1.getLastName().compareTo(customer2.getLastName());
		}
	}
}
