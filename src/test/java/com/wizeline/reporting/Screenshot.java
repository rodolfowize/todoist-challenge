package com.wizeline.reporting;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Screenshot {
    private  WebDriver webDriver;

    @Autowired
    public Screenshot(WebDriver webDriver){
        this.webDriver = webDriver;
    }
        @Attachment(value = "{testName}", type = "image/png")
        public   byte[] makeScreenshotOnFailure(String testName) {
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }
}
