package com.qacart.todo.Base;

import com.qacart.todo.Config.APIResources;
import com.qacart.todo.Factory.DriverFactory;
import com.qacart.todo.Utils.CookieUtils;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=new DriverFactory().initializeDriver();
        driver.get(APIResources.LOGIN_PAGE);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void injectCookieIntoSelenium(List<Cookie> restAssuredCookie){
        List<org.openqa.selenium.Cookie> seleniumCookies= CookieUtils.convertRestAssuredCookieIntoSelenium(restAssuredCookie);
        for (org.openqa.selenium.Cookie cookie:seleniumCookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }
}
