package PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.UtilComponents;

import java.util.List;

public class ProductsPage extends UtilComponents {

    LoginPage loginPage;
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // toast container element
    @FindBy(xpath = "//div[@id='toast-container']")
    public WebElement toastContainer;

    @FindBy(css = ".ng-animating")
    public WebElement loadingAnimation;

    // cart elements
    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    public WebElement cartButton;

    // product card elements
    @FindBy(xpath = "//div[@class='card-body']")
    public List<WebElement> productsCard;

    // checkout elements
    @FindBy(css = "div[class='cartSection']")
    public List<WebElement> productsSection;
    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    public WebElement checkoutButton;

    public WebElement waitForVisibilityOfElement(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        return webElement;
    }

}
