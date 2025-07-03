package Pages.IncomePage;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.KeypadUtils;

import java.time.Duration;

public class IncomePage extends BaseTest {

    public IncomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    private final String incomescreenTitle = "//android.widget.TextView[@text=\"New income\"]";
    private final String dateTextId = "com.monefy.app.lite:id/textViewDate";
    private final String buttonIdPrefix = "com.monefy.app.lite:id/buttonKeyboard";
    private final String noteFieldId = "com.monefy.app.lite:id/textViewNote";
    private final String chooseCategoryButtonId = "com.monefy.app.lite:id/keyboard_action_button";
    private final String salaryCategoryXpath = "//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/textCategoryName\" and @text=\"Salary\"]";

    // Actions / Getters

    public String getScreenTitle() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        WebElement screenTitleElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(incomescreenTitle)));
        return screenTitleElement.getText();
    }

    public String getDateText() {
        return driver.findElement(AppiumBy.id(dateTextId)).getText();
    }

    public void enterAmount(String amount) {
        KeypadUtils.enterAmount(driver, amount, buttonIdPrefix);
    }

    public void enterNote(String note) {
        driver.findElement(AppiumBy.id(noteFieldId)).sendKeys(note);
    }

    public void chooseSalaryCategory() {
        driver.findElement(AppiumBy.id(chooseCategoryButtonId)).click();
        driver.findElement(AppiumBy.xpath(salaryCategoryXpath)).click();
    }
}
