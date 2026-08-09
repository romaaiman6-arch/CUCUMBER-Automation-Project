package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class PaymentTestSteps {
    @Given("the browser is ready for PaymentTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the PaymentTest flow")
    public void executePaymentTest() {
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
        PaymentPage paymentPage = checkOutPage.clickPlaceOrder();
        paymentPage.enterNameOnCard("mariam ");
        paymentPage.enterExpiryMonth("12");
        paymentPage.enterExpiryYear("12");
        paymentPage.enterCVC("123");
        paymentPage.enterCardNumber("2543987323676396");
        paymentPage.clickPayAndConfirm();
        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully1());
        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully2());
        paymentPage.clickContinue();
    }
}
