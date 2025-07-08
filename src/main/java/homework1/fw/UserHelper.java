package homework1.fw;

import homework1.core.BaseHelper;
import homework1.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    protected void loginUser(String email, String password) {
        click(By.cssSelector(".ico-login"));
        //fill email
        type(By.name("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.login-button"));

    }

    public void loginUser(User user) {
        loginUser(user.getEmail(), user.getPassword());
    }

    public void fillRegistrationForm(User user) {
        click(By.cssSelector(".ico-register"));
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
        click(By.cssSelector("#register-button"));
    }

    public void clickOnSignOutButton() {
        click(By.cssSelector(".ico-logout"));

    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector(".ico-login"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }
}
