package stepdefs.page;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.page.HomePageObject;
import utils.DriverManager;

public class HomePageStepDef {
    private WebDriver driver;

    private HomePageObject homePageObject;
    public HomePageStepDef(){
        this.driver = DriverManager.getDriver();
        homePageObject = new HomePageObject(driver);
    }

    @Given("I'm on the homepage")
    public void goToTheLoginPage() {
        homePageObject.openHost();
    }



}
