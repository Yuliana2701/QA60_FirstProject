package com.ait.qa60;

import com.ait.qa60.data.UserData;
import com.ait.qa60.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @Test
    public void addSecondItemToCartTest() {

        if (!app.getUser().isLoggedIn()) {
            app.getUser().login("yulia27@gmail.com", "Yuliana123!");
        }

        app.getProduct().addSecondProductToCart();

    }


    @AfterMethod
    public void tearDown() {

        if (app.getUser().isLoggedIn()) {
            app.getUser().logout();
        }
    }
}




