package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class BrowserHelper {
    public WebDriver getChromeDriver() {
        if (!IS_OS_MAC)
            throw new RuntimeException("Unsupported OS!");
        else
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
}
