package Runners;

import Utilities.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        // or olduğunda herhangi bir tanesi varsa çalıştırır
        // and olduğunda her ikisininde senaryoda tag olarak olan senaryoları çalıştırır.
        tags = "@Regression", // hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class _09_TestRunnerParallel extends AbstractTestNGCucumberTests {
    @BeforeClass (alwaysRun = true)
    @Parameters("browser")
    public void beforeClass(String browser){
        //browser türünü GWDye göndereceğiz
        GWD.threadBrowserName.set(browser);
    }
}
