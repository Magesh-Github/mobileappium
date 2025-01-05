Feature: Sign Up screen funtionalites

  @Login
  Scenario: Verify and validate the sign up screen
    Given navigate to login screen
    #When verify the <staticUiText> in sign up screen
    When enter the vaild username and password
    And click the login button
    #Examples: 
      #| staticUiText |
      #| First Name   |
      #| Last Name    |
      #| Email        |
      #| Password     |
      #| Location     |
