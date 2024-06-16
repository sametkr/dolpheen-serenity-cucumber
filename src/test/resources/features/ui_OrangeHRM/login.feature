Feature: OrangeHRM app login feature

  User Story: As a user, I should be able to log in

  Acceptance Criteria:

  1- User can log in with valid credentials
  2- User can not log in with invalid credentials

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the home page

  Scenario: User logs in to his OrangeHRM account
    When user enters email "Admin"
    And user enters password "admin123"
    And user clicks Log in button
    Then user should see "Dashboard" on the homepage

  Scenario Outline: "Invalid credentials" should be displayed for when user enters Invalid credentials
    When user enters email "<username>"
    And user enters password "<password>"
    And user clicks Log in button
    Then user should see "Invalid credentials" message
    Examples:
      | username | password  |
      | JohnWho  | john1who  |
      | JohnWDoe | john1.who |
