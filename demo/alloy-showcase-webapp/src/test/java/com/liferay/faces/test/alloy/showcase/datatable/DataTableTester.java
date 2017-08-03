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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.liferay.faces.showcase.dto.Country;
import com.liferay.faces.showcase.dto.Customer;
import com.liferay.faces.test.alloy.showcase.data.DataTester;
import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTableTester extends DataTester {

	// Common Xpath
	protected static final String ASSERT_SERVER_EVENT_INFO_TEXT_XPATH =
		"//table[contains(@class,'alloy-messages')]/tbody/tr/td";
	protected static final String DATE_OF_BIRTH_HEADER_XPATH =
		"//table/thead/tr/th[@scope='col'][contains(.,'Date of Birth')]";
	protected static final String FIRST_NAME_HEADER_XPATH =
		"//table/thead/tr/th[@scope='col'][contains(.,'First Name')]";
	protected static final String FIRST_NAME_SORT_BUTTON_XPATH =
		"//th[contains(@class,'table-sorted')]//span[contains(@class,'table-sort-indicator')]";
	protected static final String LAST_NAME_HEADER_XPATH = "//table/thead/tr/th[@scope='col'][contains(.,'Last Name')]";
	protected static final String LAST_NAME_CELL_XPATH = "//tbody//td[2]//span[contains(@class,'alloy-output-text')]";
	protected static final String DATE_OF_BIRTH_CELL_XPATH =
		"//tbody//td[3]//span[contains(@class,'alloy-output-text')]";
	protected static final String FIRST_NAME_CELL_SELECTION_XPATH =
		"//tbody//td[2]//span[contains(@class,'alloy-output-text')]";
	protected static final String LAST_NAME_CELL_SELECTION_XPATH =
		"//tbody//td[3]//span[contains(@class,'alloy-output-text')]";
	protected static final String NOT_INFO_TEXT_XPATH =
		"(//table[contains(@class,'alloy-messages')]/tbody/tr/td[not(contains(.,'in the APPLY_REQUEST_VALUES 2 phase.'))])";
	protected static final String PAGE_BUTTON_XPATH_PREFIX =
		"//div[contains(@class,'alloy-paginator')]//ul[contains(@class,'pagination')]";
	protected static final String SORTED_ASCENDING_ICON_XPATH =
		"//th[contains(@class,'table-sortable-column table-sorted')][not(contains(@class,'table-sorted-desc'))]//span[contains(@class,'table-sort-indicator')]";
	protected static final String SORTED_DESCENDING_ICON_XPATH =
		"//th[contains(@class,'table-sortable-column table-sorted table-sorted-desc')]//span[contains(@class,'table-sort-indicator')]";

	protected static String FIRST_NAME_CELL_XPATH = "//tbody//td[1]//span[contains(@class,'alloy-output-text')]";

	protected String alloyMessageXpath(String alloyMessage) {
		return "(//table[contains(@class,'alloy-messages')]/tbody/tr/td[contains(.,'" + alloyMessage + "')])";
	}

	protected void clickAndVerifyRowDeselection(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String firstName, String lastName) {

		// For Radio deselect, the meta or command button must be held down before clicking.
		if (browserDriver.findElementsByXpath("//input[contains(@type,'checkbox')]").isEmpty()) {
			metaOrCommandClick(browserDriver, getTableRowCustomersXpath(firstName, lastName));
		}
		else {
			browserDriver.clickElement(getTableRowCustomersXpath(firstName, lastName));
		}

		waitingAsserter.assertElementDisplayed(getRowXpath(firstName, lastName, false));
	}

	protected void clickAndVerifyRowSelection(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String firstName, String lastName) {
		browserDriver.centerElementInCurrentWindow(getTableRowCustomersXpath(firstName, lastName));
		browserDriver.clickElement(getTableRowCustomersXpath(firstName, lastName));
		waitingAsserter.assertElementDisplayed(getRowXpath(firstName, lastName, true));
	}

	/**
	 * Extract the column values from the dataTable associated with the specified column elements via xpath.
	 */
	protected List<String> extractColumnValuesFromDataTable(BrowserDriver browserDriver, String columnElementsXpath) {

		// While the *Last Page* button is still active:
		List<String> columnValues = new ArrayList<String>();
		WebDriver webDriver = browserDriver.getWebDriver();
		ExpectedCondition<Boolean> navigationButtonClassDisabledCondition = textPresentInElementClass("disabled",
				"(" + PAGE_BUTTON_XPATH_PREFIX + "/li[last()])[1]");

		while (!navigationButtonClassDisabledCondition.apply(webDriver)) {

			// Extract the column values from the current page of the dataTable.
			List<WebElement> columnElements = browserDriver.findElementsByXpath(columnElementsXpath);

			for (WebElement columnElement : columnElements) {

				String columnValue = columnElement.getText();
				columnValues.add(columnValue);
			}

			// Click the *Next Page* button.
			Action clickNextPageAction = browserDriver.createClickElementAction(getNavigationButtonXpath("nextPage"));
			browserDriver.performAndWaitForRerender(clickNextPageAction, columnElementsXpath);
		}

		// Extract column values from the last page of the dataTable.
		List<WebElement> screenNameElements = browserDriver.findElementsByXpath(columnElementsXpath);

		for (WebElement screenNameElement : screenNameElements) {

			String screenName = screenNameElement.getText();
			columnValues.add(screenName);
		}

		return columnValues;
	}

	/**
	 * Extract the column values from the first page of dataTable associated with the specified column elements via
	 * xpath.
	 */
	protected List<String> extractColumnValuesFromDataTableFirstPage(BrowserDriver browserDriver,
		String columnElementsXpath) {

		// Extract column values from the first page of the dataTable.
		List<String> columnValues = new ArrayList<String>();

		List<WebElement> columnElements = browserDriver.findElementsByXpath(columnElementsXpath);

		for (WebElement columnElement : columnElements) {

			String columnValue = columnElement.getText();
			columnValues.add(columnValue);
		}

		return columnValues;
	}

	/**
	 * Extract the customers from each page of the dataTable associated with the specified column elements via xpath.
	 */
	protected LinkedList<Customer> extractCustomersFromDataTable(BrowserDriver browserDriver, String firstNameXpath,
		String lastNameXpath, String dateOfBirthXpath) {

		LinkedList<Customer> customers = new LinkedList<Customer>();

		// While the *Last Page* button is still active:
		WebDriver webDriver = browserDriver.getWebDriver();
		ExpectedCondition<Boolean> navigationButtonClassDisabledCondition = textPresentInElementClass("disabled",
				"(" + PAGE_BUTTON_XPATH_PREFIX + "/li[last()])[1]");

		Country country = new Country(0, "", "");
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");

		while (!navigationButtonClassDisabledCondition.apply(webDriver)) {

			// Extract the customers from the current page of the dataTable.
			List<WebElement> firstNameElements = browserDriver.findElementsByXpath(firstNameXpath);
			List<WebElement> lastNameElements = browserDriver.findElementsByXpath(lastNameXpath);
			List<WebElement> dateOfBirthElements = browserDriver.findElementsByXpath(dateOfBirthXpath);

			int i = 0;

			for (WebElement firstNameElement : firstNameElements) {

				WebElement lastNameElement = lastNameElements.get(i);
				WebElement dateOfBirthElement = dateOfBirthElements.get(i);

				String firstName = firstNameElement.getText();
				String lastName = lastNameElement.getText();
				String dateOfBirth = dateOfBirthElement.getText();
				Date date = new Date();

				try {
					date = dateFormat.parse(dateOfBirth);
				}
				catch (ParseException e) {
					throw new IllegalArgumentException(e);
				}

				Customer customer = new Customer(i, country, firstName, lastName, date);

				customers.add(customer);
				i++;
			}

			// Click the *Next Page* button.
			Action clickNextPageAction = browserDriver.createClickElementAction(getNavigationButtonXpath("nextPage"));
			browserDriver.performAndWaitForRerender(clickNextPageAction, firstNameXpath);
		}

		// Extract customers from the last page of the dataTable.
		List<WebElement> firstNameElements = browserDriver.findElementsByXpath(firstNameXpath);
		List<WebElement> lastNameElements = browserDriver.findElementsByXpath(lastNameXpath);
		List<WebElement> dateOfBirthElements = browserDriver.findElementsByXpath(dateOfBirthXpath);

		int i = 0;

		for (WebElement firstNameElement : firstNameElements) {

			WebElement lastNameElement = lastNameElements.get(i);
			WebElement dateOfBirthElement = dateOfBirthElements.get(i);

			String firstName = firstNameElement.getText();
			String lastName = lastNameElement.getText();
			String dateOfBirth = dateOfBirthElement.getText();
			Date date = new Date();

			try {
				date = dateFormat.parse(dateOfBirth);
			}
			catch (ParseException e) {
				throw new IllegalArgumentException(e);
			}

			Customer customer = new Customer(i, country, firstName, lastName, date);

			customers.add(customer);
			i++;
		}

		return customers;
	}

	protected LinkedList<String> getFirstPageFullNames(BrowserDriver browserDriver, String componentUseCase,
		String firstNamesXpath, String lastNamesXpath) {

		List<String> firstNames = extractColumnValuesFromDataTableFirstPage(browserDriver, firstNamesXpath);

		List<String> lastNames = extractColumnValuesFromDataTableFirstPage(browserDriver, lastNamesXpath);

		LinkedList<String> firstPageFullNames = new LinkedList<String>();

		for (int i = 0; i < firstNames.size(); i++) {
			String firstName = firstNames.get(i);
			String lastName = lastNames.get(i);

			firstPageFullNames.add(firstName + " " + lastName);
		}

		return firstPageFullNames;
	}

	protected String getPageButtonXpath(int buttonPageNumber) {
		return PAGE_BUTTON_XPATH_PREFIX + "//li/*[contains(.,'" + Integer.toString(buttonPageNumber) + "')]";
	}

	protected String getTableRowCustomersXpath(String firstName, String lastName) {
		return "//tbody/tr[contains(.,'" + firstName + "')][contains(.,'" + lastName +
			"')]//input[contains(@id,'customers:')]";
	}

	protected String getTableRowXpath(String firstName, String lastName) {
		return "//tbody/tr[contains(.,'" + firstName + "')][contains(.,'" + lastName + "')]";
	}

	protected String labelSelectOptionValueXpath(String labelText, String optionValue) {
		return "//label[contains(.,'" + labelText + "')]/following-sibling::select/option[@value='" + optionValue +
			"']";
	}

	/**
	 * Must build this action using keyDown(key) and keyUp(key) since Action sendKeys behaves differently than
	 * WebElement sendKeys (unless the browser is phantomjs, then it would need the following script).
	 * https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html#sendKeys-java.lang.CharSequence...-
	 */
	protected void metaOrCommandClick(BrowserDriver browserDriver, String xpath) {
		Keys metaOrCommandKey = Keys.META;

		if (System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("mac")) {
			metaOrCommandKey = Keys.COMMAND;
		}

		if ("phantomjs".equals(browserDriver.getBrowserName())) {
			browserDriver.executeScriptInCurrentWindow(
				"var element = arguments[0]; YUI().use('node-event-simulate', function(Y) { Y.one(element).simulate('click', { metaKey: true }); });",
				browserDriver.findElementByXpath(xpath));
		}
		else {
			Actions metaOrCommandClickBuilder = browserDriver.createActions();
			metaOrCommandClickBuilder.keyDown(metaOrCommandKey).click(browserDriver.findElementByXpath(xpath)).keyUp(
				metaOrCommandKey);

			Action metaOrCommandClick = metaOrCommandClickBuilder.build();
			metaOrCommandClick.perform();

			return;
		}
	}

	protected ExpectedCondition<Boolean> pageButtonClassActive(int pageButtonNumber) {

		String pageButtonXpath = PAGE_BUTTON_XPATH_PREFIX + "//*[contains(.,'" + Integer.toString(pageButtonNumber) +
			"')]/parent::li";

		return textPresentInElementClass("active", pageButtonXpath);
	}

	protected String removeBrackets(String string) {
		return string.replaceAll("^\\[", "").replaceAll("\\]$", "");
	}

	protected String serverEventInfoText(String rowSelectEvent, String rowIndex, String customer) {
		return "Received " + rowSelectEvent + " for rowIndex=[" + rowIndex + "] customer=[" + customer +
			"] in the APPLY_REQUEST_VALUES 2 phase.";
	}

	protected List<String> sortDateList(List<String> dateList, Boolean reverseOrder) {

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

	protected void testDataTableSelection(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String componentUseCase, LinkedList<String> fullNames) {

		// 1. Verify that the Selection mode defaults to 'checkbox'.
		waitingAsserter.assertElementDisplayed(labelSelectOptionValueXpath("Selection Mode", "checkbox"));

		// 2. Test and verify the first customer selected by checkbox.
		String[] oneCustomers = { fullNames.get(0) };
		verifyCustomersSelected(browserDriver, waitingAsserter, oneCustomers, componentUseCase);

		// 3. Test and verify the first and third customers selected by checkbox.
		String[] twoCustomers = { fullNames.get(0), fullNames.get(2) };
		verifyCustomersSelected(browserDriver, waitingAsserter, twoCustomers, componentUseCase);

		// 4. Test and verify all customers selected by checkbox.
		verifyCustomersSelected(browserDriver, waitingAsserter, fullNames.toArray(new String[fullNames.size()]),
			componentUseCase);

		// 5. Select and verify that 'radio' Selection Mode is selected.
		browserDriver.clickElement(labelSelectOptionValueXpath("Selection Mode", "radio"));
		waitingAsserter.assertElementDisplayed("//input[contains(@type,'radio')]");

		List<String> firstNames = extractColumnValuesFromDataTableFirstPage(browserDriver,
				FIRST_NAME_CELL_SELECTION_XPATH);

		List<String> lastNames = extractColumnValuesFromDataTableFirstPage(browserDriver,
				LAST_NAME_CELL_SELECTION_XPATH);

		waitingAsserter.assertElementDisplayed(getTableRowCustomersXpath(firstNames.get(0), lastNames.get(0)) +
			"/..//input[contains(@type,'radio')]");

		// 6. Test and verify the first customer selected by radio.
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, firstNames.get(0), lastNames.get(0));
		clickAndVerifyRowDeselection(browserDriver, waitingAsserter, firstNames.get(0), lastNames.get(0));
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, firstNames.get(0), lastNames.get(0));

		// 7. Test and verify that by selecting another customer, the previously selected customer is now deselected.
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, firstNames.get(2), lastNames.get(2));
		waitingAsserter.assertElementDisplayed(getRowXpath(firstNames.get(0), lastNames.get(0), false));
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, firstNames.get(0), lastNames.get(0));

		// 8. Verify UI state
		waitingAsserter.assertTextPresentInElementValue("0", "(//table/input)", false);

		// 9. Verify that selected customers appear in the feedback.
		verifyClickWaitAssertText(browserDriver, waitingAsserter, "//button[contains(.,'Feedback')]",
			ASSERT_SERVER_EVENT_INFO_TEXT_XPATH, fullNames.get(0));

		// 10. Verify that selected customers appear in the modal.
		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Modal Dialog')]");
		verifyClickWaitAssertText(browserDriver, waitingAsserter, "//button[contains(.,'Modal Dialog')]",
			modalDialogXpath + "//*[@class='alloy-output-text']", fullNames.get(0));

		browserDriver.centerElementInCurrentWindow(modalDialogXpath + "//button[contains(.,'Cancel')]");
		browserDriver.clickElement(modalDialogXpath + "//button[contains(.,'Cancel')]");
		browserDriver.waitForElementNotDisplayed(modalDialogXpath);

		// 11. Reset UI state
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);
	}

	/**
	 * Verify that at the moment of selecting or deselecting the customer that RowSelectEvent and RowDeselectEvent fire
	 * respectively, and this is used for either 'checkbox' or 'radio'.
	 *
	 * @param  rowIndex
	 * @param  customers
	 */
	protected void testDataTableServerEvents(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String rowIndex, String[] customers) {

		for (String customer : customers) {
			String[] tokens = customer.split(" ");

			String tableRowCustomersXpath = getTableRowCustomersXpath(tokens[0], tokens[1]);
			String serverEventInfoText = serverEventInfoText("RowSelectEvent", rowIndex, arrayToString(customers));
			verifyClickWaitAssertText(browserDriver, waitingAsserter, tableRowCustomersXpath,
				ASSERT_SERVER_EVENT_INFO_TEXT_XPATH, serverEventInfoText);

			if (browserDriver.findElementsByXpath("//input[contains(@type,'checkbox')]").isEmpty()) {

				metaOrCommandClick(browserDriver, tableRowCustomersXpath);
			}
			else {
				browserDriver.clickElement(tableRowCustomersXpath);
			}

			waitingAsserter.assertElementDisplayed(alloyMessageXpath(
					serverEventInfoText("RowDeselectEvent", rowIndex, arrayToString(customers))));
			verifyClickWaitAssertText(browserDriver, waitingAsserter, tableRowCustomersXpath,
				ASSERT_SERVER_EVENT_INFO_TEXT_XPATH, serverEventInfoText);
		}

		// Reset UI state
		navigateToUseCase(browserDriver, "dataTable", "server-events");
	}

	protected void testPagesPagination(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		Boolean dataTableSelection) {

		if (dataTableSelection.equals(true)) {
			FIRST_NAME_CELL_XPATH = "//tbody//td[2]//span[contains(@class,'alloy-output-text')]";
		}

		// 1. Take note of the first name of the first customer in the list on page 1.
		String firstCustomerFirstNameOnPageOne = browserDriver.findElementByXpath(FIRST_NAME_CELL_XPATH).getText();
		logger.debug("firstCustomerOnPageOne=[{}]", firstCustomerFirstNameOnPageOne);

		// 2. Click the *Next Page* button and verify that the page 2 button is highlighted.
		browserDriver.clickElement(getNavigationButtonXpath("nextPage"));
		waitingAsserter.assertTrue(pageButtonClassActive(2));

		// 3. Verify that the first name noted from page 1 is not present on page 2.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, FIRST_NAME_CELL_XPATH);

		// 4. Take note of the first name of the first customer in the list on page 2.
		String firstCustomerFirstNameOnPageTwo = browserDriver.findElementByXpath(FIRST_NAME_CELL_XPATH).getText();
		logger.debug("firstCustomerOnPageTwo=[{}]", firstCustomerFirstNameOnPageTwo);

		// 5. Click on *3* button and verify that the page 3 button is highlighted.
		browserDriver.clickElement(getPageButtonXpath(3));
		waitingAsserter.assertTrue(pageButtonClassActive(3));

		// 6. Verify that the first names noted from page 1 and 2 are not present on page 3.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, FIRST_NAME_CELL_XPATH);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageTwo, FIRST_NAME_CELL_XPATH);

		// 7. Take note of the first name of the first customer in the list on page 3.
		String firstCustomerFirstNameOnPageThree = browserDriver.findElementByXpath(FIRST_NAME_CELL_XPATH).getText();
		logger.debug("firstCustomerOnPageThree=[{}]", firstCustomerFirstNameOnPageThree);

		// 8. Click on *Previous Page* button and verify that the page 2 button is highlighted.
		browserDriver.clickElement(getNavigationButtonXpath("previousPage"));
		waitingAsserter.assertTrue(pageButtonClassActive(2));

		// 9. Verify that the first names noted from page 1 and 3 are not present on page 2.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, FIRST_NAME_CELL_XPATH);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageThree, FIRST_NAME_CELL_XPATH);

		// 10. Click on *Last Page* button and verify that the last button is highlighted and that the *Next Page* and
		// *Last Page* buttons are disabled.
		browserDriver.clickElement(getNavigationButtonXpath("lastPage"));
		waitingAsserter.assertTrue(pageButtonClassActive(17));
		waitingAsserter.assertTrue(textPresentInElementClass("disabled", PAGE_BUTTON_XPATH_PREFIX + "//li[last()]"));

		// 11. Verify that the first names noted from page 1, 2 and 3 are not present on the last page.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, FIRST_NAME_CELL_XPATH);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageTwo, FIRST_NAME_CELL_XPATH);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageThree, FIRST_NAME_CELL_XPATH);

		// 12. Take note of the first name of the first customer in the list on the last page.
		String firstCustomerFirstNameOnLastPage = browserDriver.findElementByXpath(FIRST_NAME_CELL_XPATH).getText();
		logger.debug("firstCustomerFirstNameOnLastPage[{}]", firstCustomerFirstNameOnLastPage);

		// 13. Click on *First Page* button and verify that the page 1 button is highlighted and the *First Page* and
		// *Previous Page* buttons are disabled.
		browserDriver.clickElement(getNavigationButtonXpath("firstPage"));
		waitingAsserter.assertTrue(pageButtonClassActive(1));
		waitingAsserter.assertTrue(textPresentInElementClass("disabled", PAGE_BUTTON_XPATH_PREFIX + "//li"));

		// 14. Verify that the first names noted from page 2, 3 and the last page are not present on the first page.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageTwo, FIRST_NAME_CELL_XPATH);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageThree, FIRST_NAME_CELL_XPATH);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnLastPage, FIRST_NAME_CELL_XPATH);
	}

	/**
	 * Verify that clicking on an element followed by waiting for another element to be visible that an element will
	 * contain some text.
	 *
	 * @param  clickXpath
	 * @param  assertElementXpath
	 * @param  containsText
	 */
	protected void verifyClickWaitAssertText(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String clickXpath, String assertElementXpath, String containsText) {
		browserDriver.centerElementInCurrentWindow(clickXpath);
		browserDriver.clickElement(clickXpath);
		waitingAsserter.assertTextPresentInElement(containsText, assertElementXpath);
	}

	/**
	 * Verify the customers selected for the dataTable Selection and Server Events testers.
	 *
	 * @param  customers
	 * @param  componentUseCase
	 */
	protected void verifyCustomersSelected(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String[] customers, String componentUseCase) {

		// Select the customers
		for (String customer : customers) {
			String[] tokens = customer.split(" ");
			browserDriver.centerElementInCurrentWindow(getTableRowCustomersXpath(tokens[0], tokens[1]));
			clickAndVerifyRowSelection(browserDriver, waitingAsserter, tokens[0], tokens[1]);
		}

		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Feedback')]");

		browserDriver.clickElement("//button[contains(.,'Feedback')]");
		browserDriver.waitForElementDisplayed(NOT_INFO_TEXT_XPATH);
		browserDriver.waitForElementDisplayed(alloyMessageXpath(arrayToString(customers)));

		// Assert proper feedback
		browserDriver.centerElementInCurrentWindow(alloyMessageXpath(arrayToString(customers)));

		for (int i = 0; i < customers.length; i++) {
			waitingAsserter.assertTextPresentInElement(customers[i], alloyMessageXpath(arrayToString(customers)));
		}

		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Modal Dialog')]");

		browserDriver.clickElement("//button[contains(.,'Modal Dialog')]");
		browserDriver.waitForTextPresentInElement(customers[0], modalDialogXpath);

		// Assert proper feedback
		browserDriver.centerElementInCurrentWindow(modalDialogXpath + "//button[contains(.,'Cancel')]");

		for (int i = 0; i < customers.length; i++) {
			waitingAsserter.assertTextPresentInElement(customers[i],
				"(" + modalDialogXpath + "//*[@class='alloy-output-text']" + ")[" + (i + 1) + "]");
		}

		browserDriver.clickElement(modalDialogXpath + "//button[contains(.,'Cancel')]");
		browserDriver.waitForElementNotDisplayed(modalDialogXpath);

		// Deselect the customers
		for (String customer : customers) {
			String[] tokens = customer.split(" ");
			browserDriver.centerElementInCurrentWindow(getTableRowCustomersXpath(tokens[0], tokens[1]));
			clickAndVerifyRowDeselection(browserDriver, waitingAsserter, tokens[0], tokens[1]);
		}

		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Feedback')]");
		browserDriver.clickElement("//button[contains(.,'Feedback')]");
		browserDriver.waitForElementDisplayed(alloyMessageXpath("No Customers Selected"));

		// Assert proper feedback
		waitingAsserter.assertElementDisplayed(alloyMessageXpath("No Customers Selected"));

		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Modal Dialog')]");
		browserDriver.clickElement("//button[contains(.,'Modal Dialog')]");
		browserDriver.waitForTextPresentInElement("No Customers Selected",
			modalDialogXpath + "//*[@class='alloy-output-text']");

		// Assert proper feedback
		waitingAsserter.assertTextPresentInElement("No Customers Selected",
			modalDialogXpath + "//*[@class='alloy-output-text']");

		// Reset UI state
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);
	}

	protected void verifyDataTableHeader(BrowserDriver browserDriver, WaitingAsserter waitingAsserter) {
		waitingAsserter.assertElementDisplayed(
			"(//div[contains(@class,'showcase-example-usage')])/table/thead/tr/th[@scope='colgroup'][contains(.,'Customers')]");
		waitingAsserter.assertElementDisplayed(FIRST_NAME_HEADER_XPATH);
		waitingAsserter.assertElementDisplayed(LAST_NAME_HEADER_XPATH);
		waitingAsserter.assertElementDisplayed(
			"(//div[contains(@class,'showcase-example-usage')])/table/thead/tr/th[@scope='col'][contains(.,'Date of Birth')]");
		waitingAsserter.assertElementDisplayed(
			"(//div[contains(@class,'showcase-example-usage')])/table/thead/tr/th[@scope='col'][contains(.,'Country')]");
	}

	protected void verifyDataTableSort(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String columnHeaderXpath, String columnElementsXpath, String componentUseCase) {
		verifyDataTableSort(browserDriver, waitingAsserter, columnHeaderXpath, columnElementsXpath, componentUseCase,
			false);
	}

	/**
	 * Verify the sorted order state after executing a column ordering feature of dataTable.
	 *
	 * @param  columnHeaderXpath
	 * @param  columnElementsXpath
	 * @param  componentUseCase
	 */
	protected void verifyDataTableSort(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
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
		waitingAsserter.assertElementDisplayed(SORTED_DESCENDING_ICON_XPATH);

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

	/**
	 * This will return a string representation of the contents of the specified array. it also implement
	 * removeBrackets.
	 */
	private String arrayToString(String[] stringArray) {
		return removeBrackets(Arrays.toString(stringArray));
	}

	private String getRowXpath(String firstName, String lastName, boolean selected) {

		String tr = "//table[contains(@id,':customers')]//tr[not(contains(@class,'info'))]";

		if (selected) {
			tr = "//table[contains(@id,':customers')]//tr[contains(@class,'info')]";
		}

		return tr + "[contains(.,'" + firstName + "')][contains(.,'" + lastName + "')]";
	}

}
