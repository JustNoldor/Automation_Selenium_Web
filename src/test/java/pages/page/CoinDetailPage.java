package pages.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class CoinDetailPage {

    @FindBy(id = "__APP")
    WebElement CoinDetailPage;
    WebDriver driver;
    Helpers helpers;
    public CoinDetailPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }
    WebElement CoinPage(){
        PageFactory.initElements(driver,this);
        return CoinDetailPage;
    }

    public boolean verifyCoinDetailPage() {
        helpers.waitElementPresenceByXpath("//h1[.='AVAX/USDT']");
        String coinName = CoinPage().findElement(By.xpath("//h1[.='AVAX/USDT']")).getText();
        return coinName.equals("AVAX/USDT");
    }

}
