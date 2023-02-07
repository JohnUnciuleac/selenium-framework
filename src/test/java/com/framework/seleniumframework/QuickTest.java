package com.framework.seleniumframework;

import PageModels.LoginPage;
import PageModels.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserHelper;

import java.time.Duration;

public class QuickTest {

    private final BrowserHelper browserHelper = new BrowserHelper();
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeMethod
    void beforeMethod() {
        driver = browserHelper.getChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
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
    void shouldBeAbleToAddProductsIntoCart() throws InterruptedException {

        loginPage.loginApplication("iunc@gmail.com", "123Test456!");

        for (WebElement product : productsPage.productsCard) {
            if (product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")) {
                product.findElement(By.cssSelector("button:last-of-type")).click();
            }
        }

        Thread.sleep(5000);
    }

}
