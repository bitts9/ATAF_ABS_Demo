package com.ABS.ataf.NonPegaApp.PageObjects;

public interface ServiceRequirePageLoc {
	
	//XPath Of What service do you require?
	String linkHome = "//a[text()='Home']";
	String btnServices="//button[contains(text(),'%s')]/img";

	//XPath Of Site Details
	String inpFindSiteDetails="//input[@title='Find Site Details']";
	String btnSearch="//button[@title='Search']";
	String btnSelectAsset="//div[@title='Select Asset']";
	String chkMainAddress="//input[@type='checkbox']";
	String btnContinue="//button[normalize-space()='Continue'][@title='Complete this assignment']";
	String btnSave = "//button[text()='Save']";
	String btnSaveAndClose = "//button[text()='Save and close']";
	
	//XPath Of Application Details
	String labelGenericConnectionService="//label[text()='%s']";
	String dropdowSelectTypeDev="//select[@class='standard']";
	String labelSinglePhase="//label[@for='8d47a24cSinglePhase']";
	String inpExistingLoad="//input[@name='$PpyWorkPage$pServiceDetails$pLoadDetails$l1$pAPhase']";
	String inpRemovedLoad="//input[@name='$PpyWorkPage$pServiceDetails$pLoadDetails$l2$pAPhase']";
	String inpNewLoad="//input[@name='$PpyWorkPage$pServiceDetails$pLoadDetails$l3$pAPhase']";
	String btnAddNmi="//a[text()='Add NMI']/i";
	String inpNmi="//input[@title='NMI is 10 digit/alphanumeric']";
	String imgcalendarConnectionDate="//input[@name='$PpyWorkPage$pServiceDetails$pRequestedServiceDate']/following-sibling::img";
	String inpDateTime="//input[@name='$PpyWorkPage$pServiceDetails$pRequestedServiceDate']";
	String inpFurtherAppDetails="//textarea[@class='TANORM textAreaStyle']";

	//XPath Of Supporting Documents New Connection 
	String btnAttachDoc="//button[@name='AttachSuportingDocuments_pyWorkPage_debd5fdf-b362-4f2e-9661-ce83a399f00b']";
	String btnSelectFile="//input[@id='$PpyAttachmentPage$ppxAttachName']";
	String btnAttach="//button[@title='Attach']";
	String chkSitePlan="//label[contains(text(),'Site Plan')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkDocConfirm="//label[contains(text(),'Documentation confirming')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkMaxDeCal ="//label[contains(text(),'AS3000 Maximum')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkDaCDC="//label[contains(text(),'Development Agreement (DA)')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String inpCommentBox="//span[@class='textAreaExpandStyle ']//textarea";
	//XPath Of Supporting Documents Subdivision
	String chkFinalPlanSubdivision="//label[contains(text(),'Final Plan')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkLatestCouncil="//label[contains(text(),'Latest Council')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkFinalDepositedPlan="//label[contains(text(),'Final Deposited')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";		
	
	//XPath of Supporting Documents Generator
	String chkSingleLine="//label[contains(text(),'Single line diagram')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkLocationSketch="//label[contains(text(),'Location/Sketch Diagram')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkVoltage="//label[contains(text(),'Voltage Measurement and calculations')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	
	//XPath of Supporting Documents Embedded Network
	String chkListOfNmi="//label[contains(text(),'List of NMI outside the Embedded Network')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkSwitchboard="//label[contains(text(),'Switchboard Compliance Statement')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkConfirmation="//label[contains(text(),'Confirmation')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkConstruction="//label[contains(text(),'Construction')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	String chkSingleDiagram="//label[contains(text(),'Single Line Diagram')]/preceding-sibling::input[@type='checkbox' and @role='gridcell']";
	
	//XPath Of Contact Details 
	String inpAddress="//input[@name='$PpyWorkPage$pServiceDetails$pApplicationContacts$gApplicant$pGooglePlace']";
	String chkSameAsApplicant="//input[@name='$PpyWorkPage$pServiceDetails$pIsSameAsApplicantDetails'][2]";
	String btnASPSApplication="//label[text()='No']";
	String btnASLoadApplicationNo="//label[text()='Is there an associated load application with your embedded network application?']/following-sibling::div//label[text()='No']";

	//XPath Of Review Page 
	String labelVerifyAddress="//td[@data-attribute-name='Address']//span";
	String labelVerifyNmiInfo="//td[@data-attribute-name='NMI']//span";
    
	//XPath Of Legal Disclaimer
	String chkApplicantAcceptance="//input[@name='$PpyWorkPage$pServiceDetails$pAcceptLegalDisclaimer'][2]";
	String btnSubmitLegalDisclaimer="//button[text()='Submit']";

	//XPath Of Payment Lodgement
	String btnPaymentLodgement="//button[normalize-space()='Proceed To Payment']";
	
	//XPath Of Review Cart
	String btnMakePayment="//button[text()='Confirm & Make Payment']";
	String btnClearCart = "//button[text()='Clear Cart']";
	String btnConfirmClearCart = "//button[contains(@name,'ClearCartConfirmation') and text()='Confirm']";
	
	//XPath OF Payment Details 
	String labelbPay="//label[text()='BPAY']";
	String labelAccount="//label[text()='Account']";
	String labelCreditCard="//label[normalize-space()='Credit Card']";
//	String btnPay="//button[normalize-space()='Pay']";
	String btnProcced="//button[normalize-space()='Proceed']";
	String btnPay="//button[text()='Pay']";
	String inpCardType="//input[@id='card_type_001']";
	String inpCardNumber="//input[@id='card_number']";
	String inpExpiryMonth="//select[@id='card_expiry_month']";
	String inpExpiryYear="//select[@id='card_expiry_year']";
	String inpCvn="//input[@id='card_cvn']";
	String chkPayPayment="//input[@class='right complete pay_button ']";
	String btnClose="//button[normalize-space()='Close']";
	
   //XPath Of Subdivisions
	String btnSuitableConnection="//label[text()='Yes']";
	
	
     // XPath Of Generator
    //XPath Of Generator Capacity
	String inpExistingkW="//input[@name='$PpyWorkPage$pServiceDetails$pGeneratorCapacity$l1$pLoadValue']";
	String inpNewkW="//input[@name='$PpyWorkPage$pServiceDetails$pGeneratorCapacity$l2$pLoadValue']";
	String inpRemovedkW="//input[@name='$PpyWorkPage$pServiceDetails$pGeneratorCapacity$l3$pLoadValue']";
	
	//XPath of inverter rating
	String inpInverterExistingkW="//input[@name='$PpyWorkPage$pServiceDetails$pInverterRating$l1$pLoadValue']";
	String inpInverterNewkW="//input[@name='$PpyWorkPage$pServiceDetails$pInverterRating$l2$pLoadValue']";
	String inpInverterRemovedkW="//input[@name='$PpyWorkPage$pServiceDetails$pInverterRating$l3$pLoadValue']";
	
	//XPath comment of application details generator 
	String inpManufacturerName="//input[@name='$PpyWorkPage$pServiceDetails$pManufacturerName']";
	String inpCecNumber="//input[@name='$PpyWorkPage$pServiceDetails$pCECCertificateNumber']";
	
	//XPath of Unmetered Supply / Special Small Service
	String inpCustomerAssetNo="//input[@name='$PpyWorkPage$pServiceDetails$pCustomerAssetID']";
	String inpMaximumDemand="//input[@name='$PpyWorkPage$pServiceDetails$pMaxDemand']";
	String dropdowDutyCycle="//select[@name='$PpyWorkPage$pServiceDetails$pDutyCycle']";

	//XPath of Public Lighting Assets
	String inpPublicLightingWorks="//span[@class='textAreaExpandStyle ']//textarea";
	String inpCompanyName="//input[contains(@name,'CompanyName')]";
	String inpContactPersonName="//input[contains(@name,'ContactName')]";
	String inpConatctNumber="//input[contains(@name,'ContactNumber')]";
	String inpEmailAddress="//input[@type='email']";
	
	//Payment verify successfully
	String labelBpayAccountCCPayVerify="//div[@string_type='label' and @class='content-item content-label item-1 remove-left-spacing remove-right-spacing flex flex-row dataLabelRead ee_header_label_dataLabelRead custom-control']";


}
