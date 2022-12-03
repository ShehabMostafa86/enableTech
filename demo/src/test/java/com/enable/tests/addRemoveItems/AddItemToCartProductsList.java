package com.enable.tests.addRemoveItems;

import com.enable.pages.AddRemoveItem;
import org.testng.annotations.Test;

public class AddItemToCartProductsList extends AddRemoveItem {

    @Test
    //Add item to cart from products list
    public void addItemToCartProductsList(){
        baseDriver = getDriver();
        click_on_element(".inventory_list #add-to-cart-sauce-labs-backpack");
        assert_button_updated(".pricebar .btn","REMOVE");
    }
}