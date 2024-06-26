@FirstTest
Feature: Basic Syntax

@Scenario1
  Scenario: Open the TS homepage
    Given the user is on the TS homepage
    When they click on the About Us link
    Then the user is redirected to the About page
    Then close the browser

