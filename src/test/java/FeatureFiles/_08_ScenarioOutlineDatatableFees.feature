#Senaryo :
#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password after click Login button
    Then User should login successfully

  Scenario Outline: Create a fee, delete fee
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | feeSetup   |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in the Dialog
      | toogleBar |
      | toogleBar |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | <name> |
    Then Success message should be displayed
    Examples:
      | name  | code | intCode   | priority |
      | Emin1 | 0102214445   | paypal    | 1000000022        |
      | Emin2 | 0202214445   | applePay  | 2000000033        |
      | Emin3 | 0302214445| googlePay | 3000000044        |