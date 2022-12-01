#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız
  Feature: Entrance Exam Functionality

    Background:
      Given Navigate to Campus
      When Enter username and password after click Login button
      Then User should login successfully

      Scenario: Create and Delete a Exam
        And Click on the element in left nav
          | entranceExamsOne |
          | setup |
          | entranceExamsTwo |

        And Click on the element in the Dialog
        | addButton |

        And User sending the keys in Dialog content
          | nameInput | emin1234 |


        And Click on the element in the Form Content
          | academicPeriod  |
          | academicPeriod1 |
          | gradeLevel      |
          | gradeLevel2     |

        And Click on the element in the Dialog
          | saveButton |
        Then Success message should be displayed

        And Click on the element in left nav
          | entranceExamsOne |
          | setup |
          | entranceExamsTwo |

        And User delete item from Dialog
          | emin1234 |
        Then Success message should be displayed


