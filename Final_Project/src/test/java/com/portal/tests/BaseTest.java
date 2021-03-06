package com.portal.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.portal.utils.Constants;

public class BaseTest {
	
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeTest
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/src/test/resources/reports/MyReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "Galaxy Final Project");
		extent.setSystemInfo("Environment", "SandBox");
		extent.setSystemInfo("Username", "Jhosep Bazan Bernales");

		// settting Report
		htmlReporter.config().setDocumentTitle("Report of PHPTRAVELS");
		htmlReporter.config().setReportName("Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}
	
	public void setupDriver(String browserName) {
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			setDriver(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			setDriver(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("opera")) {
			setDriver(new OperaDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			setDriver(new InternetExplorerDriver());
		}
		
	}
	
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		return this.driver.get();
	}
	
	@BeforeMethod
	@Parameters(value = { "browserName" })
	public void setupBrowser(String browserName, Method testMethod) {

		logger = extent.createTest(testMethod.getName());
		setupDriver(browserName);
		getDriver().manage().window().maximize();
		getDriver().get(Constants.url);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public static String getScreenShot(ThreadLocal<WebDriver> driver, String screenshotName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			String screenshotPath = getScreenShot(driver, result.getName());

			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {

			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.BLUE));

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		getDriver().quit();
	}
	
	
	
	@AfterTest
	public void makeReport() {
		extent.flush();
	}
}
