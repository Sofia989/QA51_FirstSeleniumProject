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

public class HomeWork1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName() {
        WebElement ul = driver.findElement(By.tagName("ul"));
        System.out.println(ul.getText());
        List<WebElement> ul1 = driver.findElements(By.tagName("ul"));
        System.out.println(ul1.size());
        WebElement h3 = driver.findElement(By.tagName("h3"));
        System.out.println(h3.getText());
    }

    @Test
    public void findElementByID() {
        driver.findElement(By.id("small-searchterms"));

        driver.get("https://demowebshop.tricentis.com/books");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.findElement(By.id("products-orderby"));

    }

    @Test
    public void findElementByClassName() {
        WebElement element = driver.findElement(By.className("footer-disclaimer"));
        System.out.println(element.getText());
        WebElement close = driver.findElement(By.className("close"));
        System.out.println(close.getText());
        WebElement element1 = driver.findElement(By.className("ico-wishlist"));
        System.out.println(element1.getText());
        WebElement twitter = driver.findElement(By.className("twitter"));
        System.out.println(twitter.getText());
        WebElement count = driver.findElement(By.className("count"));
        WebElement element3 = driver.findElement(By.className("cart-label"));
        System.out.println(element3.getText());

        driver.get("https://demowebshop.tricentis.com/gift-cards");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        WebElement element2 = driver.findElement(By.className("footer-poweredby"));
        System.out.println(element2.getText());

    }

    @Test
    public void findElementByLinkText(){
        WebElement nopCommerce = driver.findElement(By.linkText("nopCommerce"));
        System.out.println(nopCommerce.getText());

        //partialLinkText
        WebElement nop = driver.findElement(By.partialLinkText("nop"));
        System.out.println(nop.getText());
        WebElement shop = driver.findElement(By.partialLinkText("Shop"));
        System.out.println(shop.getText());

    }


    @AfterMethod()
    public void tearDown() {
        driver.quit();

    }
}