package com.enable.tests.checkOut;

import com.enable.pages.CheckOut;
import org.testng.annotations.Test;

public class CheckOutValidation extends CheckOut {

    @Test
    //Testing that check-out done successfully
    public void checkOut(){
        baseDriver = getDriver();
        click_on_element(".inventory_list .inventory_item:nth-child(1) .pricebar .btn_inventory");
        click_on_element(".inventory_list .inventory_item:nth-child(2) .pricebar .btn_inventory");
        click_on_element("#shopping_cart_container");
        click_on_element("#checkout");
        fill_checkOut_form();
        click_on_element("#continue");
        click_on_element("#finish");
        String currentMSG = get_element_text(".complete-header");
        assert_values(currentMSG, "THANK YOU FOR YOUR ORDER");
    }
}
