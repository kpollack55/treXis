package com.example.trexis;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long employeeId;
    private String name;
    private double allocation;
    private String departmentName;
    private String positionTitle;
    private long directReport;

    public Employee(String name, double allocation, String departmentName, String positionTitle, long directReport) {
        this.name = name;
        this.allocation = allocation;
        this.departmentName = departmentName;
        this.positionTitle = positionTitle;
        this.directReport = directReport;
    }

    public Employee() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public long getDirectReport() {
        return directReport;
    }

    public void setDirectReport(long directReports) {
        this.directReport = directReports;
    }

}
