package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.Helpers;

public class CookieObject {

    @FindBy(id = "onetrust-button-group")
    WebElement cookie;
    WebDriver driver;
    Helpers helpers;
    public CookieObject(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    private WebElement cookieForm(){
        PageFactory.initElements(DriverManager.getDriver(), this);
        helpers.waitElementPresenceById("onetrust-button-group");
        return cookie;
    }
    public void acceptCookies() {
        helpers.waitElementClickableById("onetrust-accept-btn-handler");
        cookieForm().findElement(By.id("onetrust-accept-btn-handler")).click();
    }
}
