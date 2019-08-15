package com.newtours.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.newtours.utilities.BrowserDriverFactory;

@Listeners(com.newtours.utilities.MyListners.class)

/**
 * This Class contains all the essential methods for a Test Class.<br>
 * <b>Note:</b> All the Test Classes must extend this Page Class.
 * 
 * @author Sujay Sawant
 * @version 1.0.2
 * @since 05/27/2019
 */
public class BaseTest {

	protected static WebDriver driver;
	protected Map<String, String> testConfig = new HashMap<String, String>();

	/**
	 * This method will run at the start of the suite execution.
	 */
	@BeforeSuite(alwaysRun = true)
	@Parameters("browser")
	public void before(@Optional("chrome") String browser) {
		System.out.println("Setting up driver: [" + browser + "]");
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		testConfig.put("browser", browser);
	}

	/**
	 * This method will run at the end of the suite execution
	 */
	@AfterSuite(alwaysRun = true)
	public void after() {
		System.out.println("Closing [driver]");
		driver.quit();
	}

	/**
	 * This method is used to get a new WebDriver instance.
	 * 
	 * @return WebDriver object
	 */
	public static WebDriver getWebDriver() {
		return driver;
	}

}
