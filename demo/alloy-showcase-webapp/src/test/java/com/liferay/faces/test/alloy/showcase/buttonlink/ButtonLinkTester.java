/**
 * Copyright (c) 2000-2025 Liferay, Inc. All rights reserved.
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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;
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

	protected void clickButtonLink(BrowserDriver browserDriver, String xpath) {

		WebElement webElement = browserDriver.findElementByXpath(xpath);
		String tagName = webElement.getTagName();
		String onclick = webElement.getAttribute("onclick");
		browserDriver.clickElement(xpath);

		// If the clicking the button/link will cause the page to reload.
		if ("a".equals(tagName) && ((onclick == null) || "".equals(onclick))) {

			browserDriver.waitFor(ExpectedConditions.stalenessOf(webElement));
			waitForShowcasePageReady(browserDriver);
		}
	}

	protected void runButtonGeneralTest(String componentName, String button1xpath, String button2xpath,
		String button3xpath) throws Exception {

		runButtonLinkGeneralTest(componentName, button1xpath, button2xpath);

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		waitingAsserter.assertElementDisplayed(button3xpath);

		BrowserDriver browserDriver = getBrowserDriver();
		clickButtonLink(browserDriver, button3xpath);
		assertImageRendered(browserDriver, waitingAsserter, getExampleImageXpath("image"));
	}

	protected void runButtonLinkGeneralTest(String componentName, String buttonLink1xpath, String buttonLink2xpath)
		throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, componentName, "general");

		// Test that buttons/links render on the page visibly and are clickable.
		WaitingAsserter waitingAsserter = getWaitingAsserter();
		waitingAsserter.assertElementDisplayed(buttonLink1xpath);
		clickButtonLink(browserDriver, buttonLink1xpath);
		waitingAsserter.assertElementDisplayed(buttonLink2xpath);
		clickButtonLink(browserDriver, buttonLink2xpath);
		assertImageRendered(browserDriver, waitingAsserter, getExampleImageXpath("children"));
		waitingAsserter.assertElementDisplayed(buttonLink1xpath + "/span[contains(@class,'icon-star')]/..");
	}

	protected void runButtonLinkMenuTest(String componentName) throws Exception {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, componentName, "menu");

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		boolean commandComponent = componentName.toLowerCase(Locale.ENGLISH).contains("command");
		testMenu(browserDriver, waitingAsserter, "menu", "caret", commandComponent);
		testMenu(browserDriver, waitingAsserter, "facet", "icon-chevron-down", commandComponent);
	}

	private void testMenu(BrowserDriver browserDriver, WaitingAsserter waitingAsserter, String exampleType,
		String dropdownButtonClass, boolean commandComponent) {

		// Test that clicking the menu button submits the correct value.
		String menuButtonText = "User";
		String menuButtonXpath = "//label[contains(.,'Example')][contains(.,'" + exampleType +
			"')]/ancestor::div[@class='showcase-example']//a[contains(@class,'btn btn-secondary alloy-')]/span[contains(text(),'" +
			menuButtonText + "')]";
		browserDriver.clickElement(menuButtonXpath);

		String menuOutputXpath = "//label[contains(.,'" + exampleType +
			"')]/parent::div[@class='showcase-example']//ul[contains(@class,'feedback')]/li[contains(@class,'text-info')]";
		String menuOutput = menuButtonText;

		if (!commandComponent) {

			menuOutputXpath =
				"//label[contains(.,'Model Value')]/parent::div[@class='showcase-results']//span[contains(@class,'alloy-output-text')]";
			menuOutput = menuOutput.toLowerCase(Locale.ENGLISH);
		}

		browserDriver.waitForTextPresentInElement(menuOutput, menuOutputXpath);
		waitingAsserter.assertTextPresentInElement(menuOutput, menuOutputXpath);

		// Test that clicking each menu item submits the correct value.
		String[] menuItems = new String[] { "Edit", "Enable", "Disable", "Delete" };
		String dropdownButtonXpath =
			"//span[@role='menuitem']/a[contains(@class,'btn btn-secondary alloy-')]/span[contains(@class,'" +
			dropdownButtonClass + "')]";

		for (String menuItem : menuItems) {

			browserDriver.waitForElementEnabled(dropdownButtonXpath);
			browserDriver.clickElement(dropdownButtonXpath);

			String menuItemXpath = "//label[contains(.,'Example')][contains(.,'" + exampleType +
				"')]/ancestor::div[@class='showcase-example']//span[contains(text(),'" + menuItem + "')]";

			browserDriver.waitForElementEnabled(menuItemXpath);
			browserDriver.clickElement(menuItemXpath);

			menuOutput = menuItem;

			if (!commandComponent) {
				menuOutput = menuItem.toLowerCase(Locale.ENGLISH);
			}

			browserDriver.waitForTextPresentInElement(menuOutput, menuOutputXpath);
			waitingAsserter.assertTextPresentInElement(menuOutput, menuOutputXpath);
		}
	}
}
