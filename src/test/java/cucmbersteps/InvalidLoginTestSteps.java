package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class InvalidLoginTestSteps {
    @Given("the browser is ready for InvalidLoginTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the InvalidLoginTest flow")
    public void executeInvalidLoginTest() {
        LoginPage loginPage = homePage.clicksignlogin();
        loginPage.loginEmail("wrongemail@gmail.com");
        loginPage.loginpassword("wrongPassword123");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isIncorrectLoginMessageDisplayed());
        Assert.assertEquals("Your email or password is incorrect!", loginPage.getIncorrectLoginMessage());
    }
}
