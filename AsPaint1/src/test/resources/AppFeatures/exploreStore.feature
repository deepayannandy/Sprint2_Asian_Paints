#Author: deepayan.nandy@capgemini.com
Feature: Explore store

  Scenario Outline: Able to get near by store details
    Given the user is on the home page of Asian Paints
    When user scroll down to the Explore Store section
    And user enter a valid pin code as "<pin>"
    And user click on the Go button
    Then user should redirected to Store Locator page
    And user closes browser

    Examples: 
      | pin    |
      | 713403 |
      | 713212 |
