package step;

import net.thucydides.core.annotations.Step;
import pages.AddToCartConfirmationModal;
import pages.Header;
import pages.SearchResultsPage;

public class SearchResultsPageSteps {

    SearchResultsPage searchResultsPage;
    AddToCartConfirmationModal addToCartConfirmationModal;
    Header header;

    @Step
    public void addProductFromSearchResultsPage(int productNo) {
        searchResultsPage.addProductFromSearchResultsPage(productNo);
        addToCartConfirmationModal.closeModal();
    }

    @Step
    public void goToShoppingCartPage() {
        header.goToShoppingCartPage();
    }
}
