package Pages.HomePage;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTest {

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    private final String monthTextXpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.monefy.app.lite:id/pts_main']//android.widget.TextView";
    private final String incomeAmountId = "com.monefy.app.lite:id/income_amount_text";
    private final String expenseAmountId = "com.monefy.app.lite:id/expense_amount_text";
    private final String balanceAmountId = "com.monefy.app.lite:id/balance_amount";
    private final String incomeButtonId = "com.monefy.app.lite:id/income_button_title";
    private final String expenseButtonId = "com.monefy.app.lite:id/expense_button_title";
    private final String leftbalanceIcon = "com.monefy.app.lite:id/rightLinesImageView";

    // Actions / Getters

    public String getMonthText() {
        return driver.findElement(AppiumBy.xpath(monthTextXpath)).getText();
    }

    public void waitForBalanceToBe(String expectedAmount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                AppiumBy.id(balanceAmountId), expectedAmount
        ));
    }

    public String getIncomeAmount() {
        return driver.findElement(AppiumBy.id(incomeAmountId)).getText();
    }

    public String extractCurrencySymbol() {
        String incomeText = getIncomeAmount();  // e.g. "$0.00" or "€0.00"
        for (char c : incomeText.toCharArray()) {
            if (!Character.isDigit(c) && c != '.' && c != ',' && c != ' ' && c != '-') {
                return String.valueOf(c);
            }
        }
        return "$"; // default fallback
    }

    public String getExpenseAmount() {
        return driver.findElement(AppiumBy.id(expenseAmountId)).getText();
    }

    public String getBalanceAmount() {
        return driver.findElement(AppiumBy.id(balanceAmountId)).getText();
    }

    public void clickBalanceButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(200));
        WebElement balanceButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(leftbalanceIcon)));
        balanceButtonElement.click();
    }

    public String getIncomeButtonText() {
        return driver.findElement(AppiumBy.id(incomeButtonId)).getText();
    }
    public String getExpenseButtonText() {
        return driver.findElement(AppiumBy.id(expenseButtonId)).getText();
    }

    public boolean isIncomeButtonDisplayed() {
        return driver.findElement(AppiumBy.id(incomeButtonId)).isDisplayed();
    }
    public boolean isExpenseButtonDisplayed() {
        return driver.findElement(AppiumBy.id(expenseButtonId)).isDisplayed();
    }

    public boolean isIncomeButtonEnabled() {
        return driver.findElement(AppiumBy.id(incomeButtonId)).isEnabled();
    }
    public boolean isExpenseButtonEnabled() {
        return driver.findElement(AppiumBy.id(expenseButtonId)).isEnabled();
    }

    public void clickIncomeButton() {
        driver.findElement(AppiumBy.id(incomeButtonId)).click();
    }

    public void clickExpenseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(700));
        WebElement expenseButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(expenseButtonId)));
        expenseButtonElement.click();
    }
}
