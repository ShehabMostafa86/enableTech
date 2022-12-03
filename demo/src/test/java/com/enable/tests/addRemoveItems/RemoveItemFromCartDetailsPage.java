package com.enable.tests.addRemoveItems;

import com.enable.pages.AddRemoveItem;
import org.testng.annotations.Test;

public class RemoveItemFromCartDetailsPage extends AddRemoveItem {

    @Test
    //Remove item from cart from product details page
    public void removeItemFromCartDetailsPage(){
        baseDriver = getDriver();
        click_on_element(".inventory_list #add-to-cart-sauce-labs-backpack");
        click_on_element(".inventory_list div:nth-child(1) .inventory_item_name");
        waitForElement(5,"#back-to-products");
        click_on_element("#remove-sauce-labs-backpack");
        assert_button_updated("#add-to-cart-sauce-labs-backpack","ADD TO CART");
    }
}
