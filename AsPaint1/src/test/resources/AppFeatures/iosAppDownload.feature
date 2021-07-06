#Author: deepayan.nandy@capgemini.com
Feature: Download ios mobile app

  Scenario: Able to download the ios mobile app
    Given the user is on the home page of Asian Paints
    When user scroll down to the Design and color app section
    And user click on the Download on the App Store button
    Then user should be redirected to Color with Asian paint on the App Store page
    And user closes browser
