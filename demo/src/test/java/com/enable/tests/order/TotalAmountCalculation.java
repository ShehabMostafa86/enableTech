package com.enable.tests.order;


import com.enable.pages.Order;
import org.testng.annotations.Test;

public class TotalAmountCalculation extends Order {

    @Test
    //Testing that total amount is calculated correctly
    public void cartTotalAmount(){
        baseDriver = getDriver();
        click_on_element(".inventory_list .inventory_item:nth-child(1) .pricebar .btn_inventory");
        click_on_element(".inventory_list .inventory_item:nth-child(2) .pricebar .btn_inventory");
        click_on_element("#shopping_cart_container");
        click_on_element("#checkout");
        fill_checkOut_form();
        click_on_element("#continue");
        assert_total_items_calculation(".cart_list div:nth-child(3) .inventory_item_price",".cart_list div:nth-child(4) .inventory_item_price",".summary_subtotal_label",13);
    }
}

