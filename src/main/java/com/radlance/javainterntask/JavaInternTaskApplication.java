package com.radlance.javainterntask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class JavaInternTaskApplication implements CommandLineRunner {

    private final EmployeeServiceConsoleWrapper employeeServiceConsoleWrapper;

    public static void main(String[] args) {
        SpringApplication.run(JavaInternTaskApplication.class, args);
    }

    @Autowired
    public JavaInternTaskApplication(EmployeeServiceConsoleWrapper employeeServiceConsoleWrapper) {
        this.employeeServiceConsoleWrapper = employeeServiceConsoleWrapper;
    }

    @Override
    public void run(String... args) {
        employeeServiceConsoleWrapper.printEmployeeInfoById(1);
        employeeServiceConsoleWrapper.printEmployeeInfoById(-1);

        employeeServiceConsoleWrapper.printGroupedNameInfo();

        employeeServiceConsoleWrapper.printEmployeeInfoBornBetweenDates(
                LocalDate.of(1990, 1, 1),
                LocalDate.of(1992, 12, 31)
        );
    }
}
