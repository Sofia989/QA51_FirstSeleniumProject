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
    @Test
    public void findelementByCSSSelector(){

        WebElement title= driver.findElement(By.cssSelector("h1"));
        System.out.println(title.getText());
        driver.findElements(By.cssSelector("#city"));

        WebElement search = driver.findElement(By.cssSelector(".navigation-link"));
        System.out.println(search.getText());

        //[key=`value`]
        driver.findElement(By.cssSelector("[href='/search']"));

        //* -contains
        driver.findElement(By.cssSelector("[class*='offers']"));

        driver.findElement(By.cssSelector("[class^='special']"));
        driver.findElement(By.cssSelector("[class$='container']"));
        //составные

        //span[contains(text(),'Latest')]

        driver.findElement(By.cssSelector(".search-container>.subtitle"));
        driver.findElement(By.cssSelector(".input-container #dates "));

        WebElement login = driver.findElement(By.cssSelector(".navigation-link:nth-child(6)"));
        System.out.println(login.getText());
    }

    @Test
    public void findElementByXpath(){
        ////*[@attr='value']

        WebElement ul = driver.findElement(By.xpath("//h1"));


        driver.findElements(By.xpath("//input[@id='city']"));
         //className
        WebElement search = driver.findElement(By.xpath("//*[@class='navigation-link']"));


        WebElement searchLink = driver.findElement(By.xpath("//*[@href='/search']"));
        System.out.println(searchLink.getText());

        //^^start

        //driver.findElement(By.cssSelector("[class^='special']"));
        driver.findElement(By.xpath("//*[starts-with(@class,'special')]"));

        //contains
        WebElement feedback = driver.findElement(By.xpath("//span[contains(text(),'Latest')]"));
        System.out.println(feedback.getText());

       driver.findElement(By.xpath("//*[@class='logo']/img[@alt='logo']"));

        driver.findElement(By.xpath("//*[@class='search-container']/*[@class='subtitle']"));

        driver.findElement(By.xpath("//*[@class='input-container']//input[@id='dates']"));

        WebElement login = driver.findElement(By.xpath("//a[6]"));
        System.out.println(login.getText());

        driver.findElement(By.xpath("//*[contains(.,'Latest')]"));
        driver.findElement(By.xpath("//*[.=' Latest feedback from our customers ']"));


    }

    }
    //div>a - css           //xpath>//div/a    //cssSelector >div a          //xpath >//div//a
