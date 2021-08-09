package com.example.trexis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class AllocationService {
    private EmployeeRepository employeeRepository;
    private ExpenseAllocationRepository expenseAllocationRepository;

    @Autowired
    public AllocationService(EmployeeRepository employeeRepository, ExpenseAllocationRepository expenseAllocationRepository) {
        this.employeeRepository = employeeRepository;
        this.expenseAllocationRepository = expenseAllocationRepository;
    }

    public AllocationService() {}

    public List<Manager> findNoDirectReports() {
        List<Manager> managerList = employeeRepository.findNoDirectReports();
        return managerList;
    }

    public double totalMonthExpenseByDepartment(String department) {
        double totalMonthlyDepartmentExpenses = employeeRepository.totalMonthlyExpenseInDepartment(department);
        return totalMonthlyDepartmentExpenses;
    }

    public double managerTotalAllocation(Manager manger) {
        double totalAllocation = manger.getAllocation();
        Queue<Long> idList = new LinkedList<Long>();
        List<ExpenseAllocation> totalExpenseList =  expenseAllocationRepository.getManagerDirectReports(manger.getEmployeeId());

        for (int i = 0; i<totalExpenseList.size(); i++) {
            totalAllocation +=  totalExpenseList.get(i).getAllocation();
            if (totalExpenseList.get(i).isHasDirectReports() == true) {
                idList.add(totalExpenseList.get(i).getSubordinateId());
            }
            totalExpenseList.remove(i);
            i--;
        }

        while(!idList.isEmpty()) {
            for(int i = 0; i<idList.size(); i++) {
                List<ExpenseAllocation> totalExpenseList2 = expenseAllocationRepository.getManagerDirectReports(idList.poll());
                totalExpenseList.addAll(totalExpenseList2);
            }

            for(int i = 0; i<totalExpenseList.size(); i++) {
                totalAllocation += totalExpenseList.get(i).getAllocation();
                if (totalExpenseList.get(i).isHasDirectReports() == true) {
                    idList.add(totalExpenseList.get(i).getSubordinateId());
                }
                totalExpenseList.remove(i);
                i--;
            }

        }

        return totalAllocation;
    }

    public Manager getManager(long id) {
        return employeeRepository.findByEmployeeId(id);
    }

}
