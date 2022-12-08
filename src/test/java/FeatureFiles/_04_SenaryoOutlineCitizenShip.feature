Feature: Citizenship with scenario Outline

  Background:
    Given Navigate to Campus
    When Enter username and password after click Login button
    Then User should login successfully
    And Navigate to CitizenShip page

  @Regression
  Scenario Outline: CitizenShip Create
    When User a CitizenShip name as "<Name>" short name as "<ShortName>"
    Then Success message should be displayed

    When User a CitizenShip name as "<Name>" short name as "<ShortName>"
    Then Already exist message should be displayed

    When User delete the "<Name>"
    Then Success message should be displayed

    Examples:
      | Name    | ShortName |
      | vatIs1341 | isVat11234   |
      | vatIs25231 | isVat122341   |
      | vatIs31124525 | isVat13235532   |
      | vatIs41532532 | isVat14523532   |