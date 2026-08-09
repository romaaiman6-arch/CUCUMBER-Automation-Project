package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    WebDriver driver;
    public DynamicLoadingPage(WebDriver driver) {
        this.driver=driver;
    }
//locators
    private By examlelink =By.partialLinkText("Example 1");



    //action
    public OnePage clickexample1link(){
        driver.findElement(examlelink).click();
        return new  OnePage(driver);
    }







}
