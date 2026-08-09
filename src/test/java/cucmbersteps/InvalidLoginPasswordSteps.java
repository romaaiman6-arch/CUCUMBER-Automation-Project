package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class InvalidLoginPasswordSteps {
    @Given("the browser is ready for InvaliedLoginPassword")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the InvaliedLoginPassword flow")
    public void executeInvalidLoginPassword() {
        LoginPage loginPage = homePage.clicksignlogin();
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("128666");
        loginPage.clickLogin();
        Assert.assertEquals("Your email or password is incorrect!", loginPage.getIncorrectLoginMessage());
    }
}
