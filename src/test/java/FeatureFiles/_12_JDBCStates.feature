Feature: Testing JDBC States
  Background:
    Given Navigate to Campus
    When Enter username and password after click Login button
    Then User should login successfully
  Scenario: States Testing JDBC
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | states  |

    Then Send the Query from database "select * from states" and control match

