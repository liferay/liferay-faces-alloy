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

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;


/**
 * @author  Kyle Stiemann
 */
public class IntegrationTestSuiteListener extends RunListener {

	@Override
	public void testRunFinished(Result result) throws Exception {

		// When the browser is phantomjs or chrome, WebDriver.close() does not quit the browser (like it is supposed to
		// https://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/WebDriver.html#quit%28%29), so we
		// use WebDriver.quit() instead.
		Browser.getInstance().quit();
		super.testRunFinished(result);
	}

	@Override
	public void testRunStarted(Description description) throws Exception {

		super.testRunStarted(description);

		if (!"tomcat".equals(IntegrationTesterBase.container)) {
			IntegrationTesterBase.signIn();
		}
	}
}
