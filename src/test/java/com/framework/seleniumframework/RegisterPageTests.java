package com.framework.seleniumframework;

import PageModels.LoginPage;
import PageModels.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UtilComponents;
import utils.BrowserHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterPageTests {

    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private UtilComponents utilComponents;

    @BeforeMethod
    void beforeMethod() {
        driver = browserHelper.getChromeDriver();
        utilComponents = new UtilComponents(driver);

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);

        loginPage.goToLoginPage();
    }

    @AfterMethod
    void afterMethod() {
        driver.close();
    }

    @Test
    void createNewAccount() {
        utilComponents.waitForElementToBeClickable(loginPage.registerButton);
        utilComponents.waitForElementToBeVisible(registerPage.firstNameInput).sendKeys("First");
        utilComponents.waitForElementToBeVisible(registerPage.lastNameInput).sendKeys("Last");
        utilComponents.waitForElementToBeVisible(registerPage.userEmailInput).sendKeys("firstLast1@gmail.com");
        utilComponents.waitForElementToBeVisible(registerPage.userMobileInput).sendKeys("3726319301");
        utilComponents.selectOptionFromSelectElement(registerPage.occupationSelect, "Student");
        utilComponents.selectOptionFromRadioButton(registerPage.genderRadioButton, "Male");
        utilComponents.waitForElementToBeVisible(registerPage.registerPassword).sendKeys("Password123!");
        utilComponents.waitForElementToBeVisible(registerPage.registerConfirmPassword).sendKeys("Password123!");
        utilComponents.waitForElementToBeClickable(registerPage.ageCheckbox);
        utilComponents.waitForElementToBeClickable(registerPage.registerButton);

        assertThat(utilComponents.waitForElementToBeVisible(registerPage.registerToastContainer).getText(), equalTo("Registered Successfully"));
        assertThat(utilComponents.waitForElementToBeVisible(registerPage.successfulAccountCreation).getText(), equalTo("Account Created Successfully"));
    }

}
