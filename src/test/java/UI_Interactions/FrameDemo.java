package UI_Interactions;

import baseTestPackage.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

import static helperPkg.CommonHelper.openPage;
import static helperPkg.CommonHelper.sendKeys;

public class FrameDemo extends BaseTest {

    private final By firstNameLocator = By.name("fname");
    private final By lastNameLocator = By.name("lname");
    private final By firstFrameLocator = By.id("firstFr");
    private final By emailFieldLocator = By.name("email");

    private final By innerFrameLocator = By.xpath("//iframe[@src='innerFrame']");

    @Test
    public void frameTest() {
        openPage(driver, "https://letcode.in/frame");

        driver.switchTo().frame(driver.findElement(firstFrameLocator));

        sendKeys(driver, firstNameLocator, "java");

        driver.switchTo().frame(driver.findElement(innerFrameLocator));

        sendKeys(driver, emailFieldLocator, "abcd@xyz.com");

        driver.switchTo().parentFrame();
        sendKeys(driver, lastNameLocator, "language");

        SleepHelper.sleep(3);
    }
}
