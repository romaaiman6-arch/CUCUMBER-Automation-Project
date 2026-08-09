package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstProduct =
            By.cssSelector(".product-image-wrapper");

    private By firstAddToCart =
            By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    private By viewCart =
            By.xpath("//u[text()='View Cart']");

    private By addedMessage =
            By.xpath("//h4[text()='Added!']");

    private By firstViewProductButton =
            By.cssSelector("a[href='/product_details/1']");

    private By searchInput =
            By.id("search_product");

    private By searchButton =
            By.id("submit_search");

    private By searchResults =
            By.cssSelector(".features_items .product-image-wrapper");

    // Actions
    public void hoverOnFirstProduct() {

        Actions actions = new Actions(driver);

        WebElement product =
                driver.findElement(firstProduct);

        actions.moveToElement(product).perform();
    }

    public void clickAddToCart() {
        driver.findElement(firstAddToCart).click();
    }

    public CartPage clickViewCart() {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        wait.until(
                ExpectedConditions.elementToBeClickable(viewCart)
        ).click();

        return new CartPage(driver);
    }

    public boolean isAddedMessageDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        addedMessage
                )
        );

        return message.isDisplayed();
    }

    public ProductDetails openFirstProduct() {

        driver.findElement(
                firstViewProductButton
        ).click();

        return new ProductDetails(driver);
    }

    public void enterSearchText(String searchText) {
        driver.findElement(searchInput).sendKeys(searchText);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void searchForProduct(String searchText) {
        enterSearchText(searchText);
        clickSearchButton();
    }

    public int getSearchResultsCount() {
        return driver.findElements(searchResults).size();
    }
    }
