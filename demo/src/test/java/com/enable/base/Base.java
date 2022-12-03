package com.enable.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class Base {

     public WebDriver baseDriver;
     WebDriverWait wait;

     //Initializing chrome driver instance
    @BeforeClass
    public WebDriver driverInit(){
        System.setProperty("webdriver.chrome.driver","././driver/chromedriver.exe");
        baseDriver = new ChromeDriver();
       // login();
        return baseDriver;
    }

    //Login to application
    @BeforeMethod
    public void login(){
        baseDriver.get("https://www.saucedemo.com/");
        baseDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        baseDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        baseDriver.findElement(By.id("login-button")).click();
        wait = new WebDriverWait(baseDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
    }

    //Close browser after test is finish
    @AfterClass
    public void closeBrowser(){
        baseDriver.quit();
    }

    //Send driver to test classes
    public WebDriver getDriver(){
        return baseDriver;
    }

    //Click on element
    public void click_on_element(String itemCssSelector){
        baseDriver.findElement(By.cssSelector(itemCssSelector)).click();
    }

    //Wait for element to be displayed
    public void waitForElement(Integer seconds, String elementCssSelector){
        wait = new WebDriverWait(baseDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCssSelector)));
    }
}