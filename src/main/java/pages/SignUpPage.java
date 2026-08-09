package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Locators
    private By signupName =
            By.name("name");

    private By signupEmail =
            By.cssSelector("input[data-qa='signup-email']");

    private By signupButton =
            By.cssSelector("button[data-qa='signup-button']");

    private By existingEmailError =
            By.xpath("//p[normalize-space()='Email Address already exist!']");

    // Actions
    public void fillName(String name) {
        driver.findElement(signupName).sendKeys(name);
    }

    public void fillEmail(String email) {
        driver.findElement(signupEmail).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    public boolean isExistingEmailErrorDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        existingEmailError
                )
        ).isDisplayed();
    }


}