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

import java.util.LinkedList;

import org.junit.Test;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTableSelectionTester extends DataTableTester {

	@Test
	public void runDataTableSelectionTest() throws Exception {
		BrowserDriver browserDriver = getBrowserDriver();
		String componentUseCase = "selection";
		navigateToUseCase(browserDriver, "dataTable", componentUseCase);

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		testPagesPagination(browserDriver, waitingAsserter, true);

		LinkedList<String> firstPageFullNames = getFirstPageFullNames(browserDriver, componentUseCase,
				FIRST_NAME_CELL_SELECTION_XPATH, LAST_NAME_CELL_SELECTION_XPATH);
		testDataTableSelection(browserDriver, waitingAsserter, componentUseCase, firstPageFullNames);
	}
}
