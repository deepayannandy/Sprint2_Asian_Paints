#Author: deepayan.nandy@capgemini.com
Feature: Enquire feature

  Scenario Outline: Enquire with valid  details
    Given the user is on the home page of Asian Paints
    When user enter valid Name as "<name>"
    And user enter valid Email as "<email>"
    And user enter valid Mobile no. as "<mobileNo>"
    And user enter valid Pin as "<pin>"
    And user click on the Enqure NOW button
    Then user should able to see the Thank you message
    And user closes browser

    Examples: 
      | name              | email                 | mobileNo   | pin    |
      | Tester Selenium   | tester.6622@gmail.com | 6622662262 | 713403 |
      | Tester Automation | tester.622@gmail.com  | 1234567890 | 713212 |

  Scenario Outline: Enquire with invalid  details
    Given the user is on the home page of Asian Paints
    When user enter invalid Name as "<name>"
    And user enter invalid Email as "<email>"
    And user enter invalid Mobile no. as "<mobileNo>"
    And user enter invalid Pin as "<pin>"
    And user click on the Enqure NOW button
    Then user should able to see the Error you message
    And user closes browser

    Examples: 
      | name           | email                  | mobileNo   | pin    |
      | De@            | deepayan.622@gmail.com | 7384213622 | 713403 |
      | Deepayan Nandy | deepayan.622gmail.com  | 7384213622 | 713403 |
      | Deepayan Nandy | deepayan.622@gmail.com |  738421362 | 713403 |
      | Deepayan Nandy | deepayan.622@gmail.com | 7384213622 |   7134 |
