package step;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage;

    @Step
    public void goToEcommerceWebsite() {
        homePage.open();
        homePage.closeDailyOfferModal();
        homePage.acceptCookiePolicy();
        homePage.closeLoginNoticeBanner();
    }

    @Step
    public void searchFor(String searchString) {
        homePage.searchFor(searchString);
    }
}
