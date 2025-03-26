package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.Log;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        Log.info("Starting Scenario: " + scenario.getName());
        driver = DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Log.error("Scenario FAILED: " + scenario.getName());
        } else {
            Log.info("Scenario PASSED: " + scenario.getName());
        }
        DriverManager.quitDriver();  // Close WebDriver after scenario
    }
}
