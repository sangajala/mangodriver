package mangodriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by sriramangajala on 13/07/2014.
 */
public class RegressionTestSuite extends baseTest
{
    static WebDriver driver;
    static BusinessLibrary businessLibrary;
    String userName = "test13";
    String password = "Insoft12";

    //datata--
    String opinion = "Excellent";


    //-----
    @Test
    public void verifyTheOpinionPoll()
    {
        //dont logout
        businessLibrary.logout();


        //selct the option("exceleleyt"
        businessLibrary.selectOpinion(opinion);


        //ceirfy the error message
        Assert.assertEquals("Only registered users can vote.",businessLibrary.getErrorMessage());


    }

    @Test
    public void verifyTheOpinionPollWithLogin()
    {
        //dont logout
        businessLibrary.login(userName,password);


        //selct the option("exceleleyt"
        businessLibrary.selectOpinion(opinion);


        //ceirfy the error message
        Assert.assertEquals("Success",businessLibrary.getErrorMessage());


    }
}
