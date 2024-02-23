package com.ABS.ataf.PegaApp.PageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.configreader.ConfigReader;
import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.stepdef.Pega.CustomerInteractionStepdef;
public class ReportsPage extends SeleniumFunc implements ReportsPageLoc {

	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	CustomerInfoPage custpage=new CustomerInfoPage(driver);
	public static int caseCount;
	public ReportsPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateReportIsVisible(String reportTitle) {
		try {
			SeleniumFunc.xpath_Genericmethod_verifyElementPresent(lnkReportName.replace("{reportTitleVariable}",reportTitle));	
			return true;
		}catch(Exception e) {
			log.error("Report is not visible");
			return false;
		}
		
	}
	
	public void clickReport(String reportName) {
		try {
			if(validateReportIsVisible(reportName))
			{
				SeleniumFunc.xpath_GenericMethod_Click(lnkReportName.replace("{reportTextVariable}", reportName));
				waitForReportToOpen(reportName);
				
			}	
		}catch(Exception e) {
			log.error("Report is not visible and click has failed");
		}	
	}
	
	public Boolean validateColumnValue(String columnName, String expectedValue) {
		
		Boolean columnValueMatches=false;
		
		try {
			columnValueMatches=xpath_Genericmethod_VerifyTextEquals(txtColumnValue.replace("{columnNameVariable}",columnName), expectedValue);
		
		}catch(Exception e) {
			log.error("Column value is not found");
			
		}
		return columnValueMatches;
	}
	
	public void waitForReportToOpen(String reportName) {
		try {
			waitForElement(driver.findElement(By.xpath(lblReportHeader.replace("{reportHeaderVariable}","reportName"))),2);
		xpath_GenericMethod_Click(lblReportHeader.replace("{reportHeaderVariable}","reportName"));			
		}
		catch(Exception e) {
			log.error("Report header not found");
		}
	}
	
	
	public void filterCaseIDColumn(String reportTitle) {
		try {
			System.out.println("Inside case column filter");
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElements(By.xpath(frmReport.replace("{reportTitleVariable}",reportTitle))).size());
		
			//xpath_GenericMethod_Click(lnkcolumnFilterMenu);
			if(driver.findElements(By.xpath(lnkCaseIDColumnFilterMenu)).size()!=0) {
				xpath_GenericMethod_Click(lnkCaseIDColumnFilterMenu);
			}
			else if(driver.findElements(By.xpath(lnkWorkIDColumnFilterMenu)).size()!=0) {
				xpath_GenericMethod_Click(lnkWorkIDColumnFilterMenu);
			} 
			else {
				xpath_GenericMethod_Click(lnkCaseNumberColumnFilterMenu);
			}
			xpath_GenericMethod_Click(lnkfilterMenu);
			waitFor(2);
			System.out.println("Got case id:"+ObjectRepo.reader.getTempCaseId().toString());
			xpath_GenericMethod_Sendkeys(inpFilteringInput,ObjectRepo.reader.getTempCaseId().toString());
			xpath_GenericMethod_Click(btnApply);
		}catch(Exception e) {
			log.error("Fitering for case id column is not working");
		}
	}
	
	public int returnRowCountFromReport() {
		int rowCount=0;
		try {
			rowCount= xpath_GenericMethod_listElements(tblCASReportsResults).size();
			System.out.println("no. of rows "+rowCount);
		}catch(Exception e) {
			log.error("Failed to get record count from report");			
		}
		return rowCount;
	}
	
	public void clickReportCategory() {
		try {
			xpath_GenericMethod_Click(lnkCASReportCategory);
		}catch(Exception e) {
			log.error("Failed to click on report category");
		}
	}
	
	public void verifyRownInCasesCreatedInPastReport() {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElements(By.xpath(frmReport.replace("{reportTitleVariable}","CAS Cases Created in Past"))).size());
			xpath_Genericmethod_verifyElementPresent(txtCasesCreatedInPastBreachInv);
			xpath_Genericmethod_verifyElementPresent(txtCasesCreatedInPastClaim);
			xpath_Genericmethod_verifyElementPresent(txtCasesCreatedInPastComplaints);
			xpath_Genericmethod_verifyElementPresent(txtCasesCreatedInPastCSS);
			xpath_Genericmethod_verifyElementPresent(txtCasesCreatedInPastGeneralEnquiry);
			xpath_Genericmethod_verifyElementPresent(txtCasesCreatedInPastHardship);
			xpath_Genericmethod_verifyElementPresent(txtCasesCreatedInPastALL);
		}catch(Exception e) {
			log.error("Rows in the Cases Created In Past Report do not match");
		}
	}
		public void clickAll() {
			try {
				driver.switchTo().defaultContent();
				xpath_GenericMethod_Click(txtCasesCreatedInPastALL);
			}catch(Exception e) {
				log.error("Click on ALL failed");
			}
		}
		
		public void clickServiceCaseInSummaryCase(String reportTitle,String serviceCase) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElements(By.xpath(frmReport.replace("{reportTitleVariable}",reportTitle))).size());
				getCaseCountFromSummaryReport(reportTitle,serviceCase);

				xpath_GenericMethod_Click(txtServiceCaseLabelInSummaryReport);
							}catch(Exception e) {
				log.error("Click on service case failed");
			}
		}
		
		public int getCaseCountFromSummaryReport(String reportTitle,String serviceCase) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElements(By.xpath(frmReport.replace("{reportTitleVariable}",reportTitle))).size());
			
				String count = xpath_Genericmethod_getElementText(txtServiceCaseCountInSummaryReport.replace("{serviceCaseLabel}",serviceCase));
				caseCount=Integer.parseInt(count);
			}catch(Exception e) {
				log.error("count for service case is not calculated");
			}
			return caseCount;
		}
		
		public Boolean validateCaseCountInIncreased(String reportTitle,String serviceCase) {
			try {
				
				if(caseCount < getCaseCountFromSummaryReport(reportTitle,serviceCase));
				{
				System.out.println("Case count is increased");
				return true;
				}
				
			}catch(Exception e) {
				return false;
			}
		}
		
		public Boolean clickReportAndValidateServiceCaseCount(String reportName,String serviceCase) {
			Boolean countIncreased= false;
			try {
				if(validateReportIsVisible(reportName))
				{
					SeleniumFunc.xpath_GenericMethod_Click(lnkReportName.replace("{reportTextVariable}", reportName));
					waitForReportToOpen(reportName);
					countIncreased = validateCaseCountInIncreased(reportName,serviceCase);
				}	
			}catch(Exception e) {
				log.error("Report is not visible and click has failed");
			}	
			return countIncreased;
		}
		
}