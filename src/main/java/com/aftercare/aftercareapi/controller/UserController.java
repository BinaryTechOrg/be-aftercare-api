package com.aftercare.aftercareapi.controller;

import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Services.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private PatientService patientService;

    @GetMapping(value = "/patients")
    public List<Patient> getPatientList() {
        //patientService

        return new ArrayList<>();
    }

    @GetMapping(value = "/patient/{patientId}")
    public Patient getPatient(@PathVariable Integer patientId) {
        Patient patient = new Patient();
        patient.setName("Peter");
        patient.setId(patientId);

        return patient;
    }
}

