package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent {


    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(css="input[formcontrolname='username']")
    public WebElement userName;

    @FindBy(css="input[formcontrolname='password']")
    public WebElement passWord;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

}
