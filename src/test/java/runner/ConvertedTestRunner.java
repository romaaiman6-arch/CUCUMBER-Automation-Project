package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucmber.feature",
        glue = "cucmbersteps",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class ConvertedTestRunner {
}
