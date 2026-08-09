package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class InvalidCheckOUtSteps {
    @Given("the browser is ready for InvalidCheckOUt")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the InvalidCheckOUt flow")
    public void executeInvalidCheckOut() {
        ProductPage productPage = homePage.clickproducts();
        productPage.hoverOnFirstProduct();
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isAddedMessageDisplayed());

        CartPage cartPage = productPage.clickViewCart();
        cartPage.clickprocescheckout();
        Assert.assertTrue(cartPage.isLoginRequiredMessageDisplayed());
    }
}
