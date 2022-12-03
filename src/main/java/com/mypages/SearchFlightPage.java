/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author sangb
 *
 */
public class SearchFlightPage extends BasePage {
	// page locators:
	private By header = By.xpath("//*[@title='Registrieren']");
	private By departure = By.id("f0-dep-location-");
	private By destination = By.id("f0-arr-location-");
	private By outboundflight = By.xpath("//*[@for='OW']");
	private By outboundcalenderdateclick = By.id("f0Date");
	private By cookieid = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
	private By airlinedropdown = By.xpath("//*[text()='1 Reisender, Economy, egal']");
	private By addingadult = By.xpath("(//*[@id='adultSelector']//parent::*//child::button)[2]");
	private By airlineselection = By.id("depAirline");
	private By searchflight = By.id("submit");
	private By selectdeptflight = By.xpath("//li[@class='item highlighted ui-menu-item']");

	// Swiss (LX)

	public SearchFlightPage(WebDriver driver) {
		super(driver);
	}

	// public getters:

	/**
	 * @return the DepartureInput
	 */
	public WebElement getDepartureInput() {
		return getElement(departure);
	}

	/**
	 * @return the DestinationInput
	 */
	public WebElement getDestinationInput() {
		return getElement(destination);
	}

	/**
	 * @return the outboundflight
	 */
	public WebElement getoutboundflight() {
		return getElement(outboundflight);

	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return getElement(header).getText();
	}

	public WebElement getOutboundcalenderdateclick() {
		return getElement(outboundcalenderdateclick);

	}

	public WebElement getAirlinedropdown() {
		return getElement(airlinedropdown);

	}

	public WebElement getAddingadult() {
		return getElement(addingadult);

	}

	public WebElement getAirlineSelection() {
		return getElement(airlineselection);

	}

	public WebElement getSearchflight() {
		return getElement(searchflight);

	}

	public String getLoginPageTitle() throws InterruptedException {
		waitForElementPresent(cookieid);
		getElement(cookieid).click();
		return getPageTite();
	}

	public String getLoginPageHeaader() {
		waitForElementPresent(cookieid);
		return getPageHeader(header);
	}

	public FlightOfferDetailsPage enterFlightDetails(String deptflight, String destflight, String outbounddate,
			String airline) throws InterruptedException {
		waitForElementPresent(outboundflight);
		getoutboundflight().click();
		webdriverwaitforvisibilityOfElement(20, 5, departure);
		getDepartureInput().sendKeys(deptflight);
		webdriverwaitforElementToBeClickable(20, 5, selectdeptflight);
		getElement(selectdeptflight).click();
		webdriverwaitforvisibilityOfElement(20, 5, destination);
		getDestinationInput().sendKeys(destflight);
		webdriverwaitforElementToBeClickable(20, 5, outboundcalenderdateclick);
		getOutboundcalenderdateclick().click();
		getOutboundcalenderdateclick().clear();
		getOutboundcalenderdateclick().sendKeys(outbounddate);
		webdriverwaitforElementToBeClickable(20, 5, airlinedropdown);
		getAirlinedropdown().click();
		webdriverwaitforElementToBeClickable(20, 5, addingadult);
		getAddingadult().click();
		webdriverwaitforElementToBeClickable(20, 5, airlineselection);
		getAirlineSelection().click();
		webdriverwaitforElementToBeClickable(20, 5, searchflight);
		Select select = new Select(getAirlineSelection());
		select.selectByVisibleText(airline);
		getSearchflight().click();
		return getInstance(FlightOfferDetailsPage.class);
	}

}
