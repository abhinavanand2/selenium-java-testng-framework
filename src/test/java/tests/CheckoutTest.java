package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void userShouldCompleteCheckoutSuccessfully() {

        // Page Objects
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        // Login
        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page was not displayed after login"
        );

        // Add product to cart
        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartCount(),
                "1",
                "Cart count should be 1"
        );

        // Open cart
        productsPage.openCart();

        Assert.assertTrue(
                cartPage.isProductDisplayed("Sauce Labs Backpack"),
                "Sauce Labs Backpack was not displayed in cart"
        );

        // Proceed to checkout
        cartPage.proceedToCheckout();

        // Enter checkout information
        checkoutPage.enterCustomerInformation(
                "Abhinav",
                "Anand",
                "00000"
        );

        // Continue to checkout overview
        checkoutPage.continueCheckout();

        Assert.assertTrue(
                checkoutPage.isCheckoutOverviewDisplayed(),
                "Checkout overview page was not displayed"
        );

        // Finish order
        checkoutPage.finishOrder();

        // Validate order confirmation
        Assert.assertEquals(
                checkoutPage.getConfirmationMessage(),
                "Thank you for your order!",
                "Order confirmation message is incorrect"
        );
    }
}