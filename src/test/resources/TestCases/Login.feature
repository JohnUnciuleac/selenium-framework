Feature: Login successfully into application

  Scenario: As a user of Practice Shop I want to be able to login
    Given I access "https://rahulshettyacademy.com/client" page
    When I login with valid username and password
    Then I can see the successful login text
