package stepdefs.common;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.common.MenuObject;
import utils.DataProperty;
import utils.DriverManager;

public class MenuStepDef {

    WebDriver driver;

    MenuObject menuObject;
    DataProperty dataProperty;
    public MenuStepDef(){
        this.driver = DriverManager.getDriver();
        dataProperty = new DataProperty();
        menuObject = new MenuObject(driver);
    }
    @When("I click navigate to Markets page")
    public void navigateToMarketsPage() {
        menuObject.clickMarketMenu();
    }

    @When("I click navigate to Spot submenu")
    public void navigateToSpotSubMenu() {
        menuObject.clickSpotSubMenu();
    }

    @When("I click login button")
    public void clickToLoginButton() {
        menuObject.clickLoginButton();
    }

}
