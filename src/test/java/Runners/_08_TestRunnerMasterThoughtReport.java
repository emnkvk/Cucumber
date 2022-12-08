package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Parameters;

@CucumberOptions(
        // or olduğunda herhangi bir tanesi varsa çalıştırır
        // and olduğunda her ikisininde senaryoda tag olarak olan senaryoları çalıştırır.
        tags = "@Regression", // hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty.html","json:target/cucumber/cucumber.json"}
)


public class _08_TestRunnerMasterThoughtReport extends AbstractTestNGCucumberTests {

}
