package pages.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class MarketPageObject {

    @FindBy(id = "__APP")
    WebElement marketPageBody;
    WebDriver driver;
    Helpers helpers;
    public MarketPageObject(WebDriver driver){
        this.driver=driver;
        helpers = new Helpers(driver);
    }

    WebElement marketPage(){
        PageFactory.initElements(driver,this);
        helpers.waitElementPresenceById("__APP");
        return marketPageBody;
    }

    public void selectSpotMarket(){
        marketPage().findElement(By.id("market_sector_Spot/Margin Market")).click();
    }

    public void selectCoin(){
        WebElement coin = marketPage().findElement(By.xpath("//div[.='AVAX']"));
        helpers.scrollUntilView(coin);
        helpers.waitElementPresenceByXpath("//div[.='AVAX']");
        coin.click();
        helpers.waitNewTabs(2);
        helpers.switchOpenedTab();
    }
}
