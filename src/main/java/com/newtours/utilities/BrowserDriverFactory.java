package com.newtours.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;

	public BrowserDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}

	public WebDriver createDriver() {
		switch (browser) {
		case "chrome":
			System.setProperty(Constants.driver_chrome, Constants.driverPath_chrome);
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty(Constants.driver_firefox, Constants.driverPath_firefox);
			driver.set(new FirefoxDriver());
			break;
		case "ie":
			System.setProperty(Constants.driver_ie, Constants.driverPath_ie);
			driver.set(new InternetExplorerDriver());
			break;
		default:
			System.out.println("Invalid browser name provided.");
		}
		return driver.get();
	}

}
