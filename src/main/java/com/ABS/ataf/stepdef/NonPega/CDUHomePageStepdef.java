package com.ABS.ataf.stepdef.NonPega;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import com.ABS.ataf.GeneralHelperSel.SeleniumFunc;
import com.ABS.ataf.NonPegaApp.PageObjects.CDUHomePage;
import com.ABS.ataf.TestBase.TestBase;
import com.ABS.ataf.configreader.ObjectRepo;
import com.ABS.ataf.helper.Logger.LoggerHelper;
import com.ABS.ataf.stepdef.common.LoginTest;
import com.ABS.ataf.utility.DateFinder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CDUHomePageStepdef {
	private final Logger log = LoggerHelper.getLogger(CDUHomePageStepdef.class);
	CDUHomePage cduhomepage = new CDUHomePage(TestBase.getDriver());

	@When("I open {string} in homepage")
	public void i_open_in_homepage(String string) throws Exception {
		cduhomepage.sendCDUHomeObject(cduhomepage);
		cduhomepage.openPageFromHome(string);
		System.out.println("Opened " + string + " page from home");
	}

	@When("I search for {string} in the product list page")
	public void i_search_product_homepage(String key) throws Exception {
		cduhomepage.sendCDUHomeObject(cduhomepage);
		String productDesc = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, key);
		cduhomepage.searchProduct(productDesc);
		System.out.println("Searched " + productDesc + " product from home");
	}

	@Then("I verify {string} in the productpage")
	public void i_verify_price(String key) throws Exception {
		String productPrice = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, key);
		cduhomepage.verifyProductPrice(productPrice);
		System.out.println("Verified " + productPrice + " product page");
	}

	@When("I add the product to cart")
	public void i_add_product_cart() throws Exception {
		cduhomepage.addToCart();
		System.out.println("Added to cart");
	}

	@When("I open the cart")
	public void i_open_cart() throws Exception {
		cduhomepage.openCart();
		System.out.println("Opened the cart");
	}

	@When("I proceed to checkout")
	public void i_proceed_checkout() throws Exception {
		cduhomepage.proceedToCheckout();
		System.out.println("Proceed to checkout");
	}
	
	@When("I place order")
	public void i_place_order() throws Exception {
		cduhomepage.placeOrder();
		System.out.println("Order placed");
	}
	
	@When("I verify order success")
	public void i_verify_order_success() throws Exception {
		cduhomepage.verifyOrderSuccess();
		System.out.println("Order placed");
	}
	
	@When("I fill delivery details")
	public void i_fill_delivery_info() throws Exception {
		String fname = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "firstname");
		String lname = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "lastname");
		String pcode = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, "postcode");
		cduhomepage.fillDeliveryDetails(fname, lname, pcode);
		System.out.println("Proceed to checkout");
	}
	
	@Then("I verify {string} and {string} before order")
	public void i_verify_before_checkout(String productName, String productPrice) throws Exception {
		String productname = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, productName);
		String productprice = SeleniumFunc.getValueFromJSON(LoginTest.testDataFile, productPrice);
		cduhomepage.verifyProductBeforeOrder(productname, productprice);
		System.out.println("Proceed to checkout");
	}

	@When("I remove the product from cart")
	public void i_remove_product_cart() throws Exception {
		cduhomepage.removeItemFromCart();
		cduhomepage.continueShopping();
		System.out.println("Removed product from the cart");
	}
	
	@Then("I verify the cart is empty")
	public void i_verify_cart_is_empty() throws Exception {
		cduhomepage.verifyEmptyCart();
		System.out.println("Verified that the cart is empty");
	}

	@And("I choose {string} option")
	public void i_choose_option(String string) throws Exception {
		cduhomepage.openOptionFromHome(string);
	}

	@And("I delete inprogress application")
	public void i_delete_inprogress_application() throws Exception {
		cduhomepage.deleteApplication();
		System.out.println("Deleted Application!");
	}

	@And("I verify MyProjects table is not blank")
	public void verify_MyProjects_table_is_not_blank() throws Exception {
		cduhomepage.verifyMyProjectsNotBlank();
		System.out.println("Verified if empty!");
	}

	@And("I verify suburb filter on MyProjects table")
	public void verify_filters_on_MyProjects_table() throws Exception {
		cduhomepage.filterBySuburb();
		System.out.println("filter by suburb verified!");
	}

	@And("I verify date filter in MyProjects table")
	public void verify_date_filter_in_MyProjects_table() throws Exception {
		cduhomepage.filterByDate();
		cduhomepage.verifyMyProjectsNotBlank();
		System.out.println("filter by date verified!");
	}

	@And("I verify fields filter working for {string} column on MyProjects table")
	public void verify_filters_on_MyProjects_table(String string) throws Exception {
		cduhomepage.filterByField(string);
		cduhomepage.verifyColumnHeaderIsNotPresent(string);
		cduhomepage.filterByField(string);
		System.out.println("filter by field verified!");
	}

	@Then("verify {string} , {string} , {string} , {string} , {string} , {string} headers should be present")
	public void verify_headers_should_be_present(String projectID, String projectStreet, String projectSuburb,
			String projectStatus, String lastStatusDate, String eeContact) throws Exception {
		cduhomepage.clickHome();
		cduhomepage.verifyColumnHeaderIsPresent(projectID);
		cduhomepage.verifyColumnHeaderIsPresent(projectStreet);
		cduhomepage.verifyColumnHeaderIsPresent(projectSuburb);
		cduhomepage.verifyColumnHeaderIsPresent(projectStatus);
		cduhomepage.verifyColumnHeaderIsPresent(lastStatusDate);
		cduhomepage.verifyColumnHeaderIsPresent(eeContact);
		System.out.println("Verified Headers!");
	}

}
