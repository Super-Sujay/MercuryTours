package com.newtours.pages;

import com.newtours.base.BaseTest;
import com.newtours.elements.Banner;
import com.newtours.elements.Button;
import com.newtours.elements.Text;

/**
 * This is the Page Class for the Second Purchase page.<br>
 * <b>mercurypurchase2.php</b>
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 05/27/2019
 */
public class MercuryPurchase2Page extends MainWebsitePage {

	public static Banner flightConfirmationBanner = new Banner(BaseTest.getWebDriver(), "Flight Confirmation", ".//img[@src='/images/masts/mast_confirmation.gif']");
	public static Text totalPrice = new Text(BaseTest.getWebDriver(), "Total Price", ".//font[contains(text(),'Price')]//following::font[4]");
	public static Button backToFlights = new Button(BaseTest.getWebDriver(), "Back To Flights", ".//a[@href='mercuryreservation.php']/img");
	public static Button backToHome = new Button(BaseTest.getWebDriver(), "Back To Home", ".//a[@href='mercurywelcome.php']/img");
	public static Button logOut = new Button(BaseTest.getWebDriver(), "Log Out", ".//a[@href='mercurysignoff.php']/img");

}
