package Pages.WelcomePage;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PermissionPopupPage extends BaseTest {

    public PermissionPopupPage(AppiumDriver driver) {
        this.driver = driver;
    }

    String icon = "com.android.permissioncontroller:id/permission_icon";
    String message = "com.android.permissioncontroller:id/permission_message";
    String allowBtn = "com.android.permissioncontroller:id/permission_allow_button";
    String denyBtn = "com.android.permissioncontroller:id/permission_deny_button";

    public boolean isPopupDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(200));
            WebElement allowBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(allowBtn)));
            return allowBtnElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean verifyPopupContent() {
        return driver.findElement(AppiumBy.id(icon)).isDisplayed()
                && driver.findElement(AppiumBy.id(message)).isDisplayed()
                && driver.findElement(AppiumBy.id(allowBtn)).isDisplayed()
                && driver.findElement(AppiumBy.id(denyBtn)).isDisplayed();

    }
    public String getMessageText() {
        return driver.findElement(AppiumBy.id(message)).getText();
    }
    public String getAllowBtnText() {
        return driver.findElement(AppiumBy.id(allowBtn)).getText();
    }
    public String getDenyBtnText() {
        return driver.findElement(AppiumBy.id(denyBtn)).getText();
    }

    public void respondToPopup(String response) {
        if (response.equalsIgnoreCase("allow")) {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        } else {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
        }
    }
}
