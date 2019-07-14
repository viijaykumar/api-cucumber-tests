Feature: Verify the book volumes and publisher names

  Scenario Outline: user retrieves the book-ID and publisherName in order to identify the Industry.
    Given the API is up and running for "https://www.googleapis.com"
    When user performs a GET request for below
      | items.id                                        | 8U2oAAAAQBAJ       |
      | items.etag                                      | C2eFA3O9VtE        |
      | items.volumeInfo.publisher                      | Simon and Schuster |
      | items.volumeInfo.publishedDate                  |               2011 |
      | items.volumeInfo.industryIdentifiers.identifier | <bookIdentifier>   |
    Then the user should receive status code of 200
    Then the user verifies book volumes on Endpoint for a given "<bookIdentifier>"

    Examples: 
      | bookIdentifier |
      |  9781451648546 |
