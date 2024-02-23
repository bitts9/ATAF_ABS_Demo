package com.ABS.ataf.NonPegaApp.PageObjects;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.helper.Logger.LoggerHelper;

public class CDUHomePage extends SeleniumFunc implements CDUHomePageLoc {
	private final Logger log = LoggerHelper.getLogger(CDUHomePage.class);
	CDUHomePage cduhomepage;

	public CDUHomePage(WebDriver driver) {
		super(driver);
	}

	public void sendCDUHomeObject(CDUHomePage cduhomepage) {
		this.cduhomepage = cduhomepage;
		// System.out.println("In sendLoginObject method search page"+this.loginpage);
	}

	public void openPageFromHome(String link) throws Exception {
		waitFor(2);
		String fullxpath = String.format(linkGenericHomePage, link);
		xpath_GenericMethod_Click(fullxpath);
	}

	public void searchProduct(String productDesc) throws Exception {
		waitFor(2);
		String fullxpath = String.format(linkProductGeneric, productDesc);
		Assert.assertTrue(xpath_Genericmethod_verifyElementPresent(fullxpath), "Product not present");
		xpath_GenericMethod_Click(fullxpath);
	}

	public void verifyProductPrice(String productPrice) throws Exception {
		waitFor(2);
		String actualPrice = xpath_Genericmethod_getElementText(labelProductPrice);
		if (!actualPrice.equalsIgnoreCase(productPrice)) {
			Assert.assertTrue(false);
		}
	}

	public void addToCart() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnAddToCart);
	}
	
	public void openCart() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(linkCart);
	}
	
	public void proceedToCheckout() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnCheckout);
	}
	
	public void fillDeliveryDetails(String fname, String lname, String pcode) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Sendkeys(inpDeliveryFName, fname);
		xpath_GenericMethod_Sendkeys(inpDeliveryLName, lname);
		xpath_GenericMethod_Sendkeys(inpDeliveryPCode, pcode);
		xpath_GenericMethod_Click(btnContinue);
		
	}
	
	public void verifyProductBeforeOrder(String productName, String productPrice) throws Exception {
		waitFor(2);
		String fullxpath = String.format(linkProductGeneric, productName);
		Assert.assertTrue(xpath_Genericmethod_verifyElementPresent(fullxpath), "Product not present");
		String actualPrice = xpath_Genericmethod_getElementText(labelItemPriceCheckout);
		if (!actualPrice.equalsIgnoreCase(productPrice)) {
			Assert.assertTrue(false);
		}
	}
	
	public void placeOrder() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnFinishOrder);
	}
	
	public void verifyOrderSuccess() throws Exception {
		waitFor(2);
		String actualMessage = xpath_Genericmethod_getElementText(headerSuccessMessage);
		Assert.assertTrue(actualMessage.equalsIgnoreCase("Thank you for your order!"), "Message not correct");
	}
	
	public void removeItemFromCart() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(btnRemoveFromCart);
	}
	
	public void verifyEmptyCart() throws Exception {
		waitFor(1);
		Assert.assertFalse(xpath_Genericmethod_verifyElementPresent(btnRemoveFromCart),"Cart is not empty");
	}
	
	public void continueShopping() throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnContinueShopping);
	}

	public void openOptionFromHome(String dropLink) throws Exception {
		waitFor(1);
		String fullxpath = String.format(optionPaymentGeneric, dropLink);
		xpath_GenericMethod_Click(fullxpath);
	}

	public void clickHome() throws Exception {
		waitFor(2);
		xpath_GenericMethod_Click(linkHome);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}

	public void deleteApplication() throws Exception {
		waitFor(1);
		List<WebElement> eles = xpath_GenericMethod_listElements(rowSavedApplication);
		if (eles.size() > 0) {
			driver.findElement(By.xpath(linkDeleteRowApplication)).click();
			waitFor(1);
			driver.findElement(By.xpath(btnDeleteYes)).click();
		} else {
			Assert.assertTrue(false, "No rows for application");
		}
	}

	public void verifyMyProjectsNotBlank() throws Exception {
		waitFor(1);
		List<WebElement> eles = xpath_GenericMethod_listElements(rowMyProjectAll);
		if (eles.size() > 0) {
			Assert.assertTrue(true, "My Projects is not blank");
			waitFor(1);
		} else {
			Assert.assertTrue(false, "No rows for application");
		}
	}

	public void filterBySuburb() throws Exception {
		waitFor(1);
		Set<String> allSuburbs = new HashSet<>();
		List<WebElement> eles = xpath_GenericMethod_listElements(rowMyProjectAll);
		for (int i = 0; i < eles.size(); i++) {
			String fullxpath = String.format(columnMyProjectSuburbGeneric, (i + 1));
			String suburb = driver.findElement(By.xpath(fullxpath)).getText();
			allSuburbs.add(suburb);
		}
		Iterator<String> iterator = allSuburbs.iterator();
		while (iterator.hasNext()) {
			driver.findElement(By.xpath(inpSuburbMyProjects)).sendKeys(iterator.next());
			xpath_GenericMethod_Click(btnSearchMyProjects);
			waitFor(1);
			verifyMyProjectsNotBlank();
			xpath_GenericMethod_Clear(inpSuburbMyProjects);
			xpath_GenericMethod_Click(btnSearchMyProjects);
		}
	}

	public void filterByDate() throws Exception {
		waitFor(1);
		String fullxpath = String.format(columnMyProjectDateGeneric, (1));
		String date = driver.findElement(By.xpath(fullxpath)).getText();
		System.out.println(date);
		String day = date.split(" ")[0];
		System.out.println(day);
		String month = date.split(" ")[1].replace(",", "");
		System.out.println(month);

		driver.findElement(By.xpath("//img[@data-test-id='_startDate_DateRange']")).click();
//		String calMonth = driver.findElement(By.xpath("//div[@class='drp-calendar left']//th[@class='month']")).getText().split(" ")[0];
		if ((!driver.findElement(By.xpath("//div[@class='drp-calendar left']//th[@class='month']")).getText()
				.split(" ")[0].equalsIgnoreCase(month))
				&& (!driver.findElement(By.xpath("//div[@class='drp-calendar right']//th[@class='month']")).getText()
						.split(" ")[0].equalsIgnoreCase(month))) {
			System.out.println("1st if");
			while (!(driver.findElement(By.xpath("//div[@class='drp-calendar left']//th[@class='month']")).getText()
					.split(" ")[0].equalsIgnoreCase(month))) {
				driver.findElement(By.xpath("//div[@class='drp-calendar left']//th[@class='prev available']")).click();
			}
			driver.findElement(By.xpath("//div[@class='drp-calendar left']//tbody//td[text()='" + day + "']")).click();
			driver.findElement(By.xpath("//div[@class='drp-calendar left']//tbody//td[text()='" + day + "']")).click();
			driver.findElement(By.xpath("//button[@id='applyBtn']")).click();
			xpath_GenericMethod_Click(btnSearchMyProjects);
		} else if ((driver.findElement(By.xpath("//div[@class='drp-calendar left']//th[@class='month']")).getText()
				.split(" ")[0].equalsIgnoreCase(month))) {
			System.out.println("2nd if");
			driver.findElement(By.xpath("//div[@class='drp-calendar left']//tbody//td[text()='" + day + "']")).click();
			driver.findElement(By.xpath("//div[@class='drp-calendar left']//tbody//td[text()='" + day + "']")).click();
			driver.findElement(By.xpath("//button[@id='applyBtn']")).click();
			xpath_GenericMethod_Click(btnSearchMyProjects);
		} else if ((driver.findElement(By.xpath("//div[@class='drp-calendar right']//th[@class='month']")).getText()
				.split(" ")[0].equalsIgnoreCase(month))) {
			System.out.println("3rd if");
			driver.findElement(By.xpath("//div[@class='drp-calendar right']//tbody//td[text()='" + day + "']")).click();
			driver.findElement(By.xpath("//div[@class='drp-calendar right']//tbody//td[text()='" + day + "']")).click();
			driver.findElement(By.xpath("//button[@id='applyBtn']")).click();
			xpath_GenericMethod_Click(btnSearchMyProjects);
		}
	}

	public void filterByField(String columnName) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnFieldsFilter);
		String fullxpath = String.format(chkBoxFieldLabelGeneric, columnName);
		xpath_GenericMethod_Click(fullxpath);
	}

	public void verifyColumnNotPresent(String columnName) throws Exception {
		waitFor(1);
		xpath_GenericMethod_Click(btnFieldsFilter);
		String fullxpath = String.format(chkBoxFieldLabelGeneric, columnName);
		xpath_GenericMethod_Click(fullxpath);
	}

	public void verifyColumnHeaderIsPresent(String header) throws Exception {
		waitFor(1);
		String fullxpath = String.format(headerColumnMyProjects, header);
		if (verifyElementPresent(fullxpath)) {
//			executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(fullxpath)));
			System.out.println(header + " is Present");
			Assert.assertTrue(true, header + "header is present in My Projects table");
		} else {
			System.out.println(header + " is Not Present");
			Assert.assertTrue(false, header + "header is not present in My Projects table");
		}
	}

	public void verifyColumnHeaderIsNotPresent(String header) throws Exception {
		waitFor(1);
		String fullxpath = String.format(headerColumnMyProjects, header);
		if (verifyElementPresent(fullxpath)) {
			System.out.println(header + " is Present");
			Assert.assertTrue(false, header + "header is present in My Projects table");
		} else {
			System.out.println(header + " is Not Present");
			Assert.assertTrue(true, header + "header is not present in My Projects table");
		}
	}

}
