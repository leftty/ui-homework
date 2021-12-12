package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.HomePageSteps;

public class HomePageStepDefinition {

    @Steps
    HomePageSteps homePageSteps;

    @Given("^I go to ecommerce website$")
    public void iGoToEcommerceWebsite() {
        homePageSteps.goToEcommerceWebsite();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchString) throws Throwable {
        homePageSteps.searchFor(searchString);
    }


}
