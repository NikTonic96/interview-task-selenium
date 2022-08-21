@UIE2E
Feature: Calculate your holiday entitlement

  As a User
  I want to be able to calculate my holiday entitlement

  Background: User is on the Calculate your holiday entitlement page
    Given User is on the Calculate your holiday entitlement page


  @positive #Positive scenario (BVA)
  Scenario Outline: First option holiday calculation
    When User clicks the start button
    And User is on the next page
    And User selects first option
    And User clicks continue button
    And User selects first option
    And User clicks continue button
    And User clicks on input box
    And User inputs the "<option>" of days worked
    Then User then sees information page

    Examples:
      | option |
      | 1      |
      | 7      |


  @negative #Negative scenario testing out of boundaries (BVA)
  Scenario Outline: First option holiday calculation
    When User clicks the start button
    And User is on the next page
    And User selects first option
    And User clicks continue button
    And User selects first option
    And User clicks continue button
    And User clicks on input box
    And User inputs the "<option>" of days worked
    Then User gets the error message

    Examples:
      | option |
      | 0      |
      | 8      |


