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
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.faces.test.alloy.showcase.data.DataTesterBase;
import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 * @author  Neil Griffin
 */
public class DataTableTesterBase extends DataTesterBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(DataTableTesterBase.class);

	// Protected Constants
	protected static final String DATA_TABLE = "dataTable";
	protected static final String DATE_OF_BIRTH_HEADER_XPATH =
		"//table/thead/tr/th[@scope='col'][contains(.,'Date of Birth')]";
	protected static final String LAST_NAME_HEADER_XPATH = "//table/thead/tr/th[@scope='col'][contains(.,'Last Name')]";
	protected static final String SERVER_EVENT_INFO_TEXT_XPATH =
		"//table[contains(@class,'alloy-messages')]/tbody/tr/td";
	protected static final String SORTED_ASCENDING_ICON_XPATH =
		"//th[contains(@class,'table-sortable-column table-sorted')][not(contains(@class,'table-sorted-desc'))]//span[contains(@class,'table-sort-indicator')]";
	protected static final int TOTAL_CUSTOMERS = 162;

	// Private Constants
	private static final String PAGE_BUTTON_XPATH_PREFIX =
		"//div[contains(@class,'alloy-paginator')]//ul[contains(@class,'pagination')]";

	// Note: SimpleDateFormat is not thread-safe but Selenium testing is single-threaded.
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMM dd, yyyy");

	/**
	 * Clicks on the specified element and verifies that the specified text is present in the element targeted by the
	 * specified xpath.
	 */
	protected void clickElementAndVerifyTextIsPresent(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String clickXpath, String assertElementXpath, String containsText) {
		browserDriver.centerElementInCurrentWindow(clickXpath);
		browserDriver.clickElement(clickXpath);
		waitingAsserter.assertTextPresentInElement(containsText, assertElementXpath);
	}

	/**
	 * Returns a complete list of customers by iterating through each of the numbered <code>alloy:dataTable</code> pages
	 * of tabular data markup.
	 */
	protected List<Customer> extractCustomersFromAllPages(BrowserDriver browserDriver, String componentUseCase)
		throws ParseException {

		List<Customer> extractedCustomers = new ArrayList<Customer>();

		// While the *Last Page* button is still active:
		WebDriver webDriver = browserDriver.getWebDriver();
		ExpectedCondition<Boolean> navigationButtonClassDisabledCondition = isTextPresentInElementClassAttribute(
				"disabled", "(" + PAGE_BUTTON_XPATH_PREFIX + "/li[last()])[1]");

		while (!navigationButtonClassDisabledCondition.apply(webDriver)) {

			// Extract the customers from the current page of the table.
			extractedCustomers.addAll(extractCustomersFromCurrentPage(browserDriver, componentUseCase));

			// Click the *Next Page* button.
			Action clickNextPageAction = browserDriver.createClickElementAction(getPaginatorButtonXpath("nextPage"));
			browserDriver.performAndWaitForRerender(clickNextPageAction, getFirstNameCellXpath(componentUseCase));
		}

		// Extract customers from the last page of the table.
		extractedCustomers.addAll(extractCustomersFromCurrentPage(browserDriver, componentUseCase));

		return extractedCustomers;
	}

	/**
	 * Returns list of customers from the currently rendered <code>alloy:dataTable</code> page of tabular data markup.
	 */
	protected List<Customer> extractCustomersFromCurrentPage(BrowserDriver browserDriver, String componentUseCase)
		throws ParseException {

		List<Customer> extractedCustomers = new ArrayList<Customer>();
		List<WebElement> firstNameElements = browserDriver.findElementsByXpath(getFirstNameCellXpath(componentUseCase));
		List<WebElement> lastNameElements = browserDriver.findElementsByXpath(getLastNameCellXpath(componentUseCase));
		List<WebElement> dateOfBirthElements = browserDriver.findElementsByXpath(getDateOfBirthCellXpath(
					componentUseCase));

		for (int i = 0; i < firstNameElements.size(); i++) {

			WebElement firstNameElement = firstNameElements.get(i);
			WebElement lastNameElement = lastNameElements.get(i);
			WebElement dateOfBirthElement = dateOfBirthElements.get(i);
			Date dateOfBirth = DATE_FORMAT.parse(dateOfBirthElement.getText());
			Customer customer = new Customer(firstNameElement.getText(), lastNameElement.getText(), dateOfBirth);
			extractedCustomers.add(customer);
		}

		return extractedCustomers;
	}

	/**
	 * Returns the xpath expression that targets the rendered <code>alloy:messages</code> component markup that displays
	 * the specified message.
	 */
	protected String getAlloyMessageXpath(String message) {

		StringBuilder alloyMessageXpath = new StringBuilder();
		alloyMessageXpath.append("(//table[contains(@class,'alloy-messages')]/tbody/tr/td[contains(.,'");
		alloyMessageXpath.append(message);
		alloyMessageXpath.append("')])");

		return alloyMessageXpath.toString();
	}

	/**
	 * Returns the xpath expression that targets the rendered <code>alloy:messages</code> component markup that displays
	 * a comma-delimited list of full names for the specified customers.
	 */
	protected String getAlloyMessageXpath(Customer[] customers) {

		StringBuilder message = new StringBuilder();

		boolean firstCustomer = true;

		for (Customer customer : customers) {

			if (firstCustomer) {
				firstCustomer = false;
			}
			else {
				message.append(", ");
			}

			message.append(customer.toString());
		}

		return getAlloyMessageXpath(message.toString());
	}

	/**
	 * Returns the xpath expression that targets all of the &lt;span&gt; elements found in the cells of the "Date of
	 * Birth" table column.
	 */
	protected String getDateOfBirthCellXpath(String componentUseCase) {

		if (componentUseCase.equals("selection") || componentUseCase.equals("server-events")) {
			return "//tbody//td[4]//span[contains(@class,'alloy-output-text')]";
		}
		else {
			return "//tbody//td[3]//span[contains(@class,'alloy-output-text')]";
		}
	}

	/**
	 * Returns the xpath expression that targets the dropdown list associated with the specified label and option value.
	 */
	protected String getDropDownListXpath(String labelText, String optionValue) {
		return "//label[contains(.,'" + labelText + "')]/following-sibling::select/option[@value='" + optionValue +
			"']";
	}

	/**
	 * Returns the xpath expression that targets all of the &lt;span&gt; elements found in the cells of the "First Name"
	 * table column.
	 */
	protected String getFirstNameCellXpath(String componentUseCase) {

		if (componentUseCase.equals("selection") || componentUseCase.equals("server-events")) {
			return "//tbody//td[2]//span[contains(@class,'alloy-output-text')]";
		}
		else {
			return "//tbody//td[1]//span[contains(@class,'alloy-output-text')]";
		}
	}

	/**
	 * Returns the xpath expression that targets all of the &lt;span&gt; elements found in the cells of the "Last Name"
	 * table column.
	 */
	protected String getLastNameCellXpath(String componentUseCase) {

		if (componentUseCase.equals("selection") || componentUseCase.equals("server-events")) {
			return "//tbody//td[3]//span[contains(@class,'alloy-output-text')]";
		}
		else {
			return "//tbody//td[2]//span[contains(@class,'alloy-output-text')]";
		}
	}

	/**
	 * Returns the xpath expression that targets the button associated with the specified label within the <code>
	 * alloy:paginator</code>.
	 */
	protected String getPaginatorButtonXpath(String buttonLabel) {
		return
			"//div[contains(@class,'alloy-paginator')]//ul[contains(@class,'pagination')]//li//*[contains(@onclick,'" +
			buttonLabel + "')]";
	}

	/**
	 * Returns the xpath expression that targets the checkbox or radio button associated with the specified customer.
	 */
	protected String getRowSelectionInputXpath(Customer customer) {
		return "//tbody/tr[contains(.,'" + customer.getFirstName() + "')][contains(.,'" + customer.getLastName() +
			"')]//input[contains(@id,'customers:')]";
	}

	/**
	 * Determines whether or not the specified page number is active in the rendered <code>alloy:paginator</code>
	 * markup.
	 */
	protected ExpectedCondition<Boolean> isPaginatorPageNumberButtonActive(int pageButtonNumber) {

		String pageButtonXpath = PAGE_BUTTON_XPATH_PREFIX + "//*[contains(.,'" + Integer.toString(pageButtonNumber) +
			"')]/parent::li";

		return isTextPresentInElementClassAttribute("active", pageButtonXpath);
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
		}
	}

	/**
	 * Tests the row selection features of the <code>alloy:dataTable</code> by verifying that rows are
	 * selected/deselected when clicking on the corresponding checkbox or radio button.
	 */
	protected void testDataTableSelection(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String componentUseCase, List<Customer> customers) {

		// 1. Verify that the *Selection Mode* dropdown list displays "checkbox".
		waitingAsserter.assertElementDisplayed(getDropDownListXpath("Selection Mode", "checkbox"));

		// 2. Click on the checkbox next to the first customer and verify that both the feedback message and modal popup
		// indicate that the first customer is selected. Click again on the checkbox next to the first customer and
		// verify that both the feedback message and modal popup indicate that there are no customers selected.
		Customer firstCustomer = customers.get(0);
		selectCustomersAndVerifySelection(browserDriver, waitingAsserter, componentUseCase, firstCustomer);

		// 2. Click on the checkbox next to the first and second customers and verify that both the feedback message and
		// modal popup indicate that the first two customers are selected. Click again on the checkbox next to the first
		// and second customers and and verify that both the feedback message and modal popup indicate that there are no
		// customers selected.
		Customer secondCustomer = customers.get(1);
		selectCustomersAndVerifySelection(browserDriver, waitingAsserter, componentUseCase, firstCustomer,
			secondCustomer);

		// 3. Click on the checkbox next to each of the 10 displayed customers and verify that both the feedback message
		// and modal popup indicate that the 10 customers are selected. Click again on the checkbox next to each of the
		// 10 displayed customers and and verify that both the feedback message and modal popup indicate that there are
		// no customers selected.
		selectCustomersAndVerifySelection(browserDriver, waitingAsserter, componentUseCase,
			customers.toArray(new Customer[customers.size()]));

		// 4. Click on "radio" in the *Selection Mode* dropdown list and verify that the checkboxes are no longer
		// displayed, and that radio buttons are displayed instead.
		browserDriver.clickElement(getDropDownListXpath("Selection Mode", "radio"));
		waitingAsserter.assertElementDisplayed("//input[contains(@type,'radio')]");
		waitingAsserter.assertElementDisplayed(getRowSelectionInputXpath(firstCustomer) +
			"/..//input[contains(@type,'radio')]");

		// 6. Verify that the first customer can be selected and deselected via the radio button in the corresponding
		// row.
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, firstCustomer);
		clickAndVerifyRowDeselection(browserDriver, waitingAsserter, firstCustomer);
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, firstCustomer);

		// 7. Verify that by selecting another customer, that the previously selected customer becomes deselected.
		Customer thirdCustomer = customers.get(2);
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, thirdCustomer);
		waitingAsserter.assertElementDisplayed(getUnselectedRowXpath(firstCustomer));
		clickAndVerifyRowSelection(browserDriver, waitingAsserter, firstCustomer);

		// 8. Verify that the "selectedRowIndexes" hidden field contains "0", indicating that the first customer
		// has been selected.
		waitingAsserter.assertTextPresentInElementValue("0", "(//table/input)", false);

		// 9. Verify that the full name of the first customer is present in the feedback message.
		clickElementAndVerifyTextIsPresent(browserDriver, waitingAsserter, "//button[contains(.,'Feedback')]",
			SERVER_EVENT_INFO_TEXT_XPATH, firstCustomer.toString());

		// 10. Verify that the full name of the first customer is present in the modal dialog.
		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Modal Dialog')]");
		clickElementAndVerifyTextIsPresent(browserDriver, waitingAsserter, "//button[contains(.,'Modal Dialog')]",
			MODAL_DIALOG_XPATH + "//*[@class='alloy-output-text']", firstCustomer.toString());
		browserDriver.centerElementInCurrentWindow(MODAL_DIALOG_XPATH + "//button[contains(.,'Cancel')]");
		browserDriver.clickElement(MODAL_DIALOG_XPATH + "//button[contains(.,'Cancel')]");
		browserDriver.waitForElementNotDisplayed(MODAL_DIALOG_XPATH);

		// 11. Navigate to the specified use-case in order to reset the state of the UI.
		navigateToUseCase(browserDriver, DATA_TABLE, componentUseCase);
	}

	/**
	 * Tests the functionality of the <code>alloy:paginator</code> by verifying that the tabular data is paginated
	 * according to expected behavior of the pagination buttons.
	 */
	protected void testPaginator(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String componentUseCase) {

		String firstNameCellXpath = getFirstNameCellXpath(componentUseCase);

		// 1. Take note of the first name of the first customer in the list on page 1.
		String firstCustomerFirstNameOnPageOne = browserDriver.findElementByXpath(firstNameCellXpath).getText();
		logger.debug("firstCustomerOnPageOne=[{}]", firstCustomerFirstNameOnPageOne);

		// 2. Click the *Next Page* button and verify that the page 2 button is highlighted.
		browserDriver.clickElement(getPaginatorButtonXpath("nextPage"));
		waitingAsserter.assertTrue(isPaginatorPageNumberButtonActive(2));

		// 3. Verify that the first name noted from page 1 is not present on page 2.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, firstNameCellXpath);

		// 4. Take note of the first name of the first customer in the list on page 2.
		String firstCustomerFirstNameOnPageTwo = browserDriver.findElementByXpath(firstNameCellXpath).getText();
		logger.debug("firstCustomerOnPageTwo=[{}]", firstCustomerFirstNameOnPageTwo);

		// 5. Click on *3* button and verify that the page 3 button is highlighted.
		browserDriver.clickElement(getPageButtonXpath(3));
		waitingAsserter.assertTrue(isPaginatorPageNumberButtonActive(3));

		// 6. Verify that the first names noted from page 1 and 2 are not present on page 3.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, firstNameCellXpath);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageTwo, firstNameCellXpath);

		// 7. Take note of the first name of the first customer in the list on page 3.
		String firstCustomerFirstNameOnPageThree = browserDriver.findElementByXpath(firstNameCellXpath).getText();
		logger.debug("firstCustomerOnPageThree=[{}]", firstCustomerFirstNameOnPageThree);

		// 8. Click on *Previous Page* button and verify that the page 2 button is highlighted.
		browserDriver.clickElement(getPaginatorButtonXpath("previousPage"));
		waitingAsserter.assertTrue(isPaginatorPageNumberButtonActive(2));

		// 9. Verify that the first names noted from page 1 and 3 are not present on page 2.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, firstNameCellXpath);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageThree, firstNameCellXpath);

		// 10. Click on *Last Page* button and verify that the last button is highlighted and that the *Next Page* and
		// *Last Page* buttons are disabled.
		browserDriver.clickElement(getPaginatorButtonXpath("lastPage"));
		waitingAsserter.assertTrue(isPaginatorPageNumberButtonActive(17));
		waitingAsserter.assertTrue(isTextPresentInElementClassAttribute("disabled",
				PAGE_BUTTON_XPATH_PREFIX + "//li[last()]"));

		// 11. Verify that the first names noted from page 1, 2 and 3 are not present on the last page.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageOne, firstNameCellXpath);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageTwo, firstNameCellXpath);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageThree, firstNameCellXpath);

		// 12. Take note of the first name of the first customer in the list on the last page.
		String firstCustomerFirstNameOnLastPage = browserDriver.findElementByXpath(firstNameCellXpath).getText();
		logger.debug("firstCustomerFirstNameOnLastPage[{}]", firstCustomerFirstNameOnLastPage);

		// 13. Click on *First Page* button and verify that the page 1 button is highlighted and the *First Page* and
		// *Previous Page* buttons are disabled.
		browserDriver.clickElement(getPaginatorButtonXpath("firstPage"));
		waitingAsserter.assertTrue(isPaginatorPageNumberButtonActive(1));
		waitingAsserter.assertTrue(isTextPresentInElementClassAttribute("disabled", PAGE_BUTTON_XPATH_PREFIX + "//li"));

		// 14. Verify that the first names noted from page 2, 3 and the last page are not present on the first page.
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageTwo, firstNameCellXpath);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnPageThree, firstNameCellXpath);
		waitingAsserter.assertTextNotPresentInElement(firstCustomerFirstNameOnLastPage, firstNameCellXpath);
	}

	private void clickAndVerifyRowDeselection(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		Customer customer) {

		// Note: For radio button deselection, the meta or command button must be held down before clicking.
		if (browserDriver.findElementsByXpath("//input[contains(@type,'checkbox')]").isEmpty()) {
			metaOrCommandClick(browserDriver, getRowSelectionInputXpath(customer));
		}
		else {
			browserDriver.clickElement(getRowSelectionInputXpath(customer));
		}

		waitingAsserter.assertElementDisplayed(getUnselectedRowXpath(customer));
	}

	/**
	 * Selects the table row associated with the specified customer by clicking on the corresponding checkbox or radio
	 * button. It also verifies
	 */
	private void clickAndVerifyRowSelection(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		Customer customer) {

		browserDriver.centerElementInCurrentWindow(getRowSelectionInputXpath(customer));
		browserDriver.clickElement(getRowSelectionInputXpath(customer));
		waitingAsserter.assertElementDisplayed(getSelectedRowXpath(customer));
	}

	/**
	 * Returns the xpath expression that targets the page number button inside the rendered markup of the <code>
	 * alloy:paginator</code> component.
	 */
	private String getPageButtonXpath(int buttonPageNumber) {
		return PAGE_BUTTON_XPATH_PREFIX + "//li/*[contains(.,'" + buttonPageNumber + "')]";
	}

	/**
	 * Returns the xpath expression that targets the selected table row associated with the specified customer
	 */
	private String getSelectedRowXpath(Customer customer) {

		// Note: The table row is considered to be selected when the class attribute of the <tr> element contains
		// "info".
		return "//table[contains(@id,':customers')]//tr[contains(@class,'info')][contains(.,'" +
			customer.getFirstName() + "')][contains(.,'" + customer.getLastName() + "')]";
	}

	/**
	 * Returns the xpath expression that targets the NON-selected table row associated with the specified customer.
	 */
	private String getUnselectedRowXpath(Customer customer) {

		// Note: The table row is considered to be NON-selected when the class attribute of the <tr> element does not
		// contain "info".
		return "//table[contains(@id,':customers')]//tr[not(contains(@class,'info'))][contains(.,'" +
			customer.getFirstName() + "')][contains(.,'" + customer.getLastName() + "')]";
	}

	/**
	 * Determines whether or not the specified text is present in the class attribute of the element targeted by the
	 * specified xpath expression.
	 */
	private ExpectedCondition<Boolean> isTextPresentInElementClassAttribute(String text, String elementXpath) {

		By locator = By.xpath(elementXpath);
		ExpectedCondition<WebElement> elementDisplayed = ExpectedConditions.visibilityOfElementLocated(locator);
		ExpectedCondition<Boolean> textPresentInElementClass = ExpectedConditions.attributeContains(locator, "class",
				text);

		return ExpectedConditions.and(elementDisplayed, textPresentInElementClass);
	}

	/**
	 * Selects the specified customer(s) by clicking on the corresponding checkbox or radio button and verifies that the
	 * row is selected by checking for the customer name(s) are found in the feedback message and modal dialog.
	 */
	private void selectCustomersAndVerifySelection(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String componentUseCase, Customer... customers) {

		// 1. Click on the checkbox next to each of the specified customers so that a check mark APPEARS in each of the
		// checkboxes.
		for (Customer customer : customers) {
			browserDriver.centerElementInCurrentWindow(getRowSelectionInputXpath(customer));
			clickAndVerifyRowSelection(browserDriver, waitingAsserter, customer);
		}

		// 2. Click on the *Show Selected Customers as Feedback* button.
		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Feedback')]");
		browserDriver.clickElement("//button[contains(.,'Feedback')]");
		browserDriver.waitForElementDisplayed(getAlloyMessageXpath(customers));

		// 3. Verify that each of the specified customers is displayed in the feedback message.
		browserDriver.centerElementInCurrentWindow(getAlloyMessageXpath(customers));

		for (Customer customer : customers) {
			waitingAsserter.assertTextPresentInElement(customer.toString(), getAlloyMessageXpath(customers));
		}

		// 4. Click on the *Show Selected Customers in Modal Dialog* button.
		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Modal Dialog')]");
		browserDriver.clickElement("//button[contains(.,'Modal Dialog')]");
		browserDriver.waitForTextPresentInElement(customers[0].toString(), MODAL_DIALOG_XPATH);

		// 5. Verify that each of the specified customers appears in the modal popup.
		browserDriver.centerElementInCurrentWindow(MODAL_DIALOG_XPATH + "//button[contains(.,'Cancel')]");

		for (int i = 0; i < customers.length; i++) {
			waitingAsserter.assertTextPresentInElement(customers[i].toString(),
				"(" + MODAL_DIALOG_XPATH + "//*[@class='alloy-output-text']" + ")[" + (i + 1) + "]");
		}

		browserDriver.clickElement(MODAL_DIALOG_XPATH + "//button[contains(.,'Cancel')]");
		browserDriver.waitForElementNotDisplayed(MODAL_DIALOG_XPATH);

		// 6. Click on the checkbox next to each of the specified customers so that a check mark DISAPPEARS from each of
		// the checkboxes.
		for (Customer customer : customers) {
			browserDriver.centerElementInCurrentWindow(getRowSelectionInputXpath(customer));
			clickAndVerifyRowDeselection(browserDriver, waitingAsserter, customer);
		}

		// 7. Click on the *Show Selected Customers as Feedback* button.
		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Feedback')]");
		browserDriver.clickElement("//button[contains(.,'Feedback')]");
		browserDriver.waitForElementDisplayed(getAlloyMessageXpath("No Customers Selected"));

		// 8. Verify that "No Customers Selected" is displayed in the feedback message.
		waitingAsserter.assertElementDisplayed(getAlloyMessageXpath("No Customers Selected"));

		// 9. Click on the *Show Selected Customers in Modal Dialog* button.
		browserDriver.centerElementInCurrentWindow("//button[contains(.,'Modal Dialog')]");
		browserDriver.clickElement("//button[contains(.,'Modal Dialog')]");
		browserDriver.waitForTextPresentInElement("No Customers Selected",
			MODAL_DIALOG_XPATH + "//*[@class='alloy-output-text']");

		// 10. Verify that "No Customers Selected" is displayed in the modal popup.
		waitingAsserter.assertTextPresentInElement("No Customers Selected",
			MODAL_DIALOG_XPATH + "//*[@class='alloy-output-text']");

		// 11. Navigate to the specified use-case in order to reset the state of the UI.
		navigateToUseCase(browserDriver, DATA_TABLE, componentUseCase);
	}
}
