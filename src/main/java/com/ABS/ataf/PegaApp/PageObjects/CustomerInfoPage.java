package com.ABS.ataf.PegaApp.PageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.utility.DateFinder;

public class CustomerInfoPage extends SeleniumFunc implements CustomerInfoPageLoc {
	private final Logger log = LoggerHelper.getLogger(CustomerInfoPage.class);
	CustomerInfoPage custpage;

	public CustomerInfoPage(WebDriver driver) {
		super(driver);
	}

	public void sendCustInfoObject(CustomerInfoPage custpage) {
		this.custpage = custpage;
	}

	public void createTask(String taskname) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(addTaskPopup);
		waitFor(1);
		String fullXpath = String.format(genericTaskXpath, taskname);
		System.out.println(fullXpath);
		xpath_GenericMethod_Click(fullXpath);
		xpath_GenericMethod_Click(btnAddTasks);
	}

	public void wrapupCall() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnWrapup);
		waitFor(1);
		waitForElementXpath(btnWrapupSubmit, 10);
		xpath_GenericMethod_Click(btnWrapupSubmit);
		xpath_GenericMethod_scrollIntoView(headerMyWork);
	}

	public static void clickSuggestionGeneric(String valueofSuggestion) throws Exception {
		String fullXpath = String.format(genericXpathComplaintInputs, valueofSuggestion);
		System.out.println(fullXpath);
		xpath_GenericMethod_Click(fullXpath);
	}

	public static void typeinClaimTableGeneric(String xpath, int numToFill, String valueofSuggestion) throws Exception {
		String fullXpath = String.format(xpath, numToFill);
		System.out.println(fullXpath);
		xpath_GenericMethod_Sendkeys(fullXpath, valueofSuggestion);
	}

	public static void clickGenericBasedOnInteger(String xpath, int valuetoFill) throws Exception {
		String fullXpath = String.format(xpath, valuetoFill);
		System.out.println(fullXpath);
		xpath_GenericMethod_Click(fullXpath);
	}

	public static void clickGenericBasedOnString(String xpath, String valuetoFill) throws Exception {
		String fullXpath = String.format(xpath, valuetoFill);
		System.out.println(fullXpath);
		xpath_GenericMethod_Click(fullXpath);
	}

	public void selectCustomerType(String customertypeVal) throws Exception {
		waitForElement(driver.findElement(By.xpath(inpCustomerType)), 20);
		xpath_GenericMethod_Clear(inpCustomerType);
		xpath_GenericMethod_Sendkeys(inpCustomerType, customertypeVal);
		waitFor(1);
		clickSuggestionGeneric(customertypeVal);
	}

	public void sendForApproval(String noInstallmentVal, String amountApprovedVal, String freqVal, String finalPayVal)
			throws Exception {
		xpath_GenericMethod_Sendkeys(inpNumberOfInstallments, noInstallmentVal);
		xpath_GenericMethod_Sendkeys(inpTotalApprovedAmount, amountApprovedVal);
		xpath_GenericMethod_Sendkeys(inpFreqOfPayments, freqVal);
		clickSuggestionGeneric(freqVal);
		xpath_GenericMethod_Sendkeys(inpFinalPayment, finalPayVal);
		xpath_GenericMethod_Sendkeys(textAreaRecommendation, "Recommended approval");
	}

	public void verifyInstallment(String noInstallmentVal, String amountApprovedVal, String freqVal, String finalPayVal)
			throws Exception {
		double noInstallment = Double.parseDouble(noInstallmentVal);
		double amountApproved = Double.parseDouble(amountApprovedVal);
		double finalPay = Double.parseDouble(finalPayVal);
		double expectedInstallmentAmount = (amountApproved - finalPay) / noInstallment;
		expectedInstallmentAmount = Math.round(expectedInstallmentAmount * Math.pow(10, 2)) / Math.pow(10, 2);
		double actualInstallmentAmount = Double
				.parseDouble(xpath_Genericmethod_getElementText(labelInstallmentAmount).split("\\$")[1]);
		actualInstallmentAmount = Math.round(actualInstallmentAmount * Math.pow(10, 2)) / Math.pow(10, 2);
		if (expectedInstallmentAmount == actualInstallmentAmount) {
			Assert.assertTrue(true, "Installment amount verified");
			waitFor(1);
			xpath_GenericMethod_Click(btnSubmitEdit);
		} else {
			Assert.assertFalse(false, "Installment amount not as expected");
		}
	}

	public void approveHardship() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(chkBoxHardshipApproveFlag);
		xpath_GenericMethod_Sendkeys(textAreaApproveComment, "Approved");
		xpath_GenericMethod_Click(btnApproveClaim);
	}

	public void submitBillingSheet(String desGoodsVal,String expEleVal,String workOrderVal,String gstCodeVal,String gstExVal,String gstAmtVal,String gstInVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpDescGoods,desGoodsVal );
		xpath_GenericMethod_Sendkeys(inpExpenseEle,expEleVal );
		xpath_GenericMethod_Sendkeys(inpWorkOrder,workOrderVal );
		xpath_GenericMethod_Sendkeys(inpGSTCode,gstCodeVal );
		xpath_GenericMethod_Sendkeys(inpGSTAmt, gstAmtVal);
		xpath_GenericMethod_Sendkeys(inpGSTExAmount,gstExVal );
		xpath_GenericMethod_Sendkeys(inpGSTInAmount,gstInVal );
		xpath_GenericMethod_Click(btnSubmitEdit);
		waitFor(2);
	}
	
	public void processCustomerResponse(String reminderVal) throws Exception {
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownModeOfReminder,reminderVal );
		String futurePayDate= DateFinder.getPastDate(10);
		setCalendarDate(calendarPaymentDue, futurePayDate);
		xpath_GenericMethod_Click(chkBoxPaymentCredited);
		xpath_GenericMethod_Click(btnSubmitEdit);
	}

	public void selectComplaintType(String complainttypeVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpComplaintType, complainttypeVal);
		waitFor(1);
		clickSuggestionGeneric(complainttypeVal);
	}

	public void selectSource(String sourceVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpSource, sourceVal);
		waitFor(1);
		clickSuggestionGeneric(sourceVal);
	}

	public void selectFault(String faultVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpFaultStatus, faultVal);
		waitFor(1);
		clickSuggestionGeneric(faultVal);
	}

	public void selectCategory(String categoryVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpCategory, categoryVal);
		waitFor(1);
		clickSuggestionGeneric(categoryVal);
	}

	public void selectSubCategory(String subCategoryVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpSubCategory, subCategoryVal);
		waitFor(1);
		clickSuggestionGeneric(subCategoryVal);
	}

	public void setDefectNumber(String defectVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpDefectNumber, defectVal);
	}

	public void setHardshipDetailText(String detailVal) throws Exception {
		xpath_GenericMethod_Sendkeys(textAreaDetailsHardship, detailVal);
	}

	public void fillBalanceSheet(String applianceoneamountVal, String appliancetwoamountVal,
			String appliancethreeamountVal) throws Exception {
		List<WebElement> eles = xpath_GenericMethod_listElements(rowClaimItem);
		int size = eles.size();
		if (size == 2) {
			typeinClaimTableGeneric(inpClaimAmountGeneric, 1, applianceoneamountVal);
			typeinClaimTableGeneric(inpClaimAmountGeneric, 2, appliancetwoamountVal);
			typeinClaimTableGeneric(inpAgeOfItemGeneric, 1, "2");
			typeinClaimTableGeneric(inpAgeOfItemGeneric, 2, "2");
			typeinClaimTableGeneric(inpLifeSpanGeneric, 1, "20");
			typeinClaimTableGeneric(inpLifeSpanGeneric, 2, "20");
			clickGenericBasedOnInteger(chkBoxSelectClaimRowGeneric, 1);
			clickGenericBasedOnInteger(chkBoxSelectClaimRowGeneric, 2);
		} else if (size > 2) {
			typeinClaimTableGeneric(inpClaimAmountGeneric, 1, applianceoneamountVal);
			typeinClaimTableGeneric(inpClaimAmountGeneric, 2, appliancetwoamountVal);
			typeinClaimTableGeneric(inpClaimAmountGeneric, 3, appliancethreeamountVal);
			typeinClaimTableGeneric(inpAgeOfItemGeneric, 1, "2");
			typeinClaimTableGeneric(inpAgeOfItemGeneric, 2, "2");
			typeinClaimTableGeneric(inpAgeOfItemGeneric, 3, "2");
			typeinClaimTableGeneric(inpLifeSpanGeneric, 1, "20");
			typeinClaimTableGeneric(inpLifeSpanGeneric, 2, "20");
			typeinClaimTableGeneric(inpLifeSpanGeneric, 3, "20");
			clickGenericBasedOnInteger(chkBoxSelectClaimRowGeneric, 1);
			clickGenericBasedOnInteger(chkBoxSelectClaimRowGeneric, 2);
			clickGenericBasedOnInteger(chkBoxSelectClaimRowGeneric, 3);
		}
		waitFor(1);
		xpath_GenericMethod_Click(btnCalculateTotals);
		xpath_GenericMethod_Click(btnSubmitClaims);
	}

	public String finaliseBalanceSheet() throws Exception {
		xpath_GenericMethod_Sendkeys(txtAreaAssessment, "Test Assessment");
		String approvedAmount = xpath_Genericmethod_getElementText(labelApprovedAmount);
		xpath_GenericMethod_Click(btnSubmitClaims);
		return approvedAmount;

	}

	public void approveClaim() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnApproveClaim);
		waitFor(1);
	}

	public static void setCalendarDateTime(String xpath, String givenDate) throws Exception {
		String date_dd_MM_yyyy[] = (givenDate.split(" ")[0]).split("/");
		System.out.println("whole date" + date_dd_MM_yyyy);

		xpath_GenericMethod_Click(xpath);
		// button to move next in month
		WebElement nextMonthLink = driver.findElement(By.xpath(calendarNextMonth));
		// button to move previous month in calendar
		WebElement previousMonthLink = driver.findElement(By.xpath(calendarPreviousMonth));

		// button to move next hour
		WebElement nextHourLink = driver.findElement(By.xpath(calendarNextHour));
		// button to move previous hour in calendar
		WebElement previousHourLink = driver.findElement(By.xpath(calendarPreviousHour));

		System.out.println("current month" + (Calendar.getInstance().get(Calendar.MONTH) + 1));
		int monthDiff = Integer.parseInt(date_dd_MM_yyyy[1]) - (Calendar.getInstance().get(Calendar.MONTH) + 1);
		System.out.println("month diff" + monthDiff);
		if (monthDiff != 0) {
			// if you have to move next year
			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					System.out.println("Month Diff->" + i);
					nextMonthLink.click();
				}
			} // if you have to move previous year
			else if (monthDiff < 0) {
				for (int i = 0; i < (monthDiff * (-1)); i++) {
					System.out.println("Month Diff->" + i);
					previousMonthLink.click();
				}
			}
		}
		String given_time_hh_mm[] = (givenDate.split(" ")[1]).split(":");
		System.out.println("returned time " + given_time_hh_mm[0] + " " + given_time_hh_mm[1]);
		String currentFullDate = DateFinder.getCurrentDateTimeInTimeZone();
		System.out.println("current full date " + currentFullDate);
		String current_time_hh_mm[] = (currentFullDate.split(" ")[1]).split(":");
		System.out.println("current time " + current_time_hh_mm[0] + " " + current_time_hh_mm[1]);
		int hourDiff = Integer.parseInt(given_time_hh_mm[0]) - Integer.parseInt(current_time_hh_mm[0]);
		System.out.println("Hour diff" + hourDiff);
		if (hourDiff != 0) {
			// if you have to move next year
			if (hourDiff > 0) {
				for (int i = 0; i < hourDiff; i++) {
					System.out.println("Hour Diff->" + i);
					nextHourLink.click();
				}
			} // if you have to move previous year
			else if (hourDiff < 0) {
				for (int i = 0; i < (hourDiff * (-1)); i++) {
					System.out.println("Hour Diff->" + i);
					previousHourLink.click();
				}
			}
		}

		String given_time_am_pm = givenDate.split(" ")[2];
		String fullAmPm = String.format(calendarAMPM, given_time_am_pm);
		// button for AM PM scroll
		WebElement amPmEle = driver.findElement(By.xpath(fullAmPm));
		amPmEle.click();

		waitFor(1);
		System.out.println("date" + date_dd_MM_yyyy[0]);
		String fullDatex = String.format(calendarDatePick, date_dd_MM_yyyy[0]);
		driver.findElement(By.xpath(fullDatex)).click();
	}

	public static void setCalendarDate(String xpath, String givenDate) throws Exception {
		String date_dd_MM_yyyy[] = (givenDate.split(" ")[0]).split("/");
		System.out.println("whole date" + date_dd_MM_yyyy);

		xpath_GenericMethod_Click(xpath);
		// button to move next in month
		WebElement nextMonthLink = driver.findElement(By.xpath(calendarNextMonth));
		// button to move previous month in calendar
		WebElement previousMonthLink = driver.findElement(By.xpath(calendarPreviousMonth));

		System.out.println("current month" + (Calendar.getInstance().get(Calendar.MONTH) + 1));
		int monthDiff = Integer.parseInt(date_dd_MM_yyyy[1]) - (Calendar.getInstance().get(Calendar.MONTH) + 1);
		System.out.println("month diff" + monthDiff);
		if (monthDiff != 0) {
			// if you have to move next year
			if (monthDiff > 0) {
				for (int i = 0; i < monthDiff; i++) {
					System.out.println("Month Diff->" + i);
					nextMonthLink.click();
				}
			} // if you have to move previous year
			else if (monthDiff < 0) {
				for (int i = 0; i < (monthDiff * (-1)); i++) {
					System.out.println("Month Diff->" + i);
					previousMonthLink.click();
				}
			}
		}

		waitFor(1);
		System.out.println("date" + date_dd_MM_yyyy[0]);
		String fullDatex = String.format(calendarDatePick, date_dd_MM_yyyy[0]);
		driver.findElement(By.xpath(fullDatex)).click();
	}

	public void setIncidentDate(String incidentDateVal) throws Exception {
		waitForElementXpath(inpIncidentDate, 10);
		System.out.println(incidentDateVal);
		setCalendarDateTime(calendarPicker, incidentDateVal);
	}

	public void setIncidentNumber(String incidentNumVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpIncidentRef, incidentNumVal);
		waitFor(1);
	}

	public void selectApproxDateCheckBox() throws Exception {
		xpath_GenericMethod_Click(chkBoxApproxDate);
		waitFor(1);
	}

	public void fillClaimDetails(String incidentDescVal, String claimDetailVal) throws Exception {
		xpath_GenericMethod_Sendkeys(txtAreaIncidentDesc, incidentDescVal);
		xpath_GenericMethod_Sendkeys(txtAreaClaimDetail, claimDetailVal);
		waitFor(1);
	}

	public void collectClaimDetailsTab(String particularsVal, String resultVal, String causeVal, String incDateVal,
			String incDesVal, String eventVal) throws Exception {
		waitFor(1);
		driver.switchTo().defaultContent();
		// waitForElementXpath(inpParticulars, 10);
		xpath_GenericMethod_Sendkeys(inpParticulars, particularsVal);
		waitFor(1);
		clickSuggestionGeneric(particularsVal);
		xpath_GenericMethod_Sendkeys(inpActualDate, incDateVal);
		xpath_GenericMethod_Sendkeys(inpResult, resultVal);
		waitFor(1);
		clickSuggestionGeneric(resultVal);
		xpath_GenericMethod_Sendkeys(inpCause, causeVal);
		waitFor(1);
		clickSuggestionGeneric(causeVal);
		xpath_GenericMethod_Sendkeys(txtAreaActualIncDesc, incDesVal);
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpEventTitle, eventVal);
		waitFor(1);
		clickSuggestionGeneric(eventVal);
		waitFor(1);
	}

	public void claimableCheckTab(String claimableVal, String claimableOptionVal, String sendFormToCustVal,
			String formTypeVal) throws Exception {
		xpath_GenericMethod_Click(tabClaimableCheck);
		waitFor(1);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnClaimable, claimableVal);
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpClaimableOption, claimableOptionVal);
		waitFor(1);
		clickSuggestionGeneric(claimableOptionVal);
		waitFor(1);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnSendForm, sendFormToCustVal);
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpClaimForm, formTypeVal);
		waitFor(1);
		clickSuggestionGeneric(formTypeVal);
	}

	public void internalEstimateTab(String claimAmountVal, String applianceoneVal, String appliancetwoVal,
			String appliancethreeVal, String applianceoneamountVal, String appliancetwoamountVal,
			String appliancethreeamountVal) throws Exception {
		xpath_GenericMethod_Click(tabinternalEstimate);
		waitFor(1);
		if (claimAmountVal.equalsIgnoreCase("less")) {

			for (int i = 1; i <= 2; i++) {
				xpath_GenericMethod_Click(linkAddItem);
				waitFor(1);
			}
			typeinClaimTableGeneric(inpApplianceGeneric, 1, applianceoneVal);
			clickSuggestionGeneric(applianceoneVal);
			typeinClaimTableGeneric(inpApplianceGeneric, 2, appliancetwoVal);
			clickSuggestionGeneric(appliancetwoVal);

			typeinClaimTableGeneric(inpAssessmentAmountGeneric, 1, applianceoneamountVal);
			typeinClaimTableGeneric(inpAssessmentAmountGeneric, 2, appliancetwoamountVal);
		} else if (claimAmountVal.equalsIgnoreCase("more")) {

			for (int i = 1; i <= 3; i++) {
				xpath_GenericMethod_Click(linkAddItem);
				waitFor(1);
			}
			typeinClaimTableGeneric(inpApplianceGeneric, 1, applianceoneVal);
			clickSuggestionGeneric(applianceoneVal);
			typeinClaimTableGeneric(inpApplianceGeneric, 2, appliancetwoVal);
			clickSuggestionGeneric(appliancetwoVal);
			typeinClaimTableGeneric(inpApplianceGeneric, 3, appliancethreeVal);
			clickSuggestionGeneric(appliancethreeVal);

			typeinClaimTableGeneric(inpAssessmentAmountGeneric, 1, applianceoneamountVal);
			typeinClaimTableGeneric(inpAssessmentAmountGeneric, 2, appliancetwoamountVal);
			typeinClaimTableGeneric(inpAssessmentAmountGeneric, 3, appliancethreeamountVal);
		}
		xpath_GenericMethod_Click(btnCalculateTotal);
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitClaims);
	}

	public void chooseCustomerResponse() throws Exception {
		waitFor(2);
		driver.findElement(By.xpath(radioProceed)).click();
		// driver.switchTo().defaultContent();
//		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
//		System.out.println(frames.size());
//		for (int i = 0; i < frames.size(); i++) {
//			System.out.println(frames.get(i).getAttribute("name"));
//			String frameNametwo = frames.get(i).getAttribute("name");
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame(frameNametwo);
//			try {
//				driver.findElement(By.xpath(radioProceed)).click();
//				System.out.println("Element " + radioProceed + " is present in the frame: " + frameNametwo);
//				break;
//			} catch (Exception e) {
//				System.out.println("Element is not present inside the frame: " + radioProceed);
//				driver.switchTo().defaultContent();
//			}
//		}
//		System.out.println("In GoToFrames Method End");
//		xpath_GenericMethod_Click(radioProceed);
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitClaims);
	}

	public void addAddress(String claimAddressVal) throws Exception {
		xpath_GenericMethod_Sendkeys(inpAddressClaim, claimAddressVal);
		clickSuggestionGeneric(claimAddressVal);
		waitFor(1);
	}

	public void fillOutageData() throws Exception {
		waitFor(1);
		int timeBack = 8;
		int dateBack = 20;
		for (int i = 1; i <= 3; i++) {
			xpath_GenericMethod_Click(linkAddOutage);
			waitFor(2);
			String dateSelection = DateFinder.getPastDate(-dateBack);
			String fullxpathdate = String.format(calendarOutageDateGeneric, i);
			setCalendarDate(fullxpathdate, dateSelection);
			String startDateTime = DateFinder.getPastDateTime(-dateBack, -timeBack);
			String endDateTime = DateFinder.getPastDateTime(-dateBack, -(timeBack - 1));
			String fullxpathstart = String.format(calendarOutageStartGeneric, i);
			setCalendarDateTime(fullxpathstart, startDateTime);
			String fullxpathend = String.format(calendarOutageEndGeneric, i);
			setCalendarDateTime(fullxpathend, endDateTime);
			dateBack = dateBack - 1;
			timeBack = timeBack - 1;
		}
		xpath_GenericMethod_Clear(inpEventTitle);
		waitFor(2);
	}

	public void completeComplaintFillup() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnComplaintNext);
	}

	public void reviewComplaintDetails(String catergoryVal, String subCategoryVal) throws Exception {
		if (verifyTextContains(labelCategory, catergoryVal)) {
			Assert.assertTrue(true, "Category value verified!");
		} else {
			Assert.assertTrue(false, "Category value not as expected!");
		}
		if (verifyTextContains(labelSubCategory, subCategoryVal)) {
			Assert.assertTrue(true, "Sub Category value verified!");
		} else {
			Assert.assertTrue(false, "Sub Category value not as expected!");
		}
		log.info("Complaint details Reviewed!");
		waitFor(1);
		//xpath_GenericMethod_scrollIntoView(btnFinishReview);
		xpath_GenericMethod_Click(btnFinishReview);
	}

	public void reviewHardshipDetails(String complaintTypeVal, String sourceVal, String faultVal, String categoryVal,
			String subCategoryVal) throws Exception {
		if (verifyTextContains(labelComplaintType, complaintTypeVal)) {
			Assert.assertTrue(true, "Complaint value verified!");
		} else {
			Assert.assertTrue(false, "Complaint value not as expected!");
		}
		if (verifyTextContains(labelSource, sourceVal)) {
			Assert.assertTrue(true, "Source value verified!");
		} else {
			Assert.assertTrue(false, "Source value not as expected!");
		}
		if (verifyTextContains(labelFault, faultVal)) {
			Assert.assertTrue(true, "Fault value verified!");
		} else {
			Assert.assertTrue(false, "Fault value not as expected!");
		}
		if (verifyTextContains(labelCategory, categoryVal)) {
			Assert.assertTrue(true, "Category value verified!");
		} else {
			Assert.assertTrue(false, "Category value not as expected!");
		}
		if (verifyTextContains(labelSubCategory, subCategoryVal)) {
			Assert.assertTrue(true, "Sub Category value verified!");
		} else {
			Assert.assertTrue(false, "Sub Category value not as expected!");
		}
		log.info("Complaint details Reviewed!");
		waitFor(1);
		//xpath_GenericMethod_scrollIntoView(btnFinishReview);
		xpath_GenericMethod_Click(btnFinishReview);
	}
	
	public void reviewClaimDetails(String incidentDateVal, String incidentRefVal, String claimDescVal,
			String claimDetailVal) throws Exception {
		String date = incidentDateVal.split(" ")[0];
		System.out.println(date);
		String year = date.substring(date.length() - 4, date.length());
		System.out.println(year);
		String yearend = date.substring(date.length() - 2, date.length());
		System.out.println(yearend);
		incidentDateVal = incidentDateVal.replace(year, yearend);
		System.out.println(incidentDateVal);
		if (verifyTextContains(labelIncidentDate, incidentDateVal)) {
			Assert.assertTrue(true, "Incident date value verified!");
		} else {
			Assert.assertTrue(false, "Incident date not as expected!");
		}
		if (verifyTextContains(labelIncidentRef, incidentRefVal)) {
			Assert.assertTrue(true, "Incident ref value verified!");
		} else {
			Assert.assertTrue(false, "Incident ref value not as expected!");
		}
		if (verifyTextContains(labelIncDesc, claimDescVal)) {
			Assert.assertTrue(true, "Incident decription value verified!");
		} else {
			Assert.assertTrue(false, "Incident decription value not as expected!");
		}
		if (verifyTextContains(labelClaimDetail, claimDetailVal)) {
			Assert.assertTrue(true, "Claim details value verified!");
		} else {
			Assert.assertTrue(false, "Claim details value not as expected!");
		}
		log.info("Claim details Reviewed!");
		waitFor(1);
		//xpath_GenericMethod_scrollIntoView(btnFinishReview);
		xpath_GenericMethod_Click(btnFinishReview);
	}

	public void categorizeCase(String invCategoryVal, String invSubCategoryVal) throws Exception {
		xpath_GenericMethod_scrollIntoView(linkCategorizeTask);
		xpath_GenericMethod_Click(linkCategorizeTask);
		waitFor(1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		xpath_GenericMethod_Sendkeys(inpInvestigationCat, invCategoryVal);
		waitFor(1);
		clickSuggestionGeneric(invCategoryVal);

		xpath_GenericMethod_Sendkeys(inpInvestigationSubCat, invSubCategoryVal);
		waitFor(1);
		clickSuggestionGeneric(invSubCategoryVal);
		xpath_GenericMethod_Click(btnSubmitCaseCategorize);
	}

	public void performQueryToSpecialist(String emailVal) throws Exception {
		// Fill Query form
		waitForElement(driver.findElement(By.xpath(inpToEmail)), 10);
		xpath_GenericMethod_Sendkeys(inpToEmail, emailVal);
		xpath_GenericMethod_Sendkeys(txtAreaEmail, "Testing");
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitQuery);

	}

	public void performManualCorrespondenceHardship(String emailVal, String templateVal) throws Exception {
		// Fill Query form
		waitForElement(driver.findElement(By.xpath(inpToEmailManualCorro)), 10);
		xpath_GenericMethod_Sendkeys(inpToEmailManualCorro, emailVal);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownTemplate, templateVal);
		waitFor(2);
		xpath_GenericMethod_Click(btnSubmitQuery);

	}

	public void performEditDetails(String eventVal) throws Exception {
		// Fill Edit details
		waitForElement(driver.findElement(By.xpath(inpEventTitle)), 10);
		xpath_GenericMethod_Sendkeys(inpEventTitle, eventVal);
		clickSuggestionGeneric(eventVal);
		xpath_GenericMethod_Click(btnSubmitEdit);

	}

	public void performTransferCase(String transferUserVal) throws Exception {
		// Fill Edit details
		waitForElement(driver.findElement(By.xpath(inpManagedByUser)), 10);
		xpath_GenericMethod_Sendkeys(inpManagedByUser, transferUserVal);
		waitFor(1);
		clickSuggestionGeneric(transferUserVal);
		xpath_GenericMethod_Click(btnSubmitTransfer);

	}

	public void performCancelCase(String cancelResolutionVal) throws Exception {
		// Choose cancel resolution
		waitForElement(driver.findElement(By.xpath(dropDownResolution)), 20);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownResolution,
				cancelResolutionVal);
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitCancelResolution);
	}

	public void performLocalAction(String localAction) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(threeDotActions);
		waitFor(1);
		String fullXpath = String.format(genericLocalActionsXpath, localAction);
		System.out.println(fullXpath);
		xpath_GenericMethod_Click(fullXpath);
		waitFor(1);
	}

	public void markAssessmentComplete() throws Exception {
		xpath_GenericMethod_Click(chkBoxAssessmentComplete);
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitProcessAction);
	}

	public void chooseSubmitProcessAction() throws Exception {
		waitFor(3);
		xpath_GenericMethod_Click(btnSubmitProcessAction);
	}

	public void openSubCaseForProcessActions() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_scrollIntoView(linkProcessActionAfterTransfer);
		xpath_GenericMethod_Click(linkProcessActionAfterTransfer);
	}

	public void openAssignmentForClaim(String taskValue) throws Exception {
		waitFor(1);
		String fullxpath = String.format(headerOpenAssignment, taskValue);
		xpath_GenericMethod_scrollIntoView(fullxpath);
		xpath_GenericMethod_Click(fullxpath);
	}

	public void openSubCase(String subcaseVal) throws Exception {
		waitFor(1);
		driver.switchTo().defaultContent();
		String fullxpath = String.format(linkGenericSubCase, subcaseVal);
		xpath_GenericMethod_scrollIntoView(fullxpath);
		xpath_GenericMethod_Click(fullxpath);
	}

	public void verifyClaimStatus(String caseStatusVal) throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		if (xpath_Genericmethod_VerifyTextEqualsIgnoreCase(headerClaimCaseStatus, caseStatusVal)) {
			Assert.assertTrue(true, "Claim Case Status verified!");
		} else {
			Assert.assertTrue(false, "Claim Case Status not as expected!");
		}
	}

	public void submitFormOfRelease(String sendFormVal, String formType) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(chkBoxApprovedByManager);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownSendForm, sendFormVal);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownFormOption, formType);

		WebElement ele = driver.findElement(By.xpath(radioWithAssessment));
		ele.click();
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitClaims);
	}

	public void updatePaymentDetails(String transactionDateVal, String paymentRef, String payeeVal, String amountVal,
			String descriptionVal) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(linkAddItem);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownPayment, "Payment");
		setCalendarDate(calendarTransactionDate, transactionDateVal);
		xpath_GenericMethod_Sendkeys(inpReference, paymentRef);
		xpath_GenericMethod_Sendkeys(inpPayee, payeeVal);
		xpath_GenericMethod_Sendkeys(inpTransactionAmount, amountVal);
		xpath_GenericMethod_Sendkeys(inpDescription, descriptionVal);
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitClaims);
	}

	public void addClosureReason(String closureReasonVal) throws Exception {
		waitFor(2);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownClaimClosure,
				closureReasonVal);
		xpath_GenericMethod_Click(btnSubmitClaims);
		waitFor(1);
	}

	public void approveRejectCSS(String decisionVal) throws Exception {
		xpath_GenericMethod_Sendkeys(textAreaApproval, decisionVal);
		String fullxpath = String.format(btnApproveReject, decisionVal);
		xpath_GenericMethod_Click(fullxpath);
	}

	public void selectResolution(String resolutionVal) throws Exception {
		waitFor(2);
//		driver.switchTo().defaultContent();
		//waitForElement(driver.findElement(By.xpath(dropDownResolution)), 20);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDownResolution, resolutionVal);
		waitFor(1);
		xpath_GenericMethod_Click(btnSubmitResolution);
	}

	public void confirmCaseClosure() throws Exception {
		waitForElement(driver.findElement(By.xpath(btnConfirmCase)), 20);
		xpath_GenericMethod_Click(btnConfirmCase);
	}

	public void performEditHardship(String eventVal) throws Exception {
		// Fill Edit details
		waitForElement(driver.findElement(By.xpath(inpEventTitle)), 10);
		xpath_GenericMethod_Sendkeys(inpEventTitle, eventVal);
		clickSuggestionGeneric(eventVal);
		driver.findElement(By.xpath(chkBoxAssessmentComplete));
		xpath_GenericMethod_Click(btnSubmitEdit);

	}

	public void verifyCaseStatus(String caseStatusVal) throws Exception {
		waitForElement(driver.findElement(By.xpath(labelStatusValue)), 20);
		if (verifyTextContains(labelStatusValue, caseStatusVal)) {
			Assert.assertTrue(true, "Status verified!");
		} else {
			Assert.assertTrue(false, "Status not as expected!");
		}
	}

	public String getCaseId() throws Exception {
		waitFor(1);
		String caseLabel = xpath_Genericmethod_getElementText(labelCaseID);
		String caseId = StringUtils.substringBetween(caseLabel, "(", ")");
		System.out.println(caseId);
		return caseId;

	}
}
