package com.enable.pages;

import com.enable.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CheckOut extends Base {
    protected WebDriver baseDriver;

    public void fill_checkOut_form() {
        baseDriver.findElement(By.id("first-name")).sendKeys("Test");
        baseDriver.findElement(By.id("last-name")).sendKeys("Test");
        baseDriver.findElement(By.id("postal-code")).sendKeys("1234");
    }

    public String get_element_text(String textCssSelector) {
        String elementText = baseDriver.findElement(By.cssSelector(textCssSelector)).getText();
        return elementText;
    }

    public void assert_checkOut_fields() {
        //While loop to test all text fields in user information page
        int counter = 1;
        boolean error = true;
        while (error) {
            baseDriver.findElement(By.id("continue")).click();
            try {
                baseDriver.findElement(By.className("error")).isDisplayed(); //check that error message exist
                baseDriver.findElement(By.cssSelector(".checkout_info div:nth-child(" + counter + ") .form_input")).sendKeys("Test");
            } catch (NoSuchElementException e) {
                error = false;
            }
            counter++;
        }
    }

    public void assert_values(String currentMSG, String expectedMSG) {
        Assert.assertEquals(currentMSG, expectedMSG);
    }
}
