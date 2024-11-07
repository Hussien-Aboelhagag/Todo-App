package com.qacart.todo.testcases;

import com.qacart.todo.Base.TestBase;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.TodoPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    @Test()
    @Severity(SeverityLevel.BLOCKER)
    @Description("validate that user can login with valid data")
    public void userCanLoginWithValidEmailAndPassword(){
        loginPage=new LoginPage(driver);
        loginPage.LoginSteps("marcellus.mitchell@yahoo.com","2edbh03116zgngc");
        TodoPage todoPage=new TodoPage(driver);
        Assert.assertTrue(todoPage.loginMsgIsDisplayed());
    }
}
