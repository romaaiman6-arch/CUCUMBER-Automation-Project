package cucmbersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CucumberHooks {
    private static final String BASE_URL = "https://automationexercise.com";

    @Before
    public void setUp() {
        CucumberTestContext.driver = new FirefoxDriver();
        CucumberTestContext.driver.manage().window().maximize();
        CucumberTestContext.driver.get(BASE_URL);
        CucumberTestContext.homePage = new pages.HomePage(CucumberTestContext.driver);
    }

    @After
    public void tearDown() {
        if (CucumberTestContext.driver != null) {
            CucumberTestContext.driver.quit();
        }
        CucumberTestContext.driver = null;
        CucumberTestContext.resetPages();
    }
}
