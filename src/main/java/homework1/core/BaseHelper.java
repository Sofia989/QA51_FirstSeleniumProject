package homework1.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseHelper  {
    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
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

    public void addItemToCart(String item) {
        click(By.xpath("//h2//a[contains(text(),'" + item + "')]"));
        click(By.cssSelector("input[value='Add to cart']"));
        pause(1500);
        click(By.xpath("//div[@class='header-links']//a[@class='ico-cart']"));
    }

    public boolean isItemToCartAdded(String productName) {
            List<WebElement> items = driver.findElements(By.cssSelector(".product-name"));
            for (WebElement el : items) {
                System.out.println("Товар в корзине: " + el.getText());
                if (el.getText().contains(productName)) {
                    return true;
                }
            }
            return false;
        }

}
