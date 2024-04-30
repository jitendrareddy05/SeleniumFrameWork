@tag
Feature: Purchase an order from ecommerce website

Background:
Given I landed on Home Page
  @Regression
  Scenario Outline: Postive test of submitting the order
    Given I Logged in with username <userName> and password <password>
    When I add the product <productName> to cart
    And Chekcout product <productName> and submit the order
    Then "Thankyou for the order." message is displayed on Confirmation Page

    Examples: 
      | userName  										| password 			| productName |
      | jitendrareddy05@gmail.com 		| Test@123  | zara coat 3 |
