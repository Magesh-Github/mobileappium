Feature: feature to test scroll funtionalites

@Login
  Scenario: Check User shouled be scroll down the screen
    Given user is on login page
    When user enter username and password
    And click the login button
    Then user is navigate to the home page
