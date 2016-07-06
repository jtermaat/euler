package com.euler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EulerSpringApplication {
	
	public static String URL = "http://localhost:8080/messages";

	public static void main(String[] args) {
		SpringApplication.run(EulerSpringApplication.class, args);
	}
}
