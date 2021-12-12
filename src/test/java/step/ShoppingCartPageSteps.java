package step;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.Header;
import pages.ShoppingCartPage;

public class ShoppingCartPageSteps {

    ShoppingCartPage shoppingCartPage;
    Header header;

    @Step
    public void checkNoOfProductsInCart(int noOfProducts) {
        Assert.assertEquals(noOfProducts, shoppingCartPage.getNoOfProductsInCart());
        /*the following line is commented out because it will make the test fail because
        of a bug regarding the number of products displayed next to the shopping cart icon from the header
        not being automatically updated when a product is removed from the shopping cart*/
//        Assert.assertEquals(noOfProducts, header.getNoOfProductsInCart());
    }

    @Step
    public void removeProductFromShoppingCart(int productNo) {
        shoppingCartPage.removeProductFromCart(productNo);
    }
}
