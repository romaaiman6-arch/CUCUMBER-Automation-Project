package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payAndConfirm = By.id("submit");
    private By successMessage1 = By.xpath("//*[contains(text(),'Congratulations!')]");
    private By orderPlaced = By.xpath("//b[text()='Order Placed!']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");
//ACTIOS
public void enterNameOnCard(String name) {
    driver.findElement(nameOnCard).sendKeys(name);
}

    public void enterCardNumber(String number) {
        driver.findElement(cardNumber).sendKeys(number);
    }

    public void enterCVC(String cvcNumber) {
        driver.findElement(cvc).sendKeys(cvcNumber);
    }

    public void enterExpiryMonth(String month) {
        driver.findElement(expiryMonth).sendKeys(month);
    }

    public void enterExpiryYear(String year) {
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void clickPayAndConfirm() {
        driver.findElement(payAndConfirm).click();
    }

    public boolean isOrderPlacedSuccessfully1() {
        return driver.findElement(successMessage1).isDisplayed();
    }
    public boolean isOrderPlacedSuccessfully2() {
        return driver.findElement(orderPlaced).isDisplayed();
    }

    public HomePage clickContinue() {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
    public boolean isStillOnPaymentPage() {
        return driver.getCurrentUrl().contains("/payment");
    }
}
