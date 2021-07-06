#Author: deepayan.nandy@capgemini.com
Feature: Mobile Number download link

  Scenario Outline: Able to get the download link throw sms
    Given the user is on the home page of Asian Paints
    When user scroll down to the Design and color app section
    And user enter a valid mobile number as "<number>"
    And user click on the Get Link button
    Then user should get a message as "<status>"
    And user closes browser

    Examples: 
      | number     | status                             |
      | 1234567890 | Message has been successfully sent |
      |  738421362 | Phone number is invalid            |
