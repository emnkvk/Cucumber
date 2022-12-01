#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel1  |
#| IT exam is1     | academicPeriod1              | gradeLevel2  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel3  |
#| Math exam  is1  | academicPeriod1              | gradeLevel4  |

Feature: Entrance Exam Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password after click Login button
    Then User should login successfully

  Scenario Outline: Create and Delete a Exam
    And Click on the element in left nav
      | entranceExamsOne |
      | setup |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName>|


    And Click on the element in the Form Content
      | academicPeriod  |
      | <AcademicPeriodOption> |
      | gradeLevel      |
      | <GradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |
    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExamsOne |
      | setup |
      | entranceExamsTwo |

    And User delete item from Dialog
      | <ExamName> |
    Then Success message should be displayed
    Examples:
      |ExamName|| AcademicPeriodOption || GradeLevelOption |
      |  Math exam i1142 || academicPeriod1 || gradeLevel2|
      |  IT exam i1142 || academicPeriod1 || gradeLevel3|
      |  Oracle exam i1142 || academicPeriod1 || gradeLevel4|
      |  Math exam is1142 || academicPeriod1 || gradeLevel5|
