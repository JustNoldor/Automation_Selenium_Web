package stepdefs.common;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.common.CookieObject;
import utils.DriverManager;

public class CookieStepDef {
    private WebDriver driver;
    private CookieObject cookieObject;

    public CookieStepDef(){
        this.driver = DriverManager.getDriver();
        cookieObject = new CookieObject(driver);
    }

    @Given("I accept cookies")
    public void acceptToCookies() {
        cookieObject.acceptCookies();
    }
}
