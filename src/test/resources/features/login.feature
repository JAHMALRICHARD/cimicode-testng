

Feature: Login Screen test scenarios
  

  @test
  Scenario:1 User enters bad credential on the login screen
    Given The user is on the login screen
    When the user enters "autoTester" in username field 
    And the user enters "pass" in the password field
    And the user clicks the Sign in button
    Then the system displays an error
    
  @test
  Scenario:2 User enters correct credential on the login screen
    Given The user is on the login screen
    When the user enters "auto-tester" in username field 
    And the user enters "changeme" in the password field
    And the user clicks the Sign in button
    Then the dashboard page is displayed 
   
