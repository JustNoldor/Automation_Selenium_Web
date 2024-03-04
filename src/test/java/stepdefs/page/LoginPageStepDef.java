package stepdefs.page;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.page.LoginPageObject;
import utils.DataProperty;
import utils.DriverManager;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPageObject loginpageObject;

    DataProperty dataProperty;
    public LoginPageStepDef(){
        this.driver = DriverManager.getDriver();
        dataProperty = new DataProperty();
        loginpageObject = new LoginPageObject(driver);
    }

    @When("I login invalid credentials")
    public void loginInvalidCredentials() {
        loginpageObject.loginInvalidCredentials();
    }

    @When("I should verify login error message")
    public void verifyErrorMessage() {
        Assert.assertEquals(dataProperty.getLoginErrorMessage(),loginpageObject.getLoginErrorText());
    }
}
