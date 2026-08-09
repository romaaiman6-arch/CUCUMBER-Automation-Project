package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.*;

public class CartTestSteps {
    @Given("the browser is ready for CartTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the CartTest flow")
    public void executeCartTest() {
        homePage.clicksignlogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("123456");
        loginPage.clickLogin();
        ProductPage productPage = homePage.clickproducts();
        productPage.hoverOnFirstProduct();
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickViewCart();
        cartPage.clickprocescheckout();
    }
}
