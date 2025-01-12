Feature: Login screen funtionalites

  @Login
  Scenario Outline: Verify and validate the Login screen
    Given navigate to login screen
    #When verify the <staticUiText> in sign up screen
    When enter the vaild <email> and <password>
    And click the login button
    And verify the dashboard screen
    Then verify the log out

    #Examples:
    #| staticUiText |
    #| First Name   |
    #| Last Name    |
    #| Email        |
    #| Password     |
    #| Location     |
    Examples: 
      | email                   | password |
      | automation@testing5.com | 12345678 |

  @signup
  Scenario: Verify and validate the sign up screen
    Given navigate to signup screen
    When verify the terms&condition popup should be visible when click terms&condition
    And verify the terms&condition popup should be close when click the close button
