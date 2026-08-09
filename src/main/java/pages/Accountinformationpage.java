package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Accountinformationpage {
    WebDriver driver;
    WebDriverWait wait;
    public Accountinformationpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );}
    //locators
    private By title=By.id("id_gender1");
    private By password=By.id("password");
    private By dateofbirth = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By firstname=By.id("first_name");
    private By lastname= By.id("last_name");
    private By address = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city=By.id("city");
    private By zipcode=By.id("zipcode");
    private By mobilenumber=By.id("mobile_number");
    private By createAccount = By.cssSelector("button[data-qa='create-account']");
    private By accountCreatedMessage =
            By.cssSelector("h2[data-qa='account-created']");


    //ACTIOS
    public void selectMr(){
        driver.findElement(title).click();
    }
    public void enterPassword(String passwordtext ){
        driver.findElement(password).sendKeys(passwordtext);
    }
    public void selectDay(String dayValue) {
        new Select(driver.findElement(dateofbirth))
                .selectByVisibleText(dayValue);
    }
    public void selectMonth(String monthValue) {
        new Select(driver.findElement(months))
                .selectByVisibleText(monthValue);
    }

    public void selectYear(String yearValue) {
        new Select(driver.findElement(years))
                .selectByVisibleText(yearValue);
    }
    public void enterFirstName(String firstNameText) {
        driver.findElement(firstname).sendKeys(firstNameText);
    }
    public void enterLastName(String lastNameText) {
        driver.findElement(lastname).sendKeys(lastNameText);
    }
    public void enterAddress(String addressText) {
        driver.findElement(address).sendKeys(addressText);
    }
    public void enterState(String stateText) {
        driver.findElement(state).sendKeys(stateText);
    }

    public void enterCity(String cityText) {
        driver.findElement(city).sendKeys(cityText);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipcode).sendKeys(zip);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(mobilenumber).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccount).click();
    }
    public boolean isAccountCreatedMessageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        accountCreatedMessage
                )
        ).isDisplayed();
    }
}











