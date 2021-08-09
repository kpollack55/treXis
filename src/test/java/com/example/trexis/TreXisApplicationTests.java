package com.example.trexis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TreXisApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ExpenseAllocationRepository expenseAllocationRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testManagerTotalAllocationOne() {
        Manager manager = employeeRepository.findByEmployeeId(1l);
        AllocationService allocationService = new AllocationService(employeeRepository,expenseAllocationRepository);
        double managerTotalAllocation = allocationService.managerTotalAllocation(manager);
        assert(managerTotalAllocation == 4200.00);
    }

    @Test
    public void testManagerTotalAllocationTwo() {
        Manager manager = employeeRepository.findByEmployeeId(3l);
        AllocationService allocationService = new AllocationService(employeeRepository,expenseAllocationRepository);
        double managerTotalAllocation = allocationService.managerTotalAllocation(manager);
        assert(managerTotalAllocation == 1200.00);
    }

    @Test
    public void testManagerTotalAllocationThree() {
        Manager manager = employeeRepository.findByEmployeeId(5l);
        AllocationService allocationService = new AllocationService(employeeRepository,expenseAllocationRepository);
        double managerTotalAllocation = allocationService.managerTotalAllocation(manager);
        assert(managerTotalAllocation == 2600.00);
    }

    @Test
    public void testNoDirectReports() {
        AllocationService allocationService = new AllocationService(employeeRepository,expenseAllocationRepository);
        List<Manager> mangerNoDirectReports = allocationService.findNoDirectReports();
        assert(mangerNoDirectReports.get(0).getEmployeeId() == 4l);
    }

    @Test
    public void testTotalMonthExpenseByDepartment() {
        AllocationService allocationService = new AllocationService(employeeRepository,expenseAllocationRepository);
        double totalMonthlyDepartmentExpenses = allocationService.totalMonthExpenseByDepartment("IT");
        assert(totalMonthlyDepartmentExpenses == 8000.00);
    }

}
