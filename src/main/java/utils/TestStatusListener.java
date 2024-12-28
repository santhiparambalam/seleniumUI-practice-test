package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestStatusListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try{
            CaptureScreenshot.captureScreenshot(result.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
