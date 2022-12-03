package com.enable.tests.checkOut;

import com.enable.pages.CheckOut;
import org.testng.annotations.Test;

public class UserInfoFieldsAllRequired extends CheckOut {

    @Test
    //Testing that user information are all required
    public void userInfo(){
        baseDriver = getDriver();
        click_on_element(".inventory_list .inventory_item:nth-child(1) .pricebar .btn_inventory");
        click_on_element(".inventory_list .inventory_item:nth-child(2) .pricebar .btn_inventory");
        click_on_element("#shopping_cart_container");
        click_on_element("#checkout");
        assert_checkOut_fields();
    }
}
