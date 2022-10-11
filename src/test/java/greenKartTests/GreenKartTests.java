package greenKartTests;

import baseTestPackage.BaseTest;
import greenKartPages.HomePage;
import greenKartPages.PreviewOrderPage;
import greenKartPages.TermsAndConditionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreenKartTests extends BaseTest {



    @Test
    public void PlaceOrderTest() {
        HomePage homePage = new HomePage(driver);
        PreviewOrderPage previewOrderPage = new PreviewOrderPage(driver);
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);

        //1. naviagte to homepage
//        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        homePage.navigateToGreenKartPage();


        //2. dynamic add to cart xpath
//        String addToCartXpath = "//h4[contains(.,'$$')]/following-sibling::div[@class='product-action']//button";

        //3. veg list
        List<String> veggies = new ArrayList<>();
        veggies.add("Tomato");
        veggies.add("Brocolli");

        //4. lopping over veg list to click on add to cart
        for (String veg : veggies) {
//            driver.findElement(By.xpath(addToCartXpath.replace("$$", veg))).click();
            homePage.addAVegitableToTheKart(veg);
        }

        //click on kart icon button
//        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        homePage.clickKartIcon();

        //click on proceed to checkout
//        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        homePage.clickProceedToCheckoutButton();

        //-----------------------previewPage------------

        //add promocode
//        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        previewOrderPage.enterPromoCode("rahulshettyacademy");


        //click apply button
//        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        previewOrderPage.applyPromoCode();

        //get the applied message and print on to the console

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));


//        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
        System.out.println(previewOrderPage.getPromoMessageText());


        //click on place order
//        driver.findElement(By.xpath("//button[.='Place Order']")).click();
        previewOrderPage.placeOrder();

//------------------terms and condition page

//        driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
        termsAndConditionsPage.selectTermsAndConditions();

        //click proceed
//        driver.findElement(By.xpath("//button[.='Proceed']")).click();
        termsAndConditionsPage.clickProceedButton();

        //
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='brand greenLogo']"), "GREEN"));


        Assert.assertEquals(homePage.getTitle(), "GREENKART");
    }


    @Test
    public void searchAndAddVeggiesTest() {
        HomePage homePage = new HomePage(driver);
        PreviewOrderPage previewOrderPage = new PreviewOrderPage(driver);
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);
        homePage.navigateToGreenKartPage();

        List<String> veggies = ExcelReader.getVeggies("TC1");

        for (String veg : veggies) {
            homePage.searchVegetable(veg);
            homePage.addToCart();
        }

        homePage.clickKartIcon();
        homePage.clickProceedToCheckoutButton();

        //validate the veggies in the table
        List<String> actualList = previewOrderPage.getAllVeggiesFromTheTable();
        System.out.println(actualList);
        Collections.sort(veggies);
        Collections.sort(actualList);
        Assert.assertEquals(actualList, veggies, "Veggies list in the table is not as expected!!");

        previewOrderPage.placeOrder();
        termsAndConditionsPage.selectTermsAndConditions();
        termsAndConditionsPage.clickProceedButton();
        Assert.assertEquals(homePage.getTitle(),"GREENKART","Proceed button did not take us to home page again!!");
    }
}