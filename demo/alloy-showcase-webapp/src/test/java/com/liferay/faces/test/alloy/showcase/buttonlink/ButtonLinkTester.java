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

	protected static final String generalButton1Xpath =
		"//label[contains(.,'Example')][contains(.,'children')]/ancestor::div[@class='showcase-example']//button//img[contains(@src,'liferay-faces-logo-small.png')][contains(@src,'ln=images') or contains(@src,'ln:images')]";
	protected static final String generalButton2Xpath =
		"//label[contains(.,'Example')][contains(.,'image')]/ancestor::div[@class='showcase-example']//button//img[contains(@src,'liferay-faces-logo-small.png')][contains(@src,'ln=images') or contains(@src,'ln:images')]";
	protected static final String generalButtonValueXpath =
		"//label[contains(.,'Example')][contains(.,'value')]/ancestor::div[@class='showcase-example']//button[@type='button' or @value='1234']";
	protected static final String generalLink1Xpath =
		"//img[contains(@src,'liferay-faces-logo-small.png')]/parent::a[contains(.,'Text for a link')]";
	protected static final String generalLink2Xpath =
		"//a[contains(.,'Text for a link')][not(contains(@src,'liferay-faces-logo-small.png'))]";
	protected static String menuItemOutputXpath =
		"(//label[contains(.,'Model Value')]/parent::div[@class='showcase-results']//span[contains(@class,'alloy-output-text')])";

	protected void runButtonLinkGeneralTest(String componentName, String buttonLink1xpath, String buttonLink2xpath)
		throws Exception {

		Browser browser = Browser.getInstance();
		navigateToUseCase(browser, componentName, "general");

		// Test that buttons/links render on the page visibly and are clickable.

		SeleniumAssert.assertElementVisible(browser, buttonLink1xpath);
		SeleniumAssert.assertElementVisible(browser, buttonLink2xpath);
		browser.click(buttonLink1xpath);
		browser.click(buttonLink2xpath);

		assertImageRendered(browser, "children");

		SeleniumAssert.assertElementVisible(browser, buttonLink1xpath + "/span[contains(@class,'icon-star')]");

		if (componentName.toLowerCase(Locale.ENGLISH).contains("button")) {
			SeleniumAssert.assertElementVisible(browser, generalButtonValueXpath);
			browser.click(generalButtonValueXpath);

			assertImageRendered(browser, "image");
		}
	}

	protected void runButtonLinkMenuTest(String componentName) throws Exception {

		Browser browser = Browser.getInstance();
		navigateToUseCase(browser, componentName, "menu");

		if (componentName.toLowerCase(Locale.ENGLISH).contains("command")) {
			menuItemOutputXpath =
				"//label[contains(.,'menu')]/parent::div[@class='showcase-example']//ul[contains(@class,'feedback')]/li[contains(@class,'text-info')]";
		}

		testMenu(browser, menuItemOutputXpath, "menu", "caret");

		if (componentName.toLowerCase(Locale.ENGLISH).contains("command")) {
			menuItemOutputXpath =
				"//label[contains(.,'facet')]/parent::div[@class='showcase-example']//ul[contains(@class,'feedback')]/li[contains(@class,'text-info')]";
		}

		testMenu(browser, menuItemOutputXpath, "facet", "icon-chevron-down");
	}

	protected void testMenu(Browser browser, String menuItemOutputXpath, String exampleType, String dropdownType) {
		String userButtonXpath = "//label[contains(.,'Example')][contains(.,'" + exampleType +
			"')]/ancestor::div[@class='showcase-example']//a[contains(@class,'btn btn-default alloy-')]/span[contains(text(),'User')]";
		browser.click(userButtonXpath);
		browser.waitForElementTextVisible(menuItemOutputXpath, "ser");
		SeleniumAssert.assertElementTextVisible(browser, menuItemOutputXpath, "ser");

		testMenuItemSelection(browser, exampleType, dropdownType, menuItemOutputXpath, "dit");
		testMenuItemSelection(browser, exampleType, dropdownType, menuItemOutputXpath, "nable");
		testMenuItemSelection(browser, exampleType, dropdownType, menuItemOutputXpath, "isable");
		testMenuItemSelection(browser, exampleType, dropdownType, menuItemOutputXpath, "elete");
	}

	protected void testMenuItemSelection(Browser browser, String exampleType, String dropdownType,
		String menuItemOutputXpath, String menuItem) {
		String dropdownButtonXpath =
			"//span[@role='menuitem']/a[contains(@class,'btn btn-default alloy-')]/span[contains(@class,'" +
			dropdownType + "')]";
		browser.waitForElementVisible(dropdownButtonXpath);
		browser.click(dropdownButtonXpath);

		browser.waitForElementVisible("//label[contains(.,'Example')][contains(.,'" + exampleType +
			"')]/ancestor::div[@class='showcase-example']//span[contains(text(),'" + menuItem + "')]");
		browser.click("//label[contains(.,'Example')][contains(.,'" + exampleType +
			"')]/ancestor::div[@class='showcase-example']//span[contains(text(),'" + menuItem + "')]");
		browser.waitForElementTextVisible(menuItemOutputXpath, menuItem);
		SeleniumAssert.assertElementTextVisible(browser, menuItemOutputXpath, menuItem);
	}
}
