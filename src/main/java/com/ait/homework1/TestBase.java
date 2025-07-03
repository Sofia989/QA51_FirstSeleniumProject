package com.ait.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.cssSelector("a.nivo-imageLink:nth-child(2)")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void loginUser(String email, String password) {
        click(By.cssSelector(".ico-login"));
        //fill email
        type(By.name("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.login-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));
    }

    protected void addItemToCart(String Item, String addButton) {
        click(By.cssSelector(Item));
        click(By.cssSelector(addButton));
        pause(1500);
        click(By.xpath("//div[@class='header-links']//a[@class='ico-cart']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".product-name ")));
    }
        protected  User user;

    protected void loginUser(User user) {
        loginUser(user.getEmail(), user.getPassword());
    }

    public void fillRegistrationForm(User user) {
        click(By.cssSelector(".ico-register")); // ← открываем форму
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
        click(By.cssSelector("#register-button")); // ← жмём "Register"
    }

}

