package com.wizeline.driver;

import org.openqa.selenium.chrome.ChromeOptions;

public class DriverOptions {

    static ChromeOptions setChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }
}
