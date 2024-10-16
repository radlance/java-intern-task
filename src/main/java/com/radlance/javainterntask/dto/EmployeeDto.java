package com.radlance.javainterntask.dto;

import java.time.LocalDate;

public record EmployeeDto(
    Integer id,
    String firstName,
    String lastName,
    LocalDate birthDate,
    String department,
    Double salary
) {

}
