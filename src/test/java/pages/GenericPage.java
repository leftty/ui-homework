package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static java.time.Duration.ofMillis;

public class GenericPage extends PageObject {

    @FindBy(css = "button.js-accept")
    WebElement acceptCookiePolicyButton;
    @FindBy(css = "button.js-dismiss-login-notice-btn")
    WebElement closeLoginNoticeBanner;

    FluentWait globalFluentWait(int timeOutSeconds, int pollingEveryMilliseconds) {
        return new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(ofMillis(pollingEveryMilliseconds))
                .ignoring(NoSuchElementException.class);
    }

    public void acceptCookiePolicy() {
        globalFluentWait(10, 100).until(ExpectedConditions.visibilityOf(
                acceptCookiePolicyButton));
        globalFluentWait(10, 100).until(ExpectedConditions.elementToBeClickable(
                acceptCookiePolicyButton));
        try {
            acceptCookiePolicyButton.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("document.querySelector('button.js-accept').click()");
        }
    }

    public void closeLoginNoticeBanner() {
        try {
            closeLoginNoticeBanner.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("document.querySelector('button.js-dismiss-login-notice-btn').click()");
        }
    }
}
