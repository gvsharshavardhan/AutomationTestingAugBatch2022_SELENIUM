package greenKartPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sleepHelperMethods.SleepHelper;
import utils.PropertyReader;

public class HomePage extends BasePage {
    private final String greenKartURL = PropertyReader.getURL();
    private final By kartIconLocator = By.xpath("//a[@class='cart-icon']");
    private String dynamicAddToCartXpath = "//h4[contains(.,'$$')]/following-sibling::div[@class='product-action']//button";
    private By addToCartButton = By.xpath("//button[.='ADD TO CART']");
    private final By proceedToCheckoutLocator = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    private final By titleLocator = By.xpath("//div[@class='brand greenLogo']");
    private final By searchFieldLocator = By.xpath("//input[@type='search']");
    private final By searchButtonLocator = By.xpath("//button[@type='submit']");

    public HomePage(WebDriver Tdriver) {
        super(Tdriver);
    }

    public void addToCart(){
        SleepHelper.sleep(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton)).click();
    }

    public void searchVegetable(String veg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator)).sendKeys(veg);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButtonLocator)).click();
    }

    public String getTitle() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(titleLocator, "GREEN"));
        return driver.findElement(titleLocator).getText();
    }

    public void clickProceedToCheckoutButton() {
        driver.findElement(proceedToCheckoutLocator).click();
    }

    public void navigateToGreenKartPage() {
        driver.get(greenKartURL);
    }

    public void clickKartIcon() {
        driver.findElement(kartIconLocator).click();
    }

    public void addAVegitableToTheKart(String veg) {
        driver.findElement(By.xpath(dynamicAddToCartXpath.replace("$$", veg))).click();
    }


}
