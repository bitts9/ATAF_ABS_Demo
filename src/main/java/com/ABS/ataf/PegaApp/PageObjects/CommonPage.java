package com.ABS.ataf.PegaApp.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.helper.Logger.LoggerHelper;

public class CommonPage extends SeleniumFunc implements CommonPageLoc{
	private final Logger log = LoggerHelper.getLogger(CustomerInfoPage.class);
	CommonPage compage;

	public CommonPage(WebDriver driver) {
		super(driver);
	}
	
	public void sendCustInfoObject(CustomerInfoPage custpage) {
		this.compage = compage;
	}

}
