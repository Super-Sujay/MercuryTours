package com.newtours.utilities;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.Reporter;

/**
 * This Class is used to take <b>Screenshot</b> at the current page.
 * 
 * @author Sujay Sawant
 * @version 1.0.2
 * @since 05/27/2019
 */
public class ScreenShot {

	/**
	 * This method is used to take <b>Screenshot</b> of the current page.
	 * 
	 * @param driver : WebDriver object
	 */
	public static void takeScreenShot() {

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		String fileName = "ScreenShot_" + datePattern.format(dateTime) + ".jpg";
		TakesScreenshot scr = (TakesScreenshot) BaseTest.getWebDriver();
		File screenShot = scr.getScreenshotAs(OutputType.FILE);
		File screenShotdestination = new File(Constants.screenShotDestination + fileName);
		try {
			System.out.println("Screen shot at " + Constants.screenShotDestination);
			Reporter.log("Screen shot at " + Constants.screenShotDestination + "<br>");
			FileUtils.copyFile(screenShot, screenShotdestination);
		} catch (IOException e) {
			System.out.println("Unable to take screen shot");
			Reporter.log("Unable to take screen shot<br>");
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to take <b>Screenshot</b> of the current page.
	 * 
	 * @param driver : WebDriver object
	 * @param name : Screenshot file name
	 */
	public static void takeScreenShot(String name) {

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		String fileName = "ScreenShot of " + name + "_" + datePattern.format(dateTime) + ".jpg";
		TakesScreenshot scr = (TakesScreenshot) BaseTest.getWebDriver();
		File screenShot = scr.getScreenshotAs(OutputType.FILE);
		File screenShotdestination = new File(Constants.screenShotDestination + fileName);
		try {
			System.out.println("Screen shot at " + Constants.screenShotDestination);
			Reporter.log("Screen shot at " + Constants.screenShotDestination + "<br>");
			FileUtils.copyFile(screenShot, screenShotdestination);
		} catch (IOException e) {
			System.out.println("Unable to take screen shot");
			Reporter.log("Unable to take screen shot<br>");
			e.printStackTrace();
		}

	}

}