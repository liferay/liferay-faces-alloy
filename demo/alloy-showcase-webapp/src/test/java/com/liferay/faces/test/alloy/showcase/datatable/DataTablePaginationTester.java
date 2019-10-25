/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
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

		// 1. Navigate to the alloy:dataTable "Pagination" use case.
		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "pagination";
		navigateToUseCase(browserDriver, componentUseCase);

		// 2. Verify that the paginator is working correctly by making sure that the first customer on page 1 is not
		// present on page 2, etc.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPaginator(browserDriver, waitingAsserter, componentUseCase);

		// 3. Verify that "Results..." is positioned at the bottom by default.
		waitingAsserter.assertElementDisplayed(getDropDownListXpath("Summary Position", "bottom") +
			"[@selected='selected']");

		String summaryPositionBottomXpath = "(//thead//*[@class='pagination'])[2]";
		String defaultSummaryPositionXpath = summaryPositionBottomXpath;
		String defaultSummaryText = getExpectedSummaryText(10);
		waitingAsserter.assertTextPresentInElement(getExpectedSummaryText(10), defaultSummaryPositionXpath);

		// 4. Select "Top" from the *Summary Position* dropdown list and verify that "Results..." is positioned at the
		// top of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "top"));
		waitingAsserter.assertTextNotPresentInElement(defaultSummaryText, summaryPositionBottomXpath);
		waitingAsserter.assertTextPresentInElement(defaultSummaryText, "(//thead//*[@class='pagination'])[1]");

		// 5. Select "Left" from the *Summary Position* dropdown list and verify that "Results..." is positioned at
		// the left of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "left"));
		waitingAsserter.assertElementNotDisplayed(summaryPositionBottomXpath);
		waitingAsserter.assertTextPresentInElement(defaultSummaryText, "(//thead//*[@class='pagination'])[1]//li[1]");

		// 6. Select "Right" from the *Summary Position* dropdown list and verify that "Results..." is positioned at the
		// right of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "right"));
		waitingAsserter.assertElementNotDisplayed(summaryPositionBottomXpath);
		waitingAsserter.assertTextPresentInElement(defaultSummaryText,
			"(//thead//*[@class='pagination'])[1]//li[last()]");

		// 7. Select "None" from the *Summary Position* dropdown list and verify that "Results..." is no longer
		// displayed near the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "none"));
		waitingAsserter.assertTextNotPresentInElement(defaultSummaryText, "//thead//*[@class='pagination']");

		// 8. Select "Bottom" from the *Summary Position* dropdown list and verify that "Results..." is positioned at
		// the bottom of the paginator.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Summary Position", "bottom"));
		waitingAsserter.assertTextPresentInElement(defaultSummaryText, defaultSummaryPositionXpath);

		// Verify that there are 10 rows per page by default.
		waitingAsserter.assertElementDisplayed(getDropDownListXpath("Rows Per Page", "10") + "[@selected='selected']");
		assertChildElementCount(browserDriver, "tbody", "tr", 10);

		// Select "5" from the *Rows Per Page* dropdown list and verify that only 5 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "5"));
		assertChildElementCount(browserDriver, "tbody", "tr", 5);
		waitingAsserter.assertTextPresentInElement(getExpectedSummaryText(5), defaultSummaryPositionXpath);

		// Select "25" from the *Rows Per Page* dropdown list and verify that only 25 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "25"));
		assertChildElementCount(browserDriver, "tbody", "tr", 25);
		waitingAsserter.assertTextPresentInElement(getExpectedSummaryText(25), defaultSummaryPositionXpath);

		// Select "50" from the *Rows Per Page* dropdown list and verify that only 50 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "50"));
		assertChildElementCount(browserDriver, "tbody", "tr", 50);
		waitingAsserter.assertTextPresentInElement(getExpectedSummaryText(50), defaultSummaryPositionXpath);

		// Select "100" from the *Rows Per Page* dropdown list and verify that only 100 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "100"));
		assertChildElementCount(browserDriver, "tbody", "tr", 100);
		waitingAsserter.assertTextPresentInElement(getExpectedSummaryText(100), defaultSummaryPositionXpath);

		// Select "10" from the *Rows Per Page* dropdown list and verify that only 10 rows are displayed.
		clickOptionAndWaitForRerender(browserDriver, getDropDownListXpath("Rows Per Page", "10"));
		assertChildElementCount(browserDriver, "tbody", "tr", 10);
		waitingAsserter.assertTextPresentInElement(defaultSummaryText, defaultSummaryPositionXpath);
	}

	private String getExpectedSummaryText(int rowsPerPage) {
		return "Results 1-" + rowsPerPage + " of " + TOTAL_CUSTOMERS + " (Page 1 of " + getTotalPages(rowsPerPage) +
			")";
	}
}
