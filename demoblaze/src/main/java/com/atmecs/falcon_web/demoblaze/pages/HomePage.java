package com.atmecs.falcon_web.demoblaze.pages;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon_web.demoblaze.constant.FilePathConstants;
import com.atmecs.falcon_web.demoblaze.utils.PropertyReader;

public class HomePage extends BasePage {
	
	private ReportLogService report = new ReportLogServiceImpl(HomePage.class);
	PropertyReader homePageProperties = new PropertyReader(FilePathConstants.HOME_LOCATOR_PATH);

	public HomePage(Browser browser) {
		super(browser);
	
	}
	
	public void clickLoginLink() {
		report.info("Click on Login Link");
		browser.getFindFromBrowser().findElementByXpath(homePageProperties.get("Login")).click();
		
	}
	public void clickSignupLink() {
		report.info("Click on SignUp Link");
		browser.getFindFromBrowser().findElementByXpath(homePageProperties.get("Signup")).click();
		
	}
	public void clickContactUsLink() {
		report.info("Click on ContactUs Link");
		browser.getFindFromBrowser().findElementByXpath(homePageProperties.get("ContactUs")).click();
		
	}
}
