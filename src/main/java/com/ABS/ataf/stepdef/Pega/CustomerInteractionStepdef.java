package com.ABS.ataf.stepdef.Pega;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.PegaApp.PageObjects.CustomerInfoPage;
import com.ABS.ataf.TestBase.TestBase;
import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.utility.DateFinder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerInteractionStepdef {
	private final Logger log = LoggerHelper.getLogger(CustomerInteractionStepdef.class);
	CustomerInfoPage custpage = new CustomerInfoPage(TestBase.getDriver());
	private static String approvedAmountVal = "";

	@And("I create a {string}")
	public void i_create_a(String string) throws Exception {
		custpage.sendCustInfoObject(custpage);
		custpage.createTask(string);
		System.out.println("Created " + string + " task type");
	}

	@And("the call is wrapped")
	public void the_call_is_wrapped() throws Exception {
		custpage.wrapupCall();
		System.out.println("Call interaction wrapped up!");
	}

	@And("I enter complaint details")
	public void i_enter_complaint_details() throws Exception {
		String customerTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"customertypenetwork");
		String complaintTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "complainttype");
		String sourceVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "source");
		String faultVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "faultstatus");
		String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "category");
		String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"subcategorycomplaints");

		custpage.selectCustomerType(customerTypeVal);
		custpage.selectComplaintType(complaintTypeVal);
		custpage.selectSource(sourceVal);
		custpage.selectFault(faultVal);
		custpage.selectCategory(categoryVal);
		custpage.selectSubCategory(subCategoryVal);
		custpage.completeComplaintFillup();
	}

	@And("I enter CSS details")
	public void i_enter_css_details() throws Exception {
		String customerTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"customertypenetwork");
		String complaintTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "complainttype");
//		String sourceVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getLoginDataFile(), "source");
//		String faultVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getLoginDataFile(), "faultstatus");
		String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "category");
		String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"subcategorycomplaints");

		custpage.selectCustomerType(customerTypeVal);
		custpage.selectComplaintType(complaintTypeVal);
//		custpage.selectSource(sourceVal);
//		custpage.selectFault(faultVal);
		custpage.selectCategory(categoryVal);
		custpage.selectSubCategory(subCategoryVal);
		custpage.fillOutageData();
		custpage.completeComplaintFillup();
	}
	
	@And("I enter breach details")
	public void i_enter_breach_details() throws Exception {
		String customerTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"customertypenetwork");
		String complaintTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "complainttype");
		String sourceVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "breachsource");
		String faultVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "breachfaultstatus");
		String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "breachcategory");
		String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"breachsubcategory");

		custpage.selectCustomerType(customerTypeVal);
		custpage.selectComplaintType(complaintTypeVal);
		custpage.selectSource(sourceVal);
		custpage.selectFault(faultVal);
		custpage.selectCategory(categoryVal);
		custpage.selectSubCategory(subCategoryVal);
		custpage.completeComplaintFillup();
	}

	@And("I enter claims details")
	public void i_enter_claims_details() throws Exception {
		String incidentDescVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimsincidentdecsription");
		String claimsDetailVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "claimsdetails");
		String incidentAddressVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimsincidentaddress");
		String incidentDateTime = DateFinder.getPastDateTime(-20, -3);
		int random_int = (int) Math.floor(Math.random() * (99999999L - 10000000 + 1) + 10000000);
		String incidentNumber = Integer.toString(random_int);
		custpage.setIncidentDate(incidentDateTime);
		custpage.setIncidentNumber(incidentNumber);
		custpage.selectApproxDateCheckBox();
		custpage.fillClaimDetails(incidentDescVal, claimsDetailVal);
		custpage.addAddress(incidentAddressVal);
		custpage.completeComplaintFillup();
		String caseID = custpage.getCaseId();
		ObjectRepo.reader.setTempCaseId(caseID);
		custpage.reviewClaimDetails(incidentDateTime, incidentNumber, incidentDescVal, claimsDetailVal);

	}

	@And("balance sheet for claim is filled")
	public void balance_sheet_for_claim_is_filled() throws Exception {
		String applianceoneamountVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimapplianceonevalue");
		String appliancetwoamountVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimappliancetwovalue");
		String appliancethreeamountVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimappliancethreevalue");
		custpage.fillBalanceSheet(applianceoneamountVal, appliancetwoamountVal, appliancethreeamountVal);
		approvedAmountVal = custpage.finaliseBalanceSheet();
	}

	@And("I enter hardship details")
	public void i_enter_hardship_details() throws Exception {
		String customerTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"customertypenetwork");
		String complaintTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipcomplainttype");
		String sourceVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "source");
		String faultVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "hardshipfaultstatus");
		String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "hardshipcategory");
		String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipsubcatergory");
		String hardshipDetailVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipdetail");
		int random_int = (int) Math.floor(Math.random() * (99999999L - 10000000 + 1) + 10000000);
		String defectNumber = Integer.toString(random_int);

		custpage.selectCustomerType(customerTypeVal);
		custpage.selectComplaintType(complaintTypeVal);
		custpage.selectSource(sourceVal);
		custpage.selectFault(faultVal);
		custpage.selectCategory(categoryVal);
		custpage.selectSubCategory(subCategoryVal);
		custpage.setDefectNumber(defectNumber);
		custpage.setHardshipDetailText(hardshipDetailVal);
		custpage.completeComplaintFillup();
	}

	@And("I send payment terms for approval")
	public void i_send_payment_terms_for_approval() throws Exception {
		String noInstallmentVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipnoofinstallment");
		String amountApprovedVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshiptotalamountapproved");
		String freqVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "hardshipfreqpayment");
		String finalPayVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipfinalpayment");
		custpage.sendForApproval(noInstallmentVal, amountApprovedVal, freqVal, finalPayVal);
	}
	
	@And("I verify installment amount")
	public void i_verify_installment_amount() throws Exception {
		String noInstallmentVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipnoofinstallment");
		String amountApprovedVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshiptotalamountapproved");
		String freqVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "hardshipfreqpayment");
		String finalPayVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipfinalpayment");
		custpage.verifyInstallment(noInstallmentVal, amountApprovedVal, freqVal, finalPayVal);
	}
	
	@And("I approve hardship")
	public void i_approve_hardship() throws Exception {
		custpage.approveHardship();
	}
	
	@And("I submit billing sheet values")
	public void i_submit_billing_sheet_values() throws Exception {
		String desGoodsVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipdescgood");
		String expEleVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipexpenseele");
		String workOrderVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipworkorder");
		String gstCodeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipgstcode");
		String gstExVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipgstexamt");
		String gstAmtVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipgstamt");
		String gstInVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipgstinamt");
		custpage.submitBillingSheet(desGoodsVal,expEleVal,workOrderVal,gstCodeVal,gstExVal,gstAmtVal,gstInVal);
	}
	
	@And("I process the customer response for hardship")
	public void i_process_the_customer_response_for_hardship() throws Exception {
		String reminderVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipcustomermodeofreminder");
		custpage.processCustomerResponse(reminderVal);
	}
	
	@Then("claim case state should be {string}")
	public void claim_case_state_should_be(String string) throws Exception {
		custpage.verifyClaimStatus(string);
		System.out.println("Case Status Verified!");

	}

	@And("I approve claim")
	public void i_approve_claim() throws Exception {
		custpage.approveClaim();
	}

	@Then("I review complaint details")
	public void i_review_complaint_details() throws Exception {
		String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "category");
		String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"subcategorycomplaints");
		String caseID = custpage.getCaseId();
		ObjectRepo.reader.setTempCaseId(caseID);
		custpage.reviewComplaintDetails(categoryVal, subCategoryVal);
		System.out.println("Complaint details Reviewed!");
	}

	@When("I categorize the case for {string}")
	public void i_categorize_the_case(String string) throws Exception {
		if (string.equalsIgnoreCase("Complaints") || string.equalsIgnoreCase("General Enquiry")||string.equalsIgnoreCase("Breach Investigations")) {
			String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "category");
			String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
					"subcategorycomplaints");
			custpage.categorizeCase(categoryVal, subCategoryVal);
			System.out.println("Case Categorized!");
		} else if (string.equalsIgnoreCase("Customer Service Standards")) {
			String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "category");
			String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
					"subcategorycomplaints");
			custpage.categorizeCase(categoryVal, subCategoryVal);
			System.out.println("Case Categorized!");
		} else if (string.equalsIgnoreCase("Hardship Request")) {
			String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
					"hardshipinvestigationcategory");
			String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
					"hardshipinvestigationsubcategory");
			custpage.categorizeCase(categoryVal, subCategoryVal);
			System.out.println("Case Categorized!");
		}
	}
	
	@Then("I review hardship details")
	public void i_review_hardship_details() throws Exception {
		String complaintTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipcomplainttype");
		String sourceVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "source");
		String faultVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "hardshipfaultstatus");
		String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "hardshipcategory");
		String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"hardshipsubcatergory");
		String caseID = custpage.getCaseId();
		ObjectRepo.reader.setTempCaseId(caseID);
		custpage.reviewHardshipDetails(complaintTypeVal, sourceVal,faultVal,categoryVal,subCategoryVal);
		System.out.println("Hardship details Reviewed!");
	}
	
	@And("I review breach details")
	public void i_review_breach_details() throws Exception {
		String customerTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"customertypenetwork");
		String complaintTypeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "complainttype");
		String sourceVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "breachsource");
		String faultVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "breachfaultstatus");
		String categoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "breachcategory");
		String subCategoryVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"breachsubcategory");
		String caseID = custpage.getCaseId();
		ObjectRepo.reader.setTempCaseId(caseID);
		custpage.reviewHardshipDetails(complaintTypeVal, sourceVal,faultVal,categoryVal,subCategoryVal);
		System.out.println("Breach details Reviewed!");
	}

	@And("local action {string} is opened")
	public void local_action_is_opened(String string) throws Exception {
		custpage.performLocalAction(string);
		System.out.println("Opened Local Action!");
	}

	@And("assessment is marked completed")
	public void assessment_is_marked_completed() throws Exception {
		custpage.markAssessmentComplete();
		System.out.println("Opened Local Action!");
	}

	@And("action edit details is done")
	public void action_edit_details_is_done() throws Exception {
		String eventVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "eventtitle");
		custpage.performEditDetails(eventVal);
		System.out.println("Edit Event details!");
	}

	@And("edit is done for hardship")
	public void edit_is_done_for_hardship() throws Exception {
		String eventVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "eventtitle");
		custpage.performEditHardship(eventVal);
		System.out.println("Edit Event details!");
	}

	@And("action cancel case is done")
	public void action_cancel_case_is_done() throws Exception {
		String cancelResolutionVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"cancelresolution");
		custpage.performCancelCase(cancelResolutionVal);
	}

	@And("action transfer case is done")
	public void action_transfer_case_is_done() throws Exception {
		String transferUserVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "transfertouser");
		custpage.performTransferCase(transferUserVal);
		System.out.println("Transferred Case!");
	}

	@And("action query to specialist is done")
	public void action_query_to_specialist_is_done() throws Exception {
		String emailVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "specialistemail");
		custpage.performQueryToSpecialist(emailVal);
		System.out.println("Query to specialist!");
	}

	@And("manual correspondence is sent for {string}")
	public void manual_correspondence_is_sent_for(String templateVal) throws Exception {
		String emailVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "specialistemail");
		custpage.performManualCorrespondenceHardship(emailVal, templateVal);
		System.out.println("Sent Manual Correspondence!");
	}

	@When("I collect claim data for form {string} with amount {string} than 2000")
	public void i_collect_claim_data(String formtypeVal, String claimAmountVal) throws Exception {
		// Claim Details
		String particularsVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimsparticulars");
		String resultVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "claimsresult");
		String causeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "claimsincidentcause");
		String incDateTimeVal = DateFinder.getPastDateTime(-20, 0);
		String incDescVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimsincidentdecsription");
		String eventVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "eventtitle");
		custpage.collectClaimDetailsTab(particularsVal, resultVal, causeVal, incDateTimeVal, incDescVal, eventVal);

		// Claim Check
		String claimableVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "claimable");
		String claimableOptionVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimableoption");
		String sendFormVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "claimsendform");
		custpage.claimableCheckTab(claimableVal, claimableOptionVal, sendFormVal, formtypeVal);

		// Internal Estimate
		String applianceoneVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimapplianceone");
		String appliancetwoVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimappliancetwo");
		String appliancethreeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimappliancethree");
		String applianceoneamountVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimapplianceonevalue");
		String appliancetwoamountVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimappliancetwovalue");
		String appliancethreeamountVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimappliancethreevalue");
		custpage.internalEstimateTab(claimAmountVal, applianceoneVal, appliancetwoVal, appliancethreeVal,
				applianceoneamountVal, appliancetwoamountVal, appliancethreeamountVal);
	}

	@And("action claim cancel is done")
	public void action_claim_cancel_is_done() throws Exception {
		String reasonVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "claimclosurereasoncxl");
		custpage.addClosureReason(reasonVal);
	}

	@When("I proceed after customer response")
	public void i_proceed_after_customer_response() throws Exception {
		custpage.chooseCustomerResponse();
	}

	@And("finalise with resolution")
	public void finalise_with_resolution() throws Exception {
		String resolutionVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "closeresolution");
		custpage.selectResolution(resolutionVal);
		System.out.println("Resolution Provided and closed case!");
	}
	
	@And("I finalise rejection resolution")
	public void i_finalise_rejection_resolution() throws Exception {
		String resolutionVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "rejectresolution");
		custpage.selectResolution(resolutionVal);
		System.out.println("Resolution Provided and closed case!");
	}

	@And("I submit case")
	public void i_submit_case() throws Exception {
		custpage.chooseSubmitProcessAction();
		System.out.println("Clicked Process Action!");
	}

	@When("I open subcase for transferred case")
	public void i_open_subcase_for_transferred_case() throws Exception {
		custpage.openSubCaseForProcessActions();
		System.out.println("Opened subcase after transfer!");
	}

	@When("I open assignment for claim task {string}")
	public void i_open_assignment_for_claim(String taskVal) throws Exception {
		custpage.openAssignmentForClaim(taskVal);
		System.out.println("Opened Assignment!");
	}

	@When("I open subcase {string}")
	public void i_open_subcase(String string) throws Exception {
		custpage.openSubCase(string);
		System.out.println("Opened subcase from tasks!");
	}

	@And("I submit form of release for {string}")
	public void i_submit_form_of_release_for(String string) throws Exception {
		String sendFormVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "claimsendform");
		custpage.submitFormOfRelease(sendFormVal, string);
		System.out.println("Opened subcase from tasks!");
	}

	@And("I update payment details")
	public void i_update_payment_details() throws Exception {
		String transactionDateVal = DateFinder.getCurrentDateTimeInTimeZone();
		int random_int = (int) Math.floor(Math.random() * (99999999L - 10000000 + 1) + 10000000);
		String paymentRef = Integer.toString(random_int);
		String amountVal = approvedAmountVal;
		String payeeVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(), "customerfirstname001");
		String descriptionVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getCASDataFile(),
				"claimsincidentdecsription");
		custpage.updatePaymentDetails(transactionDateVal, paymentRef, payeeVal, amountVal, descriptionVal);
		System.out.println("Updated payment details!");
	}

	@And("claim closure reason is added as {string}")
	public void claim_closure_reason_is_added_as(String string) throws Exception {
//		String closureReasonVal = SeleniumFunc.getValueFromJSON(ObjectRepo.reader.getLoginDataFile(),
//				"claimclosurereasonsettle");
		custpage.addClosureReason(string);
		System.out.println("Added closure reason!");
	}
	
	@And("hardship closure reason is added as {string}")
	public void hardship_closure_reason_is_added_as(String string) throws Exception {
		custpage.selectResolution(string);
		System.out.println("Added closure reason!");
	}

	@When("I decide to {string} the case")
	public void i_decide_to_the_case(String string) throws Exception {
		custpage.approveRejectCSS(string);
		System.out.println("Taken Action!");
	}

	@And("I close case")
	public void i_close_case() throws Exception {
		custpage.confirmCaseClosure();
		System.out.println("Case Page Closed!");
	}

	@Then("case status should be {string}")
	public void case_status_should_be(String string) throws Exception {
		custpage.verifyCaseStatus(string);
		System.out.println("Case Status Verified!");

	}
}
