package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/reports/cucumber-reports/cucumber.html"} )

@Test
public class TestRunner extends AbstractTestNGCucumberTests{
}
