package baseTestPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import userdefinedExceptions.InvalidBrowserNameException;
import utils.PropertyReader;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = PropertyReader.getBrowser();
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyReader.getImplicitTime()));

    }

    //    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}