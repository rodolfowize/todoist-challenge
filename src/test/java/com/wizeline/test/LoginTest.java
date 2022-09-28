package com.wizeline.test;

import com.wizeline.page.object.model.HomePage;
import com.wizeline.page.object.model.LoginPage;
import com.wizeline.page.object.model.TodayPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Feature("Login Tests")
public class LoginTest extends BaseTest{

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private TodayPage todayPage;

    @Test
    @Description("Test Description: Validates user can successfully login")
    public void successfulLoginTest() {
        driverActions.navigateTo(todoistUrl);
        homePage.clickOnLoginLink();
        loginPage.doLogin(username, password);
        driverActions.waitForElementToBeVisible(todayPage.getAddTaskButton());
        Assert.assertEquals("Add task" , todayPage.getAddTaskButton().getText());
    }

    @Test
    @Description("Test Description: Login fails when a non-existent username is used")
    public void nonExistentUsernameLoginTest(){
        driverActions.navigateTo(todoistUrl);
        homePage.clickOnLoginLink();
        loginPage.doLogin("invalidUser@g.com", password);
        driverActions.waitForElementToBeVisible(loginPage.getWrongUserNamePasswordMsg());
        Assert.assertEquals("Wrong email or password.", loginPage.getWrongUserNamePasswordMsg().getText());
    }

    @Test
    @Description("Test Description: Login fails when no username is entered")
    public void noUsernameLoginTest(){
        driverActions.navigateTo(todoistUrl);
        homePage.clickOnLoginLink();
        loginPage.doLogin("", password);
        driverActions.waitForElementToBeVisible(loginPage.getInvalidEmailMsg());
        Assert.assertEquals("Please enter a valid email address.", loginPage.getInvalidEmailMsg().getText());
    }

    @Test
    @Description("Test Description: Login fails when a wrong password is provided")
    public void wrongPasswordLoginTest(){
        driverActions.navigateTo(todoistUrl);
        homePage.clickOnLoginLink();
        loginPage.doLogin(username, "password");
        driverActions.waitForElementToBeVisible(loginPage.getWrongUserNamePasswordMsg());
        Assert.assertEquals("Wrong email or password.", loginPage.getWrongUserNamePasswordMsg().getText());
    }

    @Test
    @Description("Test Description: Login fails when no password is entered")
    public void noPasswordLoginTest(){
        driverActions.navigateTo(todoistUrl);
        homePage.clickOnLoginLink();
        loginPage.doLogin(username, "");
        driverActions.waitForElementToBeVisible(loginPage.getInvalidPasswordMsg());
        Assert.assertEquals("Passwords must be at least 8 characters long.", loginPage.getInvalidPasswordMsg().getText());
    }

}
