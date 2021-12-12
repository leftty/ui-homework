package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.ShoppingCartPageSteps;

public class ShoppingCartPageStepDefinition {

    @Steps
    ShoppingCartPageSteps shoppingCartPageSteps;

    @Then("^I should see (\\d+) products in the shopping cart$")
    public void iShouldSeeProductsInTheShoppingCart(int noOfProducts) {
        shoppingCartPageSteps.checkNoOfProductsInCart(noOfProducts);
    }

    @When("^I remove product (\\d+) from shopping cart$")
    public void iRemoveProductFromShoppingCart(int productNo) {
        shoppingCartPageSteps.removeProductFromShoppingCart(productNo);
    }

    @Then("^I should see shopping card is empty$")
    public void iShouldSeeShoppingCardIsEmpty() {
        shoppingCartPageSteps.checkNoOfProductsInCart(0);
    }
}
