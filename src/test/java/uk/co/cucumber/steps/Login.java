package uk.co.cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver = null;

    @Before
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Given("^I am on stackoverflow website$")
    public void iAmOnWebsite() throws Throwable {
        driver.get("https://stackoverflow.com");
    }

    @And("^I click on the login link$")
    public void i_have_variable_a2() throws Throwable {
        driver.findElement(By.className("login-link")).click();
    }

    @And("^I enter username and password$")
    public void i_have_variable_a3() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("suresh.averineni@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Suresh123");
    }

    @When("^I click login button$")
    public void i_have_variable_a5() throws Throwable {
        driver.findElement(By.id("submit-button")).submit();
    }

    @Then("^I should be on the home page$")
    public void i_have_variable_a6() throws Throwable {
        WebElement webElement = driver.findElement(By.linkText("Ask Question"));
        Assert.assertTrue(webElement.isDisplayed());
    }
}
