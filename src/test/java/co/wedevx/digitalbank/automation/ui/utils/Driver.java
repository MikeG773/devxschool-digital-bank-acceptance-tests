package co.wedevx.digitalbank.automation.ui.utils;

import io.cucumber.java.Scenario;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
//import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {

    }

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigReader.getPropertiesValue("digitalbank.browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
//                   System.setProperty("webdriver.chrome.driver", "/Users/mikeguerrero/Downloads/chromedriver-mac-x64/chromedriver");
                   //System.setProperty("webdriver.chrome.driver", "/Users/mikeguerrero/Downloads/chromedriver-mac-x64");
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "headless":
                    ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    //  WebDriverManager.chromedriver().setup(); //either or work ^
                    ChromeOptions options = new ChromeOptions();

                    //      FirefoxOptions options2 = new FirefoxOptions();
                    //     options2.setHeadless(true);


                    options.addArguments("--window-size=1920,1000");
                    options.addArguments("disable-extensions");
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--proxy-server='direct://'");
                    options.addArguments("--proxy-bypass-list=*");
                    options.addArguments("--start-maximized");
                    options.addArguments("--headless");

                  //just comment out  System.setProperty("webdriver.chrome.driver", "/Users/mikeguerrero/Downloads/chromedriver-mac-x64/chromedriver");

                    driver = new ChromeDriver(options);

                    //    System.setProperty("webdriver.gecko.driver", "/Users/mikeguerrero/Downloads/geckodriver 5");
                    //   driver = new FirefoxDriver(options2);
                    break;

                case "firefox":
                default:
                    WebDriverManager.firefoxdriver().setup();
                    System.setProperty("webdriver.gecko.driver", "/Users/mikeguerrero/Downloads/geckodriver 5");
                    driver = new FirefoxDriver();
                    break;
            }

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            //taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            //adding the screenshot to the report
            scenario.attach(screenshot, "image/png", "screenshot");

        }
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
