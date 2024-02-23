package com.ABS.ataf.PegaApp.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.helper.Logger.LoggerHelper;

public class LoginPage extends SeleniumFunc implements LoginPageLoc {
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	LoginPage loginpage;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void testLoginPage() {
		// System.out.println("In TestLoginPage method :"+ driver);
	}

	public void sendLoginObject(LoginPage loginpage) {
		this.loginpage = loginpage;
		// System.out.println("In sendLoginObject method search page"+this.loginpage);
	}

	public void setUserName(String username) throws Exception {
		try {
			waitFor(1);
			SeleniumFunc.xpath_GenericMethod_Sendkeys(inpUsername, username);
			log.info("Entered UserName");
			Assert.assertTrue(true, "Entered UserName");
		} catch (Exception e) {
			log.error("Failed to Enter UserName");
			Assert.assertTrue(false, "Failed to Enter UserName");
		}
	}

	public void setPassword(String password) throws Exception {
		try {
			waitFor(1);
			SeleniumFunc.xpath_GenericMethod_Sendkeys(inpPassword, password);
			log.info("Entered Password");
			Assert.assertTrue(true, "Entered Password");
		} catch (Exception ex) {
			log.error("Failed to Enter Password");
			System.out.println("Error: " + ex.getMessage());
			Assert.assertTrue(true, "Failed to Enter Password");
		}

	}

	public void clickOnLoginbtn() throws Exception {
		try {
			SeleniumFunc.xpath_GenericMethod_Click(btnLogin);
			log.info("Clicked Login button");
			Assert.assertTrue(true, "Clicked Login button");
		} catch (Exception ex) {
			log.info("Unable to Click Login button");
			Assert.assertTrue(false, "Unable to Click Login button");
		}
	}
	
	public void setUserNameNonPega(String username) throws Exception {
		try {
			waitFor(1);
			SeleniumFunc.xpath_GenericMethod_Sendkeys(inpUser, username);
			log.info("Entered UserName");
			Assert.assertTrue(true, "Entered UserName");
		} catch (Exception e) {
			log.error("Failed to Enter UserName");
			Assert.assertTrue(false, "Failed to Enter UserName");
		}
	}

	public void setPasswordNonPega(String password) throws Exception {
		try {
			waitFor(1);
			SeleniumFunc.xpath_GenericMethod_Sendkeys(inpPass, password);
			log.info("Entered Password");
			Assert.assertTrue(true, "Entered Password");
		} catch (Exception ex) {
			log.error("Failed to Enter Password");
			System.out.println("Error: " + ex.getMessage());
			Assert.assertTrue(true, "Failed to Enter Password");
		}

	}
	
	public void clickOnLogin() throws Exception {
		try {
			SeleniumFunc.xpath_GenericMethod_Click(btnLoginNonPega);
			log.info("Clicked Login button");
			Assert.assertTrue(true, "Clicked Login button");
		} catch (Exception ex) {
			log.info("Unable to Click Login button");
			Assert.assertTrue(false, "Unable to Click Login button");
		}
	}

	public void verifyMsg() throws Exception {
		boolean flag = SeleniumFunc.verifyElementPresent(inpUsername);
		if (!flag) {
			Assert.assertTrue(true, "Login is successful");
			log.info("Login is successful");
		} else {
			Assert.assertTrue(false, "Login is not successful");
			log.error("Login is not successful");
		}
	}

	public void verifyLoginFail() {

		Assert.assertTrue(driver.findElement(By.xpath(labelMsgError)).getText()
				.contains("The information you entered was not recognized"), "User logged in");

	}

	public void payment_request() throws Exception {
		Thread.sleep(3000);
		SeleniumFunc.xpath_GenericMethod_Click(btnMouse);
		SeleniumFunc.xpath_GenericMethod_Click(btnNew);
		SeleniumFunc.xpath_GenericMethod_Click(btnPayment);
	}

}
