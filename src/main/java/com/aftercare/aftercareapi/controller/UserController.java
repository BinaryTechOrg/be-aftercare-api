package com.aftercare.aftercareapi.controller;

import com.aftercare.aftercareapi.Exceptions.Patients.PatientNotFoundException;
import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Models.PatientDTO;
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
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDTO patientDTO) {
        try {
            addPatientService.addPatient(patientDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error registering patient: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "api/patients")
    public ResponseEntity<List<Patient>> getPatientList() {
        try {
            List<Patient> patients = addPatientService.getPatients();
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception and return an appropriate response
            System.err.println("Error fetching patient list: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "api/patients/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable int patientId) {
        try {
            Patient patient = addPatientService.getPatientById(patientId);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } catch (PatientNotFoundException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.err.println("Error fetching patient: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "api/patients/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId) {

        try {
            addPatientService.deletePatientById(patientId);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (Exception e){
            System.err.println("Error deleting patient: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

