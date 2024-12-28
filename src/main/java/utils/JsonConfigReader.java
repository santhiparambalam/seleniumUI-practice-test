package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonConfigReader {
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.json"; // Path to your JSON file
    private JsonNode configNode;

    public JsonConfigReader() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            configNode = objectMapper.readTree(new File(CONFIG_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file.", e);
        }
    }

    // Method to fetch the URL
    public String getUrl(String key) {
        return configNode.path("URLS").path(key).asText();
    }

    //Method to fetch the CSV file path
    public String getCsvFilePath(String key) {
        return configNode.path("CSV").path(key).asText();
    }

    //Method to fetch the Excel file path
    public String getExcelFilePath(String key) {
        return configNode.path("Excel").path(key).asText();
    }
}