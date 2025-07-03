package utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;

public class KeypadUtils {
    public static void enterAmount(AppiumDriver driver, String amount, String buttonIdPrefix) {
        for (char digit : amount.toCharArray()) {
            String buttonId = buttonIdPrefix + digit;
            driver.findElement(AppiumBy.id(buttonId)).click();
        }
    }
}
