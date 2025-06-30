package com.ait.homework1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase{

@Test
    public void newUserRegistrationPositiveTest(){
    int i=(int)(System.currentTimeMillis()/1000)%3600;


    //click on Registerlink
    click(By.cssSelector(".ico-register"));
    //fill in registration form
    type(By.cssSelector("#FirstName"), "Lena");
    type(By.cssSelector("#LastName"), "Ivanova");
    type(By.cssSelector("#Email"), "Lenali"+i+"@gmail.com");
    type(By.cssSelector("#Password"), "Lenali123!#$");
    type(By.cssSelector("#ConfirmPassword"), "Lenali123!#$");
    //click Registartion button
    click(By.cssSelector("#register-button"));
    //check email  button is present
    Assert.assertTrue(isElementPresent(By.xpath("(//a[@href='/customer/info'])[1]")));

}

    @Test
    public void existedUserRegistrationNegativeTest(){



        //click on Registerlink
        click(By.cssSelector(".ico-register"));
        //fill in registration form
        type(By.cssSelector("#FirstName"), "Lena");
        type(By.cssSelector("#LastName"), "Ivanova");
        type(By.cssSelector("#Email"), "Lenali@gmail.com");
        type(By.cssSelector("#Password"), "Lenali123!#$");
        type(By.cssSelector("#ConfirmPassword"), "Lenali123!#$");
        //click Registartion button
        click(By.cssSelector("#register-button"));
        //check email  button is present
        Assert.assertTrue(isElementPresent(By.cssSelector(".message-error li")));

    }

    }







