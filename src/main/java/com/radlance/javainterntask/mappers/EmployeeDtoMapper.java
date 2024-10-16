package com.radlance.javainterntask.mappers;

import com.radlance.javainterntask.database.entity.Employee;
import com.radlance.javainterntask.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoMapper implements Mapper<Employee, EmployeeDto> {
    @Override
    public EmployeeDto map(Employee object) {
        return new EmployeeDto(
                object.getId(),
                object.getFirstName(),
                object.getLastName(),
                object.getBirthDate(),
                object.getDepartment(),
                object.getSalary()
        );
    }
}
