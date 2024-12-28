package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    private WebDriver driver;
    
    // Locators (Encapsulation)
    private By signInButton = By.cssSelector("[data-test='nav-sign-in']");
    private By navigationMenuDropDown = By.cssSelector("[data-test='nav-menu']");
    private By signOutButton = By.cssSelector("[data-test='nav-sign-out']");
    
    // Constructor
    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Abstraction of actions
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void clickOnNavigationMenu() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(navigationMenuDropDown));
        driver.findElement(navigationMenuDropDown).click();
    }

    public void clickSignOut() {
        clickOnNavigationMenu();
        WebElement option = driver.findElement(signOutButton);
        option.click();
    }
}
