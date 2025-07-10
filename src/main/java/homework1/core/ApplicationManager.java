package homework1.core;

import homework1.fw.HomePageHelper;
import homework1.fw.ProductHelper;
import homework1.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;
    UserHelper userHelper;
    HomePageHelper homePageHelper;
    ProductHelper productHelper;

    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public void init() {
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }
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

    public HomePageHelper getHomePage() {
        return homePageHelper;
    }
}
