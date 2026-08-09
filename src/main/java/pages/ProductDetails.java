package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetails {
    WebDriver driver;
    public ProductDetails(WebDriver driver) {
        this.driver=driver;
    }

   //locatos
   private By productName =
           By.cssSelector(".product-information h2");

    private By productPrice =
            By.cssSelector(".product-information span span");
    private By searchInput =
            By.id("search_product");

    private By searchButton =
            By.id("submit_search");
    private By searchResults =
            By.cssSelector(".features_items .product-image-wrapper");
    private By viewCartButton =
            By.cssSelector("#cartModal a[href='/view_cart']");





    //actios
     public boolean isProductDetailsDisplayed() {
         return driver.findElement(productName).isDisplayed()
                 && driver.findElement(productPrice).isDisplayed();

     }

    public String getProductName() {
        return driver.findElement(productName).getText().trim();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText().trim();
    }



}
