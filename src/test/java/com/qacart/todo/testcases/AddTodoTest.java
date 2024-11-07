package com.qacart.todo.testcases;

import com.qacart.todo.API.AddTodoAPI;
import com.qacart.todo.API.RegisterAPI;
import com.qacart.todo.Base.TestBase;
import com.qacart.todo.Pages.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddTodoTest extends TestBase {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("validate that user can login with valid data, and add todo")
    public void userCanAddTodo(){
        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.register();
        TodoPage todoPage=new TodoPage(driver);
        injectCookieIntoSelenium(registerAPI.getRegisterCookie());
        todoPage.todoSteps("learn selenium");
        Assert.assertEquals(todoPage.getTodoItemName(),"learn selenium");
    }
    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Description("validate that user can login with valid data, add todo, and delete")
    public void userCanDeleteTodo(){
        RegisterAPI registerAPI=new RegisterAPI();
        registerAPI.register();
        AddTodoAPI addTodoAPI=new AddTodoAPI();
        addTodoAPI.addNewTask(registerAPI.getAccessToken());
        TodoPage todoPage=new TodoPage(driver);
        injectCookieIntoSelenium(registerAPI.getRegisterCookie());
        todoPage.deleteTodo();
        Assert.assertEquals(todoPage.getTodoItemNameAfterDelete(),"No Available Todos");
    }
}
