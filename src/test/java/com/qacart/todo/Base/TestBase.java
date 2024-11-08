package com.qacart.todo.Base;

import com.qacart.todo.Config.APIResources;
import com.qacart.todo.Factory.DriverFactory;
import com.qacart.todo.Utils.CookieUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=new DriverFactory().initializeDriver();
        driver.get(APIResources.LOGIN_PAGE);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        String testCaseName=result.getMethod().getMethodName();
        File destFile=new File("target"+File.separator+"Screenshot"+File.separator+testCaseName+".png");
        takeScreenshots(destFile);
        driver.quit();
    }
    @Step
    public void injectCookieIntoSelenium(List<Cookie> restAssuredCookie){
        List<org.openqa.selenium.Cookie> seleniumCookies= CookieUtils.convertRestAssuredCookieIntoSelenium(restAssuredCookie);
        for (org.openqa.selenium.Cookie cookie:seleniumCookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }
    public void takeScreenshots(File destFile) throws IOException {
        TakesScreenshot takeScreen = (TakesScreenshot) driver;
        File file=takeScreen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,destFile);
        InputStream inputStream=new FileInputStream(destFile);
        Allure.addAttachment("Screenshot",inputStream);
    }
}
