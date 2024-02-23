package com.ABS.ataf.PegaApp.PageObjects;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.utility.ResourceHelper;

public class HomePage extends SeleniumFunc implements HomePageLoc {
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	HomePage homepage;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void sendHomeObject(HomePage homepage) {
		this.homepage = homepage;
		// System.out.println("In sendLoginObject method search page"+this.loginpage);
	}

	public void clickNewButton() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnNew);
	}

	public void startPhoneCall() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(phoneCall);
	}

	public void enterLastName(String value) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inplastNameCustomerSearch, value);
	}

	public void validateMessage(String expectedMessage) throws Exception {
		String actualMessage = xpath_Genericmethod_getElementText(labelMessage);
		if (actualMessage.contains(expectedMessage)) {
			Assert.assertTrue(true, "Message Verified");
			System.out.println("Message Verified!");
		} else {
			System.out.println("Message incorrect!");
			Assert.assertTrue(false, "Message not as expected!");
		}
	}

	public void verifyNMI(String expectedNmiVal) throws Exception {
		String actualNMI = xpath_Genericmethod_getElementText(rowNMIValue);
		if (actualNMI.equalsIgnoreCase(expectedNmiVal)) {
			Assert.assertTrue(true, "NMI Verified");
			System.out.println("NMI Verified!");
		} else {
			System.out.println("NMI incorrect!");
			Assert.assertTrue(false, "NMI not as expected!");
		}
	}

	public void clickSearchforCustomer() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnSearchCustomerSearch);
	}

	public void profileIcon() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		if (xpath_Genericmethod_verifyElementPresent(profile))
			xpath_GenericMethod_Click(profile);
		else
			managerProfile();
	}

	public void burgerIcon() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(menuBurger);
	}
	public void clickOnLogOutNonPega() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(linkLogout);
		waitForElementXpath(LoginPage.inpUser, 20);
	}

	public void managerProfile() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(managerProfileMenu);
	}

	public void clickOnLogOffink() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(logofflink);
		waitFor(1);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
		waitForElementXpath(LoginPage.inpUsername, 20);
	}

	public void managerProfileMenu() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(managerProfileMenu);

	}

	public void createPayment() throws Exception {
		waitFor(2);
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(btnNew);
		xpath_GenericMethod_Click(btnPaymentReq);

	}

	public void validateFields() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnContinue);
		String alertMessage = driver.switchTo().alert().getText();
		Assert.assertTrue(alertMessage.equalsIgnoreCase("Please correct flagged fields before submitting the form!"),
				"Alert not displayed");
		driver.switchTo().alert().accept();
		waitFor(2);
		List<WebElement> err = driver.findElements(By.xpath(msgErrorField));
		if (err.size() < 1) {
			Assert.assertFalse(true, "No error validation msg displayed");
		}
	}

	public void fillBasicInfo(String cluster, String country, String companycode, String requestType, String po,
			String invAvailable, String bankDocAttached, String lineManager, String reasonPayment) throws Exception {
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpCluster, cluster);
		xpath_GenericMethod_Click(rowSuggestion);
		xpath_GenericMethod_Sendkeys(inpCountry, country);
		xpath_GenericMethod_Click(rowSuggestion);
		xpath_GenericMethod_Sendkeys(inpCompany, companycode);
		xpath_GenericMethod_Click(rowSuggestion);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnReqType, requestType);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnPO, po);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnInvoice, invAvailable);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnBankDetail, bankDocAttached);
		xpath_GenericMethod_Sendkeys(inpLineManager, lineManager);
//		waitFor(1);
		xpath_GenericMethod_Click(rowSuggestion);
		xpath_GenericMethod_Sendkeys(textAreaReason, reasonPayment);
		xpath_GenericMethod_Click(btnContinue);
	}

	public void fillVendorInfo() throws Exception {
		waitFor(2);
		Random random = new Random();
		int x = random.nextInt(99999);
		String randomNum = Integer.toString(x);
		xpath_GenericMethod_Sendkeys(inpInvNumber, randomNum);
		xpath_GenericMethod_selectFromDropdownUsingVisibleTextbyclickingOnDropdown(dropDwnCurrency, "USD");
		xpath_GenericMethod_Sendkeys(inpAmount, "100");
		xpath_GenericMethod_Sendkeys(inpPONumber, "225813");
		xpath_GenericMethod_Sendkeys(inpToBePaidDate, "1/29/2024");
		xpath_GenericMethod_Sendkeys(inpVendorName, "TESTVendor");
		xpath_GenericMethod_Sendkeys(inpVendorNum, "56789");
		xpath_GenericMethod_Click(btnContinue);
	}

	public void fillPaymentInfo() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Sendkeys(inpBankName, "Standard Chartered");
		xpath_GenericMethod_Sendkeys(inpBankCode, "SC1001");
		xpath_GenericMethod_Sendkeys(inpAccNum, "4444444");
		xpath_GenericMethod_Sendkeys(inpSwiftCode, "767541");
		xpath_GenericMethod_Sendkeys(inpIBANCode, "645645");
		xpath_GenericMethod_Click(btnContinue);
	}

	public void attachDoc() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnAttachDoc);
		waitFor(1);
		WebElement br = driver.findElement(By.xpath(btnSelectFile));
		br.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\payloads\\sample_file.jpg");
		waitFor(1);
		xpath_GenericMethod_Click(btnAttach);
		xpath_GenericMethod_Click(btnFinish);
	}

	public void validateSuccess() throws Exception {
		waitFor(2);
		String message = xpath_Genericmethod_getElementText(submissionLabel);
		Assert.assertTrue(message.contains("Thank you for your input"),
				"Unsuccessful submission as msg is not expected");
	}

	public void switchToInteractionPortal() throws Exception {
		waitFor(1);
		xpath_GenericMethod_HoverOnDemoScreenPops(switchPortalOption);
		waitFor(1);
		xpath_GenericMethod_Click(optionInteractionPortal);
		waitFor(1);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

	public void closeCurrentTab() {
		try {
			waitFor(1);
			System.out.println("in close current tab");
			List<WebElement> closeTabs = xpath_GenericMethod_listElements(closeTabsButton);
			int size = closeTabs.size();
			System.out.println(size);
			if (closeTabs.size() > 0) {
				driver.findElement(By.xpath("(//span[@role='button' and @title='Close Tab'])[" + size + "]")).click();
				if (isAlertPresent()) {
					driver.switchTo().alert().accept();
				}
				log.info("Clicked CloseTab");
				System.out.println("Clicked CloseTab");
			}
			Assert.assertTrue(true, "Clicked CloseTab");
		} catch (Exception e) {
			log.error("Unable to CloseTab");
			System.out.println("Error: " + e.getMessage());
			Assert.assertTrue(false, "Unable to CloseTab");
		}
	}

	public void closeAllTabs() {
		try {
			waitFor(1);
			System.out.println("in close tab");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath(menuCloseAll)).click();
			driver.findElement(By.xpath(optionCloseAll)).click();
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
			Assert.assertTrue(true, "Clicked CloseTab");
//			List<WebElement> closeTabs = xpath_GenericMethod_listElements(closeTabsButton);
//			System.out.println(closeTabs.size());
//			if (closeTabs.size() > 0) {
//				for (int i = 0; i < closeTabs.size(); i++) {
//					closeTabs.get(i).click();
//					if (isAlertPresent()) {
//						driver.switchTo().alert().accept();
//					}
//					log.info("Clicked CloseTab");
//					System.out.println("Clicked CloseTab");
//				}
//				Assert.assertTrue(true, "Clicked CloseTab");
//			}
		} catch (Exception e) {
			log.error("Unable to CloseTab");
			System.out.println("Error: " + e.getMessage());
			Assert.assertTrue(false, "Unable to CloseTab");
		}
	}

	public void switchToBackOfficePortal() throws Exception {
		waitFor(1);
		xpath_GenericMethod_HoverOnDemoScreenPops(switchPortalOption);
		waitFor(1);
		xpath_GenericMethod_Click(optionBackOfficePortal);
		waitFor(1);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

	public void searchCase(String caseNumVal) throws Exception {
		xpath_GenericMethod_Clear(inpSearchBar);
		xpath_GenericMethod_Sendkeys(inpSearchBar, caseNumVal);
		xpath_GenericMethod_Click(searchIcon);
		String fullxpath = String.format(caseResultRowAction, caseNumVal);
		xpath_GenericMethod_Click(fullxpath);
		xpath_GenericMethod_Click(startResearchOption);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

}
