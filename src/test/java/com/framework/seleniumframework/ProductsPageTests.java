package com.framework.seleniumframework;

import PageModels.ConfirmationPage;
import PageModels.LoginPage;
import PageModels.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.UtilComponents;
import utils.BrowserHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ProductsPageTests {
    private final BrowserHelper browserHelper = new BrowserHelper();
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ConfirmationPage confirmationPage;
    private WebDriver driver;
    private UtilComponents utilComponents;

    @BeforeMethod
    void beforeMethod() {
        driver = browserHelper.getChromeDriver();

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        productsPage = PageFactory.initElements(driver, ProductsPage.class);
        confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
        utilComponents = new UtilComponents(driver);

        driver.get("https://rahulshettyacademy.com/client");

    }

    @AfterMethod
    void afterMethod() {
        driver.close();
    }

    @Test
    void shouldBeAbleToAddProductsIntoCart() {

        String productName = "IPHONE 13 PRO";

        loginPage.loginApplication("iunc@gmail.com", "123Test456!");

        utilComponents.addToCart(productsPage.productsCard, productName, By.cssSelector("b"), By.cssSelector("button:last-of-type"));

        utilComponents.waitForConfirmationLoadingToDisappear(productsPage.toastContainer, productsPage.loadingAnimation);

        utilComponents.addToCart(productsPage.productsCard, "ADIDAS ORIGINAL", By.cssSelector("b"), By.cssSelector("button:last-of-type"));

        utilComponents.waitForConfirmationLoadingToDisappear(productsPage.toastContainer, productsPage.loadingAnimation);

        assertThat(utilComponents.waitForElementToBeVisible(productsPage.toastContainer).getText(), equalTo("Product Added To Cart"));

        productsPage.cartButton.click();

//        for (WebElement checkoutProduct : utilComponents.waitForAllElementsToBeVisible(productsPage.productsSection)) {
//            assertThat(checkoutProduct.findElement(By.cssSelector("h3")).getText(), equalTo(productName));
//        }

        utilComponents.waitForElementToBeClickable(productsPage.checkoutButton);
        utilComponents.waitForElementToBeVisible(confirmationPage.countryInput).sendKeys("romania");
        utilComponents.waitForElementToBeClickable(confirmationPage.countryDropdown);
        confirmationPage.placeOrderButton.click();

        assertThat(utilComponents.waitForElementToBeVisible(confirmationPage.confirmationMessage).getText(), equalToIgnoringCase("THANKYOU FOR THE ORDER."));
    }
}
