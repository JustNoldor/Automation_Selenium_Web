Feature: Homework Feature

  Background:
    Given I'm on the homepage
    Given I accept cookies

  @Case1
  Scenario: Check coin detail page
    When I click navigate to Markets page
    When I select spot market section
    When I click coin
    Then I should verify coin detail page

  @Case2
  Scenario: Check fail login attempt
    When I click navigate to Spot submenu
    When I click login button
    When I login invalid credentials
    Then I should verify login error message

  @Case3
  Scenario: Check about us section
    When I click randomly footer links
    Then I should see they open properly