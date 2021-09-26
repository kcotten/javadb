package com.javadb.demo.dao;

import com.javadb.demo.model.*;
import java.util.Collection;
import org.springframework.stereotype.Component;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class EmployeeDao {
    private final EmployeeRepo employeeRepo;

    public EmployeeDao(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee insertEmployeeData(Employee employee) {
        return employeeRepo.insert(employee);
    }

    public Collection<Employee> getAllEmployeeInformation() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeInformationById(String id) {
        return employeeRepo.findById(id);
    }

    public Employee updateEmployeeUsingId(String id, Employee employee) {
        Optional<Employee> findEmployeeQuery = employeeRepo.findById(id);
        if (findEmployeeQuery.isPresent()) {
            Employee employeeValues = findEmployeeQuery.get();
            employeeValues.setId(id);
            employeeValues.setFirstName(employee.getFirstName());
            employeeValues.setLastName(employee.getLastName());
            return employeeRepo.save(employeeValues);
        } else {
            return new Employee("NOT", "FOUND");
        }
        
    }

    public void deleteEmployeeUsingId(String id) {
        try {
            employeeRepo.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
