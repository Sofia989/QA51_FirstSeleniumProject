package homework1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHomePageHelper().isHomeComponentPresent()) {
            app.getHomePageHelper().clickOnHomeLink();
        }


        //"a.nivo-imageLink:nth-child(2)")
        //app.getDriver().navigate().to("https://demowebshop.tricentis.com/");
    }


    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePageHelper().isHomeComponentPresent());

    }
}