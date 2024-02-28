$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featurefilesNonPegaApp/DemoNonPega.feature");
formatter.feature({
  "name": "Login feature test",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "Test data file is set as \"NonPega_TestData.json\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginTest.test_data_file_is_set_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testnonpega1"
    },
    {
      "name": "@alltest"
    }
  ]
});
formatter.step({
  "name": "Open the browser and navigate to the \"NonPega\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginTest.open_the_browser_and_navigate_to_the_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I login to NonPegaApp with \"nonpegauser\" and \"nonpegapassword\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginTest.i_login_NonPega_with_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I search for \"productname\" in the product list page",
  "keyword": "And "
});
formatter.match({
  "location": "CDUHomePageStepdef.i_search_product_homepage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"productprice\" in the productpage",
  "keyword": "Then "
});
formatter.match({
  "location": "CDUHomePageStepdef.i_verify_price(String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I add the product to cart",
  "keyword": "When "
});
formatter.match({
  "location": "CDUHomePageStepdef.i_add_product_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I open the cart",
  "keyword": "And "
});
formatter.match({
  "location": "CDUHomePageStepdef.i_open_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I remove the product from cart",
  "keyword": "And "
});
formatter.match({
  "location": "CDUHomePageStepdef.i_remove_product_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I verify the cart is empty",
  "keyword": "Then "
});
formatter.match({
  "location": "CDUHomePageStepdef.i_verify_cart_is_empty()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I Logout from NonPegaApp",
  "keyword": "When "
});
formatter.match({
  "location": "LogoutTest.i_Logout_from_nonpega()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "Logout should be successful from NonPegaApp",
  "keyword": "Then "
});
formatter.match({
  "location": "LogoutTest.logout_should_be_successful_nonpega()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});