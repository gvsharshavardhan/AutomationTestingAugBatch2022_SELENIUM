package UI_Interactions;

import baseTestPackage.BaseTest;
import helperPkg.CommonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

import java.util.ArrayList;
import java.util.List;

import static helperPkg.CommonHelper.click;
import static helperPkg.CommonHelper.openPage;

public class TableDemo extends BaseTest {


    @Test
    public void simpleTableTest() {
        int indexOfPrice = 0;
        int sum = 0;

        openPage(driver, "https://letcode.in/table");

        //get the index of the prices from the headers order
        List<WebElement> headerElements = driver.findElements(By.xpath("//table[@id='shopping']//thead//th"));
        for (WebElement headerele : headerElements) {
            indexOfPrice++;
            if (headerele.getText().equals("Price")) {
                break;
            }
        }

        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@id='shopping']//tbody//tr/td[" + indexOfPrice + "]"));
        for (WebElement ele : priceElements) {
            sum = sum + Integer.parseInt(ele.getText());
        }

        System.out.println(sum);

        int totalFromPage = Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']//tfoot/td[" + indexOfPrice + "]/b")).getText());
        Assert.assertEquals(sum, totalFromPage, "Sum is not equal with the total price!!");
    }


    @Test
    public void table2Test() {
        openPage(driver, "https://letcode.in/table");
        String name = "Raj";
        driver.findElement(By.xpath("//*[text()='" + name + "']/following-sibling::td/input")).click();
        SleepHelper.sleep(3);

    }

    @Test
    public void carbsDataDescendingOrderTest() {
        openPage(driver, "https://letcode.in/table");
        String carbsHeaderXpath = "//div[contains(text(),'Carbs')]/ancestor::th";
        //scroll to the table

        //webelement.scrollIntoView()
        WebElement sortLebelElement = driver.findElement(By.xpath("//label[@for='sort']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sortLebelElement);

        SleepHelper.sleep(2);

        while (!driver.findElement(By.xpath(carbsHeaderXpath)).getAttribute("aria-sort").equals("descending")) {
            click(driver, By.xpath(carbsHeaderXpath));
        }
        List<WebElement> elements = driver.findElements(By.xpath("//label[text()='Sortable Tables']/following-sibling::table//tr/td[4]"));
        List<Integer> carbValues = new ArrayList<>();
        for (WebElement ele : elements) {
            carbValues.add(Integer.parseInt(ele.getText()));
        }

        boolean answer = CommonHelper.isDataInTheDesiredOrder(carbValues, "descending");
        System.out.println(answer);
    }

    @Test
    public void javaScriptExecutorTest() {
        openPage(driver, "https://letcode.in/table");
        By tableHeaderlocator = By.xpath("//h1");
        WebElement tableHeaderElement = driver.findElement(tableHeaderlocator);
        for (int i = 0; i < 10; i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", tableHeaderElement);
            SleepHelper.sleep(1);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid white'", tableHeaderElement);
            SleepHelper.sleep(1);
        }
    }
}