package com.atmecs.falcon_web.demoblaze.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon_web.demoblaze.pages.HomePage;
import com.atmecs.falcon_web.demoblaze.pages.LoginPage;
import com.atmecs.falcon_web.demoblaze.testsuite.SampleTestSuiteBase;
import com.atmecs.falcon_web.demoblaze.utils.ExcelDataProvider;

public class LoginTest extends SampleTestSuiteBase {
	String url = PropertyParser.readEnvOrConfigProperty("url");
	
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	
	public void initBrowser(String os,String osVersion,String br, String browserVersion) {
		this.os = os;
		this.osVersion = osVersion;
		this.br = br;
		this.browserVersion = browserVersion;
		}
	
	@Test(dataProvider = "DataSheet",dataProviderClass = ExcelDataProvider.class)
	
	public void testLogin(String username,String password) {
		
		HomePage homePage = new HomePage(browser);
		LoginPage loginPage = new LoginPage(browser);
		
		homePage.navigateToUrl(url, os, osVersion, br, browserVersion);
		homePage.clickLoginLink();
		loginPage.login(username, password);
	}

}
