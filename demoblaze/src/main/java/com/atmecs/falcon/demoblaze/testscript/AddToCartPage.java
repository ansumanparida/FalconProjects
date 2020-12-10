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

public class AddToCartPage extends SampleTestSuiteBase {
	
	private ReportLogService report = new ReportLogServiceImpl(AddToCartPage.class);
	Properties testData = PropertyReader.readProperties(FilePathConstants.HOME_TESTDATA_PATH);
	String url = testData.getProperty("Url");
	
	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void addToCartPageTest(String os, String osVersion, String br, String browserVersion) throws Exception {
		browser.openURL(url, os, osVersion, br, browserVersion);
		browser.maximizeWindow();
		
		Click click = browser.getClick();
		report.info("Executing Test ");
		TextField enterText = browser.getTextField();
		report.info("Select Mobile To Buy");
		click.performClick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.MOBILE_LINK));
		report.info("Adding To Cart");
		click.waitandclick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.ADD_TO_CART_LINK),2000);
		report.info("Handling Alert");
		String alertText = browser.getAlert().getAlertText(2000);
		report.info("Alert Text="+ alertText);
		report.info("Click on Cart Link");
		click.waitandclick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.CART_LINK),5000);
		report.info("Click on Place Order");
		click.waitandclick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.PLACE_ORDER),5000);
		report.info("Entering Details To Place Order");
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.NAME), testData.getProperty("Name"));
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.COUNTRY), testData.getProperty("Country"));
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.CITY), testData.getProperty("City"));
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.CREDITCARD), testData.getProperty("Creditcard"));
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.MONTH), testData.getProperty("Month"));
		enterText.enterTextField(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.YEAR), testData.getProperty("Year"));
		report.info("Clicking On Purchase");
		click.performClick(LocatorType.XPATH, SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HOME_LOCATOR_PATH, LocatorKeyContainer.PURCHASE_BUTTON));
//		String text = browser.getCurrentPageTitle();
//		Verify.verifyString(text, "STORE", "Verifying String Message ");
}
	}
