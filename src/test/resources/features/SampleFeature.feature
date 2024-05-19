Feature: Login App

  @JamesRider
  Scenario Outline: Successful Login with OTP
    Given I launch the application
    When I complete the login process with "<country>", "<phone_number>" and "<OTP>"
    Then I should be on the Rides screen

    Examples:
      | country           | phone_number | OTP    |
      | Afghanistan (+93) | 701111112    | 123456 |