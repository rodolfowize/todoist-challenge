package com.wizeline.page.object.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodayPage extends BasePage{

    @Autowired
    public TodayPage(WebDriver driver){ super(driver);}

    @FindBy(css = "button[class='plus_add_button']")
    private WebElement addTaskButton;
    @FindBy(css = "[class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
    private WebElement taskNameInput;
    @FindBy(css = "[class='task_editor__description_field no-focus-marker']")
    private WebElement taskDescriptionInput;
    @FindBy(css = "button[data-testid='task-editor-submit-button']")
    private WebElement submitTaskButton;
    @FindBy(css = "[class='markdown_content task_content']")
    private List<WebElement> taskNames;
    @FindBy(css ="[class='markdown_content task_description']")
    private List<WebElement> taskDescriptions;


    public WebElement getAddTaskButton(){ return addTaskButton;}
    public WebElement getNewTaskName() {
        return taskNames.get(taskNames.size()-1);
    }
    public WebElement getNewTaskDescription() {
        return taskDescriptions.get(taskDescriptions.size()-1);
    }

    @Step("Click on add a new task")
    public void clickOnAddTaskButton(){
        addTaskButton.click();
    }

    private void enterTaskName(String taskName){
        taskNameInput.sendKeys(taskName);
    }

    private void enterTaskDescription(String description){
        taskDescriptionInput.sendKeys(description);
    }

    private void clickOnSubmitTask(){
        submitTaskButton.click();
    }

    @Step("Create a new task")
    public void addNewTask(String taskName, String taskDescription){
        enterTaskName(taskName);
        enterTaskDescription(taskDescription);
        clickOnSubmitTask();
    }


}
