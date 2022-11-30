Feature: Datatable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password after click Login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | emin123 |
      | codeInput | i43434      |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | emin123 |


  Scenario: Create a Nationality
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | nationalities  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | emin123 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | emin123 |

    Scenario: Create a Fee, delete Fee
      And Click on the element in left nav
        | setupOne   |
        | parameters |
        | feeSetup  |

      And Click on the element in the Dialog
        | addButton |

      And User sending the keys in Dialog content
        | nameInput | emin123 |
        | codeInput | i43434      |
        | integrationCode | 1233      |
        | priorityCode    | 422       |

      And Click on the element in the Dialog
        | toogleBar |
        | saveButton |
      Then Success message should be displayed