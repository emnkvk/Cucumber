package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{
    public LeftNav() {PageFactory.initElements(GWD.getDriver(),this);}


    @FindBy(xpath="(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath="(//span[text()='Parameters'])")
    private WebElement parameters;

    @FindBy(xpath="(//span[text()='Countries'])[1]")
    private WebElement countries;

    @FindBy(xpath="(//span[text()='Citizenships'])[1]")
    private WebElement citizenShip;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;
    @FindBy(xpath = "//span[contains(text(),'States')]")
    private WebElement states;

    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement feeSetup;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamsOne;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setup;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsTwo;

     @FindBy(xpath = "(//span[text()='Education'])[1]")
    private WebElement educationSetup;

     @FindBy(xpath = "(//span[text()='Setup'])[5]")
    private WebElement setupThree;

    @FindBy(xpath = "(//span[text()='Subject Categories'])[1]")
    private WebElement subjectCategories;






    WebElement myElement;
    public void findAndClick(String strlement)
    {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement)
        {
            case "setupOne" : myElement=setupOne;break;
            case "parameters" : myElement=parameters;break;
            case "countries" : myElement=countries;break;
            case "citizenShip" : myElement=citizenShip;break;
            case "nationalities" : myElement=nationalities;break;
            case "states" : myElement=states;break;
            case "feeSetup" : myElement=feeSetup;break;
            case "entranceExamsOne" : myElement=entranceExamsOne;break;
            case "setup" : myElement=setup;break;
            case "entranceExamsTwo" : myElement=entranceExamsTwo;break;
            case "educationSetup" : myElement=educationSetup;break;
            case "subjectCategories" : myElement=subjectCategories;break;
            case "setupThree" : myElement=setupThree;break;

        }

        clickFunction(myElement);
        scrollToelement(myElement=entranceExamsOne);
    }


}
