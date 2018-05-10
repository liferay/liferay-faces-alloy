/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.test.alloy.showcase.inputfile;

import java.io.IOException;

import org.junit.Test;

import com.liferay.faces.test.showcase.inputfile.InputFileTester;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class InputFileMultipleTester extends InputFileTester {

	@Test
	public void runAlloyInputFileMultipleTest() throws IOException {

		// Multiple file upload is currently unsupported on Selenium, so this test only tests uploading a single file.
		// https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/2239
		runInputFileTest("alloy", "multiple");
	}
}
