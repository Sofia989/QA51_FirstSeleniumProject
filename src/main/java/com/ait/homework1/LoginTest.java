package com.ait.homework1;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginPositiveTest() {
        //лик по логин
        loginUser(new User()
                .setEmail("sofi@email.com")
                .setPassword("Sofi1234!!!"));

        //fill password
        //button login
    }


}