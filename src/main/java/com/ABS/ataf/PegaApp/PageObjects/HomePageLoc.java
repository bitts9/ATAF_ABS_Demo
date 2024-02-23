package com.ABS.ataf.PegaApp.PageObjects;

public interface HomePageLoc {

	String btnNew = "//span[@class='menu-item-icon-imageclass pi pi-plus']/parent::span/parent::a";
	String btnPaymentReq = "//span[@class='menu-item-title' and text()='Payment Request']";
	String btnContinue = "//button[text()='Continue']";
	String msgErrorField = "//span[@class='iconError dynamic-icon-error']";
	String inpCluster = "//input[contains(@name,'Cluster')]";
	String rowSuggestion = "//span[@class='match']";
	String inpCountry = "//input[contains(@name,'pCountry')]";
	String inpCompany = "//input[contains(@name,'pCompanyCode')]";
	String inpLineManager = "//input[contains(@name,'pLineManager')]";
	String dropDwnReqType = "//select[contains(@name,'pRequestType')]";
	String dropDwnPO = "//select[contains(@name,'pIsPOContractBased')]";
	String dropDwnInvoice = "//select[contains(@name,'pIsInvoiceCopyAvailable')]";
	String dropDwnBankDetail = "//select[contains(@name,'pIsBankDetailsDocToBeAttached')]";
	String textAreaReason = "//textarea[contains(@name,'pReasonForReqManualPayment')]";
	String inpInvNumber = "//input[contains(@name,'pInvoiceNumber')]";
	String dropDwnCurrency = "//select[contains(@name,'pCurrency')]";
	String inpAmount = "//input[contains(@name,'pAmountToBePaid')]";
	String inpPONumber = "//input[contains(@name,'pPONumber')]";
	String inpToBePaidDate = "//input[contains(@name,'pToBePaidBy')]";
	String inpVendorName = "//input[contains(@name,'pVendorInfo$pName')]";
	String inpVendorNum = "//input[contains(@name,'pVendorInfo$pNumber')]";
	String inpBankName = "//input[contains(@name,'pBankDetails$pName')]";
	String inpBankCode = "//input[contains(@name,'pBankDetails$pCode')]";
	String inpAccNum = "//input[contains(@name,'pBankDetails$pAccountNumber')]";
	String inpSwiftCode = "//input[contains(@name,'pBankDetails$pSWIFTCode')]";
	String inpIBANCode = "//input[contains(@name,'pBankDetails$pIBANNumber')]";
	String btnAttachDoc = "//button[contains(@data-ctl,'AttachContent')]";
	String btnSelectFile = "//input[@title='Select file(s)']";
	String btnAttach = "//button[@title='Attach']";
	String btnFinish = "//button[text()='Finish']";
	String submissionLabel = "//div[@class='content-item content-label item-1 remove-all-spacing flex flex-row dataLabelRead']";

	
	
	
	String profile = "//button[starts-with(@class,'icons avatar name')]";
	String logofflink = "//span[text()='Logout' or text()='Log off']/parent::span/parent::a";
	String managerProfileMenu = "//a[@title='Click to select option']";
	String switchPortalOption = "//span[text()='Switch portal']";
	String optionInteractionPortal = "//span[text()='Interaction Portal']";
	String optionBackOfficePortal = "//span[text()='Back office portal']";
	String closeTabsButton = "//span[@role='button' and @title='Close Tab']";
	String menuCloseAll = "//a/span[@id='TABSPAN']";
	String optionCloseAll = "//td[@title='Close All']";
	
	
	
	String menuBurger = "//button[@id='react-burger-menu-btn']";
	String linkLogout = "//a[text()='Logout']";
	
	// XPath for HomePage NewButton

	// XPath for Phone call
	String phoneCall = "//span[contains(text(),'Phone call')]";

	// XPath for searchBar
	String inpSearchBar = "//button[@id='react-burger-menu-btn']";

	// XPath for search icon (circle)
	String searchIcon = "//i[@class='pi pi-search-2 pi-regular']";

	// Case result row
	String caseResultRowAction = "//span[text()='%s']/parent::div/parent::td/following-sibling::td//button//i";
	String startResearchOption = "//span[text()='Start research']";

	// Search Customer XPath
	String customerSearchLabel = "//h6[@role='presentation']";
	String inplastNameCustomerSearch = "//input[@title='Search string last name']";
	String inpNMINumberCustomerSearch = "//input[@title='Search String Account Number']";
	String btnSearchCustomerSearch = "//button[@title='Search']";
	String btnClearCustomerSearch = "//button[@title='Clear']";
	String rowNMIValue = "//tr[@pl_index='1']/td[@data-attribute-name='NMI']//span";
	String labelMessage = "//div[@id='DialogContent']";
	// Search customer --> Three dot customer search

	String menuThreeDotCustomerSearch = "//i[@class='pi pi-more pi-blue pi-medium']";


}
