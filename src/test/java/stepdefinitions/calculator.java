package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverManager;
import utils.ResourceFileReader;


public class calculator{
    WebDriver webDriver;
    ResourceFileReader reader = ResourceFileReader.getInstance();
    String url;
    WebElement webElement;


    public calculator() {
        webDriver = DriverManager.getDriver();
        url  = reader.getProperty("calculatorURL");
        System.out.println(url);
    }

    @Given("Navigate to the calculator site")
    public void navigate_to_the_calculator_site() {
        webDriver.get(url);
    }

    @Then("Provide the values to calculate")
    public void provide_the_values_to_calculate() {
        webDriver.findElement(By.xpath("//*[@id='sciout']/tbody/tr[2]/td[2]/div/div[1]/span[1]")).click();
    }

    @Then("The calculator should provide the result")
    public void the_calculator_should_provide_the_result() {

    }

    @After("@calculate")
    private void AfterExecution(){
        DriverManager.quitDriver();
    }
}
