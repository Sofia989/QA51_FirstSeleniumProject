package homework1;

import homework1.model.User;
import homework1.utils.MyDataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSignOutLink();
        }

    }


    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User()
                //click on Registerlink
                .setFirstName("Lena")
                .setLastName("Ivanova")
                .setEmail("Lenali" + i + "@gmail.com")
                .setPassword("Lenali123!#$")
                .setConfirmPassword("Lenali123!#$");
        app.getUserHelper().fillRegistrationForm(user);

        //check email  button is present
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("(//a[@href='/customer/info'])[1]")));

    }

    @Test
    public void existedUserRegistrationNegativeTest() {


        //click on Registerlink
        app.getUserHelper().click(By.cssSelector(".ico-register"));
        //fill in registration form
        app.getUserHelper().type(By.cssSelector("#FirstName"), "Lena");
        app.getUserHelper().type(By.cssSelector("#LastName"), "Ivanova");
        app.getUserHelper().type(By.cssSelector("#Email"), "Lenali@gmail.com");
        app.getUserHelper().type(By.cssSelector("#Password"), "Lenali123!#$");
        app.getUserHelper().type(By.cssSelector("#ConfirmPassword"), "Lenali123!#$");
        //click Registartion button
        app.getUserHelper().click(By.cssSelector("#register-button"));
        //check email  button is present
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.cssSelector(".message-error li")));
    }



    @Test(dataProvider = "addContact",dataProviderClass = MyDataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderTest(String name, String LastName, String email, String password,String confirmPassword) {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User()
                //click on Registerlink
                .setFirstName(name)
                .setLastName(LastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword);
        app.getUserHelper().fillRegistrationForm(user);

        //check email  button is present
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("(//a[@href='/customer/info'])[1]")));

    }


    @Test(dataProvider ="addContactFromCsv",dataProviderClass = MyDataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvTest(User user) {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;


        app.getUserHelper().fillRegistrationForm(user);

        //check email  button is present
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("(//a[@href='/customer/info'])[1]")));

    }

}










