package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;

@Listeners({AllureTestNg.class})
public class BaseTest {

    protected static AppiumDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {

        // 1. Install the split APKs manually
        String appBasePath = System.getProperty("user.dir") + "/src/test/java/resources/apps/";
        Process install = Runtime.getRuntime().exec(new String[] {
                "adb", "install-multiple",
                appBasePath + "base.apk",
                appBasePath + "split_config.arm64_v8a.apk",
                appBasePath + "split_config.en.apk",
                appBasePath + "split_config.xxhdpi.apk"
        });
        try {
            install.waitFor(); // Wait for the install to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String udid = System.getenv("DEVICE_UDID"); // Get from environment
        if (udid == null || udid.isEmpty()) {
            System.out.println("Environment variable 'DEVICE_UDID' not set. Falling back to default UDID: R5CT9113M6J");
            udid = "R5CT9113M6J"; // fallback default
        }
        // 2. Launch Appium session
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("Android Device")
                .setUdid(udid)
                .setAutomationName("UiAutomator2")
                .setAppWaitActivity("*")
                .setAppPackage("com.monefy.app.lite")
                .setAppWaitDuration(java.time.Duration.ofSeconds(10));


        String appiumHost = System.getenv("APPIUM_HOST");
        if (appiumHost == null || appiumHost.isEmpty()) {
            appiumHost = "http://127.0.0.1:4723"; // local fallback
        }
        driver = new AppiumDriver(new URL(appiumHost), options);
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}