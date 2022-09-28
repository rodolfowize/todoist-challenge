package com.wizeline.driver;

import com.wizeline.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class DriverFactory {

    @Value("${grid.url}")
    private String gridUrl;
    @Value("${remote.execution}")
    private boolean isRemoteExecution;

    public WebDriver get(Browser browser, Environment environment) {
        if(isRemoteExecution){
            RemoteWebDriver remoteWebDriver = getRemoteWebDriver(browser);
            remoteWebDriver.manage().window().maximize();
            return remoteWebDriver;
        }
        System.out.println();
        switch (browser){
            case CHROME: {
                System.setProperty("webdriver.chrome.driver", environment.getProperty("chrome.driver"));
                ChromeDriver chromeDriver = new ChromeDriver(DriverOptions.setChromeOptions());
                chromeDriver.manage().window().maximize();
                return chromeDriver;
            }
            case SAFARI : {
                SafariDriver safariDriver = new SafariDriver();
                safariDriver.manage().window().maximize();
                return safariDriver;
            }
            default: throw new IllegalArgumentException("Browser not supported");

        }
    }

    private RemoteWebDriver getRemoteWebDriver(Browser browser) {
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.BROWSER_NAME,browser.name().toLowerCase());
            switch (browser){
                case CHROME: {
                    ChromeOptions options = new ChromeOptions();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    break;
                }
            }
            return new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
        }catch (MalformedURLException mu){
            System.err.println("Malformed Exception thrown at Remote Web Driver creation:  " + mu.getStackTrace());
        }
        return null;
    }

}
