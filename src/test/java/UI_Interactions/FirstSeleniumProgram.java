package UI_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

import java.util.Scanner;

public class FirstSeleniumProgram {

    //selenium -> driver -> browser


    public static void main(String[] args) {
        WebDriver driver;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please entre the browser name:");
        String browser = sc.nextLine();

        if(browser.equalsIgnoreCase("chrome")){
            //setting up chrome driver location to the program
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harsha\\myOwnWorkSpace\\AutomationTestingAugBatch2022_SELENIUM\\drivers\\chromedriver.exe");
            //create an obj for respective browser
            //is responsible to invoke browser
            driver = new ChromeDriver();
        }else{
            //setting up chrome driver location to the program
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harsha\\myOwnWorkSpace\\AutomationTestingAugBatch2022_SELENIUM\\drivers\\geckodriver.exe");
            //create an obj for respective browser
            //is responsible to invoke browser
            driver = new FirefoxDriver();
        }


        //navigate to the website
        driver.get("https://www.saucedemo.com/");

        //indentifing the web elements using By.id locator strategy
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //entering text into username and password fields

        driver.findElement(By.id("login-button")).click();

        //halt for 5 seconds
        SleepHelper.sleep(3);

        String title = driver.findElement(By.className("title")).getText();


        //validating the title of the page
        Assert.assertTrue(title.equalsIgnoreCase("products"));
//        Assert.assertEquals(title,"products");


        //quit the browser
        driver.close();
    }

    @Test
    public void test2(){
        System.out.println("testcase 2");
    }
}