package com.ait.homework1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase {

    @BeforeMethod
    public void precondition() {


        //лик по логин
        loginUser(new User()
                .setEmail("sofi@email.com")
                .setPassword("Sofi1234!!!"));

        //fill password
        //button login
    }
    @Test
    public void addItemToCartTest() {
        addItemToCart(".item-box:nth-child(3)", "#add-to-cart-button-31");
    }

}

