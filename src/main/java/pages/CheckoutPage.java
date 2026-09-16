package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstName =
            By.id("first-name");

    private final By lastName =
            By.id("last-name");

    private final By postalCode =
            By.id("postal-code");

    private final By continueButton =
            By.id("continue");

    private final By finishButton =
            By.id("finish");

    private final By checkoutOverview =
            By.className("summary_info");

    private final By confirmationMessage =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerInformation(
        String firstNameValue,
        String lastNameValue,
        String postalCodeValue) {

    waitForUrlContains("checkout-step-one");

    waitForVisible(firstName);

    type(firstName, firstNameValue);
    type(lastName, lastNameValue);
    type(postalCode, postalCodeValue);
}

    public void continueCheckout() {
        click(continueButton);
    }

    public boolean isCheckoutOverviewDisplayed() {
        waitForUrlContains("checkout-step-two");
        return isDisplayed(checkoutOverview);
    }

    public void finishOrder() {
        click(finishButton);
    }

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
}