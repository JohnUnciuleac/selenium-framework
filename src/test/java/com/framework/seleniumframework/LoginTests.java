package com.framework.seleniumframework;

import PageModels.LoginPage;
import PageModels.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UtilComponents;
import utils.BrowserHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests {
    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private UtilComponents utilComponents;

    @BeforeMethod
    void beforeMethod() {

        driver = browserHelper.getChromeDriver();

        productsPage = PageFactory.initElements(driver, ProductsPage.class);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        utilComponents = new UtilComponents(driver);

        loginPage.goToLoginPage();
    }

    @AfterMethod
    void afterMethod() {
        driver.close();
    }

    @Test
    void shouldBeAbleToLogin() {
        loginPage.loginApplication("iunc@gmail.com", "123Test456!");
        assertThat(utilComponents.waitForElementToBeVisible(productsPage.toastContainer).getText(), equalTo("Login Successfully"));
    }

    @Test
    void shouldNotBeAbleToLoginUsingWrongEmail() {
        loginPage.loginApplication("unregistered", "123Test456!");
        assertThat(utilComponents.waitForElementToBeVisible(loginPage.invalidEmailText).getText(), equalTo("*Enter Valid Email"));
    }

    @Test
    void shouldNotBeAbleToLoginUsingWrongPassword() {
        loginPage.loginApplication("iunc@gmail.com", "wrong password");
        assertThat(utilComponents.waitForElementToBeVisible(productsPage.toastContainer).getText(), equalTo("Incorrect email or password."));
    }

}
