package com.Adf.LoanSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication()
public class LoanSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanSystemApplication.class, args);
	}

}
