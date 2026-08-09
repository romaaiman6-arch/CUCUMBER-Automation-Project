package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

   //locators
    private By formAuthentationlink =By.linkText("Form Authentication");
    private By dynamicloading = By.linkText("Dynamic Loading");
    private By clickdropdown= By.linkText("Dropdown");
    private By signupLoginButton =
            By.cssSelector("a[href='/login']");

    private By loggedInUser =
            By.xpath("//a[contains(normalize-space(.),'Logged in as')]");
    private By productsButton =
            By.cssSelector("a[href='/products']");
    private By cartButton = By.linkText("Cart");
    private By contactUsButton = By.linkText("Contact us");
    private By logoutButton =
            By.xpath("//a[contains(normalize-space(.),'Logout')]");


   //actions

   public LoginPage clickformAuthenticationlink(){
       driver.findElement(formAuthentationlink).click();
       return new LoginPage(driver);
   }

   public DynamicLoadingPage clickdynamicloading(){
       driver.findElement(dynamicloading).click();
       return new DynamicLoadingPage(driver);


   }

public Dropdownpage clickdropdown(){
        driver.findElement(clickdropdown).click();
        return new Dropdownpage(driver);
}
    public LoginPage clicksignlogin() {
        driver.findElement(signupLoginButton).click();
        return new LoginPage(driver);
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(loggedInUser).isDisplayed();
    }

    public String getLoggedInText() {
        return driver.findElement(loggedInUser)
                .getText()
                .trim();
    }
    public ProductPage clickproducts() {
        driver.findElement(productsButton).click();
        return new ProductPage(driver);
    }

    public CartPage clickcart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public ContactUsPage clickcontactus() {
        driver.findElement(contactUsButton).click();
        return new ContactUsPage(driver);
    }

    public LoginPage clickLogout() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }
}
