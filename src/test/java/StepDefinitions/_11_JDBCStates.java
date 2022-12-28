package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBCStates {
    @Then("Send the Query from database {string} and control match")
    public void sendTheQueryFromDatabaseAndControlMatch(String sorgu) {

        // DB den Listeyi aldım
        ArrayList<ArrayList<String>> dbStates = DBUtility.getListData(sorgu);
        System.out.println("dbStates = " + dbStates);

        //Web den listesiyi aldım
        DialogContent dc = new DialogContent();
        List<WebElement> uiList = dc.statesList;

        for (WebElement e:uiList)
            System.out.println("e.getText() = " + e.getText());

        // Db ve Webden aldığım listeleri karşılaştırdım
        for (int i=0;i<dbStates.size();i++)
            Assert.assertEquals(dbStates.get(i).get(1).trim(),uiList.get(i).getText().trim(),"Hatalı Durum");
    }
}
