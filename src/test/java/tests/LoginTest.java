package tests;

import base.BaseTest;
import data.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void validUserShouldLoginSuccessfully() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.open();
        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        Assert.assertTrue(
                getDriver().getCurrentUrl().contains("inventory"),
                "User was not redirected to the products page"
        );
    }

    @Test(
            dataProvider = "invalidLoginData",
            dataProviderClass = TestDataProvider.class,
            groups = {"regression"}
    )
    public void invalidUserShouldSeeErrorMessage(
            String username,
            String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.open();
        loginPage.login(username, password);

        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Login error message was not displayed"
        );
    }
}