package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.pages.base.BasePage;

public class ContactsPage extends BasePage {

	@FindBy(xpath = ("//a[@title=\"Contacts Tab\"]"))
	WebElement contactstab;
	@FindBy(id = "tryLexDialogX")
	WebElement dialogtab;
	@FindBy(xpath = ("//input[@title=\"New\"]"))
	WebElement newbtn;
	@FindBy(id = "name_lastcon2")
	WebElement lastname;
	@FindBy(id = "con4")
	WebElement accountname;
	@FindBy(xpath = ("//input[@title=\"Save\"]"))
	WebElement savebtn;

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	public void clickContacts() {
		clickElement(contactstab, "contacts field");
	}

	public void clickDialogbox() {
		clickElement(dialogtab, "dialog field");
	}

	public void clickNewbtn() {
		clickElement(newbtn, "newbtn field");
	}

	public void enterLastname(String lastnamedata) {
		enterText(lastname, lastnamedata, "lastname field");

	}

	public void enterAccountname(String compnamedata) {
		enterText(accountname, compnamedata, "compname field");
	}

	public void clickSavebtn() {
		clickElement(savebtn, "savebtn field");
	}

	public String getTextFromHomePageText() {
		return getTextFromWebElement(contactstab, "contacts page from text");
	}
}
