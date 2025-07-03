package Pages.ExpensePage;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.KeypadUtils;

import java.time.Duration;

public class ExpensePage extends BaseTest {

    public ExpensePage(AppiumDriver driver) {
        this.driver = driver;
    }

    private final String amountInput = "com.monefy.app.lite:id/amount_text";
    private final String noteInput = "com.monefy.app.lite:id/textViewNote";
    private final String chooseCategoryButton = "com.monefy.app.lite:id/keyboard_action_button";
    private final String expenseScreenTitle = "//android.widget.TextView[@text=\"New expense\"]";
    private final String houseCategory ="//android.widget.TextView[@resource-id=\"com.monefy.app.lite:id/textCategoryName\" and @text=\"House\"]";

    public String getScreenTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        WebElement screenTitleElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(expenseScreenTitle)));
        return screenTitleElement.getText();
    }
    public void enterAmount(String amount) {
        String buttonIdPrefix = "com.monefy.app.lite:id/buttonKeyboard";
        KeypadUtils.enterAmount(driver, amount, buttonIdPrefix);
    }

    public void enterNote(String note) {
        driver.findElement(By.id(noteInput)).sendKeys(note);
    }

    public void clickChooseCategory() {
        driver.findElement(By.id(chooseCategoryButton)).click();
    }

    public void selectHouseCategory() {
        driver.findElement(By.xpath(houseCategory)).click();
    }
    public void selectCategoryByName(String categoryName) {
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.monefy.app.lite:id/textCategoryName' and @text='" + categoryName + "']")).click();
    }
}
