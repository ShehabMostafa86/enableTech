package com.enable.tests.addRemoveItems;

import com.enable.pages.AddRemoveItem;
import org.testng.annotations.Test;

public class AddItemToCartDetailsPage extends AddRemoveItem {


    @Test
    //Add item to cart from product details page
    public void addItemToCartDetailsPage () {
        baseDriver = getDriver();
        click_on_element(".inventory_list div:nth-child(1) .inventory_item_name");
        waitForElement(5, "#back-to-products");
        click_on_element(".btn_inventory");
        assert_button_updated(".btn_inventory", "REMOVE");
    }


}


