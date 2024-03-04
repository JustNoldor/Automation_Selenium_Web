package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.Helpers;
import java.util.*;

public class FooterObject {
    @FindBy(id = "__APP_FOOTER")
    WebElement footer;
    WebDriver driver;
    Helpers helpers;
    private int openedLinksCount = 0;

    public FooterObject(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    private WebElement footerMenu() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        helpers.waitElementPresenceById("__APP_FOOTER");
        return footer;
    }
    public void clickRandomlyFooterLinks() {
        helpers.scrollUntilView(footerMenu());
        clickFooterLinks();
    }

    public String getOpenedLinksCount() {
        return String.valueOf(openedLinksCount);
    }

    public void clickFooterLinks(){
        Random random = new Random();
        List<String> hrefList = new ArrayList<>();
        List<String> idList = new ArrayList<>();
        iterateObjectAttributesToList(idList,hrefList);
        for (int i = 0; i < 5 ; i++) {
                int index = random.nextInt(idList.size());
                footerMenu().findElement(By.id(idList.get(index))).click();
                openedLinksCount++;
                idList.remove(index);
                removeHrefs(hrefList);
                driver.navigate().back();
        }
    }

    public void removeHrefs(List hrefList){
        String url = driver.getCurrentUrl();
        if (hrefList.contains(url))
        {
            hrefList.remove(url);
        }
    }

    public void iterateObjectAttributesToList(List idList, List hrefList){

        List<WebElement> links = footerMenu().findElements(By.xpath("//div[@class='footer-navlist-group'][1]//a[@href]"));
        for (WebElement link : links) {
            idList.add(link.getAttribute("id"));
            hrefList.add(link.getAttribute("href"));
        }
    }

}
