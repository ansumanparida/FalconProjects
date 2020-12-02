/***
 *
 */
package com.atmecs.falcon_web.demoblaze.testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.falcon.automation.ui.selenium.Browser;

public class SampleTestSuiteBase {
	public String os,osVersion,br,browserVersion;
	public Browser browser;

	

	@BeforeClass
	public void preSetup() {
		browser = new Browser();
	}

	@AfterClass
	public void teardown() {
		browser.closeBrowser();
	}

}