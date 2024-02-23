package com.ABS.ataf.PegaApp.PageObjects;

public interface ReportsPageLoc {

	String lnkMyReports = "//a//span[text()='My Reports']";
	String lblRecentReports= "//label[text()='    Showing recent reports    ']";
	String inpSearchReports="//input[@placeholder='Search reports']";
	String lnkReportName="//a[text()='{reportTextVariable}']";
	String lblReportHeader = "//h1[text()='{reportHeaderVariable}']";
	String lnkCaseIDColumnFilterMenu= "//th[@data-attribute-name='Case ID']//a[@title='Open Menu']";
	String lnkCaseNumberColumnFilterMenu= "//th[@data-attribute-name='Case Number']//a[@title='Open Menu']";
	String lnkWorkIDColumnFilterMenu= "//th[@data-attribute-name='Work ID']//a[@title='Open Menu']";
	String lnkfilterMenu = "//div[@class != 'menu-panel-wrapper']//li[@title='Click to filter']";
	String txtColumnValue="//td[@data-attribute-name='{columnNameVariable}']//span";
	String inpFilteringInput = "//input[contains(@name,'FilterCriteria') and contains(@name,'SearchText')]";
	String btnApply="//button[text()='Apply']";
	String frmReport = "//iframe[@title='{reportTitleVariable}']";
	String tblCASReportsResults="//table[@summary='All Records' and contains(@pl_prop_class,'EE-CS-CAS-Work')]";
	String lnkCASReportCategory = "//a[text()='1_CAS REPORTS']";
	String txtCasesCreatedInPastBreachInv="//tr[contains(@id,'GrandTotal')]//span[contains(text(),'Breach Investigation')]";
	String txtCasesCreatedInPastClaim="//tr[contains(@id,'GrandTotal')]//span[contains(text(),'Claim')]";
	String txtCasesCreatedInPastComplaints="//tr[contains(@id,'GrandTotal')]//span[contains(text(),'Complaints')]";
	String txtCasesCreatedInPastCSS="//tr[contains(@id,'GrandTotal')]//span[contains(text(),'Customer Service Standards')]";
	String txtCasesCreatedInPastGeneralEnquiry="//tr[contains(@id,'GrandTotal')]//span[contains(text(),'General Enquiry')]";
	String txtCasesCreatedInPastHardship="//tr[contains(@id,'GrandTotal')]//span[contains(text(),'Breach Investigation')]";
	String txtCasesCreatedInPastALL = "//tr[contains(@id,'GrandTotal')]/td[@ddaggpath='1']";
	String txtServiceCaseLabelInSummaryReport="//td[contains(text(),'{serviceCaseLabel}')]";
	String txtServiceCaseCountInSummaryReport="//td[contains(text(),'{serviceCaseLabel}')]//parent::tr//span";
}
