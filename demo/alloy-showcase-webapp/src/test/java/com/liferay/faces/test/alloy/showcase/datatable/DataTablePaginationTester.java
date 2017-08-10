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
 * @author  Neil Griffin
 */
public class DataTablePaginationTester extends DataTableTesterBase {

	@Test
	public void runDataTablePaginationTest() throws Exception {

		// 1. Navigate to the "Pagination" use case in order to reset the state of the UI.
		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "pagination";
		navigateToUseCase(browserDriver, DATA_TABLE, componentUseCase);

		// 2. Verify that the paginator is working correctly by making sure that the first customer on page 1 is not
		// present on page 2, etc.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPaginator(browserDriver, waitingAsserter, componentUseCase);

		// 3. Verify that "Results..." is positioned at the bottom by default.
		waitingAsserter.assertElementDisplayed(getDropDownListXpath("Summary Position", "bottom") +
			"[@selected='selected']");

		String defaultPositionXpath = "(//*[@class='pagination'])[2]//span";
		String defaultResults = "Results 1-10 of " + TOTAL_CUSTOMERS + " (Page 1 of 17)";
		waitingAsserter.assertTextPresentInElement(defaultResults, defaultPositionXpath);

		// 4. Select "Top" from the *Summary Position* dropdown list and verify that "Results..." is positioned at the
		// top of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "top"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Summary Position", "top") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, "(//*[@class='pagination'])[1]//span");

		// 5. Select "Left" from the *Summary Position* dropdown list and verify that "Results..." is positioned at
		// the left of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "left"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Summary Position", "left") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, "//*[@class='pagination']//li[1]/span");

		// 6. Select "Right" from the *Summary Position* dropdown list and verify that "Results..." is positioned at the
		// right of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "right"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Summary Position", "right") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, "//*[@class='pagination']//li[last()]/span");

		// 7. Select "None" from the *Summary Position* dropdown list and verify that "Results..." is no longer
		// displayed near the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "none"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Summary Position", "none") +
			"[@selected='selected']");
		waitingAsserter.assertElementNotDisplayed("//*[@class='pagination']//li//span[contains(.,'" + defaultResults +
			"]");

		// 8. Select "Bottom" from the *Summary Position* dropdown list and verify that "Results..." is positioned at
		// the bottom of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "bottom"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Summary Position", "bottom") +
			"[@selected='selected']");
		waitingAsserter.assertTextPresentInElement(defaultResults, defaultPositionXpath);

		// Verify that there are 10 rows per page by default.
		waitingAsserter.assertElementDisplayed(getDropDownListXpath("Rows Per Page", "10") + "[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 10);

		// Select "5" from the *Rows Per Page* dropdown list and verify that only 5 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "5"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Rows Per Page", "5") + "[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 5);
		waitingAsserter.assertTextPresentInElement("Results 1-5 of " + TOTAL_CUSTOMERS + " (Page 1 of 33)",
			defaultPositionXpath);

		// Select "25" from the *Rows Per Page* dropdown list and verify that only 25 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "25"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Rows Per Page", "25") + "[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 25);
		waitingAsserter.assertTextPresentInElement("Results 1-25 of " + TOTAL_CUSTOMERS + " (Page 1 of 7)",
			defaultPositionXpath);

		// Select "50" from the *Rows Per Page* dropdown list and verify that only 50 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "50"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Rows Per Page", "50") + "[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 50);
		waitingAsserter.assertTextPresentInElement("Results 1-50 of " + TOTAL_CUSTOMERS + " (Page 1 of 4)",
			defaultPositionXpath);

		// Select "100" from the *Rows Per Page* dropdown list and verify that only 100 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "100"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Rows Per Page", "100") + "[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 100);
		waitingAsserter.assertTextPresentInElement("Results 1-100 of " + TOTAL_CUSTOMERS + " (Page 1 of 2)",
			defaultPositionXpath);

		// Select "10" from the *Rows Per Page* dropdown list and verify that only 10 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "10"));
		browserDriver.waitForElementDisplayed(getDropDownListXpath("Rows Per Page", "10") + "[@selected='selected']");
		assertListChildElementCount(browserDriver, "tbody", "tr", 10);
		waitingAsserter.assertTextPresentInElement(defaultResults, defaultPositionXpath);
	}
}
