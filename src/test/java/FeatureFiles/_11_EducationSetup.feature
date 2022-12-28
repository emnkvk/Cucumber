Feature: Entrance Exam Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password after click Login button
    Then User should login successfully

  Scenario: Add,Edit,Delete a SchoolSubject Categories
    And Click on the element in left nav
      | educationSetup |
      | setupThree |
      | subjectCategories |
    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | emin123 |
      | codeInput | i43434  |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed
    And Click on the element in the Dialog
      | editButton |

    And User sending the keys in Dialog content
      | nameInput | emin12345 |
      | codeInput | i43434er  |

    And Click on the element in the Dialog
      | editSaveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | emin12345 |

    Then Success message should be displayed
