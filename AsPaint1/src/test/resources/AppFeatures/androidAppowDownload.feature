#Author: deepayan.nandy@capgemini.com
Feature: Download android mobile app

  Scenario: Able to download the android mobile app
    Given the user is on the home page of Asian Paints
    When user scroll down to the Design and color app section
    And user click on the Get it on Google Play button
    Then user should be redirected to Color with Asian paint-Wall paint app- Apps on Google Playstore page
    And user closes browser
