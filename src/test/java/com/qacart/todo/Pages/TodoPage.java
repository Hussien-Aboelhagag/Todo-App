package com.qacart.todo.Pages;

import com.qacart.todo.Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends PageBase {
    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid='welcome']")
    WebElement loginMsg;
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root']")
    WebElement addBtn;
    @FindBy(css = "[data-testid='new-todo']")
    WebElement todoInput;
    @FindBy(css = "[data-testid='submit-newTask']")
    WebElement createBtn;
    @FindBy(css = "[data-testid='todo-text']")
    WebElement todoItem;

    @FindBy(css = "[data-testid='delete']")
    WebElement deleteTodoItem;
    @FindBy(css = "[data-testid='no-todos']")
    WebElement deleteTodoItemMSg;

    public void todoSteps(String todoItem){
        clickBtn(addBtn);
        setTxtElement(todoInput,todoItem);
        clickBtn(createBtn);
    }
    public Boolean loginMsgIsDisplayed(){
        return loginMsg.isDisplayed();
    }
    public String getTodoItemName(){
        return todoItem.getText();
    }
    public void deleteTodo(){
        clickBtn(deleteTodoItem);
    }
    public String getTodoItemNameAfterDelete(){
        return deleteTodoItemMSg.getText();
    }

}
