package com.automation.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.home.*;

import com.automation.utility.PropertiesUtility;

public class AutomationScripts extends BaseTest {

	public void main(String[] args) throws InterruptedException {

//		Login_Error_Salesforce_testscript();
//		Login_to_Salesforce_testscript();
//		Check_RememberMe_testscript();
//		Forgot_PasswordA_testscript();
//		Validate_LoginErrorB_testscript();
//		Check_leads_Tab_Link_testscript();
//		Validate_View_Dropdown_List_testscript();
//		List_Item_Todays_Leads_testscript();
//		Check_New_Button_on_Leads_testscript();
//		Create_New_Contact_testscript();

	}

	@Test
	public void Login_Error_Salesforce_testscript() throws InterruptedException {

		String expectedTitle = "Login | Salesforce";
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.invalid.userid");
		String password = appProp.getProperty("login.invalid.password");

		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		String actualTitle = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		Assert.assertEquals(actualTitle, expectedTitle);

		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String error = loginpage.getErrorText();
//		Assert.assertEquals(error, expectedError);

		closeBrowser();
		log.error("testscript error_login execution completed");
	}

	@Test
	public void Login_to_Salesforce_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedText = "Home";
		HomePage homepage = new HomePage(driver);
		String actualText = homepage.getTextFromHomePageText();
//      Assert.assertEquals(actualText, expectedText);

		closeBrowser();
		log.info("testscript login execution completed");
	}

	@Test
	public void Check_RememberMe_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		launchBrowser("chrome");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);

		loginpage.clicklabel();
		Thread.sleep(2000);
		loginpage.clickButton();

		loginpage.clickusermenu();
		loginpage.clicklogout();

		closeBrowser();
		log.info("testscript check_rememberme execution completed");

	}

	@Test
	public void Forgot_PasswordA_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");

		launchBrowser("chrome");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);

		loginpage.forgotpwd();

		String expectedError = "Forgot Your Password";
		String headerMsg = loginpage.getHeaderText();
//		Assert.assertEquals(headerMsg, expectedError);
		closeBrowser();
		log.info("testscript forgot_passwordA execution completed");

	}

	@Test
	public void Validate_LoginErrorB_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.wrong.password");
		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		Thread.sleep(3000);
		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actualError = loginpage.getErrorText();
//		Assert.assertEquals(actualError, expectedError);

		closeBrowser();
		log.info("testscript validate_loginerrorB execution completed");

	}

	@Test
	public void Check_leads_Tab_Link_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		LeadsPage leadspage = new LeadsPage(driver);
		leadspage.clickLeads();
		Thread.sleep(2000);
		leadspage.clickDialogbox();

		closeBrowser();
		System.out.println("testscript check_leads_tab_link execution completed");

	}

	@Test
	public void Validate_View_Dropdown_List_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");

		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		LeadsPage leadspage = new LeadsPage(driver);
		leadspage.clickLeads();
		Thread.sleep(2000);
		leadspage.clickDialogbox();
		leadspage.clickDropdown();

		System.out.println("All Open Leads,My Unread Leads,Recently Viewed Leads,Today's Leads is displayed");

		closeBrowser();
		System.out.println("testscript Validate_Viewdrop_down_list execution completed");
	}

	@Test
	public void List_Item_Todays_Leads_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		LeadsPage leadspage = new LeadsPage(driver);
		leadspage.clickLeads();
		Thread.sleep(2000);
		leadspage.clickDialogbox();
		leadspage.clickDropdown();

		closeBrowser();
		System.out.println("testscript list_item_todays_leads execution completed");
	}

	@Test
	public void Check_New_Button_on_Leads_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		LeadsPage leadspage = new LeadsPage(driver);
		leadspage.clickLeads();
		Thread.sleep(2000);
		leadspage.clickDialogbox();
		leadspage.clickNewbtn();
		leadspage.enterLastname(appProp.getProperty("last.name"));
		leadspage.enterCompname(appProp.getProperty("company.name"));
		leadspage.clickSavebtn();

		closeBrowser();
		System.out.println("testscript Checking_new_button_on_Leads execution completed");

	}

	@Test
	public void Create_New_Contact_testscript() throws InterruptedException {

		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataproperties");
		String SFurl = appProp.getProperty("SFurl");
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");

		launchBrowser("chrome");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.goToURLLogin(SFurl);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactsPage contactspage = new ContactsPage(driver);
		contactspage.clickContacts();
		Thread.sleep(2000);
		contactspage.clickDialogbox();
		contactspage.clickNewbtn();
		contactspage.enterLastname(appProp.getProperty("clast.name"));
		contactspage.enterAccountname(appProp.getProperty("account.name"));
		contactspage.clickSavebtn();

		closeBrowser();
		System.out.println("testscript Create_new_contact execution completed");
	}

}