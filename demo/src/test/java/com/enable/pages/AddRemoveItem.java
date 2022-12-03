package com.enable.pages;

import com.enable.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddRemoveItem  extends Base{
    protected WebDriver baseDriver;
    public void assert_button_updated(String itemCssSelector, String text ){
        Assert.assertEquals(baseDriver.findElement(By.cssSelector(itemCssSelector)).getText(),text);
    }
}

