package com.enable.pages;

import com.enable.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Order extends Base {
    protected WebDriver baseDriver;

    public void fill_checkOut_form () {
        baseDriver.findElement(By.id("first-name")).sendKeys("Test");
        baseDriver.findElement(By.id("last-name")).sendKeys("Test");
        baseDriver.findElement(By.id("postal-code")).sendKeys("1234");
    }

    public float calculate_total_cart_items (String firstItemCssSelector, String secondItemCssSelector) {
        //Format item 1
        float priceItem_1 = format_item_value(firstItemCssSelector, 1);
        //Format item 2
        float priceItem_2 = format_item_value(secondItemCssSelector, 1);
        float expectedTotalItems = priceItem_1 + priceItem_2;
        return expectedTotalItems;
    }

    public DecimalFormat decimal_format (String format, Integer fractionDigits) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        decimalFormat.setMaximumFractionDigits(fractionDigits);
        return decimalFormat;
    }

    public float format_item_value (String priceCssSelector, Integer subStringIndex) {
        float priceItem = Float.parseFloat(baseDriver.findElement(By.cssSelector(priceCssSelector)).getText().substring(subStringIndex));
        priceItem = Float.parseFloat(decimal_format("0.00", 2).format(priceItem));
        return priceItem;
    }

    public void assert_total_items_calculation (String itemCssSelector_1, String itemCssSelector_2, String actualTotalItemsCssSelector, Integer subString) {
        //Expected total
        float expectedTotal = calculate_total_cart_items(itemCssSelector_1, itemCssSelector_2);
        //Actual total
        float actualTotal = format_item_value(actualTotalItemsCssSelector, subString);
        Assert.assertTrue(expectedTotal == actualTotal);
    }

    public void assert_tax_calculation (String itemCssSelector_1, String itemCssSelector_2, String taxCssSelector, Integer subString) {
        float totalCartItems = calculate_total_cart_items(itemCssSelector_1, itemCssSelector_2);

        //Format current tax
        float currentTax = format_item_value(taxCssSelector, subString);

        //Calculate expected tax
        float expectedTax = totalCartItems * 8 / 100;

        //Format expected tax
        decimal_format("0.00", 2).setMaximumFractionDigits(1);
        decimal_format("0.00", 2).setRoundingMode(RoundingMode.UP);
        expectedTax = Float.parseFloat(decimal_format("0.00", 2).format(expectedTax));
        //Assert
        Assert.assertTrue(currentTax == expectedTax);
    }

    public void assert_total_order_calculation (String itemCssSelector_1, String itemCssSelector_2, String taxCssSelector, String totalCssSelector) {
        float totalCartItems = calculate_total_cart_items(itemCssSelector_1, itemCssSelector_2);

        //Format tax
        float tax = Float.parseFloat(baseDriver.findElement(By.cssSelector(taxCssSelector)).getText().substring(6));
        tax = Float.parseFloat(decimal_format("0.00", 2).format(tax));
        float expectedTotalItemsAndTax = totalCartItems + tax;
        //Format total
        float actualTotalItems = Float.parseFloat(baseDriver.findElement(By.cssSelector(totalCssSelector)).getText().substring(8));
        actualTotalItems = Float.parseFloat(decimal_format("0.00", 2).format(actualTotalItems));
        //Assert
        Assert.assertTrue(expectedTotalItemsAndTax == actualTotalItems);
    }
}
