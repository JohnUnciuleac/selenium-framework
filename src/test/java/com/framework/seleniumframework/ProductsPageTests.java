package com.framework.seleniumframework;

import PageModels.LoginPage;
import PageModels.ProductsPage;
import io.qameta.allure.internal.shadowed.jackson.databind.node.BooleanNode;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserHelper;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductsPageTests {
    private final BrowserHelper browserHelper = new BrowserHelper();
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    void beforeMethod() {
        driver = browserHelper.getChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        productsPage = PageFactory.initElements(driver, ProductsPage.class);

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

        for (WebElement product : wait.until(ExpectedConditions.visibilityOfAllElements(productsPage.productsCard))) {
            if (product.findElement(By.cssSelector("b")).getText().equals(productName)) {
                wait.until(ExpectedConditions.elementToBeClickable(product.findElement(By.cssSelector("button:last-of-type")))).click();
            }
        }

        wait.until(ExpectedConditions.invisibilityOf(productsPage.toastContainer));
        wait.until(ExpectedConditions.invisibilityOf(productsPage.loadingAnimation));

        assertThat(wait.until(ExpectedConditions.visibilityOf(productsPage.toastContainer)).getText(), equalTo("Product Added To Cart"));

        productsPage.cartButton.click();

        for (WebElement checkoutProduct : wait.until(ExpectedConditions.visibilityOfAllElements(productsPage.productSection))) {
            assertThat(checkoutProduct.findElement(By.cssSelector("h3")).getText(), equalTo(productName));
        }
    }
}
