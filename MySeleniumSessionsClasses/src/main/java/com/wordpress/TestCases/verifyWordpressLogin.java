/**
 * 
 */
package com.wordpress.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.wordpress.PageObject.LoginPage;

/**
 * @author marieelodie.ineza
 * I have created a wordpress account for practice and this class will test the login page
 *
 */
public class verifyWordpressLogin {
	
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports Reports;
	ExtentTest logger;
		
	@BeforeTest
	public void setup() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\src\\test\\Reports\\reports.html");
		Reports = new ExtentReports();
		Reports.attachReporter(htmlReporter);
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://wordpress.com/log-in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}
	
	@Test
	public void verifyValidLogin() {
				
		logger = Reports.createTest("testOne");
		
		LoginPage login = new LoginPage(driver);
		
		//calling the methods from the loginPage class
		login.typeUsername();
		login.clickContinue();
		login.typePassWord();
		login.clickLogin();
		logger.log(Status.PASS,"testOne");
	}
	

	
	@AfterMethod()
	public void afterTest(ITestResult Result) throws IOException{
		
		if(ITestResult.FAILURE == Result.getStatus()) {
			TakesScreenshot scrsht = (TakesScreenshot)driver;
			File SrcFile = scrsht.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir")+"\\src\\test\\Reports\\SCREENSHOT_"+Result.getMethod().getMethodName()+".PNG";
			File DestnFile = new File(dest);
			FileUtils.copyFile(SrcFile, DestnFile);
			logger.log(Status.FAIL, Result.getThrowable());
			logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(dest));
			
		}
	}
	

	@AfterTest
	public void tearDown() {
		Reports.flush();
		driver.quit();		

		
	}
	

}
