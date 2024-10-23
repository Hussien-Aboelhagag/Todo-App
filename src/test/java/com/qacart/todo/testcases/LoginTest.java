package com.qacart.todo.testcases;

import com.qacart.todo.Base.TestBase;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    @Test
    public void userCanLoginWithValidEmailAndPassword(){
        loginPage=new LoginPage(driver);
        loginPage.LoginSteps("hussien@gmail.com","Hu123456#");
        TodoPage todoPage=new TodoPage(driver);
        Assert.assertTrue(todoPage.loginMsgIsDisplayed());
    }
}
