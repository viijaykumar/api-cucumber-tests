 Feature: Delete A blog.
 
 Scenario: Verify that the created POST is DELETED
    Given the api is up and running on "http://localhost:3000"
    When user performs DELETE request for a specific ID
      | 1008 |
    Then the user should receive status code for the /specific-request is 200
    And the user validates the blog in json response