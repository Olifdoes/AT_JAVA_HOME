
Feature: Form Authentication

  Scenario: Successful login
    Given I open the login page
    Then I should see the login page title
    When I enter username "tomsmith" and password "SuperSecretPassword!"
    And I click the login button
    Then I should see a successful login message
    And I should see the logout button
    When I click the logout button
    Then I should see the login page title

  Scenario: Unsuccessful login
    Given I open the login page
    Then I should see the Elemental Selenium link
    When I enter username "admin" and password "1234"
    And I click the login button
    Then I should see an invalid username message
