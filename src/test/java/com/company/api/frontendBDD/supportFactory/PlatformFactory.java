package com.company.api.frontendBDD.supportFactory;

import com.company.api.frontendBDD.PropertiesFileReader;
import com.company.api.frontendBDD.enums.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformFactory {
    static PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
    static Platform platform = Platform.valueOf(propertiesFileReader.getPlatform());

    public static DesiredCapabilities selectPlatform(DesiredCapabilities caps) {

        switch (platform) {
            case OSX:
                caps.setCapability("os", "OSX");
                caps.setPlatform(org.openqa.selenium.Platform.MAC);
                break;
            case Windows:
                caps.setCapability("os", "Windows");
                caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
                break;
            default:
                throw new WebDriverException("No platform specified");
        }

        return caps;
    }



}
