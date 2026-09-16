package data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {

        return new Object[][]{
                {"invalid_user", "invalid_password"},
                {"standard_user", "wrong_password"},
                {"locked_out_user", "secret_sauce"}
        };
    }
}