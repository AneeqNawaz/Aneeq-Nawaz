package models.expense;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExpenseDataWrapper {

    @JsonProperty("expensesToAdd")
    private List<Expense> expensesToAdd;

    public ExpenseDataWrapper() {}

    public List<Expense> getExpensesToAdd() {
        return expensesToAdd;
    }

    public void setExpensesToAdd(List<Expense> expensesToAdd) {
        this.expensesToAdd = expensesToAdd;
    }
}
