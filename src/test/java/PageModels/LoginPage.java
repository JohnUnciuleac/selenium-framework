package PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // input elements
    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement userEmailInput;

    @FindBy(xpath = "//input[@id='userPassword']")
    public WebElement userPasswordInput;

    // button elements
    @FindBy(xpath = "//input[@id='login']")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@class='text-reset']")
    public WebElement registerButton;

    // validation message elements
    @FindBy(xpath = "//div[@class='form-group']//div[contains(text(),'Enter Valid Email')]")
    public WebElement invalidEmailText;
    @FindBy(xpath = "//div[@id='toast-container']")
    public WebElement toastContainer;

    // Login method
    public void loginApplication(String username, String password) {
        userEmailInput.sendKeys(username);
        userPasswordInput.sendKeys(password);
        loginButton.click();
    }

    // URL method
    public void goToLoginPage() {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
