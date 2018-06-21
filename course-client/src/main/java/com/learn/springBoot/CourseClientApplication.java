package com.learn.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.learn.springBoot.client") // to make sure the spring can scan the classes in that package
public class CourseClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseClientApplication.class, args);
	}
}
