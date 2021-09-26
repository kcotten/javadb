package com.javadb.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {
    @Id
    public String id;
  
    private String firstName;
    private String lastName;
  
    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public Employee() {}
  
    public Employee(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }
  
    @Override
    public String toString() {
      return String.format(
          "Employee[id=%s, firstName='%s', lastName='%s']",
          id, firstName, lastName);
    }
}
