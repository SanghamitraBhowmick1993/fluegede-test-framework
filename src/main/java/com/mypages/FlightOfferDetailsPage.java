package com.mypages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightOfferDetailsPage extends BasePage {
	// page locators:
	private By chooseofferradiobtn = By.xpath("//*[@for='segmentSelectOut1-1']");
	private By offerbtnleastprice = By.xpath("(//*[text()='Angebot wählen'])[1]");

	public FlightOfferDetailsPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getChooseofferradiobtn() {
		return getElement(chooseofferradiobtn);

	}

	public WebElement getOfferbtnleastprice() {
		return getElement(offerbtnleastprice);

	}

	public String getOfferPageUrl() {
		System.out.println("current url::: " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public ItenaryDetailsPage selectCheapestOffer() {
		try {
			webdriverwaitforvisibilityOfElement(35,5,chooseofferradiobtn);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			String handle = driver.getWindowHandle();
			System.out.println(handle);
			Set<String> handles = driver.getWindowHandles();
			System.out.println(handles);
			for (String handle1 : driver.getWindowHandles()) {
				System.out.println("both win:: " + handle1);
				if (!handle1.equals(handle)) {
					System.out.println(handle1);
					driver.switchTo().window(handle1);
					Actions action = new Actions(driver);
					action.moveToElement(getChooseofferradiobtn()).click().build().perform();
					webdriverwaitforElementToBeClickable(20,5,offerbtnleastprice);
					WebElement l = driver.findElement(By.xpath("(//*[text()='Angebot wählen'])[1]"));
					executor.executeScript("arguments[0].scrollIntoView(true);", l);
					l.click();
				} else {
					Actions action = new Actions(driver);
					action.moveToElement(getChooseofferradiobtn()).click().build().perform();
					Thread.sleep(2000);
					// selecting cheapest, as prices are sorted in ascending
					try {
					WebElement l = driver.findElement(By.xpath("(//*[text()='Angebot wählen'])[1]"));//					
					new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(l)).click();
				} catch (ElementNotInteractableException ex) {
					try {
						WebElement l = driver.findElement(By.xpath("(//*[text()='Angebot wählen'])[1]"));
						executor.executeScript("arguments[0].scrollIntoView(true);", l);
						l.click();
					}catch(Exception e) {
						driver.findElement(offerbtnleastprice).click();
					}
					}

				}
			}
			//Thread.sleep(25000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getInstance(ItenaryDetailsPage.class);
	}

}
