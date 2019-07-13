package com.newtours.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.newtours.pages.MainWebsitePage;

/**
 * This Class contains all the essential methods related to a particular <b>Browser</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.2
 * @since 02/27/2018
 */
public class BrowserUtilities {

	/**
	 * This method is used to initialize the WebDriver object to a specific browser.
	 * 
	 * @param driver : WebDriver object
	 * @param browserName : Name of the browser
	 * @return WebDriver object of the mention browser
	 */
	public static WebDriver openBrowser(WebDriver driver, String browserName) {

		switch (browserName) {
		case Constants.browser_chrome:
			System.out.println("Select [" + Constants.browser_chrome + "] browser");
			Reporter.log("Select [" + Constants.browser_chrome + "] browser<br>");
			System.setProperty(Constants.driver_chrome, Constants.driverPath_chrome);
			return new ChromeDriver();
		case Constants.browser_firefox:
			System.out.println("Select [" + Constants.browser_firefox + "] browser");
			Reporter.log("Select [" + Constants.browser_firefox + "] browser<br>");
			System.setProperty(Constants.driver_firefox, Constants.driverPath_firefox);
			return new FirefoxDriver();
		case Constants.browser_ie:
			System.out.println("Select [" + Constants.browser_ie + "] browser");
			Reporter.log("Select [" + Constants.browser_ie + "] browser<br>");
			System.setProperty(Constants.driver_ie, Constants.driverPath_ie);
			return new InternetExplorerDriver();
		default:
			System.out.println("The browser [" + browserName + "] is not a valid browser");
			Reporter.log("The browser [" + browserName + "] is not a valid browser<br>");
			Assert.assertTrue(false);
			return driver;
		}
	}

	/**
	 * This method is used to open a <b>Web Site</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param websiteUrl : URL of the Web Site
	 */
	public static void openWebsite(WebDriver driver, String websiteUrl) {
		System.out.println("Open [" + websiteUrl + "] website");
		Reporter.log("Open [" + websiteUrl + "] website<br>");
		driver.navigate().to(websiteUrl);
		Assert.assertTrue(MainWebsitePage.mercuryToursLogo.isPresent(), "Incorrect Web Site");
	}

	/**
	 * This method is used to <b>Refresh</b> a web page.
	 * 
	 * @param driver : WebDriver object
	 */
	public static void refreshWebpage(WebDriver driver) {
		System.out.println("Refresh the [" + driver.getTitle() + "] webpage");
		Reporter.log("Refresh the [" + driver.getTitle() + "] webpage<br>");
		driver.navigate().refresh();
	}

	/**
	 * This method is used to <b>Maximize</b> the browser window.
	 * 
	 * @param driver : WebDriver object
	 */
	public static void maximizeBrowser(WebDriver driver) {
		System.out.println("Maximize the " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase() + " Browser");
		Reporter.log("Maximize the " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase() + " Browser<br>");
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to include <b>Implicit Wait</b> for the WebDriver instance.
	 * 
	 * @param driver : WebDriver object
	 * @param number : Number to specify the time of wait
	 * @param time : Time Unit of the number specified
	 */
	public static void implicitlyWait(WebDriver driver, long number, TimeUnit time) {
		System.out.println("Implicitly wait for [" + number + "] " + time.name().toLowerCase());
		Reporter.log("Implicitly wait for [" + number + "] " + time.name().toLowerCase() + "<br>");
		driver.manage().timeouts().implicitlyWait(number, time);
	}

	/**
	 * This method is used to <b>Quit</b> the browser.
	 * 
	 * @param driver : WebDriver object
	 */
	public static void quitBrowser(WebDriver driver) {
		System.out.println("Quit the " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase() + " browser");
		Reporter.log("Quit the " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase() + " browser<br>");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
