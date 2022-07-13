

Feature: Chat page testing scenarios
   
  @test
  Scenario:1 User enters message in the chat box
    Given The user is on the dashboard screen
    When the user click "Apps" in the navigation menu
    And the user click "Chat" in the dropdown list
    When the chat page displays
    Then the user enters "OMG! My code works!"
    And the user clicks the send button
   
