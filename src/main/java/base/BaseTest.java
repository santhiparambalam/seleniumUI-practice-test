package base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.CaptureScreenshot;
import utils.JsonConfigReader;
import utils.Log;
import utils.WebDriverUtils;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver; //encapsulated and protected so that subclass can access it
    private String baseUrl;
    private JsonConfigReader configReader;

    public BaseTest(){
        configReader = new JsonConfigReader();
        this.baseUrl = configReader.getUrl("URL");
    }

    @Parameters("browser")
    @BeforeTest
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = WebDriverUtils.getDriver(browser);
        CaptureScreenshot.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Log.info("Get title "+ driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // @AfterTest
    // public void tearDown() {
    //     driver.quit();
    // }
}
