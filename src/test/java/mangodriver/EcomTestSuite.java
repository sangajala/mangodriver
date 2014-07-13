package mangodriver;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class EcomTestSuite extends baseTest
{


    //---------data

    String item = "Apple iPhone 5";
    String item1 = "Computer1";
    String[] options = {"DirectDebit","CreditCard","DebitCard"};
    String userName = "test13";
    String password = "Insoft12";






    ///////--

    @Test
    public void verifyAddItemToBasket()
    {

        businessLibrary.login(userName,password);

        businessLibrary.selectItemfromHomePage(item);

        businessLibrary.addItemsIntoBasket("1");

        businessLibrary.goToCart();

        boolean result = businessLibrary.isItemInBasket(item);

        Assert.assertTrue(result);


    }

    @Test
    public void compareItems()
    {
        //login
        businessLibrary.login(userName,password);


        //select from home page and add to compare 1

        businessLibrary.selectItemfromHomePageAndCompare(item);

        //select from home page and add to compare 2
        businessLibrary.selectItemfromHomePageAndCompare(item1);

        //compare item attributes and check
        Assert.assertTrue(businessLibrary.compareItemsAndCheckThePricesAvailable());

        //logut
        businessLibrary.logout();

    }

    @Test
    public void verifyPayment()

    {
        //loging

        businessLibrary.login(userName,password);

        //selct the product and add to cart
        businessLibrary.selectItemfromHomePage(item);
        businessLibrary.addItemsIntoBasket("1");



        //go to cart
        businessLibrary.goToCart();

        //checkout
        businessLibrary.checkOut();


        //viery the payment options avbailable
        Assert.assertTrue(businessLibrary.isPaymentOptionAvailble());


        //getPetmen ootion
        Assert.assertArrayEquals(options,businessLibrary.getAllOption());


    }




}