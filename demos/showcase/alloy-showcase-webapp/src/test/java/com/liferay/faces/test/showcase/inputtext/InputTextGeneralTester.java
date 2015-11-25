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
public class InputTextGeneralTester extends InputTextTester {

	@Test
	public void runInputTextGeneralTest() throws Exception {

		Browser browser = Browser.getInstance();
		browser.navigateToURL(inputTextURL + "general");

		// Wait to begin the test until the submit button is rendered.
		browser.waitForElement(submitButtonXpath);

		// Test that an empty value submits successfully.
		browser.click(submitButtonXpath);

		String successXpath = "//div[@class='alloy-field form-group has-success']";
		browser.waitForElement(successXpath);
		browser.assertElementExists(successXpath);

		// Test that the web page shows an error message when a value is required and an empty value is submitted.
		WebElement successElement = browser.getElement(successXpath);
		String requiredCheckboxXpath = "//input[contains(@id,':requiredCheckbox')]";
		browser.click(requiredCheckboxXpath);
		browser.waitWhileElementExists(successElement);
		browser.click(submitButtonXpath);
		browser.waitForElement(errorXpath);
		browser.assertElementExists(errorXpath);

		// Test that a text value submits successfully.
		String text = "Hello World!";
		browser.sendKeys(inputXpath, text);
		browser.click(submitButtonXpath);
		browser.waitForElementText(modelValueXpath, text);
		browser.assertElementTextExists(modelValueXpath, text);
	}
}
