@tag
Feature: Error Validation

  @ErrorValidation
  Scenario: Negative test to validate login
   	Given I landed on Home Page
    When I Logged in with username <userName> and password <password>
    Then I validate the Error Message "Incorrect email or password."

    Examples: 
      | userName  										| password 			|
      | jitendrareddy05@gmail.com 		| Test@1213  		|