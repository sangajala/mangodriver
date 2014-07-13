package mangodriver;

import org.openqa.selenium.WebDriver;

/**
 * Created by sriramangajala on 13/07/2014.
 */
public class Utils {
    static WebDriver driver;

    public Utils(WebDriver driver)
    {

    }

    public static boolean isTextAvailable(String text)
    {
        return driver.getPageSource().contains(text);
    }

    public static void pause(int time)
    {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setDriver(WebDriver driver) {

    }
}
