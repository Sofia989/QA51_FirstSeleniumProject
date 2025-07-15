package homework1;

import homework1.fw.ValidationHelper;
import homework1.model.User;
import homework1.utils.MyDataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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


    @Test(dataProvider = "addContact", dataProviderClass = MyDataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderTest(String name, String LastName, String email, String password, String confirmPassword) {
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


    @Test(dataProvider = "addContactFromCsv", dataProviderClass = MyDataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvTest(User user) {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;


        app.getUserHelper().fillRegistrationForm(user);

        //check email  button is present
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("(//a[@href='/customer/info'])[1]")));

    }


    @Test(dataProvider = "addNegativeUsersFromCsv", dataProviderClass = MyDataProviders.class)
    public void newUserRegistrationNegativeFromDataProviderTest(User user) {


        System.out.println(" Тест негативной регистрации для: " + user.getFirstName() + " " + user.getLastName() + " | Email: " + user.getEmail());

        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().click(By.cssSelector("#register-button"));


        By firstNameError = By.cssSelector("[data-valmsg-for='FirstName']");
        By lastNameError = By.cssSelector("[data-valmsg-for='LastName']");
        By emailError = By.cssSelector("[data-valmsg-for='Email']");
        By passwordError = By.cssSelector("[data-valmsg-for='Password']");
        By confirmPasswordError = By.cssSelector("[data-valmsg-for='ConfirmPassword']");


        String firstNameErrorText = app.getUserHelper().getText(firstNameError);
        String lastNameErrorText = app.getUserHelper().getText(lastNameError);
        String emailErrorText = app.getUserHelper().getText(emailError);
        String passwordErrorText = app.getUserHelper().getText(passwordError);
        String confirmPasswordErrorText = app.getUserHelper().getText(confirmPasswordError);

        System.out.println(" First name error: '" + firstNameErrorText + "'");
        System.out.println(" Last name error: '" + lastNameErrorText + "'");
        System.out.println(" Email error: '" + emailErrorText + "'");
        System.out.println(" Password error: '" + passwordErrorText + "'");
        System.out.println(" Confirm password error: '" + confirmPasswordErrorText + "'");

        boolean hasErrors=false;


        if (user.getFirstName().isEmpty()) {
            if (firstNameErrorText.isEmpty()) {
                Assert.fail(" Нет ошибки по First Name, хотя поле пустое у: " + user.getEmail());
            } else {
                Assert.assertEquals(firstNameErrorText, "First name is required.",
                        "Неверный текст ошибки по First Name у: " + user.getEmail());
            }
            hasErrors=true;
        }


        if (user.getLastName().isEmpty()) {
            if (lastNameErrorText.isEmpty()) {
                Assert.fail(" Нет ошибки по Last Name у: " + user.getEmail());
            } else {
                Assert.assertEquals(lastNameErrorText, "Last name is required.");
            }
            hasErrors=true;
        }


        if (!user.getEmail().contains("@")) {
            if (emailErrorText.isEmpty()) {
                Assert.fail(" Ошибка по Email не появилась у: " + user.getEmail());
            } else {
                Assert.assertTrue(emailErrorText.contains("Wrong email"),
                        " Текст ошибки Email не совпадает у: " + user.getEmail());
            }
            hasErrors=true;
        }

        // ✔ Страховка для Confirm Password
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            if (confirmPasswordErrorText.isEmpty()) {
                Assert.fail(" Нет ошибки по подтверждению пароля у: " + user.getEmail());
            } else {
                Assert.assertEquals(confirmPasswordErrorText,
                        "The password and confirmation password do not match.",
                        " Ошибка подтверждения пароля не совпадает у: " + user.getEmail());
            }
            hasErrors=true;
        }


        if (user.getPassword().length() < 6) {
            if (passwordErrorText.isEmpty()) {
                Assert.fail(" Ошибка по длине пароля не отображается у: " + user.getEmail());
            } else {
                Assert.assertEquals(passwordErrorText,
                        "The password should have at least 6 characters.");


            }
            hasErrors=true;

        }
        if(!hasErrors){
        System.out.println(" Все поля валидны у: " + user.getFirstName() + " " + user.getLastName() + " | " + user.getEmail());
    }

        ValidationHelper validator = new ValidationHelper();



    }}


