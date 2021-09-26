package com.javadb.demo;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		//@PropertySource String SPRING_DATA_MONGODB_HOST = System.getenv("SPRING_DATA_MONGODB_HOST");
		
		SpringApplication.run(Application.class, args);
	}

	// @Override
  	// public void run(String... args) throws Exception {

  	// }
}
