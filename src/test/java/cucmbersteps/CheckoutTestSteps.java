package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class CheckoutTestSteps {
    @Given("the browser is ready for CheckoutTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the CheckoutTest flow")
    public void executeCheckoutTest() {
        homePage.clicksignlogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("123456");
        loginPage.clickLogin();

        ProductPage productPage = homePage.clickproducts();
        productPage.hoverOnFirstProduct();
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickViewCart();
        CheckOutPage checkOutPage = cartPage.clickprocescheckout();
        Assert.assertTrue(checkOutPage.isDeliveryAddressDisplayed());
        Assert.assertTrue(checkOutPage.isBillingAddressDisplayed());
        checkOutPage.clickPlaceOrder();
    }
}
