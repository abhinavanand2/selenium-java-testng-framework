package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void userShouldAddProductToCartSuccessfully() {

        String productName = "Sauce Labs Backpack";

        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page was not displayed"
        );

        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartCount(),
                "1",
                "Cart count is incorrect"
        );

        productsPage.openCart();

        Assert.assertTrue(
                cartPage.isProductDisplayed(productName),
                "Expected product was not found in the cart"
        );
    }
}