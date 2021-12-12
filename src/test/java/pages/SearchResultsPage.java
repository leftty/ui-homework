package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends GenericPage {

    @FindBy(css = "div#card_grid>div.card-item button[type='submit']")
    List<WebElement> addToCartButtons;

    public void addProductFromSearchResultsPage(int productNo) {
        addToCartButtons.get(productNo - 1).click();
    }
}
