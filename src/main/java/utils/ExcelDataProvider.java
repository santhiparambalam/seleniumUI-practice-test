package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
    
    private static JsonConfigReader configReader = new JsonConfigReader();

    @DataProvider(name = "excelValidLogin")
    public static Object[][] excelValidLoginData() throws IOException {
        String excelFile = configReader.getExcelFilePath("validLogin"); // Fetch the path for the specified testType
        return readExcelData(excelFile, "validLogin");
    }

    private static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        ExcelUtil excelUtil = new ExcelUtil(filePath);
        int rowCount = ExcelUtil.getrowcount(sheetName);
        int colCount = ExcelUtil.getcolcount(sheetName);
        Object [][] data = new Object[rowCount][colCount];
        for(int rowct=1;rowct<=rowCount;rowct++){
            for(int colct=0;colct<colCount;colct++){
                data[rowct-1][colct] = ExcelUtil.getrowData(sheetName, rowct, colct);
            }
        }
        ExcelUtil.closeExcel();
        return data;
       
    }
    
}
