package com.javadb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
  	public void run(String... args) throws Exception {

		repo.deleteAll();
		repo.save(new Employee("Kris", "Cotten"));
		repo.save(new Employee("Jane", "Doe"));

		System.out.println("Employees found with findAll():");
		System.out.println("-------------------------------");
		for (Employee employee : repo.findAll()) {
			System.out.println(employee);
		}
		System.out.println();
	
		System.out.println("Employee found with findByFirstName('Kris'):");
		System.out.println("--------------------------------");
		System.out.println(repo.findByFirstName("Kris"));
	
		System.out.println("Employees found with findByLastName('Doe'):");
		System.out.println("--------------------------------");
		for (Employee employee : repo.findByLastName("Doe")) {
			System.out.println(employee);
		}
  	}
}
