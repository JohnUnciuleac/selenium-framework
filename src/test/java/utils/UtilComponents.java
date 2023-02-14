package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UtilComponents {
    public UtilComponents(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;
    public WebDriverWait wait;
    private final static long TIMEOUT = 5;

    public WebElement waitForElementToBeVisible(WebElement elementToBeVisible) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));
        return elementToBeVisible;
    }

    public WebElement waitForElementToBeInvisible(WebElement elementToBeInvisible) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.invisibilityOf(elementToBeInvisible));
        return elementToBeInvisible;
    }

    public void waitForConfirmationLoadingToDisappear(WebElement toastElement, WebElement loadingAnimation) {
        waitForElementToBeInvisible(toastElement);
        waitForElementToBeInvisible(loadingAnimation);
    }

    public List<WebElement> waitForAllElementsToBeVisible(List<WebElement> elementsToBeVisible) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsToBeVisible));
        return elementsToBeVisible;
    }

    public void waitForElementToBeClickable(WebElement elementToBeClickable) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
        elementToBeClickable.click();
    }

    public void selectOptionFromSelectElement(WebElement optionElement, String optionText) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(optionElement));
        Select dropdownOptions = new Select(optionElement);
        dropdownOptions.selectByVisibleText(optionText);
    }

    public WebElement findChild(WebElement parent, String cssSelector) {
        return parent.findElement(By.cssSelector(cssSelector));
    }

    public void addProductsToCart(List<WebElement> productsList, String productName, String quantity) {
        for (WebElement product : productsList) {
            if (product.findElement(By.cssSelector("h4")).getText().contains(productName)) {
                product.findElement(By.cssSelector("input[class='quantity']")).clear();
                product.findElement(By.cssSelector("input[class='quantity']")).sendKeys(quantity);
                product.findElement(By.cssSelector("button")).click();
            }
        }
    }

    public void addToCart(List<WebElement> productElement, String productName, By productText, By productButton) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElements(productElement));
        for (WebElement product : productElement) {
            if (product.findElement(productText).getText().equals(productName))
                wait.until(ExpectedConditions.elementToBeClickable(product.findElement(productButton))).click();
        }
    }

    public void selectOptionFromRadioButton(List<WebElement> optionElement, String gender) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElements(optionElement));
        for (WebElement option : optionElement) {
            if (option.getAttribute("value").equals(gender)) {
                option.click();
            }
        }
    }

}
