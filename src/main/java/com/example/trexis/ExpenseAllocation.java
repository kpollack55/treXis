package com.example.trexis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExpenseAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long expenseAllocationId;
    private long managerId;
    private long subordinateId;
    private double allocation;
    private String departmentName;
    private boolean hasDirectReports;

    public ExpenseAllocation(long managerId, long subordinateId, double allocation, String departmentName, boolean hasDirectReports) {
        this.managerId = managerId;
        this.subordinateId = subordinateId;
        this.allocation = allocation;
        this.departmentName = departmentName;
        this.hasDirectReports = hasDirectReports;
    }

    public ExpenseAllocation() {

    }

    public long getExpenseAllocationId() {
        return expenseAllocationId;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public long getSubordinateId() {
        return subordinateId;
    }

    public void setSubordinateId(long subordinateId) {
        this.subordinateId = subordinateId;
    }

    public double getAllocation() {
        return allocation;
    }

    public void setAllocation(double allocation) {
        this.allocation = allocation;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isHasDirectReports() {
        return hasDirectReports;
    }

    public void setHasDirectReports(boolean hasDirectReports) {
        this.hasDirectReports = hasDirectReports;
    }

}
