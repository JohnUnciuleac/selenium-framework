package PageModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage {
    @FindBy(xpath = "//div[@class='card-body']")
    public List<WebElement> productsCard;

}
