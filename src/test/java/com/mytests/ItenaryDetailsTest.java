package com.mytests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mypages.FlightOfferDetailsPage;
import com.mypages.ItenaryDetailsPage;
import com.mypages.SearchFlightPage;
import com.utils.ExtentReport;

public class ItenaryDetailsTest extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void verifyFlightOfferDetailsScreen() throws IOException, InterruptedException {
		System.out.println("verifyLoginPageTitleTest() thread name: " + Thread.currentThread().getId());
		page.getInstance(SearchFlightPage.class).getLoginPageTitle();
		page.getInstance(SearchFlightPage.class).enterFlightDetails("Frankfurt (FRA)", "Palma de Mallorca (PMI)",
				"02.02.2023", "Swiss (LX)");
		ItenaryDetailsPage itenaryPage = page.getInstance(FlightOfferDetailsPage.class).selectCheapestOffer();
		String urlval = itenaryPage.getItenaryPageUrl();
		String expectedurl = "https://www.fluege.de/flight/itinerary/sFlightInput";
		if (urlval.contains(expectedurl)) {
			ExtentReport.getTest().log(Status.PASS, "ItenaryDetailsPage landed");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "failed to land ItenaryDetails page: " + " expected value is : "
					+ expectedurl + " but found " + urlval);
		}

		page.getInstance(ItenaryDetailsPage.class).fillApplicantForm("Frau", "Tina", "Meyer", "11.10.1986",
				"Teststrasse", "11", "00000", "Teststadt", "tina.meyer@gmx.gov", "tina.meyer@gmx.gov", "0341",
				"23456789");
		page.getInstance(ItenaryDetailsPage.class).clickForFexibleBooking("Ja");
		page.getInstance(ItenaryDetailsPage.class).fillInformationAboutTraveller("Herr", "Wolfang", "Meyer",
				"18.09.1985", "Ja");
		page.getInstance(ItenaryDetailsPage.class).selectMasterCard("fluege.de Mastercard GOLD");
		boolean reservationvalue = page.getInstance(ItenaryDetailsPage.class).verifyReservationButton();
		if (reservationvalue) {
			ExtentReport.getTest().log(Status.PASS, "Reservation Option is available");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "failed to find Reservation Option");
		}

	}

}
