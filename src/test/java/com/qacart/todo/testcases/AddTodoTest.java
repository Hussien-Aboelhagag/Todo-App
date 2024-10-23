package com.qacart.todo.testcases;

import com.qacart.todo.Base.TestBase;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddTodoTest extends TestBase {
    LoginPage loginPage;
    TodoPage todoPage;
    @Test
    public void userCanAddTodo(){
        loginPage=new LoginPage(driver);
        todoPage=loginPage.LoginSteps("hussien@gmail.com","Hu123456#");
        todoPage.todoSteps("learn selenium");
        Assert.assertEquals(todoPage.getTodoItemName(),"learn selenium");
    }
    @Test
    public void userCanDeleteTodo(){
        loginPage=new LoginPage(driver);
        todoPage=loginPage.LoginSteps("hussien@gmail.com","Hu123456#");
        todoPage.deleteTodo();
        Assert.assertEquals(todoPage.getTodoItemNameAfterDelete(),"No Available Todos");
    }
}
