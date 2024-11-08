package com.qacart.todo.testcases;

import com.qacart.todo.Base.TestBase;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.TodoPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    @Test(description = "test login with valid email and valid password")
    @Feature("Login Page")
    @Story("login with valid data")
    @Severity(SeverityLevel.BLOCKER)
    @Description("validate that user can login with valid data")
    public void userCanLoginWithValidEmailAndPassword(){
        loginPage=new LoginPage(driver);
        loginPage.LoginSteps("marcellus.mitchell@yahoo.com","2edbh03116zgngc");
        TodoPage todoPage=new TodoPage(driver);
        Assert.assertTrue(todoPage.loginMsgIsDisplayed());
    }
}
