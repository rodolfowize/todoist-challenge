package com.wizeline.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePage {
    protected WebDriver webDriver;

    @Autowired
    public BasePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

}
