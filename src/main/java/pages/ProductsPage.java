package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By productList =
            By.cssSelector("[data-test='inventory-list']");

    private final By backpackAddToCartButton =
            By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");

    private final By cartBadge =
            By.cssSelector("[data-test='shopping-cart-badge']");

    private final By cartLink =
            By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageDisplayed() {
        waitForUrlContains("inventory");
        return isDisplayed(productList);
    }

    public void addBackpackToCart() {
        click(backpackAddToCartButton);
    }

    public String getCartCount() {
        return getText(cartBadge);
    }

    public void openCart() {
        click(cartLink);
    }
}