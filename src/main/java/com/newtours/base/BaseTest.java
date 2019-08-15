package com.newtours.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(com.newtours.utilities.ListnersTest.class)

/**
 * This Class contains all the essential methods for a Test Class.<br>
 * <b>Note:</b> All the Test Classes must extend this Page Class.
 * 
 * @author Sujay Sawant
 * @version 1.0.2
 * @since 05/27/2019
 */
public class BaseTest {

	public static WebDriver driver;

	/**
	 * This method will run before each Method.
	 */
	@BeforeMethod
	public void before() {
		BrowserUtilities.openWebsite(getWebDriver(), Constants.mercuryToursWebsite);
		BrowserUtilities.refreshWebpage(getWebDriver());
	}

	/**
	 * This method will run after each Test.
	 */
	@AfterTest
	public void after() {
		BrowserUtilities.quitBrowser(getWebDriver());
	}

	/**
	 * This method is used to get a new WebDriver instance.
	 * 
	 * @return WebDriver object
	 */
	public static WebDriver getWebDriver() {
		if (driver == null) {
			System.setProperty(Constants.driver_chrome, Constants.driverPath_chrome);
			driver = new ChromeDriver();
			return driver;
		} else {
			return driver;
		}

	}

}
