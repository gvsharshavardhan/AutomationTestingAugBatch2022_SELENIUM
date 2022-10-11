package UI_Interactions;


import baseTestPackage.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

import java.util.List;
import java.util.Set;

import static helperPkg.CommonHelper.*;

public class WindowDemo extends BaseTest {

    private final By homeButton = By.id("home");
    private final By multiWindowButton = By.id("multi");
    private final By headerElementsLocator = By.xpath("//p[@class='card-header-title is-size-3']");

    private final By headerLocator = By.tagName("h1");

    @Test
    public void windowTest() {
        //navigating to window page
        openPage(driver, "https://letcode.in/windows");
        //get the handle of current window
        String windowPageHandle = driver.getWindowHandle();

        click(driver, homeButton);
        //get handles of all the tabs that are present
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(windowPageHandle)) {
                driver.switchTo().window(handle);
            }
        }

        List<WebElement> headerElements = driver.findElements(headerElementsLocator);

        for (WebElement element : headerElements) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void multiTabTest() {
        openPage(driver, "https://letcode.in/windows");
        SleepHelper.sleep(1);
        String parentWindowHandle = driver.getWindowHandle();
        SleepHelper.sleep(1);
        click(driver, multiWindowButton);
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                SleepHelper.sleep(1);
                driver.switchTo().window(handle);
                SleepHelper.sleep(1);
                System.out.println(getText(driver, headerLocator) + " : " + handle);
                if (getText(driver, headerLocator).contains("Alert")) {
                    click(driver, By.id("accept"));
                    System.out.println(driver.switchTo().alert().getText());
                }
            }
        }
    }
}