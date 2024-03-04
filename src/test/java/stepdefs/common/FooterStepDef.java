package stepdefs.common;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.common.FooterObject;
import utils.DataProperty;
import utils.DriverManager;

public class FooterStepDef {
    private WebDriver driver;
    private FooterObject footerObject;

    private DataProperty dataProperty;

    public FooterStepDef(){
        this.driver = DriverManager.getDriver();
        footerObject = new FooterObject(driver);
        dataProperty = new DataProperty();
    }

    @When("I click randomly footer links")
    public void clickToFooterLinks(){
        footerObject.clickRandomlyFooterLinks();
    }

    @Then("I should see they open properly")
    public void verifyOpenFooterLinks() {
        Assert.assertEquals(dataProperty.getTotalLinksCount(),footerObject.getOpenedLinksCount());
    }

}
