Feature: Edit user info

  @UserData
  Scenario: Change User name and picture
    Given I launch the application
    And I complete the login process with "Afghanistan (+93)", "701111112" and "123456"
    And I should be on the Rides screen
    When I click on the options button
    And I should be on the account page
    And I click on the profile name
    And the user edits their name and last name
    And the user changes their profile pic
    And the changes were saved
    And I click on the logout button
    And I should be on the login page after the logout