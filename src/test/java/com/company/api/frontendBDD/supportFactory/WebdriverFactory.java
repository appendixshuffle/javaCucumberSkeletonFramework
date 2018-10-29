package com.company.api.frontendBDD.supportFactory;

import com.company.api.frontendBDD.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebdriverFactory {

//    private static class BrowserCleanup implements Runnable {
//        public void run() {
//            System.out.println("Cleaning up the browser");
//            try {
//                Driver.webdriver.quit();
//            } catch (NullPointerException e) {
//                System.out.println("Browser already shut down.");
//            }
//        }
//    }
static PropertiesFileReader propertiesFileReader = new PropertiesFileReader();

    public static WebDriver createWebdriver() throws MalformedURLException {
        caps = new DesiredCapabilities();
        String seleniumHub = "http://localhost:4444/wd/hub";
        String seleniumEnvironment = propertiesFileReader.getSeleniumEnvironment();
        System.out.println("chosen selenium environment is " +seleniumEnvironment);

        if (seleniumEnvironment.equals("local")) {
//            Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            return BrowserFactory.selectLocalBrowser();
        }else {
            if (seleniumEnvironment.equals("grid")) {
                PlatformFactory.selectPlatform(caps);
                BrowserFactory.selectRemoteBrowser(caps);
                return new RemoteWebDriver(new URL(seleniumHub), caps);
            }
        }
        return null;
    }

    private static DesiredCapabilities caps;

}

