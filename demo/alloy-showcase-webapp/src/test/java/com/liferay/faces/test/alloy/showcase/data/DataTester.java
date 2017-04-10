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
package com.liferay.faces.test.alloy.showcase.data;

import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.showcase.TesterBase;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class DataTester extends TesterBase {

	// Common Xpath
	protected static final String modalDialogXpath = "(//div[contains(@class,'yui3-widget-modal')])[1]";

	protected final void assertListChildElementCount(BrowserDriver browserDriver, String listType, String listItemTag,
		int expecteds) {
		String listItemXpath = "(//div[@class='showcase-example']//" + listType + "//" + listItemTag + ")";

		List<WebElement> elements = browserDriver.findElementsByXpath(listItemXpath);
		Assert.assertNotNull("Element " + listItemXpath + " is not present in the DOM.", elements);

		int elementsSize = elements.size();
		Assert.assertEquals("Element " + listItemXpath + " does not equal \"" + expecteds + "\". Instead it equals \"" +
			elementsSize + "\".", expecteds, elementsSize);
	}

	protected String getNavigationButtonXpath(String buttonOnClickText) {
		return
			"//div[contains(@class,'alloy-paginator')]//ul[contains(@class,'pagination')]//li//*[contains(@onclick,'" +
			buttonOnClickText + "')]";
	}

	protected ExpectedCondition<Boolean> textPresentInElementClass(String text, String elementXpath) {

		By locator = By.xpath(elementXpath);
		ExpectedCondition<WebElement> elementDisplayed = ExpectedConditions.visibilityOfElementLocated(locator);
		ExpectedCondition<Boolean> textPresentInElementClass = ExpectedConditions.attributeContains(locator, "class",
				text);

		return ExpectedConditions.and(elementDisplayed, textPresentInElementClass);
	}
}
