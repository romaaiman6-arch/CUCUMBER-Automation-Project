package cucmbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestCasesPage;

import static cucmbersteps.CucumberTestContext.driver;

public class TestCaseTestSteps {
    @Given("the browser is ready for TestCaseTest")
    public void browserIsReady() {
        Assert.assertNotNull(driver);
    }

    @When("I execute the TestCaseTest flow")
    public void executeTestCaseTest() {
        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.TestcaseButton();
        Assert.assertTrue(testCasesPage.isTestCasesPageDisplayed());
        Assert.assertTrue(testCasesPage.getCurrentUrl().contains("/test_cases"));
    }
}
