package com.example.trexis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllocatioReportController {

    @Autowired
    private AllocationService allocationService;

    @RequestMapping("allocationReport")
    public String allocationReport() {
        List<Manager> mangerNoDirectReports = allocationService.findNoDirectReports();
        Manager manager = allocationService.getManager(1l);
        double managerTotalAllocation = allocationService.managerTotalAllocation(manager);
        double totalMonthlyDepartmentExpenses = allocationService.totalMonthExpenseByDepartment("IT");

        return "***Allocation Report*** Manager total allocation: " + managerTotalAllocation + " IT Departments total monthly expenses: " + totalMonthlyDepartmentExpenses + " The manager with no direct reports: " + mangerNoDirectReports.get(0).getName();
    }

}
