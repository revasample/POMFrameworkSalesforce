package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "username")
	WebElement usernameElement;
	@FindBy(id = "password")
	WebElement passwordElement;
	@FindBy(id = "Login")
	WebElement buttonElement;

	@FindBy(xpath = ("//*[@id=\"rememberUn\"]"))
	WebElement labelElement;
	// @FindBy(id="Login")WebElement button ;
//	@FindBy(xpath=("//*[@id=\"error\"]"))WebElement error;
	@FindBy(id = "userNavLabel")
	WebElement userMenu;
	@FindBy(xpath = ("//*[@id=\"userNav-menuItems\"]/a[5]"))
	WebElement logoutElement;
	@FindBy(id = "forgot_password_link")
	WebElement forgotpwdElement;
	@FindBy(id = "header")
	WebElement headerText;
	@FindBy(id = "error")
	WebElement error1;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void goToURLLogin(String url) {
		goToUrl(url);
	}

	public void enterUsername(String usernamedata) {
		enterText(usernameElement, usernamedata, "username field");
	}

	public void enterPassword(String passworddata) {
		enterText(passwordElement, passworddata, "password field");
	}

	public void clickButton() {
		clickElement(buttonElement, "login button");
		// return driver;
	}

	public void clicklabel() {
		clickElement(labelElement, "label field");
	}

	public String getErrorText() {
		return error1.getText();
	}

	public String getHeaderText() {
		return headerText.getText();
	}

	public void clickusermenu() {
		clickElement(userMenu, "usermenu field");
	}

	public void clicklogout() {
		clickElement(logoutElement, "logout field");
	}

	public void forgotpwd() {
		clickElement(forgotpwdElement, "forgotpwd field");
	}

	public String getTitleOfThePage() {
//		waitUntilPageLoads();
		return getPageTitle();
	}

}
