package com.ABS.ataf.stepdef.Pega;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.PegaApp.PageObjects.HomePage;
import com.ABS.ataf.PegaApp.PageObjects.LogoutPage;
import com.ABS.ataf.TestBase.TestBase;
import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.stepdef.common.LoginTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepdef {
	private final Logger log = LoggerHelper.getLogger(HomePageStepdef.class);
	HomePage homepage = new HomePage(TestBase.getDriver());
	LogoutPage logoutpage = new LogoutPage(TestBase.getDriver());
	public static PropertiesConfiguration config;

	@Then("I create new payment request")
	public void i_create_new_payment_request() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		homepage.createPayment();
		System.out.println("Opened Payment request!");
	}

	@Then("I validate error message on form fields")
	public void i_validate_error_in_form() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		homepage.validateFields();
		System.out.println("Validated Errors for mandatory fields");
	}
	
	@When("I collect basic information")
	public void i_collect_basic_info() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		String cluster = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "cluster");
		String country = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "country");
		String companycode = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "companycode");
		String requestType = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "requesttype");
		String po = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "po");
		String invAvailable = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "invoiceavailable");
		String bankDocAttached = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "bankdetailsdoc");
		String lineManager = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "linemanager");
		String reasonPayment = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "reasonformanualpayment");
		homepage.fillBasicInfo(cluster,country,companycode,requestType,po,invAvailable,bankDocAttached,lineManager,reasonPayment);
		System.out.println("Filled Basic Info!");
	}
	
	@Then("I collect vendor and invoice details")
	public void i_collect_vendor_invoice_info() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		homepage.fillVendorInfo();
		System.out.println("Filled Vendor info!");
	}
	
	@Then("I collect payment details")
	public void i_collect_payment_info() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		homepage.fillPaymentInfo();
		System.out.println("Filled Payment info!");
	}
	
	
	@Then("I attach document")
	public void i_attach_doc() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		homepage.attachDoc();
		System.out.println("Attached Document!");
	}
	
	@Then("I validate success message")
	public void i_validate_success() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		homepage.validateSuccess();
		System.out.println("Verified success");
	}
	@Then("I switch to interaction portal")
	public void i_switch_to_interaction_portal() throws Exception {
		logoutpage.sendLogoutObject(logoutpage);
		homepage.sendHomeObject(homepage);
		homepage.managerProfileMenu();
		homepage.switchToInteractionPortal();
		System.out.println("Switched to Interaction portal!");
	}

	@And("I switch to backoffice portal")
	public void i_switch_to_backoffice_portal() throws Exception {
		homepage.profileIcon();
		homepage.switchToBackOfficePortal();
		System.out.println("Switched to Interaction portal!");
	}

	@When("I initiate New Phone call")
	public void i_initiate_new_phone_call() throws Exception {
		homepage = new HomePage(TestBase.getDriver());
		homepage.sendHomeObject(homepage);
		homepage.clickNewButton();
		homepage.startPhoneCall();
		System.out.println("Clicked phone call!");
	}
	
	@Then("I validate message {string}")
	public void i_validate_message(String string) throws Exception {
		homepage.validateMessage(string);
	}

	
	@Then("I validate NMI is {string}")
	public void i_validate_nmi_is(String string) throws Exception {
		String nmi = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), string);
		homepage.verifyNMI(nmi);
	}


	@Then("I close all tabs")
	public void i_close_all_tabs() {
		homepage.closeAllTabs();
		System.out.println("Closed All Tabs!");
	}
	
	@Then("I close current tab")
	public void i_close_current_tab() {
		homepage.closeCurrentTab();
		System.out.println("Closed Current Tab!");
	}

	@When("I search the case")
	public void i_search_the_case() throws Exception {
		String caseId=ObjectRepo.reader.getTempCaseId().toString();
		homepage.searchCase(caseId);
		System.out.println("Searched Case!");
	}

}
