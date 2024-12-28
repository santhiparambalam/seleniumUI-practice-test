package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators (Encapsulation)
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("[data-test='login-submit']");

    //examples -> <div _ngcontent-ng-c1371883730="" id="email-error" data-test="email-error" class="alert alert-danger"><div _ngcontent-ng-c1371883730="">Email is required</div><!----><!----></div>
    // private By incorrectEmailError = By.id("email-error");
    // private By incorrectEmailError = By.xpath("//div[@id='email-error']");
    // private By incorrectEmailError= By.cssSelector("#email-error");
    public By incorrectEmailError= By.cssSelector("[data-test='email-error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(incorrectEmailError).getText();
    }
}