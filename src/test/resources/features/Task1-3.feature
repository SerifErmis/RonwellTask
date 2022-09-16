@wip
Feature:US

  Background:
    Given user already main page

  Scenario: Verify all the specified fields are present on the registration page
    When user clicks user button for registration
    Then user should see all specified fields

  Scenario: Verify not filling the mandatory fields and clicking the submit button will lead to validation error
    When user clicks user button for registration
    And user clicks submit button without any input credentials
    Then user should see validation error message

  Scenario:Verify entering blank spaces on mandatory fields leads to validation error
    When user clicks user button for registration
    And user enters space character in mail field
    And user clicks submit button
    Then user should see invalid e-mail message

  Scenario: Verify that the user can logout successfully
    Given user already login
    When user clicks logout button
    Then user should see login button on user page









