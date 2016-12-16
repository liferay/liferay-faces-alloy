/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.test.alloy.showcase.buttonrow;

import org.junit.Test;

import com.liferay.faces.test.alloy.showcase.buttonlink.ButtonLinkTester;
import com.liferay.faces.test.selenium.Browser;
import com.liferay.faces.test.selenium.assertion.SeleniumAssert;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class ButtonRowGeneralTester extends ButtonLinkTester {

	@Test
	public void runButtonRowGeneralTest() throws Exception {
		Browser browser = Browser.getInstance();
		navigateToUseCase(browser, "buttonrow", "general");

		// Test the visibility of alloy button row and button holder.
		SeleniumAssert.assertElementVisible(browser, "//div[@class='alloy-button-row button-holder']");

		// Test the visibility of both button.
		SeleniumAssert.assertElementVisible(browser,
			"//*[contains(@class,'btn ')][contains(@class,'btn-primary')][@value='Save' or contains(.,'Save')]");
		SeleniumAssert.assertElementVisible(browser,
			"//*[contains(@class,'btn ')][contains(@class,'btn-cancel')][@value='Cancel' or contains(.,'Cancel')]");

		// click first button
		browser.click(
			"//*[contains(@class,'btn ')][contains(@class,'btn-primary')][@value='Save' or contains(.,'Save')]");

		// click second button
		browser.click(
			"//*[contains(@class,'btn ')][contains(@class,'btn-cancel')][@value='Cancel' or contains(.,'Cancel')]");
	}
}
