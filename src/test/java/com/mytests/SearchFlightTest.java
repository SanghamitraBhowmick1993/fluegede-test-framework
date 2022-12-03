package com.mytests;

import java.io.IOException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mypages.FlightOfferDetailsPage;
import com.mypages.SearchFlightPage;
import com.utils.ExtentReport;


public class SearchFlightTest extends BaseTest {
	
	@Test(priority = 1, enabled = true)
	public void verifyLoginPageTitleTest() throws IOException, InterruptedException {
        System.out.println("verifyLoginPageTitleTest() thread name: " + Thread.currentThread().getId());
		String title = page.getInstance(SearchFlightPage.class).getLoginPageTitle();
		System.out.println(title);
		String expectedTitle = "Günstige Flüge online buchen – Flug-Angebote vergleichen | fluege.de";
		if (title.equals(expectedTitle)) {
			ExtentReport.getTest().log(Status.PASS, "page title is verified");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "failed to validate page title: " + " expected value is : "
					+ expectedTitle + " but found " + title);
		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyLoginPageHeaderTest() throws IOException {
        System.out.println("verifyLoginPageHeaderTest() thread name: " + Thread.currentThread().getId());
		String header = page.getInstance(SearchFlightPage.class).getLoginPageHeaader();
		System.out.println(header);
		String expectedHeader = "Registrieren";
		if (header.equals(expectedHeader)) {
			ExtentReport.getTest().log(Status.PASS, "page header is verified");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "failed to validate page header: " + " expected value is : "
					+ expectedHeader + " but found " + header);
		}
	}

	@Test(priority = 1, enabled = true)
	public void enterFlightDetails() throws InterruptedException, IOException {
        System.out.println("enterFlightDetails() thread name: " + Thread.currentThread().getId());
        String title = page.getInstance(SearchFlightPage.class).getLoginPageTitle();
		System.out.println(title);
		String expectedTitle = "Günstige Flüge online buchen – Flug-Angebote vergleichen | fluege.de";
		if (title.equals(expectedTitle)) {
			ExtentReport.getTest().log(Status.PASS, "page title is verified");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "failed to validate page title: " + " expected value is : "
					+ expectedTitle + " but found " + title);
		}
        FlightOfferDetailsPage itenaryPage = page.getInstance(SearchFlightPage.class)
				.enterFlightDetails("Frankfurt (FRA)", "Palma de Mallorca (PMI)", "02.02.2023", "Swiss (LX)");
        String urlval = itenaryPage.getOfferPageUrl();
        String expectedurl = "https://www.fluege.de/flight/encodes/sFlightInput";
        if (urlval.contains(expectedurl)) {
			ExtentReport.getTest().log(Status.PASS, "Offer page landed");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "failed to land offer page: " + " expected value is : "
					+ expectedurl + " but found " + urlval);
		}
        		
		
	}

	}

