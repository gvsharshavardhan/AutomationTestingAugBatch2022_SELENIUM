package UI_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonDemo extends BaseTest {

    private final By homeButtonLocator = By.id("home");
    private final By coordinatesButtonLocator = By.id("position");
    private final By colorButtonLocator = By.id("color");
    private final By dimensionButtonLocator = By.id("property");
    private final By disabledButtonLocator = By.id("isDisabled");


    @Test
    public void homeButtonPageNavigationTest() {

        driver.get("https://letcode.in/buttons");
        //1. click on the button -> it should take me to home page
        driver.findElement(homeButtonLocator).click();
        //2. validate that user is on home page
        String actualTitle = driver.getTitle();
        String expectedTitle = "LetCode with Koushik";
        Assert.assertEquals(actualTitle, expectedTitle, "clicking on home button did not take us to home page!");
        //3. navigate back
        driver.navigate().back();
        //4. validate that user is on button page
        actualTitle = driver.getTitle().toLowerCase();
        expectedTitle = "button";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "navigating back from homepage did not take us to button page!");
    }

    @Test
    public void colorDimensionLocationDisabledTest() {
        //co-ordinates
        driver.get("https://letcode.in/buttons");
        Point coordinates = driver.findElement(coordinatesButtonLocator).getLocation();
        System.out.println("X: " + coordinates.getX());
        System.out.println("Y: " + coordinates.getY());

        //color
        String color = driver.findElement(colorButtonLocator).getCssValue("background-color");
        System.out.println("color:" + color);

        //dimensions
        Rectangle dimension = driver.findElement(dimensionButtonLocator).getRect();
        System.out.println("Height: " + dimension.getHeight());
        System.out.println("Widtht: " + dimension.getWidth());

        //disability check
        boolean isEnabled = driver.findElement(disabledButtonLocator).isEnabled();
        System.out.println("Is button enabled: " + isEnabled); //false


        //click and hold scenario
        WebElement clickHoldElement = driver.findElement(By.xpath("//h2[text()='Button Hold!']/ancestor::button"));
        System.out.println("before click and hold: " + clickHoldElement.getText());
        //mouse and keyboard related actions
        Actions actions = new Actions(driver);
        actions.clickAndHold(clickHoldElement).pause(Duration.ofSeconds(3)).release().perform();
        System.out.println("after click and hold: " + clickHoldElement.getText());

    }


}
