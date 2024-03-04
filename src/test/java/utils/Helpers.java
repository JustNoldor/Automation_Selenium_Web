package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Helpers {

    Duration duration= Duration.ofSeconds(10);
    private WebDriver driver;
    Actions actions;
    public Helpers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions (driver);
    }

    public void waitElementPresenceById(String locator){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }
    public void waitElementPresenceByXpath(String locator){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitElementPresenceBySelector(String locator){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }
    public void waitNewTabs(int windowsNumber){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(numberOfWindowsToBe(windowsNumber));
    }
    public void switchOpenedTab( ){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void hoverElementById(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
        WebElement element = driver.findElement(By.id(locator));
        actions.moveToElement(element).moveToElement(element).click().build().perform();
    }

    public void waitElementClickableByXpath(String locatorElement){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorElement)));
    }

    public void waitElementClickableById(String locatorElement){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorElement)));
    }

    public void scrollUntilView(WebElement locatorElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locatorElement);
    }

}
