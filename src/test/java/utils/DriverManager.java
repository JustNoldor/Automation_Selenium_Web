package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.HashMap;
import java.util.Map;


public class DriverManager {

    static DataProperty dataProperty;

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverManager() {
    }

    public  static WebDriver getDriver() {
        return driver.get();
    }

    @Before(order = 1)
    public static void setupDriver() {
        dataProperty = new DataProperty();
        System.out.println("BROWSER: " + dataProperty.getBrowser());
        if (driver.get() == null) {
            switch (dataProperty.getBrowser()) {
                case "chrome":
                    setupChromeDriver();
                    break;
                case "firefox":
                    setupFirefoxDriver();
                    break;
                default:
                    setupChromeDriver();
                    break;
            }
        }
    }

    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver.set(new ChromeDriver(chromeOptions));
        //getDeviceMetricsWithCDP(); //alternative
    }

    public static void setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-private");
        driver.set(new FirefoxDriver(firefoxOptions));
    }



    private static void getDeviceMetricsWithCDP() {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        Map deviceMetrics = new HashMap()
        {{
            put("width", 600);
            put("height", 1000);
            put("mobile", true);
            put("deviceScaleFactor", 50);
        }};
        ((ChromeDriver)driver.get()).executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

    }


    @After
    public void tearDown(){
        System.out.println(driver);
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }

}
