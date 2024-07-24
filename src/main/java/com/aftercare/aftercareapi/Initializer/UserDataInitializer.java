package com.aftercare.aftercareapi.Initializer;

import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


public class UserDataInitializer implements InitializingBean {

    private final PatientRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserDataInitializer(PasswordEncoder passwordEncoder, PatientRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createDefaultUser() {
        if (userRepository.findByEmail("admin@example.com") == null) {
            Patient user = Patient.builder()
                    .firstName("Admin")
                    .lastName("User")
                    .email("admin@example.com")
                    .password(passwordEncoder.encode("password")) // Encode password
                    .phone("1234567890")
                    .gender("M")
                    .role("ROLE_ADMIN")
                    .build();
            userRepository.save(user);
            System.out.println("Created default user: admin@example.com");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
