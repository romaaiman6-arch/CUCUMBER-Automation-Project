package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver=driver;

    }
    //locators
    private By deliveryAddress =By.id("address_delivery");
    private By billingAddress =By.id("address_invoice");
    private By placeOrder =By.linkText("Place Order");

    //ACTIOS
    public boolean isDeliveryAddressDisplayed() {
        return driver.findElement(deliveryAddress).isDisplayed();
    }

    public boolean isBillingAddressDisplayed() {
        return driver.findElement(billingAddress).isDisplayed();
    }
    public PaymentPage clickPlaceOrder() {
        driver.findElement(placeOrder).click();
        return new PaymentPage(driver);





}}
