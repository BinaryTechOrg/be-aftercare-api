package com.aftercare.aftercareapi;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AftercareApiApplication {

	@Value("${spring.profiles.active:default}")
	private String activeProfile;

	public static void main(String[] args) {
		SpringApplication.run(AftercareApiApplication.class, args);
	}

	@PostConstruct
	public void logActiveProfile() {
		System.out.println("Active Spring Profile: " + activeProfile);
	}

}
