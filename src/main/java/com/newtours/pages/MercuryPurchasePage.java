package com.newtours.pages;

import com.newtours.base.BaseTest;
import com.newtours.elements.Banner;
import com.newtours.elements.Button;
import com.newtours.elements.CheckBox;
import com.newtours.elements.DropDown;
import com.newtours.elements.Text;
import com.newtours.elements.Textbox;

/**
 * This is the Page Class for the First Purchase page.<br>
 * <b>mercurypurchase.php</b>
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 05/27/2019
 */
public class MercuryPurchasePage extends MainWebsitePage {

	public static Banner bookAFlightBanner = new Banner(BaseTest.getWebDriver(), "Book A Flight", ".//img[@src='/images/masts/mast_book.gif']");
	public static Text totalPrice = new Text(BaseTest.getWebDriver(), "Total Price", ".//b[contains(text(),'$')]");
	public static Textbox passengersFirstName1 = new Textbox(BaseTest.getWebDriver(), "Passengers First Name 1", ".//input[@name='passFirst0']");
	public static Textbox passengersLastName1 = new Textbox(BaseTest.getWebDriver(), "Passengers Last Name 1", ".//input[@name='passLast0']");
	public static DropDown passengersMeal1 = new DropDown(BaseTest.getWebDriver(), "Passengers Meal 1", ".//select[@name='pass.0.meal']");
	public static Textbox passengersFirstName2 = new Textbox(BaseTest.getWebDriver(), "Passengers First Name 2", ".//input[@name='passFirst1']");
	public static Textbox passengersLastName2 = new Textbox(BaseTest.getWebDriver(), "Passengers Last Name 2", ".//input[@name='passLast1']");
	public static DropDown passengersMeal2 = new DropDown(BaseTest.getWebDriver(), "Passengers Meal 2", ".//select[@name='pass.1.meal']");
	public static Textbox passengersFirstName3 = new Textbox(BaseTest.getWebDriver(), "Passengers First Name 3", ".//input[@name='passFirst2']");
	public static Textbox passengersLastName3 = new Textbox(BaseTest.getWebDriver(), "Passengers Last Name 3", ".//input[@name='passLast2']");
	public static DropDown passengersMeal3 = new DropDown(BaseTest.getWebDriver(), "Passengers Meal 3", ".//select[@name='pass.2.meal']");
	public static Textbox passengersFirstName4 = new Textbox(BaseTest.getWebDriver(), "Passengers First Name 4", ".//input[@name='passFirst3']");
	public static Textbox passengersLastName4 = new Textbox(BaseTest.getWebDriver(), "Passengers Last Name 4", ".//input[@name='passLast3']");
	public static DropDown passengersMeal4 = new DropDown(BaseTest.getWebDriver(), "Passengers Meal 4", ".//select[@name='pass.3.meal']");
	public static DropDown creditCardType = new DropDown(BaseTest.getWebDriver(), "Credit Card Type", ".//select[@name='creditCard']");
	public static Textbox creditCardNumber = new Textbox(BaseTest.getWebDriver(), "Credit Card Number", ".//input[@name='creditnumber']");
	public static DropDown creditCardExpirationMonth = new DropDown(BaseTest.getWebDriver(), "Credit Card Expiration Month", ".//select[@name='cc_exp_dt_mn']");
	public static DropDown creditCardExpirationYear = new DropDown(BaseTest.getWebDriver(), "Credit Card Expiration Year", ".//select[@name='cc_exp_dt_yr']");
	public static Textbox creditCardFirstName = new Textbox(BaseTest.getWebDriver(), "Credit Card First Name", ".//input[@name='cc_frst_name']");
	public static Textbox creditCardMiddleName = new Textbox(BaseTest.getWebDriver(), "Credit Card Middle Name", ".//input[@name='cc_mid_name']");
	public static Textbox creditCardLastName = new Textbox(BaseTest.getWebDriver(), "Credit Card Last Name", ".//input[@name='cc_last_name']");
	public static CheckBox ticketlessTravel = new CheckBox(BaseTest.getWebDriver(), "Ticketless Travel", ".//font[contains(text(),'Ticketless Travel')]//preceding-sibling::input");
	public static Textbox billingAddress1 = new Textbox(BaseTest.getWebDriver(), "Billing Address 1", ".//input[@name='billAddress1']");
	public static Textbox billingAddress2 = new Textbox(BaseTest.getWebDriver(), "Billing Address 2", ".//input[@name='billAddress2']");
	public static Textbox billingCity = new Textbox(BaseTest.getWebDriver(), "Billing City", ".//input[@name='billCity']");
	public static Textbox billingState = new Textbox(BaseTest.getWebDriver(), "Billing State", ".//input[@name='billState']");
	public static Textbox billingPostalCode = new Textbox(BaseTest.getWebDriver(), "Billing Postal Code", ".//input[@name='billZip']");
	public static DropDown billingCountry = new DropDown(BaseTest.getWebDriver(), "Billing Country", ".//select[@name='billCountry']");
	public static CheckBox sameAsBillingAddress = new CheckBox(BaseTest.getWebDriver(), "Same As Billing Address", ".//font[contains(text(),'Same as Billing Address')]//preceding-sibling::input");
	public static Textbox deliveryAddress1 = new Textbox(BaseTest.getWebDriver(), "Delivery Address 1", ".//input[@name='delAddress1']");
	public static Textbox deliveryAddress2 = new Textbox(BaseTest.getWebDriver(), "Delivery Address 2", ".//input[@name='delAddress2']");
	public static Textbox deliveryCity = new Textbox(BaseTest.getWebDriver(), "Delivery City", ".//input[@name='delCity']");
	public static Textbox deliveryState = new Textbox(BaseTest.getWebDriver(), "Delivery State", ".//input[@name='delState']");
	public static Textbox deliveryPostalCode = new Textbox(BaseTest.getWebDriver(), "Delivery Postal Code", ".//input[@name='delZip']");
	public static DropDown deliveryCountry = new DropDown(BaseTest.getWebDriver(), "Delivery Country", ".//select[@name='delCountry']");
	public static Button securePurchase = new Button(BaseTest.getWebDriver(), "Secure Purchase", ".//input[@name='buyFlights']");

	/**
	 * This method is used to enter details of the first passenger in
	 * <b>Passengers</b> section.
	 * 
	 * @param firstName : First Name.
	 * @param lastName : Last Name.
	 * @param mealType : Meal Type.
	 */
	public static void enterPassengerDetails1(String firstName, String lastName, String mealType) {
		passengersFirstName1.sendKeys(firstName);
		passengersLastName1.sendKeys(lastName);
		passengersMeal1.select(mealType);
	}

	/**
	 * This method is used to enter details of the second passenger in
	 * <b>Passengers</b> section.
	 * 
	 * @param firstName : First Name.
	 * @param lastName : Last Name.
	 * @param mealType : Meal Type.
	 */
	public static void enterPassengerDetails2(String firstName, String lastName, String mealType) {
		passengersFirstName2.sendKeys(firstName);
		passengersLastName2.sendKeys(lastName);
		passengersMeal2.select(mealType);
	}

	/**
	 * This method is used to enter details of the third passenger in
	 * <b>Passengers</b> section.
	 * 
	 * @param firstName : First Name
	 * @param lastName : Last Name
	 * @param mealType : Meal Type
	 */
	public static void enterPassengerDetails3(String firstName, String lastName, String mealType) {
		passengersFirstName3.sendKeys(firstName);
		passengersLastName3.sendKeys(lastName);
		passengersMeal3.select(mealType);
	}

	/**
	 * This method is used to enter details of the fourth passenger in
	 * <b>Passengers</b> section.
	 * 
	 * @param firstName : First Name
	 * @param lastName : Last Name
	 * @param mealType : Meal Type
	 */
	public static void enterPassengerDetails4(String firstName, String lastName, String mealType) {
		passengersFirstName4.sendKeys(firstName);
		passengersLastName4.sendKeys(lastName);
		passengersMeal4.select(mealType);
	}

	/**
	 * This method is used to enter <b>Credit Card Details</b>.
	 * 
	 * @param cardType : Type of the card used
	 * @param number : Card Number
	 * @param expirationMonth : Month of the expiration of the Card
	 * @param expirationYear : Year of the expiration of the Card
	 * @param firstName : First Name of the Card Holder
	 * @param middleName : Middle Name of the Card Holder
	 * @param lastName : Last Name of the Card Holder
	 */
	public static void enterCreditCardDetails(String cardType, String number, String expirationMonth, String expirationYear, String firstName , String middleName, String lastName) {
		creditCardType.select(cardType);
		creditCardNumber.sendKeys(number);
		creditCardExpirationMonth.select(expirationMonth);
		creditCardExpirationYear.select(expirationYear);
		creditCardFirstName.sendKeys(firstName);
		creditCardMiddleName.sendKeys(middleName);
		creditCardLastName.sendKeys(lastName);
	}

	/**
	 * This method is used to enter Billing Address of the passenger in
	 * <b>Address</b> text box.
	 * 
	 * @param addressLine1 : First Address Line of the Billing Address of the passenger
	 * @param addressLine2 : Second Address Line of the Billing Address of the passenger
	 * @param city : Billing City of the passenger
	 * @param state : Billing State of the passenger
	 * @param postalCode : Billing Postal Code of the passenger
	 * @param country : Billing Country of the passenger
	 */
	public static void enterBillingAddress(String addressLine1, String addressLine2, String city, String state,
			String postalCode, String country) {
		System.out.println("Enter [" + addressLine1 + "] in Address Line 1 and [" + addressLine2
				+ "] in Address Line 2 in the Billing Address. Enter [" + city + "] in Billing City Text Box. Enter ["
				+ state + "] in Billing State Text Box. Enter [" + postalCode
				+ "] in Billing Postal Code Text Box. Select [" + country + "] from Billing Country Drop Down.");
		billingAddress1.sendKeys(addressLine1);
		billingAddress2.sendKeys(addressLine2);
		billingCity.sendKeys(city);
		billingState.sendKeys(state);
		billingPostalCode.sendKeys(postalCode);
		billingCountry.select(country);
	}

	/**
	 * This method is used to enter Delivery Address of the passenger in
	 * <b>Address</b> text box.
	 * 
	 * @param addressLine1 : First Address Line of the Delivery Address of the passenger
	 * @param addressLine2 : Second Address Line of the Delivery Address of the passenger
	 * @param city : Delivery City of the passenger
	 * @param state : Delivery State of the passenger
	 * @param postalCode : Delivery Postal Code of the passenger
	 * @param country : Delivery Country of the passenger
	 */
	public static void enterDeliveryAddress(String addressLine1, String addressLine2, String city, String state,
			String postalCode, String country) {
		System.out.println("Enter [" + addressLine1 + "] in Address Line 1 and [" + addressLine2
				+ "] in Address Line 2 in the Billing Address. Enter [" + city + "] in Delivery City Text Box. Enter ["
				+ state + "] in Delivery State Text Box. Enter [" + postalCode
				+ "] in Delivery Postal Code Text Box. Select [" + country + "] from Delivery Country Drop Down.");
		deliveryAddress1.sendKeys(addressLine1);
		deliveryAddress2.sendKeys(addressLine2);
		deliveryCity.sendKeys(city);
		deliveryState.sendKeys(state);
		deliveryPostalCode.sendKeys(postalCode);
		deliveryCountry.select(country);
	}

}