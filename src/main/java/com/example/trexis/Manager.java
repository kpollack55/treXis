package com.example.trexis;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Manager extends Employee {
    private BigDecimal expenseAllocationTotal;
    private boolean hasDirectReports;

    public Manager(String name, double allocation, String departmentName, String positionTitle, long directReport, BigDecimal expenseAllocationTotal, boolean hasDirectReports) {
        super(name, allocation, departmentName, positionTitle, directReport);
        this.expenseAllocationTotal = expenseAllocationTotal;
        this.hasDirectReports = hasDirectReports;
    }

    public Manager() {

    }

    public BigDecimal getExpenseAllocationTotal() {
        return expenseAllocationTotal;
    }

    public void setExpenseAllocationTotal(BigDecimal expenseAllocationTotal) {
        this.expenseAllocationTotal = expenseAllocationTotal;
    }
    public boolean isHasDirectReports() {
        return hasDirectReports;
    }

    public void setHasDirectReports(boolean hasDirectReports) {
        this.hasDirectReports = hasDirectReports;
    }

}
