package com.radlance.javainterntask.service;

import com.radlance.javainterntask.database.repository.EmployeeRepository;
import com.radlance.javainterntask.dto.EmployeeDto;
import com.radlance.javainterntask.mappers.EmployeeDtoMapper;
import com.radlance.javainterntask.mappers.EmployeeEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoMapper employeeDtoMapper;
    private final EmployeeEntityMapper employeeEntityMapper;

    @Autowired
    public EmployeeService(
            EmployeeRepository employeeRepository,
            EmployeeDtoMapper employeeDtoMapper,
            EmployeeEntityMapper employeeEntityMapper
    ) {
        this.employeeRepository = employeeRepository;
        this.employeeDtoMapper = employeeDtoMapper;
        this.employeeEntityMapper = employeeEntityMapper;
    }

    public EmployeeDto findById(Integer id) {
        return employeeRepository.findById(id).map(employeeDtoMapper::map).orElseThrow(
                () -> new EntityNotFoundException("user with id: " + id + " not found")
        );
    }

    public List<String> groupByName() {
        return employeeRepository.groupByName();
    }

    public List<EmployeeDto> findBetween(LocalDate startDate, LocalDate endDate) {
        return employeeRepository
                .findBetween(startDate, endDate)
                .stream()
                .map(employeeDtoMapper::map)
                .toList();
    }

    @Transactional
    public void saveAll(List<EmployeeDto> employees) {
        employeeRepository.saveAll(employees.stream().map(employeeEntityMapper::map).toList());
    }

    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll().stream().map(employeeDtoMapper::map).toList();
    }
}