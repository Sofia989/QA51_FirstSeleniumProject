package homework1.core;

import homework1.fw.HomePageHelper;
import homework1.fw.ProductHelper;
import homework1.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;
    UserHelper userHelper;
    HomePageHelper homePageHelper;
    ProductHelper productHelper;

    public void init() {
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        userHelper = new UserHelper(driver);
        homePageHelper = new HomePageHelper(driver);
        productHelper = new ProductHelper(driver);
    }

    public ProductHelper getProductHelper() {
        return productHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }


    public UserHelper getUserHelper() {
        return userHelper;
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public void stop() {
        driver.quit();
    }

}
