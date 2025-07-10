package homework1.fw;

import homework1.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductHelper extends BaseHelper {
    public ProductHelper(WebDriver driver) {
        super(driver);
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
