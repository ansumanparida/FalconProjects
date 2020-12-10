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

public class RegistrationPage extends SampleTestSuiteBase {
	
	private ReportLogService report = new ReportLogServiceImpl(RegistrationPage.class);
	Properties testData = PropertyReader.readProperties(FilePathConstants.HOME_TESTDATA_PATH);
	String url = testData.getProperty("Url");
	
	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void registartionPageTest(String os, String osVersion, String br, String browserVersion) {
		browser.openURL(url, os, osVersion, br, browserVersion);
		browser.maximizeWindow();
		
		Click click = browser.getClick();
		report.info("Executing Test ");
		TextField enterText = browser.getTextField();
		report.info("Click On SignUp");
		click.performClick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.SIGNUP_LINK));
		report.info("Filling Username Field");
//		browser.getWait();
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.SIGNUP_USERNAME_LINK), testData.getProperty("SignupUsername"));
		report.info("Filling Password Field");
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.SIGNUP_PASSWORD_LINK), testData.getProperty("SignupPassword"));
		report.info("Click on SignUp Button");
		click.performClick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.SIGNUP_BUTTON_LINK));
		String alertText = browser.getAlert().getAlertText(1000);
		report.info(alertText);
		report.info("Verifying Page Title");
		String text = browser.getCurrentPageTitle();
		Verify.verifyString(text, "STORE", "Verifying String Message ");
}
	}
