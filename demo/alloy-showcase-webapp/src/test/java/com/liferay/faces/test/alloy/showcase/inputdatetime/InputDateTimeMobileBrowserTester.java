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
package com.liferay.faces.test.alloy.showcase.inputdatetime;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import com.liferay.faces.test.selenium.TestUtil;
import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.BrowserStateAsserter;
import com.liferay.faces.test.selenium.webdriver.WebDriverFactory;
import com.liferay.faces.test.showcase.TesterBase;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Kyle Stiemann
 */
public class InputDateTimeMobileBrowserTester extends TesterBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(InputDateTimeMobileBrowserTester.class);

	// Private Data Members
	private static BrowserDriver browserDriverSimulatingMobile;

	@AfterClass
	public static void quitMobileSimulatingBrowserDriver() {

		if (browserDriverSimulatingMobile != null) {

			browserDriverSimulatingMobile.quit();
			browserDriverSimulatingMobile = null;
		}
	}

	@Test
	public void runInputDateMobileBrowserTest() {

		String birthdayInput = "1999-01-01";
		String birthdayOutput = "01/01/1999";
		String browserName = browserDriverSimulatingMobile.getBrowserName();

		if ("chrome".equals(browserName)) {
			birthdayInput = birthdayOutput;
		}

		runInputDateTimeMobileBrowserTest("date", birthdayInput, birthdayOutput);
	}

	@Test
	public void runInputTimeMobileBrowserTest() {

		String timeInput = "11:11 AM";
		String timeOutput = timeInput;
		String browserName = browserDriverSimulatingMobile.getBrowserName();

		if ("chrome".equals(browserName)) {
			timeInput = "1111AM";
		}

		runInputDateTimeMobileBrowserTest("time", timeInput, timeOutput);
	}

	@Before
	public void setUpBrowserDriverSimulatingMobile() {

		Assume.assumeTrue(!"pluto".equals(TestUtil.getContainer()));

		if (browserDriverSimulatingMobile == null) {

			String browserName = TestUtil.getSystemPropertyOrDefault("integration.browser.name", null);
			String browserHeadlessString = TestUtil.getSystemPropertyOrDefault("integration.browser.headless", null);

			// Chrome does not support simulating a mobile browser in headless mode, so default to running mobile tests
			// in PhantomJS instead.
			if ((browserName == null) && (browserHeadlessString == null)) {

				browserName = "phantomjs";
				browserHeadlessString = "true";
			}
			else if (browserHeadlessString == null) {

				if ("firefox".equals(browserName) || "chrome".equals(browserName)) {
					browserHeadlessString = "false";
				}
				else {
					browserHeadlessString = "true";
				}
			}
			else if (browserName == null) {

				if ("true".equals(browserHeadlessString)) {
					browserName = "phantomjs";
				}
				else if ("false".equals(browserHeadlessString)) {
					browserName = "chrome";
				}
			}

			boolean browserHeadless = Boolean.valueOf(browserHeadlessString);
			WebDriver webDriver = WebDriverFactory.getWebDriver(browserName, browserHeadless, true);
			browserDriverSimulatingMobile = newBrowserDriver(webDriver, browserHeadless, true);
		}
	}

	private void runInputDateTimeMobileBrowserTest(String inputType, String inputValue, String output) {

		navigateToUseCase(browserDriverSimulatingMobile, "alloy", "input" + capitalize(inputType), "general");

		BrowserStateAsserter browserStateAsserter = newBrowserStateAsserter(browserDriverSimulatingMobile);
		String inputXpath = "//input[@type='" + inputType + "']";
		browserStateAsserter.assertElementDisplayed(inputXpath);
		browserDriverSimulatingMobile.centerElementInCurrentWindow(inputXpath);
		browserDriverSimulatingMobile.sendKeysToElement(inputXpath, inputValue);
		browserDriverSimulatingMobile.clickElement(submitButton1Xpath);
		browserStateAsserter.assertTextPresentInElement(output, modelValue1Xpath);
	}
}
