package UI_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class InputDemo  extends BaseTest{

    private final By fullNameInputLocator = By.id("fullName");
    private final By joinInputLocator = By.id("join");
    private final By getMeInputLocator = By.id("getMe");
    private final By editInputLocator = By.id("noEdit");
    private final By readOnlyInputLocator = By.id("dontwrite");
    private final By clearInputLocator = By.id("clearMe");

    @Test
    public void inputTest1(){
        driver.get("https://letcode.in/edit");
        driver.findElement(fullNameInputLocator).sendKeys("harsha vardhan");
        driver.findElement(joinInputLocator).sendKeys("busyqa");
        driver.findElement(joinInputLocator).sendKeys(Keys.TAB);
        System.out.println("Pre populated text: " + driver.findElement(getMeInputLocator).getAttribute("value"));
        driver.findElement(clearInputLocator).clear();
        System.out.println("is enabled: " + driver.findElement(editInputLocator).isEnabled());

        System.out.println("readonly:" + driver.findElement(readOnlyInputLocator).getAttribute("readonly"));
        System.out.println("readonly:" + driver.findElement(readOnlyInputLocator).getAttribute("harsha"));
        System.out.println("get text when no text is present:" + driver.findElement(readOnlyInputLocator).getText());
    }


}
