package com.automation.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4jUtility;
import com.automation.utility.PropertiesUtility;
import com.automation.utility.SFConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected Log4jUtility logObject=Log4jUtility.getInstance();
	protected Logger log;
	

	@BeforeTest
	public void setUpForBeforeTest() {
		log = logObject.getLogger();
	}

//	@BeforeMethod
//	@Parameters("browserName")
//	public void setUpBeforeTestMethod(@Optional("edge") String browserName) {
//		PropertiesUtility pro = new PropertiesUtility();
//		Properties appProp = pro.loadFile("applicationDataProperties");
//		String url = appProp.getProperty("SFurl");
//		launchBrowser(browserName);
//		goToUrl(url);
//	}
//
//	@AfterMethod
//	public void tearDownAfterTestMethod() {
////		driver.quit();
//		driver.close();
//		log.info("driver.....closed.......");
//	}

	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
            log.info("Edge browser launched");
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			log.info("Chrome browser launched");
		}

	}
	
//	public void goToUrl(String url) {
//		driver.get(url);
//		log.info(url + "is entered");
//	}

	public void closeBrowser() {
		driver.close();
		log.info("current browser closed");
	}

//	public void salesforceLoginPage(String url, String userName, String password) {
//		driver.get(url);
//
//		WebElement usernameElement = driver.findElement(By.id("username"));
//		enterText(usernameElement, userName, "username");
//		log.info("username entered");
//
//		WebElement passwordElement = driver.findElement(By.id("password"));
//		enterText(passwordElement, password, "password");
//		log.info("password entered");
//
//		WebElement buttonElement = driver.findElement(By.id("Login"));
//		clickElement(buttonElement, "login button");
//		log.info("button clicked");
//	}

	
	public File getScreenshotOfThePage(WebDriver driver) {
		String date = new SimpleDateFormat("yyyy_MM=dd_hh_mm_ss").format(new Date());
		String curDir = System.getProperty("user.dir");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File imgFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(SFConstants.SCREENSHOTS_DIRECTORY_PATH + date + ".png");

		try {
			FileUtils.copyFile(imgFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}

	public WebDriver returnDriverInstamce() {
		
		return null;
	}

}
