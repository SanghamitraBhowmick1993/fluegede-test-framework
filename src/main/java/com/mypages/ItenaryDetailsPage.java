package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ItenaryDetailsPage extends BasePage {
	private By enterSalutationfield = By.id("ibeBookingInput_customer_title");
	private By enterfName = By.id("ibeBookingInput_customer_firstName");
	private By enterlName = By.id("ibeBookingInput_customer_lastName");
	private By enterdateofbir = By.id("customerBirthdayMonth");
	private By enterstreet = By.id("ibeBookingInput_customer_street");
	private By enterstreetNumber = By.id("ibeBookingInput_customer_streetNumber");
	private By enterpostalCode = By.id("ibeBookingInput_customer_zipCode");
	private By entercity = By.id("ibeBookingInput_customer_city");
	private By enteremail = By.id("ibeBookingInput_customer_email");
	private By confirmemail = By.id("ibeBookingInput_customer_email_check");
	private By enterphonePrefix = By.id("ibeBookingInput_customer_telPrivateAreaCode");
	private By enterphoneNumber = By.id("customerPhonePrivate");
	private By flexiblebooking = By.id("rebookingServiceOption");
	private By takeoverData = By.xpath("//*[@for='customerDataIsTravellerData']");
	private By enterfNameTravllr2 = By.id("ibeBooking_paxFirstName_2");
	private By enterlNameTravllr2 = By.id("ibeBooking_paxLastName_2");
	private By enterdateofbirTravllr2 = By.id("travellerBirthdayDayADT_key_2");
	private By insaurancedetails = By.id("insuranceService");
	private By masterCard = By.id("payment-filter-dropdown");
	private By reservationBtn = By.xpath("//*[@title='Reservieren & weiter zum nächsten Schritt']");

	Actions actions = new Actions(driver);

	public ItenaryDetailsPage(WebDriver driver) {
		super(driver);
	}

	public String getItenaryPageUrl() {
		webdriverwaitforvisibilityOfElement(35, 5, enterSalutationfield);
		System.out.println("current url " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public WebElement enterSalutation() {
		return getElement(enterSalutationfield);

	}

	public WebElement enterFirstName() {
		return getElement(enterfName);

	}

	public WebElement enterLastName() {
		return getElement(enterlName);

	}

	public WebElement enterDateOfBirth() {
		return getElement(enterdateofbir);

	}

	public WebElement enterStreet() {
		return getElement(enterstreet);

	}

	public WebElement enterStreetNumber() {
		return getElement(enterstreetNumber);

	}

	public WebElement enterPostalCode() {
		return getElement(enterpostalCode);

	}

	public WebElement enterCity() {
		return getElement(entercity);

	}

	public WebElement enterEmail() {
		return getElement(enteremail);

	}

	public WebElement confirmEmail() {
		return getElement(confirmemail);

	}

	public WebElement enterPhonePrefix() {
		return getElement(enterphonePrefix);

	}

	public WebElement enterPhoneNumber() {
		return getElement(enterphoneNumber);

	}

	public WebElement getFlexibleBooking() {
		return getElement(flexiblebooking);

	}

	public WebElement getInformationTakeOverData() {
		return getElement(takeoverData);
	}

	public WebElement enterFirstNameTravllr2() {
		return getElement(enterfNameTravllr2);

	}

	public WebElement enterLastNameTravllr2() {
		return getElement(enterlNameTravllr2);

	}

	public WebElement enterDateOfBirthTravllr2() {
		return getElement(enterdateofbirTravllr2);

	}

	public WebElement getInsauranceDetails() {
		return getElement(insaurancedetails);

	}

	public WebElement getMasterCard() {
		return getElement(masterCard);

	}

	public WebElement getReservationBtn() {
		return getElement(reservationBtn);

	}

	public void fillApplicantForm(String salutation, String fname, String lname, String dob, String street,
			String streetnum, String postalcode, String city, String email, String confirmeMail, String phoneprefix,
			String phonenum) throws InterruptedException {
		webdriverwaitforvisibilityOfElement(20, 5, enterfName);
		actions.moveToElement(driver.findElement(enterSalutationfield));
		Select select = new Select(enterSalutation());
		select.selectByVisibleText(salutation);
		webdriverwaitforvisibilityOfElement(20, 5, enterfName);
		enterFirstName().sendKeys(fname);
		webdriverwaitforvisibilityOfElement(20, 5, enterlName);
		enterLastName().sendKeys(lname);
		webdriverwaitforvisibilityOfElement(20, 5, enterdateofbir);
		enterDateOfBirth().sendKeys(dob);
		webdriverwaitforvisibilityOfElement(20, 5, enterstreet);
		enterStreet().sendKeys(street);
		webdriverwaitforvisibilityOfElement(20, 5, enterstreetNumber);
		enterStreetNumber().sendKeys(streetnum);
		webdriverwaitforvisibilityOfElement(20, 5, enterpostalCode);
		enterPostalCode().sendKeys(postalcode);
		webdriverwaitforvisibilityOfElement(20, 5, entercity);
		enterCity().sendKeys(city);
		webdriverwaitforvisibilityOfElement(20, 5, enteremail);
		enterEmail().sendKeys(email);
		webdriverwaitforvisibilityOfElement(20, 5, confirmemail);
		confirmEmail().sendKeys(confirmeMail);
		webdriverwaitforvisibilityOfElement(20, 5, enterphonePrefix);
		enterPhonePrefix().sendKeys(phoneprefix);
		webdriverwaitforvisibilityOfElement(20, 5, enterphoneNumber);
		enterPhoneNumber().sendKeys(phonenum);
	}

	public void clickForFexibleBooking(String flexiValue) {
		Select select = new Select(getFlexibleBooking());
		select.selectByVisibleText(flexiValue);
	}

	public void fillInformationAboutTraveller(String salutation, String fname, String lname, String dateofbirth,
			String insaurance) throws InterruptedException {
		getInformationTakeOverData().click();
		actions.moveToElement(driver.findElement(enterSalutationfield));
		Select select = new Select(enterSalutation());
		select.selectByVisibleText(salutation);
		webdriverwaitforvisibilityOfElement(20, 5, enterfNameTravllr2);
		enterFirstNameTravllr2().sendKeys(fname);
		webdriverwaitforvisibilityOfElement(20, 5, enterlNameTravllr2);
		enterLastNameTravllr2().sendKeys(lname);
		webdriverwaitforvisibilityOfElement(20, 5, enterphoneNumber);
		enterDateOfBirthTravllr2().sendKeys(dateofbirth);
		webdriverwaitforvisibilityOfElement(20, 5, enterdateofbirTravllr2);
		Select select1 = new Select(getInsauranceDetails());
		select1.selectByVisibleText(insaurance);
	}

	public void selectMasterCard(String cardValue) {
		Select select = new Select(getMasterCard());
		select.selectByVisibleText(cardValue);
	}

	public boolean verifyReservationButton() {
		return getReservationBtn().isDisplayed();
	}

}
