package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }


    //loctors for login
    private By loginEmail= By.cssSelector("input[data-qa='login-email']");
    private By loginPassword = By.name("password");
    private By clickloginin =By.cssSelector("button[data-qa='login-button']");
    private By loginPageTitle = By.xpath("//h2[normalize-space()='Login to your account']");
    private By signupPageTitle = By.xpath("//h2[normalize-space()='New User Signup!']");
    private By incorrectLoginMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");





    //ACTIOS FOR LOGIN
    public void loginEmail ( String EMAIL ){
        driver.findElement(loginEmail).sendKeys(EMAIL);
    }
    public void loginpassword(String password){
        driver.findElement(loginPassword).sendKeys(password);
    }
    public void clickLogin (){
        driver.findElement(clickloginin).click();
    }
    public boolean isLoginPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageTitle)
        ).isDisplayed();

    }
    public boolean isSignupSectionDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupPageTitle)
        ).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public boolean isIncorrectLoginMessageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        incorrectLoginMessage
                )
        ).isDisplayed();
    }
    public String getIncorrectLoginMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        incorrectLoginMessage
                )
        ).getText().trim();
    }
}



















