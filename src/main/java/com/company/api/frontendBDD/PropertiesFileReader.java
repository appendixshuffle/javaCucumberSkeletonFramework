package com.company.api.frontendBDD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    private Properties properties;
    private final String propertyFilePath= "src/main/resources/properties/conf.properties";

    public PropertiesFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Conf.properties not found at " + propertyFilePath);
        }
    }


    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser!= null) return browser;
        else throw new RuntimeException("browser not specified in the conf.properties file.");
    }

    public String getPlatform(){
        String platform = properties.getProperty("platform");
        if(platform!= null) return platform;
        else throw new RuntimeException("platform not specified in the conf.properties file.");
    }
    public String getSeleniumEnvironment(){
        String seleniumEnvironment = properties.getProperty("seleniumEnvironment");
        if(seleniumEnvironment!= null) return seleniumEnvironment;
        else throw new RuntimeException("seleniumEnvironment not specified in the conf.properties file.");
    }

    public String getTestingEnvironment(){
        String testingEnvironment = properties.getProperty("testingEnvironment");
        if(testingEnvironment!= null) return testingEnvironment;
        else throw new RuntimeException("testingEnvironment not specified in the conf.properties file.");
    }


}
