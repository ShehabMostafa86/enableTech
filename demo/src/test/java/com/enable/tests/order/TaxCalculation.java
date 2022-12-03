package com.enable.tests.order;

import com.enable.pages.Order;
import org.testng.annotations.Test;

public class TaxCalculation extends Order {

    @Test
    //Testing that tax is calculated correctly (assumption tax percentage = 8%)
    public void taxCalculation(){
        baseDriver = getDriver();
        click_on_element(".inventory_list .inventory_item:nth-child(1) .pricebar .btn_inventory");
        click_on_element(".inventory_list .inventory_item:nth-child(2) .pricebar .btn_inventory");
        click_on_element("#shopping_cart_container");
        click_on_element("#checkout");
        fill_checkOut_form();
        click_on_element("#continue");
        assert_tax_calculation(".cart_list div:nth-child(3) .inventory_item_price",".cart_list div:nth-child(4) .inventory_item_price",".summary_tax_label",6);
    }
}
