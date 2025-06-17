package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(900,400));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//неявное ожидание
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }
@AfterMethod
public void tearDown(){
        driver.quit();
}
    @Test
    public void findElementByTagName() {
       WebElement title= driver.findElement(By.tagName("h1"));//find element by tag name
        System.out.println(title.getText());

        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size());
    }
    @Test
    public void findElementByOtherLocators(){
        driver.findElements(By.id("city"));
        driver.findElement(By.id("dates"));
        //className
        WebElement search = driver.findElement(By.className("navigation-link"));
        System.out.println(search.getText());
        WebElement phone = driver.findElement(By.className("telephone"));
        System.out.println((phone.getText()));
        System.out.println(phone.getDomAttribute("class"));
        //linkText
        WebElement text = driver.findElement(By.linkText("Let the car work"));
        System.out.println(text.getText());
        //partialLinkText
        WebElement text2 = driver.findElement(By.partialLinkText("work"));
        System.out.println(text2.getText());
    }

    }
