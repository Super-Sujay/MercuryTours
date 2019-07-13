package com.newtours.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * This is the Class for all the actions we perform on the Web Elements.<br>
 * <b>Note:</b> All the Element Classes must extend this Class.
 * 
 * @author Sujay Sawant
 * @version 1.0.2
 * @since 05/27/2019
 */
public class Actions {

	WebDriver driver;
	String description;
	String locator;

	/**
	 * This Constructor is used to initialize the element.
	 * 
	 * @param driver : WebDriver object
	 */
	public Actions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This Constructor is used to initialize the element.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the element
	 * @param locator : Xpath of the element
	 */
	public Actions(WebDriver driver, String description, String locator) {
		this.driver = driver;
		this.description = description;
		this.locator = locator;
	}

	/**
	 * This method is used to <b>Click</b> on a Web Element.
	 */
	public void click() {
		try {
			System.out.println("Click on " + description);
			Reporter.log("Click on " + description + "<br>");
			driver.findElement(By.xpath(locator)).click();
		} catch (Exception e) {
			System.out.println("Unable to click on " + description);
			Reporter.log("Unable to click on " + description + "<br>");
			ScreenShot.takeScreenShot("Failure");
			Assert.assertTrue(false);
		}
	}

	/**
	 * This method is used to <b>Send Text</b> in a Text Box.
	 * 
	 * @param text : Text to be sent
	 */
	public void sendKeys(String text) {
		try {
			if (description.contains("Password")) {
				System.out.println("Enter text [*********] in " + description);
				Reporter.log("Enter text [*********] in " + description + "<br>");
				driver.findElement(By.xpath(locator)).clear();
				driver.findElement(By.xpath(locator)).sendKeys(text);
			} else {
				System.out.println("Enter text [" + text + "] in " + description);
				Reporter.log("Enter text [" + text + "] in " + description + "<br>");
				driver.findElement(By.xpath(locator)).clear();
				driver.findElement(By.xpath(locator)).sendKeys(text);
			}
		} catch (Exception e) {
			System.out.println("Unable to send text [" + text + "] in " + description);
			Reporter.log("Unable to send text [" + text + "] in " + description + "<br>");
			ScreenShot.takeScreenShot("Failure");
			Assert.assertTrue(false);
		}
	}

	/**
	 * This method is used to <b>Select Text</b> from the Drop Down.
	 * 
	 * @param text : Text to be selected
	 */
	public void select(String text) {
		try {
			System.out.println("Select [" + text + "] from the " + description);
			Reporter.log("Select [" + text + "] from the " + description + "<br>");
			Select select = new Select(driver.findElement(By.xpath(locator)));
			select.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println("Unable to select [" + text + "] from the " + description);
			Reporter.log("Unable to select [" + text + "] from the " + description + "<br>");
			ScreenShot.takeScreenShot("Failure");
			Assert.assertTrue(false);
		}
	}

	/**
	 * This method is used to <b>Check</b> or <b>Uncheck</b> a Check Box.
	 * 
	 * @param condition : true to check, false to uncheck
	 */
	public void check(boolean condition) {
		try {
			if (condition) {
				System.out.println("Check " + description);
				Reporter.log("Check " + description + "<br>");
				if (!driver.findElement(By.xpath(locator)).isSelected())
					driver.findElement(By.xpath(locator)).click();
			} else {
				System.out.println("Uncheck " + description);
				Reporter.log("Uncheck " + description + "<br>");
				if (driver.findElement(By.xpath(locator)).isSelected()) {
					driver.findElement(By.xpath(locator)).click();
				}
			}
		} catch (Exception e) {
			System.out.println("Unable to check or uncheck " + description);
			Reporter.log("Unable to check or uncheck " + description + "<br>");
			ScreenShot.takeScreenShot("Failure");
			Assert.assertTrue(false);
		}
	}

	/**
	 * This method is used to get <b>Text</b> from the Web Page.
	 * 
	 * @return The text
	 */
	public String getText() {
		try {
			return driver.findElement(By.xpath(locator)).getText();
		} catch (Exception e) {
			System.out.println("Unable to get the text of " + description);
			Reporter.log("Unable to get the text of " + description + "<br>");
			ScreenShot.takeScreenShot("Failure");
			Assert.assertTrue(false);
			return null;
		}
	}

	/**
	 * This method is used to handle <b>Alerts</b>.
	 * 
	 * @param condition : True to accept, false to dismiss
	 * 
	 * @param description : Description of the alert
	 */
	public void accept(String description, boolean condition) {
		try {
			if (condition) {
				System.out.println("Alert [" + description + "] appeared with message [" + driver.switchTo().alert().getText() + "]");
				Reporter.log("Alert [" + description + "] appeared with message [" + driver.switchTo().alert().getText() + "]<br>");
				System.out.println("Accept the alert");
				driver.switchTo().alert().accept();
			} else {
				System.out.println("Alert [" + description + "] appeared with message [" + driver.switchTo().alert().getText() + "]");
				Reporter.log("Alert [" + description + "] appeared with message [" + driver.switchTo().alert().getText() + "]<br>");
				System.out.println("Dismiss the alert");
				driver.switchTo().alert().dismiss();
			}
		} catch (NoAlertPresentException e) {
			System.out.println("Alert [" + description + "] did not appear");
			Reporter.log("Alert [" + description + "] did not appear<br>");
		} catch (Exception e) {
			System.out.println("Issue with the Alert");
			Reporter.log("Issue with the Alert<br>");
			ScreenShot.takeScreenShot("Failure");
			Assert.assertTrue(false);
		}
	}
	
	/**
	 * This method is used to check whether the element is <b>present</b> or not on the web page.
	 * 
	 * @return true if element is present, false if element is not present
	 */
	public boolean isPresent() {
		try{
			System.out.println("Check " + description + " is present");
			Reporter.log("Check " + description + " is present<br>");
			driver.findElement(By.xpath(locator)).isDisplayed();
			System.out.println(description + " is present");
			Reporter.log(description + " is present<br>");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(description + " is not present");
			Reporter.log(description + " is not present<br>");
			ScreenShot.takeScreenShot("Failure");
			return false;
		} catch (Exception e) {
			System.out.println("Issue with the isPresent Method");
			Reporter.log("Issue with the isPresent Method<br>");
			ScreenShot.takeScreenShot("Failure");
			Assert.assertTrue(false);
			return false;
		}
	}
}