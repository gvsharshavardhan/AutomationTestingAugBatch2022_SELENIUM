package greenKartPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PreviewOrderPage extends BasePage {


    private final By promoCodeFieldLocator = By.xpath("//input[@class='promoCode']");
    private final By applyPromoCodeButtonLocator = By.xpath("//button[@class='promoBtn']");

    private final By promoMessageLocator = By.xpath("//span[@class='promoInfo']");

    private final By placeOrderLocator = By.xpath("//button[.='Place Order']");

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    private final By allVeggiesLocator = By.xpath("//p[@class='product-name']");

    public PreviewOrderPage(WebDriver Tdriver) {
        super(Tdriver);
    }

    public List<String> getAllVeggiesFromTheTable() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderLocator));

        List<String> veggies = new ArrayList<>();
        List<WebElement> veggieElements = driver.findElements(allVeggiesLocator);
        for (WebElement ele : veggieElements) {
            veggies.add(ele.getText().split("-")[0].toLowerCase().trim());
        }
        return veggies;
    }

    public void placeOrder() {
        driver.findElement(placeOrderLocator).click();
    }

    public String getPromoMessageText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(promoMessageLocator));
        return driver.findElement(promoMessageLocator).getText();
    }

    public void enterPromoCode(String promoCode) {
        driver.findElement(promoCodeFieldLocator).sendKeys(promoCode);
    }

    public void applyPromoCode() {
        driver.findElement(applyPromoCodeButtonLocator).click();
    }

}
