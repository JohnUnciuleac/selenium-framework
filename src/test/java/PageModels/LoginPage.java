package PageModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    // Login page elements
    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement userEmailInput;
    @FindBy(xpath = "//input[@id='userPassword']")
    public WebElement userPasswordInput;
    @FindBy(xpath = "//input[@id='login']")
    public WebElement loginButton;

    // Login method
    public void loginApplication(String username, String password) {
        userEmailInput.sendKeys(username);
        userPasswordInput.sendKeys(password);
        loginButton.click();
    }
}
