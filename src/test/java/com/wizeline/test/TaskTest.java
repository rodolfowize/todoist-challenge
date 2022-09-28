package com.wizeline.test;

import com.wizeline.page.object.model.HomePage;
import com.wizeline.page.object.model.LoginPage;
import com.wizeline.page.object.model.TodayPage;
import com.wizeline.utils.RandomUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Feature("Task tests")
public class TaskTest extends BaseTest{

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private TodayPage todayPage;

    @Test
    @Description("Test Description: Creates a new task and validates that its name and description is displayed in the page")
    public void createNewTaskTest(){
        driverActions.navigateTo(todoistUrl);
        homePage.clickOnLoginLink();
        loginPage.doLogin(username, password);
        driverActions.waitForElementToBeVisible(todayPage.getAddTaskButton());
        todayPage.clickOnAddTaskButton();
        String taskName = RandomUtils.generateRandomString(10);
        String taskDescription = RandomUtils.generateRandomString(80);
        todayPage.addNewTask(taskName, taskDescription);
        Assert.assertEquals(taskName, todayPage.getNewTaskName().getText());
        Assert.assertEquals(taskDescription, todayPage.getNewTaskDescription().getText());

    }

    @Test
    @Description("Test Description: Creates 10 new tasks and validates that their names and descriptions are displayed in the page")
    public void create10NewTasks(){
        driverActions.navigateTo(todoistUrl);
        homePage.clickOnLoginLink();
        loginPage.doLogin(username, password);
        driverActions.waitForElementToBeVisible(todayPage.getAddTaskButton());
        todayPage.clickOnAddTaskButton();
        int counter = 0;
        while(counter < 10){
            counter++;
            String taskName = RandomUtils.generateRandomString(10);
            String taskDescription = RandomUtils.generateRandomString(80);
            todayPage.addNewTask(taskName, taskDescription);
            Assert.assertEquals(taskName, todayPage.getNewTaskName().getText());
            Assert.assertEquals(taskDescription, todayPage.getNewTaskDescription().getText());
        }
    }
}
