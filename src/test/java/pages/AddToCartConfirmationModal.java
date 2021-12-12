package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCartConfirmationModal extends GenericPage {

    @FindBy(css = "button[data-dismiss=modal]")
    WebElement closeModalButton;

    public void closeModal() {
        closeModalButton.click();
        globalFluentWait(10, 100).until(
                ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.modal-dialog"), 0));
    }
}
