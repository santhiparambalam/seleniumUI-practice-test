package utils;

import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVDataProvider {
    
    private static JsonConfigReader configReader = new JsonConfigReader();

    @DataProvider(name = "validLogin")
    public Object[][] validLoginData() throws IOException {
        String csvFile = configReader.getCsvFilePath("validLogin"); // Fetch the path for the specified testType
        return readCSVData(csvFile);
    }

    private Object[][] readCSVData(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        
        // Read the number of rows
        int rowCount = 0;
        while ((line = br.readLine()) != null) {
            rowCount++;
        }
        br.close();

        // Read data from the file and populate the Object[][] array
        br = new BufferedReader(new FileReader(filePath));
        String[] headers = br.readLine().split(",");
        Object[][] data = new Object[rowCount - 1][headers.length];

        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (int j = 0; j < values.length; j++) {
                data[i][j] = values[j];
            }
            i++;
        }
        br.close();
        System.out.println(data);
        return data;
    }
}