package com.company.api.frontendBDD.webDriver;

import com.company.api.frontendBDD.supportFactory.WebdriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


public class Driver {

    public String id = "0";
    private StringBuffer verificationErrors = new StringBuffer();



    public static WebDriver webdriver;

    @BeforeClass
    public synchronized WebDriver getCurrentDriver() throws MalformedURLException {

        if (webdriver == null) {
            webdriver = WebdriverFactory.createWebdriver();
            //for Demo purpose - it's keeping webbrowser window on top
            assert webdriver != null;
            String window = webdriver.getWindowHandle();
            ArrayList<String> tabs2 = new ArrayList<>(webdriver.getWindowHandles());
                    ((JavascriptExecutor) webdriver).executeScript("alert('Test')");
                    webdriver.switchTo().alert().accept();
                    webdriver.switchTo().window(window);
        }
        prepareDriver();
        return webdriver;
    }

    private void prepareDriver() {
        webdriver.manage().deleteAllCookies();
//        webdriver.manage().window().maximize();  //its bugged after Chrome 70.xx version was released. Issue 868599 on https://bugs.chromium.org
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After



    public void tearDown(Scenario scenario) throws AssertionError {

        System.out.println("======================================= @After Cucumber Test  =======================================");
        String status;
        if (!scenario.isFailed() ) {
            status = "( ͡° ͜ʖ ͡°)"+"Scenario passed";
            scenario.write("Scenario passed");
            if (webdriver != null){
//                webdriver.close();
                webdriver.quit();
                webdriver = null;


            }
        } else {
            status = "(✖╭╮✖)"+"Scenario failed";
            try {
                File scrFile = getScreenShotFile(scenario);
                byte[] data = FileUtils.readFileToByteArray(scrFile);
                scenario.embed(data, "image/png");
                scenario.write("URL at failure: " + webdriver.getCurrentUrl());
            } catch (WebDriverException wde) {
                scenario.write("Embed Failed " + wde.getMessage());
            } catch (ClassCastException | IOException cce) {
                cce.printStackTrace();
            }
            scenario.write("Scenario failed");
            if(webdriver != null){
//                webdriver.close();
                webdriver.quit();
                webdriver = null;

            }
        }
        System.out.println("\n" + status + " End of: " + scenario.getName() + " scenario.");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);

        }


    }
    private File getScreenShotFile(Scenario s) throws IOException {
        String scenarioNme = s.getName();
        File scr = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
        String sysDate = new SimpleDateFormat( "yyyyMMddhhmmss'.txt'").format(new Date());
        String filename =  scenarioNme+"_"+sysDate;
        File dest = new File("reports/screenshots/" + filename);
        FileUtils.copyFile(scr, dest);
        return scr;
    }




}
