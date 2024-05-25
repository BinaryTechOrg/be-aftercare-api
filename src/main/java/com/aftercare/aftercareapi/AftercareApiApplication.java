package com.aftercare.aftercareapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AftercareApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AftercareApiApplication.class, args);
	}

}
