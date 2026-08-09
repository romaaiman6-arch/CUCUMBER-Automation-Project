package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class LoginTestSteps {
    @Given("the browser is ready for LoginTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the LoginTest flow")
    public void executeLoginTest() {
        HomePage homePage1 = new HomePage(driver);
        homePage1.clicksignlogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("123456");
        loginPage.clickLogin();
        Assert.assertTrue(homePage.isUserLoggedIn());
        Assert.assertEquals("Logged in as Mariam123678", homePage.getLoggedInText());
    }
}
