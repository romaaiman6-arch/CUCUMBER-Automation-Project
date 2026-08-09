package cucmbersteps;

import org.openqa.selenium.WebDriver;
import pages.Accountinformationpage;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductDetails;
import pages.ProductPage;
import pages.SignUpPage;
import pages.TestCasesPage;

public final class CucumberTestContext {
    public static WebDriver driver;
    public static HomePage homePage;
    public static ProductPage productPage;
    public static ProductDetails productDetails;
    public static CartPage cartPage;
    public static CheckOutPage checkoutPage;
    public static PaymentPage paymentPage;
    public static ContactUsPage contactUsPage;
    public static SignUpPage signUpPage;
    public static Accountinformationpage accountInformationPage;
    public static TestCasesPage testCasesPage;

    private CucumberTestContext() {
    }

    public static void resetPages() {
        homePage = null;
        productPage = null;
        productDetails = null;
        cartPage = null;
        checkoutPage = null;
        paymentPage = null;
        contactUsPage = null;
        signUpPage = null;
        accountInformationPage = null;
        testCasesPage = null;
    }
}
