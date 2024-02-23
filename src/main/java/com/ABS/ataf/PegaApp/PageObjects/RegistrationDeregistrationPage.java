package com.ABS.ataf.PegaApp.PageObjects;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.helper.Logger.LoggerHelper;

public class RegistrationDeregistrationPage extends SeleniumFunc implements RegistrationDeregistrationPageLoc {
	private final Logger log = LoggerHelper.getLogger(RegistrationDeregistrationPage.class);

	RegistrationDeregistrationPage regpage;

	public RegistrationDeregistrationPage(WebDriver driver) {
		super(driver);
	}

	public void sendRegistrationDeregistrationPageObject(RegistrationDeregistrationPage regpage) {
		this.regpage = regpage;
	}

	public void selectCustomer() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnCustomer);
	}

	public void selectNominateCheckBox() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(chkNominatePrimaryContact);
	}

	public void selectPrefix(String prefixMr) throws Exception {

		waitFor(1);
		SeleniumFunc.xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropPrefix, prefixMr);
		log.info("select Drop Down");
	}

	public void setFirstName(String firstName) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpFirstName, firstName);
	}

	public void setLastName(String lastName) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inplastName, lastName);
	}

	public void setPrimaryEmail(String primaryEmail) throws Exception {
		waitFor(1);
		SeleniumFunc.xpath_GenericMethod_Sendkeys(inpEmailAdd, primaryEmail);
		log.info("Entered emailAdd");
	}

	public void setMobileNumber(String mobileNumberReg) throws Exception {
		waitFor(1);
		SeleniumFunc.xpath_GenericMethod_Sendkeys(inpMobileNumber, mobileNumberReg);
		log.info("Entered mobileNumberReg");
	}

	public void setPrimaryAddress(String primaryAdd) throws Exception {
		xpath_GenericMethod_Sendkeys(inpPrimaryAdd, primaryAdd);
		waitFor(1);
		CustomerInfoPage.clickSuggestionGeneric(primaryAdd);
	}

	public void clickOnCopyPriAdd() throws Exception {
		waitFor(1);
		SeleniumFunc.xpath_GenericMethod_Click(chkOnCopyPrimaryAdd);
		log.info("click on copy primary address");
	}
	
	public String getLifeSupportCaseId() throws Exception {
		waitFor(1);
		String caseLabel = xpath_Genericmethod_getElementText(labelCaseId);
		String caseId = StringUtils.substringBetween(caseLabel, "(", ")");
		System.out.println(caseId);
		return caseId;

	}

	public void clickOnSubmitbtn() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmit);
		log.info("Clicked submit Button");
	}

	// RELATIONSHIP SUMMARY Status For Registration
	public void verifyLSStatus(String lifeSStatus) throws Exception {
		waitFor(5);
		try {
			if (verifyTextContains(labelLifeSupportStatusRegistered, lifeSStatus)) {
				Assert.assertTrue(true, "Category Status verified!");
			} else {
				Assert.assertTrue(false, "Category Status not as expected!");
			}
		} catch (Exception e) {
			WebElement ele = driver.findElement(By.xpath(labelLifeSupportStatusRegistered));
			if (ele.getText().contains(lifeSStatus)) {
				Assert.assertTrue(true, "Category Status verified!");
			} else {
				Assert.assertTrue(false, "Category Status not as expected!");
			}
		}
	}

	public void verifyActiveStatus(String customerS) throws Exception {
		if (verifyTextContains(labelCustomerStatusActive, customerS)) {
			Assert.assertTrue(true, "Category Status verified!");
		} else {
			Assert.assertTrue(false, "Category Status not as expected!");
		}
	}

	public void verifystatus(String customerStatusopen) throws Exception {
		if (verifyTextContains(lableStatus, customerStatusopen)) {
			Assert.assertTrue(true, "Category Status verified!");
		} else {
			Assert.assertTrue(false, "Category Status not as expected!");
		}
	}

//Registration & DeRegistration common hyperlink
	public void clickOnSubCaseQueue() throws Exception {
		waitFor(2);
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		waitFor(3);
		xpath_GenericMethod_Click(linkQueueForBingHyperlink);
		waitFor(1);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnyestocontinue);
		log.info("Clicked SubCaseQueue HyperLink");
	}

	public void clickReminderHyperlink() throws Exception {
		waitFor(2);
		xpath_GenericMethod_scrollIntoView(linkReminderNotificationsnoHyperlink);
		xpath_GenericMethod_Click(linkReminderNotificationsnoHyperlink);
		log.info("Clicked Reminder Notification  HyperLink");
	}

	public void resendWelcomePack(String noticeVal, String radioVal) throws Exception {
		waitFor(2);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnRegistrationStage, noticeVal);
		waitFor(1);
		String fullxpath = String.format(radioYesNoResetClock, radioVal);
		driver.findElement(By.xpath(fullxpath)).click();
	}

	public void selectRegistered(String lifesupportstatus) throws Exception {
		waitFor(2);
		waitForElementXpath(lableRegisterdStatus, 10);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(lableRegisterdStatus,
				lifesupportstatus);
		log.info("select Drop Down");
	}

	public void selectMedicalConfirmation(String reasonCode) throws Exception {
		driver.switchTo().defaultContent();
		xpath_GenericMethod_selectFromDropdownUsingValuebyclickingOnDropdown(chkMedicalConfirmation, reasonCode);
		log.info("select Drop Down");
	}

	public void clickTheSubmit() throws Exception {
		xpath_GenericMethod_Click(btnClickSubmit);
		log.info("Clicked submit");
	}

	public void clickLifeSupportRegpageconfirm() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnLifeSupportRegpageconfirm);
		log.info("Clicked confirm");
	}

	public void clickConfirmTaskCase() throws Exception {
		waitFor(2);
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnConfirmTaskCase);
	}

	public void clickOnFinish() throws Exception {
		waitFor(1);
		SeleniumFunc.xpath_GenericMethod_Click(btnFinish);
		log.info("Clicked finish Button");
	}

	public void clickOnWaitForCustResponseHyperlink() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		SeleniumFunc.xpath_GenericMethod_Click(linkWaitCustRes);
		log.info("Clicked On wait for Cust Response Hyperlink");

	}

	// Reason For DeRegistration
	public void clickOnCustRespons() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(chkCustomerResponded);
	}

	public void clickOnAccept() throws Exception {
		waitFor(1);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(chkAccept);
	}

	public void clickOnDeny() throws Exception {
		waitFor(1);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnRadioDeny);
	}

	public void setComments(String value) throws Exception {
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Sendkeys(inpComment, value);
	}

	public void selectResoneCode(String resoneCode) throws Exception {
		driver.switchTo().defaultContent();
		xpath_GenericMethod_selectFromDropdownUsingValuebyclickingOnDropdown(dropdowResoneCode, resoneCode);
		log.info("select Drop Down");
	}

	// DeRegistration retailer
	public void selectRetailer() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnRetailer);
	}

	public void selectRPO() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnRedioRpo);
	}

	public void selectRPONO() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnRedioRpoNo);
	}

	public void clickOnWaitIntakehyperlink() throws Exception {
		waitFor(2);
		driver.navigate().refresh();
		driver.switchTo().defaultContent();
		waitFor(3);
		xpath_GenericMethod_Click(LinkWait);
		waitFor(1);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnyestocontinue);
		log.info("Clicked WaitIntake HyperLink");
	}

	// Registration Extension provided
	public void clickOnSetExtensionThreeDots(String threeDots) throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(dropSetExtensionThreeDots);
		waitFor(2);
		xpath_GenericMethod_Click(clickSetExtendedReq);
	}

	public void clickOnExtendedFlag() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(clickExtended);
	}

	public void selectLifeSupportStatus(String LifeSupportStatus) throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_selectFromDropdownUsingValuebyclickingOnDropdown(dropdowLifeSupportstatus,
				LifeSupportStatus);
		log.info("select Drop Down");

	}

	// RELATIONSHIP SUMMARY Status For DeRegistration
	public void verifyLSStatusdereg(String lifeSStatusdereg) throws Exception {
		waitFor(3);
		try {
			if (verifyTextContains(labellifeSstatusDeregistered, lifeSStatusdereg)) {
				Assert.assertTrue(true, "Category Status verified!");
			} else {
				Assert.assertTrue(false, "Category Status not as expected!");
			}
		} catch (Exception e) {
			WebElement ele = driver.findElement(By.xpath(labellifeSstatusDeregistered));
			if (ele.getText().contains(lifeSStatusdereg)) {
				Assert.assertTrue(true, "Category Status verified!");
			} else {
				Assert.assertTrue(false, "Category Status not as expected!");
			}
		}
	}

	public void verifyCustomerStatus(String customerStatusInactive) throws Exception {
		if (verifyTextContains(labelCusStatusInactive, customerStatusInactive)) {
			Assert.assertTrue(true, "Category Status verified!");
		} else {
			Assert.assertTrue(false, "Category Status not as expected!");
		}
	}
}
