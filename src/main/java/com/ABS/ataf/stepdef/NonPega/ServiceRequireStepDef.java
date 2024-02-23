package com.ABS.ataf.stepdef.NonPega;

import org.apache.log4j.Logger;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.NonPegaApp.PageObjects.ServiceRequirePage;
import com.ABS.ataf.PegaApp.PageObjects.RegistrationDeregistrationPage;
import com.ABS.ataf.TestBase.TestBase;
import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.helper.Logger.LoggerHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceRequireStepDef {
	private final Logger log = LoggerHelper.getLogger(ServiceRequireStepDef.class);
	ServiceRequirePage serPage = new ServiceRequirePage(TestBase.getDriver());

	@And("Click on service require {string}")
	public void Click_on_service_require(String string) throws Exception {
		serPage.clickHome();
		serPage.sendServiceRequireonPageObject(serPage);
		serPage.selectServiceRequire(string);
	}

	@And("I filled Customer Site details")
	public void i_filled_customer_site_details() throws Exception {
		String findsitedetails = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(),"sitedetailsaddress");
		serPage.setSiteDetails(findsitedetails);
		serPage.clickOnSearch();
		serPage.clickSelectAsset();
		serPage.selectMainAddressBox();
	}

	@And("I click continue")
	public void i_click_continue() throws Exception {
		serPage.clickOnContinue();
	}
	
	@And("I save the application request")
	public void i_save_the_application_request() throws Exception {
		serPage.saveApplication();
	}

	@And("Select connection require {string}")
	public void select_connection_require(String string) throws Exception {
		serPage.sendServiceRequireonPageObject(serPage);
		serPage.selectConnectionRequire(string);
	}

	@And("I select type of development {string}")
	public void i_select_type_of_development(String string) throws Exception {
		serPage.selectResidentialIndividualdwellings(string);
	}

	@And("I select single phase")
	public void i_select_single_phase() throws Exception {
		serPage.clickSinglePhase();
	}

	@And("I entered Power Load")
	public void i_entered_power_load() throws Exception {
		String existingLoad = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "existingpowerload");
		String removedLoad = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "removedpowerload");
		String newLoad = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "newpowerload");

		serPage.setExistingPLoad(existingLoad);
		serPage.setRemovedPLoad(removedLoad);
		serPage.setNewPLoad(newLoad);
	}

	@And("I added nmi")
	public void I_added_nmi() throws Exception {
		String cusNmi = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "customernmi");
		serPage.clickAddNmi();
		serPage.setCustomerNmi(cusNmi);
	}
	@And("I select future date for connection")
    public void i_select_future_date_for_connection() throws Exception {
        String coDate = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "connectiondate");
        serPage.setConnectionDate(coDate);
    }
	
	@And("I provide further details")
	public void i_provide_further_details() throws Exception {
		String furtherDetailsApp = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(),
				"furtherdetailsofapplication");
		serPage.setApplicationFurtherDetails(furtherDetailsApp);
	}

	@And("I attach supporting documents for new connection")
	public void i_attach_supporting_documents_for_new_connection() throws Exception {
		String supportingDocument = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(),"requiredsupportingdoc");
		serPage.setSupportingDocuments(supportingDocument);
	}

	@And("I entered Contact Details")
	public void i_entered_contact_details() throws Exception {
		String contactAddress = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "contactdetailsadd");
		serPage.setContactDetails(contactAddress);
		serPage.clickSameAsApplicant();
	}
	
	@And("I select associated load application No")
	public void i_select_load_app_no() throws Exception{
		serPage.selectLoadApplicationAsNo();
	}

	@And("I select No")
	public void i_select_no() throws Exception {
		serPage.selectAsPaApplicationAsNo();
	}

	@Then("Verify application request")
	public void Verify_application_request() throws Exception {
		String address = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "verifyAddress");
		serPage.verifySiteDetails(address);
		serPage.clickOnContinue();
	}

	@When("I click applicant acceptance")
	public void i_click_applicant_acceptance() throws Exception {
		serPage.clickApplicantAcceptance();
	}

	@And("Submit legal disclaimer")
	public void Submit_legal_disclaimer() throws Exception {
		serPage.clickOnSubmit();
	}
	
	@And("I save payment for later")
	public void i_save_payment_for_later() throws Exception {
		serPage.clickOnProceedToPayment();
		serPage.clearCart();
	}

	@And("I make payment using credit card")
	public void i_make_payment_using_credit_card() throws Exception {
		String cardNumber = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "creditcardno");
		String expiryMonth = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "cardexpirymonth");
		String expiryYear = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "cardexpiryyear");
		String cvnNumber = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "cardcvn");
		serPage.clickOnProceedToPayment();
		serPage.clickOnConfirmAndMakePayment();
		serPage.selectCreditCard();
		serPage.clickOnPay();
		serPage.clickOnNonRefundableProceed();
		serPage.selectVisaCreditCard();
		serPage.setCreditcardNumber(cardNumber);
		serPage.selectExpiryMonth(expiryMonth);
		serPage.selectExpiryYear(expiryYear);
		serPage.setCreditCardCvn(cvnNumber);
		serPage.clickOnCreditCardPay();
	}

	// SUBDIVISION

	@And("I select yes for suitable connection")
	public void i_select_yes_for_suitable_connection() throws Exception {
		serPage.selectSuitableConnectionAsYes();
	}
	@And("I attach supporting documents for subdivision")
	public void i_attach_supporting_documents_for_subdivision() throws Exception {
		serPage.setSupportingDocSubdivision();
	}

	// GENERATOR
	@And("I provied details of generator systeam")
	public void i_provied_details_of_generator_systeam() throws Exception {
		String existingkW = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "existingkw");
		String newkW = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "newkw");
		String removedkW = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "removedkw");
		String inExistingkW = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "inverterexistingkw");
		String inNewkW = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "inverternewkw");
		String inRemovedkW = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "inverterremovedkw");
		serPage.setGeneratorCapacity(existingkW, newkW, removedkW);
		serPage.setInverterRating(inExistingkW, inNewkW, inRemovedkW);
	}

	@And("I enter manufacturer name and cec certificate number")
	public void i_enter_manufacturer_name_and_cec_certificate_number() throws Exception {
		String manufacturerNa = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "manufacturername");
		String cecNumber = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "ceccertificatenumber");
		serPage.setManufacturerName(manufacturerNa);
		serPage.setCecCertificate(cecNumber);
	}
	@And("I attach supporting documents for generator")
	public void i_attach_supporting_documents_for_generator() throws Exception {
		serPage.setSupportingDocGenerator();
	}

	// Unmetered Supply / Special Small Service
	@And("I enter customer asset number")
	public void i_enter_customer_asset_number() throws Exception {
		String customerNumber = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "customerassetno");
		String maximumDe = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "maximumdemand");
		serPage.setCustomerAssetnumber(customerNumber, maximumDe);
	}

	@And("I select duty cycle {string}")
	public void i_select_duty_cycle(String string) throws Exception {
		serPage.selectDutyCycle(string);
	}

	@And("I provide a description of the public lighting works")
	public void i_provide_a_description_of_the_public_lighting_works() throws Exception {
		String publicLightingWorks = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(),
				"providescription");
		serPage.setDiscriptionOfPublicWorks(publicLightingWorks);
	}

	@And("I provide details of the public lighting customer")
	public void i_provide_a_description_of_the_public_lighting_customer() throws Exception {
		String companyNa = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "companyname");
		String contactPersone = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "contactpersonename");
		String contactNum = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "contactnumber");
		String contactEmail = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "contactemailadd");
		serPage.setDiscriptionOfPublicCustomer(companyNa, contactPersone, contactNum, contactEmail);
	}
	@And("I attach supporting documents for unmetered supply")
	public void i_attach_supporting_documents_for_unmetered_supply() throws Exception {
		serPage.setSupportingDocUnmeteredSupply();
	}
     //Public Lighting 
	@And("I attach supporting documents for public lighting")
	public void i_attach_supporting_documents_for_public_lighting() throws Exception {
		serPage.setSupportingDocPublicLighting();
	}
	// Relocate
	@And("I make payment using Bpay")
	public void i_make_payment_using_Bpay() throws Exception {
		serPage.clickOnProceedToPayment();
		serPage.clickOnConfirmAndMakePayment();
		serPage.selectBPay();
		serPage.clickOnNonRefundableProceed();
	}
	@And("I attach supporting documents for relocate")
	public void i_attach_supporting_documents_for_relocate() throws Exception {
		serPage.setSupportingDocRelocate();
	}

	// Embedded Network

	@And("I provide a description of embedded network request")
	public void i_provide_a_description_of_the_embedded_network_request() throws Exception {
		String embeddedNetworkRequest = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(),
				"networkrequest");
		serPage.setDiscriptionOfEmbeddedNetworkRequest(embeddedNetworkRequest);
	}
	@And("I attach supporting documents for embedded network")
	public void i_attach_supporting_documents_for_embedded_network() throws Exception {
		serPage.setSupportingDocEmbeddedNet();
	}
	// Technical Enquiry
	@And("I make payment using Account Pay")
	public void i_make_payment_using_account() throws Exception {
		serPage.clickOnProceedToPayment();
		serPage.clickOnConfirmAndMakePayment();
		serPage.selectAccount();
	}
	
	@And("I continue payment with CreditCard")
	public void i_continue_payment_with_creditcard() throws Exception {
		String cardNumber = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "creditcardno");
		String expiryMonth = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "cardexpirymonth");
		String expiryYear = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "cardexpiryyear");
		String cvnNumber = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCDUDataFile(), "cardcvn");
		serPage.clickOnConfirmAndMakePayment();
		serPage.selectCreditCard();
		serPage.clickOnPay();
		serPage.clickOnNonRefundableProceed();
		serPage.selectVisaCreditCard();
		serPage.setCreditcardNumber(cardNumber);
		serPage.selectExpiryMonth(expiryMonth);
		serPage.selectExpiryYear(expiryYear);
		serPage.setCreditCardCvn(cvnNumber);
		serPage.clickOnCreditCardPay();
	}
	
	@And("I attach supporting documents for technical enquiry")
	public void i_attach_supporting_documents_for_technical_enquiry() throws Exception {
		serPage.setSupportingDocTechnicalEnquiry();
	}
	//Payment verification
	
	@Then("CC payment should be successful")
	public void cc_payment_should_be_successful() throws Exception {
		serPage.verifyCCPayment();
		serPage.clickOnClose();
	}

	@Then("Bpay payment should be successful")
	public void Bpay_payment_should_be_successful() throws Exception {
		serPage.verifyBPayPayment();
		serPage.clickOnClose();
	}
	@Then("Account payment should be successful")
	public void account_payment_should_be_successful() throws Exception {
		serPage.verifyAccountPayment();
		serPage.clickOnClose();
	}
}
