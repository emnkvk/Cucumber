Feature:ApachePOI Citizen Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password after click Login button
    Then User should login successfully
    And Navigate to CitizenShip page

  Scenario: Create citizenship from Excel
    When User Create citizenship with ApachePOI

  Scenario: delete citizenship from Excel
    Then User Delete citizenship with ApachePOI