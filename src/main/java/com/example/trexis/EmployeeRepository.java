package com.example.trexis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Manager findByEmployeeId(Long id);

    @Query("select m from Manager m where m.hasDirectReports = false")
    List<Manager> findNoDirectReports();

    @Query("select SUM(e.allocation) from Employee e where e.departmentName = ?1")
    double totalMonthlyExpenseInDepartment(String departmentName);
}
