package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.pages.base.BasePage;

public class HomePage extends BasePage{

	
	@FindBy(xpath=("//a[@title=\"Home Tab\"]"))WebElement hometab ;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextFromHomePageText() {
		return getTextFromWebElement(hometab,"home page from text");
	}
	
		
}
