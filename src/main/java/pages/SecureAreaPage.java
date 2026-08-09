package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    WebDriver driver;
    public SecureAreaPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By sucessmessage = By.id("flash");

    //ACTIONS
    public String getSucessmessage(){
      return driver.findElement(sucessmessage).getText();
    }


}
