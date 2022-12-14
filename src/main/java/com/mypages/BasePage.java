package com.mypages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTite() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("some error occured while creating element " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}
	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
			return element;
		} catch (Exception e) {
			System.out.println("some error occured while creating element " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
			System.out.println("some error/expection occured while waiting for the element " + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("some error/expection occured while waiting for the element " + title);
			e.printStackTrace();
		}
	}
	@Override
	public void webdriverwaitforvisibilityOfElement(int seconds, int polling, By locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
					  .withTimeout(Duration.ofSeconds(seconds)) 
					  .pollingEvery(Duration.ofSeconds(polling)) 
					  .ignoring(NoSuchElementException.class); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("some error/expection occured while waiting for the element " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void webdriverwaitforElementToBeClickable(int seconds, int polling, By locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
					  .withTimeout(Duration.ofSeconds(seconds)) 
					  .pollingEvery(Duration.ofSeconds(polling)) 
					  .ignoring(NoSuchElementException.class); 
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out.println("some error/expection occured while clicking the element " + e.getMessage());
			e.printStackTrace();
		}
	}

}
