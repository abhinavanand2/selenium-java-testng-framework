package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private DriverManager() {
        // Prevent object creation
    }

    public static void initializeDriver() {

        String browser =
                System.getProperty("browser", "chrome");

        boolean headless =
                Boolean.parseBoolean(
                        System.getProperty("headless", "false")
                );

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "firefox":

                FirefoxOptions firefoxOptions =
                        new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }

                webDriver =
                        new FirefoxDriver(firefoxOptions);

                break;

            case "chrome":

                ChromeOptions chromeOptions =
                        new ChromeOptions();

                /*
                 * Disable Chrome password manager and
                 * password breach/change-password warnings.
                 */
                Map<String, Object> prefs = new HashMap<>();

                prefs.put(
                        "credentials_enable_service",
                        false
                );

                prefs.put(
                        "profile.password_manager_enabled",
                        false
                );

                prefs.put(
                        "profile.password_manager_leak_detection",
                        false
                );

                prefs.put(
                        "profile.default_content_setting_values.notifications",
                        2
                );

                chromeOptions.setExperimentalOption(
                        "prefs",
                        prefs
                );

                /*
                 * Additional Chrome arguments to suppress
                 * password manager related UI.
                 */
                chromeOptions.addArguments(
                        "--disable-features=PasswordLeakDetection,PasswordManagerOnboarding"
                );

                chromeOptions.addArguments(
                        "--disable-save-password-bubble"
                );

                /*
                 * Start automation with a clean browser session.
                 */
                chromeOptions.addArguments(
                        "--incognito"
                );

                /*
                 * CI / headless configuration.
                 */
                if (headless) {

                    chromeOptions.addArguments(
                            "--headless=new"
                    );

                    chromeOptions.addArguments(
                            "--window-size=1920,1080"
                    );

                    chromeOptions.addArguments(
                            "--no-sandbox"
                    );

                    chromeOptions.addArguments(
                            "--disable-dev-shm-usage"
                    );
                }

                webDriver =
                        new ChromeDriver(chromeOptions);

                break;

            default:

                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser
                );
        }

        driver.set(webDriver);

        /*
         * Maximize browser only during headed/local execution.
         * Headless execution already uses 1920x1080.
         */
        if (!headless) {

            getDriver()
                    .manage()
                    .window()
                    .maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}