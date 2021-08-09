package com.example.trexis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabasePop implements CommandLineRunner {
    private EmployeeRepository employeeRepository;

    @Autowired
    public DatabasePop(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Employee> al = new ArrayList<>();

        al.add(new Manager("John", 600,"IT", "Manager", 0, new BigDecimal("0"), true));
        al.add(new Manager("Max", 600, "IT", "Manager", 1, new BigDecimal("0"), true));
        al.add(new Manager("Kathy", 600,"IT", "Manager", 0, new BigDecimal("0"), true));
        al.add(new Manager("Olga", 600, "IT", "Manager", 3, new BigDecimal("0"), false));
        al.add(new Manager("Ellen", 600, "IT", "Manager", 0, new BigDecimal("0"), true));
        al.add(new Employee("Jane", 2000, "IT","Developer", 5));
        al.add(new Employee("Kyle", 2000, "IT", "Developer", 2));
        al.add(new Employee("Paul", 1000, "IT", "QATester", 2));
        al.add(new Employee("Spiddster", 1000, "Marketing", "SEO", 2));

        employeeRepository.saveAll(al);
    }
}
