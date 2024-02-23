Feature: Login Pega App feature test

  Background: 
    Given Test data file is set as "Pega_TestData.json"

  @pegaappdemo @alltest
  Scenario: Login with valid credentials
    Given Open the browser and navigate to the "Pega" url
    When I login with "username" and "password"
    Then Login should be successful
    When I create new payment request
    Then I validate error message on form fields
    When I collect basic information
    And I validate error message on form fields
    And I collect vendor and invoice details
    Then I validate error message on form fields
    And I collect payment details
    And I attach document
    Then I validate success message
    Then I Logout
    Then Logout should be successful
