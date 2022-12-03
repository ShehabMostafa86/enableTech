package com.enable.tests.cart;

import com.enable.pages.Cart;
import org.testng.annotations.Test;

public class CorrectItemsAdded extends Cart {

    @Test
    //Testing that correct items added correctly to cart
    public void cartItems(){
        baseDriver = getDriver();
        click_on_element(".inventory_list .inventory_item:nth-child(1) .pricebar .btn_inventory");
        String productName_1 = get_element_text(".inventory_list .inventory_item:nth-child(1) .inventory_item_name");
        click_on_element(".inventory_list .inventory_item:nth-child(2) .pricebar .btn_inventory");
        String productName_2 = get_element_text(".inventory_list .inventory_item:nth-child(2) .inventory_item_name");
        click_on_element(".shopping_cart_link");
        waitForElement(5,"#checkout");
        String cartName_1 = get_element_text(".cart_list div:nth-child(3) .cart_item_label .inventory_item_name");
        String cartName_2 = get_element_text(".cart_list div:nth-child(4) .cart_item_label .inventory_item_name");
        assert_values(productName_1,cartName_1);
        assert_values(productName_2,cartName_2);
    }
}
