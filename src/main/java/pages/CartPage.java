package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }
    //locators
    private By proceedcheckout =By.cssSelector("a.check_out");
    private By emptyCartMessage =
            By.xpath("//*[contains(normalize-space(),'Cart is empty!')]");

    private By proceedToCheckoutButton =
            By.xpath("//a[contains(@class,'check_out')]");
    private By loginRequiredMessage =
            By.xpath(
                    "//div[@id='checkoutModal']" +
                            "//p[contains(normalize-space()," +
                            "'Register / Login account to proceed on checkout')]"
            );


    //ACTIONS
    public CheckOutPage clickprocescheckout(){
        driver.findElement(proceedcheckout).click();
        return new CheckOutPage(driver);
    }
    public boolean isCartEmpty() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)
        ).isDisplayed();
    }

    public String getEmptyCartMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)
        ).getText().trim();
    }

    public boolean isProceedToCheckoutDisplayed() {
        return !driver.findElements(proceedToCheckoutButton).isEmpty();
    }
    public boolean isLoginRequiredMessageDisplayed() {
        return driver.findElement(loginRequiredMessage).isDisplayed();
    }




}

