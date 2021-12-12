package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends GenericPage {

    @FindBy(id = "searchboxTrigger")
    WebElement searchInput;
    @FindBy(css = "button.searchbox-submit-button")
    WebElement searchButton;
    @FindBy(css = "div.ns-wrap-bottom-right button")
    WebElement closeDailyOfferModal;

    public void searchFor(String searchString) {
        searchInput.sendKeys(searchString);
        globalFluentWait(10, 100).until(ExpectedConditions.attributeToBe(searchInput, "value", searchString));
        searchButton.click();
    }

    public void closeDailyOfferModal() {
        closeDailyOfferModal.click();
    }
}
