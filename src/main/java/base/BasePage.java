package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver Tdriver) {
        driver = Tdriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getExplicitTime()));
    }

}