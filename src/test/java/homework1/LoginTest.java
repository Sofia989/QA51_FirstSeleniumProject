package homework1;

import homework1.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSignOutLink();
        }

    }

        @Test
        public void loginPositiveTest () {
            //лик по логин
            app.getUserHelper().loginUser(new User()
                    .setEmail("sofi@email.com")
                    .setPassword("Sofi1234!!!"));
            Assert.assertTrue(app.getUserHelper().isElementPresent(By.cssSelector(".ico-logout")));
            //fill password
            //button login
        }

    }