package helperPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sleepHelperMethods.SleepHelper;

import java.util.List;

public class CommonHelper {
    public static void click(WebDriver driver, By locator) {
        SleepHelper.sleep(1);
        driver.findElement(locator).click();
        SleepHelper.sleep(1);
    }

    public static String getText(WebDriver driver, By locator) {
        return driver.findElement(locator).getText();
    }

    public static void sendKeys(WebDriver driver, By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public static boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() != 0;
    }


    public static boolean isDataInTheDesiredOrder(List<Integer> data, String order) {
        boolean flag = true;
        if (order.equalsIgnoreCase("ascending")) {
            for (int i = 0; i < data.size()-1; i++) {
                if (data.get(i) > data.get(i + 1)) {
                    flag = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < data.size()-1; i++) {
                if (data.get(i) < data.get(i + 1)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

}