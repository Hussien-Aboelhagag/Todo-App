package com.qacart.todo.Base;

import com.qacart.todo.Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=new DriverFactory().initializeDriver();
        driver.get("https://qacart-todo.herokuapp.com/login");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
