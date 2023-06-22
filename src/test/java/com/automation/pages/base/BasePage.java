package com.automation.pages.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4jUtility;

public class BasePage {

	protected static WebDriver driver;
	protected WebDriverWait wait;
	protected Log4jUtility logObject = Log4jUtility.getInstance();
	protected Logger log;
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();

	public BasePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		logObject.getLogger();
		log = LogManager.getLogger(BasePage.class);
		log.info("driver in basePage=" + driver);
	}

	public void enterText(WebElement element, String data, String objectName) {
		//waitFluentForVisibility(element, objectName);
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(data);
			log.info("Pass:" + objectName + " is entered to the username field");
			// report.logTestInfo("Pass:"+objectName + " is entered to the username field");
		} else {
			log.error("Fail:" + objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			log.info("pass:" + objName + "element cleared");
		} else {
			log.error("fail:" + objName + "element not displayed");
		}
	}

	public void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			log.info("pass:" + objName + "element clicked");
		} else {
			log.error("fail:" + objName + "element not clicked");
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void goToUrl(String url) {
		driver.get(url);
		log.info(url + "is entered");
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public String getTextFromWebElement(WebElement element, String name) {
		//waitFluentForVisibility(element, name);
		if (element.isDisplayed()) {
			return element.getText();
		} else {
			log.info(name + "web element is not displated");
		}
		return null;
	}

	public void displayAlert() {
		Alert alert = switchToAlert();
		alert.dismiss();
		log.info("Alert dismissed");
	}

	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		log.info("switch to alert");
		return alert;
	}

	public void AcceptAlert(Alert alert) {
		log.info("Alert accepted");
		alert.accept();
	}

	public String getAlertText(Alert alert) {
		log.info("extracting text in the alert");
		return alert.getText();
	}

	public void waitUntilPageLoads() {
		log.info("waiting until page loads with 30 sec maximum");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public void moveToElementAction(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		log.info("curser moved to web element" + objName);
	}

	public void contextClickAction(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		log.info("curser moved to web element" + objName);
	}

	public void WaitUntilElementIsVisible(WebElement ele, String objName) {
		log.info("waiting element " + objName + " for its visibility");
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void WaitUntilPresenceOfElementLocatedBy(By locator, String objName) {
		log.info("waiting element " + objName + " for its visibility");
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void selectByTextData(WebElement element, String text,String objName) {
		Select selectdata = new Select(element);
		selectdata.selectByVisibleText(text);
		System.out.println(objName + " selected " + text);
	}
	
	public void selectByValueData(WebElement element, String text, String objName) {
		Select selectdata = new Select(element);
		selectdata.selectByValue(text);
		System.out.println(objName + " selected " + text);
	}
	
	public void selectByIndexData(WebElement element, int index, String objName) {
		Select selectdata = new Select(element);
		selectdata.selectByIndex(index);
		System.out.println(objName + " selected " + index);
	}

//	public void waitFluentForVisibility(WebElement ele, String objName) {
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(ele));
//	}

}
