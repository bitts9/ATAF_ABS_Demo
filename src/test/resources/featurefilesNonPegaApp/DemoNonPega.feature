Feature: Login feature test

  Background: 
    Given Test data file is set as "NonPega_TestData.json"

  @testnonpega1 @alltest
  Scenario: Login with valid credentials
    Given Open the browser and navigate to the "NonPega" url
    When I login to NonPegaApp with "nonpegauser" and "nonpegapassword"
    And I search for "productname" in the product list page
    Then I verify "productprice" in the productpage
    When I add the product to cart
    And I open the cart
    And I remove the product from cart
    Then I verify the cart is empty
    When I Logout from NonPegaApp
    Then Logout should be successful from NonPegaApp

  @testnonpega2 @alltest
  Scenario: Login with valid credentials
    Given Open the browser and navigate to the "NonPega" url
    When I login to NonPegaApp with "nonpegauser" and "nonpegapassword"
    And I search for "productname" in the product list page
    Then I verify "productprice" in the productpage
    When I add the product to cart
    And I open the cart
    And I proceed to checkout
    And I fill delivery details
    Then I verify "productname" and "productprice" before order
    And I place order
    Then I verify order success
    When I Logout from NonPegaApp
    Then Logout should be successful from NonPegaApp
