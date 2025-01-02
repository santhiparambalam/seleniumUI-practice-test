package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;

    //locators
    private By dashboardTitle = By.cssSelector("[data-test=page-title");

    //constructor
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    
    public String getDashboardTitleText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 10 seconds wait
        // Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle));
        return driver.findElement(dashboardTitle).getText();
    }
}
