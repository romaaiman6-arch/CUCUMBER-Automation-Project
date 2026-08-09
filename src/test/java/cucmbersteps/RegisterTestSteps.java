package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Accountinformationpage;
import pages.HomePage;
import pages.SignUpPage;

import static cucmbersteps.CucumberTestContext.driver;

public class RegisterTestSteps {
    @Given("the browser is ready for RegisterTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the RegisterTest flow")
    public void executeRegisterTest() throws InterruptedException {
        HomePage homePage1 = new HomePage(driver);
        homePage1.clicksignlogin();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.fillName("Mariam123678");
        signUpPage.fillEmail("mariam45666@gmail.com");
        signUpPage.clickSignup();
        Thread.sleep(3000);

        Accountinformationpage accountInformationPage = new Accountinformationpage(driver);
        accountInformationPage.enterPassword("123456");
        accountInformationPage.enterAddress("33 cairo ");
        accountInformationPage.enterZipCode("1286");
        accountInformationPage.enterCity("cairo");
        accountInformationPage.enterMobileNumber("01211798852");
        accountInformationPage.enterLastName("ayman");
        accountInformationPage.enterFirstName("mariam ");
        accountInformationPage.enterState("canda ");
        accountInformationPage.clickCreateAccount();
        Thread.sleep(5000);
    }
}
