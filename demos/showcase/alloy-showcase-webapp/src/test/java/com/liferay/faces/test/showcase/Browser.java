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
package com.liferay.faces.test.showcase;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author  Kyle Stiemann
 */
public class Browser {

	private static WebDriver webDriver = null;
	private static WebDriverWait wait = null;
	private static Browser instance = null;
	private static final Logger logger = Logger.getLogger(Browser.class.getName());

	static {

		String logLevelString = System.getProperty("integration.log.level", "WARNING");
		Level logLevel = Level.parse(logLevelString);
		logger.setLevel(logLevel);
	}

	private Browser() {

		String browser = System.getProperty("integration.browser", "phantomjs");

		if ("phantomjs".equals(browser)) {
			webDriver = new PhantomJSDriver();
		}
		else if ("chrome".equals(browser)) {
			webDriver = new ChromeDriver();
		}
		else if ("firefox".equals(browser)) {
			webDriver = new FirefoxDriver();
		}

		webDriver.manage();
		wait = new WebDriverWait(webDriver, 5);
	}

	public static Browser getInstance() {

		if (instance == null) {
			instance = new Browser();
		}

		return instance;
	}

	public void assertElementExists(String xpath) {
		assertElementExists("Element " + xpath + " exists.", xpath);
	}

	public void assertElementExists(String message, String xpath) {
		WebElement element = getElement(xpath);
		Assert.assertNotNull(message, element);
	}

	public void assertElementTextExists(String xpath, String text) {
		assertElementTextExists("Element " + xpath + " contains text '" + text + "'", xpath, text);
	}

	public void assertElementTextExists(String message, String xpath, String text) {
		WebElement modelValue = getElement(xpath);
		String modelValueText = modelValue.getText();
		Assert.assertEquals(message, text, modelValueText);
	}

	public void click(String xpath) {
		getElement(xpath).click();
	}

	public void navigateToURL(String url) {
		webDriver.navigate().to(url);
	}

	public void quit() {
		webDriver.quit();
	}

	public void sendKeys(String xpath, String keys) {
		getElement(xpath).sendKeys(keys);
	}

	public void waitForElement(String xpath) {

		logger.log(Level.INFO, "Waiting for element {0}.", xpath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.ByXPath.xpath(xpath)));
		logger.log(Level.INFO, "Element {0} exists.", xpath);
	}

	public void waitForElementText(String xpath, String text) {

		String[] loggerArgs = new String[] { xpath, text };
		logger.log(Level.INFO, "Waiting for element {0} to contain text {1}.", loggerArgs);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.ByXPath.xpath(xpath), text));
		logger.log(Level.INFO, "Element {0} contains text {1}.", loggerArgs);
	}

	public void waitWhileElementExists(WebElement element) {

		logger.log(Level.INFO, "Waiting while element {0} exists.", element);

		// Note: We used stalenessOf instead of invisibilityOf because invisibiltyOf causes PhantomJS to log a warning.
		// Either one works though.
		wait.until(ExpectedConditions.stalenessOf(element));
		logger.log(Level.INFO, "Element {0} does not exist.", element);
	}

	public WebElement getElement(String xpath) {
		return webDriver.findElement(By.xpath(xpath));
	}
}
