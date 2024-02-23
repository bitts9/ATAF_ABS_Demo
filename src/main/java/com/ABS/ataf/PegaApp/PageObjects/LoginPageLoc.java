package com.ABS.ataf.PegaApp.PageObjects;

public interface LoginPageLoc {

	String inpUsername = "//input[@id='txtUserID']";
	String inpPassword = "//input[@id='txtPassword']";
	String btnLogin = "//button[@id='sub']";

	String labelVerifyMsg = "//span[@data-test-id='2018031408355709381206']"; // span[text()='O2CKatowice']
	String btnLoginClose = "//div[@class='pzbtn-mid' and text()='Close']";
	String labelMsgError = "//div[@id='error' and text()='                   The information you entered was not recognized.          ']";

	String inpUser = "//input[@id='user-name']";
	String inpPass = "//input[@id='password']";
	String btnLoginNonPega = "//input[@id='login-button']";
	
	// Create new Payment Request
	String btnMouse = "//a[@aria-haspopup='true']//child::span[@class='menu-item-image-wrapper'][1]";
	String btnNew = "//span[text()='New']";
	String btnPayment = "//span[@class='menu-item-title-wrap']//child::span[text()='Payment Request']";

}
