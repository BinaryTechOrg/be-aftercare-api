package com.aftercare.aftercareapi.controller;


import com.aftercare.aftercareapi.Models.PatientDTO;
import com.aftercare.aftercareapi.Services.AddPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class UserController {

    @Autowired
    private AddPatientService patientService;

    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> addPatient(@RequestBody PatientDTO patientDTO) {
        System.out.println(patientDTO.toString());
        patientDTO.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        patientService.addPatient(patientDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getPatients() {
        List<PatientDTO> patients = patientService.getPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable int patientId) {
        PatientDTO patient = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
