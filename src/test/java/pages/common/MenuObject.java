package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class MenuObject {
    @FindBy(id="__APP_HEADER")
    WebElement header;
    WebDriver driver;
    Helpers helpers;

    public MenuObject(WebDriver driver){
        this.driver=driver;
        helpers = new Helpers(driver);
    }

    WebElement headerMenu(){
        PageFactory.initElements(driver,this);
        helpers.waitElementPresenceById("__APP_HEADER");
        return header;
    }

    public void clickMarketMenu(){
        headerMenu().findElement(By.id("ba-tableMarkets")).click();
    }

    public void clickSpotSubMenu(){
        helpers.hoverElementById("ba-trade");
        helpers.waitElementClickableByXpath("//div[contains(text(),'Spot')]");
        headerMenu().findElement(By.xpath("//div[contains(text(),'Spot')]")).click();
    }

    public void clickLoginButton(){
        headerMenu().findElement(By.id("toLoginPage")).click();
    }
}
