package realTimeScenarios;

import UI_Interactions.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

public class FidoTest extends BaseTest {


    @Test
    public void testFidoMobile() {
        driver.get("https://www.fido.ca/phones/");

        SleepHelper.sleep(5);

        String fullPriceXpath = "//*[text()='$$']/ancestor::ds-tile//*[contains(text(),'Full Price')]";
        String mobile = "Samsung Galaxy S21 FE 5G";

        String price = driver.findElement(By.xpath(fullPriceXpath.replace("$$", mobile))).getText().trim();
        System.out.println(price);
    }

}
