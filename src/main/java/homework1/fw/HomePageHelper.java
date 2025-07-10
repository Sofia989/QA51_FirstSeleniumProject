package homework1.fw;

import homework1.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("a.nivo-imageLink:nth-child(2)"));
    }

    public void clickOnHomeLink() {
        click(By.cssSelector(".header-logo a"));

    }
}
