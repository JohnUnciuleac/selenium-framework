package StepDefinition;

import PageModels.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.UtilComponents;

public class StepDefinition {
    public LoginPage loginPage;
    private UtilComponents utilComponents;
    private WebDriver driver;

    @Before()
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        utilComponents = new UtilComponents(driver);
    }

    @After
    public void after() {
        driver.close();
    }

    @Given("^I access \"([^\"]*)\" page$")
    public void i_access_something_page(String strArg1) throws Throwable {
        loginPage.goToLoginPage();
    }

    @When("^I login with valid username and password$")
    public void i_login_with_valid_username_and_password() throws Throwable {
        loginPage.loginApplication("iunc@gmail.com", "123Test456!");
    }

    @Then("^I can see the successful login text$")
    public void i_can_see_the_successful_login_text() throws Throwable {
        Assert.assertTrue(utilComponents.waitForElementToBeVisible(loginPage.toastContainer).getText().contains("Login Successfully"));
    }
}
