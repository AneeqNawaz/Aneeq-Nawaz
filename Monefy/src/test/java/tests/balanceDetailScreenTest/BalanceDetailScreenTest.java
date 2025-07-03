package tests.balanceDetailScreenTest;

import Base.BaseTest;
import Pages.BalanceDetailPage.BalanceDetailPage;
import Pages.HomePage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.NumberUtils;

import java.util.Random;

public class BalanceDetailScreenTest extends BaseTest {

    @Test(priority = 1)
    public void editIncomeTest() {
        HomePage homePage = new HomePage(driver);

        // Step 1: Capture original amounts from HomePage
        double originalIncome = Double.parseDouble(
                homePage.getIncomeAmount().replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));
        double originalExpense = Double.parseDouble(
                homePage.getExpenseAmount().replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));
        double originalBalance = Double.parseDouble(
                homePage.getBalanceAmount().replace("Balance ", "").replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));

        // Step 2: Navigate to balance details
        homePage.clickBalanceButton();

        BalanceDetailPage balanceDetailPage = new BalanceDetailPage(driver);

        balanceDetailPage.selectCategoryByName("Salary"); // replace if needed
        double oldIncomeValue = balanceDetailPage.getOldAmount();


        // Step 3: Tap income note and edit the amount
        Random rand = new Random();
        int randomAddition = rand.nextInt(151) + 50;
        int newIncomeAmount= (int) (randomAddition + originalIncome);
        System.out.println("Random income added: " + randomAddition);
        balanceDetailPage.editIncomeByNote("Salary", newIncomeAmount);

        // Step 4: Verify list count remains the same
        int listCountBeforeEdit = balanceDetailPage.getTransactionListCount();
        int listCountAfterEdit = balanceDetailPage.getTransactionListCount();
        Assert.assertEquals(listCountBeforeEdit, listCountAfterEdit, "Transaction count should remain the same after edit.");

        // Step 5: Navigate back to HomePage
        balanceDetailPage.clickHomeButton();

        // Step 6: Calculate expected updated values
        double expectedIncome = originalIncome + randomAddition;
        double expectedBalance = originalBalance + randomAddition;

        // Step 7: Validate amounts on HomePage
        Assert.assertEquals(homePage.getIncomeAmount(), NumberUtils.formatAsCurrency(expectedIncome), "Income value not updated correctly after edit.");
        Assert.assertEquals(homePage.getExpenseAmount(), NumberUtils.formatAsCurrency(originalExpense), "Expense should remain unchanged after editing income.");
        Assert.assertEquals(homePage.getBalanceAmount(), "Balance " + NumberUtils.formatAsCurrency(expectedBalance), "Balance value not updated correctly after editing income.");
    }

    @Test(priority = 2)
    public void deleteExpenseTest() {
        HomePage homePage = new HomePage(driver);

        // Step 1: Capture original amounts from HomePage
        double originalIncome = Double.parseDouble(
                homePage.getIncomeAmount().replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));
        double originalExpense = Double.parseDouble(
                homePage.getExpenseAmount().replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));
        double originalBalance = Double.parseDouble(
                homePage.getBalanceAmount().replace("Balance ", "").replace(NumberUtils.getCurrencySymbol(), "").replace(",", ""));

        // Step 2: Navigate to balance details
        homePage.clickBalanceButton();

        BalanceDetailPage balanceDetailPage = new BalanceDetailPage(driver);

        balanceDetailPage.selectCategoryByName("Food");
        double deletedExpenseAmount = balanceDetailPage.getOldAmount();

        int listCountBeforeDelete = balanceDetailPage.getTransactionListCount();
        // Tap and hold on transaction note
        balanceDetailPage.deleteExpenseByNote( "Groceries");


        // Verify the transaction list is updated
        int listCountAfterDelete = balanceDetailPage.getTransactionListCount();
        Assert.assertTrue(listCountAfterDelete < listCountBeforeDelete, "Expense was not deleted successfully.");

        //  Navigate back to HomePage
        balanceDetailPage.clickHomeButton();

        //  Calculate expected expense and balance after deletion
        double expectedExpense = originalExpense - deletedExpenseAmount;
        double expectedBalance = originalBalance + deletedExpenseAmount;

        //Validate updated amounts on HomePage
        Assert.assertEquals(homePage.getExpenseAmount(), NumberUtils.formatAsCurrency(expectedExpense), "Expense value not updated correctly after deletion.");
        Assert.assertEquals(homePage.getIncomeAmount(), NumberUtils.formatAsCurrency(originalIncome), "Income should remain unchanged after deletion.");
        Assert.assertEquals(homePage.getBalanceAmount(), "Balance " + NumberUtils.formatAsCurrency(expectedBalance), "Balance value not updated correctly after deletion.");
    }
}
