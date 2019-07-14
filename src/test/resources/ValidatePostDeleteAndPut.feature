#Author: your.email@your.domain.com
Feature: Create/Post a blog

  Scenario Outline: Verify and validate my blog POST request
    Given the api is up and running on "http://localhost:3000"
    When user performs POST request for /posts
      | id        | <id>                    |
      | title     | my blog post 1035       |
      | author    | vijay 1035              |
      | region    | UK - POST  request      |
      | weather   | sunny   - POST request  |
      | location  | east M25 - POST request |
      | longitude |                   30.73 |
    Then the user should receive status code for the /specific-request is 201
    And the user validates the blog in json response with parameter "<id>"

    Examples: 
      | id   |
      | 1035 |

  Scenario Outline: Verify and validate my blog PUT request
    Given the api is up and running on "http://localhost:3000"
    When user performs PUT request for /posts/id "<id>"
      | id        | <id>                    |
      | title     | my blog post 1035       |
      | author    | vijay 1035              |
      | region    | UK - PUT  request       |
      | weather   | sunny  - PUT  request   |
      | location  | east M25 - PUT  request |
      | longitude |                   30.73 |
    Then the user should receive status code for the /specific-request is 200
    And the user validates the blog in json response with parameter "<id>"

    Examples: 
      | id   |
      | 1035 |
