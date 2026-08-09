package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class ProductTestSteps {
    @Given("the browser is ready for ProductTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the ProductTest flow")
    public void executeProductTest() {
        homePage.clicksignlogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("123456");
        loginPage.clickLogin();

        ProductPage productPage = homePage.clickproducts();
        productPage.hoverOnFirstProduct();
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isAddedMessageDisplayed());
    }
}
