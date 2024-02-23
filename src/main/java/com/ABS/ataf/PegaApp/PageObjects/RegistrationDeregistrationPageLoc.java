package com.ABS.ataf.PegaApp.PageObjects;

public interface  RegistrationDeregistrationPageLoc {
	
	
	//XPath Of Nominate Customer Form
	String chkNominatePrimaryContact="//input[@name='$PpyWorkPage$pIsPrimaryContactRequired'][2]";
	
	String dropPrefix="//select[@title='Select Prefix']";
	
	String inpFirstName="//input[@title='First Name']";
	
	String inplastName="//input[@title='Last Name']";
	
	String inpEmailAdd="//input[@title='Primary email']";
	
	String inpMobileNumber="//input[@type='text'][@name='$PpyWorkPage$ppyWorkParty$gPrimaryContact$pPrimaryPhoneNumber']";
	
    String inpSecondaryNumber="//input[@name='$PpyWorkPage$ppyWorkParty$gPrimaryContact$pSecondaryPhoneNumber']";
	
    String inpPrimaryAdd="//input[@name='$PpyWorkPage$ppyWorkParty$gPrimaryContact$pAddressDetails$gHOM$pGooglePlaceAddress']";
   
    String chkOnCopyPrimaryAdd="//input[@type='checkbox'][@name='$PpyWorkPage$ppyWorkParty$gPrimaryContact$pIsPrimaryAddressAsServiceAddress']";
    
    String labelCaseId="//div[@class='content-item content-field item-1 flex flex-row flex-align-center dataValueRead custom-control']/following-sibling::div[starts-with(@class,'content-item content-field item-2')]/span";
   
    String btnSubmit="//button[@title='Complete this assignment']";
    
    //XPath to Check RELATIONSHIP SUMMARY
    String labelLifeSupportStatusRegistered= "//span[@class='lsstatus']";
    
    String labelCustomerStatusActive="//div[@class='content-item content-field item-3 remove-all-spacing flex urgency urgency-high']//div[@class='field-item dataValueRead']";
 
    String lableStatus="//span[text()='Status']/following-sibling::div/span";
    
    String btnConfirmTaskCase="//button[@title='Confirm']";
    
    String btnLifeSupportRegpageconfirm="//span[contains(text(),'Resolved')]/ancestor::div[@section_index='4']//button[@title='Confirm']";
    
    String linkQueueForBingHyperlink="//a[contains(text(),'Queue for Bing Processing')]";
    
    String btnyestocontinue="//button[@title='Complete this assignment']";

    String linkReminderNotificationsnoHyperlink="//a[contains(text(),'Reminder Notifications')]";
    
    String lableRegisterdStatus="//label[text()='Life Support Status']/following-sibling::div/select";
    
    String chkMedicalConfirmation="//label[text()='Reason Code']/following-sibling::div/select";
    
    String btnClickSubmit="//div[@data-methodname='simpleLayout_6']//button[text()='Submit']";
    
    //XPath Of Set Extension Request 
    String dropSetExtensionThreeDots="//ancestor::div[@data-methodname='simpleLayout_6']//i";
    
    String clickSetExtendedReq="//span[contains(text(),'Set Extension Request')]";
    
    String clickExtended="//input[@type='checkbox'][@name='$PpyWorkPage$pLSDetails$pIsExtentionRequired']"; 
    
    String dropdowLifeSupportstatus="//select[@id='8b2bf0a1'][@name='$PpyWorkPage$pLSDetails$pInitialLSStatus']";
    String dropDwnRegistrationStage = "//label[text()='Registration Stage']/following-sibling::div/select";
    String radioYesNoResetClock = "//label[text()='%s']/preceding-sibling::input";
    //XPath of DeRegistration Flow
    
    String btnCustomer="//label[text()='Customer']";
    String btnFinish="//div[text()='Finish']";
    String linkWaitCustRes="//a[text()='Wait for Customer Response (Processing)']";
    String chkCustomerResponded="//span[@class='checkbox']//input[2]";
    String chkAccept="//label[text()='Accept']";
    String dropdowResoneCode="//select[@name='$PpyWorkPage$pLSDetails$pInitialReasonCode']";
    String btnRadioDeny="//label[text()='Deny']";
    String inpComment="//span[@class='textAreaExpandStyle ']//textarea";
    String labellifeSstatusDeregistered="//div[contains(@class,'content-item content-field item-2 remove-all-spacing flex')]//span[contains(text(),'Deregistered')]";
    String labelCusStatusInactive="//div[contains(@class,'content-item content-field item-4 remove-all-spacing flex')]//span[contains(text(),'Inactive')]";
    
    //XPath OF Retailer De_registration
    
    String btnRetailer="//label[text()='Retailer']";
    String btnRedioRpo="//label[text()='Yes']";
    String btnRedioRpoNo= "//label[text()='No']";
    String LinkWait="//a[normalize-space()='Wait (Intake)']";
    
}