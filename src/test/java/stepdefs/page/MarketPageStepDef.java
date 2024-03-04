package stepdefs.page;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.page.MarketPageObject;
import utils.DriverManager;

public class MarketPageStepDef {
    private MarketPageObject marketpageObject;
    private WebDriver driver;
    public MarketPageStepDef(){
        this.driver = DriverManager.getDriver();
        marketpageObject =  new MarketPageObject(driver);
    }

    @When("I select spot market section")
    public void selectSpotMarketSection() {
        marketpageObject.selectSpotMarket();
    }

    @When("I click coin")
    public void clickCoin() {
        marketpageObject.selectCoin();
    }
}
