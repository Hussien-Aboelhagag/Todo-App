package com.qacart.todo.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;
    public WebDriver initializeDriver(){
        String browser=System.getProperty("browser","chrome");
        switch (browser){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;
            case "msEdge":
                driver=new EdgeDriver();
                break;
            default:throw new RuntimeException("this browser is not supported");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }
}
