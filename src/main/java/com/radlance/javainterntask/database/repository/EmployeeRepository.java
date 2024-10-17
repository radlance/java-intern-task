package com.radlance.javainterntask.database.repository;

import com.radlance.javainterntask.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT first_name FROM employee GROUP BY first_name ORDER BY first_name", nativeQuery = true)
    List<String> groupByName();

    @Query(value = "SELECT * FROM employee WHERE birth_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Employee> findBetween(LocalDate startDate, LocalDate endDate);
}
