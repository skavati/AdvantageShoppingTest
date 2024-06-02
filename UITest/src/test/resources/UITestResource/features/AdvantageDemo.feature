@advantageDemo @uitest @tearDown
Feature: Advantage Online Shopping
   

 @log001
  Scenario: LOG001 - Mandatory field error messages display & clear   
    Given scenario starts "advantageDemo" "Advantage Online Shopping" "Mandatory field error messages display & clear" uitest
    Given I launch advantage online shopping website
    And I navigate to User
    And I click on CREATE NEW ACCOUNT
    When I click into and out of the Username, Email, Password and Confirm Password fields
    Then I should verify that errors display and contain the correct content 
    When I enter valid data for Username, Email, Password and Confirm Password field
    Then I should verify all errors are cleared
    