/**
 * Copyright (c) 2000-2022 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.test.alloy.showcase.data;

import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.showcase.TesterBase;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTesterBase extends TesterBase {

	// Protected Constants
	protected static final String MODAL_DIALOG_XPATH = "(//div[contains(@class,'yui3-widget-modal')])[1]";

	protected void assertChildElementCount(BrowserDriver browserDriver, String parentTagName, String childTagName,
		int expectedCount) {

		String listItemXpath = "(//div[@class='showcase-example']//" + parentTagName + "//" + childTagName + ")";

		List<WebElement> elements = browserDriver.findElementsByXpath(listItemXpath);
		Assert.assertNotNull("Element " + listItemXpath + " is not present in the DOM.", elements);

		int elementsSize = elements.size();
		Assert.assertEquals("Element " + listItemXpath + " does not equal \"" + expectedCount +
			"\". Instead it equals \"" + elementsSize + "\".", expectedCount, elementsSize);
	}
}
