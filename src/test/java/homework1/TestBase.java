package homework1;

import homework1.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    Logger logger=LoggerFactory.getLogger(TestBase.class);

    protected  static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

   // @BeforeMethod
    @BeforeSuite

    public void setUp(){
        System.err.close();

        app.init();

    }

   //@AfterMethod(enabled = false)
    @AfterSuite(alwaysRun = true)
    public void tearDown(){

        app.stop();
    }

    //input[value='Add to cart']

    @BeforeMethod
    public void startTest(Method method, Object[]p){
        logger.info("Start test{} with data:{}",method.getName(), Arrays.asList(p));
    }
    @AfterMethod
    public void stopTest(){
        logger.info(("Stop test"));
    }
}



