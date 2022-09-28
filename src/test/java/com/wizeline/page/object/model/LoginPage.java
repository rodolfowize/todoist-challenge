package com.wizeline.page.object.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage{

    @Autowired
    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(id ="element-0")
    private WebElement usernameInput;
    @FindBy(id = "element-3")
    private WebElement passwordInput;
    @FindBy(css = "[data-gtm-id='start-email-login']")
    private WebElement loginButton;
    @FindBy(css = "[class='a83bd4e0 _266d6623 _8f5b5f2b f9408a0e']")
    private WebElement wrongUserNamePasswordMsg;
    @FindBy(id ="element-2")
    private WebElement invalidEmailMsg;
    @FindBy(css = "[class='a83bd4e0 a8d37c6e _8f5b5f2b f9408a0e']")
    private WebElement invalidPasswordMsg;

    private void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    private void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    private void clickOnLoginButton(){
        loginButton.click();
    }

    public WebElement getInvalidEmailMsg(){return invalidEmailMsg;}
    public WebElement getWrongUserNamePasswordMsg(){ return wrongUserNamePasswordMsg;}

    public WebElement getInvalidPasswordMsg(){return invalidPasswordMsg;}

    @Step("Login to the application")
    public void doLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
}
