package com.aftercare.aftercareapi.controller;

import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Services.AddPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AddPatientService addPatientService;

    @PostMapping(value = "api/patients/register")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {

        System.out.println(patient);
        return new ResponseEntity<Patient>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/patients")
    public List<Patient> getPatientList() {

        return addPatientService.getPatients();
    }

    @GetMapping(value = "/patient/{patientId}")
    public Patient getPatient(@PathVariable Integer patientId) {


        return addPatientService.getPatientById(patientId);
    }
}

