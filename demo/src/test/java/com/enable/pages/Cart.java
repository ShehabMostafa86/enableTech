package com.enable.pages;

import com.enable.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cart extends Base {
    protected WebDriver baseDriver;

    public String get_element_text(String textCssSelector){
         String elementText = baseDriver.findElement(By.cssSelector(textCssSelector)).getText();
        return elementText;
    }

    public void assert_values(String current, String expected){
        Assert.assertEquals( current, expected);
    }
}

