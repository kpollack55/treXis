package com.example.trexis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabasePopExpenseAllocation implements CommandLineRunner {
    private ExpenseAllocationRepository expenseAllocationRepository;

    @Autowired
    public DatabasePopExpenseAllocation(ExpenseAllocationRepository expenseAllocationRepository) {this.expenseAllocationRepository = expenseAllocationRepository; }

    @Override
    public void run(String... strings) throws Exception {
        List<ExpenseAllocation> el = new ArrayList<>();

        el.add(new ExpenseAllocation(0l, 1l, 600.00, "IT", true));
        el.add(new ExpenseAllocation(1l, 2l, 600.00, "IT", true));
        el.add(new ExpenseAllocation(2l, 7l, 2000.00, "IT", false));
        el.add(new ExpenseAllocation(2l, 8l, 1000.00, "IT", false));

        el.add(new ExpenseAllocation(0l, 3l, 600.00, "IT", true));
        el.add(new ExpenseAllocation(3l, 4l, 600.00, "IT", false));

        el.add(new ExpenseAllocation(0l, 5l, 600.00, "IT", true));
        el.add(new ExpenseAllocation(5l, 6l, 2000.00, "IT", false));

        expenseAllocationRepository.saveAll(el);

    }
}
