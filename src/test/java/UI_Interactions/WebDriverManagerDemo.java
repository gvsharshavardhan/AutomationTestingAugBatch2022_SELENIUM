package UI_Interactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;
import userdefinedExceptions.InvalidBrowserNameException;

public class WebDriverManagerDemo {
    WebDriver driver;

    @Test
    public void test1() {
        String browser = "chrome";
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new InvalidBrowserNameException("Please enter valid browser name! (chrome/firefox)");
        }

        //maximize the browser
        driver.manage().window().maximize();

        //get size of the browser window
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Height: " + dimension.getHeight());
        System.out.println("Width: " + dimension.getWidth());

        Dimension dimension1 = new Dimension(200,200);
        driver.manage().window().setSize(dimension1);


        driver.get("https://www.google.com");


        SleepHelper.sleep(3);


        driver.quit();
    }
}
