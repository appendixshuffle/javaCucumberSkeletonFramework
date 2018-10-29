package com.company.api.frontendBDD.steps;

import com.company.api.frontendBDD.supportFactory.StepConfig;
import com.company.api.frontendBDD.webDriver.Driver;

import java.net.MalformedURLException;

public class StepsDefinitions extends StepConfig {

    public StepsDefinitions(Driver config) throws MalformedURLException {
        super(config
        );
        try {
            driver = config.getCurrentDriver();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(config.id);
        }

    }




}
