package com.javadb.demo.controller;

import com.javadb.demo.model.*;
import com.javadb.demo.dao.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    
    private final EmployeeDao employeeDao;
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeDao.insertEmployeeData(employee);
    }

    @GetMapping
    public Collection<Employee> read() {
        return employeeDao.getAllEmployeeInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<Employee> readQueryUsingId(@PathVariable("id") String id) {
        return employeeDao.getEmployeeInformationById(id);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody Employee employee ) {
        employeeDao.updateEmployeeUsingId(id, employee);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") String id){
        employeeDao.deleteEmployeeUsingId(id);
    }
}
