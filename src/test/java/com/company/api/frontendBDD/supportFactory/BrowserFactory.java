package com.company.api.frontendBDD.supportFactory;

import com.company.api.frontendBDD.PropertiesFileReader;
import com.company.api.frontendBDD.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    static PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
    static Browser browser = Browser.valueOf(propertiesFileReader.getBrowser());

    public static DesiredCapabilities selectRemoteBrowser(DesiredCapabilities caps) {

        switch (browser) {
            case Chrome:
                caps.setCapability("browserName", "chrome");
                break;
            case Safari:
                caps.setCapability("browserName", "safari");
                break;
            case Firefox:
                caps.setCapability("browserName", "firefox");
                break;
            default:
                throw new WebDriverException("No browser specified");

        }
        return caps;
    }


    public static WebDriver selectLocalBrowser() {
        switch (browser) {
            case Chrome:
			    System.setProperty("webdriver.chrome.driver", "src/test/resources/binaries/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
                options.addArguments("--disable-gpu"); //[1540364989.082][SEVERE]: Timed out receiving message from renderer: 300.000 it's a Chromium open BUG : Issue 794017  on https://bugs.chromium.org
                options.addArguments("--always-authorize-plugins");
                return new ChromeDriver(options);

            case chromeHeadless:
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("--start-maximized");
                headlessOptions.addArguments("headless");
                headlessOptions.addArguments("--no-sandbox");
                headlessOptions.addArguments("--disable-gpu");
                headlessOptions.addArguments("--disable-infobars");
                headlessOptions.addArguments("--remote-debugging-port=9222");
                headlessOptions.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
                headlessOptions.addArguments("--disable-browser-side-navigation");
                headlessOptions.addArguments("--always-authorize-plugins");
                return new ChromeDriver(headlessOptions);

            case Firefox:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/binaries/geckodriver");
                return new FirefoxDriver();
            case IE:
                return new InternetExplorerDriver();
            case Opera:
                return new OperaDriver();
            case Safari:
                return new SafariDriver();
            default:
                throw new WebDriverException("No browser specified");
        }
    }


}

