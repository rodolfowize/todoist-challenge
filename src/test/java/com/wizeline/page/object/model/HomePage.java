package com.wizeline.page.object.model;

import com.wizeline.driver.DriverActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage{

    @Autowired
    public HomePage(WebDriver webDriver){super(webDriver);}
    @Autowired
    DriverActions driverActions;
    @FindBy( css = ".Y5eL4cjJHcHaCQ8EbL7V[href='/auth/login']")
    private WebElement loginLink;

    @Step("Click on Login link")
    public void clickOnLoginLink(){
        driverActions.waitForElementToBeVisible(loginLink);
        loginLink.click();
    }

}
