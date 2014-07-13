package mangodriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by sriramangajala on 13/07/2014.
 */
public class baseTest {

    static WebDriver driver;
    static BusinessLibrary businessLibrary;
    static Utils utils;
    @BeforeClass
    public static void start()
    {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://frontend.smartstore.net/en");
        businessLibrary = new BusinessLibrary(driver);
        utils = new Utils(driver);
        Utils.driver = (driver);

    }

    @AfterClass
    public static void stop()
    {
        driver.quit();
    }
}
