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
public class DataTablePaginationTester extends DataTableTester {

	@Test
	public void runDataTablePaginationTest() throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "dataTable", "pagination");

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPagesPagination(browserDriver, waitingAsserter, false);

		// Verify that the Summary Position of "Results..." is located at the bottom by default.
		waitingAsserter.assertElementDisplayed(labelSelectOptionValueXpath("Summary Position", "bottom") +
			"[@selected='selected']");

		String defaultPositionXpath = "(//*[@class='pagination'])[2]//span";
		String defaultResults = "Results 1-10 of 162 (Page 1 of 17)";
		waitingAsserter.assertTextPresentInElement(defaultResults, defaultPositionXpath);

		// Select and verify the Summary Position of "Results..." is 'top' and located at the top.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Summary Position", "top"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Summary Position", "top") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, "(//*[@class='pagination'])[1]//span");

		// Select and verify that the Summary Position of "Results..." is 'left' and located on the left.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Summary Position", "left"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Summary Position", "left") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, "//*[@class='pagination']//li[1]/span");

		// Select and verify that the Summary Position of "Results..." is 'right' and located on the right.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Summary Position", "right"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Summary Position", "right") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, "//*[@class='pagination']//li[last()]/span");

		// Select and verify that the Summary Position of "Results..." is 'none' and not visible.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Summary Position", "none"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Summary Position", "none") +
			"[@selected='selected']");
		waitingAsserter.assertElementNotDisplayed("//*[@class='pagination']//li//span[contains(.,'" + defaultResults +
			"]");

		// Select and verify that the Summary Position of "Results..." has returned to 'bottom' and is located at the
		// bottom.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Summary Position", "bottom"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Summary Position", "bottom") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, defaultPositionXpath);

		// Verify that there are 10 rows per page by default.
		waitingAsserter.assertElementDisplayed(labelSelectOptionValueXpath("Rows Per Page", "10") +
			"[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 10);

		// Select and verify 5 rows per page.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Rows Per Page", "5"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Rows Per Page", "5") +
			"[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 5);
		waitingAsserter.assertTextPresentInElement("Results 1-5 of 162 (Page 1 of 33)", defaultPositionXpath);

		// Select and verify 15 rows per page.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Rows Per Page", "15"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Rows Per Page", "15") +
			"[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 15);
		waitingAsserter.assertTextPresentInElement("Results 1-15 of 162 (Page 1 of 11)", defaultPositionXpath);

		// Select and verify 20 rows per page.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Rows Per Page", "20"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Rows Per Page", "20") +
			"[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 20);
		waitingAsserter.assertTextPresentInElement("Results 1-20 of 162 (Page 1 of 9)", defaultPositionXpath);

		// Select and verify 10 rows per page.
		clickOptionAndWaitForRerender(browserDriver, labelSelectOptionValueXpath("Rows Per Page", "10"));
		browserDriver.waitForElementDisplayed(labelSelectOptionValueXpath("Rows Per Page", "10") +
			"[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 10);
		waitingAsserter.assertTextPresentInElement(defaultResults, defaultPositionXpath);
	}
}
