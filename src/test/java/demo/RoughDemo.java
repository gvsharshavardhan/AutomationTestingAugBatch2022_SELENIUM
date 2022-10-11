package demo;

import helperPkg.CommonHelper;
import org.testng.Assert;
import utils.PropertyReader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RoughDemo {
    public static void main(String[] args) {
//        List<Integer> marks = List.of(3,18,12,15);
//
//        System.out.println(CommonHelper.isDataInTheDesiredOrder(marks,"ascending"));

//        System.out.println(PropertyReader.getURL());
//        System.out.println(PropertyReader.getBrowser());
//        System.out.println(PropertyReader.getExplicitTime());

        List<String> veg1 = new ArrayList<>();
        veg1.add("onion");
        veg1.add("beetroot");
        veg1.add("carrot");

        List<String> veg2 = new ArrayList<>();
        veg2.add("beetroot");
        veg2.add("onion");
        veg2.add("carrot");

        Collections.sort(veg1);
        Collections.sort(veg2);
        Assert.assertEquals(veg1,veg2);
    }
}
