package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends PageObject {

    @FindBy(css = "a#my_cart span.jewel")
    WebElement shoppingCartButton;
    @FindBy(css = "span.jewel-danger")
    WebElement noOfProductsInCart;

    public void goToShoppingCartPage() {
        shoppingCartButton.click();
    }

    public int getNoOfProductsInCart() {
        return Integer.parseInt(noOfProductsInCart.getText());
    }
}
