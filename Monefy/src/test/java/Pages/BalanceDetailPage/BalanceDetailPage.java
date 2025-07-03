package Pages.BalanceDetailPage;

import Base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.KeypadUtils;
import utils.NumberUtils;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class BalanceDetailPage extends BaseTest {

    public BalanceDetailPage(AppiumDriver driver) {
        this.driver = driver;
    }
    private final String categoryNameXpath = "//android.widget.TextView[@resource-id='com.monefy.app.lite:id/textViewCategoryName' and @text='%s']";
    private final String transactionAmountId = "com.monefy.app.lite:id/textViewTransactionAmount";
    private final String transactionNoteId = "com.monefy.app.lite:id/textViewTransactionNote";
    private final String transactionNoteXpath = "//android.widget.TextView[@resource-id='com.monefy.app.lite:id/textViewTransactionNote' and @text='%s']";
    private final String deleteIconId = "com.monefy.app.lite:id/delete";
    private final String homeButtonId = "com.monefy.app.lite:id/leftLinesImageView";
    private final String settingsTextId = "com.monefy.app.lite:id/settings_textview";
    private final String settingsCloseButtonXpath = "//android.widget.Button[@content-desc='Settings']";
    private final String editAmountFieldId = "com.monefy.app.lite:id/amount_text";
    private final String fieldClearIconId = "com.monefy.app.lite:id/buttonKeyboardClear";
    private final String chooseCategoryButtonId = "com.monefy.app.lite:id/keyboard_action_button";
    private final String salaryCategoryXpath = "//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/textCategoryName\" and @text=\"Salary\"]";
    private final String buttonIdPrefix = "com.monefy.app.lite:id/buttonKeyboard";



    // ======================
    // Page Methods

    public void editIncomeByNote(String noteText, int updatedAmount) {
        WebElement noteElement = driver.findElement(By.xpath(String.format(transactionNoteXpath, noteText)));
        noteElement.click();
        WebElement amountField = driver.findElement(By.id(editAmountFieldId));

        WebElement removeKey = driver.findElement(By.id(fieldClearIconId)); // Replace with actual ID

        Point location = removeKey.getLocation();
        int centerX = location.getX() + (removeKey.getSize().getWidth() / 2);
        int centerY = location.getY() + (removeKey.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);

        longPress.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), centerX, centerY));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(finger, Duration.ofSeconds(2))); // Hold for 2 seconds
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(longPress));


        KeypadUtils.enterAmount(driver, String.valueOf(updatedAmount), buttonIdPrefix);
        driver.findElement(By.id(chooseCategoryButtonId)).click();
        driver.findElement(By.xpath(salaryCategoryXpath)).click();
    }

    public void selectCategoryByName(String categoryName) {
        closeSettingsIfDisplayed();
        driver.findElement(By.xpath(String.format(categoryNameXpath, categoryName))).click();
    }

    public int getTransactionListCount() {
        List<WebElement> transactions = driver.findElements(By.id(transactionNoteId));
        return transactions.size();
    }
    public double getOldAmount() {
        String amountText = driver.findElement(By.id(transactionAmountId)).getText();
        return Double.parseDouble(amountText.replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));
    }
    public void deleteExpenseByNote(String noteText) {

        // Step 1: Tap on the transaction note to bring delete options
        tapTransactionNote(noteText);
        // Step 2: Click delete icon
        clickDeleteIcon();
    }

    public void closeSettingsIfDisplayed() {
        List<WebElement> settingText = driver.findElements(By.id(settingsTextId));
        if (!settingText.isEmpty() && settingText.get(0).isDisplayed()) {
            List<WebElement> closeButtons = driver.findElements(By.xpath(settingsCloseButtonXpath));
            if (!closeButtons.isEmpty() && closeButtons.get(0).isDisplayed()) {
                closeButtons.get(0).click();
            }
        }
    }

    public void tapTransactionNote(String noteText) {
        WebElement noteElement = driver.findElement(By.xpath(String.format(transactionNoteXpath, noteText)));
        noteElement.click();
    }

    public void clickDeleteIcon() {
        driver.findElement(By.id(deleteIconId)).click();
    }

    public void clickHomeButton() {
        driver.findElement(By.id(homeButtonId)).click();
    }

}
