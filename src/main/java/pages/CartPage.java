package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    click(checkoutButton);
    waitForUrlContains("checkout-step-one");
}
}