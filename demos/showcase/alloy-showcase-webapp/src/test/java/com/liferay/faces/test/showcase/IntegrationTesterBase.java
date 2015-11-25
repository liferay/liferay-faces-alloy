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

import org.junit.AfterClass;
import org.junit.BeforeClass;


/**
 * @author  Kyle Stiemann
 */
public class IntegrationTesterBase {

	// Private Constants
	private static final String baseURL;
	private static String context = System.getProperty("integration.context",
			"/alloy-showcase-webapp-3.0.0-SNAPSHOT/web/guest/showcase/-/component/alloy/");
	private static String host = System.getProperty("integration.host", "localhost");
	private static String port = System.getProperty("integration.port", "8080");
	private static final boolean runningWithMavenSurefirePlugin = Boolean.valueOf(System.getProperty(
				"runningWithMavenSurefirePlugin"));
	private static String signInContext = System.getProperty("integration.sign.in.context", "");

	// /* package-private */ Constants
	/* package-private */ static String container = System.getProperty("integration.container", "tomcat");

	// Protected Constants
	protected static final String signInURL;
	protected static final String testBaseURL;

	static {
		baseURL = "http://" + host + ":" + port;
		signInURL = baseURL + signInContext;
		testBaseURL = baseURL + context;
	}

	/**
	 * {@link TestSuiteListener#testRunFinished()} is used to shut down the browser/webDriver when the tests are run
	 * with the maven-surefire-plugin. However, {@link TestSuiteListener#testRunFinished()} is not called when the tests
	 * are not run with the maven-surefire-plugin (i.e. when the tests are run from an IDE). So when the tests are run
	 * from an IDE, it is necessary to shutdown the browser after each test class is run.
	 */
	@AfterClass
	public static void tearDown() {

		if (!runningWithMavenSurefirePlugin) {

			// When the browser is phantomjs or chrome, WebDriver.close() does not quit the browser (like it is
			// supposed to
			// https://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/WebDriver.html#quit%28%29),
			// so we use WebDriver.quit() instead.
			Browser.getInstance().quit();
		}
	}

	/* package-private */ static void signIn() {

		if ("liferay".equals(container)) {
			// TODO
		}
		else if ("pluto".equals(container)) {
			// TODO
		}
	}

	/**
	 * {@link TestSuiteListener#testRunStarted()} is used to sign in to the container when the tests are run with the
	 * maven-surefire-plugin. However, {@link TestSuiteListener#testRunStarted()} is not called when the tests are not
	 * run with the maven-surefire-plugin (i.e. when the tests are run from an IDE). So when the tests are run from an
	 * IDE, it is necessary to sign in to the container before each test class is run.
	 */
	@BeforeClass
	public static void setUp() {

		if (!runningWithMavenSurefirePlugin && !"tomcat".equals(container)) {
			signIn();
		}
	}
}
