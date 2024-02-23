package com.ABS.ataf.stepdef.common;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.PegaApp.PageObjects.HomePage;
import com.ABS.ataf.PegaApp.PageObjects.LoginPage;
import com.ABS.ataf.TestBase.TestBase;
import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.utility.EncodeDecode;
import com.ABS.ataf.utility.ResourceHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);

	LoginPage loginpage;
	HomePage homepage;
	public static String testDataFile = null;

	@Given("Test data file is set as {string}")
	public void test_data_file_is_set_as(String file) throws Throwable {
		testDataFile = file;
	}

	@Given("Open the browser and navigate to the {string} url")
	public void open_the_browser_and_navigate_to_the_url(String appType) throws Throwable {
		
		if (ObjectRepo.reader.getRun().equalsIgnoreCase("jenkins")) {
			TestBase.getDriver().get(System.getenv("URL"));
		} else {
			switch(appType) {
			case "Pega":
				TestBase.getDriver().get(ObjectRepo.reader.getPegaWebsite());
				break;
			case "NonPega":
				TestBase.getDriver().get(ObjectRepo.reader.getNonPegaWebsite());
				break;
			}
		}
		loginpage = new LoginPage(TestBase.getDriver());
		loginpage.sendLoginObject(loginpage);
		Thread.sleep(1000);
	}

	@Given("^Open the browser and navigate to the NonPega url$")
	public void open_the_browser_and_navigate_to_the_nonpega_url() throws Throwable {
		// System.out.println("Before driver instantiation: "+TestBase.getDriver());
		// TestBase.getDriver().get(ObjectRepo.reader.getWebsite()); //Run from local
		// TestBase.getDriver().get(System.getProperty("URL")); //Run from jenkins
		if (ObjectRepo.reader.getRun().equalsIgnoreCase("jenkins")) {
			TestBase.getDriver().get(System.getenv("URL"));
		} else {
			TestBase.getDriver().get(ObjectRepo.reader.getNonPegaWebsite());
		}
		loginpage = new LoginPage(TestBase.getDriver());
		loginpage.sendLoginObject(loginpage);
		Thread.sleep(1000);
	}

	@When("I login with {string} and {string}")
	public void i_login_with_and(String username, String password) throws Throwable {
		String usernamefromJSON = SeleniumFunc.getValueFromJSON(testDataFile, username);
		String passwordfromJSON = EncodeDecode.decodeData(SeleniumFunc.getValueFromJSON(testDataFile, password));
		loginpage.setUserName(usernamefromJSON);
		loginpage.setPassword(passwordfromJSON);
		loginpage.clickOnLoginbtn();
	}
	
	@When("I login to NonPegaApp with {string} and {string}")
	public void i_login_NonPega_with_and(String username, String password) throws Throwable {
		String usernamefromJSON = SeleniumFunc.getValueFromJSON(testDataFile, username);
		String passwordfromJSON = EncodeDecode.decodeData(SeleniumFunc.getValueFromJSON(testDataFile, password));
		loginpage.setUserNameNonPega(usernamefromJSON);
		loginpage.setPasswordNonPega(passwordfromJSON);
		loginpage.clickOnLogin();
	}

	@When("^I click on Login button$")
	public void i_click_on_Login_button() throws Throwable {
		loginpage.clickOnLoginbtn();
	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() throws Throwable {
		loginpage.verifyMsg();
		System.out.println("Login successful!");
	}

	@Then("^User should not be logged in$")
	public void user_should_not_be_logged_in() throws Throwable {
		loginpage.verifyLoginFail();
	}

}
