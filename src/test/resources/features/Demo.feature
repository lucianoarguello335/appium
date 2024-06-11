Feature: Latch Appium Interview

  @UserData
  Scenario: Login
    Given I launch the application
    And I complete the login process with "Afghanistan (+93)", "701111112" and "123456"
    And I should be on the Rides screen
    When I click on the options button
    And I should be on the account page

  @UserData
  Scenario: Change User name and picture
    Given I launch the application
    And I should be on the account page
    And I click on the profile name
    And I edit the name and last name
    And I change the profile pic
    And the changes were saved
    And I click on the done button

  @UserData
  Scenario: Logout
    Given I launch the application
    And I should be on the Rides screen
    When I click on the options button
    And I should be on the account page
    And I click on the logout button