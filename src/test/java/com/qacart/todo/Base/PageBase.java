package com.qacart.todo.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickBtn(WebElement button){
        button.click();
    }
    public void setTxtElement(WebElement element,String value){
        element.sendKeys(value);
    }
}
