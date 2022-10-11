package greenKartPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage extends BasePage {

    private final By termsAndConditionsCheckBox = By.xpath("//input[@class='chkAgree']");

    private final By proceedButtonLocator = By.xpath("//button[.='Proceed']");
    public TermsAndConditionsPage(WebDriver Tdriver) {
        super(Tdriver);
    }

    public void clickProceedButton(){
        driver.findElement(proceedButtonLocator).click();
    }

    public void selectTermsAndConditions(){
        driver.findElement(termsAndConditionsCheckBox).click();
    }


}
