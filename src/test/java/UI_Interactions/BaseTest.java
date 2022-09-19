package UI_Interactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import userdefinedExceptions.InvalidBrowserNameException;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
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

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}