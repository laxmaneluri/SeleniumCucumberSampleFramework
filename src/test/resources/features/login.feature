@ui-tests
@login
Feature: User should be able to login to application

  Scenario: user with a valid credentials should be able to login
    Given Application is launched
    When a user enters credentials "sampleuser@gmail.com" and "myPassword123#"
    Then user is logged in to application
    And user can see profile option