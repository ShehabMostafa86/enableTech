package com.enable.tests.addRemoveItems;

import com.enable.pages.AddRemoveItem;
import org.testng.annotations.Test;

public class RemoveItemFromCartProductsList extends AddRemoveItem {

    @Test
    //Remove item from cart from products list
    public void removeItemFromCartProductsList(){
        baseDriver = getDriver();
        click_on_element(".inventory_list #add-to-cart-sauce-labs-backpack");
        click_on_element(".inventory_list #remove-sauce-labs-backpack");
        assert_button_updated("#add-to-cart-sauce-labs-backpack","ADD TO CART");
    }
}
