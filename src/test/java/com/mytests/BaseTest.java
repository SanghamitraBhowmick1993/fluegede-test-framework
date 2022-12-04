package com.mytests;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mypages.BasePage;
import com.mypages.Page;
import com.utils.ConfigReader;
import com.utils.ExtentManager;
import com.utils.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	public Page page;
	public Properties prop;
	public ConfigReader configFileReader;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentSparkReport.html");
	DesiredCapabilities cap = new DesiredCapabilities();

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) throws MalformedURLException {
		if (browser.equals("chrome")) {
			/*for running tests without continious integration*/
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			/*for running in Docker:*/
//			cap.setBrowserName("chrome");			
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			/*for Docker:*/
//			cap.setBrowserName("firefox");			
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		} else {
			System.out.println("no browser is defined in xml file...");
		}
		page = new BasePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.get(ConfigReader.getUrl());

		/*
		 * Extracting network logs to debug errors - Selenium4 implementation
		 */
		// NetworkLogs.getNetworkLogs(driver);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setupSpark(ITestResult result) {
		ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
		ExtentReport.setTest(test);
	}

	// @AfterMethod
	public void tearDown() {
		driver.close();
	}

	@AfterSuite
	public static void teardown() {
		ExtentManager.getInstance().flush();
	}
	@AfterMethod
	public void tearDownSuite() {
		driver.quit();
	}

}
