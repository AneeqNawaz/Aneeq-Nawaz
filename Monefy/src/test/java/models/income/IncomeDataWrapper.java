package models.income;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeDataWrapper {

    @JsonProperty("IncomeTestData")
    private Income IncomeTestData;

    public Income getIncomeTestData() {
        return IncomeTestData;
    }

    public void setIncomeTestData(Income IncomeTestData) {
        this.IncomeTestData = IncomeTestData;
    }
}
