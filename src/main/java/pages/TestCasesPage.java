package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    WebDriver driver;
    public TestCasesPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By testCasesButton =
            By.cssSelector("a[href='/test_cases']");

    private By testCasesTitle =
            By.xpath("//h2[contains(normalize-space(),'Test Cases')]");



    //actios
    public void TestcaseButton(){
        driver.findElement(testCasesButton).click();
    }
    public boolean isTestCasesPageDisplayed() {
        return driver.findElement(testCasesTitle).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }





}


