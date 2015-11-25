/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.test.showcase.inputtext;

import org.junit.Test;

import org.openqa.selenium.WebElement;

import com.liferay.faces.test.showcase.Browser;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class InputTextConversionTester extends InputTextTester {

	@Test
	public void runInputTextConversionTest() throws Exception {

		Browser browser = Browser.getInstance();
		browser.navigateToURL(inputTextURL + "conversion");

		// Wait to begin the test until the submit button is rendered.
		browser.waitForElement(submitButtonXpath);

		// Test that the web page shows an error message when an invalid value is submitted.
		WebElement input = browser.getElement(inputXpath);
		input.clear();

		String invalidText = "apr 3 33";
		input.sendKeys(invalidText);
		browser.click(submitButtonXpath);
		browser.waitForElement(errorXpath);
		browser.assertElementExists(errorXpath);

		// Test that a valid value submits successfully.
		input = browser.getElement(inputXpath);
		input.clear();

		String text = "apr 3, 33";
		input.sendKeys(text);
		browser.click(submitButtonXpath);

		String textOutput = "Apr 3, 0033";
		browser.waitForElementText(modelValueXpath, textOutput);
		browser.assertElementTextExists(modelValueXpath, textOutput);

		// Test that the web page shows an error message when an invalid value is submitted.
		input = browser.getElement(inputXpathRight);
		input.clear();
		invalidText = "4/333";
		input.sendKeys(invalidText);
		browser.click(submitButtonXpathRight);
		browser.waitForElement(errorXpath);
		browser.assertElementExists(errorXpath);

		// Test that a valid value submits successfully.
		input = browser.getElement(inputXpathRight);
		input.clear();
		text = "4/3/33";
		input.sendKeys(text);
		browser.click(submitButtonXpathRight);
		textOutput = "04/03/0033";
		browser.waitForElementText(modelValueXpathRight, textOutput);
		browser.assertElementTextExists(modelValueXpathRight, textOutput);
	}
}
