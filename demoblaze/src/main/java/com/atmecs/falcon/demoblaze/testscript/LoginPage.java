package com.atmecs.falcon.demoblaze.testscript;

import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Click;
import com.atmecs.falcon.automation.ui.selenium.TextField;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.demoblaze.constant.FilePathConstants;
import com.atmecs.falcon.demoblaze.constant.LocatorKeyContainer;
import com.atmecs.falcon.demoblaze.constant.PropertyReader;
import com.atmecs.falcon.demoblaze.testsuite.SampleTestSuiteBase;
import com.atmecs.locatorSmartFixTool.models.SmartFixPageFileHandler;

public class LoginPage extends SampleTestSuiteBase {
	private ReportLogService report = new ReportLogServiceImpl(LoginPage.class);
	Properties testData = PropertyReader.readProperties(FilePathConstants.HOME_TESTDATA_PATH);
	String url = testData.getProperty("Url");
	
	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void loginPageTest(String os, String osVersion, String br, String browserVersion) throws Exception {
		browser.openURL(url, os, osVersion, br, browserVersion);
		browser.maximizeWindow();
		
		Click click = browser.getClick();
		report.info("Executing Test ");
		TextField enterText = browser.getTextField();
		report.info("Click On Login");
		click.performClick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.LOGIN_LINK));
		browser.getWait();
		report.info("Entering UserName");
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.LOGIN_USERNAME_LINK), testData.getProperty("LoginUsername"));
		report.info("Entering Password");
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.LOGIN_PASSWORD_LINK), testData.getProperty("LoginPassword"));
		report.info("Click on Login Button");
		click.performClick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.lOGIN_BUTTON_LINK));
		report.info("Verifying Page Title");
		String text = browser.getCurrentPageTitle();
		System.out.println(text);
		Verify.verifyString(text, "STORE", "Verifying String Message ");
				
	}
	
}
