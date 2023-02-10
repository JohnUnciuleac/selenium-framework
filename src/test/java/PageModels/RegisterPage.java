package PageModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.crypto.dsig.XMLObject;
import java.util.List;

public class RegisterPage {
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement userEmailInput;
    @FindBy(xpath = "//input[@id='userMobile']")
    public WebElement userMobileInput;
    @FindBy(xpath = "//select[contains(@class,'custom-select')]")
    public WebElement occupationSelect;
    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> genderRadioButton;
    @FindBy(xpath = "//input[@id='userPassword']")
    public WebElement registerPassword;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement registerConfirmPassword;
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement ageCheckbox;
    @FindBy(xpath = "//input[@id='login']")
    public WebElement registerButton;
    @FindBy(xpath = "//div[@id='toast-container']")
    public WebElement registerToastContainer;
    @FindBy(xpath = "//h1[@class='headcolor']")
    public WebElement successfulAccountCreation;

}
