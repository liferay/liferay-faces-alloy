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

import java.io.IOException;

import org.junit.Assume;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.TestUtil;
import com.liferay.faces.test.selenium.browser.WaitingAsserter;


/**
 * @author  Kyle Stiemann
 */
public class LSV_487Tester extends LSV_487TesterCompat {

	@Test
	public void runLSV_487Test() throws IOException {

		Assume.assumeTrue("This vulnerability only exists in non-Portlet applications.",
			"webapp".equalsIgnoreCase(TestUtil.getContainer()));
		runInputFileTest("alloy", "multiple");

		BrowserDriver browserDriver = getBrowserDriver();
		browserDriver.sendKeysToElement("//input[@type='file']", getFileSystemPathForResource("1_5mb.txt"));
		browserDriver.clickElement(submitButton1Xpath);

		WaitingAsserter waitingAsserter = getWaitingAsserter();
		String uploadedFilesXpath = "//div[contains(@class,'results-content')]/pre";
		ExpectedCondition<Boolean> uploadedFileTextNotPresent = ExpectedConditions.not(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(uploadedFilesXpath + "/table/tbody/tr/td[2]/span"),
					"1_5mb.txt"));
		ExpectedCondition<Boolean> noUploadedFilesPresent = ExpectedConditions.not(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath(uploadedFilesXpath + "/*")));
		waitingAsserter.assertTrue(ExpectedConditions.or(uploadedFileTextNotPresent, noUploadedFilesPresent));
	}
}
