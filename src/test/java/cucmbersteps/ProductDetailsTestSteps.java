package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductDetails;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.driver;

public class ProductDetailsTestSteps {
    @Given("the browser is ready for ProductDetailstest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the ProductDetailstest flow")
    public void executeProductDetailsTest() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickproducts();
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"));
        productPage.openFirstProduct();

        ProductDetails productDetails = new ProductDetails(driver);
        Assert.assertEquals("Blue Top", productDetails.getProductName());
        Assert.assertTrue(productDetails.isProductDetailsDisplayed());
        Assert.assertEquals("Rs. 500", productDetails.getProductPrice());
    }
}
