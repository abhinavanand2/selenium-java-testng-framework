package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDisplayed(String productName) {

        By product = By.xpath(
                "//div[@class='cart_item']//div[@class='inventory_item_name' and text()='"
                        + productName +
                        "']"
        );

        return isDisplayed(product);
    }

    public void proceedToCheckout() {

        WebElement checkout =
                waitForVisible(checkoutButton);

        scrollIntoView(checkoutButton);

        try {
            checkout.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            checkout
                    );
        }

        // Fallback if native click was accepted but navigation did not occur
        try {
            waitForUrlContains("checkout-step-one");
        } catch (Exception e) {

            checkout =
                    waitForVisible(checkoutButton);

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            checkout
                    );

            waitForUrlContains("checkout-step-one");
        }
    }
}