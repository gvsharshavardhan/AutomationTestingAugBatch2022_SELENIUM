package UI_Interactions;

import baseTestPackage.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

import static helperPkg.CommonHelper.click;
import static helperPkg.CommonHelper.getText;

public class AlertDemo extends BaseTest {

    private final By simpleAlertLocator = By.id("accept");
    private final By confirmAlertLocator = By.id("confirm");
    private final By promptAlertLocator = By.id("prompt");
    private final By modernAlertLocator = By.id("modern");
    private final By NotificationBarLocator = By.id("myName");
    private final By modernAlertTextLocator = By.xpath("//p[@class='title']");
    private final By modernAlertCloseLocator = By.xpath("//button[@aria-label='close']");

    @Test
    public void alertTest() {
        driver.get("https://letcode.in/alert");

        //1
        click(driver, simpleAlertLocator);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        //2
        click(driver, confirmAlertLocator);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


        //3
        click(driver, promptAlertLocator);
        driver.switchTo().alert().sendKeys("selenium");
        driver.switchTo().alert().accept();
        System.out.println(getText(driver, NotificationBarLocator).contains("selenium"));

        //4
        click(driver, modernAlertLocator);
        System.out.println(getText(driver, modernAlertTextLocator));
        click(driver, modernAlertCloseLocator);

        SleepHelper.sleep(2);

    }

}
