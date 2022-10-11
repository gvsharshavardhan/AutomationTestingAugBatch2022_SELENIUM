package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    static String filePath = "C:\\Users\\Harsha\\myOwnWorkSpace\\AutomationTestingAugBatch2022_SELENIUM\\src\\main\\resources\\testdata.xlsx";
    static XSSFWorkbook workbook;

    static Map<String, List<String>> greenCartMap = new HashMap<>();

    static {
        File file = new File(filePath);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet sheet = workbook.getSheet("greenkart");
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        for (int i = 1; i <= rowCount; i++) {
            String key = sheet.getRow(i).getCell(0).getStringCellValue();

            //note: string[] to list
            //1. List.of() -> unmodifiable
            //2. Arrays.asList() -> modifiable

            List<String> veggies = Arrays.asList(sheet.getRow(i).getCell(1).getStringCellValue().split(","));
            greenCartMap.put(key, veggies);
        }
    }

    public static List<String> getVeggies(String tcID) {

        return greenCartMap.get(tcID);

    }

}
