package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnePage {
    WebDriver driver;
    WebDriverWait wait;

    public OnePage(WebDriver driver) {
        this.driver=driver;
    }
    // locators
    private By startbuttom = By.xpath("//button[contains(text(),'start')]");
    private By valiedmessage = By.xpath("//button[contains(text(),'Hello World!')]");


    //acions
    public void clickstartbuttom(){
        driver.findElement(startbuttom).click();
    }

public String getvaledmeesage(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(valiedmessage)));
        return driver.findElement(valiedmessage).getText();
}





}
