package models.income;

public class Income {

    private String defaultMonth;
    private String currentDate;
    private String defaultIncomeValue;
    private String defaultExpenseValue;
    private String defaultBalanceValue;
    private String incomeSalary;
    private String incomeSalaryNote;

    // Getters and setters
    public String getDefaultMonth() {
        return defaultMonth;
    }

    public void setDefaultMonth(String defaultMonth) {
        this.defaultMonth = defaultMonth;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getDefaultIncomeValue() {
        return defaultIncomeValue;
    }

    public void setDefaultIncomeValue(String defaultIncomeValue) {
        this.defaultIncomeValue = defaultIncomeValue;
    }

    public String getDefaultExpenseValue() {
        return defaultExpenseValue;
    }

    public void setDefaultExpenseValue(String defaultExpenseValue) {
        this.defaultExpenseValue = defaultExpenseValue;
    }

    public String getDefaultBalanceValue() {
        return defaultBalanceValue;
    }

    public void setDefaultBalanceValue(String defaultBalanceValue) {
        this.defaultBalanceValue = defaultBalanceValue;
    }

    public String getIncomeSalary() {
        return incomeSalary;
    }

    public void setAmount(String incomeSalary) {
        this.incomeSalary = incomeSalary;
    }

    public String getIncomeSalaryNote() {
        return incomeSalaryNote;
    }

    public void setNote(String incomeSalaryNote) {
        this.incomeSalaryNote = incomeSalaryNote;
    }
}
