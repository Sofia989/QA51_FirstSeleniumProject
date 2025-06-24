package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelector() {
        WebElement ul = driver.findElement(By.cssSelector("ul"));
        System.out.println(ul.getText());
        List<WebElement> ul1 = driver.findElements(By.cssSelector("ul"));
        System.out.println(ul1.size());
        WebElement h3 = driver.findElement(By.cssSelector("h3"));
        System.out.println(h3.getText());
    }

    @Test
    public void findElementByIDCssSelector() {
        driver.findElement(By.cssSelector("#small-searchterms"));

        driver.get("https://demowebshop.tricentis.com/books");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.findElement(By.cssSelector("#products-orderby"));

    }

    @Test
    public void findElementByClassNameCssSelector() {
        WebElement element = driver.findElement(By.cssSelector(".footer-disclaimer"));
        System.out.println(element.getText());
        WebElement close = driver.findElement(By.cssSelector(".close"));
        System.out.println(close.getText());
        WebElement element1 = driver.findElement(By.cssSelector(".ico-wishlist"));
        System.out.println(element1.getText());
        WebElement twitter = driver.findElement(By.cssSelector(".twitter"));
        System.out.println(twitter.getText());
        WebElement count = driver.findElement(By.cssSelector(".count"));
        WebElement element3 = driver.findElement(By.cssSelector(".cart-label"));
        System.out.println(element3.getText());

        driver.get("https://demowebshop.tricentis.com/gift-cards");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        WebElement element2 = driver.findElement(By.cssSelector(".footer-poweredby"));
        System.out.println(element2.getText());

    }


    @AfterMethod()
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void KeyValuecCssSelector() {
        WebElement register = driver.findElement(By.cssSelector("[href='/register']"));
        System.out.println(register.getText());
        WebElement productall = driver.findElement(By.cssSelector("[href='/producttag/all']"));
        System.out.println(productall.getText());

        //contains->*
        driver.findElement(By.cssSelector("[class*='mini']"));

        //Start
        //ajax-loading-block-window
        driver.findElement(By.cssSelector("[class^='ajax']"));


        //"[class='master-wrapper-main']")
        driver.findElement(By.cssSelector("[class^='master']"));

        //end on->$
        driver.findElement(By.cssSelector("[class$='main']"));
        //header-selectors-wrapper
        driver.findElement(By.cssSelector("[class$='wrapper']"));

        //composite cssSelector
        driver.findElement(By.cssSelector(".header-logo img[alt='Tricentis Demo Web Shop']"));

        WebElement signin = driver.findElement(By.cssSelector(".newsletter-subscribe-block>span"));
        System.out.println(signin.getText());


        //page ComputersDesktops

        driver.get("https://demowebshop.tricentis.com/computers");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        driver.findElement(By.cssSelector(".picture img[alt='Picture for category Desktops']"));

        WebElement giftcards = driver.findElement(By.cssSelector(".top-menu>li:nth-child(7)"));
        System.out.println(giftcards.getText());

    }
    }