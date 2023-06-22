package com.automation.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.pages.base.BasePage;

public class LeadsPage extends BasePage {

	@FindBy(xpath = ("//a[@title=\"Leads Tab\"]"))
	WebElement leadstab;
	@FindBy(id = "tryLexDialogX")
	WebElement dialogtab;
	@FindBy(id = "fcf")
	WebElement dropdown;
//	@FindBy(LinkText = "Today's Leads")WebElement visibletextElement;
	@FindBy(xpath = ("//input[@title=\"New\"]"))
	WebElement newbtn;
	@FindBy(id = "name_lastlea2")
	WebElement lastname;
	@FindBy(id = "lea3")
	WebElement compname;
	@FindBy(xpath = ("//input[@title=\"Save\"]"))
	WebElement savebtn;

	public LeadsPage(WebDriver driver) {
		super(driver);
	}

	public void clickLeads() {
		clickElement(leadstab, "leads field");
	}

	public void clickDialogbox() {
		clickElement(dialogtab, "dialog field");
	}

	public void clickDropdown() {
		clickElement(dropdown, "dropdown field");
		Select select = new Select(dropdown);
		select.selectByVisibleText("Today's Leads");
	}

	public void clickNewbtn() {
		clickElement(newbtn, "newbtn field");
	}

	public void enterLastname(String lastnamedata) {
		enterText(lastname, lastnamedata, "lastname field");

	}

	public void enterCompname(String compnamedata) {
		enterText(compname, compnamedata, "compname field");
	}

	public void clickSavebtn() {
		clickElement(savebtn, "savebtn field");
	}

	public String getTextFromHomePageText() {
		return getTextFromWebElement(leadstab, "leads page from text");
	}

}
