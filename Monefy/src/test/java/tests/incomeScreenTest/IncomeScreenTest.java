package tests.incomeScreenTest;

import Base.BaseTest;
import Pages.HomePage.HomePage;
import Pages.IncomePage.IncomePage;
import models.income.Income;
import models.income.IncomeDataWrapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DateUtils;
import utils.JsonDataReader;
import utils.NumberUtils;

public class IncomeScreenTest extends BaseTest {

    @Test
    public void addIncomeTest() {

        String path = "src/test/java/resources/data/incomeTestData.json";
        // Read the wrapper
        IncomeDataWrapper dataWrapper = JsonDataReader.readJson(path, IncomeDataWrapper.class);
        // Extract the Income object
        Income data = dataWrapper.getIncomeTestData();

        HomePage homePage = new HomePage(driver);
        SoftAssert softAssert= new SoftAssert();

        // Set currency symbol once by extracting from home page income amount text
        String currencySymbol = homePage.extractCurrencySymbol();
        NumberUtils.setCurrencySymbol(currencySymbol);

        // Step 1: verify month
        softAssert.assertEquals(homePage.getMonthText(), DateUtils.getCurrentMonth());

        // Step 2: verify initial amounts formatted with currency symbol
        Assert.assertEquals(homePage.getIncomeAmount(), NumberUtils.formatAsCurrency(Double.parseDouble(data.getDefaultIncomeValue())));
        Assert.assertEquals(homePage.getExpenseAmount(), NumberUtils.formatAsCurrency(Double.parseDouble(data.getDefaultExpenseValue())));
        Assert.assertEquals(homePage.getBalanceAmount(), "Balance " + NumberUtils.formatAsCurrency(Double.parseDouble(data.getDefaultBalanceValue())));

        // Step 3: verify income button state and click
        Assert.assertTrue(homePage.isIncomeButtonDisplayed());
        Assert.assertTrue(homePage.isIncomeButtonEnabled());
        Assert.assertEquals(homePage.getIncomeButtonText(), "INCOME");
        homePage.clickIncomeButton();

        // Income Page verification and input
        IncomePage incomePage = new IncomePage(driver);
        Assert.assertEquals(incomePage.getScreenTitle(), "New income");
        Assert.assertEquals(incomePage.getDateText(), DateUtils.getFormattedCurrentDate());

        incomePage.enterAmount(data.getIncomeSalary());
        incomePage.enterNote(data.getIncomeSalaryNote());
        incomePage.chooseSalaryCategory();

        // Calculate updated income and balance
        double previousIncome = Double.parseDouble(data.getDefaultIncomeValue());
        double addedIncome = Double.parseDouble(data.getIncomeSalary());
        double updatedIncome = previousIncome + addedIncome;

        double previousBalance = Double.parseDouble(data.getDefaultBalanceValue());
        double updatedBalance = previousBalance + addedIncome;

        // Validate updated values on home page
        Assert.assertEquals(homePage.getIncomeAmount(), NumberUtils.formatAsCurrency(updatedIncome));
        Assert.assertEquals(homePage.getExpenseAmount(), NumberUtils.formatAsCurrency(Double.parseDouble(data.getDefaultExpenseValue())));
        Assert.assertEquals(homePage.getBalanceAmount(), "Balance " + NumberUtils.formatAsCurrency(updatedBalance));

        softAssert.assertAll();
    }
}
