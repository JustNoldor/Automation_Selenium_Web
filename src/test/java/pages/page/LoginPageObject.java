package pages.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class LoginPageObject {

    @FindBy(css = "form")
    WebElement Login;
    WebDriver driver;
    Helpers helpers;
    public LoginPageObject(WebDriver driver){
        this.driver=driver;
        helpers = new Helpers(driver);
    }

    WebElement LoginForm(){
        PageFactory.initElements(driver,this);
        return Login;
    }

    public void loginInvalidCredentials(){
        LoginForm().findElement(By.id("username")).sendKeys("mostwrongestemailintheworld12@mail.com");
        LoginForm().findElement(By.id("click_login_submit_v2")).click();
    }

    public String getLoginErrorText(){
        helpers.waitElementPresenceBySelector(".help_error");
        return LoginForm().findElement(By.cssSelector(".help_error")).getText();
    }
}
