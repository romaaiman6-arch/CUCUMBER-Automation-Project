package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class CheckoutEmptyCartSteps {
    @Given("the browser is ready for CheckoutEmptyCart")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the CheckoutEmptyCart flow")
    public void executeCheckoutEmptyCart() {
        CartPage cartPage = homePage.clickcart();
        Assert.assertTrue(cartPage.isCartEmpty());
        Assert.assertTrue(cartPage.getEmptyCartMessage().contains("Cart is empty!"));
        Assert.assertFalse(cartPage.isProceedToCheckoutDisplayed());
    }
}
