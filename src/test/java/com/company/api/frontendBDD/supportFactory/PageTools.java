package com.company.api.frontendBDD.supportFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTools {
    static WebDriver driver;

    public PageTools(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeClickable(WebElement webElement, int maxWaitTime) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, maxWaitTime);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForVisibilityOfElement(WebElement element, int maxWaitTime) {
        WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean isElementVisible(WebElement element, int maxWaitTime) {
        WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    return true;


    }







    public WebElement findElementByPriority(String priority) {

        String fullCss = null;
        String baseCss = "div.options--3hMNf > div.priority--1esqD.";
        switch (priority) {
            case "Hohe Priorität":
                fullCss = baseCss + "\"high--3y-SC\"";
                break;

            case "Mittlere Priorität":
                fullCss = baseCss + "\"medium--2_JJC\"";
                break;

            case "Niedrige Priorität":
                fullCss = baseCss + "\"low--3srzH\"";
                break;
        }


        return driver.findElement(By.cssSelector(fullCss));

    }

    public WebElement findPrioOverRoundIcon(String priority, String sectionRoundIcon) {

        String fullCss = null;
        String baseSeconPart=null;
        //String baseCss = "high--2Dn-G.point--211Qm";
        //String baseFirstClassPart = ".point--211Qm";
        switch (priority) {
            case "Hohe Priorität":
                String baseCss = ".point--211Qm.high--2Dn-G";
                if (sectionRoundIcon.equals("Betriebliche Unfall")) {
                    String baseSecondPart = "[style=\"top: 180.492px; left: -10.1702px; width: 29.6659px; height: 29.6659px;\"]";

                } if (sectionRoundIcon.equals("Betriebliche Altersversorgung")) {
                String baseSecondPart = "[style=\"top: 93.0155px; left: 26.0638px; width: 29.6659px; height: 29.6659px;\"]";

            } if (sectionRoundIcon.equals("Betriebliche Kranken")) {
                String baseSecondPart = "[style=\"top: 26.0638px; left: 93.0155px; width: 29.6659px; height: 29.6659px;\"]";
            }

                fullCss = baseCss + baseSeconPart;
                break;

            case "Mittlere Priorität":
                baseCss = ".point--211Qm.medium--31O48";
                if (sectionRoundIcon.equals("Betriebliche Unfall")) {
                    String baseSecondPart = "[style=\"top: 180.492px; left: -10.1702px; width: 29.6659px; height: 29.6659px;\"]";

                } if (sectionRoundIcon.equals("Betriebliche Altersversorgung")) {
                String baseSecondPart = "[style=\"top: 93.0155px; left: 26.0638px; width: 29.6659px; height: 29.6659px;\"]";

            } if (sectionRoundIcon.equals("Betriebliche Kranken")) {
                String baseSecondPart = "[style=\"top: 26.0638px; left: 93.0155px; width: 29.6659px; height: 29.6659px;\"]";
            }


                fullCss = baseCss + baseSeconPart;
                break;

            case "Niedrige Priorität":
                baseCss = ".point--211Qm.low--31O48";
                if (sectionRoundIcon.equals("Betriebliche Unfall")) {
                    String baseSecondPart = "[style=\"top: 180.492px; left: -10.1702px; width: 29.6659px; height: 29.6659px;\"]";

                } if (sectionRoundIcon.equals("Betriebliche Altersversorgung")) {
                String baseSecondPart = "[style=\"top: 93.0155px; left: 26.0638px; width: 29.6659px; height: 29.6659px;\"]";

            } if (sectionRoundIcon.equals("Betriebliche Kranken")) {
                String baseSecondPart = "[style=\"top: 26.0638px; left: 93.0155px; width: 29.6659px; height: 29.6659px;\"]";
            }

                fullCss = baseCss + baseSeconPart;
                break;
        }


        return driver.findElement(By.cssSelector(fullCss));
    }


    //POLIGON

//    public WebElement matchGherkinArgumentsToWebElements(String argValue){
//        String locatorPath = null;
//        switch(argValue){
//            case "Jahresumsatz":
//                locatorPath = "somePath";
//
//        }
//        WebElement foundedElement = driver.findElement(By.cssSelector(locatorPath));
//
//
//      return  foundedElement;
//    }


}
