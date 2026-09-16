package listeners;

import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            System.out.println(
                    "Screenshot not captured because WebDriver is null."
            );
            return;
        }

        try {
            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now()
                    .format(
                            DateTimeFormatter.ofPattern(
                                    "yyyyMMdd_HHmmss"
                            )
                    );

            String fileName =
                    result.getMethod().getMethodName()
                            + "_"
                            + timestamp
                            + ".png";

            File destination = new File(
                    "test-output/screenshots/" + fileName
            );

            FileUtils.copyFile(
                    screenshot,
                    destination
            );

            System.out.println(
                    "Screenshot captured: "
                            + destination.getAbsolutePath()
            );

        } catch (IOException e) {

            System.out.println(
                    "Unable to capture screenshot: "
                            + e.getMessage()
            );
        }
    }
}