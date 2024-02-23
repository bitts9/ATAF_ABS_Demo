package com.ABS.ataf.PegaApp.PageObjects;

public interface CustomerInfoPageLoc {
	// Customer Page Info

	String headerMyWork = "//div[text()='My Work']";
	// Add Tasks
	String addTaskPopup = "//button[@title='Add task']";

	// XPath for New --> Phone Call --> Test --> Submit --> Add task
	String genericTaskXpath = "//a[text()='%s' and @class='Add_task']";
	String complaints = "//a[text()='Complaints' and @class='Add_task']";
	String cSS = "//a[text()='Customer Service Standards' and @class='Add_task']";
	String hardshipRequest = "//a[text()='Hardship Request' and @class='Add_task']";
	String generalEnquiry = "//a[text()='General Enquiry' and @class='Add_task']";

	// Add Tasks Submit Button
	String btnAddTasks = "//button[text()='Add tasks']";

	// Wrap up call xpaths
	String btnWrapup = "//button[@title='Wrap up']";
	String btnWrapupSubmit = "//button[starts-with(@name,'CAWrapUp')]";

	// Fill Complaint Details
	String inpCustomerType = "//label[text()='Customer type']/following-sibling::div/input";
	String inpComplaintType = "//label[text()='Complaint type']/following-sibling::div/input";
	String inpSource = "//label[text()='Source']/following-sibling::div/input";
	String inpFaultStatus = "//label[text()='Fault Status']/following-sibling::div/input";
	String inpCategory = "//label[text()='Category']/following-sibling::div/input[@type='text']";
	String inpSubCategory = "//label[text()='Sub Category']/following-sibling::div/input";
	String inpEventTitle = "//label[text()='Event Title']/following-sibling::div/input[@type='text']";
	String btnComplaintNext = "//div[@data-methodname='simpleLayout_6']//button//div[text()='Next >>']";
	String inpDefectNumber = "//label[text()='Defect Number']/following-sibling::div//input";
	String textAreaDetailsHardship = "//label[text()='Details']/following-sibling::div//textarea";
	
	String genericXpathComplaintInputs = "//tr[contains(@data-gargs,'%s')]";

	// Review Complaint details
	String labelCategory = "//span[text()='Category']/following-sibling::div/span";
	String labelSubCategory = "//span[text()='Sub Category']/following-sibling::div/span";
	String labelComplaintType = "//span[text()='Complaint type']/following-sibling::div/span";
	String labelFault = "//span[text()='Fault Status']/following-sibling::div/span";
	String labelSource = "//span[text()='Source']/following-sibling::div/span";
	String btnFinishReview = "//div[text()='Finish']";

	// Categorize Case input
	String linkCategorizeTask = "//a[text()='Categorize Case (Processing)']";
	String inpInvestigationCat = "//label[text()='Investigation Category']/following-sibling::div/input[@type='text']";
	String inpInvestigationSubCat = "//label[text()='Investigation Sub Category']/following-sibling::div/input";
	String btnSubmitCaseCategorize = "//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";
	// label[text()=' Categorize Case ']/ancestor::
	// Process Actions
	String btnSubmitProcessAction = "//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";
	String threeDotActions = "//button[@title='Other actions']";// modified this xpath as this is more generic across
																// other tasks
	String genericLocalActionsXpath = "//span[text()='%s']";

	// Query to Specialist
	String inpToEmail = "//label[text()='To']/following-sibling::div/input";
	String txtAreaEmail = "//span[@class='textAreaExpandStyle ']/textarea";
	String btnSubmitQuery = "//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";

	// Resolution
	String dropDownResolution = "//label[text()='Resolution']/following-sibling::div/select";
	String btnSubmitResolution = "//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";

	// Cancel Resolution
	String btnSubmitCancelResolution = "//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";

	// Edit Details
	String btnSubmitEdit = "//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";

	// Transfer Case
	String inpManagedByUser = "//label[text()='Managed by']/following-sibling::div/input[@type='text']";
	String btnSubmitTransfer = "//button[text()='Transfer']";
	String linkProcessActionAfterTransfer = "//a[text()='Process Actions (Processing)']";

	// Case status
	String labelStatusValue = "//span[text()='Status']/following-sibling::div/span";
	String btnConfirmCase = "//button[@title='Confirm']";
	String labelCaseID = "//label[starts-with(text(),' Review')]/parent::div/following-sibling::div[starts-with(@class,'content-item content-field item-2')]/span";

	// Customer Service Standard Details
	String linkAddOutage = "//a[starts-with(@name,'CSSOutageDetails')]";
	String inpOutageStart = "//tr[@pl_index='1']/td[@data-attribute-name='Outage Start Time']//input";
	String inpOutageEnd = "//tr[@pl_index='1']/td[@data-attribute-name='Outage End Time']//input";
	String calendarOutageDateGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Outage Date']//img[@role='button']";
	String calendarOutageStartGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Outage Start Time']//img[@role='button']";
	String calendarOutageEndGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Outage End Time']//img[@role='button']";

	// Sub case
	String linkGenericSubCase = "//a[contains(text(),'%s')]";

	// Approval
	String textAreaApproval = "//div[@data-methodname='simpleLayout_6']//textarea";
	String btnApproveReject = "//button[text()='%s']";

	// Claims Details
	String inpIncidentDate = "//label[text()='Incident Date Time']/following-sibling::div//input";
	String inpIncidentRef = "//label[text()='Incident Reference Number']/following-sibling::div//input";
	String txtAreaIncidentDesc = "//label[text()='Customer Incident Description']/following-sibling::div//textarea";
	String txtAreaClaimDetail = "//label[text()='Customer Claim Details']/following-sibling::div//textarea";
	String inpAddressClaim = "//label[text()='Address']/following-sibling::div/input[@type='text']";
	String chkBoxApproxDate = "//label[text()='Approx Date']/following-sibling::div/input[@type='checkbox']";

	// Review claim details
	String labelIncidentDate = "//span[text()='Incident Date Time']/parent::span/following-sibling::div/span";
	String labelIncidentRef = "//span[text()='Incident Reference Number']/following-sibling::div/span";
	String labelIncDesc = "//span[text()='Customer Incident Description']/parent::span/following-sibling::div/span";
	String labelClaimDetail = "//span[text()='Customer Claim Details']/parent::span/following-sibling::div/span";

	String headerOpenAssignment = "//a[text()='%s']/ancestor::div[@data-node-id='OpenAssignments']//h2[text()='Open assignments']";

	// String collect claim
	String inpParticulars = "//label[text()='Particulars']/following-sibling::div//input";
	String inpResult = "//label[text()='Result']/following-sibling::div//input";
	String inpCause = "//label[text()='Cause']/following-sibling::div//input";
	String inpActualDate = "//label[text()='Actual Incident Date Time']/following-sibling::div//input";
	String txtAreaActualIncDesc = "//label[text()='Actual Incident Description']/following-sibling::div//textarea";

	String tabClaimableCheck = "//h2[text()='Claimable Check']";
	String dropDwnClaimable = "//label[text()='Claimable']/following-sibling::div/select";
	String inpClaimableOption = "//label[text()='Claimable Options']/following-sibling::div/input";
	String dropDwnSendForm = "//label[text()='Send the claim form to the customer?']/following-sibling::div/select";
	String inpClaimForm = "//label[text()='Claim Form']/following-sibling::div/input";

	String tabinternalEstimate = "//h2[text()='Internal Estimate']";
	String linkAddItem = "//a[text()='Add item']";
	String inpApplianceGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Appliances(Claim Item)']//input[@type='text']";
	String inpAssessmentAmountGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Internal Assessment']//input[@type='text']";
	String btnCalculateTotal = "//button[text()='Calculate Total']";
	String btnSubmitClaims = "//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";

	String radioProceed = "//label[text()='Proceed']/parent::span/input[@type='radio']";

	String rowClaimItem = "//tr/td[@data-attribute-name='Claim Item']";
	String inpClaimAmountGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Claimed Amount']//input[@type='text']";
	String inpLifeSpanGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Life Span (from ATO)']//input[@type='text']";
	String inpAgeOfItemGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Age of Item']//input[@type='number']";
	String chkBoxSelectClaimRowGeneric = "//tr[@pl_index='%d']/td[@data-attribute-name='Select']//input[@type='checkbox']";
	String btnCalculateTotals = "//button[text()='Calculate Totals']";
	String txtAreaAssessment = "//label[text()='Assessment']/following-sibling::div//textarea";
	String btnApproveClaim = "//button[text()='Approve']";
	String btnCloseAfterApprove = "//button[@title='Close']";
	String labelApprovedAmount = "//span[text()='Total Approved Amount']/following-sibling::div//span[@data-ctl='Text']";

	// Form of release
	String chkBoxApprovedByManager = "//label[text()='Approved by Manager?']/following-sibling::div/input[@type='checkbox']";
	String dropDownSendForm = "//label[text()='Send the form of release to the customer?']/following-sibling::div/select";
	String dropDownFormOption = "//label[text()='Form of Release Options']/following-sibling::div/select";
	String radioWithAssessment = "//label[text()='With Assessment']/parent::span/input[@type='radio']";

	// Payment details
	String dropDownPayment = "//tr[@pl_index='1']/td[@data-attribute-name='Transaction Type']//select";
	String calendarTransactionDate = "//tr[@pl_index='1']/td[@data-attribute-name='Transaction Date']//img[@aria-label='Open date picker']";
	String inpReference = "//tr[@pl_index='1']/td[@data-attribute-name='Reference Number']//input";
	String inpPayee = "//tr[@pl_index='1']/td[@data-attribute-name='Payee']//input";
	String inpTransactionAmount = "//tr[@pl_index='1']/td[@data-attribute-name='Transaction Amount']//input";
	String inpDescription = "//tr[@pl_index='1']/td[@data-attribute-name='Description']//input";

	String dropDownClaimClosure = "//label[text()='Closure Reason']/following-sibling::div/select";
	String headerClaimCaseStatus = "//span[text()='Claim']/parent::div/following-sibling::div/following-sibling::div//span[@class='badge_text']";

	String calendarPicker = "//img[@role='button' and @alt='Choose from calendar']";
	String calendarNextMonth = "//button[@aria-label='Next Month']";
	String calendarPreviousMonth = "//button[@aria-label='Previous month']";
	String calendarNextHour = "//button[@aria-label='Next hour']";
	String calendarPreviousHour = "//button[@aria-label='Previous hour']";
	String calendarDatePick = "//a[@data-day='%s']";
	String calendarAMPM = "//button[@aria-label='%s']";

	// Hardship
	String chkBoxAssessmentComplete = "//label[text()='Assessment Completed']/following-sibling::div/input[@type='checkbox']";

	String inpTotalApprovedAmount = "//label[text()='Total Amount Approved']/following-sibling::div//input[@type='text']";
	String inpNumberOfInstallments = "//label[text()='Number Of Installments']/following-sibling::div//input[@type='number']";
	String inpFreqOfPayments = "//label[text()='Frequency of payments']/following-sibling::div//input[@type='text']";
	String inpFinalPayment = "//label[text()='Final Payment']/following-sibling::div//input[@type='text']";
	String labelInstallmentAmount = "//span[text()='Installment Amount']/following-sibling::div//span[@data-ctl='Text']";
	String textAreaRecommendation = "//label[text()='Recommendations']/following-sibling::div//textarea";

	String chkBoxHardshipApproveFlag = "//label[text()='Hardship Approved Flag']/following-sibling::div/input[@type='checkbox']";
	String textAreaApproveComment = "//label[text()='Approver Comments']/following-sibling::div//textarea";

	String inpDescGoods = "//label[text()='Description of Good/Service Expense Element']/following-sibling::div//input";
	String inpExpenseEle = "//label[text()='Expense Element']/following-sibling::div//input";
	String inpWorkOrder = "//label[text()='Work Order/Cost Centre']/following-sibling::div//input";
	String inpGSTCode = "//label[text()='GST Code']/following-sibling::div//input";
	String inpGSTExAmount = "//label[text()='GST Exclusive Amount']/following-sibling::div//input";
	String inpGSTInAmount = "//label[text()='GST Inclusive Amount']/following-sibling::div//input";
	String inpGSTAmt = "//label[text()='GST Amt If Applicable']/following-sibling::div//input";

	String dropDownModeOfReminder = "//label[text()='Mode Of Reminder']/following-sibling::div//select";
	String calendarPaymentDue = "//label[text()='Payment Due Date']/following-sibling::div//img";
	String chkBoxPaymentCredited = "//label[text()='Payment Credited']/following-sibling::div//input[@type='checkbox']";
	
	//Manual Correspondence
	String dropDownTemplate ="//label[text()='Template']/following-sibling::div//select";
	String inpToEmailManualCorro = "//label[text()='To']/following-sibling::div//input";
	
}