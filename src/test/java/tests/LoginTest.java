package tests;

import com.vamtester.Model.UserNameAndPassword;
import com.vamtester.pageobjects.LoginPage;
import com.vamtester.utils.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.vamtester.TestData.ApplicationKeywords.applicationURL;


public class LoginTest extends Base {

    private WebDriver driver;
    private UserNameAndPassword userNameAndPassword;


    @BeforeTest
   void launch()
    {
        driver = setUp(applicationURL);
        userNameAndPassword = getCredentials(driver);
    }

    @Test
    void testCase01()
    {
        try {
            LoginPage login = new LoginPage(driver);
            login.login(userNameAndPassword.getUsername(), userNameAndPassword.getPassword());
            String redirectionCheck = "practicetestautomation.com/logged-in-successfully/";
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains(redirectionCheck));
            System.out.println("Verify new url page:");
            Assert.assertTrue(driver.getPageSource().contains("Congratulations student. You successfully logged in!"));
            System.getProperty("Verify new page contains expected text");
            System.out.println("Test Case 01 Passed");
        }
        catch (AssertionError | Exception e)
        {
            e.printStackTrace();
            Assert.fail("Test Case 01 Failed");
        }
    }

}
