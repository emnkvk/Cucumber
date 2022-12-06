package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // or olduğunda herhangi bir tanesi varsa çalıştırır
        // and olduğunda her ikisininde senaryoda tag olarak olan senaryoları çalıştırır.
        tags = "@Regression", // hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class _07_TestRunnerExtentReport extends AbstractTestNGCucumberTests {
}
