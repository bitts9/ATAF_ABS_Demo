package com.ABS.ataf.stepdef.common;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.ABS.ataf.PegaApp.PageObjects.HomePage;
import com.ABS.ataf.PegaApp.PageObjects.LogoutPage;
import com.ABS.ataf.TestBase.TestBase;
import com.ABS.ataf.helper.Logger.LoggerHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogoutTest {
	private final Logger log = LoggerHelper.getLogger(LogoutTest.class);
	LogoutPage logoutpage;
	HomePage homepage;

	@When("^I click on down arrow$")
	public void i_click_on_down_arrow() throws Throwable {
		logoutpage = new LogoutPage(TestBase.getDriver());
		logoutpage.sendLogoutObject(logoutpage);
		logoutpage.clickOnDownArrow();
		// System.out.println("Down arrow" +TestBase.getDriver());
	}

	@When("^I click on Logout button$")
	public void i_click_on_logout_button() throws Throwable {
		logoutpage = new LogoutPage(TestBase.getDriver());
		logoutpage.sendLogoutObject(logoutpage);
		logoutpage.clickOnLogoutButton();
		// System.out.println("Down arrow" +TestBase.getDriver());
	}

	@When("^I click on Logout$")
	public void i_click_on_Logout() throws Throwable {
		logoutpage.clickOnLogoutLink();
		// System.out.println("click on logout" +TestBase.getDriver());
	}

	@Then("^Logout should be successful$")
	public void logout_should_be_successful() throws Throwable {
		logoutpage.verifyUsernameField_IsDisplayed();
		// System.out.println("logout success verification" +TestBase.getDriver());
	}
	
	@Then("^Logout should be successful from NonPegaApp$")
	public void logout_should_be_successful_nonpega() throws Throwable {
		logoutpage.verifyUsernameFieldNonPega_IsDisplayed();
		// System.out.println("logout success verification" +TestBase.getDriver());
	}

	@And("^I Logout$")
	public void i_Logout() throws Throwable {
		try {

			logoutpage = new LogoutPage(TestBase.getDriver());
			logoutpage.sendLogoutObject(logoutpage);
			homepage = new HomePage(TestBase.getDriver());
			homepage.sendHomeObject(homepage);
			homepage.profileIcon();
			homepage.clickOnLogOffink();
			log.info("Logout Successful");
			Assert.assertTrue(true, "Logout Successful");
		} catch (Exception ex) {
			log.info("Unable to logout");
			Assert.assertTrue(false, "Unable to logout");
		}
		// System.out.println("click on logout" +TestBase.getDriver());
	}
	
	@And("I Logout from NonPegaApp")
	public void i_Logout_from_nonpega() throws Throwable {
		try {

			logoutpage = new LogoutPage(TestBase.getDriver());
			logoutpage.sendLogoutObject(logoutpage);
			homepage = new HomePage(TestBase.getDriver());
			homepage.sendHomeObject(homepage);
			homepage.burgerIcon();
			homepage.clickOnLogOutNonPega();
			log.info("Logout Successful");
			Assert.assertTrue(true, "Logout Successful");
		} catch (Exception ex) {
			log.info("Unable to logout");
			Assert.assertTrue(false, "Unable to logout");
		}
		// System.out.println("click on logout" +TestBase.getDriver());
	}

}
