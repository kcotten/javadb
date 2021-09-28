package com.javadb.demo;

import com.javadb.demo.controller.EmployeeController;
import com.javadb.demo.dao.EmployeeRepo;
import com.javadb.demo.model.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

	@Autowired
	private EmployeeController controller;

	@Test
	public void contextLoads() throws Exception {
		assert(controller != null);
	}

	@Test
    public void testReadWrite(@Autowired MongoTemplate mongoTemplate) {
        // given
        Employee emp = new Employee("FirstName", "LastName");

        // when
        Employee ret = mongoTemplate.save(emp, "collection");

        // then
        assert(mongoTemplate.findAll(Employee.class, "collection").get(0).equals(ret));
    }
}
