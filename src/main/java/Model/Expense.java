package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expense extends CashFlow{
    private String reason;
    private ExpenseFrequency expenseFrequency;
}
