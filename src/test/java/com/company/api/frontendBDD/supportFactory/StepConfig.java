package com.company.api.frontendBDD.supportFactory;

import com.company.api.frontendBDD.webDriver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class StepConfig {
    public WebDriver driver;



    public StepConfig(Driver config) throws MalformedURLException {
        this.driver = config.getCurrentDriver();

    }

    protected void waitForElementToBeClickable(WebElement webElement, int maxWaitTime) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, maxWaitTime);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));

    }

    protected void waitForVisibilityOfElement(WebElement element, int maxWaitTime) {
        WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForInvisibilityOfElement(WebElement element, int maxWaitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public static boolean isInvisible(final WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (StaleElementReferenceException | java.util.NoSuchElementException ignored) {
            // We can assume a stale element isn't displayed.
            return true;
        }
    }


    public void waitForInvis(By locator , int maxWaitTime) {
        WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    public WebElement waitForElementToBeRefreshedAndClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(by)));
    }

    public String getTextFromWebElement(WebElement element) {
        return element.getText();
    }


    protected boolean isElementPresent(WebElement element){
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        try{
            element.isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }




}
