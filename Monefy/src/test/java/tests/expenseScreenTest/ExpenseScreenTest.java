package tests.expenseScreenTest;

import Base.BaseTest;
import Pages.HomePage.HomePage;
import Pages.ExpensePage.ExpensePage;
import models.expense.Expense;
import models.expense.ExpenseDataWrapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.JsonDataReader;
import utils.NumberUtils;

public class ExpenseScreenTest extends BaseTest {

    @Test
    public void addExpenseTest() {

        // Read wrapper
        String path = "src/test/java/resources/data/expenseTestData.json";
        ExpenseDataWrapper dataWrapper = JsonDataReader.readJson(path, ExpenseDataWrapper.class);

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert= new SoftAssert();

        // Read initial amounts from UI
        double originalIncome = Double.parseDouble(
                homePage.getIncomeAmount().replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));
        double originalExpense = Double.parseDouble(
                homePage.getExpenseAmount().replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));
        double originalBalance = Double.parseDouble(
                homePage.getBalanceAmount().replace("Balance ", "").replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));

        double updatedExpense = originalExpense;
        double updatedBalance = originalBalance;

        for (Expense expense : dataWrapper.getExpensesToAdd()) {
            // Step 1: Click on Expense button
            Assert.assertTrue(homePage.isExpenseButtonDisplayed());
            Assert.assertTrue(homePage.isExpenseButtonEnabled());
            Assert.assertEquals(homePage.getExpenseButtonText(), "EXPENSE");
            homePage.clickExpenseButton();

            ExpensePage expensePage = new ExpensePage(driver);
            Assert.assertEquals(expensePage.getScreenTitle(), "New expense");

            // Step 2: Enter expense amount
            expensePage.enterAmount(expense.getAmount());

            // Step 3: Enter note
            expensePage.enterNote(expense.getNote());

            // Step 4: Click choose category
            expensePage.clickChooseCategory();

            // Step 5: Select category dynamically (implement this method)
            expensePage.selectCategoryByName(expense.getCategory());

            // Update expected values
            double expenseAmount = Double.parseDouble(expense.getAmount());
            updatedExpense += expenseAmount;
            updatedBalance = originalIncome - updatedExpense;

            // Wait for balance update if needed
            homePage.waitForBalanceToBe(NumberUtils.formatAsCurrency(updatedBalance));

            // Step 6: Validations on home page after each expense
            Assert.assertEquals(homePage.getExpenseAmount(), NumberUtils.formatAsCurrency(updatedExpense), "Expense not updated correctly.");
            Assert.assertEquals(homePage.getIncomeAmount(), NumberUtils.formatAsCurrency(originalIncome), "Income should not change.");
            Assert.assertEquals(homePage.getBalanceAmount(), "Balance " + NumberUtils.formatAsCurrency(updatedBalance), "Balance not updated correctly.");
        }

        softAssert.assertAll();
    }
}
