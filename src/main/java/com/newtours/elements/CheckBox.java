package com.newtours.elements;

import org.openqa.selenium.WebDriver;

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Check Box</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.2
 * @since 05/27/2019
 */
public class CheckBox extends Actions {

	/**
	 * This Constructor is used to create an object to access a <b>CheckBox</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the CheckBox
	 * @param locator : Xpath of the CheckBox
	 */
	public CheckBox(WebDriver driver, String description, String locator) {
		super(driver, "[" + description + "] check box", locator);
	}

}
