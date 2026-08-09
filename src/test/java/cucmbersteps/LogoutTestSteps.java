package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class LogoutTestSteps {
    @Given("the browser is ready for LogOutTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the LogOutTest flow")
    public void executeLogoutTest() {
        LoginPage loginPage = homePage.clicksignlogin();
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("123456");
        loginPage.clickLogin();

        Assert.assertTrue(homePage.isUserLoggedIn());
        Assert.assertEquals("Logged in as Mariam123678", homePage.getLoggedInText());

        LoginPage loginPageAfterLogout = homePage.clickLogout();
        Assert.assertTrue(loginPageAfterLogout.isLoginPageDisplayed());
        Assert.assertTrue(loginPageAfterLogout.isSignupSectionDisplayed());
        Assert.assertTrue(loginPageAfterLogout.getCurrentUrl().contains("/login"));
    }
}
