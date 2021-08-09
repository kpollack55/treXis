package com.example.trexis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseAllocationRepository extends JpaRepository<ExpenseAllocation, Long> {
    List<ExpenseAllocation> findByExpenseAllocationId(Long id);

    @Query("select SUM(ea.allocation) from ExpenseAllocation ea where ea.managerId = ?1")
    BigDecimal managerMonthlyExpenseAllocation(long id);

    @Query("SELECT ea from ExpenseAllocation ea WHERE ea.managerId = ?1")
    List<ExpenseAllocation> getManagerDirectReports(long id);

}
