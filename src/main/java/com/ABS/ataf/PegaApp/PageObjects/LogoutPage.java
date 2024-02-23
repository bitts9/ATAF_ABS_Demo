package com.ABS.ataf.PegaApp.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.helper.Logger.LoggerHelper;

public class LogoutPage extends SeleniumFunc implements LogoutPageLoc {
	private final Logger log = LoggerHelper.getLogger(LogoutPage.class);
	LogoutPage logoutpage;

	public LogoutPage(WebDriver driver) {
		super(driver);

	}

	public void testLogoutPage() {
		// System.out.println("In test logout page");
	}

	public void sendLogoutObject(LogoutPage logoutpage) {
		this.logoutpage = logoutpage;
		// System.out.println("In sendLogoutObject method page"+this.logoutpage);
	}

	public void clickOnDownArrow() throws Exception {

		try { // driver.findElement(By.xpath(login_popup_close_xpath)).click();
			xpath_GenericMethod_Click(login_popup_close_xpath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try { // driver.findElement(By.xpath(logout_icon_xpath)).click();
			xpath_GenericMethod_Click(logout_icon_xpath); // waitFor(3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickOnLogoutButton() throws Exception {
		/*
		 * try { //driver.findElement(By.xpath(login_popup_close_xpath)).click();
		 * xpath_GenericMethod_Click(login_popup_close_xpath); }catch(Exception e) {
		 * System.out.println(e.getMessage()); }
		 */

		/*
		 * try { //driver.findElement(By.xpath(logout_icon_xpath)).click();
		 * 
		 * xpath_GenericMethod_Click(logout_icon_xpath); waitFor(3); }catch(Exception e)
		 * { System.out.println(e.getMessage()); }
		 */
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(logout_icon_xpath);
	}

	public void clickOnLogoutLink() {
		try {
			xpath_GenericMethod_Click(logout_xpath);
			waitFor(1);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// SeleniumFunc.robotClass();
		waitFor(1);
		driver.switchTo().alert().dismiss();
		waitFor(2);
	}

	public void verifyUsernameField_IsDisplayed() {
		try {
			waitForElement(driver.findElement(By.xpath(username_xpath)), 20);
			Assert.assertTrue(driver.findElement(By.xpath(username_xpath)).isDisplayed(), "Logout is successful");
			// System.out.println("verify UsernameField_IsDisplayed method" + driver);
		} catch (Exception e) {
			Assert.assertTrue(false, "Logout is not successful");
			log.error("Login is not successful");
		}
	}
	
	public void verifyUsernameFieldNonPega_IsDisplayed() {
		try {
			waitForElement(driver.findElement(By.xpath(inpUsername)), 20);
			Assert.assertTrue(driver.findElement(By.xpath(inpUsername)).isDisplayed(), "Logout is successful");
			// System.out.println("verify UsernameField_IsDisplayed method" + driver);
		} catch (Exception e) {
			Assert.assertTrue(false, "Logout is not successful");
			log.error("Login is not successful");
		}
	}

}
