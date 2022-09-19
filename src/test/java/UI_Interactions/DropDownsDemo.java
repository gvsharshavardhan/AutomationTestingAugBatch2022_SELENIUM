package UI_Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import sleepHelperMethods.SleepHelper;

import java.util.*;

public class DropDownsDemo extends BaseTest{

    @Test
    public void visibleTextTest(){
        driver.get("https://letcode.in/dropdowns");
        By fruitsDropDown = By.id("fruits");
        WebElement fruitsDropDownElement = driver.findElement(fruitsDropDown);
        Select select = new Select(fruitsDropDownElement);
        String fruit = "Orange";
        select.selectByVisibleText(fruit);

        SleepHelper.sleep(3);

        String subtitle = driver.findElement(By.xpath("//p[@class='subtitle']")).getText();
        System.out.println(subtitle);
        Assert.assertTrue(subtitle.contains(fruit),"Improper dropdown option is selected!");
    }

    @Test
    public void multiDropDownTest(){
        driver.get("https://letcode.in/dropdowns");
        WebElement superHeroDropDown = driver.findElement(By.id("superheros"));
        Select select = new Select(superHeroDropDown);
        if(select.isMultiple()){
            select.selectByValue("dd");
            select.selectByValue("ds");
        }
        SleepHelper.sleep(3);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        HashMap<String,String> selectedOptionsMap = new HashMap<>();
        for(WebElement element:selectedOptions){
            String text = element.getText();
            String  value = element.getAttribute("value");
            selectedOptionsMap.put(value,text);
        }
        System.out.println(selectedOptionsMap);
    }

    @Test
    public void lastLangTest(){
        //lang

        driver.get("https://letcode.in/dropdowns");
        WebElement langElement = driver.findElement(By.id("lang"));
        Select select = new Select(langElement);
        List<WebElement> langOptionsElements = select.getOptions();
        List<String> langOptions = new ArrayList<>();
        for(WebElement element :langOptionsElements){
            langOptions.add(element.getText());
        }
        System.out.println(langOptions);

        String lastValue = langOptions.get(langOptions.size()-1);
        select.selectByVisibleText(lastValue);

        String selectOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectOption,lastValue,".did not select the last option!");
    }



}
