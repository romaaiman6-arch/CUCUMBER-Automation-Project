package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class ContactUsSteps {
    private static final String CONTACT_FILE = "C:\\Users\\Mega Store\\Desktop\\Hello.java";

    @Given("the browser is ready for ContactUs")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the ContactUs flow")
    public void executeContactUs() {
        HomePage homePage1 = new HomePage(driver);
        homePage1.clicksignlogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("123456");
        loginPage.clickLogin();

        Assert.assertTrue(homePage.isUserLoggedIn());
        Assert.assertEquals("Logged in as Mariam123678", homePage.getLoggedInText());

        ContactUsPage contactUsPage = homePage1.clickcontactus();
        contactUsPage.enterName("mariam");
        contactUsPage.enterEmail("mariam45666@gmail.com");
        contactUsPage.enterSubject("about the speed ");
        contactUsPage.enterMessage("the website spend long time to work");
        contactUsPage.uploadFile(CONTACT_FILE);
        contactUsPage.clickSubmit();
        contactUsPage.acceptAlert();

        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
        contactUsPage.clickHome();
    }
}
