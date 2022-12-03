package com.enable.tests.cart;

import com.enable.pages.Cart;
import org.testng.annotations.Test;

public class CartBadgeAddProduct extends Cart{

    @Test
    //Validate cart badge icon after adding items to cart
    public void cartBadgeAddProduct(){
        baseDriver = getDriver();
        click_on_element(".inventory_list .inventory_item:nth-child(1) .pricebar .btn_inventory");
        click_on_element(".inventory_list .inventory_item:nth-child(2) .pricebar .btn_inventory");
        String badgeText = get_element_text(".shopping_cart_link .shopping_cart_badge");
        assert_values(badgeText,"2");
    }
}
