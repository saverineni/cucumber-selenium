Feature: Login
  Scenario: test 1 for login
    Given I am on stackoverflow website
    And I click on the login link
    And I enter username and password
    When I click login button
    Then I should be on the home page