package com.radlance.javainterntask.mappers;

import com.radlance.javainterntask.database.entity.Employee;
import com.radlance.javainterntask.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityMapper implements Mapper<EmployeeDto, Employee> {
    @Override
    public Employee map(EmployeeDto object) {
        return new Employee(
                object.getId(),
                object.getFirstName(),
                object.getLastName(),
                object.getBirthDate(),
                object.getDepartment(),
                object.getSalary()

        );
    }
}
