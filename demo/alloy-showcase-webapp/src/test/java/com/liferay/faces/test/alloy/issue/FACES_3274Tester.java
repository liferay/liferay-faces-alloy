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
package com.liferay.faces.test.alloy.issue;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;
import com.liferay.faces.test.showcase.TesterBase;


/**
 * @author  Kyle Stiemann
 */
public class FACES_3274Tester extends TesterBase {

	private static void assertAutocompleteAttributeOff(WaitingAsserter waitingAsserter, String inputXpath) {
		waitingAsserter.assertTrue(ExpectedConditions.attributeToBe(By.xpath(inputXpath), "autocomplete", "off"));
	}

	private static String getInputDateTimeXpath(String showOn, String inputIdSuffix) {
		return "//div[contains(@class,'showcase-example')]" + "[contains(.,'showOn')][contains(.,'=')][contains(.,'" +
			showOn + "')]" + "//input[contains(@id,':" + inputIdSuffix + "')]";
	}

	/**
	 * This method only works in Firefox.
	 */
	private static void runFACES_3274Test(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String inputXpath, boolean isAutocompleteOn) {

		String helloWorld = "Hello World!";
		Actions actions = browserDriver.createActions(inputXpath);
		WebElement inputElement = browserDriver.findElementByXpath(inputXpath);
		actions.sendKeys(inputElement, helloWorld, Keys.ENTER);
		browserDriver.performAndWaitForRerender(actions.build(), inputXpath);
		browserDriver.clearElement(inputXpath);

		String hello = "Hello";
		browserDriver.sendKeysToElement(inputXpath, hello);
		waitingAsserter.assertTextPresentInElementValue(hello, inputXpath);
		browserDriver.sendKeysToElement(inputXpath, Keys.DOWN, Keys.ENTER);
		waitingAsserter.assertTextPresentInElementValue(hello, inputXpath);

		ExpectedCondition<Boolean> textToBePresentInElementValue = ExpectedConditions.textToBePresentInElementValue(By
				.xpath(inputXpath), helloWorld);

		if (isAutocompleteOn) {
			waitingAsserter.assertTrue(textToBePresentInElementValue);
		}
		else {
			waitingAsserter.assertFalse(textToBePresentInElementValue);
		}
	}

	@Test
	public void runFACES_3274AutoCompleteTest() {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "autoComplete", "general");

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		String autoCompleteInputXpath = "(//*[contains(@class,'alloy-auto-complete')]/input[contains(@id,'_input')])";
		assertAutocompleteAttributeOff(waitingAsserter, autoCompleteInputXpath + "[1]");
		assertAutocompleteAttributeOff(waitingAsserter, autoCompleteInputXpath + "[2]");
	}

	@Test
	public void runFACES_3274InputDateTest() {

		BrowserDriver browserDriver = getBrowserDriver();
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		String inputType = "inputDate";
		String inputIdSuffix = "birthday_input";
		runFaces_3274InputDateTimeTest(browserDriver, waitingAsserter, inputType, inputIdSuffix);
	}

	@Test
	public void runFACES_3274InputTimeTest() {

		BrowserDriver browserDriver = getBrowserDriver();
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		String inputType = "inputTime";
		String inputIdSuffix = "time_input";
		runFaces_3274InputDateTimeTest(browserDriver, waitingAsserter, inputType, inputIdSuffix);
	}

	private void runFaces_3274InputDateTimeTest(BrowserDriver browserDriver, WaitingAsserter waitingAsserter,
		String inputType, String inputIdSuffix) {

		navigateToUseCase(browserDriver, inputType, "general");

		String showOnButtonInputXpath = getInputDateTimeXpath("button", inputIdSuffix);
		WebElement showOnButtonInput = browserDriver.findElementByXpath(showOnButtonInputXpath);
		waitingAsserter.assertTrue(ExpectedConditions.not(
				ExpectedConditions.attributeToBeNotEmpty(showOnButtonInput, "autocomplete")));

		String showOnFocusInputXpath = getInputDateTimeXpath("focus", inputIdSuffix);
		assertAutocompleteAttributeOff(waitingAsserter, showOnFocusInputXpath);

		String showOnBothInputXpath = getInputDateTimeXpath("both", inputIdSuffix);
		assertAutocompleteAttributeOff(waitingAsserter, showOnBothInputXpath);

		if ("firefox".equals(browserDriver.getBrowserName())) {

			runFACES_3274Test(browserDriver, waitingAsserter, showOnButtonInputXpath, true);

			if ("inputDate".equalsIgnoreCase(inputType)) {

				runFACES_3274Test(browserDriver, waitingAsserter, showOnFocusInputXpath, false);
				runFACES_3274Test(browserDriver, waitingAsserter, showOnBothInputXpath, false);
			}
		}
	}
}
