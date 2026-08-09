package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdownpage {
    WebDriver driver;
    Select select;
    public Dropdownpage(WebDriver driver){
        this.driver=driver;
    }
    //locators
    private By Dropdownlist =By.linkText("dropdown");


    //actios
    public void selectvisibletext(String text){
        WebElement list =driver.findElement(Dropdownlist);
        select=new Select(list);
        select.deselectByVisibleText(text);

    }



}