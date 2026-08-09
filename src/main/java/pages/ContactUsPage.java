package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    WebDriver driver;
    WebDriverWait wait;
    public ContactUsPage(WebDriver driver) {
            this.driver=driver;
            this.wait = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10)
            );


    }
    //locators
    private By name = By.name("name");
    private By email = By.name("email");
    private By subject = By.name("subject");
    private By message = By.id("message");
    private By uploadFile = By.name("upload_file");
    private By submitButton = By.name("submit");
    private By successMessage = By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]");
    private By homeButton = By.cssSelector("a.btn.btn-success");

    //actios
    public void enterName(String userName) {
        driver.findElement(name).sendKeys(userName);
    }
    public void enterEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }
    public void enterSubject(String userSubject) {
        driver.findElement(subject).sendKeys(userSubject);
    }
    public void enterMessage(String userMessage) {
        driver.findElement(message).sendKeys(userMessage);
    }
    public void uploadFile(String filePath) {
        driver.findElement(uploadFile).sendKeys(filePath);
    }
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();

    }
    public HomePage clickHome() {
        driver.findElement(homeButton).click();
        return new HomePage(driver);
    }
    public boolean isSuccessMessageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).isDisplayed();
    }
     public void submitWithoutEmail() {
            driver.findElement(email).clear();
            driver.findElement(submitButton).click();
        }

    public boolean isSuccessMessageVisible() {

        if (driver.findElements(successMessage).isEmpty()) {
            return false;
        }

        return driver.findElement(successMessage).isDisplayed();
    }
    }