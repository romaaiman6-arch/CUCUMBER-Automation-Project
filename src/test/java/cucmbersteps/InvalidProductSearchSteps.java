package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductPage;

import static cucmbersteps.CucumberTestContext.driver;
import static cucmbersteps.CucumberTestContext.homePage;

public class InvalidProductSearchSteps {
    @Given("the browser is ready for InvaliedProdctSearch")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the InvaliedProdctSearch flow")
    public void executeInvalidProductSearch() {
        ProductPage productPage = homePage.clickproducts();
        productPage.searchForProduct("invalid-product-12345");
        Assert.assertEquals(0, productPage.getSearchResultsCount());
    }
}
