package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class _01_LoginSteps {
    DialogContent dc = new DialogContent();


    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().get("https://demo.mersys.io/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password after click Login button")
    public void enterUsernameAndPasswordAfterClickLoginButton() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dc.userName));
        System.out.println("username login");
        GWD.Bekle(3);
        dc.userName.sendKeys("richfield.edu");
        GWD.Bekle(3);
        dc.passWord.sendKeys("Richfield2020!");
        GWD.Bekle(3);
        dc.loginButton.click();
        GWD.Bekle(3);



    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        System.out.println("login successfully");

    }
}
