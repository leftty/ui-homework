package stepDefinitions;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import step.SearchResultsPageSteps;

public class SearchResultsPageStepDefinition {

    @Steps
    SearchResultsPageSteps searchResultsPageSteps;

    @And("^I add to cart product (\\d+) from search results page$")
    public void iAddToCartProductFromSearchResultsPage(int productNo) {
        searchResultsPageSteps.addProductFromSearchResultsPage(productNo);

    }

    @And("^I go to shopping cart page$")
    public void iGoToShoppingCartPage() {
        searchResultsPageSteps.goToShoppingCartPage();
    }


}
