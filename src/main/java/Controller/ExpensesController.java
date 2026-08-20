package Controller;

import Model.Expense;
import Service.ExpensesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")

public class ExpensesController {
    private final ExpensesService expenseService;

    @PostMapping
    public Expense save(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }
}
