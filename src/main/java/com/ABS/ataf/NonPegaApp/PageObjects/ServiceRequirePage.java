package com.ABS.ataf.NonPegaApp.PageObjects;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.PegaApp.PageObjects.CustomerInfoPage;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.utility.DateFinder;

public class ServiceRequirePage extends SeleniumFunc implements ServiceRequirePageLoc {
	private final Logger log = LoggerHelper.getLogger(ServiceRequirePage.class);

	ServiceRequirePage serPage;
	Properties user = System.getProperties();

	public ServiceRequirePage(WebDriver driver) {
		super(driver);
	}

	public void sendServiceRequireonPageObject(ServiceRequirePage serPage) {
		this.serPage = serPage;
	}
	
	// What service do you require
	public void selectServiceRequire(String servicename) throws Exception {
		waitFor(2);
		String fullXpath = String.format(btnServices, servicename);
		System.out.println(fullXpath);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void clickHome() throws Exception {
		xpath_GenericMethod_Click(linkHome);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

	public void setSiteDetails(String findsitedetails) throws Exception {
		waitFor(5);
		xpath_GenericMethod_Sendkeys(inpFindSiteDetails, findsitedetails);
	}

	public void clickOnSearch() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnSearch);
	}

	public void clickSelectAsset() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnSelectAsset);
	}

	public void selectMainAddressBox() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(chkMainAddress);
	}

	public void clickOnContinue() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnContinue);
	}
	
	public void saveApplication() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnSave);
		waitFor(1);
		xpath_GenericMethod_Click(btnSaveAndClose);
	}

	public void selectConnectionRequire(String connectionserviceRequire) throws Exception {
		waitFor(1);
		String fullXpath = String.format(labelGenericConnectionService, connectionserviceRequire);
		System.out.println(fullXpath);
		xpath_GenericMethod_Click(fullXpath);
	}

	public void selectResidentialIndividualdwellings(String typeOfDevelopment) throws Exception {
		waitFor(3);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropdowSelectTypeDev,
				typeOfDevelopment);
		log.info("select Drop Down");
	}

	public void clickSinglePhase() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(labelSinglePhase);
	}

	public void setExistingPLoad(String existingLoad) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpExistingLoad, existingLoad);
		log.info("Entered ExistingLoad");
	}

	public void setRemovedPLoad(String removedLoad) throws Exception {
		xpath_GenericMethod_Click(inpRemovedLoad);
		xpath_GenericMethod_Sendkeys(inpRemovedLoad, removedLoad);
		log.info("Entered Removed Load");
	}

	public void setNewPLoad(String newLoad) throws Exception {
		xpath_GenericMethod_Click(inpNewLoad);
		xpath_GenericMethod_Sendkeys(inpNewLoad, newLoad);
		log.info("Entered New Load");
	}

	public void clickAddNmi() throws Exception {
		try {
			waitFor(2);
			driver.switchTo().defaultContent();
			WebElement l = driver.findElement(By.xpath("//a[text()='Add NMI']"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", l);
			log.info("Clicked Add NMI");
		} catch (Exception e) {

		}
	}

	public void setCustomerNmi(String cusNmi) throws Exception {
		waitFor(1);
		driver.switchTo().defaultContent();
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpNmi, cusNmi);
		driver.findElement(By.xpath("//div[text()='Comments']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Valid']")));
		//waitForElementXpath("//span[text()='Valid']", 10);
		//span[text()='Valid']
		log.info("Entered Customer NMI");
	}

	public void setConnectionDate(String coDate) throws Exception {
		xpath_GenericMethod_Click(imgcalendarConnectionDate);
		waitFor(1);
		xpath_GenericMethod_Click(inpDateTime);
		xpath_GenericMethod_Sendkeys(inpDateTime, coDate);
		xpath_GenericMethod_Click(imgcalendarConnectionDate);
		log.info("Entered Connection Date");
	}

	public void setApplicationFurtherDetails(String furtherDetailsApp) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpFurtherAppDetails, furtherDetailsApp);
		log.info("Entered Further Details Regarding Application");
	}

	public void setSupportingDocuments(String supportingdocument) throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(2);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);

		xpath_GenericMethod_Click(chkSitePlan);
		xpath_GenericMethod_Click(chkMaxDeCal);
		xpath_GenericMethod_Click(chkDaCDC);
		log.info("Entered Reason for Required Documents Unavailable");
	}

//Contact Details 
	public void setContactDetails(String contactAddress) throws Exception {
		waitFor(3);
		xpath_GenericMethod_Sendkeys(inpAddress, contactAddress);
		CustomerInfoPage.clickSuggestionGeneric(contactAddress);
		log.info("Entered applicant Contact details");
	}

	public void clickSameAsApplicant() throws Exception {
		waitFor(3);
		xpath_GenericMethod_Click(chkSameAsApplicant);
		log.info("click on Same as Applicant");
	}

	public void selectAsPaApplicationAsNo() throws Exception {
		waitFor(2);
		driver.findElement(By.xpath(btnASPSApplication)).click();
		waitFor(2);
		driver.findElement(By.xpath(btnASPSApplication)).click();
	}
	
	public void selectLoadApplicationAsNo() throws Exception {
		driver.findElement(By.xpath(btnASLoadApplicationNo)).click();
		waitFor(2);
		driver.findElement(By.xpath(btnASLoadApplicationNo)).click();
	}

	public void verifySiteDetails(String address) throws Exception {
		waitFor(1);
		if (verifyTextContains(labelVerifyAddress, address)) {
			Assert.assertTrue(true, "Address  verified!");
		} else {
			Assert.assertTrue(false, "Address not as expected!");
		}
	}

	public void verifyApplicationDetails(String reviewNmi) throws Exception {
		waitFor(2);
		if (verifyTextContains(labelVerifyNmiInfo, reviewNmi)) {
			Assert.assertTrue(true, "NMI Info verified!");
		} else {
			Assert.assertTrue(false, "NMI Info not as expected!");
		}
	}

	// Applicant Acceptance of Legal Disclaimer

	public void clickApplicantAcceptance() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(chkApplicantAcceptance);
	}

	public void clickOnSubmit() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitLegalDisclaimer);
	}
	// Payment Process

	public void clickOnProceedToPayment() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnPaymentLodgement);
	}
	
	public void clearCart() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnClearCart);
		xpath_GenericMethod_Click(btnConfirmClearCart);
	}

	public void clickOnConfirmAndMakePayment() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnMakePayment);
	}

	public void selectCreditCard() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(labelCreditCard);
		waitFor(1);
		xpath_GenericMethod_Click(btnProcced);
		log.info("Select Payment Option Credit card");
	}

	public void selectBPay() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(labelbPay);
		waitFor(2);
		xpath_GenericMethod_Click(btnProcced);
		waitFor(2);
		xpath_GenericMethod_Click(btnProcced);
		log.info("Select Payment Option BPAY");
	}

	public void selectAccount() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(labelAccount);
		waitFor(2);
		xpath_GenericMethod_Click(btnProcced);
		log.info("Select Payment Option AACOUNT");
	}

	public void clickOnPay() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnPay);
	}

	public void clickOnNonRefundableProceed() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnProcced);
	}

	// Payment Details
	public void selectVisaCreditCard() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(inpCardType);
		log.info("Select Credit card Type Visa");
	}

	public void setCreditcardNumber(String cardnumber) throws Exception {
		xpath_GenericMethod_Sendkeys(inpCardNumber, cardnumber);
	}

	public void selectExpiryMonth(String expirymonth) throws Exception {
		xpath_GenericMethod_selectFromDropdownUsingValuebyclickingOnDropdown(inpExpiryMonth, expirymonth);
		log.info("select Expiry Month Of Card");
	}

	public void selectExpiryYear(String expiryyear) throws Exception {
		xpath_GenericMethod_selectFromDropdownUsingValuebyclickingOnDropdown(inpExpiryYear, expiryyear);
		log.info("select Expiry Year Of Card");
	}

	public void setCreditCardCvn(String cvnnumber) throws Exception {
		xpath_GenericMethod_Sendkeys(inpCvn, cvnnumber);
	}

	public void clickOnCreditCardPay() throws Exception {
		xpath_GenericMethod_Click(chkPayPayment);
	}
	
	public void verifyCCPayment() throws Exception {
		waitFor(1);
		WebElement get_Title=driver.findElement(By.xpath(labelBpayAccountCCPayVerify));
		String get_Text=get_Title.getText();
		if(get_Text.equalsIgnoreCase("Thank you for your Payment.")) {
			Assert.assertTrue(true, "CC Payment message verified");
		}else
		{
			Assert.assertTrue(false, "CC Payment Not successfull");
		}	
	}
	
	public void verifyBPayPayment() throws Exception {
		waitFor(2);
		WebElement get_Title=driver.findElement(By.xpath(labelBpayAccountCCPayVerify));
		String get_Text=get_Title.getText();
		if(get_Text.equalsIgnoreCase("We have confirmed BPAY as your payment option - Thank you!")) {
			Assert.assertTrue(true, "Payment message verified");
		}else
		{
			Assert.assertTrue(false, "Payment Not successfull");
		}	
	}
	public void verifyAccountPayment() throws Exception {
		waitFor(2);
		WebElement get_Title=driver.findElement(By.xpath(labelBpayAccountCCPayVerify));
		String get_Text=get_Title.getText();
		if(get_Text.equalsIgnoreCase("Thank you for your payment option confirmation")) {
			Assert.assertTrue(true, "Account Payment message verified");
		}else
		{
			Assert.assertTrue(false, "Account Payment Not successfull");
		}	
	}
	public void clickOnClose() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnClose);
	}
	

	// SUBDIVISION
	public void selectSuitableConnectionAsYes() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnSuitableConnection);
		log.info("suitable connection for your Subdivision As Yes");
	}
	public void setSupportingDocSubdivision() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(1);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(chkFinalPlanSubdivision);
		xpath_GenericMethod_Click(chkLatestCouncil);
		xpath_GenericMethod_Click(chkFinalDepositedPlan);
	}
	// GENERATOR

	public void setGeneratorCapacity(String existingkW, String newkW, String removedkW) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpExistingkW, existingkW);
		log.info("Entered ExistingkW");
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpNewkW, newkW);
		log.info("Entered NewkW");
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpRemovedkW, removedkW);
		log.info("Entered RemovedkW");
	}

	public void setInverterRating(String inexistingkW, String innewkW, String inremovedkW) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpInverterExistingkW, inexistingkW);
		log.info("Entered Inverter ExistingkW");
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpInverterNewkW, innewkW);
		log.info("Entered Inverter NewkW");
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpInverterRemovedkW, inremovedkW);
		log.info("Entered Inverter RemovedkW");
	}

	public void setManufacturerName(String manufacturerna) throws Exception {
		waitFor(3);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Sendkeys(inpManufacturerName, manufacturerna);
		log.info("Entered Manufacturer Name");
	}

	public void setCecCertificate(String cecnumber) throws Exception {
		waitFor(3);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Sendkeys(inpCecNumber, cecnumber);
		log.info("Entered CEC Certificate Number");
	}

	public void setSupportingDocGenerator() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(2);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(chkSingleLine);
		xpath_GenericMethod_Click(chkLocationSketch);
		xpath_GenericMethod_Click(chkVoltage);
	}

	// Unmetered Supply / Special Small Service
	public void setCustomerAssetnumber(String customernuber, String maximunde) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpCustomerAssetNo, customernuber);
		log.info("Entered customer asset number");
		waitFor(1);
		xpath_GenericMethod_Click(inpMaximumDemand);
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpMaximumDemand, maximunde);
		log.info("Entered Maximum Demand");
	}

	public void selectDutyCycle(String duty) throws Exception {
		waitFor(3);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropdowDutyCycle, duty);
		log.info("select 24 Hours As Duty Cycle");
	}
	public void setSupportingDocUnmeteredSupply() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(2);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(chkSitePlan);
		xpath_GenericMethod_Click(chkDocConfirm);
	}
	// Public Lighting Assets

	public void setDiscriptionOfPublicWorks(String publiclightingworks) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpPublicLightingWorks, publiclightingworks);
		log.info("Provide a description of the public lighting works");
	}

	public void setDiscriptionOfPublicCustomer(String companyna, String contactpersone, String contactnum,
			String contactemail) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(inpCompanyName);
		xpath_GenericMethod_Sendkeys(inpCompanyName, companyna);
		log.info("Provide Company Name");
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpContactPersonName, contactpersone);
		log.info("Provide Contact Persone Name");
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpConatctNumber, contactnum);
		log.info("Provide Contact Number");
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpEmailAddress, contactemail);
		log.info("Provide Contact persone email");
	}
	public void setSupportingDocPublicLighting() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(2);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(chkSitePlan);
	}
	//Relocate 
	public void setDiscriptionOfEmbeddedNetworkRequest(String embeddednetworkrequest) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpPublicLightingWorks, embeddednetworkrequest);
		log.info("Provide a description of embedded network request");
	}
	public void setSupportingDocRelocate() throws Exception {
		waitFor(2);
		//driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(2);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(chkSitePlan);
	}
	//Embedded Network
	public void setSupportingDocEmbeddedNet() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(2);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(chkSingleDiagram);
		xpath_GenericMethod_Click(chkListOfNmi);
		xpath_GenericMethod_Click(chkSwitchboard);
		xpath_GenericMethod_Click(chkConfirmation);
		xpath_GenericMethod_Click(chkConstruction);
	}
	//Technical Enquiry
	public void setSupportingDocTechnicalEnquiry() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(2);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(user.get("user.dir") + "\\Files\\Connections-Portal-User-Guide.pdf");
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(chkSitePlan);
	}
	
}
