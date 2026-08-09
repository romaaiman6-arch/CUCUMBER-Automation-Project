package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.SignUpPage;

import static cucmbersteps.CucumberTestContext.driver;

public class InvalidSignupTestSteps {
    @Given("the browser is ready for InvalidSignupTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the InvalidSignupTest flow")
    public void executeInvalidSignupTest() {
        HomePage homePage1 = new HomePage(driver);
        homePage1.clicksignlogin();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.fillName("Mariam");
        signUpPage.fillEmail("mariam45666@gmail.com");
        signUpPage.clickSignup();
        Assert.assertTrue(signUpPage.isExistingEmailErrorDisplayed());
    }
}
