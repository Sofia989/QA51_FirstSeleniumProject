package homework1;

import homework1.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUserHelper().isUserLoggedIn()) {
            app.getUserHelper().loginUser(new User()
                    .setEmail("sofi@email.com")
                    .setPassword("Sofi1234!!!"));
        }
    }
    @Test
    public void addItemToCartTest() {
       // String item = "$25 Virtual Gift Card";
        //String item = "14.1-inch Laptop";
        //String item ="Simple Computer";
        String item = "Build your own expensive computer";
        app.getProductHelper().addItemToCart(item);
        Assert.assertTrue(app.getProductHelper().isItemToCartAdded(item));
    }
}

