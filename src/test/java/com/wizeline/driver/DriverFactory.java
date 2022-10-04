package com.wizeline.driver;

import com.wizeline.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

    @Value("${grid.url}")
    private String gridUrl;

    public WebDriver get(Browser browser, Environment environment) {

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

}
