package Service;

import Model.Expense;
import Repository.ExpensesRepository;

import java.util.List;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
    @Service
    public class ExpensesService {
        private final ExpensesRepository expensesRepository;

        public ExpensesService(ExpensesRepository expenseRepository, ExpensesRepository expensesRepository) {
            this.expensesRepository = expenseRepository;
        }

        public Expense save(Expense expense) {
            return expensesRepository.save(expense);
        }
    }

