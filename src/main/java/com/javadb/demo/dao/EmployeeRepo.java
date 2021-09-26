package com.javadb.demo.dao;

import java.util.List;

import com.javadb.demo.model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
    public Employee findByFirstName(String firstName);
    public List<Employee> findByLastName(String lastName);
}
