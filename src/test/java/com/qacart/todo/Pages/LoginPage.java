package com.qacart.todo.Pages;

import com.qacart.todo.Base.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "submit")
    WebElement loginBtn;

    @Step("open browser web application, login with valid data")
    public TodoPage LoginSteps(String email,String password){
        setTxtElement(emailInput,email);
        setTxtElement(passwordInput,password);
        clickBtn(loginBtn);
        return new TodoPage(driver);
    }
}
