package com.mytests;

import java.io.IOException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mypages.FlightOfferDetailsPage;
import com.mypages.ItenaryDetailsPage;
import com.mypages.SearchFlightPage;
import com.utils.ExtentReport;

public class FlightOfferDetailsTest extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void verifyFlightOfferDetailsScreen() throws IOException, InterruptedException {
		System.out.println("verifyLoginPageTitleTest() thread name: " + Thread.currentThread().getId());
		page.getInstance(SearchFlightPage.class).getLoginPageTitle();
		page.getInstance(SearchFlightPage.class)
		.enterFlightDetails("Frankfurt (FRA)", "Palma de Mallorca (PMI)", "02.02.2023", "Swiss (LX)");
		ItenaryDetailsPage itenaryPage = page.getInstance(FlightOfferDetailsPage.class).selectCheapestOffer();
		String urlval = itenaryPage.getItenaryPageUrl();
		String expectedurl = "sFlightInput";
		if (urlval.contains(expectedurl)) {
			ExtentReport.getTest().log(Status.PASS, "ItenaryDetailsPage landed");
		} else {
			ExtentReport.getTest().log(Status.FAIL, "failed to land ItenaryDetails page: " + " expected value is : "
					+ expectedurl + " but found " + urlval);
		}

	}
}
