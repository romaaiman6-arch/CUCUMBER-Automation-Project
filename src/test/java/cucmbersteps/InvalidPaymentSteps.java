package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class InvalidPaymentSteps {
    @Given("the browser is ready for IvalidPayment")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the IvalidPayment flow")
    public void executeInvalidPayment() {
        HomePage homePage1 = new HomePage(driver);
        homePage1.clicksignlogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmail("mariam45666@gmail.com");
        loginPage.loginpassword("123456");
        loginPage.clickLogin();

        ProductPage productPage = homePage.clickproducts();
        productPage.hoverOnFirstProduct();
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isAddedMessageDisplayed());

        CartPage cartPage = productPage.clickViewCart();
        CheckOutPage checkoutPage = cartPage.clickprocescheckout();
        PaymentPage paymentPage = checkoutPage.clickPlaceOrder();
        Assert.assertTrue(driver.getCurrentUrl().contains("/payment"));

        paymentPage.enterNameOnCard("Mariam");
        paymentPage.enterCVC("123");
        paymentPage.enterExpiryMonth("12");
        paymentPage.enterExpiryYear("2030");
        paymentPage.clickPayAndConfirm();
        Assert.assertTrue(paymentPage.isStillOnPaymentPage());
    }
}
