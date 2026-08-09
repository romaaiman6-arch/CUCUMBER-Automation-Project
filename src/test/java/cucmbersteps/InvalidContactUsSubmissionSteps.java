package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ContactUsPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class InvalidContactUsSubmissionSteps {
    @Given("the browser is ready for InvalidContactUsSubmission")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the InvalidContactUsSubmission flow")
    public void executeInvalidContactUsSubmission() {
        ContactUsPage contactUsPage = homePage.clickcontactus();
        contactUsPage.enterName("Mariam");
        contactUsPage.enterEmail("mariam@gmail.com");
        contactUsPage.enterSubject("Website speed issue");
        contactUsPage.submitWithoutEmail();
        Assert.assertFalse(contactUsPage.isSuccessMessageVisible());
    }
}
