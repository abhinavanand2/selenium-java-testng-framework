package base;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final String BASE_URL =
            "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        DriverManager.initializeDriver();

        getDriver().get(BASE_URL);
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quitDriver();
    }
}