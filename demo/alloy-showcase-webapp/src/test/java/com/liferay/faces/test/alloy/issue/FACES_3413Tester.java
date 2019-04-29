/**
 * Copyright (c) 2000-2019 Liferay, Inc. All rights reserved.
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

import java.util.regex.Pattern;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;
import com.liferay.faces.test.showcase.TesterBase;


/**
 * @author  Kyle Stiemann
 */
public class FACES_3413Tester extends TesterBase {

	@Test
	public void runFACES_3274Test() {

		BrowserDriver browserDriver = getBrowserDriver();
		navigateToUseCase(browserDriver, "autoComplete", "general");

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		String autoCompleteInputXpath = "(//*[contains(@class,'alloy-auto-complete')]/input[contains(@id,'_input')])";
		waitingAsserter.assertTrue(new HasCSSClass(autoCompleteInputXpath, "form-control"));
		waitingAsserter.assertTrue(ExpectedConditions.not(
				new HasCSSClass(autoCompleteInputXpath + "/..", "form-control")));
	}

	private static final class HasCSSClass implements ExpectedCondition<Boolean> {

		// Private Final Data Members
		private final String elementXpath;
		private final String cssClass;
		private final Pattern containsCSSClassRegex;

		public HasCSSClass(String elementXpath, String cssClass) {
			this.elementXpath = elementXpath;
			this.cssClass = cssClass;
			this.containsCSSClassRegex = Pattern.compile("(^|\\s)" + cssClass + "(\\s|$)");
		}

		@Override
		public Boolean apply(WebDriver webDriver) {

			WebElement element = webDriver.findElement(By.xpath(elementXpath));
			String classes = element.getAttribute("class");

			if (classes == null) {
				classes = "";
			}

			return containsCSSClassRegex.matcher(classes).find();
		}

		@Override
		public String toString() {
			return "element at \"" + elementXpath + "\" to have CSS class \"" + cssClass + "\".";
		}
	}
}
