package com.newtours.pages;

import com.newtours.elements.Alert;
import com.newtours.elements.Banner;
import com.newtours.elements.Hyperlink;
import com.newtours.utilities.BaseTest;

/**
 * This is the Page Class for the main web page.<br>
 * <b>Note:</b> All the Page Classes must extend this Page Class.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 05/27/2019
 */
public class MainWebsitePage {

	public static Banner mercuryToursLogo = new Banner(BaseTest.getWebDriver(), "Mercury Tours", ".//img[@src='/images/nav/logo.gif']");
	public static Hyperlink signOn = new Hyperlink(BaseTest.getWebDriver(), "Sign On", ".//a[@href='mercurysignon.php' and text()='SIGN-ON']");
	public static Hyperlink register = new Hyperlink(BaseTest.getWebDriver(), "Register", ".//a[@href='mercuryregister.php' and text()='REGISTER']");
	public static Hyperlink support = new Hyperlink(BaseTest.getWebDriver(), "Support", ".//a[@href='mercuryunderconst.php' and text()='SUPPORT']");
	public static Hyperlink contact = new Hyperlink(BaseTest.getWebDriver(), "Contact", ".//a[@href='mercuryunderconst.php' and text()='CONTACT']");
	public static Hyperlink home = new Hyperlink(BaseTest.getWebDriver(), "Home", ".//a[@href='mercurywelcome.php' and text()='Home']");
	public static Hyperlink flights = new Hyperlink(BaseTest.getWebDriver(), "Flights", ".//a[@href='mercuryreservation.php' and text()='Flights']");
	public static Hyperlink hotels = new Hyperlink(BaseTest.getWebDriver(), "Hotels", ".//a[@href='mercuryunderconst.php' and text()='Hotels']");
	public static Hyperlink carRentals = new Hyperlink(BaseTest.getWebDriver(), "Car Rentals", ".//a[@href='mercuryunderconst.php' and text()='Car Rentals']");
	public static Hyperlink cruises = new Hyperlink(BaseTest.getWebDriver(), "Cruises", ".//a[@href='mercurycruise.php' and text()='Cruises']");
	public static Hyperlink destinations = new Hyperlink(BaseTest.getWebDriver(), "Destinations", ".//a[@href='mercuryunderconst.php' and text()='Destinations']");
	public static Hyperlink vacations = new Hyperlink(BaseTest.getWebDriver(), "Vacations", ".//a[@href='mercuryunderconst.php' and text()='Vacations']");
	public static Hyperlink signOff = new Hyperlink(BaseTest.getWebDriver(), "Sign Off", ".//a[@href='mercurysignoff.php' and text()='SIGN-OFF']");
	public static Hyperlink itinerary = new Hyperlink(BaseTest.getWebDriver(), "Itinerary", ".//a[@href='mercuryitinerary.php' and text()='ITINERARY']");
	public static Hyperlink profile = new Hyperlink(BaseTest.getWebDriver(), "Profile", ".//a[@href='mercuryprofile.php' and text()='PROFILE']");
	public static Alert alert = new Alert(BaseTest.getWebDriver());
	
	/**
	 * This method is used to <b>Sign-Off</b> from the web site.
	 */
	public static void signOff() {
		signOff.click();
	}

}
