package com.ABS.ataf.stepdef.Pega;

import org.apache.log4j.Logger;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.PegaApp.PageObjects.CustomerInfoPage;
import com.ABS.ataf.PegaApp.PageObjects.RegistrationDeregistrationPage;
import com.ABS.ataf.TestBase.TestBase;
import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.helper.Logger.LoggerHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationDeregistrationStepdef {

	private final Logger log = LoggerHelper.getLogger(RegistrationDeregistrationStepdef.class);
	RegistrationDeregistrationPage regPage = new RegistrationDeregistrationPage(TestBase.getDriver());

	@When("I am on the Primary Contact Form page")
	public void i_am_on_the_Primary_Contact_Form_page() throws Exception {

		regPage.sendRegistrationDeregistrationPageObject(regPage);
	}

	@And("I select customer as {string}")
	public void i_select_customer_as(String string) throws Exception {
		regPage.selectCustomer();
	}

	@And("I select deregistration requested date {string}")
	public void i_select_deregistration_requested_date(String string) {

	}
	

	@And("I fill life support intake form")
	public void i_fill_life_support_intake_form() throws Exception {
		String prefixMr = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "prefix");
		String firstName = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "firstName");
		String lastName = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "lastName");
		String primaryEmail = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "primaryemail");
		String mobileNumberReg = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "mobilenumber");
	    String primaryAdd = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "primaryaddress");
	    
	    regPage.selectNominateCheckBox();
	    regPage.selectPrefix(prefixMr);
		regPage.setFirstName(firstName);
	    regPage.setLastName(lastName);
		regPage.setPrimaryEmail(primaryEmail);
		regPage.setMobileNumber(mobileNumberReg);
		regPage.setPrimaryAddress(primaryAdd);
		regPage.clickOnCopyPriAdd();
		String caseID = regPage.getLifeSupportCaseId();
		ObjectRepo.reader.setTempCaseId(caseID);	
	}
	
	@And("I click on finish")
	public void i_click_on_finish() throws Exception {
		regPage.clickOnFinish();
	}
	

	@And("I submit the form")
	public void i_submit_the_form() throws Exception {
		regPage.clickOnSubmitbtn();
		System.out.println("I Submited form");
	}
	

	@And("Verify Relationship summary")
	public void verify_relationship_summary() throws Exception {
		String lifeSStatus = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "lifesupportstatus");
		String customerS = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "customerstatus");
		String customerStatusopen = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "status");
		
		regPage.verifyLSStatus(lifeSStatus);
		regPage.verifyActiveStatus(customerS);
		regPage.verifystatus(customerStatusopen);	
	}
	
	@Then("Verify life support status {string}")
	public void verify_life_support_status(String string) throws Exception {
		regPage.verifyLSStatus(string);
	}

	@And("I check Customer Status {string}")
	public void i_check_Customer_Status(String string) throws Exception {
		regPage.verifyActiveStatus(string);
		System.out.println("Customer Status Verified!");
	}

	@And("I check case status should be {string}")
	public void i_check_case_status_should_be(String string) throws Exception {
		regPage.verifystatus(string);
		System.out.println("Label Status open");
	}

	@When("I click on Queue for Bing Processing hyperlink")
	public void i_click_on_Queue_for_Bing_Processing_hyperlink() throws Exception {
		regPage.clickOnSubCaseQueue();

	}

	@And("I click on sub case wait for Cus Response hyperlink")
	public void i_click_on_sub_case_wait_for_Cus_Response_hyperlink() throws Exception {
		regPage.clickOnWaitForCustResponseHyperlink();
	}

	@And("Click Deregistration Decision {string}")
	public void click_Deregistration_Decision(String string) throws Exception {
		// regPage.ClickOnCustRespons();
		regPage.clickOnAccept();
	}

	@And("Click Customer Deregistration Decision {string}")
	public void click_Customer_Deregistration_Decision(String string) throws Exception {
		regPage.clickOnCustRespons();
		regPage.clickOnDeny();
	}

	@And("I Comments {string}")
	public void i_Comments(String string) throws Exception {
		regPage.setComments(string);
	}

	@And("I click on Reminder Notification hyperlink")
	public void i_click_on_Reminder_Notification_hyperlink() throws Exception {
		regPage.clickReminderHyperlink();
	}
	
	@And("resend {string} is done with reset clock {string}")
	public void resend_letter_is_done_with_reset_clock(String notice, String radioVal) throws Exception {
		regPage.resendWelcomePack(notice,radioVal);
		regPage.clickOnSubmitbtn();
	}

	@And("I select life support status  {string}")
	public void i_select_life_support_status(String string) throws Exception {
		regPage.selectRegistered(string);
	}

	@And("I select Life support Status {string}")
	public void i_select_Life_support_Status(String string) throws Exception {
		regPage.selectLifeSupportStatus(string);
	}

	@And("I select reason code {string}")
	public void i_select_reason_code(String string) throws Exception {
		regPage.selectMedicalConfirmation(string);
	}

	@And("Submit")
	public void submit() throws Exception {
		regPage.clickTheSubmit();
	}

	@When("I select Resone code {string}")
	public void i_select_Resone_code(String string) throws Exception {
		regPage.selectResoneCode(string);
	}

	@And("I Submit Deregistration decision")
	public void i_Submit_Deregistration_decision() throws Exception {
		regPage.clickTheSubmit();
	}

	@And("Click Confirm Btn")
	public void click_Confirm_Btn() throws Exception {
		regPage.clickLifeSupportRegpageconfirm();
		regPage.clickConfirmTaskCase();
	}
	

	@Then("Verify deregistration summary status")
	public void verify_derelationship_summary_status() throws Exception {
	    String lifeSStatusdereg = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "lifesupportstatusdereg");
		String customerStatusInactive = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "customerstatusinactive");
		
		regPage.verifyLSStatusdereg(lifeSStatusdereg);
		regPage.verifyCustomerStatus(customerStatusInactive);
	}
	
	@Then("Click the DeRegistration Confirm")
	public void click_the_DeRegistration_Confirm() throws Exception {
	    regPage.clickConfirmTaskCase();
	}

	@And("I select Retailer")
	public void i_select_Retailer() throws Exception {
		regPage.selectRetailer();
		String caseID = regPage.getLifeSupportCaseId();
		ObjectRepo.reader.setTempCaseId(caseID);
	}

	@And("I Select Rpo as {string}")
	public void i_Select_Rpo_as(String string) throws Exception {
		regPage.selectRPO();
	}

	@When("I Select Rpo  {string}")
	public void i_Select_Rpo(String string) throws Exception {
		regPage.selectRPONO();
	}

	@And("clicked on wait intake hyperlink")
	public void clicked_on_wait_intake_hyperlink() throws Exception {
		regPage.clickOnWaitIntakehyperlink();
	}

	@And("Cliked on Extended Flag")
	public void cliked_on_Extended_Flag() throws Exception {
		regPage.clickOnExtendedFlag();
	}

	@And("I clicked on three dots  {string}")
	public void i_clicked_on_three_dots(String string) throws Exception {
		regPage.clickOnSetExtensionThreeDots(string);

	}
}
