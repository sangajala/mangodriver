package mangodriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sriramangajala on 13/07/2014.
 */
public class BusinessLibrary {

    WebDriver driver;
    public BusinessLibrary(WebDriver driver) {
        this.driver = driver;


    }

    public void login(String admin, String password) {
        WebElement loginButton = driver.findElement(By.xpath("//div[@id='shopbar-account']/a/span/span[2]"));
        loginButton.click();
        WebElement userName = driver.findElement(By.id("Username"));
        userName.sendKeys(admin);
        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys(password);
        WebElement submitButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        submitButton.click();
        Utils.pause(5);
//        if(!isUserLoggedin(admin))
//        throw new RuntimeException("User is not logged in");

    }

    private boolean isUserLoggedin(String user) {
            return Utils.isTextAvailable(user);
    }

    public void selectItemfromHomePage(String item) {

        WebElement itemLink = driver.findElement(By.linkText(item));
        itemLink.click();

    }

    public void addItemsIntoBasket(String qty) {

        WebElement quantity=driver.findElement(By.xpath("//div[@id='AddToCart']/div[2]/div/input"));
        quantity.sendKeys(qty);
        WebElement addToCart=driver.findElement(By.linkText("Add to cart"));
        addToCart.click();

    }

    public boolean isItemInBasket(String item) {
        return driver.findElement(By.linkText(item)).isDisplayed();

    }

    public void selectItemfromHomePageAndCompare(String item) {
               selectItemfromHomePage(item);
               addToCompare();
    }

    private void addToCompare() {

    }

    public boolean compareItemsAndCheckThePricesAvailable() {
            return true;
    }

    public void logout() {

    }

    public void goToCart() {

        String Url = driver.getCurrentUrl();
        int x = Url.split("/").length;

        String u = Url.split("/")[x-1];

        driver.navigate().to(Url.replace(u,"cart"));
        Utils.pause(5);

    }

    public void checkOut() {

    }

    public boolean isPaymentOptionAvailble() {
        return true;
    }

    public String[] getAllOption() {
        return new String[0];
    }

    public void selectOpinion(String opinion) {

    }

    public String getErrorMessage() {
                return null;
    }
}
