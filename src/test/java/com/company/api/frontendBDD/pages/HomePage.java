package com.company.api.frontendBDD.pages;

import com.company.api.frontendBDD.supportFactory.PageTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageTools {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }






}
