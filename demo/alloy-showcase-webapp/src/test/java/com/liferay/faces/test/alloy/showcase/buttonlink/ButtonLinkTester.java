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
package com.liferay.faces.test.alloy.showcase.buttonlink;

import java.util.Locale;

import com.liferay.faces.test.selenium.Browser;
import com.liferay.faces.test.selenium.assertion.SeleniumAssert;
import com.liferay.faces.test.showcase.TesterBase;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class ButtonLinkTester extends TesterBase {

	// Xpath
	protected static final String generalButton1Xpath =
		"//button[contains(.,'Button')]//img[contains(@src,'liferay-faces-logo-small.png')][contains(@src,'ln=images') or contains(@src,'ln:images')]/..";
	protected static final String generalButton2Xpath =
		"//button[not(contains(.,'Button'))]//img[contains(@src,'liferay-faces-logo-small.png')][contains(@src,'ln=images') or contains(@src,'ln:images')]/..";
	protected static final String generalButton3Xpath =
		"//label[contains(.,'Example')][contains(.,'value')]/ancestor::div[@class='showcase-example']//button[@type='button' or @value='1234']";
	protected static final String generalLink1Xpath =
		"//img[contains(@src,'liferay-faces-logo-small.png')]/parent::a[contains(.,'Text for a link')]";
	protected static final String generalLink2Xpath =
		"//a[contains(.,'Text for a link')][not(contains(@src,'liferay-faces-logo-small.png'))]";

	protected void runButtonGeneralTest(String componentName, String button1xpath, String button2xpath,
		String button3xpath) throws Exception {

		runButtonLinkGeneralTest(componentName, button1xpath, button2xpath);

		Browser browser = Browser.getInstance();
		browser.waitForElementPresent(button3xpath);
		SeleniumAssert.assertElementVisible(browser, button3xpath);
		browser.click(button3xpath);
		assertImageRendered(browser, getExampleImageXpath("image"));
	}

	protected void runButtonLinkGeneralTest(String componentName, String buttonLink1xpath, String buttonLink2xpath)
		throws Exception {

		Browser browser = Browser.getInstance();
		navigateToUseCase(browser, componentName, "general");

		// Test that buttons/links render on the page visibly and are clickable.
		SeleniumAssert.assertElementVisible(browser, buttonLink1xpath);
		browser.click(buttonLink1xpath);
		browser.waitForElementPresent(buttonLink2xpath);
		SeleniumAssert.assertElementVisible(browser, buttonLink2xpath);
		browser.click(buttonLink2xpath);
		assertImageRendered(browser, getExampleImageXpath("children"));
		SeleniumAssert.assertElementVisible(browser, buttonLink1xpath + "/span[contains(@class,'icon-star')]/..");
	}

	protected void runButtonLinkMenuTest(String componentName) throws Exception {

		Browser browser = Browser.getInstance();
		navigateToUseCase(browser, componentName, "menu");

		boolean commandComponent = componentName.toLowerCase(Locale.ENGLISH).contains("command");
		testMenu(browser, "menu", "caret", commandComponent);
		testMenu(browser, "facet", "icon-chevron-down", commandComponent);
	}

	private void testMenu(Browser browser, String exampleType, String dropdownButtonClass, boolean commandComponent) {

		// Test that clicking the menu button submits the correct value.
		String menuButtonText = "User";
		String menuButtonXpath = "//label[contains(.,'Example')][contains(.,'" + exampleType +
			"')]/ancestor::div[@class='showcase-example']//a[contains(@class,'btn btn-default alloy-')]/span[contains(text(),'" +
			menuButtonText + "')]";
		browser.click(menuButtonXpath);

		String menuOutputXpath = "//label[contains(.,'" + exampleType +
			"')]/parent::div[@class='showcase-example']//ul[contains(@class,'feedback')]/li[contains(@class,'text-info')]";
		String menuOutput = menuButtonText;

		if (!commandComponent) {

			menuOutputXpath =
				"//label[contains(.,'Model Value')]/parent::div[@class='showcase-results']//span[contains(@class,'alloy-output-text')]";
			menuOutput = menuOutput.toLowerCase(Locale.ENGLISH);
		}

		browser.waitForElementTextVisible(menuOutputXpath, menuOutput);
		SeleniumAssert.assertElementTextVisible(browser, menuOutputXpath, menuOutput);

		// Test that clicking each menu item submits the correct value.
		String[] menuItems = new String[] { "Edit", "Enable", "Disable", "Delete" };
		String dropdownButtonXpath =
			"//span[@role='menuitem']/a[contains(@class,'btn btn-default alloy-')]/span[contains(@class,'" +
			dropdownButtonClass + "')]";

		for (String menuItem : menuItems) {

			browser.waitForElementVisible(dropdownButtonXpath);
			browser.click(dropdownButtonXpath);

			String menuItemXpath = "//label[contains(.,'Example')][contains(.,'" + exampleType +
				"')]/ancestor::div[@class='showcase-example']//span[contains(text(),'" + menuItem + "')]";

			browser.waitForElementVisible(menuItemXpath);
			browser.click(menuItemXpath);

			menuOutput = menuItem;

			if (!commandComponent) {
				menuOutput = menuItem.toLowerCase(Locale.ENGLISH);
			}

			browser.waitForElementTextVisible(menuOutputXpath, menuOutput);
			SeleniumAssert.assertElementTextVisible(browser, menuOutputXpath, menuOutput);
		}
	}
}
