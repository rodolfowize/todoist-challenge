package com.wizeline.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverActions{

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriverWait webDriverWait;

    public  void navigateTo(String url){
        webDriver.get(url);
    }

    public void waitForElementToBeVisible(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
