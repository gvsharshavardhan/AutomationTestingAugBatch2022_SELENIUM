package UI_Interactions;

import baseTestPackage.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

import java.time.Duration;

public class WaitsDemo extends BaseTest {

    @Test
    public void alertWaitTest(){
        driver.get("https://letcode.in/waits");
        driver.findElement(By.id("accept")).click();

        //1. thread.sleep -> not recommeneded
        //2. implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        //3. explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());


        driver.switchTo().alert();
        System.out.println(driver.switchTo().alert().getText());

        SleepHelper.sleep(2);

        driver.switchTo().alert().accept();
    }
}