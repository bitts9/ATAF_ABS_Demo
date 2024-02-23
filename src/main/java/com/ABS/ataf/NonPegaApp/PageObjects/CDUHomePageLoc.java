package com.ABS.ataf.NonPegaApp.PageObjects;

public interface CDUHomePageLoc {
	
	String linkGenericHomePage = "//a[text()='%s']";
	String linkHome = "//a[text()='Home']";
	String rowSavedApplication = "//tr[@aria-rowindex='1']/following-sibling::tr[@data-row='true']";
	String linkDeleteRowApplication = "//tr[@aria-rowindex='2']/td[@aria-colindex='5']";
	String btnDeleteYes = "//button[text()='Yes' and starts-with(@name,'DeleteApplication')]";
	String optionPaymentGeneric = "//span[text()='%s']";
	String btnAddCartRow1 = "//tr[@pl_index='1']/td[@headers='a7']//button[contains(@name,'CartButton')]";
	//String btnCheckout = "//button[text()='Checkout']";
	
	String rowMyProjectAll = "//tbody/tr[@aria-rowindex='1']/following-sibling::tr[@data-row='true']";
	String rowMyProjectGeneric = "//tbody/tr[@aria-rowindex='1']/following-sibling::tr[@data-test-id='-R%d' and @data-row='true']";
	String columnMyProjectSuburbGeneric = "//tr[@aria-rowindex='1']/following-sibling::tr[@data-test-id='-R%d' and @data-row='true']/td[@data-attribute-name='Project Suburb']/span";
	String columnMyProjectDateGeneric = "//tr[@aria-rowindex='1']/following-sibling::tr[@data-test-id='-R%d' and @data-row='true']/td[@data-attribute-name='Last Status Date']/span";
	String inpSuburbMyProjects = "//label[text()='Suburb']/following-sibling::div//input";
	String btnSearchMyProjects = "//button[starts-with(@name,'MyProjectsHeader')]/i[@class='pi pi-search']";
	String headerColumnMyProjects = "//tbody/tr[@aria-rowindex='1']/th/div[@tabindex='-1' and contains(text(),'%s')]";
	String btnFieldsFilter = "//button[text()='Fields']";
	String chkBoxFieldLabelGeneric = "//label[text()='%s']/preceding-sibling::input[@type='checkbox']";
	
	String linkProductGeneric = "//a[contains(@id,'title_link')]/div[text()='%s']";
	String labelProductPrice = "//div[@class='inventory_details_price']";
	String btnAddToCart = "//button[text()='Add to cart']";
	String linkCart = "//a[@class='shopping_cart_link']";
	String btnRemoveFromCart = "//button[text()='Remove']";
	String btnContinueShopping = "//button[@name='continue-shopping']";
	String btnCheckout = "//button[@name='checkout']";
	String inpDeliveryFName = "//input[@name='firstName']";
	String inpDeliveryLName = "//input[@name='lastName']";
	String inpDeliveryPCode= "//input[@name='postalCode']";
	String btnContinue = "//input[@name='continue']";
	String labelItemPriceCheckout = "//div[@class='inventory_item_price']";
	String btnFinishOrder = "//button[text()='Finish']";
	String headerSuccessMessage = "//h2[@class='complete-header']";
	
	
}
