package PageModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConfirmationPage {
    @FindBy(xpath = "//input[@placeholder='Select Country']")
    public WebElement countryInput;
    @FindBy(xpath = "//div[@class='payment__shipping']//button[@type='button']")
    public WebElement countryDropdown;
    @FindBy(xpath = "//div[@class='actions']//a")
    public WebElement placeOrderButton;
    @FindBy(xpath = "//h1[@class='hero-primary']")
    public WebElement confirmationMessage;
}
