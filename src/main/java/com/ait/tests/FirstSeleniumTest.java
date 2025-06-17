package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {

    WebDriver driver;

    //before-setUp


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.get("https://www.google.com");//without history
        driver.navigate().to("https://www.google.com");//with history
        driver.navigate().back();//key back
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//не явное ожидание
    }

    @Test
    public void openGoogle() {
        System.out.println("Google opened!");

    }

    @AfterMethod(enabled=false)
    public void tearDown(){
        driver.quit();//all tabs
        driver.close();//only on tab
    }
    //test

    //after-tearDown
}
