package testCase;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.MenuPage;
// import utils.CSVDataProvider;
import utils.ExcelDataProvider;
import utils.Log;

@Listeners(utils.TestStatusListener.class) // Registering the listener
public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private MenuPage menuPage;

    @BeforeMethod
    public void initLoginPage(){
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
    }

    @Test(dataProvider = "excelValidLogin", dataProviderClass = ExcelDataProvider.class)
    // @Test(dataProvider = "validLogin", dataProviderClass = CSVDataProvider.class)
    public void testValidLogin(String role, String username, String password){
        Log.info("Test login for "+role);
        loginPage = new LoginPage(driver);
        menuPage.clickSignIn();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        Log.info("Enter username " + username + " and password" + password );
        loginPage.clickLogin();
        Log.info("Click login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        menuPage.clickSignOut();
        Log.info("Signed Out");
    }

    // @Test(dataProvider = "invalidLogin", dataProviderClass = CSVDataProvider.class)
    // public void testInValidLogin(String role, String username, String password){
    //     Log.info("Test login for "+role);
    //     loginPage = new LoginPage(driver);
    //     menuPage.clickSignIn();
    //     loginPage.enterUsername(username);
    //     loginPage.enterPassword(password);
    //     Log.info("Enter username " + username + " and password" + password );
    //     loginPage.clickLogin();
    //     Log.info("Click login");
    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // }

    
}
