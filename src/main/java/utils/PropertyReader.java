package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    static String propertyFilePath = "C:\\Users\\Harsha\\myOwnWorkSpace\\AutomationTestingAugBatch2022_SELENIUM\\src\\main\\resources\\greenkart.properties";
    static Properties properties;

    static {
        File file = new File(propertyFilePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties = new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getURL() {
        return (String) properties.get("url");
    }

    public static String getBrowser() {
        return (String) properties.get("browser");
    }

    public static int getExplicitTime() {
        return Integer.parseInt((String) properties.get("explicitwait"));
    }

    //note : Integer.parseInt(number in string format) -> integer
    public static int getImplicitTime() {
        return Integer.parseInt((String) properties.get("implicitwait"));
    }

}