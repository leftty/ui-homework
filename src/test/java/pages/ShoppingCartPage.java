package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends GenericPage {

    @FindBy(css = "div.cart-line")
    List<WebElement> productsInCart;
    @FindBy(css = "a.remove-product.btn-remove-product")
    List<WebElement> removeProductFromCartButtons;
    @FindBy(css = "")
    WebElement removeProductSpinner;


    public int getNoOfProductsInCart() {
        return productsInCart.size();
    }

    public void removeProductFromCart(int productNo) {
        removeProductFromCartButtons.get(productNo - 1).click();
        globalFluentWait(10, 100).until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div.loader-overlay[style]>div")));
        globalFluentWait(10, 100).until(ExpectedConditions.numberOfElementsToBe(
                By.cssSelector("div.loader-overlay[style]>div"), 0));
    }
}
