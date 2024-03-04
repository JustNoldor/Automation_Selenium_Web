package stepdefs.page;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.page.CoinDetailPage;
import utils.DriverManager;

public class CoinDetailPageStepDef {

    private WebDriver driver;
    private CoinDetailPage coinDetailPage;

    public CoinDetailPageStepDef(){
        this.driver = DriverManager.getDriver();
        coinDetailPage = new CoinDetailPage(driver);
    }

    @Then("I should verify coin detail page")
    public void verifyCoinDetailPage() {
        Assert.assertTrue(coinDetailPage.verifyCoinDetailPage());
    }

}
