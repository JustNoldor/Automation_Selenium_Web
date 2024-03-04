package pages.page;

import org.openqa.selenium.WebDriver;
import utils.DataProperty;
import utils.Helpers;

public class HomePageObject {
    WebDriver driver;
    Helpers helpers;

    DataProperty dataProperty;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
        dataProperty = new DataProperty();
    }
    public void openHost() {
        driver.get("http://" + dataProperty.getEnvironment() + dataProperty.getHost());
    }


}
