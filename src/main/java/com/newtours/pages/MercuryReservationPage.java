package com.newtours.pages;

import com.newtours.base.BaseTest;
import com.newtours.elements.Banner;
import com.newtours.elements.Button;
import com.newtours.elements.DropDown;
import com.newtours.elements.RadioButton;

/**
 * This is the Page Class for the First Reservation page.<br>
 * <b>mercuryreservation.php</b>
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 05/27/2019
 */
public class MercuryReservationPage extends MainWebsitePage {

	public static Banner flightFinderBanner = new Banner(BaseTest.getWebDriver(), "Flight Finder", ".//img[@src='/images/masts/mast_flightfinder.gif']");
	public static RadioButton roundTrip = new RadioButton(BaseTest.getWebDriver(), "Round Trip", ".//input[@value='roundtrip']");
	public static RadioButton oneWay = new RadioButton(BaseTest.getWebDriver(), "One Way", ".//input[@value='oneway']");
	public static DropDown passengers = new DropDown(BaseTest.getWebDriver(), "Passengers", ".//select[@name='passCount']");
	public static DropDown departingFrom = new DropDown(BaseTest.getWebDriver(), "Departing From", ".//select[@name='fromPort']");
	public static DropDown fromMonth = new DropDown(BaseTest.getWebDriver(), "From Month", ".//select[@name='fromMonth']");
	public static DropDown fromDay = new DropDown(BaseTest.getWebDriver(), "From Day", ".//select[@name='fromDay']");
	public static DropDown arrivingIn = new DropDown(BaseTest.getWebDriver(), "Arriving In", ".//select[@name='toPort']");
	public static DropDown toMonth = new DropDown(BaseTest.getWebDriver(), "To Month", ".//select[@name='toMonth']");
	public static DropDown toDay = new DropDown(BaseTest.getWebDriver(), "To Day", ".//select[@name='toDay']");
	public static RadioButton economyClass = new RadioButton(BaseTest.getWebDriver(), "Economy Class", ".//input[@value='Coach']");
	public static RadioButton businessClass = new RadioButton(BaseTest.getWebDriver(), "Business Class", ".//input[@value='Business']");
	public static RadioButton firstClass = new RadioButton(BaseTest.getWebDriver(), "First Class", ".//input[@value='First']");
	public static DropDown airline = new DropDown(BaseTest.getWebDriver(), "Airline", ".//select[@name='airline']");
	public static Button continueNext = new Button(BaseTest.getWebDriver(), "Continue", ".//input[@name='findFlights']");

	/**
	 * This method is used to select the airport, month and data of departure
	 * from the <b>Departure</b> drop downs.
	 * 
	 * @param airport : Airport of departure.
	 * @param month : Month of departure.
	 * @param date : Date of departure.
	 */

	public static void departure(String airport, String month, String date) {
		System.out.println("Select the airport [" + airport + "] for month [" + month + "] and date [" + date
				+ "] from the Departure drop downs.");
		departingFrom.select(airport);
		fromMonth.select(month);
		fromDay.select(date);
	}

	/**
	 * This method is used to select the airport, month and data of arrival from
	 * the <b>Arrival</b> drop down.
	 * 
	 * @param airport : Airport of arrival.
	 * @param month : Month of arrival.
	 * @param date : Date of arrival.
	 */

	public static void arrival(String airport, String month, String date) {
		System.out.println("Select month [" + month + "] and date [" + date + "] from the Returning drop down");
		arrivingIn.select(airport);
		toMonth.select(month);
		toDay.select(date);
	}

}