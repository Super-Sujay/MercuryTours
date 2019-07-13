package com.newtours.elements;

import org.openqa.selenium.WebDriver;

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Text</b> in a Web Page.
 * 
 * @author Sujay Sawant
 * @version 1.0.2
 * @since 05/27/2019
 */
public class Text extends Actions {

	/**
	 * This Constructor is used to create an object to access a <b>Text</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the Text
	 * @param locator : Xpath of the Text
	 */
	public Text(WebDriver driver, String description, String locator) {
		super(driver, description, locator);
	}

}
