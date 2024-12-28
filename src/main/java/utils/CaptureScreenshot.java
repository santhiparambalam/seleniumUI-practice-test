package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CaptureScreenshot{

    private static WebDriver driver;

    // Set WebDriver for static usage
    public static void setDriver(WebDriver driver) {
        CaptureScreenshot.driver = driver;
    }

    public static void captureScreenshot(String testName){
         TakesScreenshot takesScreenshot = (TakesScreenshot)driver; // Ensure WebDriver instance is casted correctly
         String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); // Generate a timestamp to make the screenshot name unique      
         File source = takesScreenshot.getScreenshotAs(OutputType.FILE); // Capture screenshot as a file
         try{
            FileUtils.copyFile(source, new File("./Screenshots/" + testName + "_" + timestamp +".png")); // Save screenshot with a timestamp in the filename
        }catch (IOException e) {
		    e.printStackTrace();
			throw new RuntimeException("Unable to capture screenshot", e);
        }
    }
    
}
