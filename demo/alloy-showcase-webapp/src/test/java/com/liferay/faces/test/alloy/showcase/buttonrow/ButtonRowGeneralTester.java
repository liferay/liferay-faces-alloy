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
		navigateToUseCase(browser, "buttonRow", "general");

		// Test that alloy:buttonRow is visible.
		SeleniumAssert.assertElementVisible(browser, "//div[@class='alloy-button-row button-holder']");

		// Test that both buttons appear and can be clicked.
		String saveButtonXpath =
			"//*[contains(@class,'btn ')][contains(@class,'btn-primary')][@value='Save' or contains(.,'Save')]";
		SeleniumAssert.assertElementVisible(browser, saveButtonXpath);
		browser.click(saveButtonXpath);

		String cancelButtonXpath =
			"//*[contains(@class,'btn ')][contains(@class,'btn-cancel')][@value='Cancel' or contains(.,'Cancel')]";
		SeleniumAssert.assertElementVisible(browser, cancelButtonXpath);
		browser.click(cancelButtonXpath);
	}
}
