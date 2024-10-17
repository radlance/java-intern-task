package com.radlance.javainterntask;

import com.radlance.javainterntask.dto.EmployeeDto;
import com.radlance.javainterntask.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer {
    private final EmployeeService employeeService;
    private static final List<EmployeeDto> employees = List.of(
            new EmployeeDto(null, "John", "Doe", LocalDate.of(1990, 5, 15), "IT", 50000.00),
            new EmployeeDto(null, "Jane", "Smith", LocalDate.of(1985, 8, 22), "HR", 60000.00),
            new EmployeeDto(null, "Robert", "Johnson", LocalDate.of(1992, 12, 3), "Finance", 70000.00),
            new EmployeeDto(null, "Emily", "Brown", LocalDate.of(1988, 3, 18), "Marketing", 55000.00),
            new EmployeeDto(null, "Michael", "Wilson", LocalDate.of(1995, 9, 7), "IT", 52000.00),
            new EmployeeDto(null, "Sarah", "Davis", LocalDate.of(1989, 11, 29), "HR", 62000.00)
    );

    @Autowired
    public DataInitializer(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void init() {
        if (employeeService.getAll().isEmpty()) {
            employeeService.saveAll(employees);
        }
    }
}
