Feature: Spartans API CRUD operations

  Scenario: Perform CRUD operations on Spartans API
    Given a new Spartan is created with name "John Smith", gender "Male", phone "1234567890" details
    Then the Spartan details should match the created details
    When I update the Spartan's name to "Jane Doe"
    Then the Spartan's details should be updated
    When I delete the Spartan
    Then the Spartan should no longer exist
